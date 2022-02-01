package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KCgi;
import com.tencent.kinda.gen.KNetworkMockManager;
import com.tencent.kinda.gen.KNetworkService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.e;
import com.tencent.mm.network.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.kc;
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
      kc localkc = new kc();
      localkc.YMr = 0;
      localkc.YMq = new com.tencent.mm.bx.b(arrayOfByte);
      localkc.YMs = new com.tencent.mm.bx.b(arrayOfByte);
      localkc.IJG = paramInt;
      localkc.YMp = new com.tencent.mm.bx.b(arrayOfByte);
      h.baC();
      localkc.yth = com.tencent.mm.kernel.b.getUin();
      arrayOfByte = localkc.toByteArray();
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
    Object localObject1 = new kc();
    byte[] arrayOfByte = getBaseRequestOnError(paramInt);
    Object localObject2 = h.baD().mCm;
    if (localObject2 == null)
    {
      Log.printErrStackTrace("MicroMsg.WXPNetworkServiceImpl", new Throwable(), "kernel().network().getNetSceneQueue() return null!!", new Object[0]);
      AppMethodBeat.o(18672);
      return arrayOfByte;
    }
    localObject2 = ((s)localObject2).oun;
    if (localObject2 == null)
    {
      Log.printErrStackTrace("MicroMsg.WXPNetworkServiceImpl", new Throwable(), "netSceneQueue.getDispatcher() return null!!", new Object[0]);
      AppMethodBeat.o(18672);
      return arrayOfByte;
    }
    localObject2 = ((g)localObject2).bGg();
    if (localObject2 == null)
    {
      Log.printErrStackTrace("MicroMsg.WXPNetworkServiceImpl", new Throwable(), "dispatcher.getAccInfo() return null!!", new Object[0]);
      AppMethodBeat.o(18672);
      return arrayOfByte;
    }
    ((kc)localObject1).YMr = d.Yxh;
    ((kc)localObject1).IJG = paramInt;
    ((kc)localObject1).yth = ((e)localObject2).getUin();
    h.baC();
    Log.v("MicroMsg.WXPNetworkServiceImpl", "uin: %d, uin2: %d, username: %s, wxusername: %s, islogin: %s", new Object[] { Integer.valueOf(com.tencent.mm.kernel.b.getUin()), Integer.valueOf(((e)localObject2).getUin()), ((e)localObject2).getUsername(), ((e)localObject2).bGc(), Boolean.valueOf(((e)localObject2).bGa()) });
    ((kc)localObject1).YMq = com.tencent.mm.bx.b.cX(q.aPg().getBytes());
    if (((kc)localObject1).YMq.Op.length >= 16) {
      ((kc)localObject1).YMq = ((kc)localObject1).YMq.axn(16);
    }
    ((kc)localObject1).YMs = com.tencent.mm.bx.b.cX(d.nsC.getBytes());
    if (((kc)localObject1).YMs.Op.length >= 132) {
      ((kc)localObject1).YMs = ((kc)localObject1).YMs.axn(132);
    }
    try
    {
      ((kc)localObject1).YMp = com.tencent.mm.bx.b.pv(new String(""), "UTF-8");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          localObject1 = ((kc)localObject1).toByteArray();
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
        localException = localException;
        Log.e("MicroMsg.WXPNetworkServiceImpl", localException.getLocalizedMessage());
      }
    }
    return arrayOfByte;
  }
  
  public void invoke(KCgi paramKCgi, KNetworkMockManager paramKNetworkMockManager)
  {
    AppMethodBeat.i(18673);
    Log.d("MicroMsg.WXPNetworkServiceImpl", "thread when WXPNetworkServiceImpl.invoke: %s, , thread id: %d", new Object[] { Thread.currentThread(), Long.valueOf(Thread.currentThread().getId()) });
    paramKNetworkMockManager = new WXPNetSceneBase(paramKCgi.getCgiId(), paramKCgi.getCgiId(), paramKCgi.getCgiUrl(), paramKCgi.getChannelType(), paramKCgi.getTimeout(), paramKCgi.getRetryCount(), paramKCgi.getRequestData(), paramKCgi, paramKNetworkMockManager);
    h.baD().mCm.a(paramKNetworkMockManager, 0);
    Log.d("MicroMsg.WXPNetworkServiceImpl", "do scene for: %s", new Object[] { paramKCgi.getCgiUrl() });
    AppMethodBeat.o(18673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.NetworkServiceImpl
 * JD-Core Version:    0.7.0.1
 */