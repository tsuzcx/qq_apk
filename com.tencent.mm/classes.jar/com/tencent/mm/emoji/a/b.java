package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.csu;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/CgiEmojiRecommend;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiResponse;", "req", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiRequest;", "(Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiRequest;)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiRequest;", "plugin-emojisdk_release"})
public final class b
  extends com.tencent.mm.ak.a<csu>
{
  private final cst gmf;
  
  public b(cst paramcst)
  {
    AppMethodBeat.i(188555);
    this.gmf = paramcst;
    paramcst = new csu();
    b.a locala = new b.a();
    locala.c((com.tencent.mm.bw.a)this.gmf);
    locala.d((com.tencent.mm.bw.a)paramcst);
    locala.DN("/cgi-bin/micromsg-bin/mmrecommendpanelemoji");
    locala.oS(3793);
    locala.oU(0);
    locala.oV(0);
    c(locala.aDS());
    AppMethodBeat.o(188555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b
 * JD-Core Version:    0.7.0.1
 */