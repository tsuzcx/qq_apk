package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Objects;

public final class au
{
  private static final WxaCommLibRuntimeReader.a qFM;
  
  static
  {
    AppMethodBeat.i(44336);
    qFM = new WxaCommLibRuntimeReader.a();
    AppMethodBeat.o(44336);
  }
  
  public static void cgu()
  {
    AppMethodBeat.i(44332);
    doNotify();
    AppMethodBeat.o(44332);
  }
  
  public static void cgv()
  {
    AppMethodBeat.i(44333);
    doNotify();
    AppMethodBeat.o(44333);
  }
  
  public static void cgw()
  {
    AppMethodBeat.i(44334);
    try
    {
      WxaCommLibRuntimeReader.a locala = qFM;
      IPCVoid localIPCVoid = IPCVoid.mzv;
      locala.cgD();
      AppMethodBeat.o(44334);
      return;
    }
    catch (WxaCommLibRuntimeReader.AccountNotReadyError localAccountNotReadyError)
    {
      b localb = new b();
      AppMethodBeat.o(44334);
      throw localb;
    }
  }
  
  private static void doNotify()
  {
    AppMethodBeat.i(44335);
    Object localObject1 = qFM;
    Object localObject2 = IPCVoid.mzv;
    localObject2 = ((WxaCommLibRuntimeReader.a)localObject1).cgD();
    if ((localObject2 instanceof ICommLibReader))
    {
      localObject1 = (ICommLibReader)localObject2;
      Log.i("MicroMsg.AppBrand.WxaCommLibPreloadNotify", "doNotify check ok ret[%s]", new Object[] { localObject2 });
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrand.WxaCommLibPreloadNotify", "doNotify invoke ipc reset with reader:%s", new Object[] { localObject1 });
      Objects.requireNonNull(localObject1);
      localObject2 = h.mDj;
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject2[i];
        str = MMApplicationContext.getPackageName() + str;
        if (MMApplicationContext.isProcessExist(str)) {
          XIPCInvoker.a(str, localObject1, au.a.class, null);
        }
        i += 1;
      }
      if ((localObject2 instanceof WxaPkgWrappingInfo))
      {
        localObject1 = aw.a((WxaPkgWrappingInfo)localObject2);
        Log.i("MicroMsg.AppBrand.WxaCommLibPreloadNotify", "doNotify check ok ret[%s]", new Object[] { localObject2 });
      }
      else
      {
        Log.e("MicroMsg.AppBrand.WxaCommLibPreloadNotify", "doNotify check failed ret[%s]", new Object[] { localObject2 });
        localObject1 = AssetReader.qDV;
      }
    }
    AppMethodBeat.o(44335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.au
 * JD-Core Version:    0.7.0.1
 */