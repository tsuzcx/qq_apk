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
import com.tencent.mm.plugin.game.autogen.chatroom.BlockChatroomMsgRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.BlockChatroomMsgResponse;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends p
  implements m
{
  private h callback;
  private final c mtC;
  
  public a(String paramString, long paramLong)
  {
    AppMethodBeat.i(275825);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new BlockChatroomMsgRequest();
    ((c.a)localObject).otF = new BlockChatroomMsgResponse();
    ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/blockchatroommsg";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (BlockChatroomMsgRequest)c.b.b(this.mtC.otB);
    ((BlockChatroomMsgRequest)localObject).chatroom_name = paramString;
    ((BlockChatroomMsgRequest)localObject).seq = paramLong;
    AppMethodBeat.o(275825);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(275838);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
    AppMethodBeat.o(275838);
    return i;
  }
  
  public final int getType()
  {
    return 4516;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(275848);
    Log.i("GameChatRoom.CgiBlockChatRoomMsg", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(275848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.a
 * JD-Core Version:    0.7.0.1
 */