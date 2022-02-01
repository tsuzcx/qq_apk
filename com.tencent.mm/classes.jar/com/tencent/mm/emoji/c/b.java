package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.enq;
import com.tencent.mm.protocal.protobuf.enr;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/CgiEmojiRecommend;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiResponse;", "req", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiRequest;", "(Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiRequest;)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiRequest;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.am.b<enr>
{
  private final enq mhA;
  
  public b(enq paramenq)
  {
    AppMethodBeat.i(242652);
    this.mhA = paramenq;
    paramenq = new enr();
    c.a locala = new c.a();
    locala.otE = ((a)this.mhA);
    locala.otF = ((a)paramenq);
    locala.uri = "/cgi-bin/micromsg-bin/mmrecommendpanelemoji";
    locala.funcId = 3793;
    locala.otG = 0;
    locala.respCmdId = 0;
    c(locala.bEF());
    AppMethodBeat.o(242652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b
 * JD-Core Version:    0.7.0.1
 */