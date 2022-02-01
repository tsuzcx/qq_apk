package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.r.a.e;
import com.tencent.mm.r.a.f;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/eggspring/cgi/GetInteractionADCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/eggspring/model/GetInteractionADResp;", "keyword", "", "uxinfo", "source", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends b<f>
{
  public c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(266529);
    Object localObject = new e();
    ((e)localObject).hAB = paramString1;
    ((e)localObject).mdG = paramString2;
    ((e)localObject).source = 1;
    paramString1 = new c.a();
    paramString1.otE = ((a)localObject);
    paramString2 = new f();
    localObject = new kd();
    ((kd)localObject).akjO = new etl();
    ah localah = ah.aiuX;
    paramString2.setBaseResponse((kd)localObject);
    localObject = ah.aiuX;
    paramString1.otF = ((a)paramString2);
    paramString1.otG = 0;
    paramString1.respCmdId = 0;
    paramString1.uri = "/cgi-bin/mmoc-bin/interaction/get_interaction_ad";
    paramString1.funcId = 4947;
    c(paramString1.bEF());
    AppMethodBeat.o(266529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.b.c
 * JD-Core Version:    0.7.0.1
 */