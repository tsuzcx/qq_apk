package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.t.a.d;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/eggspring/cgi/GetInteractionADCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/eggspring/model/GetInteractionADResp;", "keyword", "", "uxinfo", "source", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "plugin-eggspring_release"})
public final class b
  extends com.tencent.mm.ak.c<d>
{
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194565);
    com.tencent.mm.t.a.c localc = new com.tencent.mm.t.a.c();
    localc.dDv = paramString1;
    localc.gTk = paramString2;
    localc.source = 1;
    paramString1 = new d.a();
    paramString1.c((a)localc);
    paramString1.d((a)new d());
    paramString1.sI(0);
    paramString1.sJ(0);
    paramString1.MB("/cgi-bin/mmoc-bin/interaction/get_interaction_ad");
    paramString1.sG(4947);
    c(paramString1.aXF());
    AppMethodBeat.o(194565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.b.b
 * JD-Core Version:    0.7.0.1
 */