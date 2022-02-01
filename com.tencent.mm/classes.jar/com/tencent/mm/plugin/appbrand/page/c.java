package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.i;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandActionBarHomeButtonStyleWC;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandActionBarHomeButtonStyle;", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;)V", "onBackButtonClicked", "", "view", "Landroid/view/View;", "plugin-appbrand-integration_release"})
public final class c
  extends b
{
  private final ag mri;
  
  public c(ag paramag)
  {
    super((ac)paramag);
    AppMethodBeat.i(229232);
    this.mri = paramag;
    AppMethodBeat.o(229232);
  }
  
  public final boolean cz(View paramView)
  {
    AppMethodBeat.i(229231);
    p.h(paramView, "view");
    boolean bool = super.cz(paramView);
    if ((bool) && (this.mri.bRk() != null))
    {
      paramView = this.mri.bRi();
      p.g(paramView, "pageView.actionBar");
      if (!paramView.cae())
      {
        paramView = this.mri.getRuntime();
        p.g(paramView, "pageView.runtime");
        i.E(paramView.getAppId(), this.mri.getURL(), 3);
      }
    }
    AppMethodBeat.o(229231);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c
 * JD-Core Version:    0.7.0.1
 */