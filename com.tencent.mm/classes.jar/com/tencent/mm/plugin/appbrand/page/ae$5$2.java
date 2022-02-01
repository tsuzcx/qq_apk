package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ad;

final class ae$5$2
  implements View.OnClickListener
{
  ae$5$2(ae.5 param5) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(221301);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$13$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.AppBrandPageViewWC", "pageview click close button");
    com.tencent.mm.plugin.appbrand.ab.g.bBT();
    if (ae.h(this.nbD.mcH) != null)
    {
      com.tencent.mm.plugin.appbrand.g.a(this.nbD.mcH.getAppId(), g.d.jwl);
      ae.h(this.nbD.mcH).close();
    }
    a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$13$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(221301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ae.5.2
 * JD-Core Version:    0.7.0.1
 */