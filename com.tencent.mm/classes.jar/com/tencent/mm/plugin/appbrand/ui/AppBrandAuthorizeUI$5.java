package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

final class AppBrandAuthorizeUI$5
  implements Runnable
{
  AppBrandAuthorizeUI$5(AppBrandAuthorizeUI paramAppBrandAuthorizeUI, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(132896);
    Preference localPreference = new Preference(this.iLF);
    localPreference.zsk = false;
    if (this.ixx)
    {
      localPreference.setLayoutResource(2130968663);
      localPreference.setTitle(this.iLF.getString(2131296576, new Object[] { AppBrandAuthorizeUI.i(this.iLF).nickname }));
    }
    for (;;)
    {
      this.iLF.iLA.b(localPreference);
      this.iLF.iLA.notifyDataSetChanged();
      AppMethodBeat.o(132896);
      return;
      localPreference.setLayoutResource(2130968664);
      localPreference.setTitle(this.iLF.getString(2131296577, new Object[] { AppBrandAuthorizeUI.i(this.iLF).nickname }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.5
 * JD-Core Version:    0.7.0.1
 */