package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aqf;
import com.tencent.mm.protocal.protobuf.aqg;
import com.tencent.mm.sdk.platformtools.ad;

public final class u
  extends n
  implements k, b
{
  private g callback;
  private long pOb;
  private byte[] pOc;
  private com.tencent.mm.al.b rr;
  
  public u(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103634);
    this.pOb = -1L;
    this.pOc = null;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new aqf();
    ((b.a)localObject).gUV = new aqg();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getbioconfig";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (aqf)this.rr.gUS.gUX;
    ((aqf)localObject).mBH = 1;
    ((aqf)localObject).Scene = paramInt1;
    ((aqf)localObject).Drq = paramInt2;
    ad.i("MicroMsg.NetSceneGetBioConfig", "carson logic ");
    ad.i("MicroMsg.NetSceneGetBioConfig", "mChechLiveFlag is ".concat(String.valueOf(paramInt2)));
    AppMethodBeat.o(103634);
  }
  
  public final long cfq()
  {
    return this.pOb;
  }
  
  public final byte[] cfr()
  {
    return this.pOc;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(103635);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103635);
    return i;
  }
  
  public final int getType()
  {
    return 732;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103636);
    paramq = (aqg)((com.tencent.mm.al.b)paramq).gUT.gUX;
    long l;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.pOb = paramq.Drr;
      this.pOc = paramq.Drs.wA;
      ad.i("MicroMsg.NetSceneGetBioConfig", "carson logic ");
      ad.i("MicroMsg.NetSceneGetBioConfig", "Config is " + this.pOc);
      l = this.pOb;
      if (this.pOc != null) {
        break label149;
      }
    }
    label149:
    for (paramInt1 = 0;; paramInt1 = this.pOc.length)
    {
      ad.i("MicroMsg.NetSceneGetBioConfig", "hy: get bio config: bioId: %s, bioConfigSize: %d", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1) });
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(103636);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.u
 * JD-Core Version:    0.7.0.1
 */