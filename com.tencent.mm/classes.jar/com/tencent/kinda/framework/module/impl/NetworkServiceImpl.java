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
import com.tencent.mm.protocal.protobuf.ip;
import com.tencent.mm.sdk.platformtools.ad;
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
      ip localip = new ip();
      localip.CEj = 0;
      localip.CEi = new com.tencent.mm.bx.b(arrayOfByte);
      localip.CEk = new com.tencent.mm.bx.b(arrayOfByte);
      localip.Scene = paramInt;
      localip.CEh = new com.tencent.mm.bx.b(arrayOfByte);
      g.afz();
      localip.oXh = a.getUin();
      arrayOfByte = localip.toByteArray();
      AppMethodBeat.o(18674);
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("MicroMsg.WXPNetworkServiceImpl", localIOException, "", new Object[0]);
      AppMethodBeat.o(18674);
    }
    return new byte[0];
  }
  
  public byte[] getBaseRequest(int paramInt)
  {
    AppMethodBeat.i(18672);
    Object localObject1 = new ip();
    byte[] arrayOfByte = getBaseRequestOnError(paramInt);
    Object localObject2 = g.afA().gcy;
    if (localObject2 == null)
    {
      ad.printErrStackTrace("MicroMsg.WXPNetworkServiceImpl", new Throwable(), "kernel().network().getNetSceneQueue() return null!!", new Object[0]);
      AppMethodBeat.o(18672);
      return arrayOfByte;
    }
    localObject2 = ((com.tencent.mm.al.q)localObject2).gVH;
    if (localObject2 == null)
    {
      ad.printErrStackTrace("MicroMsg.WXPNetworkServiceImpl", new Throwable(), "netSceneQueue.getDispatcher() return null!!", new Object[0]);
      AppMethodBeat.o(18672);
      return arrayOfByte;
    }
    localObject2 = ((e)localObject2).avg();
    if (localObject2 == null)
    {
      ad.printErrStackTrace("MicroMsg.WXPNetworkServiceImpl", new Throwable(), "dispatcher.getAccInfo() return null!!", new Object[0]);
      AppMethodBeat.o(18672);
      return arrayOfByte;
    }
    ((ip)localObject1).CEj = d.CpK;
    ((ip)localObject1).Scene = paramInt;
    ((ip)localObject1).oXh = ((c)localObject2).getUin();
    g.afz();
    ad.v("MicroMsg.WXPNetworkServiceImpl", "uin: %d, uin2: %d, username: %s, wxusername: %s, islogin: %s", new Object[] { Integer.valueOf(a.getUin()), Integer.valueOf(((c)localObject2).getUin()), ((c)localObject2).getUsername(), ((c)localObject2).avc(), Boolean.valueOf(((c)localObject2).ava()) });
    ((ip)localObject1).CEi = com.tencent.mm.bx.b.cd(com.tencent.mm.compatible.deviceinfo.q.Xa().getBytes());
    if (((ip)localObject1).CEi.wA.length >= 16) {
      ((ip)localObject1).CEi = ((ip)localObject1).CEi.Vu(16);
    }
    ((ip)localObject1).CEk = com.tencent.mm.bx.b.cd(d.glX.getBytes());
    if (((ip)localObject1).CEk.wA.length >= 132) {
      ((ip)localObject1).CEk = ((ip)localObject1).CEk.Vu(132);
    }
    ((ip)localObject1).CEh = com.tencent.mm.bx.b.cd(((c)localObject2).mq(1));
    if (((ip)localObject1).CEh.wA.length >= 36) {
      ((ip)localObject1).CEh = ((ip)localObject1).CEh.Vu(36);
    }
    try
    {
      localObject1 = ((ip)localObject1).toByteArray();
      ad.v("MicroMsg.WXPNetworkServiceImpl", "result.size: %d", new Object[] { Integer.valueOf(localObject1.length) });
      AppMethodBeat.o(18672);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("MicroMsg.WXPNetworkServiceImpl", localIOException, "", new Object[0]);
      ad.v("MicroMsg.WXPNetworkServiceImpl", "exception: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(18672);
    }
    return arrayOfByte;
  }
  
  public void invoke(KCgi paramKCgi, KNetworkMockManager paramKNetworkMockManager)
  {
    AppMethodBeat.i(18673);
    ad.d("MicroMsg.WXPNetworkServiceImpl", "thread when WXPNetworkServiceImpl.invoke: %s, , thread id: %d", new Object[] { Thread.currentThread(), Long.valueOf(Thread.currentThread().getId()) });
    paramKNetworkMockManager = new WXPNetSceneBase(paramKCgi.getCgiId(), paramKCgi.getCgiId(), paramKCgi.getCgiUrl(), paramKCgi.getChannelType(), paramKCgi.getTimeout(), paramKCgi.getRetryCount(), paramKCgi.getRequestData(), paramKCgi, paramKNetworkMockManager);
    g.afA().gcy.a(paramKNetworkMockManager, 0);
    ad.d("MicroMsg.WXPNetworkServiceImpl", "do scene for: %s", new Object[] { paramKCgi.getCgiUrl() });
    AppMethodBeat.o(18673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.NetworkServiceImpl
 * JD-Core Version:    0.7.0.1
 */