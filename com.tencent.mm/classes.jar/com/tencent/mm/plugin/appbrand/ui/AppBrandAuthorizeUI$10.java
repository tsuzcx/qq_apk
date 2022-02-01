package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.ae;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

final class AppBrandAuthorizeUI$10
  implements Runnable
{
  AppBrandAuthorizeUI$10(AppBrandAuthorizeUI paramAppBrandAuthorizeUI, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(227569);
    Preference localPreference = new Preference(this.nRR);
    localPreference.OZw = false;
    localPreference.setKey("preference_key_tip");
    if (this.nrh)
    {
      localPreference.setLayoutResource(2131493011);
      localPreference.setTitle(this.nRR.getString(2131755358, new Object[] { AppBrandAuthorizeUI.l(this.nRR).nickname }));
    }
    for (;;)
    {
      this.nRR.nRm.bmi("preference_key_tip");
      this.nRR.nRm.c(localPreference);
      this.nRR.nRm.notifyDataSetChanged();
      AppMethodBeat.o(227569);
      return;
      localPreference.setLayoutResource(2131493012);
      localPreference.setTitle(this.nRR.getString(2131755359, new Object[] { AppBrandAuthorizeUI.l(this.nRR).nickname }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.10
 * JD-Core Version:    0.7.0.1
 */