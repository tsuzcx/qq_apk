package com.tencent.mm.ai;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.acq;
import com.tencent.mm.protocal.c.acr;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;

public final class s
  extends m
  implements k
{
  Object data;
  public b dmK;
  private f dmL;
  
  public s(String paramString, int paramInt, Object paramObject)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new acq();
    ((b.a)localObject).ecI = new acr();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizenterpriseattr";
    ((b.a)localObject).ecG = 1343;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (acq)this.dmK.ecE.ecN;
    ((acq)localObject).sCO = paramString;
    ((acq)localObject).tbs = paramInt;
    if (x.cqJ().equals("zh_CN")) {}
    for (paramInt = 2;; paramInt = 1)
    {
      ((acq)localObject).tbt = paramInt;
      this.data = paramObject;
      return;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    y.i("MicroMsg.NetSceneGetBizEnterpriseAttr", "do scene");
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1343;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ai.s
 * JD-Core Version:    0.7.0.1
 */