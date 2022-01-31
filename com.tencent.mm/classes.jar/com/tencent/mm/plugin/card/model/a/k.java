package com.tencent.mm.plugin.card.model.a;

import a.f.b.j;
import a.l;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.bvk;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "_Resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/Cgi;", "()V", "setRR", "", "request", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "response", "funcId", "", "uri", "", "plugin-card_release"})
public abstract class k<_Resp extends bvk>
  extends com.tencent.mm.ai.a<_Resp>
{
  public final void a(buy parambuy, bvk parambvk, int paramInt, String paramString)
  {
    j.q(parambuy, "request");
    j.q(parambvk, "response");
    j.q(paramString, "uri");
    b.a locala = new b.a();
    locala.a((com.tencent.mm.bv.a)parambuy);
    locala.b((com.tencent.mm.bv.a)parambvk);
    locala.kT(paramInt);
    locala.rl(paramString);
    locala.kU(0);
    locala.kV(0);
    a(locala.ado());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.k
 * JD-Core Version:    0.7.0.1
 */