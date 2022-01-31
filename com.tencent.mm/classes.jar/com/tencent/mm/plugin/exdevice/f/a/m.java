package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bzy;
import com.tencent.mm.protocal.c.bzz;
import com.tencent.mm.sdk.platformtools.y;

public final class m
  extends com.tencent.mm.ah.m
  implements k
{
  private b dmK = null;
  private f dmL = null;
  public String jxP;
  public String jxQ;
  
  public m(String paramString1, String paramString2)
  {
    this.jxP = paramString1;
    this.jxQ = paramString2;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bzy();
    ((b.a)localObject).ecI = new bzz();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/rank/updatecover";
    ((b.a)localObject).ecG = 1040;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bzy)this.dmK.ecE.ecN;
    ((bzy)localObject).thK = paramString1;
    ((bzy)localObject).jxQ = paramString2;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneUpdateRankCoverAndMotto", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1040;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.m
 * JD-Core Version:    0.7.0.1
 */