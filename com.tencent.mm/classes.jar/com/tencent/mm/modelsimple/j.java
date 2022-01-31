package com.tencent.mm.modelsimple;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aep;
import com.tencent.mm.protocal.c.aeq;
import com.tencent.mm.sdk.platformtools.y;

public final class j
  extends m
  implements k
{
  public String cCA;
  public String cCB;
  public String country;
  private b dmK;
  private f dmL;
  
  public j(double paramDouble1, double paramDouble2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new aep();
    ((b.a)localObject).ecI = new aeq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcurlocation";
    ((b.a)localObject).ecG = 665;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (aep)this.dmK.ecE.ecN;
    ((aep)localObject).sDn = paramDouble1;
    ((aep)localObject).sDm = paramDouble2;
    y.d("MicroMsg.NetSceneGetCurLocation", "latitude:" + paramDouble1 + ", longitude:" + paramDouble2);
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetCurLocation", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (aeq)this.dmK.ecF.ecN;
      this.cCB = paramq.ffj;
      this.country = paramq.ffq;
      this.cCA = paramq.ffi;
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 665;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsimple.j
 * JD-Core Version:    0.7.0.1
 */