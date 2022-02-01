package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class a<RequestType extends com.tencent.mm.bx.a, ResponseType extends com.tencent.mm.bx.a>
  extends n
  implements k
{
  private f gzH;
  protected b pZR;
  
  public final ResponseType bIz()
  {
    if ((this.pZR != null) && (this.pZR.hNL.hNQ != null)) {
      return this.pZR.hNL.hNQ;
    }
    return null;
  }
  
  protected abstract RequestType ckK();
  
  protected abstract ResponseType ckL();
  
  public final int doScene(e parame, f paramf)
  {
    this.gzH = paramf;
    if (this.pZR == null)
    {
      paramf = new b.a();
      paramf.funcId = getType();
      paramf.uri = getUri();
      paramf.hNM = ckK();
      paramf.hNN = ckL();
      paramf.hNO = 0;
      paramf.respCmdId = 0;
      this.pZR = paramf.aDC();
      i(this.pZR.hNK.hNQ);
    }
    return dispatch(parame, this.pZR, this);
  }
  
  protected abstract String getUri();
  
  protected void i(RequestType paramRequestType) {}
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    ad.i("MicroMsg.BaseNetScene", "onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gzH != null) {
      this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.a
 * JD-Core Version:    0.7.0.1
 */