package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.acg;
import com.tencent.mm.protocal.c.ach;
import com.tencent.mm.sdk.platformtools.y;

public final class u
  extends m
  implements k, b
{
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  private long jNe = -1L;
  private byte[] jNf = null;
  
  public u(int paramInt1, int paramInt2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new acg();
    ((b.a)localObject).ecI = new ach();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getbioconfig";
    ((b.a)localObject).ecG = 732;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (acg)this.dmK.ecE.ecN;
    ((acg)localObject).hQR = 1;
    ((acg)localObject).pyo = paramInt1;
    ((acg)localObject).tbk = paramInt2;
    y.i("MicroMsg.NetSceneGetBioConfig", "carson logic ");
    y.i("MicroMsg.NetSceneGetBioConfig", "mChechLiveFlag is " + paramInt2);
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramq = (ach)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    long l;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.jNe = paramq.tbl;
      this.jNf = paramq.tbm.oY;
      y.i("MicroMsg.NetSceneGetBioConfig", "carson logic ");
      y.i("MicroMsg.NetSceneGetBioConfig", "Config is " + this.jNf);
      l = this.jNe;
      if (this.jNf != null) {
        break label139;
      }
    }
    label139:
    for (paramInt1 = 0;; paramInt1 = this.jNf.length)
    {
      y.i("MicroMsg.NetSceneGetBioConfig", "hy: get bio config: bioId: %s, bioConfigSize: %d", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1) });
      if (this.dmL != null) {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      return;
    }
  }
  
  public final long aNT()
  {
    return this.jNe;
  }
  
  public final byte[] aNU()
  {
    return this.jNf;
  }
  
  public final int getType()
  {
    return 732;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.u
 * JD-Core Version:    0.7.0.1
 */