package com.facebook.appevents.codeless;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

public class RCTCodelessLoggingEventListener
{
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(17510);
    TAG = RCTCodelessLoggingEventListener.class.getCanonicalName();
    AppMethodBeat.o(17510);
  }
  
  public static AutoLoggingOnTouchListener getOnTouchListener(EventBinding paramEventBinding, View paramView1, View paramView2)
  {
    AppMethodBeat.i(17509);
    paramEventBinding = new AutoLoggingOnTouchListener(paramEventBinding, paramView1, paramView2);
    AppMethodBeat.o(17509);
    return paramEventBinding;
  }
  
  public static class AutoLoggingOnTouchListener
    implements View.OnTouchListener
  {
    private View.OnTouchListener existingOnTouchListener;
    private WeakReference<View> hostView;
    private EventBinding mapping;
    private WeakReference<View> rootView;
    private boolean supportCodelessLogging;
    
    public AutoLoggingOnTouchListener(EventBinding paramEventBinding, View paramView1, View paramView2)
    {
      AppMethodBeat.i(17506);
      this.supportCodelessLogging = false;
      if ((paramEventBinding == null) || (paramView1 == null) || (paramView2 == null))
      {
        AppMethodBeat.o(17506);
        return;
      }
      this.existingOnTouchListener = ViewHierarchy.getExistingOnTouchListener(paramView2);
      this.mapping = paramEventBinding;
      this.hostView = new WeakReference(paramView2);
      this.rootView = new WeakReference(paramView1);
      this.supportCodelessLogging = true;
      AppMethodBeat.o(17506);
    }
    
    private void logEvent()
    {
      AppMethodBeat.i(17508);
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
          AppMethodBeat.i(17505);
          AppEventsLogger.newLogger(FacebookSdk.getApplicationContext()).logEvent(str, localBundle);
          AppMethodBeat.o(17505);
        }
      });
      AppMethodBeat.o(17508);
    }
    
    public boolean getSupportCodelessLogging()
    {
      return this.supportCodelessLogging;
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(17507);
      if (paramMotionEvent.getAction() == 1) {
        logEvent();
      }
      if ((this.existingOnTouchListener != null) && (this.existingOnTouchListener.onTouch(paramView, paramMotionEvent)))
      {
        AppMethodBeat.o(17507);
        return true;
      }
      AppMethodBeat.o(17507);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.appevents.codeless.RCTCodelessLoggingEventListener
 * JD-Core Version:    0.7.0.1
 */