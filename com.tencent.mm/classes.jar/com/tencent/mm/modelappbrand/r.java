package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bie;
import com.tencent.mm.protocal.protobuf.bif;
import com.tencent.mm.sdk.platformtools.ad;

public final class r
  extends n
  implements k
{
  private f gzH;
  public final b hKw;
  
  public r(int paramInt)
  {
    AppMethodBeat.i(121056);
    b.a locala = new b.a();
    locala.hNM = new bie();
    locala.hNN = new bif();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getservicenotifyoptions";
    locala.funcId = getType();
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.hKw = locala.aDC();
    ((bie)this.hKw.hNK.hNQ).GDf = paramInt;
    AppMethodBeat.o(121056);
  }
  
  public final bif aDN()
  {
    return (bif)this.hKw.hNL.hNQ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(121058);
    ad.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
    this.gzH = paramf;
    int i = dispatch(parame, this.hKw, this);
    AppMethodBeat.o(121058);
    return i;
  }
  
  public final int getType()
  {
    return 1145;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(121057);
    ad.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gzH != null) {
      this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(121057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.r
 * JD-Core Version:    0.7.0.1
 */