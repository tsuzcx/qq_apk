package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.sdk.platformtools.ad;

final class ae$15
  implements View.OnClickListener
{
  ae$15(ae paramae) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(221304);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.AppBrandPageViewWC", "pageview click close button");
    if (this.mcH.bux().bCm())
    {
      ad.i("MicroMsg.AppBrandPageViewWC", "pageview click close button, but nav area is hidden");
      a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(221304);
      return;
    }
    if (ae.h(this.mcH) != null) {
      ae.h(this.mcH).aXd().bug();
    }
    if ((this.mcH.lYc != null) && (ae.h(this.mcH) != null)) {
      h.F(ae.h(this.mcH).mAppId, this.mcH.kuf, 3);
    }
    a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(221304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ae.15
 * JD-Core Version:    0.7.0.1
 */