package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.plugin.gamelife.b.p;
import com.tencent.mm.plugin.gamelife.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiSetBlackList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/SetBlackListResponse;", "userName", "", "switch", "", "associateWxGameAccount", "(Ljava/lang/String;ZZ)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class e
  extends c<q>
{
  private static final String TAG = "MicroMsg.CgiSetBlackList";
  public static final a yby;
  
  static
  {
    AppMethodBeat.i(241285);
    yby = new a((byte)0);
    TAG = "MicroMsg.CgiSetBlackList";
    AppMethodBeat.o(241285);
  }
  
  public e(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(241284);
    d.a locala = new d.a();
    p localp = new p();
    com.tencent.mm.plugin.gamelife.b.a locala1 = new com.tencent.mm.plugin.gamelife.b.a();
    locala1.username = paramString;
    locala1.yaY = paramBoolean1;
    localp.ybe = locala1;
    localp.ybr = paramBoolean2;
    locala.c((com.tencent.mm.bw.a)localp);
    locala.d((com.tencent.mm.bw.a)new q());
    locala.MB("/cgi-bin/mmgame-bin/gamegamelifeappsvr/setblacklist");
    locala.sG(1102);
    c(locala.aXF());
    AppMethodBeat.o(241284);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiSetBlackList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.e
 * JD-Core Version:    0.7.0.1
 */