package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.cvz;
import com.tencent.mm.sdk.platformtools.ad;

public final class m
  extends n
  implements k
{
  private f callback;
  private final String dvs;
  private final b rr;
  
  public m(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151212);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cvy();
    ((b.a)localObject).hNN = new cvz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/revokeopenimchatroomqrcode";
    ((b.a)localObject).funcId = 772;
    this.rr = ((b.a)localObject).aDC();
    this.dvs = paramString1;
    localObject = (cvy)this.rr.hNK.hNQ;
    ((cvy)localObject).dvs = paramString1;
    ((cvy)localObject).dAD = paramString2;
    ad.i("MicroMsg.Openim.NetSceneRevokeOpenIMChatRoomQRCode", "get roomname:%s, qrcode:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(151212);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(151214);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(151214);
    return i;
  }
  
  public final int getType()
  {
    return 772;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151213);
    ad.i("MicroMsg.Openim.NetSceneRevokeOpenIMChatRoomQRCode", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.dvs });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.m
 * JD-Core Version:    0.7.0.1
 */