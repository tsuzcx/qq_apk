package com.tencent.mm.ai;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bqe;
import com.tencent.mm.protocal.c.bqf;
import com.tencent.mm.protocal.c.iw;

public final class y
  extends m
  implements k
{
  Object data;
  public b dmK;
  private f dmL;
  
  public y(iw paramiw, Object paramObject)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bqe();
    ((b.a)localObject).ecI = new bqf();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/setbizenterpriseattr";
    ((b.a)localObject).ecG = 1228;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bqe)this.dmK.ecE.ecN;
    ((bqe)localObject).tbu = paramiw;
    ((bqe)localObject).mask = 1;
    ((bqe)localObject).tbs = 1;
    this.data = paramObject;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneSetBizEnterpriseAttr", "do scene");
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneSetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1228;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ai.y
 * JD-Core Version:    0.7.0.1
 */