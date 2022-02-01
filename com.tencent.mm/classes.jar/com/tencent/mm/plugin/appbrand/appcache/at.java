package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class at
{
  private static final WxaCommLibRuntimeReader.a nFT;
  
  static
  {
    AppMethodBeat.i(44336);
    nFT = new WxaCommLibRuntimeReader.a();
    AppMethodBeat.o(44336);
  }
  
  public static void bGY()
  {
    AppMethodBeat.i(44332);
    doNotify();
    AppMethodBeat.o(44332);
  }
  
  public static void bGZ()
  {
    AppMethodBeat.i(44333);
    doNotify();
    AppMethodBeat.o(44333);
  }
  
  public static void bHa()
  {
    AppMethodBeat.i(44334);
    try
    {
      WxaCommLibRuntimeReader.a locala = nFT;
      IPCVoid localIPCVoid = IPCVoid.jZu;
      locala.bHg();
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
    Object localObject1 = nFT;
    Object localObject2 = IPCVoid.jZu;
    localObject2 = ((WxaCommLibRuntimeReader.a)localObject1).bHg();
    if ((localObject2 instanceof WxaPkgWrappingInfo))
    {
      localObject1 = (WxaPkgWrappingInfo)localObject2;
      Log.i("MicroMsg.AppBrand.WxaCommLibPreloadNotify", "doNotify check ok ret[%s]", new Object[] { localObject2 });
      localObject2 = h.kda;
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject2[i];
        str = MMApplicationContext.getPackageName() + str;
        if (MMApplicationContext.isProcessExist(str)) {
          XIPCInvoker.a(str, localObject1, a.class, null);
        }
        i += 1;
      }
      AppMethodBeat.o(44335);
      return;
    }
    Log.e("MicroMsg.AppBrand.WxaCommLibPreloadNotify", "doNotify check failed ret[%s]", new Object[] { localObject2 });
    AppMethodBeat.o(44335);
  }
  
  static final class a
    implements d<WxaPkgWrappingInfo, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.at
 * JD-Core Version:    0.7.0.1
 */