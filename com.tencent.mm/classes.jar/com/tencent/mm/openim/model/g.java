package com.tencent.mm.openim.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.lb;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.coj;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.dxc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.by;

public final class g
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private final String hMM;
  private final c rr;
  
  public g(String paramString)
  {
    AppMethodBeat.i(151190);
    c.a locala = new c.a();
    locala.otE = new coj();
    locala.otF = new cok();
    locala.uri = "/cgi-bin/micromsg-bin/getopenimchatroomcontact";
    locala.funcId = 407;
    this.rr = locala.bEF();
    this.hMM = paramString;
    ((coj)c.b.b(this.rr.otB)).pss = paramString;
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatRoomContact", "get roomname:%s", new Object[] { paramString });
    AppMethodBeat.o(151190);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(151192);
    this.callback = paramh;
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
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatRoomContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.hMM });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (cok)c.c.b(((c)params).otC);
      if (params.aavA != null)
      {
        params = params.aavA;
        com.tencent.mm.openim.room.a.a.a(params, params.abcX, params.abcX);
      }
    }
    try
    {
      boolean bool1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().Te(params.pss);
      boolean bool2 = ((com.tencent.mm.plugin.chatroom.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.a.class)).Iq(params.pss);
      Log.i("OpenIMChatRoomContactLogic", "updateChatroomContactByGetRoomContact chatroom:%s isExistConversation:%s isNeedUpdateChatRoomInfo:%s", new Object[] { params.pss, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (bool2))
      {
        paramArrayOfByte = new lb();
        paramArrayOfByte.hML.hMM = params.pss;
        paramArrayOfByte.publish();
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        Log.e("OpenIMChatRoomContactLogic", "updateChatroomContactByGetRoomContact chatroom:%s, exception:%s %s", new Object[] { params.pss, paramArrayOfByte.getClass().getSimpleName(), paramArrayOfByte.getMessage() });
      }
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.model.g
 * JD-Core Version:    0.7.0.1
 */