package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiTest;", "", "()V", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final a JaZ;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(268189);
    JaZ = new a((byte)0);
    TAG = "MicroMsg.CgiTest";
    AppMethodBeat.o(268189);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiTest$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getBlackList", "", "userName", "getChatSessionData", "sessionIdList", "Ljava/util/LinkedList;", "getChatSessionId", "fromUserName", "toUserName", "getChatUserInfo", "userNameList", "setBlackList", "switch", "", "associateWxGameAccount", "setChatSessionData", "sessionId", "mask", "", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void c(String paramString, long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(268231);
      s.u(paramString, "sessionId");
      Log.i(g.access$getTAG$cp(), "setChatSessionData, sessionId = " + paramString + ", mask = " + paramLong + ", switch = " + paramBoolean);
      new f(paramString, paramLong, paramBoolean).bFJ();
      AppMethodBeat.o(268231);
    }
    
    public static void j(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(268223);
      s.u(paramString, "userName");
      Log.i(g.access$getTAG$cp(), "setBlackList, userName = " + paramString + ", swith = " + paramBoolean1 + ", associateWxGameAccount = " + paramBoolean2);
      new e(paramString, paramBoolean1, paramBoolean2).bFJ();
      AppMethodBeat.o(268223);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.g
 * JD-Core Version:    0.7.0.1
 */