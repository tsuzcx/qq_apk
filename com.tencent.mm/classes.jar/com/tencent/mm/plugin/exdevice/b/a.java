package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ae;

public abstract class a<RequestType extends com.tencent.mm.bw.a, ResponseType extends com.tencent.mm.bw.a>
  extends n
  implements k
{
  private f gCo;
  protected b qgw;
  
  public final ResponseType bJx()
  {
    if ((this.qgw != null) && (this.qgw.hQE.hQJ != null)) {
      return this.qgw.hQE.hQJ;
    }
    return null;
  }
  
  protected abstract RequestType cma();
  
  protected abstract ResponseType cmb();
  
  public final int doScene(e parame, f paramf)
  {
    this.gCo = paramf;
    if (this.qgw == null)
    {
      paramf = new b.a();
      paramf.funcId = getType();
      paramf.uri = getUri();
      paramf.hQF = cma();
      paramf.hQG = cmb();
      paramf.hQH = 0;
      paramf.respCmdId = 0;
      this.qgw = paramf.aDS();
      i(this.qgw.hQD.hQJ);
    }
    return dispatch(parame, this.qgw, this);
  }
  
  protected abstract String getUri();
  
  protected void i(RequestType paramRequestType) {}
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    ae.i("MicroMsg.BaseNetScene", "onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gCo != null) {
      this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.a
 * JD-Core Version:    0.7.0.1
 */