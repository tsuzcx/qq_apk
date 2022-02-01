package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/utils/OpenUrlHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/IOpenUrlHelper;", "()V", "openUrl", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "url", "", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
public final class ab
  implements b
{
  public final void a(f paramf, String paramString, Context paramContext)
  {
    AppMethodBeat.i(51403);
    p.h(paramf, "component");
    p.h(paramString, "url");
    p.h(paramContext, "context");
    paramf = (ag)paramf.M(ag.class);
    if (paramf != null)
    {
      paramf.a(paramContext, paramString, null);
      AppMethodBeat.o(51403);
      return;
    }
    AppMethodBeat.o(51403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ab
 * JD-Core Version:    0.7.0.1
 */