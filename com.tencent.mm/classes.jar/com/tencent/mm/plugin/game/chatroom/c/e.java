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
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomMsgRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomMsgResponse;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends p
  implements m
{
  public int Ijd;
  public long Ije;
  private h callback;
  public final c mtC;
  
  public e(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2)
  {
    AppMethodBeat.i(275842);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new GetChatroomMsgRequest();
    ((c.a)localObject).otF = new GetChatroomMsgResponse();
    ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/getchatroommsg";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (GetChatroomMsgRequest)c.b.b(this.mtC.otB);
    ((GetChatroomMsgRequest)localObject).chatroom_name = paramString;
    if (paramLong1 > 0L) {
      ((GetChatroomMsgRequest)localObject).seq_gt = paramLong1;
    }
    for (;;)
    {
      ((GetChatroomMsgRequest)localObject).channel_id = paramInt2;
      this.Ijd = paramInt1;
      this.Ije = paramLong3;
      Log.i("GameChatRoom.CgiGetChatRoomMsg", "gtSeq:%d, ltSeq:%d, channelId:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(275842);
      return;
      if (paramLong2 > 0L) {
        ((GetChatroomMsgRequest)localObject).seq_lt = paramLong2;
      }
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(275860);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
    AppMethodBeat.o(275860);
    return i;
  }
  
  public final GetChatroomMsgRequest fCA()
  {
    AppMethodBeat.i(275874);
    GetChatroomMsgRequest localGetChatroomMsgRequest = (GetChatroomMsgRequest)c.b.b(this.mtC.otB);
    AppMethodBeat.o(275874);
    return localGetChatroomMsgRequest;
  }
  
  public final int getType()
  {
    return 4562;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(275868);
    Log.i("GameChatRoom.CgiGetChatRoomMsg", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(275868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.e
 * JD-Core Version:    0.7.0.1
 */