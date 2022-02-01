package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.t.a.g;
import com.tencent.mm.t.a.h;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/eggspring/cgi/GetCouponCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/eggspring/model/GetSnsAdCouponCardResp;", "appId", "", "stockId", "uxInfo", "compId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "plugin-eggspring_release"})
public final class a
  extends c<h>
{
  public a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(194564);
    g localg = new g();
    localg.appId = paramString1;
    localg.gTp = paramString2;
    localg.uxInfo = paramString3;
    localg.gTq = paramString4;
    paramString1 = new d.a();
    paramString1.c((com.tencent.mm.bw.a)localg);
    paramString1.d((com.tencent.mm.bw.a)new h());
    paramString1.sI(0);
    paramString1.sJ(0);
    paramString1.MB("/cgi-bin/mmoc-bin/adplayinfo/send_ad_coupon");
    paramString1.sG(4743);
    c(paramString1.aXF());
    AppMethodBeat.o(194564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.b.a
 * JD-Core Version:    0.7.0.1
 */