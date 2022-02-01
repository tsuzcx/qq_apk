package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.aj.e;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/AppBrandPluginHandlerFactoryWC;", "Lcom/tencent/mm/plugin/appbrand/extendplugin/AppBrandPluginHandlerFactory;", "()V", "createHandler", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/IExtendPluginHandler;", "type", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends d
{
  public final com.tencent.luggage.xweb_ext.extendplugin.a.b fU(String paramString)
  {
    AppMethodBeat.i(317054);
    s.u(paramString, "type");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          paramString = super.fU(paramString);
          AppMethodBeat.o(317054);
          return paramString;
        } while (!paramString.equals("voiproom"));
        paramString = (com.tencent.luggage.xweb_ext.extendplugin.a.b)new e();
        AppMethodBeat.o(317054);
        return paramString;
      } while (!paramString.equals("webgl"));
      paramString = (com.tencent.luggage.xweb_ext.extendplugin.a.b)new com.tencent.mm.plugin.appbrand.jsapi.c.a.a();
      AppMethodBeat.o(317054);
      return paramString;
    } while (!paramString.equals("video"));
    paramString = new c();
    paramString.a((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b)new com.tencent.mm.plugin.appbrand.xweb_ext.video.a());
    paramString = (com.tencent.luggage.xweb_ext.extendplugin.a.b)paramString;
    AppMethodBeat.o(317054);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a
 * JD-Core Version:    0.7.0.1
 */