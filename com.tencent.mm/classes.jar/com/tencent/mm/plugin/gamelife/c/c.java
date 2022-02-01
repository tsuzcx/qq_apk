package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.gamelife.b.h;
import com.tencent.mm.plugin.gamelife.b.i;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatSessionId;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionIdResponse;", "fromUserName", "", "toUserName", "scene", "", "extInfo", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protobuf/ByteString;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.am.b<i>
{
  public static final a JaV;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(268220);
    JaV = new a((byte)0);
    TAG = "MicroMsg.CgiGetChatSessionId";
    AppMethodBeat.o(268220);
  }
  
  public c(String paramString1, String paramString2, int paramInt, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(268207);
    com.tencent.mm.am.c.a locala = new com.tencent.mm.am.c.a();
    h localh = new h();
    localh.from_username = paramString1;
    localh.waL = paramString2;
    localh.scene = paramInt;
    localh.JaK = paramb;
    locala.otE = ((a)localh);
    locala.otF = ((a)new i());
    Log.i(TAG, "fromUserName[" + localh.from_username + "], toUserName[" + localh.waL + "], scene[" + localh.scene + "], extInfo[" + localh.JaK + ']');
    locala.uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/getchatsessionid";
    locala.funcId = 1103;
    c(locala.bEF());
    AppMethodBeat.o(268207);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatSessionId$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.c
 * JD-Core Version:    0.7.0.1
 */