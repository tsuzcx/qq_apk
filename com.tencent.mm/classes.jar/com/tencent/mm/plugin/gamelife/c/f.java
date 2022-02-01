package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.gamelife.b.r;
import com.tencent.mm.plugin.gamelife.b.s;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiSetChatSessionData;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/SetChatSessionDataResponse;", "sessionId", "", "flagMask", "", "switch", "", "(Ljava/lang/String;JZ)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class f
  extends c<s>
{
  private static final String TAG = "MicroMsg.CgiSetChatSessionData";
  public static final a ybz;
  
  static
  {
    AppMethodBeat.i(241288);
    ybz = new a((byte)0);
    TAG = "MicroMsg.CgiSetChatSessionData";
    AppMethodBeat.o(241288);
  }
  
  public f(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(241287);
    d.a locala = new d.a();
    r localr = new r();
    localr.session_id = paramString;
    localr.ybs = paramLong;
    localr.yaY = paramBoolean;
    locala.c((a)localr);
    locala.d((a)new s());
    locala.MB("/cgi-bin/mmgame-bin/gamegamelifeappsvr/setchatsessiondata");
    locala.sG(1910);
    c(locala.aXF());
    AppMethodBeat.o(241287);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiSetChatSessionData$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.f
 * JD-Core Version:    0.7.0.1
 */