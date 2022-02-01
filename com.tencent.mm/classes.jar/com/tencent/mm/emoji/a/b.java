package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.cmw;
import com.tencent.mm.protocal.protobuf.cmx;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/CgiEmojiRecommend;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiResponse;", "req", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiRequest;", "(Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiRequest;)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiRequest;", "plugin-emojisdk_release"})
public final class b
  extends com.tencent.mm.ak.a<cmx>
{
  private final cmw fQm;
  
  public b(cmw paramcmw)
  {
    AppMethodBeat.i(209824);
    this.fQm = paramcmw;
    paramcmw = new cmx();
    b.a locala = new b.a();
    locala.c((com.tencent.mm.bw.a)this.fQm);
    locala.d((com.tencent.mm.bw.a)paramcmw);
    locala.Am("/cgi-bin/micromsg-bin/mmrecommendpanelemoji");
    locala.op(3793);
    locala.or(0);
    locala.os(0);
    c(locala.aAz());
    AppMethodBeat.o(209824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b
 * JD-Core Version:    0.7.0.1
 */