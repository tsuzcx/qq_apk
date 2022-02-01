package com.tencent.mm.plugin.card.model.a;

import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.cqk;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "_Resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "()V", "setRR", "", "request", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "response", "funcId", "", "uri", "", "plugin-card_release"})
public abstract class j<_Resp extends cqk>
  extends c<_Resp>
{
  public final void a(cpx paramcpx, cqk paramcqk, int paramInt, String paramString)
  {
    k.h(paramcpx, "request");
    k.h(paramcqk, "response");
    k.h(paramString, "uri");
    b.a locala = new b.a();
    locala.c((a)paramcpx);
    locala.d((a)paramcqk);
    locala.op(paramInt);
    locala.Am(paramString);
    locala.or(0);
    locala.os(0);
    c(locala.aAz());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.j
 * JD-Core Version:    0.7.0.1
 */