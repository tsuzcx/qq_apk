package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.eke;
import com.tencent.mm.protocal.protobuf.ekf;
import com.tencent.mm.sdk.platformtools.ae;

public final class s
  extends n
  implements k
{
  private f gCo;
  private final b hNp;
  
  public s(String paramString)
  {
    AppMethodBeat.i(121059);
    b.a locala = new b.a();
    locala.hQF = new eke();
    locala.hQG = new ekf();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/wxatmplcomplaint";
    locala.funcId = getType();
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.hNp = locala.aDS();
    ((eke)this.hNp.hQD.hQJ).Ink = paramString;
    AppMethodBeat.o(121059);
  }
  
  public final ekf aEe()
  {
    if (this.hNp != null) {
      return (ekf)this.hNp.hQE.hQJ;
    }
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(121061);
    ae.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
    this.gCo = paramf;
    int i = dispatch(parame, this.hNp, this);
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
    ae.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gCo != null) {
      this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(121060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.s
 * JD-Core Version:    0.7.0.1
 */