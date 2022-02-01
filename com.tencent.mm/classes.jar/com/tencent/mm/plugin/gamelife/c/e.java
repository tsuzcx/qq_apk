package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.plugin.gamelife.b.n;
import com.tencent.mm.plugin.gamelife.b.o;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiSetBlackList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/SetBlackListResponse;", "userName", "", "switch", "", "associateWxGameAccount", "(Ljava/lang/String;ZZ)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class e
  extends com.tencent.mm.al.a<o>
{
  private static final String TAG = "MicroMsg.CgiSetBlackList";
  public static final a uxE;
  
  static
  {
    AppMethodBeat.i(211278);
    uxE = new a((byte)0);
    TAG = "MicroMsg.CgiSetBlackList";
    AppMethodBeat.o(211278);
  }
  
  public e(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(211277);
    b.a locala = new b.a();
    n localn = new n();
    com.tencent.mm.plugin.gamelife.b.a locala1 = new com.tencent.mm.plugin.gamelife.b.a();
    locala1.username = paramString;
    locala1.uxk = paramBoolean1;
    localn.uxn = locala1;
    localn.uxx = paramBoolean2;
    locala.c((com.tencent.mm.bx.a)localn);
    locala.d((com.tencent.mm.bx.a)new o());
    locala.Dl("/cgi-bin/mmgame-bin/gamegamelifeappsvr/setblacklist");
    locala.oP(1102);
    c(locala.aDC());
    AppMethodBeat.o(211277);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiSetBlackList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.e
 * JD-Core Version:    0.7.0.1
 */