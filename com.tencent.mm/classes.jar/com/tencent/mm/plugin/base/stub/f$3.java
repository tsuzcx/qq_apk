package com.tencent.mm.plugin.base.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.sdk.platformtools.Log;

final class f$3
  implements aa.a
{
  public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
  {
    AppMethodBeat.i(231612);
    Log.i("MicroMsg.WXBizLogic", "doPreloadMiniProgramTranslateLink, %d, %d, %s, cgiType=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(this.pee) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      f.z(false, this.pee);
      AppMethodBeat.o(231612);
      return 0;
    }
    f.z(true, this.pee);
    if (this.pee == 3)
    {
      ((com.tencent.mm.plugin.appbrand.service.f)g.af(com.tencent.mm.plugin.appbrand.service.f.class)).b(z.nMH);
      ((com.tencent.mm.plugin.appbrand.service.f)g.af(com.tencent.mm.plugin.appbrand.service.f.class)).c(z.nMH);
    }
    AppMethodBeat.o(231612);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.f.3
 * JD-Core Version:    0.7.0.1
 */