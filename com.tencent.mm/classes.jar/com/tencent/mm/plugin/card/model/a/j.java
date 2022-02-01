package com.tencent.mm.plugin.card.model.a;

import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.cwj;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "_Resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/Cgi;", "()V", "setRR", "", "request", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "response", "funcId", "", "uri", "", "plugin-card_release"})
public abstract class j<_Resp extends cwj>
  extends com.tencent.mm.ak.a<_Resp>
{
  public final void a(cvw paramcvw, cwj paramcwj, int paramInt, String paramString)
  {
    p.h(paramcvw, "request");
    p.h(paramcwj, "response");
    p.h(paramString, "uri");
    b.a locala = new b.a();
    locala.c((com.tencent.mm.bw.a)paramcvw);
    locala.d((com.tencent.mm.bw.a)paramcwj);
    locala.oS(paramInt);
    locala.DN(paramString);
    locala.oU(0);
    locala.oV(0);
    c(locala.aDS());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.j
 * JD-Core Version:    0.7.0.1
 */