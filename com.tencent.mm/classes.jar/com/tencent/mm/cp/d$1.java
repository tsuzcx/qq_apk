package com.tencent.mm.cp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zz;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.xweb.WebView.PreInitCallback;

final class d$1
  implements WebView.PreInitCallback
{
  d$1(WebView.PreInitCallback paramPreInitCallback) {}
  
  public final void aYf()
  {
    AppMethodBeat.i(152943);
    ae.i("XWebUtil", "onCoreInitFailed");
    zz localzz = new zz();
    localzz.dQy.success = false;
    a.IvT.l(localzz);
    if (this.LZc != null) {
      this.LZc.aYf();
    }
    AppMethodBeat.o(152943);
  }
  
  public final void onCoreInitFinished()
  {
    AppMethodBeat.i(152942);
    ae.i("XWebUtil", "onCoreInitFinished");
    zz localzz = new zz();
    localzz.dQy.success = true;
    a.IvT.l(localzz);
    if (this.LZc != null) {
      this.LZc.onCoreInitFinished();
    }
    AppMethodBeat.o(152942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.cp.d.1
 * JD-Core Version:    0.7.0.1
 */