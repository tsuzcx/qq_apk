package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KCgi;
import com.tencent.kinda.gen.KNetworkMockManager;
import com.tencent.kinda.gen.KNetworkService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.iv;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;

public class NetworkServiceImpl
  implements KNetworkService
{
  private static final String TAG = "MicroMsg.WXPNetworkServiceImpl";
  
  private byte[] getBaseRequestOnError(int paramInt)
  {
    AppMethodBeat.i(18674);
    try
    {
      byte[] arrayOfByte = new byte[2];
      byte[] tmp11_10 = arrayOfByte;
      tmp11_10[0] = 0;
      byte[] tmp16_11 = tmp11_10;
      tmp16_11[1] = 1;
      tmp16_11;
      iv localiv = new iv();
      localiv.DWJ = 0;
      localiv.DWI = new com.tencent.mm.bw.b(arrayOfByte);
      localiv.DWK = new com.tencent.mm.bw.b(arrayOfByte);
      localiv.Scene = paramInt;
      localiv.DWH = new com.tencent.mm.bw.b(arrayOfByte);
      g.agP();
      localiv.pAs = a.getUin();
      arrayOfByte = localiv.toByteArray();
      AppMethodBeat.o(18674);
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      ac.printErrStackTrace("MicroMsg.WXPNetworkServiceImpl", localIOException, "", new Object[0]);
      AppMethodBeat.o(18674);
    }
    return new byte[0];
  }
  
  public byte[] getBaseRequest(int paramInt)
  {
    AppMethodBeat.i(18672);
    Object localObject1 = new iv();
    byte[] arrayOfByte = getBaseRequestOnError(paramInt);
    Object localObject2 = g.agQ().ghe;
    if (localObject2 == null)
    {
      ac.printErrStackTrace("MicroMsg.WXPNetworkServiceImpl", new Throwable(), "kernel().network().getNetSceneQueue() return null!!", new Object[0]);
      AppMethodBeat.o(18672);
      return arrayOfByte;
    }
    localObject2 = ((com.tencent.mm.ak.q)localObject2).hwg;
    if (localObject2 == null)
    {
      ac.printErrStackTrace("MicroMsg.WXPNetworkServiceImpl", new Throwable(), "netSceneQueue.getDispatcher() return null!!", new Object[0]);
      AppMethodBeat.o(18672);
      return arrayOfByte;
    }
    localObject2 = ((e)localObject2).aBZ();
    if (localObject2 == null)
    {
      ac.printErrStackTrace("MicroMsg.WXPNetworkServiceImpl", new Throwable(), "dispatcher.getAccInfo() return null!!", new Object[0]);
      AppMethodBeat.o(18672);
      return arrayOfByte;
    }
    ((iv)localObject1).DWJ = d.DIc;
    ((iv)localObject1).Scene = paramInt;
    ((iv)localObject1).pAs = ((c)localObject2).getUin();
    g.agP();
    ac.v("MicroMsg.WXPNetworkServiceImpl", "uin: %d, uin2: %d, username: %s, wxusername: %s, islogin: %s", new Object[] { Integer.valueOf(a.getUin()), Integer.valueOf(((c)localObject2).getUin()), ((c)localObject2).getUsername(), ((c)localObject2).aBV(), Boolean.valueOf(((c)localObject2).aBT()) });
    ((iv)localObject1).DWI = com.tencent.mm.bw.b.cc(com.tencent.mm.compatible.deviceinfo.q.XX().getBytes());
    if (((iv)localObject1).DWI.xy.length >= 16) {
      ((iv)localObject1).DWI = ((iv)localObject1).DWI.XD(16);
    }
    ((iv)localObject1).DWK = com.tencent.mm.bw.b.cc(d.gMK.getBytes());
    if (((iv)localObject1).DWK.xy.length >= 132) {
      ((iv)localObject1).DWK = ((iv)localObject1).DWK.XD(132);
    }
    ((iv)localObject1).DWH = com.tencent.mm.bw.b.cc(((c)localObject2).mp(1));
    if (((iv)localObject1).DWH.xy.length >= 36) {
      ((iv)localObject1).DWH = ((iv)localObject1).DWH.XD(36);
    }
    try
    {
      localObject1 = ((iv)localObject1).toByteArray();
      ac.v("MicroMsg.WXPNetworkServiceImpl", "result.size: %d", new Object[] { Integer.valueOf(localObject1.length) });
      AppMethodBeat.o(18672);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      ac.printErrStackTrace("MicroMsg.WXPNetworkServiceImpl", localIOException, "", new Object[0]);
      ac.v("MicroMsg.WXPNetworkServiceImpl", "exception: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(18672);
    }
    return arrayOfByte;
  }
  
  public void invoke(KCgi paramKCgi, KNetworkMockManager paramKNetworkMockManager)
  {
    AppMethodBeat.i(18673);
    ac.d("MicroMsg.WXPNetworkServiceImpl", "thread when WXPNetworkServiceImpl.invoke: %s, , thread id: %d", new Object[] { Thread.currentThread(), Long.valueOf(Thread.currentThread().getId()) });
    paramKNetworkMockManager = new WXPNetSceneBase(paramKCgi.getCgiId(), paramKCgi.getCgiId(), paramKCgi.getCgiUrl(), paramKCgi.getChannelType(), paramKCgi.getTimeout(), paramKCgi.getRetryCount(), paramKCgi.getRequestData(), paramKCgi, paramKNetworkMockManager);
    g.agQ().ghe.a(paramKNetworkMockManager, 0);
    ac.d("MicroMsg.WXPNetworkServiceImpl", "do scene for: %s", new Object[] { paramKCgi.getCgiUrl() });
    AppMethodBeat.o(18673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.NetworkServiceImpl
 * JD-Core Version:    0.7.0.1
 */