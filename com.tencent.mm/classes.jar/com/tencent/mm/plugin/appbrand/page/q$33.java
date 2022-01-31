package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.j.e;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.r.a;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.sdk.platformtools.ai;

final class q$33
  implements View.OnClickListener
{
  q$33(q paramq) {}
  
  public final void onClick(View paramView)
  {
    paramView = (AppBrandOptionButton)paramView;
    boolean bool = e.af(this.gTY.mContext);
    if (paramView.hoS)
    {
      paramView = new q.33.1(this);
      if (bool) {}
      for (int i = 100;; i = 0)
      {
        ai.l(paramView, i);
        return;
      }
    }
    a.f(q.d(this.gTY).Zy());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.q.33
 * JD-Core Version:    0.7.0.1
 */