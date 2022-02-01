package com.tencent.mm.plugin.appbrand.page;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/SwipeBackLayoutSettingsAlignmentWC;", "", "()V", "alignSettings", "", "maybeSwipeLayout", "Landroid/view/View;", "plugin-appbrand-integration_release"})
public final class cb
{
  public static final cb nuN;
  
  static
  {
    AppMethodBeat.i(50952);
    nuN = new cb();
    AppMethodBeat.o(50952);
  }
  
  public static final void cE(View paramView)
  {
    AppMethodBeat.i(50951);
    if (!(paramView instanceof SwipeBackLayout)) {
      paramView = null;
    }
    for (;;)
    {
      paramView = (SwipeBackLayout)paramView;
      if (paramView != null)
      {
        Resources localResources = paramView.getResources();
        p.g(localResources, "page.resources");
        float f = localResources.getDisplayMetrics().density;
        paramView.setMinVelocity(100.0F * f);
        paramView.setMaxVelocity(300.0F * f);
        paramView.setEdgeTrackingEnabled(1);
        paramView.setEdgeSize((int)(f * 20.0F + 0.5F));
        paramView.setEdgeTrackingEnabled(1);
        paramView.setScrimColor(0);
        AppMethodBeat.o(50951);
        return;
      }
      AppMethodBeat.o(50951);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.cb
 * JD-Core Version:    0.7.0.1
 */