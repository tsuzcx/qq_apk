package com.facebook.appevents.codeless;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.EventBinding.ActionType;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

public class CodelessLoggingEventListener
{
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(17482);
    TAG = CodelessLoggingEventListener.class.getCanonicalName();
    AppMethodBeat.o(17482);
  }
  
  public static AutoLoggingAccessibilityDelegate getAccessibilityDelegate(EventBinding paramEventBinding, View paramView1, View paramView2)
  {
    AppMethodBeat.i(17481);
    paramEventBinding = new AutoLoggingAccessibilityDelegate(paramEventBinding, paramView1, paramView2);
    AppMethodBeat.o(17481);
    return paramEventBinding;
  }
  
  public static class AutoLoggingAccessibilityDelegate
    extends View.AccessibilityDelegate
  {
    private int accessibilityEventType;
    private View.AccessibilityDelegate existingDelegate;
    private WeakReference<View> hostView;
    private EventBinding mapping;
    private WeakReference<View> rootView;
    protected boolean supportButtonIndexing;
    private boolean supportCodelessLogging;
    
    public AutoLoggingAccessibilityDelegate()
    {
      this.supportCodelessLogging = false;
      this.supportButtonIndexing = false;
    }
    
    public AutoLoggingAccessibilityDelegate(EventBinding paramEventBinding, View paramView1, View paramView2)
    {
      AppMethodBeat.i(17478);
      this.supportCodelessLogging = false;
      this.supportButtonIndexing = false;
      if ((paramEventBinding == null) || (paramView1 == null) || (paramView2 == null))
      {
        AppMethodBeat.o(17478);
        return;
      }
      this.existingDelegate = ViewHierarchy.getExistingDelegate(paramView2);
      this.mapping = paramEventBinding;
      this.hostView = new WeakReference(paramView2);
      this.rootView = new WeakReference(paramView1);
      paramView1 = paramEventBinding.getType();
      switch (CodelessLoggingEventListener.1.$SwitchMap$com$facebook$appevents$codeless$internal$EventBinding$ActionType[paramEventBinding.getType().ordinal()])
      {
      default: 
        paramEventBinding = new FacebookException("Unsupported action type: " + paramView1.toString());
        AppMethodBeat.o(17478);
        throw paramEventBinding;
      case 1: 
        this.accessibilityEventType = 1;
      }
      for (;;)
      {
        this.supportCodelessLogging = true;
        AppMethodBeat.o(17478);
        return;
        this.accessibilityEventType = 4;
        continue;
        this.accessibilityEventType = 16;
      }
    }
    
    private void logEvent()
    {
      AppMethodBeat.i(17480);
      final String str = this.mapping.getEventName();
      final Bundle localBundle = CodelessMatcher.getParameters(this.mapping, (View)this.rootView.get(), (View)this.hostView.get());
      if (localBundle.containsKey("_valueToSum")) {
        localBundle.putDouble("_valueToSum", AppEventUtility.normalizePrice(localBundle.getString("_valueToSum")));
      }
      localBundle.putString("_is_fb_codeless", "1");
      FacebookSdk.getExecutor().execute(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(17477);
          AppEventsLogger.newLogger(FacebookSdk.getApplicationContext()).logEvent(str, localBundle);
          AppMethodBeat.o(17477);
        }
      });
      AppMethodBeat.o(17480);
    }
    
    public boolean getSupportButtonIndexing()
    {
      return this.supportButtonIndexing;
    }
    
    public boolean getSupportCodelessLogging()
    {
      return this.supportCodelessLogging;
    }
    
    public void sendAccessibilityEvent(View paramView, int paramInt)
    {
      AppMethodBeat.i(17479);
      if ((paramInt != -1) || (paramInt != this.accessibilityEventType))
      {
        AppMethodBeat.o(17479);
        return;
      }
      if ((this.existingDelegate != null) && (!(this.existingDelegate instanceof AutoLoggingAccessibilityDelegate))) {
        this.existingDelegate.sendAccessibilityEvent(paramView, paramInt);
      }
      logEvent();
      AppMethodBeat.o(17479);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.appevents.codeless.CodelessLoggingEventListener
 * JD-Core Version:    0.7.0.1
 */