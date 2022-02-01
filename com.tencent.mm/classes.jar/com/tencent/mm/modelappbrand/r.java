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
import com.tencent.mm.protocal.protobuf.bdw;
import com.tencent.mm.protocal.protobuf.bdx;
import com.tencent.mm.sdk.platformtools.ac;

public final class r
  extends n
  implements k
{
  private g gfX;
  public final b hse;
  
  public r(int paramInt)
  {
    AppMethodBeat.i(121056);
    b.a locala = new b.a();
    locala.hvt = new bdw();
    locala.hvu = new bdx();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getservicenotifyoptions";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.hse = locala.aAz();
    ((bdw)this.hse.hvr.hvw).ETI = paramInt;
    AppMethodBeat.o(121056);
  }
  
  public final bdx aAK()
  {
    return (bdx)this.hse.hvs.hvw;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(121058);
    ac.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
    this.gfX = paramg;
    int i = dispatch(parame, this.hse, this);
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
    ac.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gfX != null) {
      this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(121057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.r
 * JD-Core Version:    0.7.0.1
 */