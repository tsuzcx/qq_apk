package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.plugin.gamelife.b.p;
import com.tencent.mm.plugin.gamelife.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiSetChatSessionData;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/SetChatSessionDataResponse;", "sessionId", "", "flagMask", "", "switch", "", "(Ljava/lang/String;JZ)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class f
  extends com.tencent.mm.al.a<q>
{
  private static final String TAG = "MicroMsg.CgiSetChatSessionData";
  public static final a uxF;
  
  static
  {
    AppMethodBeat.i(211281);
    uxF = new a((byte)0);
    TAG = "MicroMsg.CgiSetChatSessionData";
    AppMethodBeat.o(211281);
  }
  
  public f(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(211280);
    b.a locala = new b.a();
    p localp = new p();
    localp.session_id = paramString;
    localp.uxy = paramLong;
    localp.uxk = paramBoolean;
    locala.c((com.tencent.mm.bx.a)localp);
    locala.d((com.tencent.mm.bx.a)new q());
    locala.Dl("/cgi-bin/mmgame-bin/gamegamelifeappsvr/setchatsessiondata");
    locala.oP(1910);
    c(locala.aDC());
    AppMethodBeat.o(211280);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiSetChatSessionData$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.f
 * JD-Core Version:    0.7.0.1
 */