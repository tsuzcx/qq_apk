package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.sdk.platformtools.ad;

final class ae$7
  implements View.OnClickListener
{
  ae$7(ae paramae) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(196067);
    ad.i("MicroMsg.AppBrandPageViewWC", "pageview click close button");
    if (this.lbG.bjH().brg())
    {
      ad.i("MicroMsg.AppBrandPageViewWC", "pageview click close button, but nav area is hidden");
      AppMethodBeat.o(196067);
      return;
    }
    if (ae.h(this.lbG) != null) {
      ae.h(this.lbG).aNd().bjo();
    }
    if ((this.lbG.kWU != null) && (ae.h(this.lbG) != null)) {
      h.D(ae.h(this.lbG).mAppId, this.lbG.jzm, 3);
    }
    AppMethodBeat.o(196067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ae.7
 * JD-Core Version:    0.7.0.1
 */