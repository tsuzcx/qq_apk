package com.tencent.mm.plugin.emojicapture.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.agf;
import com.tencent.mm.protocal.protobuf.agg;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/cgi/CgiTextAntiSpam;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/EmojiTextAntiSpamResponse;", "text", "", "(Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getText", "plugin-emojicapture_release"})
public final class a
  extends com.tencent.mm.al.a<agg>
{
  private final String TAG;
  private final String text;
  
  public a(String paramString)
  {
    AppMethodBeat.i(128);
    this.text = paramString;
    this.TAG = "MicroMsg.CgiTextAntiSpam";
    paramString = new b.a();
    agf localagf = new agf();
    localagf.FGP = this.text;
    paramString.c((com.tencent.mm.bx.a)localagf);
    paramString.d((com.tencent.mm.bx.a)new agg());
    paramString.Dl("/cgi-bin/micromsg-bin/mmemojitextantispam");
    paramString.oP(532);
    c(paramString.aDC());
    ad.i(this.TAG, "Check text anti spam " + this.text);
    AppMethodBeat.o(128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.a.a
 * JD-Core Version:    0.7.0.1
 */