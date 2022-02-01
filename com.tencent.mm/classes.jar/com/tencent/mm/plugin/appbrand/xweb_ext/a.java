package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.luggage.xweb_ext.extendplugin.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.d;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/AppBrandPluginHandlerFactoryWC;", "Lcom/tencent/mm/plugin/appbrand/extendplugin/AppBrandPluginHandlerFactory;", "()V", "createHandler", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/IExtendPluginHandler;", "type", "", "plugin-appbrand-integration_release"})
public final class a
  extends d
{
  public final b dD(String paramString)
  {
    AppMethodBeat.i(224027);
    p.h(paramString, "type");
    switch (paramString.hashCode())
    {
    }
    do
    {
      paramString = super.dD(paramString);
      AppMethodBeat.o(224027);
      return paramString;
    } while (!paramString.equals("webgl"));
    paramString = (b)new com.tencent.mm.plugin.appbrand.jsapi.a.a.a();
    AppMethodBeat.o(224027);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a
 * JD-Core Version:    0.7.0.1
 */