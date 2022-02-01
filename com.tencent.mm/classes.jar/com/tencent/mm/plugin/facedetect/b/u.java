package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.atj;
import com.tencent.mm.protocal.protobuf.atk;
import com.tencent.mm.sdk.platformtools.ac;

public final class u
  extends n
  implements k, b
{
  private g callback;
  private long qwJ;
  private byte[] qwK;
  private com.tencent.mm.ak.b rr;
  
  public u(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103634);
    this.qwJ = -1L;
    this.qwK = null;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new atj();
    ((b.a)localObject).hvu = new atk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getbioconfig";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (atj)this.rr.hvr.hvw;
    ((atj)localObject).ndI = 1;
    ((atj)localObject).Scene = paramInt1;
    ((atj)localObject).EMs = paramInt2;
    ac.i("MicroMsg.NetSceneGetBioConfig", "carson logic ");
    ac.i("MicroMsg.NetSceneGetBioConfig", "mChechLiveFlag is ".concat(String.valueOf(paramInt2)));
    AppMethodBeat.o(103634);
  }
  
  public final long cmX()
  {
    return this.qwJ;
  }
  
  public final byte[] cmY()
  {
    return this.qwK;
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
    paramq = (atk)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    long l;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.qwJ = paramq.EMt;
      this.qwK = paramq.EMu.xy;
      ac.i("MicroMsg.NetSceneGetBioConfig", "carson logic ");
      ac.i("MicroMsg.NetSceneGetBioConfig", "Config is " + this.qwK);
      l = this.qwJ;
      if (this.qwK != null) {
        break label149;
      }
    }
    label149:
    for (paramInt1 = 0;; paramInt1 = this.qwK.length)
    {
      ac.i("MicroMsg.NetSceneGetBioConfig", "hy: get bio config: bioId: %s, bioConfigSize: %d", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1) });
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(103636);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.u
 * JD-Core Version:    0.7.0.1
 */