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
import com.tencent.mm.plugin.game.autogen.chatroom.ReceiveChatroomMsgRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.ReceiveChatroomMsgResponse;

public final class o
  extends p
  implements m
{
  public int DD;
  private h callback;
  public final c mtC;
  
  public o(String paramString1, long paramLong, String paramString2, int paramInt)
  {
    AppMethodBeat.i(275807);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ReceiveChatroomMsgRequest();
    ((c.a)localObject).otF = new ReceiveChatroomMsgResponse();
    ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/receivechatroommsg";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    ((c.a)localObject).longPolling = true;
    ((c.a)localObject).longPollingTimeout = 25000;
    this.DD = paramInt;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (ReceiveChatroomMsgRequest)c.b.b(this.mtC.otB);
    ((ReceiveChatroomMsgRequest)localObject).chatroom_name = paramString1;
    ((ReceiveChatroomMsgRequest)localObject).seq = paramLong;
    ((ReceiveChatroomMsgRequest)localObject).version = paramString2;
    AppMethodBeat.o(275807);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(275821);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
    AppMethodBeat.o(275821);
    return i;
  }
  
  public final int getType()
  {
    return 4302;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(275828);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(275828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.o
 * JD-Core Version:    0.7.0.1
 */