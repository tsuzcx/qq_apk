package com.tencent.mm.plugin.exdevice.a;

import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class a<RequestType extends com.tencent.mm.bv.a, ResponseType extends com.tencent.mm.bv.a>
  extends m
  implements k
{
  private f eGj;
  protected b lCp;
  
  public final ResponseType aUl()
  {
    if ((this.lCp != null) && (this.lCp.fsW.fta != null)) {
      return this.lCp.fsW.fta;
    }
    return null;
  }
  
  protected abstract RequestType bpq();
  
  protected abstract ResponseType bpr();
  
  public final int doScene(e parame, f paramf)
  {
    this.eGj = paramf;
    if (this.lCp == null)
    {
      paramf = new b.a();
      paramf.funcId = getType();
      paramf.uri = getUri();
      paramf.fsX = bpq();
      paramf.fsY = bpr();
      paramf.reqCmdId = 0;
      paramf.respCmdId = 0;
      this.lCp = paramf.ado();
      g(this.lCp.fsV.fta);
    }
    return dispatch(parame, this.lCp, this);
  }
  
  protected void g(RequestType paramRequestType) {}
  
  protected abstract String getUri();
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    ab.i("MicroMsg.BaseNetScene", "onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.eGj != null) {
      this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.a.a
 * JD-Core Version:    0.7.0.1
 */