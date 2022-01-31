package com.tencent.mm.plugin.appbrand;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.d;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.d;

final class x$2
  implements Runnable
{
  x$2(Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(129137);
    al.Nf(-2);
    if (WebView.hasInited())
    {
      this.gRV.run();
      AppMethodBeat.o(129137);
      return;
    }
    ak localak = new ak(Looper.myLooper());
    d.a(WebView.d.BEq, new x.2.1(this, localak));
    AppMethodBeat.o(129137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.x.2
 * JD-Core Version:    0.7.0.1
 */