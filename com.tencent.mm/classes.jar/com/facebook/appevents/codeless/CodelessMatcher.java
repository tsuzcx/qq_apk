package com.facebook.appevents.codeless;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ParameterComponent;
import com.facebook.appevents.codeless.internal.PathComponent;
import com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.InternalSettings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CodelessMatcher
{
  private static final String CURRENT_CLASS_NAME = ".";
  private static final String PARENT_CLASS_NAME = "..";
  private static final String TAG;
  private Set<Activity> activitiesSet;
  private HashMap<String, String> delegateMap;
  private final Handler uiThreadHandler;
  private Set<ViewMatcher> viewMatchers;
  
  static
  {
    AppMethodBeat.i(17504);
    TAG = CodelessMatcher.class.getCanonicalName();
    AppMethodBeat.o(17504);
  }
  
  public CodelessMatcher()
  {
    AppMethodBeat.i(17497);
    this.uiThreadHandler = new Handler(Looper.getMainLooper());
    this.activitiesSet = new HashSet();
    this.viewMatchers = new HashSet();
    this.delegateMap = new HashMap();
    AppMethodBeat.o(17497);
  }
  
  public static Bundle getParameters(EventBinding paramEventBinding, View paramView1, View paramView2)
  {
    AppMethodBeat.i(17500);
    Bundle localBundle = new Bundle();
    if (paramEventBinding == null)
    {
      AppMethodBeat.o(17500);
      return localBundle;
    }
    Object localObject1 = paramEventBinding.getViewParameters();
    if (localObject1 != null)
    {
      Iterator localIterator = ((List)localObject1).iterator();
      break label157;
      break label157;
      label45:
      ParameterComponent localParameterComponent;
      do
      {
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label241;
          }
          localParameterComponent = (ParameterComponent)localIterator.next();
          if ((localParameterComponent.value == null) || (localParameterComponent.value.length() <= 0)) {
            break;
          }
          localBundle.putString(localParameterComponent.name, localParameterComponent.value);
        }
      } while (localParameterComponent.path.size() <= 0);
      if (localParameterComponent.pathType.equals("relative")) {}
      for (localObject1 = ViewMatcher.findViewByPath(paramEventBinding, paramView2, localParameterComponent.path, 0, -1, paramView2.getClass().getSimpleName());; localObject1 = ViewMatcher.findViewByPath(paramEventBinding, paramView1, localParameterComponent.path, 0, -1, paramView1.getClass().getSimpleName()))
      {
        localObject1 = ((List)localObject1).iterator();
        label157:
        if (!((Iterator)localObject1).hasNext()) {
          break label45;
        }
        Object localObject2 = (MatchedView)((Iterator)localObject1).next();
        if (((MatchedView)localObject2).getView() == null) {
          break;
        }
        localObject2 = ViewHierarchy.getTextOfView(((MatchedView)localObject2).getView());
        if (((String)localObject2).length() <= 0) {
          break;
        }
        localBundle.putString(localParameterComponent.name, (String)localObject2);
        break label45;
      }
    }
    label241:
    AppMethodBeat.o(17500);
    return localBundle;
  }
  
  private void matchViews()
  {
    AppMethodBeat.i(17502);
    Iterator localIterator = this.activitiesSet.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Activity)localIterator.next();
      Object localObject1 = ((Activity)localObject2).getWindow().getDecorView().getRootView();
      localObject2 = localObject2.getClass().getSimpleName();
      localObject1 = new ViewMatcher((View)localObject1, this.uiThreadHandler, this.delegateMap, (String)localObject2);
      this.viewMatchers.add(localObject1);
    }
    AppMethodBeat.o(17502);
  }
  
  private void startTracking()
  {
    AppMethodBeat.i(17501);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      matchViews();
      AppMethodBeat.o(17501);
      return;
    }
    this.uiThreadHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(17483);
        CodelessMatcher.access$000(CodelessMatcher.this);
        AppMethodBeat.o(17483);
      }
    });
    AppMethodBeat.o(17501);
  }
  
  public void add(Activity paramActivity)
  {
    AppMethodBeat.i(17498);
    if (InternalSettings.isUnityApp())
    {
      AppMethodBeat.o(17498);
      return;
    }
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      paramActivity = new FacebookException("Can't add activity to CodelessMatcher on non-UI thread");
      AppMethodBeat.o(17498);
      throw paramActivity;
    }
    this.activitiesSet.add(paramActivity);
    this.delegateMap.clear();
    startTracking();
    AppMethodBeat.o(17498);
  }
  
  public void remove(Activity paramActivity)
  {
    AppMethodBeat.i(17499);
    if (InternalSettings.isUnityApp())
    {
      AppMethodBeat.o(17499);
      return;
    }
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      paramActivity = new FacebookException("Can't remove activity from CodelessMatcher on non-UI thread");
      AppMethodBeat.o(17499);
      throw paramActivity;
    }
    this.activitiesSet.remove(paramActivity);
    this.viewMatchers.clear();
    this.delegateMap.clear();
    AppMethodBeat.o(17499);
  }
  
  public static class MatchedView
  {
    private WeakReference<View> view;
    private String viewMapKey;
    
    public MatchedView(View paramView, String paramString)
    {
      AppMethodBeat.i(17484);
      this.view = new WeakReference(paramView);
      this.viewMapKey = paramString;
      AppMethodBeat.o(17484);
    }
    
    public View getView()
    {
      AppMethodBeat.i(17485);
      if (this.view == null)
      {
        AppMethodBeat.o(17485);
        return null;
      }
      View localView = (View)this.view.get();
      AppMethodBeat.o(17485);
      return localView;
    }
    
    public String getViewMapKey()
    {
      return this.viewMapKey;
    }
  }
  
  protected static class ViewMatcher
    implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Runnable
  {
    private final String activityName;
    private HashMap<String, String> delegateMap;
    private List<EventBinding> eventBindings;
    private final Handler handler;
    private WeakReference<View> rootView;
    
    public ViewMatcher(View paramView, Handler paramHandler, HashMap<String, String> paramHashMap, String paramString)
    {
      AppMethodBeat.i(17486);
      this.rootView = new WeakReference(paramView);
      this.handler = paramHandler;
      this.delegateMap = paramHashMap;
      this.activityName = paramString;
      this.handler.postDelayed(this, 200L);
      AppMethodBeat.o(17486);
    }
    
    private void attachListener(CodelessMatcher.MatchedView paramMatchedView, View paramView, EventBinding paramEventBinding)
    {
      AppMethodBeat.i(17495);
      if (paramEventBinding == null)
      {
        AppMethodBeat.o(17495);
        return;
      }
      try
      {
        View localView = paramMatchedView.getView();
        if (localView == null)
        {
          AppMethodBeat.o(17495);
          return;
        }
        if (ViewHierarchy.isRCTButton(localView))
        {
          attachRCTListener(paramMatchedView, paramView, paramEventBinding);
          AppMethodBeat.o(17495);
          return;
        }
        paramMatchedView = paramMatchedView.getViewMapKey();
        View.AccessibilityDelegate localAccessibilityDelegate = ViewHierarchy.getExistingDelegate(localView);
        int i;
        int j;
        if (localAccessibilityDelegate != null)
        {
          i = 1;
          if ((i == 0) || (!(localAccessibilityDelegate instanceof CodelessLoggingEventListener.AutoLoggingAccessibilityDelegate))) {
            break label176;
          }
          j = 1;
          label93:
          if ((j == 0) || (!((CodelessLoggingEventListener.AutoLoggingAccessibilityDelegate)localAccessibilityDelegate).getSupportCodelessLogging())) {
            break label182;
          }
        }
        label176:
        label182:
        for (int k = 1;; k = 0)
        {
          if ((!this.delegateMap.containsKey(paramMatchedView)) && ((i == 0) || (j == 0) || (k == 0)))
          {
            localView.setAccessibilityDelegate(CodelessLoggingEventListener.getAccessibilityDelegate(paramEventBinding, paramView, localView));
            this.delegateMap.put(paramMatchedView, paramEventBinding.getEventName());
          }
          AppMethodBeat.o(17495);
          return;
          i = 0;
          break;
          j = 0;
          break label93;
        }
        return;
      }
      catch (FacebookException paramMatchedView)
      {
        AppMethodBeat.o(17495);
      }
    }
    
    private void attachRCTListener(CodelessMatcher.MatchedView paramMatchedView, View paramView, EventBinding paramEventBinding)
    {
      AppMethodBeat.i(17496);
      if (paramEventBinding == null)
      {
        AppMethodBeat.o(17496);
        return;
      }
      View localView = paramMatchedView.getView();
      if ((localView == null) || (!ViewHierarchy.isRCTButton(localView)))
      {
        AppMethodBeat.o(17496);
        return;
      }
      paramMatchedView = paramMatchedView.getViewMapKey();
      View.OnTouchListener localOnTouchListener = ViewHierarchy.getExistingOnTouchListener(localView);
      int i;
      int j;
      if (localOnTouchListener != null)
      {
        i = 1;
        if ((i == 0) || (!(localOnTouchListener instanceof RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener))) {
          break label162;
        }
        j = 1;
        label79:
        if ((j == 0) || (!((RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener)localOnTouchListener).getSupportCodelessLogging())) {
          break label168;
        }
      }
      label162:
      label168:
      for (int k = 1;; k = 0)
      {
        if ((!this.delegateMap.containsKey(paramMatchedView)) && ((i == 0) || (j == 0) || (k == 0)))
        {
          localView.setOnTouchListener(RCTCodelessLoggingEventListener.getOnTouchListener(paramEventBinding, paramView, localView));
          this.delegateMap.put(paramMatchedView, paramEventBinding.getEventName());
        }
        AppMethodBeat.o(17496);
        return;
        i = 0;
        break;
        j = 0;
        break label79;
      }
    }
    
    public static List<CodelessMatcher.MatchedView> findViewByPath(EventBinding paramEventBinding, View paramView, List<PathComponent> paramList, int paramInt1, int paramInt2, String paramString)
    {
      int j = 0;
      int i = 0;
      AppMethodBeat.i(17492);
      paramString = paramString + "." + String.valueOf(paramInt2);
      ArrayList localArrayList = new ArrayList();
      if (paramView == null)
      {
        AppMethodBeat.o(17492);
        return localArrayList;
      }
      if (paramInt1 >= paramList.size()) {
        localArrayList.add(new CodelessMatcher.MatchedView(paramView, paramString));
      }
      while ((paramView instanceof ViewGroup))
      {
        paramView = findVisibleChildren((ViewGroup)paramView);
        j = paramView.size();
        paramInt2 = i;
        while (paramInt2 < j)
        {
          localArrayList.addAll(findViewByPath(paramEventBinding, (View)paramView.get(paramInt2), paramList, paramInt1 + 1, paramInt2, paramString));
          paramInt2 += 1;
        }
        PathComponent localPathComponent = (PathComponent)paramList.get(paramInt1);
        if (localPathComponent.className.equals(".."))
        {
          paramView = paramView.getParent();
          if ((paramView instanceof ViewGroup))
          {
            paramView = findVisibleChildren((ViewGroup)paramView);
            i = paramView.size();
            paramInt2 = j;
            while (paramInt2 < i)
            {
              localArrayList.addAll(findViewByPath(paramEventBinding, (View)paramView.get(paramInt2), paramList, paramInt1 + 1, paramInt2, paramString));
              paramInt2 += 1;
            }
          }
          AppMethodBeat.o(17492);
          return localArrayList;
        }
        if (localPathComponent.className.equals("."))
        {
          localArrayList.add(new CodelessMatcher.MatchedView(paramView, paramString));
          AppMethodBeat.o(17492);
          return localArrayList;
        }
        if (!isTheSameView(paramView, localPathComponent, paramInt2))
        {
          AppMethodBeat.o(17492);
          return localArrayList;
        }
        if (paramInt1 == paramList.size() - 1) {
          localArrayList.add(new CodelessMatcher.MatchedView(paramView, paramString));
        }
      }
      AppMethodBeat.o(17492);
      return localArrayList;
    }
    
    private static List<View> findVisibleChildren(ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(17494);
      ArrayList localArrayList = new ArrayList();
      int j = paramViewGroup.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = paramViewGroup.getChildAt(i);
        if (localView.getVisibility() == 0) {
          localArrayList.add(localView);
        }
        i += 1;
      }
      AppMethodBeat.o(17494);
      return localArrayList;
    }
    
    private static boolean isTheSameView(View paramView, PathComponent paramPathComponent, int paramInt)
    {
      AppMethodBeat.i(17493);
      if ((paramPathComponent.index != -1) && (paramInt != paramPathComponent.index))
      {
        AppMethodBeat.o(17493);
        return false;
      }
      Object localObject;
      if (!paramView.getClass().getCanonicalName().equals(paramPathComponent.className)) {
        if (paramPathComponent.className.matches(".*android\\..*"))
        {
          localObject = paramPathComponent.className.split("\\.");
          if (localObject.length > 0)
          {
            localObject = localObject[(localObject.length - 1)];
            if (!paramView.getClass().getSimpleName().equals(localObject))
            {
              AppMethodBeat.o(17493);
              return false;
            }
          }
          else
          {
            AppMethodBeat.o(17493);
            return false;
          }
        }
        else
        {
          AppMethodBeat.o(17493);
          return false;
        }
      }
      if (((paramPathComponent.matchBitmask & PathComponent.MatchBitmaskType.ID.getValue()) > 0) && (paramPathComponent.id != paramView.getId()))
      {
        AppMethodBeat.o(17493);
        return false;
      }
      if (((paramPathComponent.matchBitmask & PathComponent.MatchBitmaskType.TEXT.getValue()) > 0) && (!paramPathComponent.text.equals(ViewHierarchy.getTextOfView(paramView))))
      {
        AppMethodBeat.o(17493);
        return false;
      }
      if ((paramPathComponent.matchBitmask & PathComponent.MatchBitmaskType.DESCRIPTION.getValue()) > 0)
      {
        String str = paramPathComponent.description;
        if (paramView.getContentDescription() == null) {}
        for (localObject = ""; !str.equals(localObject); localObject = String.valueOf(paramView.getContentDescription()))
        {
          AppMethodBeat.o(17493);
          return false;
        }
      }
      if (((paramPathComponent.matchBitmask & PathComponent.MatchBitmaskType.HINT.getValue()) > 0) && (!paramPathComponent.hint.equals(ViewHierarchy.getHintOfView(paramView))))
      {
        AppMethodBeat.o(17493);
        return false;
      }
      if ((paramPathComponent.matchBitmask & PathComponent.MatchBitmaskType.TAG.getValue()) > 0)
      {
        paramPathComponent = paramPathComponent.tag;
        if (paramView.getTag() == null) {}
        for (paramView = ""; !paramPathComponent.equals(paramView); paramView = String.valueOf(paramView.getTag()))
        {
          AppMethodBeat.o(17493);
          return false;
        }
      }
      AppMethodBeat.o(17493);
      return true;
    }
    
    private void startMatch()
    {
      AppMethodBeat.i(17490);
      if ((this.eventBindings != null) && (this.rootView.get() != null))
      {
        int i = 0;
        while (i < this.eventBindings.size())
        {
          findView((EventBinding)this.eventBindings.get(i), (View)this.rootView.get());
          i += 1;
        }
      }
      AppMethodBeat.o(17490);
    }
    
    public void findView(EventBinding paramEventBinding, View paramView)
    {
      AppMethodBeat.i(17491);
      if ((paramEventBinding == null) || (paramView == null))
      {
        AppMethodBeat.o(17491);
        return;
      }
      if ((!TextUtils.isEmpty(paramEventBinding.getActivityName())) && (!paramEventBinding.getActivityName().equals(this.activityName)))
      {
        AppMethodBeat.o(17491);
        return;
      }
      Object localObject = paramEventBinding.getViewPath();
      if (((List)localObject).size() > 25)
      {
        AppMethodBeat.o(17491);
        return;
      }
      localObject = findViewByPath(paramEventBinding, paramView, (List)localObject, 0, -1, this.activityName).iterator();
      while (((Iterator)localObject).hasNext()) {
        attachListener((CodelessMatcher.MatchedView)((Iterator)localObject).next(), paramView, paramEventBinding);
      }
      AppMethodBeat.o(17491);
    }
    
    public void onGlobalLayout()
    {
      AppMethodBeat.i(17488);
      startMatch();
      AppMethodBeat.o(17488);
    }
    
    public void onScrollChanged()
    {
      AppMethodBeat.i(17489);
      startMatch();
      AppMethodBeat.o(17489);
    }
    
    public void run()
    {
      AppMethodBeat.i(17487);
      Object localObject = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
      if ((localObject == null) || (!((FetchedAppSettings)localObject).getCodelessEventsEnabled()))
      {
        AppMethodBeat.o(17487);
        return;
      }
      this.eventBindings = EventBinding.parseArray(((FetchedAppSettings)localObject).getEventBindings());
      if (this.eventBindings != null)
      {
        localObject = (View)this.rootView.get();
        if (localObject == null)
        {
          AppMethodBeat.o(17487);
          return;
        }
        localObject = ((View)localObject).getViewTreeObserver();
        if (((ViewTreeObserver)localObject).isAlive())
        {
          ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(this);
          ((ViewTreeObserver)localObject).addOnScrollChangedListener(this);
        }
        startMatch();
      }
      AppMethodBeat.o(17487);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.appevents.codeless.CodelessMatcher
 * JD-Core Version:    0.7.0.1
 */