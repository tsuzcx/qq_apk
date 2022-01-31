package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.r.d;
import com.tencent.mm.plugin.appbrand.r.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

final class e$1
  implements View.OnClickListener
{
  e$1(e parame) {}
  
  public final void onClick(View paramView)
  {
    if (this.hqF.aii == 5)
    {
      ((f)g.r(f.class)).cb(paramView.getContext());
      return;
    }
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    if (this.hqF.aii == 1) {}
    for (localAppBrandStatObject.scene = 1104;; localAppBrandStatObject.scene = 1089)
    {
      ((d)g.r(d.class)).a(paramView.getContext(), this.hqF.hqE.hqw.username, null, this.hqF.hqE.hqw.fJy, -1, null, localAppBrandStatObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.e.1
 * JD-Core Version:    0.7.0.1
 */