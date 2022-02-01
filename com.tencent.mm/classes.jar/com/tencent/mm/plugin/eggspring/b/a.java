package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.t.a.k;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/eggspring/cgi/GetCouponCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/eggspring/model/GetSnsAdCouponCardResp;", "appId", "", "stockId", "uxInfo", "compId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "plugin-eggspring_release"})
public final class a
  extends c<com.tencent.mm.t.a.l>
{
  public a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(249388);
    k localk = new k();
    localk.appId = paramString1;
    localk.jDR = paramString2;
    localk.uxInfo = paramString3;
    localk.jDS = paramString4;
    paramString1 = new d.a();
    paramString1.c((com.tencent.mm.cd.a)localk);
    paramString1.d((com.tencent.mm.cd.a)new com.tencent.mm.t.a.l());
    paramString1.vF(0);
    paramString1.vG(0);
    paramString1.TW("/cgi-bin/mmoc-bin/adplayinfo/send_ad_coupon");
    paramString1.vD(4743);
    c(paramString1.bgN());
    AppMethodBeat.o(249388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.b.a
 * JD-Core Version:    0.7.0.1
 */