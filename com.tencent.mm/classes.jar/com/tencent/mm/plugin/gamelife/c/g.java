package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiTest;", "", "()V", "Companion", "plugin-gamelife_release"})
public final class g
{
  public static final a Dhf;
  private static final String TAG = "MicroMsg.CgiTest";
  
  static
  {
    AppMethodBeat.i(204263);
    Dhf = new a((byte)0);
    TAG = "MicroMsg.CgiTest";
    AppMethodBeat.o(204263);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiTest$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getBlackList", "", "userName", "getChatSessionData", "sessionIdList", "Ljava/util/LinkedList;", "getChatSessionId", "fromUserName", "toUserName", "getChatUserInfo", "userNameList", "setBlackList", "switch", "", "associateWxGameAccount", "setChatSessionData", "sessionId", "mask", "", "plugin-gamelife_release"})
  public static final class a
  {
    public static void c(String paramString, long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(202885);
      p.k(paramString, "sessionId");
      Log.i(g.access$getTAG$cp(), "setChatSessionData, sessionId = " + paramString + ", mask = " + paramLong + ", switch = " + paramBoolean);
      new f(paramString, paramLong, paramBoolean).bhW();
      AppMethodBeat.o(202885);
    }
    
    public static void h(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(202882);
      p.k(paramString, "userName");
      Log.i(g.access$getTAG$cp(), "setBlackList, userName = " + paramString + ", swith = " + paramBoolean1 + ", associateWxGameAccount = " + paramBoolean2);
      new e(paramString, paramBoolean1, paramBoolean2).bhW();
      AppMethodBeat.o(202882);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.g
 * JD-Core Version:    0.7.0.1
 */