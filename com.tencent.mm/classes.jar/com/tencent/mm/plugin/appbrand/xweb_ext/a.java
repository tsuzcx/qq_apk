package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.luggage.xweb_ext.extendplugin.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.d;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/AppBrandPluginHandlerFactoryWC;", "Lcom/tencent/mm/plugin/appbrand/extendplugin/AppBrandPluginHandlerFactory;", "()V", "createHandler", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/IExtendPluginHandler;", "type", "", "plugin-appbrand-integration_release"})
public final class a
  extends d
{
  public final b dA(String paramString)
  {
    AppMethodBeat.i(189738);
    p.h(paramString, "type");
    switch (paramString.hashCode())
    {
    }
    do
    {
      paramString = super.dA(paramString);
      AppMethodBeat.o(189738);
      return paramString;
    } while (!paramString.equals("webgl"));
    paramString = (b)new com.tencent.mm.plugin.appbrand.jsapi.a.a.a();
    AppMethodBeat.o(189738);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a
 * JD-Core Version:    0.7.0.1
 */