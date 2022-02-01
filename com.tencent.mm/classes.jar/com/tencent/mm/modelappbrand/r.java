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
import com.tencent.mm.protocal.protobuf.biu;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.sdk.platformtools.ae;

public final class r
  extends n
  implements k
{
  private f gCo;
  public final b hNp;
  
  public r(int paramInt)
  {
    AppMethodBeat.i(121056);
    b.a locala = new b.a();
    locala.hQF = new biu();
    locala.hQG = new biv();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getservicenotifyoptions";
    locala.funcId = getType();
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.hNp = locala.aDS();
    ((biu)this.hNp.hQD.hQJ).GWF = paramInt;
    AppMethodBeat.o(121056);
  }
  
  public final biv aEd()
  {
    return (biv)this.hNp.hQE.hQJ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(121058);
    ae.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
    this.gCo = paramf;
    int i = dispatch(parame, this.hNp, this);
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
    ae.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gCo != null) {
      this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(121057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.r
 * JD-Core Version:    0.7.0.1
 */