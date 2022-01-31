package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

final class AppBrandAuthorizeUI$7
  implements Runnable
{
  AppBrandAuthorizeUI$7(AppBrandAuthorizeUI paramAppBrandAuthorizeUI, boolean paramBoolean) {}
  
  public final void run()
  {
    Preference localPreference = new Preference(this.hcu);
    localPreference.vdK = false;
    if (this.gUd)
    {
      localPreference.setLayoutResource(y.h.app_brand_authorize_none);
      localPreference.setTitle(this.hcu.getString(y.j.app_brand_auth_info_none, new Object[] { AppBrandAuthorizeUI.d(this.hcu).nickname }));
    }
    for (;;)
    {
      this.hcu.hcp.a(localPreference);
      this.hcu.hcp.notifyDataSetChanged();
      return;
      localPreference.setLayoutResource(y.h.app_brand_authorize_used);
      localPreference.setTitle(this.hcu.getString(y.j.app_brand_auth_info_used, new Object[] { AppBrandAuthorizeUI.d(this.hcu).nickname }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.7
 * JD-Core Version:    0.7.0.1
 */