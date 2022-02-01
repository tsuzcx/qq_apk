package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.gamelife.b.h;
import com.tencent.mm.plugin.gamelife.b.i;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatSessionId;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionIdResponse;", "fromUserName", "", "toUserName", "scene", "", "extInfo", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protobuf/ByteString;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class c
  extends com.tencent.mm.ak.c<i>
{
  private static final String TAG = "MicroMsg.CgiGetChatSessionId";
  public static final a ybw;
  
  static
  {
    AppMethodBeat.i(241279);
    ybw = new a((byte)0);
    TAG = "MicroMsg.CgiGetChatSessionId";
    AppMethodBeat.o(241279);
  }
  
  public c(String paramString1, String paramString2, int paramInt, b paramb)
  {
    AppMethodBeat.i(241278);
    d.a locala = new d.a();
    h localh = new h();
    localh.pPy = paramString1;
    localh.pPz = paramString2;
    localh.scene = paramInt;
    localh.ybi = paramb;
    locala.c((a)localh);
    locala.d((a)new i());
    Log.i(TAG, "fromUserName[" + localh.pPy + "], toUserName[" + localh.pPz + "], scene[" + localh.scene + "], extInfo[" + localh.ybi + ']');
    locala.MB("/cgi-bin/mmgame-bin/gamegamelifeappsvr/getchatsessionid");
    locala.sG(1103);
    c(locala.aXF());
    AppMethodBeat.o(241278);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatSessionId$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.c
 * JD-Core Version:    0.7.0.1
 */