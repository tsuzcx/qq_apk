package com.tencent.mm.plugin.appbrand.weishi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class g
{
  public static boolean J(i parami)
  {
    AppMethodBeat.i(133642);
    if (parami != null)
    {
      boolean bool = "wxfe02ecfe70800f46".equalsIgnoreCase(parami.mAppId);
      AppMethodBeat.o(133642);
      return bool;
    }
    AppMethodBeat.o(133642);
    return false;
  }
  
  public static void aOu()
  {
    AppMethodBeat.i(155945);
    if (ah.brt())
    {
      aOv();
      AppMethodBeat.o(155945);
      return;
    }
    XIPCInvoker.a("com.tencent.mm", new IPCString("wxfe02ecfe70800f46"), g.a.class, new g.1());
    AppMethodBeat.o(155945);
  }
  
  static void aOv()
  {
    AppMethodBeat.i(155946);
    ab.i("MicroMsg.AppBrandWeishiUtil", "doSendEventAppBrandWeishiUIReady");
    f localf = new f();
    a.ymk.l(localf);
    AppMethodBeat.o(155946);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.weishi.g
 * JD-Core Version:    0.7.0.1
 */