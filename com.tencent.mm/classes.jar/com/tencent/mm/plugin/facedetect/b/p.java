package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ai.f;
import com.tencent.mm.ai.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.avk;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.mg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class p
  extends n
  implements k
{
  static String mhi = null;
  protected f callback = null;
  
  public static void Nn(String paramString)
  {
    mhi = paramString;
  }
  
  protected static String agx()
  {
    return mhi;
  }
  
  abstract void Nm(String paramString);
  
  public final void a(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    ab.i("MicroMsg.NetSceneFaceRsaBase", "hy: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 4) && (paramInt2 == -102))
    {
      paramInt1 = paramq.getReqObj().getRsaInfo().ver;
      ab.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      g.RO().ac(new p.1(this, paramInt1));
      return;
    }
    c(paramInt1, paramInt2, paramString, paramq);
  }
  
  public final void adq()
  {
    if (this.callback != null) {
      this.callback.onSceneEnd(3, -1, "", this);
    }
  }
  
  public final f adr()
  {
    return this.callback;
  }
  
  public final mg b(q paramq)
  {
    paramq = f(paramq);
    if (paramq != null) {
      return paramq.wvY;
    }
    return null;
  }
  
  public final bft c(q paramq)
  {
    paramq = f(paramq);
    if (paramq != null) {
      return paramq.wvZ;
    }
    return null;
  }
  
  abstract void c(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public final avk d(q paramq)
  {
    paramq = f(paramq);
    if (paramq != null) {
      return paramq.wvX;
    }
    return null;
  }
  
  public int doScene(e parame, f paramf)
  {
    this.callback = paramf;
    if (!bo.isNullOrNil(mhi))
    {
      ab.i("MicroMsg.NetSceneFaceRsaBase", "hy: has ticket: %s", new Object[] { mhi });
      Nm(mhi);
      return f(parame);
    }
    return getType();
  }
  
  abstract int f(e parame);
  
  protected abstract bfu f(q paramq);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.p
 * JD-Core Version:    0.7.0.1
 */