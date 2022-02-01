package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.t;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandActionBarHomeButtonStyleWC;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandActionBarHomeButtonStyle;", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;)V", "onBackButtonClicked", "", "view", "Landroid/view/View;", "plugin-appbrand-integration_release"})
public final class c
  extends b
{
  private final ah ppq;
  
  public c(ah paramah)
  {
    super((ad)paramah);
    AppMethodBeat.i(284564);
    this.ppq = paramah;
    AppMethodBeat.o(284564);
  }
  
  public final boolean cS(View paramView)
  {
    AppMethodBeat.i(284563);
    p.k(paramView, "view");
    boolean bool = super.cS(paramView);
    if ((bool) && (this.ppq.cea() != null))
    {
      paramView = this.ppq.cdY();
      p.j(paramView, "pageView.actionBar");
      if (!paramView.cnb())
      {
        paramView = this.ppq.getRuntime();
        p.j(paramView, "pageView.runtime");
        j.H(paramView.getAppId(), this.ppq.btD(), 3);
      }
    }
    AppMethodBeat.o(284563);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c
 * JD-Core Version:    0.7.0.1
 */