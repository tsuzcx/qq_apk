package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.dlc;
import com.tencent.mm.protocal.protobuf.dld;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/CgiEmojiRecommend;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiResponse;", "req", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiRequest;", "(Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiRequest;)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiRequest;", "plugin-emojisdk_release"})
public final class b
  extends c<dld>
{
  private final dlc gWV;
  
  public b(dlc paramdlc)
  {
    AppMethodBeat.i(199909);
    this.gWV = paramdlc;
    paramdlc = new dld();
    d.a locala = new d.a();
    locala.c((a)this.gWV);
    locala.d((a)paramdlc);
    locala.MB("/cgi-bin/micromsg-bin/mmrecommendpanelemoji");
    locala.sG(3793);
    locala.sI(0);
    locala.sJ(0);
    c(locala.aXF());
    AppMethodBeat.o(199909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b
 * JD-Core Version:    0.7.0.1
 */