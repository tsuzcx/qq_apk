package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.plugin.gamelife.b.h;
import com.tencent.mm.plugin.gamelife.b.i;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatSessionId;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionIdResponse;", "fromUserName", "", "toUserName", "(Ljava/lang/String;Ljava/lang/String;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class c
  extends com.tencent.mm.ak.a<i>
{
  private static final String TAG = "MicroMsg.CgiGetChatSessionId";
  public static final a uJf;
  
  static
  {
    AppMethodBeat.i(212039);
    uJf = new a((byte)0);
    TAG = "MicroMsg.CgiGetChatSessionId";
    AppMethodBeat.o(212039);
  }
  
  public c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212038);
    b.a locala = new b.a();
    h localh = new h();
    localh.oBM = paramString1;
    localh.oBN = paramString2;
    locala.c((com.tencent.mm.bw.a)localh);
    locala.d((com.tencent.mm.bw.a)new i());
    locala.DN("/cgi-bin/mmgame-bin/gamegamelifeappsvr/getchatsessionid");
    locala.oS(1103);
    c(locala.aDS());
    AppMethodBeat.o(212038);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatSessionId$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.c
 * JD-Core Version:    0.7.0.1
 */