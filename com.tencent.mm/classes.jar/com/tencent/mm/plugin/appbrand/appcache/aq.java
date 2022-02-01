package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vending.c.a;

public final class aq
{
  private static final WxaCommLibRuntimeReader.a jnf;
  
  static
  {
    AppMethodBeat.i(44336);
    jnf = new WxaCommLibRuntimeReader.a();
    AppMethodBeat.o(44336);
  }
  
  public static void aWG()
  {
    AppMethodBeat.i(44332);
    doNotify();
    AppMethodBeat.o(44332);
  }
  
  public static void aWH()
  {
    AppMethodBeat.i(44333);
    doNotify();
    AppMethodBeat.o(44333);
  }
  
  public static void aWI()
  {
    AppMethodBeat.i(44334);
    try
    {
      WxaCommLibRuntimeReader.a locala = jnf;
      IPCVoid localIPCVoid = IPCVoid.gey;
      locala.aWP();
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
    Object localObject1 = jnf;
    Object localObject2 = IPCVoid.gey;
    localObject2 = ((WxaCommLibRuntimeReader.a)localObject1).aWP();
    if ((localObject2 instanceof WxaPkgWrappingInfo))
    {
      localObject1 = (WxaPkgWrappingInfo)localObject2;
      ac.i("MicroMsg.AppBrand.WxaCommLibPreloadNotify", "doNotify check ok ret[%s]", new Object[] { localObject2 });
      localObject2 = g.gia;
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject2[i];
        str = ai.getPackageName() + str;
        if (ai.aKN(str)) {
          XIPCInvoker.a(str, localObject1, a.class, null);
        }
        i += 1;
      }
      AppMethodBeat.o(44335);
      return;
    }
    ac.e("MicroMsg.AppBrand.WxaCommLibPreloadNotify", "doNotify check failed ret[%s]", new Object[] { localObject2 });
    AppMethodBeat.o(44335);
  }
  
  static final class a
    implements com.tencent.mm.ipcinvoker.b<WxaPkgWrappingInfo, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aq
 * JD-Core Version:    0.7.0.1
 */