package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.protocal.protobuf.bbh;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/CgiGetEmojiWordList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetEmotionWordListResponse;", "()V", "plugin-emojisdk_release"})
public final class c
  extends com.tencent.mm.ak.a<bbh>
{
  public c()
  {
    AppMethodBeat.i(188556);
    bbg localbbg = new bbg();
    bbh localbbh = new bbh();
    b.a locala = new b.a();
    locala.c((com.tencent.mm.bw.a)localbbg);
    locala.d((com.tencent.mm.bw.a)localbbh);
    locala.DN("/cgi-bin/micromsg-bin/getemotionwordlist");
    locala.oS(3628);
    locala.oU(0);
    locala.oV(0);
    c(locala.aDS());
    AppMethodBeat.o(188556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.a.c
 * JD-Core Version:    0.7.0.1
 */