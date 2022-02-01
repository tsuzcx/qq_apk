package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.crz;
import com.tencent.mm.protocal.protobuf.csa;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/CgiEmojiRecommend;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiResponse;", "req", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiRequest;", "(Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiRequest;)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiRequest;", "plugin-emojisdk_release"})
public final class b
  extends com.tencent.mm.al.a<csa>
{
  private final crz gjM;
  
  public b(crz paramcrz)
  {
    AppMethodBeat.i(218944);
    this.gjM = paramcrz;
    paramcrz = new csa();
    b.a locala = new b.a();
    locala.c((com.tencent.mm.bx.a)this.gjM);
    locala.d((com.tencent.mm.bx.a)paramcrz);
    locala.Dl("/cgi-bin/micromsg-bin/mmrecommendpanelemoji");
    locala.oP(3793);
    locala.oR(0);
    locala.oS(0);
    c(locala.aDC());
    AppMethodBeat.o(218944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b
 * JD-Core Version:    0.7.0.1
 */