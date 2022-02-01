package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vending.c.a;

public final class aq
{
  private static final WxaCommLibRuntimeReader.a iMY;
  
  static
  {
    AppMethodBeat.i(44336);
    iMY = new WxaCommLibRuntimeReader.a();
    AppMethodBeat.o(44336);
  }
  
  public static void aPO()
  {
    AppMethodBeat.i(44332);
    doNotify();
    AppMethodBeat.o(44332);
  }
  
  public static void aPP()
  {
    AppMethodBeat.i(44333);
    doNotify();
    AppMethodBeat.o(44333);
  }
  
  public static void aPQ()
  {
    AppMethodBeat.i(44334);
    try
    {
      WxaCommLibRuntimeReader.a locala = iMY;
      IPCVoid localIPCVoid = IPCVoid.fZS;
      locala.aPX();
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
    Object localObject1 = iMY;
    Object localObject2 = IPCVoid.fZS;
    localObject2 = ((WxaCommLibRuntimeReader.a)localObject1).aPX();
    if ((localObject2 instanceof WxaPkgWrappingInfo))
    {
      localObject1 = (WxaPkgWrappingInfo)localObject2;
      ad.i("MicroMsg.AppBrand.WxaCommLibPreloadNotify", "doNotify check ok ret[%s]", new Object[] { localObject2 });
      localObject2 = g.gdu;
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject2[i];
        str = aj.getPackageName() + str;
        if (aj.aFw(str)) {
          XIPCInvoker.a(str, localObject1, a.class, null);
        }
        i += 1;
      }
      AppMethodBeat.o(44335);
      return;
    }
    ad.e("MicroMsg.AppBrand.WxaCommLibPreloadNotify", "doNotify check failed ret[%s]", new Object[] { localObject2 });
    AppMethodBeat.o(44335);
  }
  
  static final class a
    implements com.tencent.mm.ipcinvoker.b<WxaPkgWrappingInfo, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aq
 * JD-Core Version:    0.7.0.1
 */