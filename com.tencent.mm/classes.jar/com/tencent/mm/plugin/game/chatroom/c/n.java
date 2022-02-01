package com.tencent.mm.plugin.game.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.autogen.chatroom.LeaveChatroomRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.LeaveChatroomResponse;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends p
  implements m
{
  private h callback;
  private final c mtC;
  
  public n(String paramString)
  {
    AppMethodBeat.i(275801);
    c.a locala = new c.a();
    locala.otE = new LeaveChatroomRequest();
    locala.otF = new LeaveChatroomResponse();
    locala.uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/leavechatroom";
    locala.funcId = getType();
    locala.otG = 0;
    locala.respCmdId = 0;
    this.mtC = locala.bEF();
    ((LeaveChatroomRequest)c.b.b(this.mtC.otB)).chatroom_name = paramString;
    AppMethodBeat.o(275801);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(275815);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
    AppMethodBeat.o(275815);
    return i;
  }
  
  public final int getType()
  {
    return 4979;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(275824);
    Log.i("GameChatRoom.CgiLeaveChatRoom", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(275824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.n
 * JD-Core Version:    0.7.0.1
 */