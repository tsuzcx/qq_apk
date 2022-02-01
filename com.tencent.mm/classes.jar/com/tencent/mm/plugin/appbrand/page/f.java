package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.k;
import com.tencent.mm.plugin.appbrand.ui.q;
import com.tencent.mm.plugin.appbrand.ui.r;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"obtainPersistentContextWrapper", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandRuntimePersistentContextWrapper;", "Landroid/content/Context;", "obtainScreenAdaptiveContext", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIScreenAdaptiveContextThemeWrapper;", "plugin-appbrand-integration_release"})
public final class f
{
  static final q dH(Context paramContext)
  {
    AppMethodBeat.i(50911);
    if ((paramContext instanceof q))
    {
      paramContext = (q)paramContext;
      AppMethodBeat.o(50911);
      return paramContext;
    }
    if ((paramContext instanceof AppBrandUI)) {}
    for (paramContext = ((AppBrandUI)paramContext).bzB();; paramContext = new q(paramContext, r.bzG()))
    {
      p.g(paramContext, "if (this is AppBrandUI) …ITheme.THEME())\n        }");
      AppMethodBeat.o(50911);
      return paramContext;
    }
  }
  
  static final k dI(Context paramContext)
  {
    AppMethodBeat.i(50912);
    if ((paramContext instanceof k))
    {
      paramContext = (k)paramContext;
      AppMethodBeat.o(50912);
      return paramContext;
    }
    paramContext = k.dN(paramContext);
    p.g(paramContext, "AppBrandRuntimePersisten…apper.forAppBrandUI(this)");
    AppMethodBeat.o(50912);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.f
 * JD-Core Version:    0.7.0.1
 */