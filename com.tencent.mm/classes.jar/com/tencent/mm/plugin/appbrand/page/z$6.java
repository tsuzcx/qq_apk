package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.appbrand.widget.actionbar.g;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.sdk.platformtools.bo;

final class z$6
  implements View.OnLongClickListener
{
  z$6(z paramz) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(143500);
    if (this.ixG.getRuntime().wS().bDh.scene == 1086)
    {
      AppMethodBeat.o(143500);
      return true;
    }
    if ((z.d(this.ixG) == null) || (z.d(this.ixG).getCount() == 0))
    {
      AppMethodBeat.o(143500);
      return true;
    }
    z.d(this.ixG).refresh();
    this.ixG.ixD.showAsDropDown(paramView);
    e.a(this.ixG.getAppId(), this.ixG.hzM, 21, "", bo.aox(), 1, 0);
    AppMethodBeat.o(143500);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.z.6
 * JD-Core Version:    0.7.0.1
 */