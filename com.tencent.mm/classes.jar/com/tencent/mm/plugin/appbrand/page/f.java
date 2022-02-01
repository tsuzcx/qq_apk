package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.ui.p;
import com.tencent.mm.plugin.appbrand.ui.q;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"obtainPersistentContextWrapper", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandRuntimePersistentContextWrapper;", "Landroid/content/Context;", "obtainScreenAdaptiveContext", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIScreenAdaptiveContextThemeWrapper;", "plugin-appbrand-integration_release"})
public final class f
{
  static final j dA(Context paramContext)
  {
    AppMethodBeat.i(50912);
    if ((paramContext instanceof j))
    {
      paramContext = (j)paramContext;
      AppMethodBeat.o(50912);
      return paramContext;
    }
    paramContext = j.dF(paramContext);
    k.g(paramContext, "AppBrandRuntimePersisten…apper.forAppBrandUI(this)");
    AppMethodBeat.o(50912);
    return paramContext;
  }
  
  static final p dz(Context paramContext)
  {
    AppMethodBeat.i(50911);
    if ((paramContext instanceof p))
    {
      paramContext = (p)paramContext;
      AppMethodBeat.o(50911);
      return paramContext;
    }
    if ((paramContext instanceof AppBrandUI)) {}
    for (paramContext = ((AppBrandUI)paramContext).boA();; paramContext = new p(paramContext, q.boF()))
    {
      k.g(paramContext, "if (this is AppBrandUI) …ITheme.THEME())\n        }");
      AppMethodBeat.o(50911);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.f
 * JD-Core Version:    0.7.0.1
 */