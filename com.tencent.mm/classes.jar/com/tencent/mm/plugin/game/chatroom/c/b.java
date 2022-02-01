package com.tencent.mm.plugin.game.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomBaseInfoRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomBaseInfoResponse;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  private i callback;
  public final d jTk;
  
  public b(String paramString)
  {
    AppMethodBeat.i(210564);
    d.a locala = new d.a();
    locala.lBU = new GetChatroomBaseInfoRequest();
    locala.lBV = new GetChatroomBaseInfoResponse();
    locala.uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/getchatroombaseinfo";
    locala.funcId = getType();
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.jTk = locala.bgN();
    ((GetChatroomBaseInfoRequest)d.b.b(this.jTk.lBR)).chatroom_name = paramString;
    AppMethodBeat.o(210564);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(210565);
    this.callback = parami;
    int i = dispatch(paramg, this.jTk, this);
    AppMethodBeat.o(210565);
    return i;
  }
  
  public final int getType()
  {
    return 4391;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(210566);
    Log.i("GameChatRoom.CgiGetChatRoomBaseInfo", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(210566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.b
 * JD-Core Version:    0.7.0.1
 */