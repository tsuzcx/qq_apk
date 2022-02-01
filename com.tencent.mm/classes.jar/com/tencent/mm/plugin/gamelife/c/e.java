package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.plugin.gamelife.b.p;
import com.tencent.mm.plugin.gamelife.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiSetBlackList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/SetBlackListResponse;", "userName", "", "switch", "", "associateWxGameAccount", "(Ljava/lang/String;ZZ)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class e
  extends c<q>
{
  public static final a Dhd;
  private static final String TAG = "MicroMsg.CgiSetBlackList";
  
  static
  {
    AppMethodBeat.i(203649);
    Dhd = new a((byte)0);
    TAG = "MicroMsg.CgiSetBlackList";
    AppMethodBeat.o(203649);
  }
  
  public e(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(203645);
    d.a locala = new d.a();
    p localp = new p();
    com.tencent.mm.plugin.gamelife.b.a locala1 = new com.tencent.mm.plugin.gamelife.b.a();
    locala1.username = paramString;
    locala1.DgG = paramBoolean1;
    localp.DgM = locala1;
    localp.DgW = paramBoolean2;
    locala.c((com.tencent.mm.cd.a)localp);
    locala.d((com.tencent.mm.cd.a)new q());
    locala.TW("/cgi-bin/mmgame-bin/gamegamelifeappsvr/setblacklist");
    locala.vD(1102);
    c(locala.bgN());
    AppMethodBeat.o(203645);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiSetBlackList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.e
 * JD-Core Version:    0.7.0.1
 */