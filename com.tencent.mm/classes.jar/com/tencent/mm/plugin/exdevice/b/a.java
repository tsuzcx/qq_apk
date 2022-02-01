package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a<RequestType extends com.tencent.mm.bw.a, ResponseType extends com.tencent.mm.bw.a>
  extends q
  implements m
{
  private i heq;
  protected d rxs;
  
  protected abstract RequestType cKc();
  
  protected abstract ResponseType cKd();
  
  public final ResponseType cgq()
  {
    if ((this.rxs != null) && (this.rxs.iLL.iLR != null)) {
      return this.rxs.iLL.iLR;
    }
    return null;
  }
  
  public final int doScene(g paramg, i parami)
  {
    this.heq = parami;
    if (this.rxs == null)
    {
      parami = new d.a();
      parami.funcId = getType();
      parami.uri = getUri();
      parami.iLN = cKc();
      parami.iLO = cKd();
      parami.iLP = 0;
      parami.respCmdId = 0;
      this.rxs = parami.aXF();
      i(this.rxs.iLK.iLR);
    }
    return dispatch(paramg, this.rxs, this);
  }
  
  protected abstract String getUri();
  
  protected void i(RequestType paramRequestType) {}
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    Log.i("MicroMsg.BaseNetScene", "onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.heq != null) {
      this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.a
 * JD-Core Version:    0.7.0.1
 */