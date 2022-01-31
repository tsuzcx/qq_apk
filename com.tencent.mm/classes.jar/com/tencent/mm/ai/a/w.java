package com.tencent.mm.ai.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bzs;
import com.tencent.mm.protocal.c.bzt;
import com.tencent.mm.protocal.c.io;
import com.tencent.mm.sdk.platformtools.y;

public final class w
  extends m
  implements k
{
  Object data;
  public b dmK;
  private f dmL;
  
  public w(String paramString, io paramio, Object paramObject)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bzs();
    ((b.a)localObject).ecI = new bzt();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/updatebizchat";
    ((b.a)localObject).ecG = 1356;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bzs)this.dmK.ecE.ecN;
    ((bzs)localObject).sCO = paramString;
    ((bzs)localObject).sYQ = paramio;
    this.data = paramObject;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    y.i("MicroMsg.brandservice.NetSceneUpdateBizChat", "do scene");
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.brandservice.NetSceneUpdateBizChat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1356;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ai.a.w
 * JD-Core Version:    0.7.0.1
 */