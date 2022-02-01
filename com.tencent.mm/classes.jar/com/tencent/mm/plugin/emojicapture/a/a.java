package com.tencent.mm.plugin.emojicapture.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.amu;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/cgi/CgiTextAntiSpam;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/EmojiTextAntiSpamResponse;", "text", "", "(Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getText", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b<amu>
{
  private final String TAG;
  private final String text;
  
  public a(String paramString)
  {
    AppMethodBeat.i(128);
    this.text = paramString;
    this.TAG = "MicroMsg.CgiTextAntiSpam";
    paramString = new c.a();
    amt localamt = new amt();
    localamt.YRE = this.text;
    paramString.otE = ((com.tencent.mm.bx.a)localamt);
    paramString.otF = ((com.tencent.mm.bx.a)new amu());
    paramString.uri = "/cgi-bin/micromsg-bin/mmemojitextantispam";
    paramString.funcId = 532;
    c(paramString.bEF());
    Log.i(this.TAG, s.X("Check text anti spam ", this.text));
    AppMethodBeat.o(128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.a.a
 * JD-Core Version:    0.7.0.1
 */