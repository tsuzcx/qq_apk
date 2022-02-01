package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.ab;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

final class AppBrandAuthorizeUI$10
  implements Runnable
{
  AppBrandAuthorizeUI$10(AppBrandAuthorizeUI paramAppBrandAuthorizeUI, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(188821);
    Preference localPreference = new Preference(this.mAb);
    localPreference.JtB = false;
    localPreference.setKey("preference_key_tip");
    if (this.mcm)
    {
      localPreference.setLayoutResource(2131492973);
      localPreference.setTitle(this.mAb.getString(2131755322, new Object[] { AppBrandAuthorizeUI.m(this.mAb).nickname }));
    }
    for (;;)
    {
      this.mAb.mzx.aVE("preference_key_tip");
      this.mAb.mzx.b(localPreference);
      this.mAb.mzx.notifyDataSetChanged();
      AppMethodBeat.o(188821);
      return;
      localPreference.setLayoutResource(2131492974);
      localPreference.setTitle(this.mAb.getString(2131755323, new Object[] { AppBrandAuthorizeUI.m(this.mAb).nickname }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.10
 * JD-Core Version:    0.7.0.1
 */