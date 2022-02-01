package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aj;
import com.tencent.mm.plugin.appbrand.jsapi.al.e.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/OpenUrlHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/IOpenUrlHelper;", "()V", "openUrl", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "url", "", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai
  implements b
{
  public final void a(f paramf, String paramString, Context paramContext)
  {
    AppMethodBeat.i(51403);
    s.u(paramf, "component");
    s.u(paramString, "url");
    s.u(paramContext, "context");
    paramf = (aj)paramf.T(aj.class);
    if (paramf != null) {
      paramf.a(paramContext, paramString, "", null);
    }
    AppMethodBeat.o(51403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ai
 * JD-Core Version:    0.7.0.1
 */