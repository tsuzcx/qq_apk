package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiTest;", "", "()V", "Companion", "plugin-gamelife_release"})
public final class g
{
  private static final String TAG = "MicroMsg.CgiTest";
  public static final a uJj;
  
  static
  {
    AppMethodBeat.i(212051);
    uJj = new a((byte)0);
    TAG = "MicroMsg.CgiTest";
    AppMethodBeat.o(212051);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiTest$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getBlackList", "", "userName", "getChatSessionData", "sessionIdList", "Ljava/util/LinkedList;", "getChatSessionId", "fromUserName", "toUserName", "getChatUserInfo", "userNameList", "setBlackList", "switch", "", "associateWxGameAccount", "setChatSessionData", "sessionId", "mask", "", "plugin-gamelife_release"})
  public static final class a
  {
    public static void d(String paramString, long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(212050);
      p.h(paramString, "sessionId");
      ae.i(g.access$getTAG$cp(), "setChatSessionData, sessionId = " + paramString + ", mask = " + paramLong + ", switch = " + paramBoolean);
      new f(paramString, paramLong, paramBoolean).aET();
      AppMethodBeat.o(212050);
    }
    
    public static void g(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(212049);
      p.h(paramString, "userName");
      ae.i(g.access$getTAG$cp(), "setBlackList, userName = " + paramString + ", swith = " + paramBoolean1 + ", associateWxGameAccount = " + paramBoolean2);
      new e(paramString, paramBoolean1, paramBoolean2).aET();
      AppMethodBeat.o(212049);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.g
 * JD-Core Version:    0.7.0.1
 */