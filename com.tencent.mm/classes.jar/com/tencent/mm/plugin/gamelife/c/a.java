package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.plugin.gamelife.b.d;
import com.tencent.mm.plugin.gamelife.b.e;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetBlackList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetBlackListResponse;", "userName", "", "(Ljava/lang/String;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b<e>
{
  public static final a JaS;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(268218);
    JaS = new a((byte)0);
    TAG = "MicroMsg.CgiGetBlackList";
    AppMethodBeat.o(268218);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(268206);
    c.a locala = new c.a();
    d locald = new d();
    locald.username = paramString;
    locala.otE = ((com.tencent.mm.bx.a)locald);
    locala.otF = ((com.tencent.mm.bx.a)new e());
    locala.uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/getblacklist";
    locala.funcId = 2982;
    c(locala.bEF());
    AppMethodBeat.o(268206);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetBlackList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.a
 * JD-Core Version:    0.7.0.1
 */