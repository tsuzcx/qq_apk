package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.t.a.r;
import com.tencent.mm.t.a.s;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/eggspring/cgi/GetMoneyCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/eggspring/model/OpenMoneyResp;", "uxInfo", "", "source", "", "materialId", "", "traceId", "(Ljava/lang/String;IJLjava/lang/String;)V", "plugin-eggspring_release"})
public final class e
  extends c<s>
{
  public e(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(249522);
    r localr = new r();
    localr.jDL = paramString1;
    localr.source = 1;
    localr.jEe = paramLong;
    localr.jDM = paramString2;
    paramString1 = new d.a();
    paramString1.c((a)localr);
    paramString1.d((a)new s());
    paramString1.vF(0);
    paramString1.vG(0);
    paramString1.vD(4919);
    paramString1.TW("/cgi-bin/mmoc-bin/interaction/open_money ");
    c(paramString1.bgN());
    AppMethodBeat.o(249522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.b.e
 * JD-Core Version:    0.7.0.1
 */