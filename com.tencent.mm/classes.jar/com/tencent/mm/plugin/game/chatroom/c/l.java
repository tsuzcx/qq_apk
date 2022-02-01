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
import com.tencent.mm.plugin.game.autogen.chatroom.ReceiveChatroomMsgRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.ReceiveChatroomMsgResponse;

public final class l
  extends q
  implements m
{
  private i callback;
  public final d jTk;
  public int mInstanceId;
  
  public l(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(210803);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ReceiveChatroomMsgRequest();
    ((d.a)localObject).lBV = new ReceiveChatroomMsgResponse();
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/receivechatroommsg";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    ((d.a)localObject).longPolling = true;
    ((d.a)localObject).longPollingTimeout = 25000;
    this.mInstanceId = paramInt;
    this.jTk = ((d.a)localObject).bgN();
    localObject = (ReceiveChatroomMsgRequest)d.b.b(this.jTk.lBR);
    ((ReceiveChatroomMsgRequest)localObject).chatroom_name = paramString;
    ((ReceiveChatroomMsgRequest)localObject).seq = paramLong;
    AppMethodBeat.o(210803);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(210804);
    this.callback = parami;
    int i = dispatch(paramg, this.jTk, this);
    AppMethodBeat.o(210804);
    return i;
  }
  
  public final int getType()
  {
    return 4302;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(210805);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(210805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.l
 * JD-Core Version:    0.7.0.1
 */