package com.tencent.mm.plugin.card.model.a;

import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.cvp;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "_Resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/Cgi;", "()V", "setRR", "", "request", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "response", "funcId", "", "uri", "", "plugin-card_release"})
public abstract class j<_Resp extends cvp>
  extends com.tencent.mm.al.a<_Resp>
{
  public final void a(cvc paramcvc, cvp paramcvp, int paramInt, String paramString)
  {
    p.h(paramcvc, "request");
    p.h(paramcvp, "response");
    p.h(paramString, "uri");
    b.a locala = new b.a();
    locala.c((com.tencent.mm.bx.a)paramcvc);
    locala.d((com.tencent.mm.bx.a)paramcvp);
    locala.oP(paramInt);
    locala.Dl(paramString);
    locala.oR(0);
    locala.oS(0);
    c(locala.aDC());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.j
 * JD-Core Version:    0.7.0.1
 */