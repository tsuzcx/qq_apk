package com.tencent.mm.plugin.brandservice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.nc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.sortview.a;

final class f$1
  implements c.b
{
  f$1(f paramf) {}
  
  public final void a(c paramc, a parama, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(14031);
    nc localnc = this.jUP.rY(paramInt3);
    parama = new StringBuilder().append(bo.nullAsNil(this.jUP.jTm)).append(",").append(paramInt1).append(",").append(bo.nullAsNil(paramString)).append(",").append(paramInt2).append(",").append(paramc.jTu).append(",");
    if (localnc == null) {}
    for (paramc = "";; paramc = localnc.wBZ + ",0")
    {
      paramc = paramc;
      h.qsU.kvStat(10866, paramc);
      ab.d("MicroMsg.SearchOrRecommendBizAdapter", "report : ".concat(String.valueOf(paramc)));
      AppMethodBeat.o(14031);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.f.1
 * JD-Core Version:    0.7.0.1
 */