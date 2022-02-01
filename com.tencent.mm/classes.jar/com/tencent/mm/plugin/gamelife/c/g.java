package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiTest;", "", "()V", "Companion", "plugin-gamelife_release"})
public final class g
{
  private static final String TAG = "MicroMsg.CgiTest";
  public static final a ybA;
  
  static
  {
    AppMethodBeat.i(241291);
    ybA = new a((byte)0);
    TAG = "MicroMsg.CgiTest";
    AppMethodBeat.o(241291);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiTest$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getBlackList", "", "userName", "getChatSessionData", "sessionIdList", "Ljava/util/LinkedList;", "getChatSessionId", "fromUserName", "toUserName", "getChatUserInfo", "userNameList", "setBlackList", "switch", "", "associateWxGameAccount", "setChatSessionData", "sessionId", "mask", "", "plugin-gamelife_release"})
  public static final class a
  {
    public static void d(String paramString, long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(241290);
      p.h(paramString, "sessionId");
      Log.i(g.access$getTAG$cp(), "setChatSessionData, sessionId = " + paramString + ", mask = " + paramLong + ", switch = " + paramBoolean);
      new f(paramString, paramLong, paramBoolean).aYI();
      AppMethodBeat.o(241290);
    }
    
    public static void h(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(241289);
      p.h(paramString, "userName");
      Log.i(g.access$getTAG$cp(), "setBlackList, userName = " + paramString + ", swith = " + paramBoolean1 + ", associateWxGameAccount = " + paramBoolean2);
      new e(paramString, paramBoolean1, paramBoolean2).aYI();
      AppMethodBeat.o(241289);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.g
 * JD-Core Version:    0.7.0.1
 */