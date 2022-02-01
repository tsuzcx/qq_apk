package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.plugin.gamelife.b.g;
import com.tencent.mm.plugin.gamelife.b.h;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatSessionId;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionIdResponse;", "fromUserName", "", "toUserName", "(Ljava/lang/String;Ljava/lang/String;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class c
  extends com.tencent.mm.al.a<h>
{
  private static final String TAG = "MicroMsg.CgiGetChatSessionId";
  public static final a uxC;
  
  static
  {
    AppMethodBeat.i(211272);
    uxC = new a((byte)0);
    TAG = "MicroMsg.CgiGetChatSessionId";
    AppMethodBeat.o(211272);
  }
  
  public c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(211271);
    b.a locala = new b.a();
    g localg = new g();
    localg.ovl = paramString1;
    localg.ovm = paramString2;
    locala.c((com.tencent.mm.bx.a)localg);
    locala.d((com.tencent.mm.bx.a)new h());
    locala.Dl("/cgi-bin/mmgame-bin/gamegamelifeappsvr/getchatsessionid");
    locala.oP(1103);
    c(locala.aDC());
    AppMethodBeat.o(211271);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatSessionId$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.c
 * JD-Core Version:    0.7.0.1
 */