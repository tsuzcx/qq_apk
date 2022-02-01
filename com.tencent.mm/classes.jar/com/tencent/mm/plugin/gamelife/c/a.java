package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.plugin.gamelife.b.d;
import com.tencent.mm.plugin.gamelife.b.e;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetBlackList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetBlackListResponse;", "userName", "", "(Ljava/lang/String;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class a
  extends com.tencent.mm.ak.a<e>
{
  private static final String TAG = "MicroMsg.CgiGetBlackList";
  public static final a uJc;
  
  static
  {
    AppMethodBeat.i(212033);
    uJc = new a((byte)0);
    TAG = "MicroMsg.CgiGetBlackList";
    AppMethodBeat.o(212033);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(212032);
    b.a locala = new b.a();
    d locald = new d();
    locald.username = paramString;
    locala.c((com.tencent.mm.bw.a)locald);
    locala.d((com.tencent.mm.bw.a)new e());
    locala.DN("/cgi-bin/mmgame-bin/gamegamelifeappsvr/getblacklist");
    locala.oS(2982);
    c(locala.aDS());
    AppMethodBeat.o(212032);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetBlackList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.a
 * JD-Core Version:    0.7.0.1
 */