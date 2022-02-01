package com.tencent.mm.plugin.appbrand.page;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/SwipeBackLayoutSettingsAlignmentWC;", "", "()V", "alignSettings", "", "maybeSwipeLayout", "Landroid/view/View;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ck
{
  public static final ck tBH;
  
  static
  {
    AppMethodBeat.i(50952);
    tBH = new ck();
    AppMethodBeat.o(50952);
  }
  
  public static final void dE(View paramView)
  {
    AppMethodBeat.i(50951);
    if ((paramView instanceof SwipeBackLayout)) {}
    for (paramView = (SwipeBackLayout)paramView;; paramView = null)
    {
      if (paramView != null)
      {
        float f = paramView.getResources().getDisplayMetrics().density;
        paramView.setMinVelocity(100.0F * f);
        paramView.setMaxVelocity(300.0F * f);
        paramView.setEdgeTrackingEnabled(1);
        paramView.setEdgeSize((int)(f * 20.0F + 0.5F));
        paramView.setEdgeTrackingEnabled(1);
        paramView.setScrimColor(0);
      }
      AppMethodBeat.o(50951);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ck
 * JD-Core Version:    0.7.0.1
 */