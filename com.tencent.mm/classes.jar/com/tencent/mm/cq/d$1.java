package com.tencent.mm.cq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.xweb.WebView.PreInitCallback;

final class d$1
  implements WebView.PreInitCallback
{
  d$1(WebView.PreInitCallback paramPreInitCallback) {}
  
  public final void aXM()
  {
    AppMethodBeat.i(152943);
    ad.i("XWebUtil", "onCoreInitFailed");
    zt localzt = new zt();
    localzt.dPi.success = false;
    a.IbL.l(localzt);
    if (this.LBY != null) {
      this.LBY.aXM();
    }
    AppMethodBeat.o(152943);
  }
  
  public final void onCoreInitFinished()
  {
    AppMethodBeat.i(152942);
    ad.i("XWebUtil", "onCoreInitFinished");
    zt localzt = new zt();
    localzt.dPi.success = true;
    a.IbL.l(localzt);
    if (this.LBY != null) {
      this.LBY.onCoreInitFinished();
    }
    AppMethodBeat.o(152942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.cq.d.1
 * JD-Core Version:    0.7.0.1
 */