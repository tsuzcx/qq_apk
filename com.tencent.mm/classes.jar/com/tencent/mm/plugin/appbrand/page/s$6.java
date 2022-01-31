package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.launching.precondition.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.a;
import com.tencent.mm.sdk.platformtools.ai;

final class s$6
  implements AppBrandRecentView.b
{
  s$6(s params) {}
  
  public final boolean a(View paramView, a parama, float paramFloat1, float paramFloat2)
  {
    ai.l(new s.6.1(this), 100L);
    if (parama.type == 1)
    {
      paramView = parama.hqw;
      parama = new AppBrandStatObject();
      parama.scene = 1090;
      parama.bFv = this.gUs.mAppId;
      g.gMF.a(this.gUs.mContext, paramView.username, null, null, paramView.fJy, -1, parama, null, null);
      return true;
    }
    return false;
  }
  
  public final boolean b(View paramView, a parama, float paramFloat1, float paramFloat2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.s.6
 * JD-Core Version:    0.7.0.1
 */