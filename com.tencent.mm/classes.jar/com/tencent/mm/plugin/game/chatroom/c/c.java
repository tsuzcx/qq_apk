package com.tencent.mm.plugin.game.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.game.autogen.chatroom.DebugOption;
import com.tencent.mm.plugin.game.autogen.chatroom.ExportExternInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomBaseInfoRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomBaseInfoResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends p
  implements m
{
  private h callback;
  public final com.tencent.mm.am.c mtC;
  
  public c(String paramString, Lbs paramLbs, ExportExternInfo paramExportExternInfo)
  {
    AppMethodBeat.i(275843);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new GetChatroomBaseInfoRequest();
    ((c.a)localObject).otF = new GetChatroomBaseInfoResponse();
    ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/getchatroombaseinfo";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (GetChatroomBaseInfoRequest)c.b.b(this.mtC.otB);
    ((GetChatroomBaseInfoRequest)localObject).chatroom_name = paramString;
    ((GetChatroomBaseInfoRequest)localObject).lbs_info = paramLbs;
    ((GetChatroomBaseInfoRequest)localObject).export_extern_info = paramExportExternInfo;
    if (z.pDv)
    {
      paramString = new DebugOption();
      paramString.need_debug = true;
      paramString.debug_info = "forceShowFirstEnterNotify";
      ((GetChatroomBaseInfoRequest)localObject).debug_option = paramString;
    }
    AppMethodBeat.o(275843);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(275859);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
    AppMethodBeat.o(275859);
    return i;
  }
  
  public final int getType()
  {
    return 4391;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(275867);
    Log.i("GameChatRoom.CgiGetChatRoomBaseInfo", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(275867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.c
 * JD-Core Version:    0.7.0.1
 */