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
import com.tencent.mm.plugin.game.autogen.chatroom.GetCanJoinChatroomRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.GetCanJoinChatroomResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  extends p
  implements m
{
  private h callback;
  public final c mtC;
  
  public j(Lbs paramLbs)
  {
    AppMethodBeat.i(275794);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new GetCanJoinChatroomRequest();
    ((c.a)localObject).otF = new GetCanJoinChatroomResponse();
    ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/getcanjoinchatroom";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (GetCanJoinChatroomRequest)c.b.b(this.mtC.otB);
    if (paramLbs != null) {
      ((GetCanJoinChatroomRequest)localObject).lbs_info = paramLbs;
    }
    AppMethodBeat.o(275794);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(275822);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
    AppMethodBeat.o(275822);
    return i;
  }
  
  public final int getType()
  {
    return 4631;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(275835);
    Log.i("GameChatRoom.CgiGetRecommendChatRoom", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(275835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.j
 * JD-Core Version:    0.7.0.1
 */