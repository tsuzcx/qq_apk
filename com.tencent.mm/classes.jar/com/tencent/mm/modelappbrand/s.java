package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dwq;
import com.tencent.mm.protocal.protobuf.dwr;
import com.tencent.mm.sdk.platformtools.ad;

public final class s
  extends n
  implements k
{
  private final b gRE;
  private g gbr;
  
  public s(String paramString)
  {
    AppMethodBeat.i(121059);
    b.a locala = new b.a();
    locala.gUU = new dwq();
    locala.gUV = new dwr();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/wxatmplcomplaint";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.gRE = locala.atI();
    ((dwq)this.gRE.gUS.gUX).EKD = paramString;
    AppMethodBeat.o(121059);
  }
  
  public final dwr atU()
  {
    if (this.gRE != null) {
      return (dwr)this.gRE.gUT.gUX;
    }
    return null;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(121061);
    ad.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
    this.gbr = paramg;
    int i = dispatch(parame, this.gRE, this);
    AppMethodBeat.o(121061);
    return i;
  }
  
  public final int getType()
  {
    return 1198;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(121060);
    ad.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gbr != null) {
      this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(121060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.s
 * JD-Core Version:    0.7.0.1
 */