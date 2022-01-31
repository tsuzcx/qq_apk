package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.ui.base.h;

final class c$12
  implements View.OnClickListener
{
  c$12(c paramc, View paramView) {}
  
  public final void onClick(View paramView)
  {
    if (this.gkF.getParent() != null) {
      ((ViewGroup)this.gkF.getParent()).removeAllViews();
    }
    h.a(this.gkx.gkh.mContext, false, this.gkx.gkh.getContentView().getResources().getString(y.j.app_brand_get_phone_number_expose_title), this.gkF, this.gkx.gkh.getContentView().getResources().getString(y.j.app_brand_get_phone_number_expose_ok_hint), "", new c.12.1(this), new c.12.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.c.12
 * JD-Core Version:    0.7.0.1
 */