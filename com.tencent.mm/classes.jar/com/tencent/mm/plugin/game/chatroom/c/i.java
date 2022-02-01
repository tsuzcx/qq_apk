package com.tencent.mm.plugin.game.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.autogen.chatroom.GetMyChatroomRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.GetMyChatroomResponse;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class i
  extends p
  implements m
{
  public int DD;
  private h callback;
  public final c mtC;
  
  public i(List<String> paramList, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(275795);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new GetMyChatroomRequest();
    ((c.a)localObject).otF = new GetMyChatroomResponse();
    ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/getmychatroom";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    ((c.a)localObject).longPolling = true;
    ((c.a)localObject).longPollingTimeout = 25000;
    this.DD = paramInt2;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (GetMyChatroomRequest)c.b.b(this.mtC.otB);
    Util.isNullOrNil(paramList);
    ((GetMyChatroomRequest)localObject).first_chatroom_name = paramString1;
    ((GetMyChatroomRequest)localObject).version = paramString2;
    ((GetMyChatroomRequest)localObject).scene_type = paramInt1;
    Log.i("GameChatRoom.CgiGetMyChatRoom", "request params, version:%s, scene:%d", new Object[] { paramString2, Integer.valueOf(paramInt1) });
    AppMethodBeat.o(275795);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(275812);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
    AppMethodBeat.o(275812);
    return i;
  }
  
  public final GetMyChatroomResponse fCB()
  {
    AppMethodBeat.i(275826);
    GetMyChatroomResponse localGetMyChatroomResponse = (GetMyChatroomResponse)c.c.b(this.mtC.otC);
    AppMethodBeat.o(275826);
    return localGetMyChatroomResponse;
  }
  
  public final int getType()
  {
    return 4989;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(275817);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(275817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.i
 * JD-Core Version:    0.7.0.1
 */