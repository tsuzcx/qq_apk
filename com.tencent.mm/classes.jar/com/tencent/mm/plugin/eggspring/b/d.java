package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.t.a.n;
import com.tencent.mm.t.a.o;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/eggspring/cgi/GetMoneyCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/eggspring/model/OpenMoneyResp;", "uxInfo", "", "source", "", "materialId", "", "traceId", "(Ljava/lang/String;IJLjava/lang/String;)V", "plugin-eggspring_release"})
public final class d
  extends c<o>
{
  public d(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(194567);
    n localn = new n();
    localn.gTk = paramString1;
    localn.source = 1;
    localn.gTC = paramLong;
    localn.gTl = paramString2;
    paramString1 = new d.a();
    paramString1.c((a)localn);
    paramString1.d((a)new o());
    paramString1.sI(0);
    paramString1.sJ(0);
    paramString1.sG(4919);
    paramString1.MB("/cgi-bin/mmoc-bin/interaction/open_money ");
    c(paramString1.aXF());
    AppMethodBeat.o(194567);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.b.d
 * JD-Core Version:    0.7.0.1
 */