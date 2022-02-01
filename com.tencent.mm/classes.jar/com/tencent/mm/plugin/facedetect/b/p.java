package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.bpj;
import com.tencent.mm.protocal.protobuf.ccw;
import com.tencent.mm.protocal.protobuf.ccx;
import com.tencent.mm.protocal.protobuf.px;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;

public abstract class p
  extends o
  implements k
{
  static String roy = null;
  protected f callback = null;
  
  protected static String aHN()
  {
    return roy;
  }
  
  public static void agP(String paramString)
  {
    roy = paramString;
  }
  
  public final void a(final int paramInt1, int paramInt2, String paramString, q paramq)
  {
    ae.i("MicroMsg.NetSceneFaceRsaBase", "hy: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 4) && (paramInt2 == -102))
    {
      paramInt1 = paramq.getReqObj().getRsaInfo().ver;
      ae.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103619);
          new m().doScene(p.a(p.this), new f()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(103618);
              ae.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2n.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                ae.e("MicroMsg.NetSceneFaceRsaBase", "hy: do scene err in rsa when get cert. clear ticket");
                p.cuh();
                p.this.agO(p.aHN());
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
  
  public final void aFa()
  {
    if (this.callback != null) {
      this.callback.onSceneEnd(3, -1, "", this);
    }
  }
  
  public final f aFb()
  {
    return this.callback;
  }
  
  abstract void agO(String paramString);
  
  public final px b(q paramq)
  {
    paramq = f(paramq);
    if (paramq != null) {
      return paramq.FWy;
    }
    return null;
  }
  
  public final ccw c(q paramq)
  {
    paramq = f(paramq);
    if (paramq != null) {
      return paramq.FWz;
    }
    return null;
  }
  
  abstract void c(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public final bpj d(q paramq)
  {
    paramq = f(paramq);
    if (paramq != null) {
      return paramq.FWx;
    }
    return null;
  }
  
  public int doScene(e parame, f paramf)
  {
    this.callback = paramf;
    if (!bu.isNullOrNil(roy))
    {
      ae.i("MicroMsg.NetSceneFaceRsaBase", "hy: has ticket: %s", new Object[] { roy });
      agO(roy);
      return f(parame);
    }
    return getType();
  }
  
  abstract int f(e parame);
  
  protected abstract ccx f(q paramq);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.p
 * JD-Core Version:    0.7.0.1
 */