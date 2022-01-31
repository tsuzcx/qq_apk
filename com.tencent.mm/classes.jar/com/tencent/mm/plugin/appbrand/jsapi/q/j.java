package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView.d;

public final class j
  implements a
{
  private static boolean aEF()
  {
    AppMethodBeat.i(131436);
    if (MMWebView.getUsingTbsCoreVersion(ah.getContext()) >= 36867)
    {
      AppMethodBeat.o(131436);
      return true;
    }
    if (MMWebView.getCurWebType() == WebView.d.BEq)
    {
      AppMethodBeat.o(131436);
      return true;
    }
    AppMethodBeat.o(131436);
    return false;
  }
  
  public final boolean a(c paramc, ai paramai)
  {
    AppMethodBeat.i(131435);
    boolean bool;
    if (!paramc.isRunning()) {
      bool = false;
    }
    while (bool)
    {
      AppMethodBeat.o(131435);
      return true;
      if (!(paramc instanceof h))
      {
        ab.e("MicroMsg.SensorJsEventControllerWx", "hasPermission AppBrandComponentWithExtra");
        bool = false;
      }
      else
      {
        h localh = (h)paramc;
        if (!(localh.getRuntime() instanceof o))
        {
          ab.e("MicroMsg.SensorJsEventControllerWx", "hasPermission not AppBrandRuntimeWC");
          bool = false;
        }
        else
        {
          bool = ((o)localh.getRuntime()).wO().a(paramc, paramai);
        }
      }
    }
    AppMethodBeat.o(131435);
    return false;
  }
  
  public final int aEB()
  {
    AppMethodBeat.i(131433);
    if (aEF())
    {
      AppMethodBeat.o(131433);
      return 5;
    }
    AppMethodBeat.o(131433);
    return 20;
  }
  
  public final int aEC()
  {
    AppMethodBeat.i(131434);
    if (aEF())
    {
      AppMethodBeat.o(131434);
      return 20;
    }
    AppMethodBeat.o(131434);
    return 200;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.j
 * JD-Core Version:    0.7.0.1
 */