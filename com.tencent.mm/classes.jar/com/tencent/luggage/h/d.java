package com.tencent.luggage.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.b.f;
import com.tencent.mm.plugin.appbrand.config.b.j;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.apache.commons.c.i;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/skyline/SkylineHelper;", "", "()V", "TAG", "", "isSkyline", "", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "libReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "url", "luggage-skyline-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d evX;
  
  static
  {
    AppMethodBeat.i(220009);
    evX = new d();
    AppMethodBeat.o(220009);
  }
  
  public static boolean a(com.tencent.mm.plugin.appbrand.config.b paramb, ICommLibReader paramICommLibReader, String paramString)
  {
    AppMethodBeat.i(220001);
    s.u(paramb, "config");
    com.tencent.luggage.h.a.b localb = com.tencent.luggage.h.a.b.ewj;
    if (!com.tencent.luggage.h.a.b.atc())
    {
      Log.i("SkylineHelper", s.X("url:%s isWebView, abtest: ", Integer.valueOf(c.asS())), new Object[] { paramString });
      AppMethodBeat.o(220001);
      return false;
    }
    localb = com.tencent.luggage.h.a.b.ewj;
    if (!com.tencent.luggage.h.a.b.a(paramICommLibReader))
    {
      Log.i("SkylineHelper", "url:%s isFlutterView, lib not support", new Object[] { paramString });
      AppMethodBeat.o(220001);
      return false;
    }
    paramICommLibReader = paramb.Xk(paramString);
    s.s(paramICommLibReader, "config.getPageConfig(url)");
    if (i.qA("webview", paramICommLibReader.qWz))
    {
      Log.i("SkylineHelper", "url:%s page config isWebView", new Object[] { paramString });
      AppMethodBeat.o(220001);
      return false;
    }
    if (i.qA("skyline", paramICommLibReader.qWz))
    {
      Log.i("SkylineHelper", "url:%s page config isFlutter", new Object[] { paramString });
      AppMethodBeat.o(220001);
      return true;
    }
    boolean bool = i.qA(paramb.qVP.qWb, "skyline");
    Log.i("SkylineHelper", "url:%s global default config isSkyline:%b", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(220001);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.h.d
 * JD-Core Version:    0.7.0.1
 */