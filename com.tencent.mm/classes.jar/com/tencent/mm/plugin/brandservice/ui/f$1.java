package com.tencent.mm.plugin.brandservice.ui;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.kq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.sortview.a;

final class f$1
  implements c.b
{
  f$1(f paramf) {}
  
  public final void a(c paramc, a parama, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    kq localkq = this.ieb.os(paramInt3);
    parama = new StringBuilder().append(bk.pm(this.ieb.icx)).append(",").append(paramInt1).append(",").append(bk.pm(paramString)).append(",").append(paramInt2).append(",").append(paramc.icF).append(",");
    if (localkq == null) {}
    for (paramc = "";; paramc = localkq.sFF + ",0")
    {
      paramc = paramc;
      h.nFQ.aC(10866, paramc);
      y.d("MicroMsg.SearchOrRecommendBizAdapter", "report : " + paramc);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.f.1
 * JD-Core Version:    0.7.0.1
 */