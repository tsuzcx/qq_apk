package com.tencent.mm.plugin.exdevice.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.y;

public abstract class a<RequestType extends com.tencent.mm.bv.a, ResponseType extends com.tencent.mm.bv.a>
  extends m
  implements k
{
  private f dIJ;
  protected b jsP;
  
  public final int a(e parame, f paramf)
  {
    this.dIJ = paramf;
    if (this.jsP == null)
    {
      paramf = new b.a();
      paramf.ecG = getType();
      paramf.uri = getUri();
      paramf.ecH = aLd();
      paramf.ecI = aLe();
      paramf.ecJ = 0;
      paramf.ecK = 0;
      this.jsP = paramf.Kt();
      g(this.jsP.ecE.ecN);
    }
    return a(parame, this.jsP, this);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.BaseNetScene", "onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.dIJ != null) {
      this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public abstract RequestType aLd();
  
  public abstract ResponseType aLe();
  
  public final ResponseType auJ()
  {
    if ((this.jsP != null) && (this.jsP.ecF.ecN != null)) {
      return this.jsP.ecF.ecN;
    }
    return null;
  }
  
  public void g(RequestType paramRequestType) {}
  
  public abstract String getUri();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.a.a
 * JD-Core Version:    0.7.0.1
 */