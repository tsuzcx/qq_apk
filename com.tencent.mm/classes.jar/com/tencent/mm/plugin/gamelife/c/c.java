package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.gamelife.b.h;
import com.tencent.mm.plugin.gamelife.b.i;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatSessionId;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionIdResponse;", "fromUserName", "", "toUserName", "scene", "", "extInfo", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protobuf/ByteString;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class c
  extends com.tencent.mm.an.c<i>
{
  public static final a Dhb;
  private static final String TAG = "MicroMsg.CgiGetChatSessionId";
  
  static
  {
    AppMethodBeat.i(203306);
    Dhb = new a((byte)0);
    TAG = "MicroMsg.CgiGetChatSessionId";
    AppMethodBeat.o(203306);
  }
  
  public c(String paramString1, String paramString2, int paramInt, b paramb)
  {
    AppMethodBeat.i(203304);
    d.a locala = new d.a();
    h localh = new h();
    localh.from_username = paramString1;
    localh.sWA = paramString2;
    localh.scene = paramInt;
    localh.DgQ = paramb;
    locala.c((a)localh);
    locala.d((a)new i());
    Log.i(TAG, "fromUserName[" + localh.from_username + "], toUserName[" + localh.sWA + "], scene[" + localh.scene + "], extInfo[" + localh.DgQ + ']');
    locala.TW("/cgi-bin/mmgame-bin/gamegamelifeappsvr/getchatsessionid");
    locala.vD(1103);
    c(locala.bgN());
    AppMethodBeat.o(203304);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatSessionId$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.c
 * JD-Core Version:    0.7.0.1
 */