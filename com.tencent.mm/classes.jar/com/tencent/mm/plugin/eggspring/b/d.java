package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.r.a.g;
import com.tencent.mm.r.a.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/eggspring/cgi/GetInteractionMaterialCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/eggspring/model/GetInteractionMaterialResp;", "keyword", "", "uxinfo", "source", "", "traceId", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends b<h>
{
  public d(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(266534);
    g localg = new g();
    localg.hAB = paramString1;
    localg.mdG = paramString2;
    localg.source = 0;
    localg.mdH = paramString3;
    paramString1 = new c.a();
    paramString1.otE = ((a)localg);
    paramString1.otF = ((a)new h());
    paramString1.otG = 0;
    paramString1.respCmdId = 0;
    paramString1.uri = "/cgi-bin/mmoc-bin/interaction/get_interaction_material";
    paramString1.funcId = 4310;
    c(paramString1.bEF());
    AppMethodBeat.o(266534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.b.d
 * JD-Core Version:    0.7.0.1
 */