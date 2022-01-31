package com.tencent.mm.plugin.appbrand;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.xweb.WebView.c;

final class x$2$1
  implements WebView.c
{
  x$2$1(x.2 param2, ak paramak) {}
  
  public final void BG()
  {
    AppMethodBeat.i(129136);
    x.access$100();
    Looper.myLooper().quit();
    AppMethodBeat.o(129136);
  }
  
  public final void onCoreInitFinished()
  {
    AppMethodBeat.i(129135);
    this.gRW.post(this.gRX.gRV);
    AppMethodBeat.o(129135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.x.2.1
 * JD-Core Version:    0.7.0.1
 */