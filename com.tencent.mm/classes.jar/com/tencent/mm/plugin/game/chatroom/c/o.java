package com.tencent.mm.plugin.game.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.bf;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.autogen.chatroom.UserConfirmStatusRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.UserConfirmStatusResponse;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
  extends q
  implements m
{
  private i callback;
  private final d jTk;
  
  public o(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(211947);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new UserConfirmStatusRequest();
    ((d.a)localObject).lBV = new UserConfirmStatusResponse();
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/userconfirmstatus";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.jTk = ((d.a)localObject).bgN();
    localObject = (UserConfirmStatusRequest)d.b.b(this.jTk.lBR);
    ((UserConfirmStatusRequest)localObject).chatroom_name = paramString;
    ((UserConfirmStatusRequest)localObject).confirm_status = paramInt;
    ((UserConfirmStatusRequest)localObject).notification_id = paramLong;
    Log.i("GameChatRoom.CgiUserConfirmStatus", "chatRoomName:%s, status:%d, id:%d", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    AppMethodBeat.o(211947);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(211950);
    this.callback = parami;
    int i = dispatch(paramg, this.jTk, this);
    AppMethodBeat.o(211950);
    return i;
  }
  
  public final int getType()
  {
    return 4530;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(211951);
    Log.i("GameChatRoom.CgiUserConfirmStatus", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (UserConfirmStatusRequest)d.b.b(this.jTk.lBR);
      if (params.confirm_status == 1)
      {
        paramArrayOfByte = new bf();
        paramArrayOfByte.fwX.opType = 2;
        paramArrayOfByte.fwX.fwY = params.chatroom_name;
        EventCenter.instance.publish(paramArrayOfByte);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(211951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.o
 * JD-Core Version:    0.7.0.1
 */