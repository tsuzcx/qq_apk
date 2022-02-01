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
import com.tencent.mm.plugin.game.autogen.chatroom.EnterChatroomRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.EnterChatroomResponse;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends p
  implements m
{
  private h callback;
  private final c mtC;
  
  public b(String paramString)
  {
    AppMethodBeat.i(275833);
    c.a locala = new c.a();
    locala.otE = new EnterChatroomRequest();
    locala.otF = new EnterChatroomResponse();
    locala.uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/enterchatroom";
    locala.funcId = getType();
    locala.otG = 0;
    locala.respCmdId = 0;
    this.mtC = locala.bEF();
    ((EnterChatroomRequest)c.b.b(this.mtC.otB)).chatroom_name = paramString;
    AppMethodBeat.o(275833);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(275850);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
    AppMethodBeat.o(275850);
    return i;
  }
  
  public final int getType()
  {
    return 4593;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(275857);
    Log.i("GameChatRoom.CgiEnterChatRoom", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(275857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.b
 * JD-Core Version:    0.7.0.1
 */