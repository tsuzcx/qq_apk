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
import com.tencent.mm.plugin.game.autogen.chatroom.GetMoreChatroomRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.GetMoreChatroomResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  extends q
  implements m
{
  private i callback;
  public final d jTk;
  
  public f(String paramString, Lbs paramLbs)
  {
    AppMethodBeat.i(210976);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new GetMoreChatroomRequest();
    ((d.a)localObject).lBV = new GetMoreChatroomResponse();
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/getmorechatroom";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.jTk = ((d.a)localObject).bgN();
    localObject = (GetMoreChatroomRequest)d.b.b(this.jTk.lBR);
    ((GetMoreChatroomRequest)localObject).chatroom_filter = paramString;
    if (paramLbs != null) {
      ((GetMoreChatroomRequest)localObject).lbs_info = paramLbs;
    }
    ((GetMoreChatroomRequest)localObject).limit = 10;
    AppMethodBeat.o(210976);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(210978);
    this.callback = parami;
    int i = dispatch(paramg, this.jTk, this);
    AppMethodBeat.o(210978);
    return i;
  }
  
  public final int getType()
  {
    return 5048;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(210979);
    Log.i("GameChatRoom.CgiGetMoreChatRoom", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(210979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.f
 * JD-Core Version:    0.7.0.1
 */