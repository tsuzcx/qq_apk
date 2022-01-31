package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.atx;
import com.tencent.mm.protocal.c.aty;
import com.tencent.mm.sdk.platformtools.y;

public final class l
  extends m
  implements k
{
  public int bXq;
  public String dRQ;
  private b dmK = null;
  private f dmL = null;
  public String jyd;
  
  public l(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.jyd = paramString3;
    this.dRQ = paramString2;
    this.bXq = paramInt;
    this.jyd = paramString3;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new atx();
    ((b.a)localObject).ecI = new aty();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/rank/addlike";
    ((b.a)localObject).ecG = 1041;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (atx)this.dmK.ecE.ecN;
    ((atx)localObject).jFa = paramString2;
    ((atx)localObject).username = paramString1;
    ((atx)localObject).bXq = paramInt;
    ((atx)localObject).dRj = paramString3;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneUpdateLikeStatus", "hy: end. errType: %d, errCode: %d, errMsg: %s, ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1041;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.l
 * JD-Core Version:    0.7.0.1
 */