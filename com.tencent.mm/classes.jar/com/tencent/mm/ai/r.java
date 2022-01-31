package com.tencent.mm.ai;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bgq;
import com.tencent.mm.protocal.c.bgr;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Date;

public final class r
  extends m
  implements k
{
  private Object data;
  public com.tencent.mm.ah.b dmK;
  private f dmL;
  
  public r(b paramb, int paramInt1, int paramInt2, Object paramObject)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bgq();
    ((b.a)localObject).ecI = new bgr();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/reportpluginstat";
    ((b.a)localObject).ecG = 2805;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bgq)this.dmK.ecE.ecN;
    ((bgq)localObject).tBn = 1;
    ((bgq)localObject).tBo = paramb.field_wwCorpId;
    ((bgq)localObject).sDc = paramb.field_wwUserVid;
    g.DN();
    ((bgq)localObject).tBp = a.CK();
    ((bgq)localObject).scene = paramInt2;
    ((bgq)localObject).bHz = paramInt1;
    ((bgq)localObject).tBq = 0L;
    ((bgq)localObject).tBr = new Date().getTime();
    ((bgq)localObject).platform = 1;
    ((bgq)localObject).tyF = com.tencent.mm.sdk.platformtools.e.ag(null, d.spa);
    this.data = paramObject;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    y.i("MicroMsg.NetSceneEnterprisePushStat", "do scene");
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneEnterprisePushStat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 2805;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ai.r
 * JD-Core Version:    0.7.0.1
 */