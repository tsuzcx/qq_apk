package com.tencent.mm.plugin.game.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.bl;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.game.autogen.chatroom.UserConfirmStatusRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.UserConfirmStatusResponse;
import com.tencent.mm.sdk.platformtools.Log;

public final class s
  extends p
  implements m
{
  private h callback;
  private final c mtC;
  
  public s(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(275777);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new UserConfirmStatusRequest();
    ((c.a)localObject).otF = new UserConfirmStatusResponse();
    ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/userconfirmstatus";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (UserConfirmStatusRequest)c.b.b(this.mtC.otB);
    ((UserConfirmStatusRequest)localObject).chatroom_name = paramString;
    ((UserConfirmStatusRequest)localObject).confirm_status = paramInt;
    ((UserConfirmStatusRequest)localObject).notification_id = paramLong;
    Log.i("GameChatRoom.CgiUserConfirmStatus", "chatRoomName:%s, status:%d, id:%d", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    AppMethodBeat.o(275777);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(275791);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
    AppMethodBeat.o(275791);
    return i;
  }
  
  public final int getType()
  {
    return 4530;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(275804);
    Log.i("GameChatRoom.CgiUserConfirmStatus", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (UserConfirmStatusRequest)c.b.b(this.mtC.otB);
      if (params.confirm_status == 1)
      {
        paramArrayOfByte = new bl();
        paramArrayOfByte.hBx.opType = 2;
        paramArrayOfByte.hBx.hBy = params.chatroom_name;
        paramArrayOfByte.publish();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(275804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.s
 * JD-Core Version:    0.7.0.1
 */