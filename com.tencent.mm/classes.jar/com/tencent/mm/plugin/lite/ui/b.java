package com.tencent.mm.plugin.lite.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wax.c.a;

final class b
  extends FrameLayout
{
  b(Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(212453);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    if (bool) {}
    for (paramMotionEvent = "true";; paramMotionEvent = "false")
    {
      a.i("MicroMsg.LiteApp.WxaLiteAppBaseView", "dispatchTouchEvent action=%d r=%s", new Object[] { Integer.valueOf(i), paramMotionEvent });
      AppMethodBeat.o(212453);
      return bool;
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(212451);
    getParent().requestDisallowInterceptTouchEvent(true);
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    if (bool) {}
    for (paramMotionEvent = "true";; paramMotionEvent = "false")
    {
      a.i("MicroMsg.LiteApp.WxaLiteAppBaseView", "onInterceptTouchEvent action=%d r=%s", new Object[] { Integer.valueOf(i), paramMotionEvent });
      AppMethodBeat.o(212451);
      return bool;
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(212452);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    if (bool) {}
    for (paramMotionEvent = "true";; paramMotionEvent = "false")
    {
      a.i("MicroMsg.LiteApp.WxaLiteAppBaseView", "onTouchEvent action=%d r=%s", new Object[] { Integer.valueOf(i), paramMotionEvent });
      AppMethodBeat.o(212452);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.b
 * JD-Core Version:    0.7.0.1
 */