package com.tencent.mm.plugin.appbrand.config;

import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.i.a;
import com.tencent.mm.sdk.platformtools.al;

final class o$3
  implements Runnable
{
  o$3(o paramo, i.a parama, String paramString, al paramal) {}
  
  public final void run()
  {
    AppMethodBeat.i(129875);
    if (!g.RJ().QU())
    {
      if (this.hju != null) {
        this.hju.d(null);
      }
      AppMethodBeat.o(129875);
      return;
    }
    if (s.Av(this.efI)) {
      s.a(this.efI, false, new o.3.1(this));
    }
    for (;;)
    {
      Looper.myQueue().addIdleHandler(new o.3.2(this));
      AppMethodBeat.o(129875);
      return;
      if (this.hju != null) {
        this.hju.d(this.hjv.Ae(this.efI));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.o.3
 * JD-Core Version:    0.7.0.1
 */