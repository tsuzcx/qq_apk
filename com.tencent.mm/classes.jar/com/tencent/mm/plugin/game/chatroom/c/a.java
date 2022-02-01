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
import com.tencent.mm.plugin.game.autogen.chatroom.EnterChatroomRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.EnterChatroomResponse;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q
  implements m
{
  private i callback;
  private final d jTk;
  
  public a(String paramString)
  {
    AppMethodBeat.i(212439);
    d.a locala = new d.a();
    locala.lBU = new EnterChatroomRequest();
    locala.lBV = new EnterChatroomResponse();
    locala.uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/enterchatroom";
    locala.funcId = getType();
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.jTk = locala.bgN();
    ((EnterChatroomRequest)d.b.b(this.jTk.lBR)).chatroom_name = paramString;
    AppMethodBeat.o(212439);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(212443);
    this.callback = parami;
    int i = dispatch(paramg, this.jTk, this);
    AppMethodBeat.o(212443);
    return i;
  }
  
  public final int getType()
  {
    return 4593;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212445);
    Log.i("GameChatRoom.CgiEnterChatRoom", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(212445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.a
 * JD-Core Version:    0.7.0.1
 */