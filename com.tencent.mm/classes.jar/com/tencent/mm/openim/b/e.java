package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.il;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bas;
import com.tencent.mm.protocal.protobuf.bat;
import com.tencent.mm.protocal.protobuf.bzy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bk;

public final class e
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.g callback;
  private final String djF;
  private final com.tencent.mm.ak.b rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(151190);
    b.a locala = new b.a();
    locala.hvt = new bas();
    locala.hvu = new bat();
    locala.uri = "/cgi-bin/micromsg-bin/getopenimchatroomcontact";
    locala.funcId = 407;
    this.rr = locala.aAz();
    this.djF = paramString;
    ((bas)this.rr.hvr.hvw).ioe = paramString;
    ac.i("MicroMsg.Openim.NetSceneGetOpenIMChatRoomContact", "get roomname:%s", new Object[] { paramString });
    AppMethodBeat.o(151190);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(151192);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(151192);
    return i;
  }
  
  public final int getType()
  {
    return 407;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151191);
    ac.i("MicroMsg.Openim.NetSceneGetOpenIMChatRoomContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.djF });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bat)((com.tencent.mm.ak.b)paramq).hvs.hvw;
      if (paramq.ERD != null)
      {
        paramq = paramq.ERD;
        com.tencent.mm.openim.room.a.a.a(paramq, paramq.FoO, paramq.FoO);
      }
    }
    try
    {
      boolean bool1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().Gt(paramq.ioe);
      boolean bool2 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.b.class)).GN(paramq.ioe);
      ac.i("OpenIMChatRoomContactLogic", "updateChatroomContactByGetRoomContact chatroom:%s isExistConversation:%s isNeedUpdateChatRoomInfo:%s", new Object[] { paramq.ioe, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (bool2))
      {
        paramArrayOfByte = new il();
        paramArrayOfByte.djE.djF = paramq.ioe;
        com.tencent.mm.sdk.b.a.GpY.l(paramArrayOfByte);
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        ac.e("OpenIMChatRoomContactLogic", "updateChatroomContactByGetRoomContact chatroom:%s, exception:%s %s", new Object[] { paramq.ioe, paramArrayOfByte.getClass().getSimpleName(), paramArrayOfByte.getMessage() });
      }
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.e
 * JD-Core Version:    0.7.0.1
 */