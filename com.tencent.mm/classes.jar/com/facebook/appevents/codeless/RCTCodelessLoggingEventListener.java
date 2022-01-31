package com.facebook.appevents.codeless;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.FacebookSdk;
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
    AppMethodBeat.i(72074);
    TAG = RCTCodelessLoggingEventListener.class.getCanonicalName();
    AppMethodBeat.o(72074);
  }
  
  public static AutoLoggingOnTouchListener getOnTouchListener(EventBinding paramEventBinding, View paramView1, View paramView2)
  {
    AppMethodBeat.i(72073);
    paramEventBinding = new AutoLoggingOnTouchListener(paramEventBinding, paramView1, paramView2);
    AppMethodBeat.o(72073);
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
      AppMethodBeat.i(72070);
      this.supportCodelessLogging = false;
      if ((paramEventBinding == null) || (paramView1 == null) || (paramView2 == null))
      {
        AppMethodBeat.o(72070);
        return;
      }
      this.existingOnTouchListener = ViewHierarchy.getExistingOnTouchListener(paramView2);
      this.mapping = paramEventBinding;
      this.hostView = new WeakReference(paramView2);
      this.rootView = new WeakReference(paramView1);
      this.supportCodelessLogging = true;
      AppMethodBeat.o(72070);
    }
    
    private void logEvent()
    {
      AppMethodBeat.i(72072);
      String str = this.mapping.getEventName();
      Bundle localBundle = CodelessMatcher.getParameters(this.mapping, (View)this.rootView.get(), (View)this.hostView.get());
      if (localBundle.containsKey("_valueToSum")) {
        localBundle.putDouble("_valueToSum", AppEventUtility.normalizePrice(localBundle.getString("_valueToSum")));
      }
      localBundle.putString("_is_fb_codeless", "1");
      FacebookSdk.getExecutor().execute(new RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener.1(this, str, localBundle));
      AppMethodBeat.o(72072);
    }
    
    public boolean getSupportCodelessLogging()
    {
      return this.supportCodelessLogging;
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(72071);
      if (paramMotionEvent.getAction() == 1) {
        logEvent();
      }
      if ((this.existingOnTouchListener != null) && (this.existingOnTouchListener.onTouch(paramView, paramMotionEvent)))
      {
        AppMethodBeat.o(72071);
        return true;
      }
      AppMethodBeat.o(72071);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.appevents.codeless.RCTCodelessLoggingEventListener
 * JD-Core Version:    0.7.0.1
 */