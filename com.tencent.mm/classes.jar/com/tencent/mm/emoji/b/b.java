package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.protocal.protobuf.dut;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/CgiEmojiRecommend;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiResponse;", "req", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiRequest;", "(Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiRequest;)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiRequest;", "plugin-emojisdk_release"})
public final class b
  extends c<dut>
{
  private final dus jHT;
  
  public b(dus paramdus)
  {
    AppMethodBeat.i(238479);
    this.jHT = paramdus;
    paramdus = new dut();
    d.a locala = new d.a();
    locala.c((a)this.jHT);
    locala.d((a)paramdus);
    locala.TW("/cgi-bin/micromsg-bin/mmrecommendpanelemoji");
    locala.vD(3793);
    locala.vF(0);
    locala.vG(0);
    c(locala.bgN());
    AppMethodBeat.o(238479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b
 * JD-Core Version:    0.7.0.1
 */