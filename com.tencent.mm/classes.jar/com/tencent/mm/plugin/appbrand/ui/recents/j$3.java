package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.c.cmt;
import com.tencent.mm.sdk.platformtools.y;

final class j$3
  implements View.OnClickListener
{
  j$3(j paramj, cmt paramcmt) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.AppBrandListRecentsListWAGameHeader", "Invoke WxApp click listener, invoke wxapp");
    paramView = new AppBrandStatObject();
    AppBrandLaunchProxyUI.a(this.hjk.fyk, this.hjm.username, this.hjm.path, 0, this.hjm.sEs, paramView, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.j.3
 * JD-Core Version:    0.7.0.1
 */