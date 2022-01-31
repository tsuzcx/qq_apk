package com.tencent.mm.plugin.brandservice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bya;
import com.tencent.mm.protocal.protobuf.nb;
import com.tencent.mm.protocal.protobuf.nc;
import com.tencent.mm.protocal.protobuf.ni;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.sortview.a;

final class BizSearchDetailPageUI$3
  implements c.b
{
  BizSearchDetailPageUI$3(BizSearchDetailPageUI paramBizSearchDetailPageUI) {}
  
  public final void a(c paramc, a parama, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(13877);
    nc localnc;
    StringBuilder localStringBuilder;
    if ((BizSearchDetailPageUI.e(this.jTp) == 1) && (parama.type == 5))
    {
      parama = (ni)parama.getData();
      if ((parama.wCo == null) || (parama.wCo.wBU == null))
      {
        ab.e("MicroMsg.BrandService.BizSearchDetailPageUI", "bcdItem.ContactItem == null || bcdItem.ContactItem.ContactItem == null");
        AppMethodBeat.o(13877);
        return;
      }
      localnc = paramc.rY(paramInt3);
      localStringBuilder = new StringBuilder().append(bo.nullAsNil(BizSearchDetailPageUI.a(this.jTp))).append(",").append(paramInt1).append(",").append(bo.nullAsNil(paramString)).append(",").append(paramInt2).append(",").append(paramc.jTu).append(",");
      if (localnc != null) {
        break label237;
      }
    }
    label237:
    for (paramc = "";; paramc = localnc.wBZ + ",1")
    {
      paramc = paramc;
      h.qsU.kvStat(10866, paramc);
      ab.d("MicroMsg.BrandService.BizSearchDetailPageUI", "report : ".concat(String.valueOf(paramc)));
      if ((parama.wCo.wBU.xpe & 0x8) > 0) {
        h.qsU.kvStat(10298, paramString + ",35");
      }
      AppMethodBeat.o(13877);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI.3
 * JD-Core Version:    0.7.0.1
 */