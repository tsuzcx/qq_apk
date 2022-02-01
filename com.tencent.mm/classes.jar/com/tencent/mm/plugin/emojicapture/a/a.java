package com.tencent.mm.plugin.emojicapture.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agp;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/cgi/CgiTextAntiSpam;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/EmojiTextAntiSpamResponse;", "text", "", "(Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getText", "plugin-emojicapture_release"})
public final class a
  extends com.tencent.mm.ak.a<agp>
{
  private final String TAG;
  private final String text;
  
  public a(String paramString)
  {
    AppMethodBeat.i(128);
    this.text = paramString;
    this.TAG = "MicroMsg.CgiTextAntiSpam";
    paramString = new b.a();
    ago localago = new ago();
    localago.FZl = this.text;
    paramString.c((com.tencent.mm.bw.a)localago);
    paramString.d((com.tencent.mm.bw.a)new agp());
    paramString.DN("/cgi-bin/micromsg-bin/mmemojitextantispam");
    paramString.oS(532);
    c(paramString.aDS());
    ae.i(this.TAG, "Check text anti spam " + this.text);
    AppMethodBeat.o(128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.a.a
 * JD-Core Version:    0.7.0.1
 */