package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;

final class e$2
  implements View.OnTouchListener
{
  e$2(e parame, v.b paramb, com.tencent.mm.plugin.appbrand.jsapi.e parame1) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126304);
    boolean bool = "webview".equals(this.hBX.getString("sendTo", null));
    a.a(this.hEL, paramMotionEvent, this.hBX.getString("data", ""), bool);
    AppMethodBeat.o(126304);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.e.2
 * JD-Core Version:    0.7.0.1
 */