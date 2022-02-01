package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.luggage.xweb_ext.extendplugin.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.ae.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/AppBrandPluginHandlerFactoryWC;", "Lcom/tencent/mm/plugin/appbrand/extendplugin/AppBrandPluginHandlerFactory;", "()V", "createHandler", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/IExtendPluginHandler;", "type", "", "plugin-appbrand-integration_release"})
public final class a
  extends d
{
  public final b dW(String paramString)
  {
    AppMethodBeat.i(229694);
    p.h(paramString, "type");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        paramString = super.dW(paramString);
        AppMethodBeat.o(229694);
        return paramString;
      } while (!paramString.equals("voiproom"));
      paramString = (b)new e();
      AppMethodBeat.o(229694);
      return paramString;
    } while (!paramString.equals("webgl"));
    paramString = (b)new com.tencent.mm.plugin.appbrand.jsapi.b.a.a();
    AppMethodBeat.o(229694);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a
 * JD-Core Version:    0.7.0.1
 */