package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.iu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bfm;
import com.tencent.mm.protocal.protobuf.bfn;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.br;

public final class e
  extends n
  implements k
{
  private f callback;
  private final String dwx;
  private final com.tencent.mm.ak.b rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(151190);
    b.a locala = new b.a();
    locala.hQF = new bfm();
    locala.hQG = new bfn();
    locala.uri = "/cgi-bin/micromsg-bin/getopenimchatroomcontact";
    locala.funcId = 407;
    this.rr = locala.aDS();
    this.dwx = paramString;
    ((bfm)this.rr.hQD.hQJ).iKu = paramString;
    ae.i("MicroMsg.Openim.NetSceneGetOpenIMChatRoomContact", "get roomname:%s", new Object[] { paramString });
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
    ae.i("MicroMsg.Openim.NetSceneGetOpenIMChatRoomContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.dwx });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bfn)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
      if (paramq.GUv != null)
      {
        paramq = paramq.GUv;
        com.tencent.mm.openim.room.a.a.a(paramq, paramq.Hsb, paramq.Hsb);
      }
    }
    try
    {
      boolean bool1 = ((l)g.ab(l.class)).azL().Kh(paramq.iKu);
      boolean bool2 = ((com.tencent.mm.plugin.chatroom.a.b)g.ab(com.tencent.mm.plugin.chatroom.a.b.class)).zF(paramq.iKu);
      ae.i("OpenIMChatRoomContactLogic", "updateChatroomContactByGetRoomContact chatroom:%s isExistConversation:%s isNeedUpdateChatRoomInfo:%s", new Object[] { paramq.iKu, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (bool2))
      {
        paramArrayOfByte = new iu();
        paramArrayOfByte.dww.dwx = paramq.iKu;
        com.tencent.mm.sdk.b.a.IvT.l(paramArrayOfByte);
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        ae.e("OpenIMChatRoomContactLogic", "updateChatroomContactByGetRoomContact chatroom:%s, exception:%s %s", new Object[] { paramq.iKu, paramArrayOfByte.getClass().getSimpleName(), paramArrayOfByte.getMessage() });
      }
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.e
 * JD-Core Version:    0.7.0.1
 */