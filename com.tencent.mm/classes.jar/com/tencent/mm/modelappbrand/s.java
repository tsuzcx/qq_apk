package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ech;
import com.tencent.mm.protocal.protobuf.eci;
import com.tencent.mm.sdk.platformtools.ac;

public final class s
  extends n
  implements k
{
  private g gfX;
  private final b hse;
  
  public s(String paramString)
  {
    AppMethodBeat.i(121059);
    b.a locala = new b.a();
    locala.hvt = new ech();
    locala.hvu = new eci();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/wxatmplcomplaint";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.hse = locala.aAz();
    ((ech)this.hse.hvr.hvw).GhP = paramString;
    AppMethodBeat.o(121059);
  }
  
  public final eci aAL()
  {
    if (this.hse != null) {
      return (eci)this.hse.hvs.hvw;
    }
    return null;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(121061);
    ac.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
    this.gfX = paramg;
    int i = dispatch(parame, this.hse, this);
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
    ac.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gfX != null) {
      this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(121060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.s
 * JD-Core Version:    0.7.0.1
 */