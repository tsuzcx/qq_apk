package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.ui.base.n.d;

final class BindMContactIntroUI$23$2
  implements n.d
{
  BindMContactIntroUI$23$2(BindMContactIntroUI.23 param23) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(13432);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(13432);
      return;
      BindMContactIntroUI.d(this.gtA.gtw);
      AppMethodBeat.o(13432);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("need_matte_high_light_item", "settings_find_me_by_mobile");
      d.b(this.gtA.gtw, "setting", ".ui.setting.SettingsPrivacyUI", paramMenuItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.23.2
 * JD-Core Version:    0.7.0.1
 */