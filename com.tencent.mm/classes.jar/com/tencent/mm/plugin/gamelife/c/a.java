package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.plugin.gamelife.b.d;
import com.tencent.mm.plugin.gamelife.b.e;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetBlackList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetBlackListResponse;", "userName", "", "(Ljava/lang/String;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class a
  extends c<e>
{
  private static final String TAG = "MicroMsg.CgiGetBlackList";
  public static final a ybt;
  
  static
  {
    AppMethodBeat.i(241273);
    ybt = new a((byte)0);
    TAG = "MicroMsg.CgiGetBlackList";
    AppMethodBeat.o(241273);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(241272);
    d.a locala = new d.a();
    d locald = new d();
    locald.username = paramString;
    locala.c((com.tencent.mm.bw.a)locald);
    locala.d((com.tencent.mm.bw.a)new e());
    locala.MB("/cgi-bin/mmgame-bin/gamegamelifeappsvr/getblacklist");
    locala.sG(2982);
    c(locala.aXF());
    AppMethodBeat.o(241272);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetBlackList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.a
 * JD-Core Version:    0.7.0.1
 */