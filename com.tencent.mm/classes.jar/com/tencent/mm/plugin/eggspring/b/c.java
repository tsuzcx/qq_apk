package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.t.a.e;
import com.tencent.mm.t.a.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/eggspring/cgi/GetInteractionADCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/eggspring/model/GetInteractionADResp;", "keyword", "", "uxinfo", "source", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "plugin-eggspring_release"})
public final class c
  extends com.tencent.mm.an.c<f>
{
  public c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(249307);
    Object localObject = new e();
    ((e)localObject).fwe = paramString1;
    ((e)localObject).jDL = paramString2;
    ((e)localObject).source = 1;
    paramString1 = new d.a();
    paramString1.c((a)localObject);
    paramString2 = new f();
    localObject = new jh();
    ((jh)localObject).Tef = new eaf();
    paramString2.setBaseResponse((jh)localObject);
    paramString1.d((a)paramString2);
    paramString1.vF(0);
    paramString1.vG(0);
    paramString1.TW("/cgi-bin/mmoc-bin/interaction/get_interaction_ad");
    paramString1.vD(4947);
    c(paramString1.bgN());
    AppMethodBeat.o(249307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.b.c
 * JD-Core Version:    0.7.0.1
 */