package com.tencent.mm.plugin.game.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomRealtimeInfoRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomRealtimeInfoResponse;

public final class g
  extends p
  implements m
{
  public int DD;
  private h callback;
  public final c mtC;
  
  public g(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(275837);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new GetChatroomRealtimeInfoRequest();
    ((c.a)localObject).otF = new GetChatroomRealtimeInfoResponse();
    ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/getchatroomrealtimeinfo";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    ((c.a)localObject).longPolling = true;
    ((c.a)localObject).longPollingTimeout = 25000;
    this.DD = paramInt;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (GetChatroomRealtimeInfoRequest)c.b.b(this.mtC.otB);
    ((GetChatroomRealtimeInfoRequest)localObject).chatroom_name = paramString1;
    ((GetChatroomRealtimeInfoRequest)localObject).version = paramString2;
    AppMethodBeat.o(275837);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(275854);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
    AppMethodBeat.o(275854);
    return i;
  }
  
  public final int getType()
  {
    return 4316;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(275858);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(275858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.g
 * JD-Core Version:    0.7.0.1
 */