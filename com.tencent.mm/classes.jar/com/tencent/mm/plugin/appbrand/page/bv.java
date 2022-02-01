package com.tencent.mm.plugin.appbrand.page;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/SwipeBackLayoutSettingsAlignmentWC;", "", "()V", "alignSettings", "", "maybeSwipeLayout", "Landroid/view/View;", "plugin-appbrand-integration_release"})
public final class bv
{
  public static final bv mfV;
  
  static
  {
    AppMethodBeat.i(50952);
    mfV = new bv();
    AppMethodBeat.o(50952);
  }
  
  public static final void cK(View paramView)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bv
 * JD-Core Version:    0.7.0.1
 */