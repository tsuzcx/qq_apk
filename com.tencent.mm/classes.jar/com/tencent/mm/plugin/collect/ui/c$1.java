package com.tencent.mm.plugin.collect.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.o;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class c$1
  implements ao.b.a
{
  c$1(c paramc, long paramLong) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(41323);
    if (paramBoolean)
    {
      ab.v("MicroMsg.CollectPayInfoPreference", "getContact suc; cost=" + (bo.aoy() - this.kQi) + " ms");
      b.U(paramString, 3);
      o.adi().qU(paramString);
    }
    for (;;)
    {
      a.b.c(c.a(this.kSP), c.b(this.kSP));
      AppMethodBeat.o(41323);
      return;
      ab.w("MicroMsg.CollectPayInfoPreference", "getContact failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.c.1
 * JD-Core Version:    0.7.0.1
 */