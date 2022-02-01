package com.tencent.mm.plugin.appbrand.jsapi.handoff;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

final class JsApiStartHandoff$1$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  JsApiStartHandoff$1$1(JsApiStartHandoff.1 param1, TextView paramTextView) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(224366);
    if (this.kRf.getLineCount() > 1) {
      this.kRf.setTextSize(0, a.ax(this.mYd.val$context, 2131165257));
    }
    this.kRf.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    AppMethodBeat.o(224366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.handoff.JsApiStartHandoff.1.1
 * JD-Core Version:    0.7.0.1
 */