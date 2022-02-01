package com.tencent.mm.plugin.emojicapture.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.acx;
import com.tencent.mm.protocal.protobuf.acy;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/cgi/CgiTextAntiSpam;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/EmojiTextAntiSpamResponse;", "text", "", "(Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getText", "plugin-emojicapture_release"})
public final class a
  extends c<acy>
{
  private final String TAG;
  private final String text;
  
  public a(String paramString)
  {
    AppMethodBeat.i(128);
    this.text = paramString;
    this.TAG = "MicroMsg.CgiTextAntiSpam";
    paramString = new b.a();
    acx localacx = new acx();
    localacx.CIE = this.text;
    paramString.c((com.tencent.mm.bx.a)localacx);
    paramString.d((com.tencent.mm.bx.a)new acy());
    paramString.wg("/cgi-bin/micromsg-bin/mmemojitextantispam");
    paramString.nB(532);
    c(paramString.atI());
    ad.i(this.TAG, "Check text anti spam " + this.text);
    AppMethodBeat.o(128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.a.a
 * JD-Core Version:    0.7.0.1
 */