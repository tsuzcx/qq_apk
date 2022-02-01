package com.tencent.mm.plugin.game.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.autogen.chatroom.GetMoreChatroomRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.GetMoreChatroomResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  public final c mtC;
  
  public h(String paramString, Lbs paramLbs)
  {
    AppMethodBeat.i(275792);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new GetMoreChatroomRequest();
    ((c.a)localObject).otF = new GetMoreChatroomResponse();
    ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/getmorechatroom";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (GetMoreChatroomRequest)c.b.b(this.mtC.otB);
    ((GetMoreChatroomRequest)localObject).chatroom_filter = paramString;
    if (paramLbs != null) {
      ((GetMoreChatroomRequest)localObject).lbs_info = paramLbs;
    }
    ((GetMoreChatroomRequest)localObject).limit = 10;
    AppMethodBeat.o(275792);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(275810);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
    AppMethodBeat.o(275810);
    return i;
  }
  
  public final int getType()
  {
    return 5048;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(275820);
    Log.i("GameChatRoom.CgiGetMoreChatRoom", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(275820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.h
 * JD-Core Version:    0.7.0.1
 */