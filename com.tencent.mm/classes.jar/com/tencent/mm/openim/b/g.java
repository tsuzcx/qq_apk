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
import com.tencent.mm.protocal.protobuf.bfa;
import com.tencent.mm.protocal.protobuf.bfb;
import com.tencent.mm.sdk.platformtools.ad;

public final class g
  extends n
  implements k
{
  private f callback;
  private final String dvs;
  private final b rr;
  
  public g(String paramString)
  {
    AppMethodBeat.i(151196);
    b.a locala = new b.a();
    locala.hNM = new bfa();
    locala.hNN = new bfb();
    locala.uri = "/cgi-bin/micromsg-bin/getopenimchatroomqrcode";
    locala.funcId = 890;
    this.rr = locala.aDC();
    this.dvs = paramString;
    ((bfa)this.rr.hNK.hNQ).iHB = paramString;
    ad.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomQRCode", "get roomname:%s", new Object[] { paramString });
    AppMethodBeat.o(151196);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(151198);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(151198);
    return i;
  }
  
  public final int getType()
  {
    return 890;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151197);
    ad.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomQRCode", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.dvs });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.g
 * JD-Core Version:    0.7.0.1
 */