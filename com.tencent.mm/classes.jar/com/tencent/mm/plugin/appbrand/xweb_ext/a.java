package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.ag.e;
import com.tencent.mm.plugin.appbrand.xweb_ext.video.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/AppBrandPluginHandlerFactoryWC;", "Lcom/tencent/mm/plugin/appbrand/extendplugin/AppBrandPluginHandlerFactory;", "()V", "createHandler", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/IExtendPluginHandler;", "type", "", "plugin-appbrand-integration_release"})
public final class a
  extends d
{
  public final com.tencent.luggage.xweb_ext.extendplugin.a.b ex(String paramString)
  {
    AppMethodBeat.i(284256);
    p.k(paramString, "type");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          paramString = super.ex(paramString);
          AppMethodBeat.o(284256);
          return paramString;
        } while (!paramString.equals("voiproom"));
        paramString = (com.tencent.luggage.xweb_ext.extendplugin.a.b)new e();
        AppMethodBeat.o(284256);
        return paramString;
      } while (!paramString.equals("webgl"));
      paramString = (com.tencent.luggage.xweb_ext.extendplugin.a.b)new com.tencent.mm.plugin.appbrand.jsapi.b.a.a();
      AppMethodBeat.o(284256);
      return paramString;
    } while (!paramString.equals("video"));
    paramString = new f();
    paramString.a((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b)new com.tencent.mm.plugin.appbrand.xweb_ext.video.a());
    paramString = (com.tencent.luggage.xweb_ext.extendplugin.a.b)paramString;
    AppMethodBeat.o(284256);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a
 * JD-Core Version:    0.7.0.1
 */