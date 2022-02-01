package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.t.a.g;
import com.tencent.mm.t.a.h;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/eggspring/cgi/GetInteractionMaterialCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/eggspring/model/GetInteractionMaterialResp;", "keyword", "", "uxinfo", "source", "", "traceId", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "plugin-eggspring_release"})
public final class d
  extends c<h>
{
  public d(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(249462);
    g localg = new g();
    localg.fwe = paramString1;
    localg.jDL = paramString2;
    localg.source = 0;
    localg.jDM = paramString3;
    paramString1 = new d.a();
    paramString1.c((a)localg);
    paramString1.d((a)new h());
    paramString1.vF(0);
    paramString1.vG(0);
    paramString1.TW("/cgi-bin/mmoc-bin/interaction/get_interaction_material");
    paramString1.vD(4310);
    c(paramString1.bgN());
    AppMethodBeat.o(249462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.b.d
 * JD-Core Version:    0.7.0.1
 */