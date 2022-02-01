package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.baq;
import com.tencent.mm.protocal.protobuf.bar;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/CgiGetEmojiWordList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetEmotionWordListResponse;", "()V", "plugin-emojisdk_release"})
public final class c
  extends com.tencent.mm.al.a<bar>
{
  public c()
  {
    AppMethodBeat.i(218945);
    baq localbaq = new baq();
    bar localbar = new bar();
    b.a locala = new b.a();
    locala.c((com.tencent.mm.bx.a)localbaq);
    locala.d((com.tencent.mm.bx.a)localbar);
    locala.Dl("/cgi-bin/micromsg-bin/getemotionwordlist");
    locala.oP(3628);
    locala.oR(0);
    locala.oS(0);
    c(locala.aDC());
    AppMethodBeat.o(218945);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.a.c
 * JD-Core Version:    0.7.0.1
 */