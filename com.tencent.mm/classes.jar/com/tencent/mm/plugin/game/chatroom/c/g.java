package com.tencent.mm.plugin.game.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.autogen.chatroom.GetMyChatroomRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.GetMyChatroomResponse;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class g
  extends q
  implements m
{
  private i callback;
  public final d jTk;
  public int mInstanceId;
  
  public g(List<String> paramList, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(211032);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new GetMyChatroomRequest();
    ((d.a)localObject).lBV = new GetMyChatroomResponse();
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/getmychatroom";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    ((d.a)localObject).longPolling = true;
    ((d.a)localObject).longPollingTimeout = 25000;
    this.mInstanceId = paramInt;
    this.jTk = ((d.a)localObject).bgN();
    localObject = (GetMyChatroomRequest)d.b.b(this.jTk.lBR);
    Util.isNullOrNil(paramList);
    ((GetMyChatroomRequest)localObject).first_chatroom_name = paramString1;
    ((GetMyChatroomRequest)localObject).version = paramString2;
    AppMethodBeat.o(211032);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(211033);
    this.callback = parami;
    int i = dispatch(paramg, this.jTk, this);
    AppMethodBeat.o(211033);
    return i;
  }
  
  public final int getType()
  {
    return 4989;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(211034);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(211034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.g
 * JD-Core Version:    0.7.0.1
 */