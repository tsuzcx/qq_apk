package com.tencent.mm.plugin.brandservice.ui;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bof;
import com.tencent.mm.protocal.c.kp;
import com.tencent.mm.protocal.c.kq;
import com.tencent.mm.protocal.c.kw;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.sortview.a;

final class BizSearchDetailPageUI$3
  implements c.b
{
  BizSearchDetailPageUI$3(BizSearchDetailPageUI paramBizSearchDetailPageUI) {}
  
  public final void a(c paramc, a parama, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if ((BizSearchDetailPageUI.e(this.icA) == 1) && (parama.type == 5))
    {
      parama = (kw)parama.data;
      if ((parama.sFU == null) || (parama.sFU.sFA == null)) {
        y.e("MicroMsg.BrandService.BizSearchDetailPageUI", "bcdItem.ContactItem == null || bcdItem.ContactItem.ContactItem == null");
      }
    }
    else
    {
      return;
    }
    kq localkq = paramc.os(paramInt3);
    StringBuilder localStringBuilder = new StringBuilder().append(bk.pm(BizSearchDetailPageUI.a(this.icA))).append(",").append(paramInt1).append(",").append(bk.pm(paramString)).append(",").append(paramInt2).append(",").append(paramc.icF).append(",");
    if (localkq == null) {}
    for (paramc = "";; paramc = localkq.sFF + ",1")
    {
      paramc = paramc;
      h.nFQ.aC(10866, paramc);
      y.d("MicroMsg.BrandService.BizSearchDetailPageUI", "report : " + paramc);
      if ((parama.sFU.sFA.tpg & 0x8) <= 0) {
        break;
      }
      h.nFQ.aC(10298, paramString + ",35");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI.3
 * JD-Core Version:    0.7.0.1
 */