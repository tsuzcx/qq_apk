package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.axx;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.sdk.platformtools.ae;

public final class u
  extends n
  implements k, b
{
  private f callback;
  private long roD;
  private byte[] roE;
  private com.tencent.mm.ak.b rr;
  
  public u(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103634);
    this.roD = -1L;
    this.roE = null;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new axx();
    ((b.a)localObject).hQG = new axy();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getbioconfig";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (axx)this.rr.hQD.hQJ;
    ((axx)localObject).nJA = 1;
    ((axx)localObject).Scene = paramInt1;
    ((axx)localObject).GOV = paramInt2;
    ae.i("MicroMsg.NetSceneGetBioConfig", "carson logic ");
    ae.i("MicroMsg.NetSceneGetBioConfig", "mChechLiveFlag is ".concat(String.valueOf(paramInt2)));
    AppMethodBeat.o(103634);
  }
  
  public final long cud()
  {
    return this.roD;
  }
  
  public final byte[] cue()
  {
    return this.roE;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(103635);
    this.callback = paramf;
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
    paramq = (axy)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    long l;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.roD = paramq.GOW;
      this.roE = paramq.GOX.zr;
      ae.i("MicroMsg.NetSceneGetBioConfig", "carson logic ");
      ae.i("MicroMsg.NetSceneGetBioConfig", "Config is " + this.roE);
      l = this.roD;
      if (this.roE != null) {
        break label149;
      }
    }
    label149:
    for (paramInt1 = 0;; paramInt1 = this.roE.length)
    {
      ae.i("MicroMsg.NetSceneGetBioConfig", "hy: get bio config: bioId: %s, bioConfigSize: %d", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1) });
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