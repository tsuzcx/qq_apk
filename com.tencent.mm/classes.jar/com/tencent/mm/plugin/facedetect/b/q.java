package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.modelsimple.o;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.protocal.protobuf.dts;
import com.tencent.mm.protocal.protobuf.dtt;
import com.tencent.mm.protocal.protobuf.sc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class q
  extends com.tencent.mm.am.q
{
  private static String zSh = null;
  protected com.tencent.mm.am.h callback = null;
  
  public static void atH(String paramString)
  {
    zSh = paramString;
  }
  
  protected static String bIQ()
  {
    return zSh;
  }
  
  public final void a(final int paramInt1, int paramInt2, String paramString, s params)
  {
    Log.i("MicroMsg.NetSceneFaceRsaBase", "hy: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 4) && (paramInt2 == -102))
    {
      paramInt1 = params.getReqObj().getRsaInfo().ver;
      Log.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103619);
          new o().doScene(q.a(q.this), new com.tencent.mm.am.h()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, p paramAnonymous2p)
            {
              AppMethodBeat.i(103618);
              Log.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2p.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                Log.e("MicroMsg.NetSceneFaceRsaBase", "hy: do scene err in rsa when get cert. clear ticket");
                q.dOF();
                q.this.atG(q.bIQ());
                q.this.callback.onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", q.this);
                AppMethodBeat.o(103618);
                return;
              }
              q.this.g(q.b(q.this));
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
  
  abstract void atG(String paramString);
  
  public final sc b(s params)
  {
    params = g(params);
    if (params != null) {
      return params.YOA;
    }
    return null;
  }
  
  public final void bFM()
  {
    if (this.callback != null) {
      this.callback.onSceneEnd(3, -1, "", this);
    }
  }
  
  public final com.tencent.mm.am.h bFN()
  {
    return this.callback;
  }
  
  public final dts c(s params)
  {
    params = g(params);
    if (params != null) {
      return params.YOB;
    }
    return null;
  }
  
  abstract void c(int paramInt1, int paramInt2, String paramString, s params);
  
  public final dal d(s params)
  {
    params = g(params);
    if (params != null) {
      return params.YOz;
    }
    return null;
  }
  
  public int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    this.callback = paramh;
    if (!Util.isNullOrNil(zSh))
    {
      Log.i("MicroMsg.NetSceneFaceRsaBase", "hy: has ticket: %s", new Object[] { zSh });
      atG(zSh);
      return g(paramg);
    }
    return getType();
  }
  
  public final int e(s params)
  {
    params = g(params);
    if (params != null) {
      return params.aaZs;
    }
    return 0;
  }
  
  abstract int g(g paramg);
  
  protected abstract dtt g(s params);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.q
 * JD-Core Version:    0.7.0.1
 */