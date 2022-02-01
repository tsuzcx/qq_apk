package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dfy;
import com.tencent.mm.protocal.protobuf.dfz;
import com.tencent.mm.sdk.platformtools.ad;

public final class n
  extends com.tencent.mm.al.n
  implements k
{
  private g callback;
  public int oYD;
  public int oYE;
  public int opType;
  private b rr;
  
  public n(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(23540);
    this.callback = null;
    this.rr = null;
    this.opType = paramInt1;
    this.oYD = paramInt2;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dfy();
    ((b.a)localObject).gUV = new dfz();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/rank/updateranksetting";
    ((b.a)localObject).funcId = 1044;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (dfy)this.rr.gUS.gUX;
    ((dfy)localObject).dvW = this.opType;
    ((dfy)localObject).dtM = this.oYD;
    AppMethodBeat.o(23540);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(23541);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(23541);
    return i;
  }
  
  public final int getType()
  {
    return 1044;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23542);
    ad.d("MicroMsg.NetSceneUpdateRankSetting", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.oYE = ((dfz)this.rr.gUT.gUX).dtM;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.n
 * JD-Core Version:    0.7.0.1
 */