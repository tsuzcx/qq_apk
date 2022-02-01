package com.tencent.mm.cq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.xweb.WebView.PreInitCallback;

final class d$1
  implements WebView.PreInitCallback
{
  d$1(WebView.PreInitCallback paramPreInitCallback) {}
  
  public final void aUA()
  {
    AppMethodBeat.i(152943);
    ac.i("XWebUtil", "onCoreInitFailed");
    yw localyw = new yw();
    localyw.dCN.success = false;
    a.GpY.l(localyw);
    if (this.JIp != null) {
      this.JIp.aUA();
    }
    AppMethodBeat.o(152943);
  }
  
  public final void onCoreInitFinished()
  {
    AppMethodBeat.i(152942);
    ac.i("XWebUtil", "onCoreInitFinished");
    yw localyw = new yw();
    localyw.dCN.success = true;
    a.GpY.l(localyw);
    if (this.JIp != null) {
      this.JIp.onCoreInitFinished();
    }
    AppMethodBeat.o(152942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.cq.d.1
 * JD-Core Version:    0.7.0.1
 */