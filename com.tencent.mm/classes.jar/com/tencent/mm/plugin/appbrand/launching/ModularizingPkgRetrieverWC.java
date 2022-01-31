package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.k.e;
import com.tencent.mm.plugin.appbrand.k.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.e.a;

public final class ModularizingPkgRetrieverWC
  implements e, a
{
  final ModularizingPkgRetrieverWC.LoadParams img;
  volatile e.a imh;
  
  private ModularizingPkgRetrieverWC(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(131943);
    this.img = new ModularizingPkgRetrieverWC.LoadParams(paramString1, paramInt1, paramInt2, paramString2, (byte)0);
    AppMethodBeat.o(131943);
  }
  
  public final void a(e.a parama)
  {
    this.imh = parama;
  }
  
  public final void dead()
  {
    this.imh = null;
  }
  
  public final void start()
  {
    AppMethodBeat.i(131944);
    ab.i("MicroMsg.AppBrand.ModularizingPkgRetrieverWC[modularizing]", "startLoad %s", new Object[] { this.img.toString() });
    XIPCInvoker.a("com.tencent.mm", this.img, ModularizingPkgRetrieverWC.a.class, new ModularizingPkgRetrieverWC.2(this));
    AppMethodBeat.o(131944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC
 * JD-Core Version:    0.7.0.1
 */