package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.launching.precondition.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.b;
import com.tencent.mm.sdk.platformtools.al;

final class z$5
  implements AppBrandRecentView.b
{
  z$5(z paramz) {}
  
  public final boolean a(View paramView, com.tencent.mm.plugin.appbrand.widget.recentview.a parama, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(143499);
    al.p(new z.5.1(this), 100L);
    if (parama.type == 1)
    {
      paramView = parama.jfk;
      parama = new AppBrandStatObject();
      parama.scene = 1090;
      parama.cmF = this.ixG.getAppId();
      f.ioc.a(this.ixG.getContext(), paramView.username, null, null, paramView.hcr, -1, parama, null, null);
      AppMethodBeat.o(143499);
      return true;
    }
    AppMethodBeat.o(143499);
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.plugin.appbrand.widget.recentview.a parama, float paramFloat1, float paramFloat2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.z.5
 * JD-Core Version:    0.7.0.1
 */