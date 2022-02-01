package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KCgi;
import com.tencent.kinda.gen.KNetworkMockManager;
import com.tencent.kinda.gen.KNetworkService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.jr;
import com.tencent.mm.sdk.platformtools.Log;
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
      jr localjr = new jr();
      localjr.KOj = 0;
      localjr.KOi = new com.tencent.mm.bw.b(arrayOfByte);
      localjr.KOk = new com.tencent.mm.bw.b(arrayOfByte);
      localjr.Scene = paramInt;
      localjr.KOh = new com.tencent.mm.bw.b(arrayOfByte);
      com.tencent.mm.kernel.g.aAf();
      localjr.rBx = a.getUin();
      arrayOfByte = localjr.toByteArray();
      AppMethodBeat.o(18674);
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("MicroMsg.WXPNetworkServiceImpl", localIOException, "", new Object[0]);
      AppMethodBeat.o(18674);
    }
    return new byte[0];
  }
  
  public byte[] getBaseRequest(int paramInt)
  {
    AppMethodBeat.i(18672);
    Object localObject1 = new jr();
    byte[] arrayOfByte = getBaseRequestOnError(paramInt);
    Object localObject2 = com.tencent.mm.kernel.g.aAg().hqi;
    if (localObject2 == null)
    {
      Log.printErrStackTrace("MicroMsg.WXPNetworkServiceImpl", new Throwable(), "kernel().network().getNetSceneQueue() return null!!", new Object[0]);
      AppMethodBeat.o(18672);
      return arrayOfByte;
    }
    localObject2 = ((t)localObject2).iMw;
    if (localObject2 == null)
    {
      Log.printErrStackTrace("MicroMsg.WXPNetworkServiceImpl", new Throwable(), "netSceneQueue.getDispatcher() return null!!", new Object[0]);
      AppMethodBeat.o(18672);
      return arrayOfByte;
    }
    localObject2 = ((com.tencent.mm.network.g)localObject2).aZh();
    if (localObject2 == null)
    {
      Log.printErrStackTrace("MicroMsg.WXPNetworkServiceImpl", new Throwable(), "dispatcher.getAccInfo() return null!!", new Object[0]);
      AppMethodBeat.o(18672);
      return arrayOfByte;
    }
    ((jr)localObject1).KOj = d.KyO;
    ((jr)localObject1).Scene = paramInt;
    ((jr)localObject1).rBx = ((e)localObject2).getUin();
    com.tencent.mm.kernel.g.aAf();
    Log.v("MicroMsg.WXPNetworkServiceImpl", "uin: %d, uin2: %d, username: %s, wxusername: %s, islogin: %s", new Object[] { Integer.valueOf(a.getUin()), Integer.valueOf(((e)localObject2).getUin()), ((e)localObject2).getUsername(), ((e)localObject2).aZd(), Boolean.valueOf(((e)localObject2).aZb()) });
    ((jr)localObject1).KOi = com.tencent.mm.bw.b.cD(q.aoG().getBytes());
    if (((jr)localObject1).KOi.zy.length >= 16) {
      ((jr)localObject1).KOi = ((jr)localObject1).KOi.aiU(16);
    }
    ((jr)localObject1).KOk = com.tencent.mm.bw.b.cD(d.ics.getBytes());
    if (((jr)localObject1).KOk.zy.length >= 132) {
      ((jr)localObject1).KOk = ((jr)localObject1).KOk.aiU(132);
    }
    ((jr)localObject1).KOh = com.tencent.mm.bw.b.cD(((e)localObject2).qe(1));
    if (((jr)localObject1).KOh.zy.length >= 36) {
      ((jr)localObject1).KOh = ((jr)localObject1).KOh.aiU(36);
    }
    try
    {
      localObject1 = ((jr)localObject1).toByteArray();
      Log.v("MicroMsg.WXPNetworkServiceImpl", "result.size: %d", new Object[] { Integer.valueOf(localObject1.length) });
      AppMethodBeat.o(18672);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("MicroMsg.WXPNetworkServiceImpl", localIOException, "", new Object[0]);
      Log.v("MicroMsg.WXPNetworkServiceImpl", "exception: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(18672);
    }
    return arrayOfByte;
  }
  
  public void invoke(KCgi paramKCgi, KNetworkMockManager paramKNetworkMockManager)
  {
    AppMethodBeat.i(18673);
    Log.d("MicroMsg.WXPNetworkServiceImpl", "thread when WXPNetworkServiceImpl.invoke: %s, , thread id: %d", new Object[] { Thread.currentThread(), Long.valueOf(Thread.currentThread().getId()) });
    paramKNetworkMockManager = new WXPNetSceneBase(paramKCgi.getCgiId(), paramKCgi.getCgiId(), paramKCgi.getCgiUrl(), paramKCgi.getChannelType(), paramKCgi.getTimeout(), paramKCgi.getRetryCount(), paramKCgi.getRequestData(), paramKCgi, paramKNetworkMockManager);
    com.tencent.mm.kernel.g.aAg().hqi.a(paramKNetworkMockManager, 0);
    Log.d("MicroMsg.WXPNetworkServiceImpl", "do scene for: %s", new Object[] { paramKCgi.getCgiUrl() });
    AppMethodBeat.o(18673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.NetworkServiceImpl
 * JD-Core Version:    0.7.0.1
 */