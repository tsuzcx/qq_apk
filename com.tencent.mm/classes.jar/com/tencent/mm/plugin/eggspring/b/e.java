package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.r.a.r;
import com.tencent.mm.r.a.s;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/eggspring/cgi/GetMoneyCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/eggspring/model/OpenMoneyResp;", "uxInfo", "", "source", "", "materialId", "", "traceId", "(Ljava/lang/String;IJLjava/lang/String;)V", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends b<s>
{
  public e(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(266537);
    r localr = new r();
    localr.mdG = paramString1;
    localr.source = 1;
    localr.mea = paramLong;
    localr.mdH = paramString2;
    paramString1 = new c.a();
    paramString1.otE = ((a)localr);
    paramString1.otF = ((a)new s());
    paramString1.otG = 0;
    paramString1.respCmdId = 0;
    paramString1.funcId = 4919;
    paramString1.uri = "/cgi-bin/mmoc-bin/interaction/open_money ";
    c(paramString1.bEF());
    AppMethodBeat.o(266537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.b.e
 * JD-Core Version:    0.7.0.1
 */