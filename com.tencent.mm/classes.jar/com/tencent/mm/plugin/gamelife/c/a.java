package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.plugin.gamelife.b.d;
import com.tencent.mm.plugin.gamelife.b.e;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetBlackList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetBlackListResponse;", "userName", "", "(Ljava/lang/String;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class a
  extends c<e>
{
  public static final a DgY;
  private static final String TAG = "MicroMsg.CgiGetBlackList";
  
  static
  {
    AppMethodBeat.i(202701);
    DgY = new a((byte)0);
    TAG = "MicroMsg.CgiGetBlackList";
    AppMethodBeat.o(202701);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(202699);
    d.a locala = new d.a();
    d locald = new d();
    locald.username = paramString;
    locala.c((com.tencent.mm.cd.a)locald);
    locala.d((com.tencent.mm.cd.a)new e());
    locala.TW("/cgi-bin/mmgame-bin/gamegamelifeappsvr/getblacklist");
    locala.vD(2982);
    c(locala.bgN());
    AppMethodBeat.o(202699);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetBlackList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.a
 * JD-Core Version:    0.7.0.1
 */