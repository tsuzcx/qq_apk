package com.tencent.mm.plugin.appbrand.page;

import a.l;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.d;
import com.tencent.mm.plugin.appbrand.i;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$3$2"})
final class g$b
  implements View.OnClickListener
{
  g$b(g paramg, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(134760);
    paramView = g.b(this.ivD);
    if (paramView != null)
    {
      paramView = paramView.getRuntime();
      if (paramView != null)
      {
        e.a(paramView.getAppId(), e.d.gPe);
        paramView.close();
        AppMethodBeat.o(134760);
        return;
      }
    }
    AppMethodBeat.o(134760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.g.b
 * JD-Core Version:    0.7.0.1
 */