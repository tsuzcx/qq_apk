package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.protocal.protobuf.buk;
import com.tencent.mm.protocal.protobuf.bul;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/CgiGetEmojiWordList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetEmotionWordListResponse;", "()V", "plugin-emojisdk_release"})
public final class c
  extends com.tencent.mm.an.c<bul>
{
  public c()
  {
    AppMethodBeat.i(229505);
    buk localbuk = new buk();
    bul localbul = new bul();
    d.a locala = new d.a();
    locala.c((a)localbuk);
    locala.d((a)localbul);
    locala.TW("/cgi-bin/micromsg-bin/getemotionwordlist");
    locala.vD(3628);
    locala.vF(0);
    locala.vG(0);
    c(locala.bgN());
    AppMethodBeat.o(229505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c
 * JD-Core Version:    0.7.0.1
 */