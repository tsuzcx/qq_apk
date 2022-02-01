package com.tencent.mm.plugin.base.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.ab;
import com.tencent.mm.plugin.appbrand.service.g;
import com.tencent.mm.sdk.platformtools.Log;

final class f$3
  implements z.a
{
  public final int callback(int paramInt1, int paramInt2, String paramString, c paramc, p paramp)
  {
    AppMethodBeat.i(269029);
    Log.i("MicroMsg.WXBizLogic", "doPreloadMiniProgramTranslateLink, %d, %d, %s, cgiType=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(this.vrZ) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      f.C(false, this.vrZ);
      AppMethodBeat.o(269029);
      return 0;
    }
    f.C(true, this.vrZ);
    if (this.vrZ == 3)
    {
      ((g)h.ax(g.class)).b(ab.tTQ);
      ((g)h.ax(g.class)).c(ab.tTQ);
    }
    AppMethodBeat.o(269029);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.f.3
 * JD-Core Version:    0.7.0.1
 */