package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.gamelife.b.r;
import com.tencent.mm.plugin.gamelife.b.s;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiSetChatSessionData;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/SetChatSessionDataResponse;", "sessionId", "", "flagMask", "", "switch", "", "(Ljava/lang/String;JZ)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class f
  extends c<s>
{
  public static final a Dhe;
  private static final String TAG = "MicroMsg.CgiSetChatSessionData";
  
  static
  {
    AppMethodBeat.i(203502);
    Dhe = new a((byte)0);
    TAG = "MicroMsg.CgiSetChatSessionData";
    AppMethodBeat.o(203502);
  }
  
  public f(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(203500);
    d.a locala = new d.a();
    r localr = new r();
    localr.session_id = paramString;
    localr.DgX = paramLong;
    localr.DgG = paramBoolean;
    locala.c((a)localr);
    locala.d((a)new s());
    locala.TW("/cgi-bin/mmgame-bin/gamegamelifeappsvr/setchatsessiondata");
    locala.vD(1910);
    c(locala.bgN());
    AppMethodBeat.o(203500);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiSetChatSessionData$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.f
 * JD-Core Version:    0.7.0.1
 */