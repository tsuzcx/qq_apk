package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class a<RequestType extends com.tencent.mm.bx.a, ResponseType extends com.tencent.mm.bx.a>
  extends n
  implements k
{
  private g gbr;
  protected b oTb;
  
  protected abstract RequestType bYX();
  
  protected abstract ResponseType bYY();
  
  public final ResponseType bxu()
  {
    if ((this.oTb != null) && (this.oTb.gUT.gUX != null)) {
      return this.oTb.gUT.gUX;
    }
    return null;
  }
  
  public final int doScene(e parame, g paramg)
  {
    this.gbr = paramg;
    if (this.oTb == null)
    {
      paramg = new b.a();
      paramg.funcId = getType();
      paramg.uri = getUri();
      paramg.gUU = bYX();
      paramg.gUV = bYY();
      paramg.reqCmdId = 0;
      paramg.respCmdId = 0;
      this.oTb = paramg.atI();
      i(this.oTb.gUS.gUX);
    }
    return dispatch(parame, this.oTb, this);
  }
  
  protected abstract String getUri();
  
  protected void i(RequestType paramRequestType) {}
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    ad.i("MicroMsg.BaseNetScene", "onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gbr != null) {
      this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.a
 * JD-Core Version:    0.7.0.1
 */