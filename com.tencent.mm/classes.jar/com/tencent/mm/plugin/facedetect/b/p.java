package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.r;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.protocal.protobuf.ctb;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class p
  extends r
  implements com.tencent.mm.network.m
{
  static String sQc = null;
  protected i callback = null;
  
  public static void arz(String paramString)
  {
    sQc = paramString;
  }
  
  protected static String bbG()
  {
    return sQc;
  }
  
  public final void a(final int paramInt1, int paramInt2, String paramString, s params)
  {
    Log.i("MicroMsg.NetSceneFaceRsaBase", "hy: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 4) && (paramInt2 == -102))
    {
      paramInt1 = params.getReqObj().getRsaInfo().ver;
      Log.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103619);
          new com.tencent.mm.modelsimple.m().doScene(p.a(p.this), new i()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
            {
              AppMethodBeat.i(103618);
              Log.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2q.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                Log.e("MicroMsg.NetSceneFaceRsaBase", "hy: do scene err in rsa when get cert. clear ticket");
                p.cSQ();
                p.this.ary(p.bbG());
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
    c(paramInt1, paramInt2, paramString, params);
  }
  
  public final void aYP()
  {
    if (this.callback != null) {
      this.callback.onSceneEnd(3, -1, "", this);
    }
  }
  
  public final i aYQ()
  {
    return this.callback;
  }
  
  abstract void ary(String paramString);
  
  public final qy b(s params)
  {
    params = f(params);
    if (params != null) {
      return params.KQk;
    }
    return null;
  }
  
  public final ctb c(s params)
  {
    params = f(params);
    if (params != null) {
      return params.KQl;
    }
    return null;
  }
  
  abstract void c(int paramInt1, int paramInt2, String paramString, s params);
  
  public final ccb d(s params)
  {
    params = f(params);
    if (params != null) {
      return params.KQj;
    }
    return null;
  }
  
  public int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    this.callback = parami;
    if (!Util.isNullOrNil(sQc))
    {
      Log.i("MicroMsg.NetSceneFaceRsaBase", "hy: has ticket: %s", new Object[] { sQc });
      ary(sQc);
      return f(paramg);
    }
    return getType();
  }
  
  abstract int f(com.tencent.mm.network.g paramg);
  
  protected abstract ctc f(s params);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.p
 * JD-Core Version:    0.7.0.1
 */