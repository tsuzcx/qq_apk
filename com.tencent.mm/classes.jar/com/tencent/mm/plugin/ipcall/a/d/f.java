package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.amp;
import com.tencent.mm.protocal.c.amq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class f
  extends m
  implements k
{
  private b dmK = null;
  private com.tencent.mm.ah.f dmL;
  public boolean lrA = true;
  private amp lry = null;
  public amq lrz = null;
  
  public f(String paramString1, String paramString2)
  {
    if (bk.bl(paramString2))
    {
      this.lrA = true;
      paramString2 = "";
    }
    for (;;)
    {
      b.a locala = new b.a();
      locala.ecH = new amp();
      locala.ecI = new amq();
      locala.ecG = 929;
      locala.uri = "/cgi-bin/micromsg-bin/getwcoproductlist";
      locala.ecJ = 0;
      locala.ecK = 0;
      this.dmK = locala.Kt();
      this.lry = ((amp)this.dmK.ecE.ecN);
      this.lry.tiu = paramString1;
      this.lry.tiv = paramString2;
      y.i("MicroMsg.NetSceneIPCallGetProductList", "NetSceneIPCallGetProductList");
      return;
      this.lrA = false;
    }
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneIPCallGetProductList", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.lrz = ((amq)((b)paramq).ecF.ecN);
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 929;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.d.f
 * JD-Core Version:    0.7.0.1
 */