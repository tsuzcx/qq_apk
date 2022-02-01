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
import com.tencent.mm.protocal.protobuf.jc;
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
      jc localjc = new jc();
      localjc.FCf = 0;
      localjc.FCe = new com.tencent.mm.bx.b(arrayOfByte);
      localjc.FCg = new com.tencent.mm.bx.b(arrayOfByte);
      localjc.Scene = paramInt;
      localjc.FCd = new com.tencent.mm.bx.b(arrayOfByte);
      g.ajA();
      localjc.qdX = a.getUin();
      arrayOfByte = localjc.toByteArray();
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
    Object localObject1 = new jc();
    byte[] arrayOfByte = getBaseRequestOnError(paramInt);
    Object localObject2 = g.ajB().gAO;
    if (localObject2 == null)
    {
      ad.printErrStackTrace("MicroMsg.WXPNetworkServiceImpl", new Throwable(), "kernel().network().getNetSceneQueue() return null!!", new Object[0]);
      AppMethodBeat.o(18672);
      return arrayOfByte;
    }
    localObject2 = ((com.tencent.mm.al.q)localObject2).hOv;
    if (localObject2 == null)
    {
      ad.printErrStackTrace("MicroMsg.WXPNetworkServiceImpl", new Throwable(), "netSceneQueue.getDispatcher() return null!!", new Object[0]);
      AppMethodBeat.o(18672);
      return arrayOfByte;
    }
    localObject2 = ((e)localObject2).aFc();
    if (localObject2 == null)
    {
      ad.printErrStackTrace("MicroMsg.WXPNetworkServiceImpl", new Throwable(), "dispatcher.getAccInfo() return null!!", new Object[0]);
      AppMethodBeat.o(18672);
      return arrayOfByte;
    }
    ((jc)localObject1).FCf = d.Fnj;
    ((jc)localObject1).Scene = paramInt;
    ((jc)localObject1).qdX = ((c)localObject2).getUin();
    g.ajA();
    ad.v("MicroMsg.WXPNetworkServiceImpl", "uin: %d, uin2: %d, username: %s, wxusername: %s, islogin: %s", new Object[] { Integer.valueOf(a.getUin()), Integer.valueOf(((c)localObject2).getUin()), ((c)localObject2).getUsername(), ((c)localObject2).aEY(), Boolean.valueOf(((c)localObject2).aEW()) });
    ((jc)localObject1).FCe = com.tencent.mm.bx.b.cj(com.tencent.mm.compatible.deviceinfo.q.aay().getBytes());
    if (((jc)localObject1).FCe.zr.length >= 16) {
      ((jc)localObject1).FCe = ((jc)localObject1).FCe.Zz(16);
    }
    ((jc)localObject1).FCg = com.tencent.mm.bx.b.cj(d.hgH.getBytes());
    if (((jc)localObject1).FCg.zr.length >= 132) {
      ((jc)localObject1).FCg = ((jc)localObject1).FCg.Zz(132);
    }
    ((jc)localObject1).FCd = com.tencent.mm.bx.b.cj(((c)localObject2).mO(1));
    if (((jc)localObject1).FCd.zr.length >= 36) {
      ((jc)localObject1).FCd = ((jc)localObject1).FCd.Zz(36);
    }
    try
    {
      localObject1 = ((jc)localObject1).toByteArray();
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
    g.ajB().gAO.a(paramKNetworkMockManager, 0);
    ad.d("MicroMsg.WXPNetworkServiceImpl", "do scene for: %s", new Object[] { paramKCgi.getCgiUrl() });
    AppMethodBeat.o(18673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.NetworkServiceImpl
 * JD-Core Version:    0.7.0.1
 */