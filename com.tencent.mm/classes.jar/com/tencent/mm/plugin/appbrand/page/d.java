package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandActionBarHomeButtonStyleWC;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandActionBarHomeButtonStyle;", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;)V", "onBackButtonClicked", "", "view", "Landroid/view/View;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends c
{
  private final ah sue;
  
  public d(ah paramah)
  {
    super((ad)paramah);
    AppMethodBeat.i(324878);
    this.sue = paramah;
    AppMethodBeat.o(324878);
  }
  
  public final boolean dz(View paramView)
  {
    AppMethodBeat.i(324881);
    s.u(paramView, "view");
    boolean bool = super.dz(paramView);
    if ((bool) && (this.sue.tti != null) && (!this.sue.cEC().cOU())) {
      j.N(this.sue.getRuntime().mAppId, this.sue.cgR(), 3);
    }
    AppMethodBeat.o(324881);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.d
 * JD-Core Version:    0.7.0.1
 */