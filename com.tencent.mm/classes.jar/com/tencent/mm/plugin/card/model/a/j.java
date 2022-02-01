package com.tencent.mm.plugin.card.model.a;

import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.cld;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "_Resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "()V", "setRR", "", "request", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "response", "funcId", "", "uri", "", "plugin-card_release"})
public abstract class j<_Resp extends cld>
  extends c<_Resp>
{
  public final void a(ckq paramckq, cld paramcld, int paramInt, String paramString)
  {
    k.h(paramckq, "request");
    k.h(paramcld, "response");
    k.h(paramString, "uri");
    b.a locala = new b.a();
    locala.c((a)paramckq);
    locala.d((a)paramcld);
    locala.nB(paramInt);
    locala.wg(paramString);
    locala.nD(0);
    locala.nE(0);
    c(locala.atI());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.j
 * JD-Core Version:    0.7.0.1
 */