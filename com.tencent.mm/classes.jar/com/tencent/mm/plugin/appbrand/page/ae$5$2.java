package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ad;

final class ae$5$2
  implements View.OnClickListener
{
  ae$5$2(ae.5 param5) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(196064);
    ad.i("MicroMsg.AppBrandPageViewWC", "pageview click close button");
    com.tencent.mm.plugin.appbrand.ac.g.bqO();
    if (ae.h(this.lbH.lbG) != null)
    {
      com.tencent.mm.plugin.appbrand.g.a(this.lbH.lbG.getAppId(), g.d.iDc);
      ae.h(this.lbH.lbG).close();
    }
    AppMethodBeat.o(196064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ae.5.2
 * JD-Core Version:    0.7.0.1
 */