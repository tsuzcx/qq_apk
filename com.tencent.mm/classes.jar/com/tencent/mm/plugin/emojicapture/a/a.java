package com.tencent.mm.plugin.emojicapture.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.zj;
import com.tencent.mm.protocal.protobuf.zk;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/cgi/CgiTextAntiSpam;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/EmojiTextAntiSpamResponse;", "text", "", "(Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getText", "plugin-emojicapture_release"})
public final class a
  extends com.tencent.mm.ai.a<zk>
{
  private final String TAG;
  private final String text;
  
  public a(String paramString)
  {
    AppMethodBeat.i(2568);
    this.text = paramString;
    this.TAG = "MicroMsg.CgiTextAntiSpam";
    paramString = new b.a();
    zj localzj = new zj();
    localzj.wxW = this.text;
    paramString.a((com.tencent.mm.bv.a)localzj);
    paramString.b((com.tencent.mm.bv.a)new zk());
    paramString.rl("/cgi-bin/micromsg-bin/mmemojitextantispam");
    paramString.kT(532);
    a(paramString.ado());
    ab.i(this.TAG, "Check text anti spam " + this.text);
    AppMethodBeat.o(2568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.a.a
 * JD-Core Version:    0.7.0.1
 */