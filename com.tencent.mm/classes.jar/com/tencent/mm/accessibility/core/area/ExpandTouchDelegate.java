package com.tencent.mm.accessibility.core.area;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.ViewTag;
import com.tencent.mm.accessibility.core.ViewTagManager;
import com.tencent.mm.accessibility.uitl.IdUtil;
import com.tencent.mm.accessibility.uitl.TimeBlocker;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/area/ExpandTouchDelegate;", "Landroid/view/TouchDelegate;", "parentView", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "lastEventCode", "", "Ljava/lang/Integer;", "mDelegateTargeted", "", "mTargetedRect", "Landroid/graphics/Rect;", "mTargetedView", "Landroid/view/View;", "viewRectMap", "", "Ljava/lang/ref/WeakReference;", "addDelegateChild", "", "view", "rect", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onTouchExplorationHoverEvent", "putRect", "rectKey", "reset", "Companion", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ExpandTouchDelegate
  extends TouchDelegate
{
  public static final Companion Companion;
  public static final String TAG = "MicroMsg.Acc.ExpandTouchDelegate";
  private static Method getListenerInfoMethod;
  private static final ExpandTouchDelegate.Companion.layoutChangeListener.1 layoutChangeListener;
  private static Field mOnTouchListenerField;
  private static boolean successReflect;
  private static boolean tryReflect;
  private Integer lastEventCode;
  private boolean mDelegateTargeted;
  private Rect mTargetedRect;
  private View mTargetedView;
  private final ViewGroup parentView;
  private final Map<WeakReference<View>, Rect> viewRectMap;
  
  static
  {
    AppMethodBeat.i(234440);
    Companion = new Companion(null);
    layoutChangeListener = new ExpandTouchDelegate.Companion.layoutChangeListener.1();
    AppMethodBeat.o(234440);
  }
  
  public ExpandTouchDelegate(ViewGroup paramViewGroup)
  {
    super(localRect, (View)paramViewGroup);
    this.parentView = paramViewGroup;
    this.viewRectMap = ((Map)new LinkedHashMap());
    AppMethodBeat.o(234361);
  }
  
  /* Error */
  private final void putRect(View paramView, Rect paramRect)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 151
    //   4: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 124	com/tencent/mm/accessibility/core/area/ExpandTouchDelegate:viewRectMap	Ljava/util/Map;
    //   11: invokeinterface 155 1 0
    //   16: invokeinterface 161 1 0
    //   21: astore 4
    //   23: aload 4
    //   25: invokeinterface 166 1 0
    //   30: ifeq +74 -> 104
    //   33: aload 4
    //   35: invokeinterface 170 1 0
    //   40: checkcast 172	java/lang/ref/WeakReference
    //   43: astore 5
    //   45: aload 5
    //   47: invokevirtual 175	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   50: checkcast 112	android/view/View
    //   53: astore 6
    //   55: aload 6
    //   57: ifnull +42 -> 99
    //   60: aload 6
    //   62: invokevirtual 179	android/view/View:hashCode	()I
    //   65: aload_1
    //   66: invokevirtual 179	android/view/View:hashCode	()I
    //   69: if_icmpne +30 -> 99
    //   72: iconst_1
    //   73: istore_3
    //   74: iload_3
    //   75: ifeq -52 -> 23
    //   78: aload_0
    //   79: getfield 124	com/tencent/mm/accessibility/core/area/ExpandTouchDelegate:viewRectMap	Ljava/util/Map;
    //   82: aload 5
    //   84: aload_2
    //   85: invokeinterface 183 3 0
    //   90: pop
    //   91: ldc 151
    //   93: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_0
    //   97: monitorexit
    //   98: return
    //   99: iconst_0
    //   100: istore_3
    //   101: goto -27 -> 74
    //   104: aload_0
    //   105: getfield 124	com/tencent/mm/accessibility/core/area/ExpandTouchDelegate:viewRectMap	Ljava/util/Map;
    //   108: new 172	java/lang/ref/WeakReference
    //   111: dup
    //   112: aload_1
    //   113: invokespecial 186	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   116: aload_2
    //   117: invokeinterface 183 3 0
    //   122: pop
    //   123: ldc 151
    //   125: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: goto -32 -> 96
    //   131: astore_1
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_1
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	ExpandTouchDelegate
    //   0	136	1	paramView	View
    //   0	136	2	paramRect	Rect
    //   73	28	3	i	int
    //   21	13	4	localIterator	Iterator
    //   43	40	5	localWeakReference	WeakReference
    //   53	8	6	localView	View
    // Exception table:
    //   from	to	target	type
    //   2	23	131	finally
    //   23	55	131	finally
    //   60	72	131	finally
    //   78	96	131	finally
    //   104	128	131	finally
  }
  
  private final void reset()
  {
    this.mTargetedRect = null;
    this.mTargetedView = null;
    this.mDelegateTargeted = false;
  }
  
  public final void addDelegateChild(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(234441);
    s.u(paramView, "view");
    s.u(paramRect, "rect");
    putRect(paramView, new Rect(paramRect));
    AppMethodBeat.o(234441);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    AppMethodBeat.i(234447);
    s.u(paramMotionEvent, "event");
    int i = paramMotionEvent.hashCode();
    Object localObject1 = this.lastEventCode;
    int j;
    int k;
    boolean bool1;
    if (localObject1 == null)
    {
      this.lastEventCode = Integer.valueOf(paramMotionEvent.hashCode());
      j = (int)paramMotionEvent.getX();
      k = (int)paramMotionEvent.getY();
      switch (paramMotionEvent.getActionMasked())
      {
      case 4: 
      default: 
        bool1 = false;
      }
    }
    for (;;)
    {
      localObject1 = this.mTargetedView;
      Object localObject2 = this.mTargetedRect;
      boolean bool2 = bool3;
      if (bool1)
      {
        bool2 = bool3;
        if (localObject1 != null)
        {
          bool2 = bool3;
          if (localObject2 != null)
          {
            paramMotionEvent.setLocation(((View)localObject1).getWidth() / 2.0F, ((View)localObject1).getHeight() / 2.0F);
            bool2 = ((View)localObject1).dispatchTouchEvent(paramMotionEvent);
          }
        }
      }
      this.lastEventCode = null;
      if (3 == paramMotionEvent.getActionMasked()) {
        reset();
      }
      AppMethodBeat.o(234447);
      return bool2;
      if (i != ((Integer)localObject1).intValue()) {
        break;
      }
      AppMethodBeat.o(234447);
      return false;
      localObject1 = ((Iterable)this.viewRectMap.entrySet()).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (((Rect)((Map.Entry)localObject2).getValue()).contains(j, k))
        {
          Object localObject3 = (View)((WeakReference)((Map.Entry)localObject2).getKey()).get();
          if (localObject3 == null)
          {
            AppMethodBeat.o(234447);
            return false;
          }
          if ((((View)localObject3).getVisibility() == 0) && (((View)localObject3).isShown()))
          {
            localObject3 = new StringBuilder("hit view ");
            IdUtil localIdUtil = IdUtil.INSTANCE;
            View localView = (View)((WeakReference)((Map.Entry)localObject2).getKey()).get();
            if (localView == null) {}
            for (i = 0;; i = localView.getId())
            {
              Log.d("MicroMsg.Acc.ExpandTouchDelegate", localIdUtil.getName(i) + " in parent " + IdUtil.INSTANCE.getName(this.parentView.getId()) + ", parent isClickable:" + this.parentView.isClickable() + ", isLongClickable: " + this.parentView.isLongClickable());
              this.mTargetedRect = ((Rect)((Map.Entry)localObject2).getValue());
              this.mTargetedView = ((View)((WeakReference)((Map.Entry)localObject2).getKey()).get());
              this.mDelegateTargeted = true;
              i = 1;
              break;
            }
          }
        }
      }
      if (i == 0) {
        reset();
      }
      bool1 = this.mDelegateTargeted;
      continue;
      bool1 = this.mDelegateTargeted;
      continue;
      bool1 = this.mDelegateTargeted;
    }
  }
  
  public final boolean onTouchExplorationHoverEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(234449);
    s.u(paramMotionEvent, "event");
    AppMethodBeat.o(234449);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/area/ExpandTouchDelegate$Companion;", "", "()V", "TAG", "", "getListenerInfoMethod", "Ljava/lang/reflect/Method;", "layoutChangeListener", "com/tencent/mm/accessibility/core/area/ExpandTouchDelegate$Companion$layoutChangeListener$1", "Lcom/tencent/mm/accessibility/core/area/ExpandTouchDelegate$Companion$layoutChangeListener$1;", "mOnTouchListenerField", "Ljava/lang/reflect/Field;", "successReflect", "", "tryReflect", "checkHasTouchListener", "view", "Landroid/view/View;", "expand", "", "eLeft", "", "eTop", "eRight", "eBottom", "findLargeParentPath", "Landroid/view/ViewGroup;", "outRectInParent", "Landroid/graphics/Rect;", "getParentCached", "isOutBound", "parent", "rectInParent", "saveParent", "setDelegate", "v", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion
  {
    private final boolean checkHasTouchListener(View paramView)
    {
      AppMethodBeat.i(234354);
      if (paramView == null)
      {
        AppMethodBeat.o(234354);
        return false;
      }
      if ((ExpandTouchDelegate.access$getTryReflect$cp()) && (!ExpandTouchDelegate.access$getSuccessReflect$cp()))
      {
        AppMethodBeat.o(234354);
        return false;
      }
      if (!ExpandTouchDelegate.access$getTryReflect$cp()) {}
      try
      {
        ExpandTouchDelegate.access$setGetListenerInfoMethod$cp(View.class.getDeclaredMethod("getListenerInfo", new Class[0]));
        localObject = ExpandTouchDelegate.access$getGetListenerInfoMethod$cp();
        if (localObject != null) {
          ((Method)localObject).setAccessible(true);
        }
        ExpandTouchDelegate.access$setMOnTouchListenerField$cp(Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener"));
        localObject = ExpandTouchDelegate.access$getMOnTouchListenerField$cp();
        if (localObject != null) {
          ((Field)localObject).setAccessible(true);
        }
        ExpandTouchDelegate.access$setSuccessReflect$cp(true);
      }
      finally
      {
        for (;;)
        {
          try
          {
            Object localObject = ExpandTouchDelegate.access$getMOnTouchListenerField$cp();
            Method localMethod = ExpandTouchDelegate.access$getGetListenerInfoMethod$cp();
            if ((localObject == null) || (localMethod == null) || (((Field)localObject).get(localMethod.invoke(paramView, new Object[0])) == null)) {
              break label223;
            }
            Log.d("MicroMsg.Acc.ExpandTouchDelegate", "checkHasTouchListener return true with view(" + IdUtil.INSTANCE.getName(paramView.getId()) + ')');
            AppMethodBeat.o(234354);
            return true;
          }
          finally
          {
            Log.printErrStackTrace("MicroMsg.Acc.ExpandTouchDelegate", paramView, "successReflect but invoke error in checkHasTouchListener", new Object[0]);
          }
          localThrowable = finally;
          Log.printErrStackTrace("MicroMsg.Acc.ExpandTouchDelegate", localThrowable, "tryReflect error in checkHasTouchListener", new Object[0]);
        }
        AppMethodBeat.o(234354);
      }
      ExpandTouchDelegate.access$setTryReflect$cp(true);
      if ((ExpandTouchDelegate.access$getSuccessReflect$cp()) && (ExpandTouchDelegate.access$getGetListenerInfoMethod$cp() != null) && (ExpandTouchDelegate.access$getMOnTouchListenerField$cp() != null)) {}
      label223:
      return false;
    }
    
    private final ViewGroup getParentCached(View paramView)
    {
      AppMethodBeat.i(234363);
      paramView = ViewTagManager.INSTANCE.getTagData(paramView);
      if (paramView == null)
      {
        paramView = null;
        if (!(paramView instanceof WeakReference)) {
          break label62;
        }
      }
      for (;;)
      {
        if (paramView != null)
        {
          paramView = paramView.get();
          if ((paramView instanceof ViewGroup))
          {
            paramView = (ViewGroup)paramView;
            AppMethodBeat.o(234363);
            return paramView;
            paramView = paramView.getTouchDelegateParent();
            break;
            label62:
            paramView = null;
            continue;
          }
          AppMethodBeat.o(234363);
          return null;
        }
      }
      AppMethodBeat.o(234363);
      return null;
    }
    
    private final boolean isOutBound(ViewGroup paramViewGroup, Rect paramRect)
    {
      AppMethodBeat.i(234339);
      if ((paramViewGroup.getHeight() < paramRect.bottom) || (paramViewGroup.getWidth() < paramRect.right) || (paramRect.top < 0) || (paramRect.left < 0))
      {
        AppMethodBeat.o(234339);
        return true;
      }
      AppMethodBeat.o(234339);
      return false;
    }
    
    private final void saveParent(View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(234369);
      ViewTag localViewTag = ViewTagManager.INSTANCE.getTagData(paramView);
      if (localViewTag != null) {
        if (paramViewGroup == null) {
          break label41;
        }
      }
      label41:
      for (paramView = new WeakReference(paramViewGroup);; paramView = null)
      {
        localViewTag.setTouchDelegateParent(paramView);
        AppMethodBeat.o(234369);
        return;
      }
    }
    
    private final void setDelegate(View paramView)
    {
      AppMethodBeat.i(234331);
      Object localObject = ViewTagManager.INSTANCE.getTagData(paramView);
      if (localObject != null)
      {
        Integer localInteger1 = ((ViewTag)localObject).getELeft();
        Integer localInteger2 = ((ViewTag)localObject).getETop();
        Integer localInteger3 = ((ViewTag)localObject).getERight();
        localObject = ((ViewTag)localObject).getEBottom();
        if ((localInteger1 != null) && (localInteger2 != null) && (localInteger3 != null) && (localObject != null))
        {
          int i = ((Number)localObject).intValue();
          int j = ((Number)localInteger3).intValue();
          int k = ((Number)localInteger2).intValue();
          int m = ((Number)localInteger1).intValue();
          ExpandTouchDelegate.Companion.setDelegate(paramView, m, k, j, i);
        }
      }
      AppMethodBeat.o(234331);
    }
    
    public final void expand(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(234390);
      s.u(paramView, "view");
      ViewTag localViewTag = ViewTagManager.INSTANCE.getTagData(paramView);
      if (localViewTag != null)
      {
        localViewTag.setELeft(Integer.valueOf(paramInt1));
        localViewTag.setETop(Integer.valueOf(paramInt2));
        localViewTag.setERight(Integer.valueOf(paramInt3));
        localViewTag.setEBottom(Integer.valueOf(paramInt4));
      }
      TimeBlocker.INSTANCE.pendingExcu(paramView, "addOnLayoutChangeListener", (a)new u(paramView)
      {
        public final void invoke()
        {
          AppMethodBeat.i(234326);
          this.$view.addOnLayoutChangeListener((View.OnLayoutChangeListener)ExpandTouchDelegate.access$getLayoutChangeListener$cp());
          AppMethodBeat.o(234326);
        }
      });
      setDelegate(paramView);
      AppMethodBeat.o(234390);
    }
    
    public final ViewGroup findLargeParentPath(View paramView, Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(234407);
      s.u(paramView, "view");
      s.u(paramRect, "outRectInParent");
      Object localObject1 = paramView.getParent();
      if ((localObject1 instanceof ViewGroup)) {}
      for (localObject1 = (ViewGroup)localObject1; localObject1 == null; localObject1 = null)
      {
        AppMethodBeat.o(234407);
        return null;
      }
      paramView.getHitRect(paramRect);
      paramRect.left -= paramInt1;
      paramRect.top -= paramInt2;
      paramRect.right += paramInt3;
      paramRect.bottom += paramInt4;
      Object localObject4 = getParentCached(paramView);
      Object localObject2 = localObject1;
      Object localObject3;
      if (localObject4 != null) {
        try
        {
          ((ViewGroup)localObject4).offsetDescendantRectToMyCoords((View)localObject1, paramRect);
          AppMethodBeat.o(234407);
          return localObject4;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          Log.e("MicroMsg.Acc.ExpandTouchDelegate", s.X("getParentCached: throw ", localIllegalArgumentException.getMessage()));
          ExpandTouchDelegate.Companion.saveParent(paramView, null);
          localObject3 = localObject1;
        }
      }
      for (;;)
      {
        if (localObject3 != null)
        {
          if ((!isOutBound(localObject3, paramRect)) || (localObject3.isClickable()) || (localObject3.isLongClickable()) || (checkHasTouchListener((View)localObject3)))
          {
            saveParent(paramView, localObject3);
            AppMethodBeat.o(234407);
            return localObject3;
          }
          if ((localObject3.getParent() instanceof ViewGroup))
          {
            localObject4 = (View)localObject3;
            localObject1 = localObject3.getParent();
            if ((localObject1 instanceof ViewGroup)) {}
            for (localObject1 = (ViewGroup)localObject1;; localObject1 = null) {
              for (;;)
              {
                if (localObject1 == null) {
                  break label339;
                }
                try
                {
                  ((ViewGroup)localObject1).offsetDescendantRectToMyCoords((View)localObject4, paramRect);
                  localObject3 = localObject1;
                }
                catch (IllegalArgumentException paramView)
                {
                  Log.e("MicroMsg.Acc.ExpandTouchDelegate", s.X("findLargeParentPath: throw ", paramView.getMessage()));
                  AppMethodBeat.o(234407);
                  return null;
                }
              }
            }
          }
          AppMethodBeat.o(234407);
          return null;
        }
        AppMethodBeat.o(234407);
        return null;
        label339:
        localObject3 = localObject1;
      }
    }
    
    public final void setDelegate(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(234398);
      s.u(paramView, "v");
      Rect localRect = new Rect();
      ViewGroup localViewGroup = findLargeParentPath(paramView, localRect, paramInt1, paramInt2, paramInt3, paramInt4);
      if (localViewGroup == null)
      {
        localObject = null;
        if (localObject == null) {
          Log.e("MicroMsg.Acc.ExpandTouchDelegate", s.X("expand parent null? ", IdUtil.INSTANCE.getName(paramView.getId())));
        }
        AppMethodBeat.o(234398);
        return;
      }
      Object localObject = localViewGroup.getTouchDelegate();
      if ((localObject instanceof ExpandTouchDelegate))
      {
        localObject = (ExpandTouchDelegate)localObject;
        label100:
        if (localObject != null) {
          break label213;
        }
        localObject = ExpandTouchDelegate.Companion;
        localViewGroup.setTouchDelegate((TouchDelegate)new ExpandTouchDelegate(localViewGroup));
        localObject = localViewGroup.getTouchDelegate();
        if (!(localObject instanceof ExpandTouchDelegate)) {
          break label207;
        }
        localObject = (ExpandTouchDelegate)localObject;
        label149:
        if (localObject != null) {
          ((ExpandTouchDelegate)localObject).addDelegateChild(paramView, localRect);
        }
      }
      for (;;)
      {
        localObject = ViewTagManager.INSTANCE.getTagData(paramView);
        if (localObject != null) {
          ((ViewTag)localObject).setTouchDelegate(new WeakReference(localViewGroup.getTouchDelegate()));
        }
        localObject = ah.aiuX;
        break;
        localObject = null;
        break label100;
        label207:
        localObject = null;
        break label149;
        label213:
        ((ExpandTouchDelegate)localObject).addDelegateChild(paramView, localRect);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.core.area.ExpandTouchDelegate
 * JD-Core Version:    0.7.0.1
 */