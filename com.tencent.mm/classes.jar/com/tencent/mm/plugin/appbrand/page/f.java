package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.n;
import com.tencent.mm.plugin.appbrand.ui.w;
import com.tencent.mm.plugin.appbrand.ui.x;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"obtainPersistentContextWrapper", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandRuntimePersistentContextWrapper;", "Landroid/content/Context;", "obtainScreenAdaptiveContext", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIScreenAdaptiveContextThemeWrapper;", "plugin-appbrand-integration_release"})
public final class f
{
  static final w eh(Context paramContext)
  {
    AppMethodBeat.i(50911);
    if ((paramContext instanceof w))
    {
      paramContext = (w)paramContext;
      AppMethodBeat.o(50911);
      return paramContext;
    }
    if ((paramContext instanceof AppBrandUI)) {}
    for (paramContext = ((AppBrandUI)paramContext).bXx();; paramContext = new w(paramContext, x.bXG()))
    {
      p.g(paramContext, "if (this is AppBrandUI) …ITheme.THEME())\n        }");
      AppMethodBeat.o(50911);
      return paramContext;
    }
  }
  
  static final n ei(Context paramContext)
  {
    AppMethodBeat.i(50912);
    if ((paramContext instanceof n))
    {
      paramContext = n.eo(((n)paramContext).getBaseContext());
      p.g(paramContext, "AppBrandRuntimePersisten…BrandUI(this.baseContext)");
      AppMethodBeat.o(50912);
      return paramContext;
    }
    paramContext = n.eo(paramContext);
    p.g(paramContext, "AppBrandRuntimePersisten…apper.forAppBrandUI(this)");
    AppMethodBeat.o(50912);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.f
 * JD-Core Version:    0.7.0.1
 */