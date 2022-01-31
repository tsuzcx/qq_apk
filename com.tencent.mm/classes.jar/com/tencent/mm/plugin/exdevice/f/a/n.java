package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.caa;
import com.tencent.mm.protocal.c.cab;
import com.tencent.mm.sdk.platformtools.y;

public final class n
  extends m
  implements k
{
  private b dmK = null;
  private f dmL = null;
  public int jyu;
  public int jyv;
  public int opType;
  
  public n(int paramInt1, int paramInt2)
  {
    this.opType = paramInt1;
    this.jyu = paramInt2;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new caa();
    ((b.a)localObject).ecI = new cab();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/rank/updateranksetting";
    ((b.a)localObject).ecG = 1044;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (caa)this.dmK.ecE.ecN;
    ((caa)localObject).bXq = this.opType;
    ((caa)localObject).bcw = this.jyu;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneUpdateRankSetting", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.jyv = ((cab)this.dmK.ecF.ecN).bcw;
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1044;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.n
 * JD-Core Version:    0.7.0.1
 */