package com.tencent.mm.ai.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.rq;
import com.tencent.mm.protocal.c.rr;
import com.tencent.mm.sdk.platformtools.y;

public final class m
  extends com.tencent.mm.ah.m
  implements k
{
  Object data;
  public b dmK;
  private f dmL;
  public String eia;
  
  public m(String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new rq();
    ((b.a)localObject).ecI = new rr();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/convertbizchat";
    ((b.a)localObject).ecG = 1315;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (rq)this.dmK.ecE.ecN;
    ((rq)localObject).sPM = paramString1;
    ((rq)localObject).sPO = paramString2;
    ((rq)localObject).sPN = paramString3;
    this.data = paramObject;
  }
  
  public final rr MS()
  {
    if ((this.dmK != null) && (this.dmK.ecF.ecN != null)) {
      return (rr)this.dmK.ecF.ecN;
    }
    return null;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    y.i("MicroMsg.NetSceneConvertBizChat", "do scene");
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneConvertBizChat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1315;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ai.a.m
 * JD-Core Version:    0.7.0.1
 */