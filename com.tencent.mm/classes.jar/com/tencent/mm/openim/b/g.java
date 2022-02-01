package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bax;
import com.tencent.mm.sdk.platformtools.ac;

public final class g
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private final String djF;
  private final b rr;
  
  public g(String paramString)
  {
    AppMethodBeat.i(151196);
    b.a locala = new b.a();
    locala.hvt = new baw();
    locala.hvu = new bax();
    locala.uri = "/cgi-bin/micromsg-bin/getopenimchatroomqrcode";
    locala.funcId = 890;
    this.rr = locala.aAz();
    this.djF = paramString;
    ((baw)this.rr.hvr.hvw).ioe = paramString;
    ac.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomQRCode", "get roomname:%s", new Object[] { paramString });
    AppMethodBeat.o(151196);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(151198);
    this.callback = paramg;
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
    ac.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomQRCode", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.djF });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.g
 * JD-Core Version:    0.7.0.1
 */