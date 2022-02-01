package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.r.a.k;
import com.tencent.mm.r.a.l;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/eggspring/cgi/GetCouponCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/eggspring/model/GetSnsAdCouponCardResp;", "appId", "", "stockId", "uxInfo", "compId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b<l>
{
  public a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(266533);
    k localk = new k();
    localk.appId = paramString1;
    localk.mdN = paramString2;
    localk.uxInfo = paramString3;
    localk.mdO = paramString4;
    paramString1 = new c.a();
    paramString1.otE = ((com.tencent.mm.bx.a)localk);
    paramString1.otF = ((com.tencent.mm.bx.a)new l());
    paramString1.otG = 0;
    paramString1.respCmdId = 0;
    paramString1.uri = "/cgi-bin/mmoc-bin/adplayinfo/send_ad_coupon";
    paramString1.funcId = 4743;
    c(paramString1.bEF());
    AppMethodBeat.o(266533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.b.a
 * JD-Core Version:    0.7.0.1
 */