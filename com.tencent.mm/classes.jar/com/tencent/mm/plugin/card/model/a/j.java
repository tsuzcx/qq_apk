package com.tencent.mm.plugin.card.model.a;

import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "_Resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/Cgi;", "()V", "setRR", "", "request", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "response", "funcId", "", "uri", "", "plugin-card_release"})
public abstract class j<_Resp extends dpc>
  extends c<_Resp>
{
  public final void a(dop paramdop, dpc paramdpc, int paramInt, String paramString)
  {
    p.h(paramdop, "request");
    p.h(paramdpc, "response");
    p.h(paramString, "uri");
    d.a locala = new d.a();
    locala.c((a)paramdop);
    locala.d((a)paramdpc);
    locala.sG(paramInt);
    locala.MB(paramString);
    locala.sI(0);
    locala.sJ(0);
    c(locala.aXF());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.j
 * JD-Core Version:    0.7.0.1
 */