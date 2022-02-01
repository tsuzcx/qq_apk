package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.plugin.gamelife.b.o;
import com.tencent.mm.plugin.gamelife.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiSetBlackList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/SetBlackListResponse;", "userName", "", "switch", "", "associateWxGameAccount", "(Ljava/lang/String;ZZ)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class e
  extends com.tencent.mm.ak.a<p>
{
  private static final String TAG = "MicroMsg.CgiSetBlackList";
  public static final a uJh;
  
  static
  {
    AppMethodBeat.i(212045);
    uJh = new a((byte)0);
    TAG = "MicroMsg.CgiSetBlackList";
    AppMethodBeat.o(212045);
  }
  
  public e(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(212044);
    b.a locala = new b.a();
    o localo = new o();
    com.tencent.mm.plugin.gamelife.b.a locala1 = new com.tencent.mm.plugin.gamelife.b.a();
    locala1.username = paramString;
    locala1.uIK = paramBoolean1;
    localo.uIP = locala1;
    localo.uJa = paramBoolean2;
    locala.c((com.tencent.mm.bw.a)localo);
    locala.d((com.tencent.mm.bw.a)new p());
    locala.DN("/cgi-bin/mmgame-bin/gamegamelifeappsvr/setblacklist");
    locala.oS(1102);
    c(locala.aDS());
    AppMethodBeat.o(212044);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiSetBlackList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.e
 * JD-Core Version:    0.7.0.1
 */