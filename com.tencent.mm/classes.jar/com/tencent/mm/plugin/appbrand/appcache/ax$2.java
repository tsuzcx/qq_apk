package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.protocal.protobuf.gka;
import com.tencent.mm.protocal.protobuf.gkb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

final class ax$2
  implements z.a
{
  public final int callback(int paramInt1, int paramInt2, String paramString, c paramc, p paramp)
  {
    AppMethodBeat.i(44338);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(368L, 40L, 1L, false);
    if (com.tencent.mm.kernel.h.baz())
    {
      long l = Util.nowSecond();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acNd, Long.valueOf(86400L + l));
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.WxaCommLibVersionChecker", "onResp, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1509, 2);
      AppMethodBeat.o(44338);
      return 0;
    }
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1509, 1);
    try
    {
      ax.b(((gka)c.b.b(paramc.otB)).version, (gkb)c.c.b(paramc.otC), ax.a.qGa);
      AppMethodBeat.o(44338);
      return 0;
    }
    catch (RuntimeException paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.WxaCommLibVersionChecker", "onResp, e %s", new Object[] { paramString });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ax.2
 * JD-Core Version:    0.7.0.1
 */