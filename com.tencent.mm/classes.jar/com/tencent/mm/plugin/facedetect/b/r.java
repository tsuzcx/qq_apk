package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agp;
import com.tencent.mm.sdk.platformtools.ac;

public final class r
  extends n
  implements k
{
  private g callback;
  public String mFileName;
  private b rr;
  
  public r(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(103623);
    this.mFileName = "";
    b.a locala = new b.a();
    locala.hvt = new ago();
    locala.hvu = new agp();
    locala.uri = "/cgi-bin/mmbiz-bin/usrmsg/facevideobindbioid";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.mFileName = paramString1;
    paramString1 = (ago)this.rr.hvr.hvw;
    paramString1.djj = paramString2;
    paramString1.EyA = paramLong;
    paramString1.EyB = paramString4;
    paramString1.EyI = paramString3;
    AppMethodBeat.o(103623);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(103624);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103624);
    return i;
  }
  
  public final int getType()
  {
    return 1197;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103625);
    ac.d("MicroMsg.NetSceneFaceThirdBindVideo", "hy:  errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(103625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.r
 * JD-Core Version:    0.7.0.1
 */