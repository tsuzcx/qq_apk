package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.aws;
import com.tencent.mm.protocal.protobuf.awt;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/CgiGetEmojiWordList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetEmotionWordListResponse;", "()V", "plugin-emojisdk_release"})
public final class c
  extends com.tencent.mm.ak.a<awt>
{
  public c()
  {
    AppMethodBeat.i(209825);
    aws localaws = new aws();
    awt localawt = new awt();
    b.a locala = new b.a();
    locala.c((com.tencent.mm.bw.a)localaws);
    locala.d((com.tencent.mm.bw.a)localawt);
    locala.Am("/cgi-bin/micromsg-bin/getemotionwordlist");
    locala.op(3628);
    locala.or(0);
    locala.os(0);
    c(locala.aAz());
    AppMethodBeat.o(209825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.c
 * JD-Core Version:    0.7.0.1
 */