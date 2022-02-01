package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.plugin.gamelife.b.p;
import com.tencent.mm.plugin.gamelife.b.q;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiSetBlackList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/SetBlackListResponse;", "userName", "", "switch", "", "associateWxGameAccount", "(Ljava/lang/String;ZZ)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends b<q>
{
  public static final a JaX;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(268211);
    JaX = new a((byte)0);
    TAG = "MicroMsg.CgiSetBlackList";
    AppMethodBeat.o(268211);
  }
  
  public e(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(268199);
    c.a locala = new c.a();
    p localp = new p();
    com.tencent.mm.plugin.gamelife.b.a locala1 = new com.tencent.mm.plugin.gamelife.b.a();
    locala1.username = paramString;
    locala1.JaA = paramBoolean1;
    localp.JaG = locala1;
    localp.JaQ = paramBoolean2;
    locala.otE = ((com.tencent.mm.bx.a)localp);
    locala.otF = ((com.tencent.mm.bx.a)new q());
    locala.uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/setblacklist";
    locala.funcId = 1102;
    c(locala.bEF());
    AppMethodBeat.o(268199);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiSetBlackList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.e
 * JD-Core Version:    0.7.0.1
 */