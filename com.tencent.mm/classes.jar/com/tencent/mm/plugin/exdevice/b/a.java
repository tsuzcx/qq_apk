package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ac;

public abstract class a<RequestType extends com.tencent.mm.bw.a, ResponseType extends com.tencent.mm.bw.a>
  extends n
  implements k
{
  private g gfX;
  protected b pwm;
  
  public final ResponseType bEq()
  {
    if ((this.pwm != null) && (this.pwm.hvs.hvw != null)) {
      return this.pwm.hvs.hvw;
    }
    return null;
  }
  
  protected abstract RequestType cgg();
  
  protected abstract ResponseType cgh();
  
  public final int doScene(e parame, g paramg)
  {
    this.gfX = paramg;
    if (this.pwm == null)
    {
      paramg = new b.a();
      paramg.funcId = getType();
      paramg.uri = getUri();
      paramg.hvt = cgg();
      paramg.hvu = cgh();
      paramg.reqCmdId = 0;
      paramg.respCmdId = 0;
      this.pwm = paramg.aAz();
      i(this.pwm.hvr.hvw);
    }
    return dispatch(parame, this.pwm, this);
  }
  
  protected abstract String getUri();
  
  protected void i(RequestType paramRequestType) {}
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    ac.i("MicroMsg.BaseNetScene", "onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gfX != null) {
      this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.a
 * JD-Core Version:    0.7.0.1
 */