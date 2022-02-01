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
import com.tencent.mm.plugin.game.autogen.chatroom.GetCanJoinChatroomRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.GetCanJoinChatroomResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  extends q
  implements m
{
  private i callback;
  public final d jTk;
  
  public h(Lbs paramLbs)
  {
    AppMethodBeat.i(210784);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new GetCanJoinChatroomRequest();
    ((d.a)localObject).lBV = new GetCanJoinChatroomResponse();
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/getcanjoinchatroom";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.jTk = ((d.a)localObject).bgN();
    localObject = (GetCanJoinChatroomRequest)d.b.b(this.jTk.lBR);
    if (paramLbs != null) {
      ((GetCanJoinChatroomRequest)localObject).lbs_info = paramLbs;
    }
    AppMethodBeat.o(210784);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(210785);
    this.callback = parami;
    int i = dispatch(paramg, this.jTk, this);
    AppMethodBeat.o(210785);
    return i;
  }
  
  public final int getType()
  {
    return 4631;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(210786);
    Log.i("GameChatRoom.CgiGetRecommendChatRoom", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(210786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.h
 * JD-Core Version:    0.7.0.1
 */