package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.gamelife.b.r;
import com.tencent.mm.plugin.gamelife.b.s;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiSetChatSessionData;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/SetChatSessionDataResponse;", "sessionId", "", "flagMask", "", "switch", "", "(Ljava/lang/String;JZ)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends b<s>
{
  public static final a JaY;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(268201);
    JaY = new a((byte)0);
    TAG = "MicroMsg.CgiSetChatSessionData";
    AppMethodBeat.o(268201);
  }
  
  public f(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(268190);
    c.a locala = new c.a();
    r localr = new r();
    localr.session_id = paramString;
    localr.JaR = paramLong;
    localr.JaA = paramBoolean;
    locala.otE = ((a)localr);
    locala.otF = ((a)new s());
    locala.uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/setchatsessiondata";
    locala.funcId = 1910;
    c(locala.bEF());
    AppMethodBeat.o(268190);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiSetChatSessionData$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.f
 * JD-Core Version:    0.7.0.1
 */