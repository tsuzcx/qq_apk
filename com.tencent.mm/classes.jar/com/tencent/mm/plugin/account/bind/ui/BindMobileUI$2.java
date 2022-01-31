package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.at.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.b.a;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;

final class BindMobileUI$2
  implements View.OnClickListener
{
  BindMobileUI$2(BindMobileUI paramBindMobileUI) {}
  
  public final void onClick(View paramView)
  {
    int i = 0;
    if ((BindMobileUI.a(this.fcH).getText().toString() == null) || (BindMobileUI.a(this.fcH).getText().toString().length() == 0))
    {
      Toast.makeText(this.fcH, this.fcH.getString(a.i.bind_mcontact_err_format), 0).show();
      return;
    }
    BindMobileUI.b(this.fcH, BindMobileUI.b(this.fcH).getText().toString().trim() + bk.Gi(BindMobileUI.a(this.fcH).getText().toString()));
    switch (BindMobileUI.c(this.fcH))
    {
    default: 
      return;
    case 0: 
      h.b(this.fcH, this.fcH.getString(a.i.bind_mcontact_unable_change_mobile), "", true);
      return;
    case 1: 
      y.i("MicroMsg.BindMContactUI", "do next, send sms to self");
      BindMobileUI.c(this.fcH, BindMobileUI.d(this.fcH));
      return;
    case 2: 
      paramView = b.k(this.fcH, BindMobileUI.e(this.fcH), this.fcH.getString(a.i.country_code));
      bool = ((Boolean)g.DP().Dz().get(ac.a.uzj, Boolean.valueOf(false))).booleanValue();
      localBindMobileUI = this.fcH;
      j = a.i.license_read_url;
      str = x.cqJ();
      if (bool) {}
      for (i = 1;; i = 0)
      {
        paramView = localBindMobileUI.getString(j, new Object[] { str, paramView, "setting", Integer.valueOf(1), Integer.valueOf(i) });
        a.b(this.fcH, paramView, 30767, true);
        return;
      }
    }
    paramView = b.k(this.fcH, BindMobileUI.e(this.fcH), this.fcH.getString(a.i.country_code));
    boolean bool = ((Boolean)g.DP().Dz().get(ac.a.uzj, Boolean.valueOf(false))).booleanValue();
    BindMobileUI localBindMobileUI = this.fcH;
    int j = a.i.license_read_url;
    String str = x.cqJ();
    if (bool) {
      i = 1;
    }
    paramView = localBindMobileUI.getString(j, new Object[] { str, paramView, "login", Integer.valueOf(1), Integer.valueOf(i) });
    a.b(this.fcH, paramView, 30766, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileUI.2
 * JD-Core Version:    0.7.0.1
 */