package com.tencent.mm.plugin.base.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.sdk.platformtools.ae;

final class f$3
  implements x.a
{
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
  {
    AppMethodBeat.i(186406);
    ae.i("MicroMsg.WXBizLogic", "doPreloadMiniProgramTranslateLink, %d, %d, %s, cgiType=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(this.nTq) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      f.y(false, this.nTq);
      AppMethodBeat.o(186406);
      return 0;
    }
    f.y(true, this.nTq);
    if (this.nTq == 3) {
      ((i)g.ab(i.class)).LC("");
    }
    AppMethodBeat.o(186406);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.f.3
 * JD-Core Version:    0.7.0.1
 */