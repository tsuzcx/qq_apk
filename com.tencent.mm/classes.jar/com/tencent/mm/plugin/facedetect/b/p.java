package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.o;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.bkh;
import com.tencent.mm.protocal.protobuf.bxl;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.protocal.protobuf.oq;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;

public abstract class p
  extends o
  implements k
{
  static String qwE = null;
  protected com.tencent.mm.ak.g callback = null;
  
  protected static String aEr()
  {
    return qwE;
  }
  
  public static void ace(String paramString)
  {
    qwE = paramString;
  }
  
  public final void a(final int paramInt1, int paramInt2, String paramString, q paramq)
  {
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneFaceRsaBase", "hy: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 4) && (paramInt2 == -102))
    {
      paramInt1 = paramq.getReqObj().getRsaInfo().ver;
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103619);
          new l().doScene(p.a(p.this), new com.tencent.mm.ak.g()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(103618);
              com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2n.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneFaceRsaBase", "hy: do scene err in rsa when get cert. clear ticket");
                p.cnb();
                p.this.acd(p.aEr());
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
  
  public final void aBH()
  {
    if (this.callback != null) {
      this.callback.onSceneEnd(3, -1, "", this);
    }
  }
  
  public final com.tencent.mm.ak.g aBI()
  {
    return this.callback;
  }
  
  abstract void acd(String paramString);
  
  public final oq b(q paramq)
  {
    paramq = f(paramq);
    if (paramq != null) {
      return paramq.DYH;
    }
    return null;
  }
  
  public final bxl c(q paramq)
  {
    paramq = f(paramq);
    if (paramq != null) {
      return paramq.DYI;
    }
    return null;
  }
  
  abstract void c(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public final bkh d(q paramq)
  {
    paramq = f(paramq);
    if (paramq != null) {
      return paramq.DYG;
    }
    return null;
  }
  
  public int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    this.callback = paramg;
    if (!bs.isNullOrNil(qwE))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneFaceRsaBase", "hy: has ticket: %s", new Object[] { qwE });
      acd(qwE);
      return f(parame);
    }
    return getType();
  }
  
  abstract int f(e parame);
  
  protected abstract bxm f(q paramq);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.p
 * JD-Core Version:    0.7.0.1
 */