package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.ab;
import com.tencent.mm.plugin.appbrand.ui.ac;
import com.tencent.mm.plugin.appbrand.ui.o;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"obtainPersistentContextWrapper", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandRuntimePersistentContextWrapper;", "Landroid/content/Context;", "obtainScreenAdaptiveContext", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIScreenAdaptiveContextThemeWrapper;", "plugin-appbrand-integration_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final ab fa(Context paramContext)
  {
    AppMethodBeat.i(50911);
    s.u(paramContext, "<this>");
    if ((paramContext instanceof ab))
    {
      paramContext = (ab)paramContext;
      AppMethodBeat.o(50911);
      return paramContext;
    }
    if ((paramContext instanceof AppBrandUI)) {
      paramContext = ((AppBrandUI)paramContext).cLq();
    }
    for (;;)
    {
      s.s(paramContext, "{\n        if (this is Ap….THEME())\n        }\n    }");
      AppMethodBeat.o(50911);
      return paramContext;
      if ((paramContext instanceof o)) {
        paramContext = ((o)paramContext).cLq();
      } else {
        paramContext = new ab(paramContext, ac.cLF());
      }
    }
  }
  
  static final o fb(Context paramContext)
  {
    AppMethodBeat.i(50912);
    if ((paramContext instanceof o))
    {
      paramContext = o.fj(((o)paramContext).getBaseContext());
      s.s(paramContext, "{\n        AppBrandRuntim…I(this.baseContext)\n    }");
      AppMethodBeat.o(50912);
      return paramContext;
    }
    paramContext = o.fj(paramContext);
    s.s(paramContext, "{\n        AppBrandRuntim…forAppBrandUI(this)\n    }");
    AppMethodBeat.o(50912);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.g
 * JD-Core Version:    0.7.0.1
 */