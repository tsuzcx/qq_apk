package com.tencent.mm.plugin.base.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.sdk.platformtools.ad;

final class f$3
  implements x.a
{
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
  {
    AppMethodBeat.i(193148);
    ad.i("MicroMsg.WXBizLogic", "doPreloadMiniProgramTranslateLink, %d, %d, %s, cgiType=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(this.nNL) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      f.x(false, this.nNL);
      AppMethodBeat.o(193148);
      return 0;
    }
    f.x(true, this.nNL);
    if (this.nNL == 3) {
      ((i)g.ab(i.class)).Lc("");
    }
    AppMethodBeat.o(193148);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.f.3
 * JD-Core Version:    0.7.0.1
 */