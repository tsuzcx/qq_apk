package com.tencent.mm.plugin.emojicapture.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.adx;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/cgi/CgiTextAntiSpam;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/EmojiTextAntiSpamResponse;", "text", "", "(Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getText", "plugin-emojicapture_release"})
public final class a
  extends c<adx>
{
  private final String TAG;
  private final String text;
  
  public a(String paramString)
  {
    AppMethodBeat.i(128);
    this.text = paramString;
    this.TAG = "MicroMsg.CgiTextAntiSpam";
    paramString = new b.a();
    adw localadw = new adw();
    localadw.Ebg = this.text;
    paramString.c((com.tencent.mm.bw.a)localadw);
    paramString.d((com.tencent.mm.bw.a)new adx());
    paramString.Am("/cgi-bin/micromsg-bin/mmemojitextantispam");
    paramString.op(532);
    c(paramString.aAz());
    ac.i(this.TAG, "Check text anti spam " + this.text);
    AppMethodBeat.o(128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.a.a
 * JD-Core Version:    0.7.0.1
 */