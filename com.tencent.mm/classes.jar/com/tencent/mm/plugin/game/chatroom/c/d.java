package com.tencent.mm.plugin.game.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomMsgRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomMsgResponse;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends q
  implements m
{
  public int Cuw;
  private i callback;
  public final com.tencent.mm.an.d jTk;
  
  public d(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(210808);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new GetChatroomMsgRequest();
    ((d.a)localObject).lBV = new GetChatroomMsgResponse();
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/getchatroommsg";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.jTk = ((d.a)localObject).bgN();
    localObject = (GetChatroomMsgRequest)d.b.b(this.jTk.lBR);
    ((GetChatroomMsgRequest)localObject).chatroom_name = paramString;
    if (paramLong1 > 0L) {
      ((GetChatroomMsgRequest)localObject).seq_gt = paramLong1;
    }
    for (;;)
    {
      this.Cuw = paramInt;
      AppMethodBeat.o(210808);
      return;
      if (paramLong2 > 0L) {
        ((GetChatroomMsgRequest)localObject).seq_lt = paramLong2;
      }
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(210809);
    this.callback = parami;
    int i = dispatch(paramg, this.jTk, this);
    AppMethodBeat.o(210809);
    return i;
  }
  
  public final int getType()
  {
    return 4562;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(210810);
    Log.i("GameChatRoom.CgiGetChatRoomMsg", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(210810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.d
 * JD-Core Version:    0.7.0.1
 */