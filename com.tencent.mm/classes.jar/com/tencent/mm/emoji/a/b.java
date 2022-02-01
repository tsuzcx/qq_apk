package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.cht;
import com.tencent.mm.protocal.protobuf.chu;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/CgiEmojiRecommend;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiResponse;", "req", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiRequest;", "(Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiRequest;)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiRequest;", "plugin-emojisdk_release"})
public final class b
  extends com.tencent.mm.al.a<chu>
{
  private final cht fMA;
  
  public b(cht paramcht)
  {
    AppMethodBeat.i(193391);
    this.fMA = paramcht;
    paramcht = new chu();
    b.a locala = new b.a();
    locala.c((com.tencent.mm.bx.a)this.fMA);
    locala.d((com.tencent.mm.bx.a)paramcht);
    locala.wg("/cgi-bin/micromsg-bin/mmrecommendpanelemoji");
    locala.nB(3793);
    locala.nD(0);
    locala.nE(0);
    c(locala.atI());
    AppMethodBeat.o(193391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b
 * JD-Core Version:    0.7.0.1
 */