package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.ui.p;
import com.tencent.mm.plugin.appbrand.ui.q;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"obtainPersistentContextWrapper", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandRuntimePersistentContextWrapper;", "Landroid/content/Context;", "obtainScreenAdaptiveContext", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIScreenAdaptiveContextThemeWrapper;", "plugin-appbrand-integration_release"})
public final class f
{
  static final p dI(Context paramContext)
  {
    AppMethodBeat.i(50911);
    if ((paramContext instanceof p))
    {
      paramContext = (p)paramContext;
      AppMethodBeat.o(50911);
      return paramContext;
    }
    if ((paramContext instanceof AppBrandUI)) {}
    for (paramContext = ((AppBrandUI)paramContext).bvv();; paramContext = new p(paramContext, q.bvA()))
    {
      k.g(paramContext, "if (this is AppBrandUI) …ITheme.THEME())\n        }");
      AppMethodBeat.o(50911);
      return paramContext;
    }
  }
  
  static final j dJ(Context paramContext)
  {
    AppMethodBeat.i(50912);
    if ((paramContext instanceof j))
    {
      paramContext = (j)paramContext;
      AppMethodBeat.o(50912);
      return paramContext;
    }
    paramContext = j.dO(paramContext);
    k.g(paramContext, "AppBrandRuntimePersisten…apper.forAppBrandUI(this)");
    AppMethodBeat.o(50912);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.f
 * JD-Core Version:    0.7.0.1
 */