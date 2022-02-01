package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.bor;
import com.tencent.mm.protocal.protobuf.ccc;
import com.tencent.mm.protocal.protobuf.ccd;
import com.tencent.mm.protocal.protobuf.pv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public abstract class p
  extends o
  implements k
{
  static String rgu = null;
  protected f callback = null;
  
  protected static String aHw()
  {
    return rgu;
  }
  
  public static void afT(String paramString)
  {
    rgu = paramString;
  }
  
  public final void a(final int paramInt1, int paramInt2, String paramString, q paramq)
  {
    ad.i("MicroMsg.NetSceneFaceRsaBase", "hy: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 4) && (paramInt2 == -102))
    {
      paramInt1 = paramq.getReqObj().getRsaInfo().ver;
      ad.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103619);
          new l().doScene(p.a(p.this), new f()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(103618);
              ad.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2n.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                ad.e("MicroMsg.NetSceneFaceRsaBase", "hy: do scene err in rsa when get cert. clear ticket");
                p.csG();
                p.this.afS(p.aHw());
                p.this.callback.onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", p.this);
                AppMethodBeat.o(103618);
                return;
              }
              p.this.f(p.b(p.this));
              AppMethodBeat.o(103618);
            }
          });
          AppMethodBeat.o(103619);
        }
      });
      return;
    }
    c(paramInt1, paramInt2, paramString, paramq);
  }
  
  public final void aEK()
  {
    if (this.callback != null) {
      this.callback.onSceneEnd(3, -1, "", this);
    }
  }
  
  public final f aEL()
  {
    return this.callback;
  }
  
  abstract void afS(String paramString);
  
  public final pv b(q paramq)
  {
    paramq = f(paramq);
    if (paramq != null) {
      return paramq.FEd;
    }
    return null;
  }
  
  public final ccc c(q paramq)
  {
    paramq = f(paramq);
    if (paramq != null) {
      return paramq.FEe;
    }
    return null;
  }
  
  abstract void c(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public final bor d(q paramq)
  {
    paramq = f(paramq);
    if (paramq != null) {
      return paramq.FEc;
    }
    return null;
  }
  
  public int doScene(e parame, f paramf)
  {
    this.callback = paramf;
    if (!bt.isNullOrNil(rgu))
    {
      ad.i("MicroMsg.NetSceneFaceRsaBase", "hy: has ticket: %s", new Object[] { rgu });
      afS(rgu);
      return f(parame);
    }
    return getType();
  }
  
  abstract int f(e parame);
  
  protected abstract ccd f(q paramq);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.p
 * JD-Core Version:    0.7.0.1
 */