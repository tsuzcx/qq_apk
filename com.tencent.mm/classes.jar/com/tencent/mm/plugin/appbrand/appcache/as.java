package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vending.c.a;

public final class as
{
  private static final WxaCommLibRuntimeReader.a jKd;
  
  static
  {
    AppMethodBeat.i(44336);
    jKd = new WxaCommLibRuntimeReader.a();
    AppMethodBeat.o(44336);
  }
  
  public static void baC()
  {
    AppMethodBeat.i(44332);
    doNotify();
    AppMethodBeat.o(44332);
  }
  
  public static void baD()
  {
    AppMethodBeat.i(44333);
    doNotify();
    AppMethodBeat.o(44333);
  }
  
  public static void baE()
  {
    AppMethodBeat.i(44334);
    try
    {
      WxaCommLibRuntimeReader.a locala = jKd;
      IPCVoid localIPCVoid = IPCVoid.gAP;
      locala.baL();
      AppMethodBeat.o(44334);
      return;
    }
    catch (WxaCommLibRuntimeReader.AccountNotReadyError localAccountNotReadyError)
    {
      com.tencent.mm.model.b localb = new com.tencent.mm.model.b();
      AppMethodBeat.o(44334);
      throw localb;
    }
  }
  
  private static void doNotify()
  {
    AppMethodBeat.i(44335);
    Object localObject1 = jKd;
    Object localObject2 = IPCVoid.gAP;
    localObject2 = ((WxaCommLibRuntimeReader.a)localObject1).baL();
    if ((localObject2 instanceof WxaPkgWrappingInfo))
    {
      localObject1 = (WxaPkgWrappingInfo)localObject2;
      ae.i("MicroMsg.AppBrand.WxaCommLibPreloadNotify", "doNotify check ok ret[%s]", new Object[] { localObject2 });
      localObject2 = g.gEr;
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject2[i];
        str = ak.getPackageName() + str;
        if (ak.aRQ(str)) {
          XIPCInvoker.a(str, localObject1, a.class, null);
        }
        i += 1;
      }
      AppMethodBeat.o(44335);
      return;
    }
    ae.e("MicroMsg.AppBrand.WxaCommLibPreloadNotify", "doNotify check failed ret[%s]", new Object[] { localObject2 });
    AppMethodBeat.o(44335);
  }
  
  static final class a
    implements com.tencent.mm.ipcinvoker.b<WxaPkgWrappingInfo, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.as
 * JD-Core Version:    0.7.0.1
 */