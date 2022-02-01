package com.tencent.mm.cr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yl;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.xweb.WebView.PreInitCallback;

final class d$1
  implements WebView.PreInitCallback
{
  d$1(WebView.PreInitCallback paramPreInitCallback) {}
  
  public final void aNK()
  {
    AppMethodBeat.i(152943);
    ad.i("XWebUtil", "onCoreInitFailed");
    yl localyl = new yl();
    localyl.dFa.success = false;
    a.ESL.l(localyl);
    if (this.IgH != null) {
      this.IgH.aNK();
    }
    AppMethodBeat.o(152943);
  }
  
  public final void onCoreInitFinished()
  {
    AppMethodBeat.i(152942);
    ad.i("XWebUtil", "onCoreInitFinished");
    yl localyl = new yl();
    localyl.dFa.success = true;
    a.ESL.l(localyl);
    if (this.IgH != null) {
      this.IgH.onCoreInitFinished();
    }
    AppMethodBeat.o(152942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cr.d.1
 * JD-Core Version:    0.7.0.1
 */