package com.tencent.mm.plugin.account.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.at.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;

final class BindMContactUI$3
  implements MenuItem.OnMenuItemClickListener
{
  BindMContactUI$3(BindMContactUI paramBindMContactUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    int i = 0;
    BindMContactUI.a(this.fcb, BindMContactUI.d(this.fcb).getText().toString().trim() + bk.Gi(BindMContactUI.b(this.fcb).getText().toString()));
    if ((!com.tencent.mm.pluginsdk.a.Vw(BindMContactUI.e(this.fcb))) || (bk.Gi(BindMContactUI.b(this.fcb).getText().toString()).length() <= 0))
    {
      h.h(this.fcb, a.i.bind_mcontact_mobile_erro, a.i.app_tip);
      return true;
    }
    switch (BindMContactUI.f(this.fcb))
    {
    default: 
      return true;
    case 0: 
      h.b(this.fcb, this.fcb.getString(a.i.bind_mcontact_unable_change_mobile), "", true);
      return true;
    case 1: 
      y.i("MicroMsg.BindMContactUI", "do next, send sms to self");
      h.a(this.fcb, this.fcb.getString(a.i.regbymobile_reg_verify_mobile_msg) + BindMContactUI.e(this.fcb), this.fcb.getString(a.i.regbymobile_reg_verify_mobile_title), new BindMContactUI.3.1(this), null);
      return true;
    case 2: 
      paramMenuItem = b.k(this.fcb, BindMContactUI.c(this.fcb), this.fcb.getString(a.i.country_code));
      bool = ((Boolean)g.DP().Dz().get(ac.a.uzj, Boolean.valueOf(false))).booleanValue();
      localBindMContactUI = this.fcb;
      j = a.i.license_read_url;
      str = x.cqJ();
      if (bool) {}
      for (i = 1;; i = 0)
      {
        paramMenuItem = localBindMContactUI.getString(j, new Object[] { str, paramMenuItem, "setting", Integer.valueOf(1), Integer.valueOf(i) });
        com.tencent.mm.plugin.account.a.b.a.b(this.fcb, paramMenuItem, 30767, true);
        return true;
      }
    }
    paramMenuItem = b.k(this.fcb, BindMContactUI.c(this.fcb), this.fcb.getString(a.i.country_code));
    boolean bool = ((Boolean)g.DP().Dz().get(ac.a.uzj, Boolean.valueOf(false))).booleanValue();
    BindMContactUI localBindMContactUI = this.fcb;
    int j = a.i.license_read_url;
    String str = x.cqJ();
    if (bool) {
      i = 1;
    }
    paramMenuItem = localBindMContactUI.getString(j, new Object[] { str, paramMenuItem, "login", Integer.valueOf(1), Integer.valueOf(i) });
    com.tencent.mm.plugin.account.a.b.a.b(this.fcb, paramMenuItem, 30766, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactUI.3
 * JD-Core Version:    0.7.0.1
 */