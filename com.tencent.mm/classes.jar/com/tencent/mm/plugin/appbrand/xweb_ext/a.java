package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.luggage.k.a.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.d;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/AppBrandPluginHandlerFactoryWC;", "Lcom/tencent/mm/plugin/appbrand/extendplugin/AppBrandPluginHandlerFactory;", "()V", "createHandler", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/IExtendPluginHandler;", "type", "", "plugin-appbrand-integration_release"})
public final class a
  extends d
{
  public final b cJ(String paramString)
  {
    AppMethodBeat.i(196546);
    k.h(paramString, "type");
    switch (paramString.hashCode())
    {
    }
    do
    {
      paramString = super.cJ(paramString);
      AppMethodBeat.o(196546);
      return paramString;
    } while (!paramString.equals("webgl"));
    paramString = (b)new com.tencent.mm.plugin.appbrand.jsapi.b.a.a();
    AppMethodBeat.o(196546);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a
 * JD-Core Version:    0.7.0.1
 */