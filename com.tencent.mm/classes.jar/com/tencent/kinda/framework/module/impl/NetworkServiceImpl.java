package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KCgi;
import com.tencent.kinda.gen.KNetworkMockManager;
import com.tencent.kinda.gen.KNetworkService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.hq;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public class NetworkServiceImpl
  implements KNetworkService
{
  private static final String TAG = "MicroMsg.WXPNetworkServiceImpl";
  
  public byte[] getBaseRequest(int paramInt)
  {
    AppMethodBeat.i(144555);
    Object localObject = new hq();
    g.RM();
    c localc = g.RK().eHt.ftA.adI();
    ((hq)localObject).wur = d.whH;
    ((hq)localObject).Scene = paramInt;
    ((hq)localObject).lGw = localc.getUin();
    g.RM();
    g.RJ();
    ab.v("MicroMsg.WXPNetworkServiceImpl", "uin: %d, uin2: %d, username: %s, wxusername: %s, islogin: %s", new Object[] { Integer.valueOf(a.getUin()), Integer.valueOf(localc.getUin()), localc.getUsername(), localc.adE(), Boolean.valueOf(localc.adC()) });
    ((hq)localObject).wuq = com.tencent.mm.bv.b.bL(q.LK().getBytes());
    if (((hq)localObject).wuq.pW.length >= 16) {
      ((hq)localObject).wuq = ((hq)localObject).wuq.Mz(16);
    }
    ((hq)localObject).wus = com.tencent.mm.bv.b.bL(d.eQs.getBytes());
    if (((hq)localObject).wus.pW.length >= 132) {
      ((hq)localObject).wus = ((hq)localObject).wus.Mz(132);
    }
    ((hq)localObject).wup = com.tencent.mm.bv.b.bL(localc.jN(1));
    if (((hq)localObject).wup.pW.length >= 36) {
      ((hq)localObject).wup = ((hq)localObject).wup.Mz(36);
    }
    try
    {
      localObject = ((hq)localObject).toByteArray();
      ab.v("MicroMsg.WXPNetworkServiceImpl", "result.size: %d", new Object[] { Integer.valueOf(localObject.length) });
      AppMethodBeat.o(144555);
      return localObject;
    }
    catch (IOException localIOException)
    {
      ab.printErrStackTrace("MicroMsg.WXPNetworkServiceImpl", localIOException, "", new Object[0]);
      ab.v("MicroMsg.WXPNetworkServiceImpl", "exception: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(144555);
    }
    return new byte[0];
  }
  
  public void invoke(KCgi paramKCgi, KNetworkMockManager paramKNetworkMockManager)
  {
    AppMethodBeat.i(144556);
    ab.i("MicroMsg.WXPNetworkServiceImpl", "thread when WXPNetworkServiceImpl.invoke: %s, , thread id: %d", new Object[] { Thread.currentThread(), Long.valueOf(Thread.currentThread().getId()) });
    paramKNetworkMockManager = new WXPNetSceneBase(paramKCgi.getCgiId(), paramKCgi.getCgiId(), paramKCgi.getCgiUrl(), paramKCgi.getChannelType(), paramKCgi.getTimeout(), paramKCgi.getRetryCount(), paramKCgi.getRequestData(), paramKCgi, paramKNetworkMockManager);
    g.RK().eHt.a(paramKNetworkMockManager, 0);
    ab.e("MicroMsg.WXPNetworkServiceImpl", "has do scene for: %s", new Object[] { paramKCgi.getCgiUrl() });
    AppMethodBeat.o(144556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.NetworkServiceImpl
 * JD-Core Version:    0.7.0.1
 */