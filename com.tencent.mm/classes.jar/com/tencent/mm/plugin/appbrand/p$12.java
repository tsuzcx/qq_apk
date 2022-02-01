package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.floatball.c;
import com.tencent.mm.plugin.appbrand.floatball.d;
import com.tencent.mm.plugin.appbrand.floatball.d.2;
import com.tencent.mm.plugin.appbrand.floatball.d.3;
import com.tencent.mm.plugin.appbrand.floatball.g;
import com.tencent.mm.sdk.f.a;
import com.tencent.mm.sdk.platformtools.ae;

final class p$12
  implements Runnable
{
  p$12(p paramp) {}
  
  public final void run()
  {
    boolean bool3 = true;
    AppMethodBeat.i(43873);
    if (p.f(this.jCE) != null)
    {
      d locald = p.f(this.jCE);
      p localp = this.jCE;
      ae.i("MicroMsg.AppBrandFloatBallLogic", "close, runtime:%s", new Object[] { localp.mAppId });
      int i = c.b(h.KU(localp.mAppId));
      boolean bool1;
      boolean bool2;
      if ((locald.kmR != null) && (locald.kmR.bhx()))
      {
        bool1 = true;
        if ((locald.kmS == null) || (!locald.kmS.bhx())) {
          break label179;
        }
        bool2 = true;
        label106:
        ae.i("MicroMsg.AppBrandFloatBallLogic", "close, voip:%s, voip1v1:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if (!bool1) {
          break label184;
        }
        locald.kmR.a(a.jw(localp.mContext), new d.2(locald, i));
        bool1 = bool3;
      }
      for (;;)
      {
        if (!bool1) {
          break label248;
        }
        AppMethodBeat.o(43873);
        return;
        bool1 = false;
        break;
        label179:
        bool2 = false;
        break label106;
        label184:
        if (bool2)
        {
          locald.kmS.a(a.jw(localp.mContext), new d.3(locald, i));
          bool1 = bool3;
        }
        else
        {
          bool1 = locald.sA(i);
          ae.i("MicroMsg.AppBrandFloatBallLogic", "close, result:%s", new Object[] { Boolean.valueOf(bool1) });
        }
      }
    }
    label248:
    this.jCE.aXr();
    AppMethodBeat.o(43873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.12
 * JD-Core Version:    0.7.0.1
 */