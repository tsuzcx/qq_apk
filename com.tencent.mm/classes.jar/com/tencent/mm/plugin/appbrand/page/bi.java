package com.tencent.mm.plugin.appbrand.page;

import a.f.b.j;
import a.l;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/page/SwipeBackLayoutSettingsAlignmentWC;", "", "()V", "alignSettings", "", "maybeSwipeLayout", "Landroid/view/View;", "plugin-appbrand-integration_release"})
public final class bi
{
  public static final bi izY;
  
  static
  {
    AppMethodBeat.i(134776);
    izY = new bi();
    AppMethodBeat.o(134776);
  }
  
  public static final void cv(View paramView)
  {
    AppMethodBeat.i(134775);
    if (!(paramView instanceof SwipeBackLayout)) {
      paramView = null;
    }
    for (;;)
    {
      paramView = (SwipeBackLayout)paramView;
      if (paramView != null)
      {
        Resources localResources = paramView.getResources();
        j.p(localResources, "page.resources");
        float f = localResources.getDisplayMetrics().density;
        paramView.setMinVelocity(100.0F * f);
        paramView.setMaxVelocity(300.0F * f);
        paramView.setEdgeTrackingEnabled(1);
        paramView.setEdgeSize((int)(f * 20.0F + 0.5F));
        paramView.setEdgeTrackingEnabled(1);
        paramView.setScrimColor(0);
        AppMethodBeat.o(134775);
        return;
      }
      AppMethodBeat.o(134775);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bi
 * JD-Core Version:    0.7.0.1
 */