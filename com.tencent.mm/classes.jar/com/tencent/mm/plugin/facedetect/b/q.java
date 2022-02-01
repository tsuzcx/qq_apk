package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.r;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.m;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.cke;
import com.tencent.mm.protocal.protobuf.dca;
import com.tencent.mm.protocal.protobuf.dcb;
import com.tencent.mm.protocal.protobuf.qr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class q
  extends r
{
  private static String wwa = null;
  protected i callback = null;
  
  public static void azA(String paramString)
  {
    wwa = paramString;
  }
  
  protected static String bkW()
  {
    return wwa;
  }
  
  public final void a(final int paramInt1, int paramInt2, String paramString, s params)
  {
    Log.i("MicroMsg.NetSceneFaceRsaBase", "hy: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 4) && (paramInt2 == -102))
    {
      paramInt1 = params.getReqObj().getRsaInfo().ver;
      Log.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103619);
          new m().doScene(q.a(q.this), new i()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.an.q paramAnonymous2q)
            {
              AppMethodBeat.i(103618);
              Log.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2q.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                Log.e("MicroMsg.NetSceneFaceRsaBase", "hy: do scene err in rsa when get cert. clear ticket");
                q.dhU();
                q.this.azz(q.bkW());
                q.this.callback.onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", q.this);
                AppMethodBeat.o(103618);
                return;
              }
              q.this.f(q.b(q.this));
              AppMethodBeat.o(103618);
            }
          });
          AppMethodBeat.o(103619);
        }
      });
      return;
    }
    c(paramInt1, paramInt2, paramString, params);
  }
  
  abstract void azz(String paramString);
  
  public final qr b(s params)
  {
    params = g(params);
    if (params != null) {
      return params.RRi;
    }
    return null;
  }
  
  public final void bie()
  {
    if (this.callback != null) {
      this.callback.onSceneEnd(3, -1, "", this);
    }
  }
  
  public final i bif()
  {
    return this.callback;
  }
  
  public final dca c(s params)
  {
    params = g(params);
    if (params != null) {
      return params.RRj;
    }
    return null;
  }
  
  abstract void c(int paramInt1, int paramInt2, String paramString, s params);
  
  public final cke d(s params)
  {
    params = g(params);
    if (params != null) {
      return params.RRh;
    }
    return null;
  }
  
  public int doScene(g paramg, i parami)
  {
    this.callback = parami;
    if (!Util.isNullOrNil(wwa))
    {
      Log.i("MicroMsg.NetSceneFaceRsaBase", "hy: has ticket: %s", new Object[] { wwa });
      azz(wwa);
      return f(paramg);
    }
    return getType();
  }
  
  public final int e(s params)
  {
    params = g(params);
    if (params != null) {
      return params.TJD;
    }
    return 0;
  }
  
  abstract int f(g paramg);
  
  protected abstract dcb g(s params);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.q
 * JD-Core Version:    0.7.0.1
 */