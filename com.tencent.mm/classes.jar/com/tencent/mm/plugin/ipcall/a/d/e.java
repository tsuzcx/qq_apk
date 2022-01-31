package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.amn;
import com.tencent.mm.protocal.c.amo;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  extends m
  implements k
{
  private b dmK = null;
  private f dmL = null;
  private amn lrw = null;
  public amo lrx = null;
  
  public e()
  {
    b.a locala = new b.a();
    locala.ecH = new amn();
    locala.ecI = new amo();
    locala.ecG = 831;
    locala.uri = "/cgi-bin/micromsg-bin/getwcopackageproductlist";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.lrw = ((amn)this.dmK.ecE.ecN);
    y.i("MicroMsg.NetSceneIPCallGetPackageProductList", "NetSceneIPCallGetPackageProductList");
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneIPCallGetPackageProductList", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.lrx = ((amo)((b)paramq).ecF.ecN);
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 831;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.d.e
 * JD-Core Version:    0.7.0.1
 */