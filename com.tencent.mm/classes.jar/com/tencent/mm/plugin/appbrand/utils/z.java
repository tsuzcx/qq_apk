package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/utils/OpenUrlHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/IOpenUrlHelper;", "()V", "openUrl", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "url", "", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
public final class z
  implements b
{
  public final void a(c paramc, String paramString, Context paramContext)
  {
    AppMethodBeat.i(51403);
    p.h(paramc, "component");
    p.h(paramString, "url");
    p.h(paramContext, "context");
    paramc = (ac)paramc.K(ac.class);
    if (paramc != null)
    {
      paramc.a(paramContext, paramString, null);
      AppMethodBeat.o(51403);
      return;
    }
    AppMethodBeat.o(51403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.z
 * JD-Core Version:    0.7.0.1
 */