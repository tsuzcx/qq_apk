package com.tencent.mm.plugin.appbrand.n;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.art;
import com.tencent.mm.protocal.c.aru;
import com.tencent.mm.protocal.c.cms;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends m
  implements k
{
  private f dIJ;
  public final com.tencent.mm.ah.b dmK;
  private c.a<c> gQv;
  
  private c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.webview.NetSceneJSOperateWxData", "NetSceneJSLogin doScene appId [%s], data [%s], grantScope [%s], versionType [%d], opt [%d], extScene [%d]", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new art();
    ((b.a)localObject).ecI = new aru();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-operatewxdata";
    ((b.a)localObject).ecG = 1133;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (art)this.dmK.ecE.ecN;
    ((art)localObject).euK = paramString1;
    if (paramString2.getBytes() == null) {}
    for (paramString1 = new byte[0];; paramString1 = paramString2.getBytes())
    {
      ((art)localObject).hPF = new com.tencent.mm.bv.b(paramString1);
      ((art)localObject).tnh = paramString3;
      ((art)localObject).tmZ = paramInt1;
      ((art)localObject).tmY = paramInt2;
      if (paramInt3 > 0)
      {
        ((art)localObject).tna = new cms();
        ((art)localObject).tna.scene = paramInt3;
      }
      return;
    }
  }
  
  public c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, c.a<c> parama)
  {
    this(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3);
    this.gQv = parama;
  }
  
  public final int a(e parame, f paramf)
  {
    y.i("MicroMsg.webview.NetSceneJSOperateWxData", "doScene");
    this.dIJ = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.webview.NetSceneJSOperateWxData", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.dIJ != null) {
      this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.gQv != null) {
      this.gQv.a(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1133;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.c
 * JD-Core Version:    0.7.0.1
 */