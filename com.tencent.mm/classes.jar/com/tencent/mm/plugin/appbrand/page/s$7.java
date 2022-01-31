package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.sdk.platformtools.bk;

final class s$7
  implements View.OnLongClickListener
{
  s$7(s params) {}
  
  public final boolean onLongClick(View paramView)
  {
    if (this.gUs.getRuntime().aag() == 1086) {}
    while ((s.a(this.gUs) == null) || (s.a(this.gUs).getCount() == 0)) {
      return true;
    }
    s.a(this.gUs).refresh();
    this.gUs.gUh.showAsDropDown(paramView);
    c.a(this.gUs.mAppId, this.gUs.getURL(), 21, "", bk.UX(), 1, 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.s.7
 * JD-Core Version:    0.7.0.1
 */