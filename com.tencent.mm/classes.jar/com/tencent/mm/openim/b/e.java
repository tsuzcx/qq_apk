package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.jj;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.openim.room.a.a;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bri;
import com.tencent.mm.protocal.protobuf.brj;
import com.tencent.mm.protocal.protobuf.cvq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bw;

public final class e
  extends q
  implements m
{
  private i callback;
  private final String dOe;
  private final d rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(151190);
    d.a locala = new d.a();
    locala.iLN = new bri();
    locala.iLO = new brj();
    locala.uri = "/cgi-bin/micromsg-bin/getopenimchatroomcontact";
    locala.funcId = 407;
    this.rr = locala.aXF();
    this.dOe = paramString;
    ((bri)this.rr.iLK.iLR).jHa = paramString;
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatRoomContact", "get roomname:%s", new Object[] { paramString });
    AppMethodBeat.o(151190);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(151192);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151192);
    return i;
  }
  
  public final int getType()
  {
    return 407;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151191);
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatRoomContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.dOe });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (brj)((d)params).iLL.iLR;
      if (params.LYN != null)
      {
        params = params.LYN;
        a.a(params, params.MAZ, params.MAZ);
      }
    }
    try
    {
      boolean bool1 = ((l)com.tencent.mm.kernel.g.af(l.class)).aST().Tf(params.jHa);
      boolean bool2 = ((b)com.tencent.mm.kernel.g.af(b.class)).Ih(params.jHa);
      Log.i("OpenIMChatRoomContactLogic", "updateChatroomContactByGetRoomContact chatroom:%s isExistConversation:%s isNeedUpdateChatRoomInfo:%s", new Object[] { params.jHa, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (bool2))
      {
        paramArrayOfByte = new jj();
        paramArrayOfByte.dOd.dOe = params.jHa;
        EventCenter.instance.publish(paramArrayOfByte);
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        Log.e("OpenIMChatRoomContactLogic", "updateChatroomContactByGetRoomContact chatroom:%s, exception:%s %s", new Object[] { params.jHa, paramArrayOfByte.getClass().getSimpleName(), paramArrayOfByte.getMessage() });
      }
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.b.e
 * JD-Core Version:    0.7.0.1
 */