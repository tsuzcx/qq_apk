package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.v;
import com.tencent.mm.plugin.appbrand.ui.w;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"obtainPersistentContextWrapper", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandRuntimePersistentContextWrapper;", "Landroid/content/Context;", "obtainScreenAdaptiveContext", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIScreenAdaptiveContextThemeWrapper;", "plugin-appbrand-integration_release"})
public final class f
{
  public static final v eg(Context paramContext)
  {
    AppMethodBeat.i(50911);
    p.k(paramContext, "$this$obtainScreenAdaptiveContext");
    if ((paramContext instanceof v))
    {
      paramContext = (v)paramContext;
      AppMethodBeat.o(50911);
      return paramContext;
    }
    if ((paramContext instanceof AppBrandUI)) {}
    for (paramContext = ((AppBrandUI)paramContext).ckd();; paramContext = new v(paramContext, w.ckq()))
    {
      p.j(paramContext, "if (this is AppBrandUI) …ITheme.THEME())\n        }");
      AppMethodBeat.o(50911);
      return paramContext;
    }
  }
  
  static final com.tencent.mm.plugin.appbrand.ui.l eh(Context paramContext)
  {
    AppMethodBeat.i(50912);
    if ((paramContext instanceof com.tencent.mm.plugin.appbrand.ui.l))
    {
      paramContext = com.tencent.mm.plugin.appbrand.ui.l.en(((com.tencent.mm.plugin.appbrand.ui.l)paramContext).getBaseContext());
      p.j(paramContext, "AppBrandRuntimePersisten…BrandUI(this.baseContext)");
      AppMethodBeat.o(50912);
      return paramContext;
    }
    paramContext = com.tencent.mm.plugin.appbrand.ui.l.en(paramContext);
    p.j(paramContext, "AppBrandRuntimePersisten…apper.forAppBrandUI(this)");
    AppMethodBeat.o(50912);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.f
 * JD-Core Version:    0.7.0.1
 */