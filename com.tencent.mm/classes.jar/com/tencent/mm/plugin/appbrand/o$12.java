package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.floatball.c;
import com.tencent.mm.plugin.appbrand.floatball.d;
import com.tencent.mm.plugin.appbrand.floatball.d.2;
import com.tencent.mm.plugin.appbrand.floatball.d.3;
import com.tencent.mm.plugin.appbrand.floatball.h;
import com.tencent.mm.sdk.f.a;
import com.tencent.mm.sdk.platformtools.ad;

final class o$12
  implements Runnable
{
  o$12(o paramo) {}
  
  public final void run()
  {
    boolean bool3 = true;
    AppMethodBeat.i(43873);
    if (o.f(this.jzB) != null)
    {
      d locald = o.f(this.jzB);
      o localo = this.jzB;
      ad.i("MicroMsg.AppBrandFloatBallLogic", "close, runtime:%s", new Object[] { localo.mAppId });
      int i = c.b(g.Kv(localo.mAppId));
      boolean bool1;
      boolean bool2;
      if ((locald.kjB != null) && (locald.kjB.bgP()))
      {
        bool1 = true;
        if ((locald.kjC == null) || (!locald.kjC.bgP())) {
          break label179;
        }
        bool2 = true;
        label106:
        ad.i("MicroMsg.AppBrandFloatBallLogic", "close, voip:%s, voip1v1:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if (!bool1) {
          break label184;
        }
        locald.kjB.a(a.jq(localo.mContext), new d.2(locald, i));
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
          locald.kjC.a(a.jq(localo.mContext), new d.3(locald, i));
          bool1 = bool3;
        }
        else
        {
          bool1 = locald.sx(i);
          ad.i("MicroMsg.AppBrandFloatBallLogic", "close, result:%s", new Object[] { Boolean.valueOf(bool1) });
        }
      }
    }
    label248:
    this.jzB.aWW();
    AppMethodBeat.o(43873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.12
 * JD-Core Version:    0.7.0.1
 */