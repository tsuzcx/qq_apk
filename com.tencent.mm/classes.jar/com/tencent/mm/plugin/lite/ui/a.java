package com.tencent.mm.plugin.lite.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
  extends FrameLayout
{
  a(Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198938);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    if (bool) {}
    for (paramMotionEvent = "true";; paramMotionEvent = "false")
    {
      com.tencent.wxa.c.a.i("MicroMsg.LiteApp.WxaLiteAppBaseView", "dispatchTouchEvent action=%d r=%s", new Object[] { Integer.valueOf(i), paramMotionEvent });
      AppMethodBeat.o(198938);
      return bool;
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198936);
    getParent().requestDisallowInterceptTouchEvent(true);
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    if (bool) {}
    for (paramMotionEvent = "true";; paramMotionEvent = "false")
    {
      com.tencent.wxa.c.a.i("MicroMsg.LiteApp.WxaLiteAppBaseView", "onInterceptTouchEvent action=%d r=%s", new Object[] { Integer.valueOf(i), paramMotionEvent });
      AppMethodBeat.o(198936);
      return bool;
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198937);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    if (bool) {}
    for (paramMotionEvent = "true";; paramMotionEvent = "false")
    {
      com.tencent.wxa.c.a.i("MicroMsg.LiteApp.WxaLiteAppBaseView", "onTouchEvent action=%d r=%s", new Object[] { Integer.valueOf(i), paramMotionEvent });
      AppMethodBeat.o(198937);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.a
 * JD-Core Version:    0.7.0.1
 */