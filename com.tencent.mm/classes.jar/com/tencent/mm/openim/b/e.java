package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.it;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bew;
import com.tencent.mm.protocal.protobuf.bex;
import com.tencent.mm.protocal.protobuf.cep;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bq;

public final class e
  extends n
  implements k
{
  private f callback;
  private final String dvs;
  private final com.tencent.mm.al.b rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(151190);
    b.a locala = new b.a();
    locala.hNM = new bew();
    locala.hNN = new bex();
    locala.uri = "/cgi-bin/micromsg-bin/getopenimchatroomcontact";
    locala.funcId = 407;
    this.rr = locala.aDC();
    this.dvs = paramString;
    ((bew)this.rr.hNK.hNQ).iHB = paramString;
    ad.i("MicroMsg.Openim.NetSceneGetOpenIMChatRoomContact", "get roomname:%s", new Object[] { paramString });
    AppMethodBeat.o(151190);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(151192);
    this.callback = paramf;
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
    ad.i("MicroMsg.Openim.NetSceneGetOpenIMChatRoomContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.dvs });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bex)((com.tencent.mm.al.b)paramq).hNL.hNQ;
      if (paramq.GAV != null)
      {
        paramq = paramq.GAV;
        com.tencent.mm.openim.room.a.a.a(paramq, paramq.GYA, paramq.GYA);
      }
    }
    try
    {
      boolean bool1 = ((l)g.ab(l.class)).azv().JI(paramq.iHB);
      boolean bool2 = ((com.tencent.mm.plugin.chatroom.a.b)g.ab(com.tencent.mm.plugin.chatroom.a.b.class)).yV(paramq.iHB);
      ad.i("OpenIMChatRoomContactLogic", "updateChatroomContactByGetRoomContact chatroom:%s isExistConversation:%s isNeedUpdateChatRoomInfo:%s", new Object[] { paramq.iHB, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (bool2))
      {
        paramArrayOfByte = new it();
        paramArrayOfByte.dvr.dvs = paramq.iHB;
        com.tencent.mm.sdk.b.a.IbL.l(paramArrayOfByte);
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        ad.e("OpenIMChatRoomContactLogic", "updateChatroomContactByGetRoomContact chatroom:%s, exception:%s %s", new Object[] { paramq.iHB, paramArrayOfByte.getClass().getSimpleName(), paramArrayOfByte.getMessage() });
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