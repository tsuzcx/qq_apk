package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a<RequestType extends com.tencent.mm.bx.a, ResponseType extends com.tencent.mm.bx.a>
  extends p
  implements m
{
  private h mAY;
  protected c yoM;
  
  public final ResponseType cWm()
  {
    if ((this.yoM != null) && (c.c.b(this.yoM.otC) != null)) {
      return c.c.b(this.yoM.otC);
    }
    return null;
  }
  
  protected abstract RequestType dFd();
  
  protected abstract ResponseType dFe();
  
  public final int doScene(g paramg, h paramh)
  {
    this.mAY = paramh;
    if (this.yoM == null)
    {
      paramh = new c.a();
      paramh.funcId = getType();
      paramh.uri = getUri();
      paramh.otE = dFd();
      paramh.otF = dFe();
      paramh.otG = 0;
      paramh.respCmdId = 0;
      this.yoM = paramh.bEF();
      f(c.b.b(this.yoM.otB));
    }
    return dispatch(paramg, this.yoM, this);
  }
  
  protected void f(RequestType paramRequestType) {}
  
  protected abstract String getUri();
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    Log.i("MicroMsg.BaseNetScene", "onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.mAY != null) {
      this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.a
 * JD-Core Version:    0.7.0.1
 */