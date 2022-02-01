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
import com.tencent.mm.plugin.game.autogen.chatroom.SetChatroomMsgChosenRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.SetChatroomMsgChosenResponse;
import com.tencent.mm.sdk.platformtools.Log;

public final class q
  extends p
  implements m
{
  private h callback;
  public final c mtC;
  
  public q(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(275780);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new SetChatroomMsgChosenRequest();
    ((c.a)localObject).otF = new SetChatroomMsgChosenResponse();
    ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/setchatroommsgchosen";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (SetChatroomMsgChosenRequest)c.b.b(this.mtC.otB);
    ((SetChatroomMsgChosenRequest)localObject).chatroom_name = paramString;
    ((SetChatroomMsgChosenRequest)localObject).seq = paramLong;
    ((SetChatroomMsgChosenRequest)localObject).is_chosen = paramBoolean;
    AppMethodBeat.o(275780);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(275796);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
    AppMethodBeat.o(275796);
    return i;
  }
  
  public final int getType()
  {
    return 4383;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(275805);
    Log.i("GameChatRoom.CgiSetChatroomMsgChosen", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(275805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.q
 * JD-Core Version:    0.7.0.1
 */