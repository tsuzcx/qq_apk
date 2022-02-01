package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.plugin.gamelife.b.c;
import com.tencent.mm.plugin.gamelife.b.d;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetBlackList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetBlackListResponse;", "userName", "", "(Ljava/lang/String;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class a
  extends com.tencent.mm.al.a<d>
{
  private static final String TAG = "MicroMsg.CgiGetBlackList";
  public static final a uxz;
  
  static
  {
    AppMethodBeat.i(211266);
    uxz = new a((byte)0);
    TAG = "MicroMsg.CgiGetBlackList";
    AppMethodBeat.o(211266);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(211265);
    b.a locala = new b.a();
    c localc = new c();
    localc.username = paramString;
    locala.c((com.tencent.mm.bx.a)localc);
    locala.d((com.tencent.mm.bx.a)new d());
    locala.Dl("/cgi-bin/mmgame-bin/gamegamelifeappsvr/getblacklist");
    locala.oP(2982);
    c(locala.aDC());
    AppMethodBeat.o(211265);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetBlackList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.a
 * JD-Core Version:    0.7.0.1
 */