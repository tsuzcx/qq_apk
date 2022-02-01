package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.r;
import com.tencent.mm.plugin.appbrand.ui.s;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"obtainPersistentContextWrapper", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandRuntimePersistentContextWrapper;", "Landroid/content/Context;", "obtainScreenAdaptiveContext", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIScreenAdaptiveContextThemeWrapper;", "plugin-appbrand-integration_release"})
public final class e
{
  static final r dL(Context paramContext)
  {
    AppMethodBeat.i(50911);
    if ((paramContext instanceof r))
    {
      paramContext = (r)paramContext;
      AppMethodBeat.o(50911);
      return paramContext;
    }
    if ((paramContext instanceof AppBrandUI)) {}
    for (paramContext = ((AppBrandUI)paramContext).bAw();; paramContext = new r(paramContext, s.bAB()))
    {
      p.g(paramContext, "if (this is AppBrandUI) …ITheme.THEME())\n        }");
      AppMethodBeat.o(50911);
      return paramContext;
    }
  }
  
  static final com.tencent.mm.plugin.appbrand.ui.l dM(Context paramContext)
  {
    AppMethodBeat.i(50912);
    if ((paramContext instanceof com.tencent.mm.plugin.appbrand.ui.l))
    {
      paramContext = (com.tencent.mm.plugin.appbrand.ui.l)paramContext;
      AppMethodBeat.o(50912);
      return paramContext;
    }
    paramContext = com.tencent.mm.plugin.appbrand.ui.l.dR(paramContext);
    p.g(paramContext, "AppBrandRuntimePersisten…apper.forAppBrandUI(this)");
    AppMethodBeat.o(50912);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.e
 * JD-Core Version:    0.7.0.1
 */