package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.bmv;
import com.tencent.mm.protocal.protobuf.bmw;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/CgiGetEmojiWordList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetEmotionWordListResponse;", "()V", "plugin-emojisdk_release"})
public final class c
  extends com.tencent.mm.ak.c<bmw>
{
  public c()
  {
    AppMethodBeat.i(199910);
    bmv localbmv = new bmv();
    bmw localbmw = new bmw();
    d.a locala = new d.a();
    locala.c((a)localbmv);
    locala.d((a)localbmw);
    locala.MB("/cgi-bin/micromsg-bin/getemotionwordlist");
    locala.sG(3628);
    locala.sI(0);
    locala.sJ(0);
    c(locala.aXF());
    AppMethodBeat.o(199910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c
 * JD-Core Version:    0.7.0.1
 */