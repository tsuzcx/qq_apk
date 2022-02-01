package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.plugin.gamelife.b.q;
import com.tencent.mm.plugin.gamelife.b.r;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiSetChatSessionData;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/SetChatSessionDataResponse;", "sessionId", "", "flagMask", "", "switch", "", "(Ljava/lang/String;JZ)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class f
  extends com.tencent.mm.ak.a<r>
{
  private static final String TAG = "MicroMsg.CgiSetChatSessionData";
  public static final a uJi;
  
  static
  {
    AppMethodBeat.i(212048);
    uJi = new a((byte)0);
    TAG = "MicroMsg.CgiSetChatSessionData";
    AppMethodBeat.o(212048);
  }
  
  public f(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(212047);
    b.a locala = new b.a();
    q localq = new q();
    localq.session_id = paramString;
    localq.uJb = paramLong;
    localq.uIK = paramBoolean;
    locala.c((com.tencent.mm.bw.a)localq);
    locala.d((com.tencent.mm.bw.a)new r());
    locala.DN("/cgi-bin/mmgame-bin/gamegamelifeappsvr/setchatsessiondata");
    locala.oS(1910);
    c(locala.aDS());
    AppMethodBeat.o(212047);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiSetChatSessionData$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.f
 * JD-Core Version:    0.7.0.1
 */