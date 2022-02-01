package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.t.a.e;
import com.tencent.mm.t.a.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/eggspring/cgi/GetInteractionMaterialCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/eggspring/model/GetInteractionMaterialResp;", "keyword", "", "uxinfo", "source", "", "traceId", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "plugin-eggspring_release"})
public final class c
  extends com.tencent.mm.ak.c<f>
{
  public c(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(194566);
    e locale = new e();
    locale.dDv = paramString1;
    locale.gTk = paramString2;
    locale.source = 0;
    locale.gTl = paramString3;
    paramString1 = new d.a();
    paramString1.c((a)locale);
    paramString1.d((a)new f());
    paramString1.sI(0);
    paramString1.sJ(0);
    paramString1.MB("/cgi-bin/mmoc-bin/interaction/get_interaction_material");
    paramString1.sG(4310);
    c(paramString1.aXF());
    AppMethodBeat.o(194566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.b.c
 * JD-Core Version:    0.7.0.1
 */