package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.h.a.so;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.friend.ui.i.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.ui.MMWizardActivity;

final class BindMContactIntroUI$25
  implements i.a
{
  BindMContactIntroUI$25(BindMContactIntroUI paramBindMContactIntroUI, String paramString) {}
  
  public final void d(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 1) {
      if (BindMContactIntroUI.f(this.fbF))
      {
        if (!q.Gr())
        {
          paramBundle = new so();
          paramBundle.ccd.cce = true;
          paramBundle.ccd.ccf = true;
          com.tencent.mm.sdk.b.a.udP.m(paramBundle);
        }
        BindMContactIntroUI.g(this.fbF);
        paramBundle = new Intent();
        paramBundle.addFlags(67108864);
        com.tencent.mm.plugin.account.a.a.eUR.c(this.fbF, paramBundle);
      }
    }
    while (paramInt != 2)
    {
      do
      {
        return;
        MMWizardActivity.C(this.fbF, new Intent(this.fbF, BindMContactStatusUI.class).putExtra("is_bind_for_contact_sync", BindMContactIntroUI.h(this.fbF)));
      } while (!BindMContactIntroUI.i(this.fbF));
      if (BindMContactIntroUI.h(this.fbF))
      {
        h.nFQ.f(11002, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
        return;
      }
      h.nFQ.f(11002, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
      return;
    }
    paramBundle = new Intent(this.fbF, BindMContactVerifyUI.class);
    paramBundle.putExtra("bindmcontact_mobile", this.fbL);
    paramBundle.putExtra("is_bind_for_safe_device", BindMContactIntroUI.f(this.fbF));
    paramBundle.putExtra("is_bind_for_contact_sync", BindMContactIntroUI.h(this.fbF));
    paramBundle.putExtra("KEnterFromBanner", BindMContactIntroUI.i(this.fbF));
    MMWizardActivity.C(this.fbF, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.25
 * JD-Core Version:    0.7.0.1
 */