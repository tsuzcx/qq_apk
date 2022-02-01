package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.openim.room.a.a;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.protocal.protobuf.axb;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends n
  implements k
{
  private g callback;
  private final String dlX;
  private final b rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(151190);
    b.a locala = new b.a();
    locala.gUU = new axa();
    locala.gUV = new axb();
    locala.uri = "/cgi-bin/micromsg-bin/getopenimchatroomcontact";
    locala.funcId = 407;
    this.rr = locala.atI();
    this.dlX = paramString;
    ((axa)this.rr.gUS.gUX).hNI = paramString;
    ad.i("MicroMsg.Openim.NetSceneGetOpenIMChatRoomContact", "get roomname:%s", new Object[] { paramString });
    AppMethodBeat.o(151190);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
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
    ad.i("MicroMsg.Openim.NetSceneGetOpenIMChatRoomContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.dlX });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (axb)((b)paramq).gUT.gUX;
      if (paramq.Dwi != null) {
        a.b(paramq.Dwi);
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