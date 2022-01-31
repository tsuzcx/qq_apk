package com.tencent.mm.cn;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wm;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView.c;

final class d$1
  implements WebView.c
{
  d$1(WebView.c paramc) {}
  
  public final void BG()
  {
    AppMethodBeat.i(80408);
    ab.i("XWebUtil", "onCoreInitFailed");
    wm localwm = new wm();
    localwm.cOb.success = false;
    a.ymk.l(localwm);
    if (this.AZM != null) {
      this.AZM.BG();
    }
    AppMethodBeat.o(80408);
  }
  
  public final void onCoreInitFinished()
  {
    AppMethodBeat.i(80407);
    ab.i("XWebUtil", "onCoreInitFinished");
    wm localwm = new wm();
    localwm.cOb.success = true;
    a.ymk.l(localwm);
    if (this.AZM != null) {
      this.AZM.onCoreInitFinished();
    }
    AppMethodBeat.o(80407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cn.d.1
 * JD-Core Version:    0.7.0.1
 */