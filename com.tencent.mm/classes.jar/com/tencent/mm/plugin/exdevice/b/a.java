package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a<RequestType extends com.tencent.mm.cd.a, ResponseType extends com.tencent.mm.cd.a>
  extends q
  implements m
{
  private i jQg;
  protected d vcY;
  
  protected abstract RequestType cYM();
  
  protected abstract ResponseType cYN();
  
  public final ResponseType ctC()
  {
    if ((this.vcY != null) && (d.c.b(this.vcY.lBS) != null)) {
      return d.c.b(this.vcY.lBS);
    }
    return null;
  }
  
  public final int doScene(g paramg, i parami)
  {
    this.jQg = parami;
    if (this.vcY == null)
    {
      parami = new d.a();
      parami.funcId = getType();
      parami.uri = getUri();
      parami.lBU = cYM();
      parami.lBV = cYN();
      parami.lBW = 0;
      parami.respCmdId = 0;
      this.vcY = parami.bgN();
      i(d.b.b(this.vcY.lBR));
    }
    return dispatch(paramg, this.vcY, this);
  }
  
  protected abstract String getUri();
  
  protected void i(RequestType paramRequestType) {}
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    Log.i("MicroMsg.BaseNetScene", "onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.jQg != null) {
      this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.a
 * JD-Core Version:    0.7.0.1
 */