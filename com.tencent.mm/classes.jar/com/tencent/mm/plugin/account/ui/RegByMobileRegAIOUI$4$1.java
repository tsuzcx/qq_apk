package com.tencent.mm.plugin.account.ui;

import android.widget.EditText;
import com.tencent.mm.at.b;
import com.tencent.mm.plugin.account.a.b.a;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.a.c.a;

final class RegByMobileRegAIOUI$4$1
  implements c.a
{
  RegByMobileRegAIOUI$4$1(RegByMobileRegAIOUI.4 param4) {}
  
  public final void eP(String paramString)
  {
    RegByMobileRegAIOUI.a(this.fqG.fqF, ar.Zt(RegByMobileRegAIOUI.c(this.fqG.fqF).getText().toString()));
    RegByMobileRegAIOUI.b(this.fqG.fqF, ar.Zv(RegByMobileRegAIOUI.d(this.fqG.fqF)));
    paramString = RegByMobileRegAIOUI.e(this.fqG.fqF) + RegByMobileRegAIOUI.f(this.fqG.fqF);
    this.fqG.fqF.XM();
    if (RegByMobileRegAIOUI.g(this.fqG.fqF))
    {
      if (bk.bl(RegByMobileRegAIOUI.h(this.fqG.fqF))) {
        RegByMobileRegAIOUI.c(this.fqG.fqF, b.k(this.fqG.fqF, RegByMobileRegAIOUI.d(this.fqG.fqF), this.fqG.fqF.getString(q.j.country_code)));
      }
      paramString = this.fqG.fqF.getString(q.j.license_read_url, new Object[] { x.cqJ(), RegByMobileRegAIOUI.h(this.fqG.fqF), "reg", Integer.valueOf(1), Integer.valueOf(0) });
      a.b(this.fqG.fqF, paramString, 30847, false);
      return;
    }
    RegByMobileRegAIOUI.d(this.fqG.fqF, paramString);
  }
  
  public final void xB()
  {
    h.h(this.fqG.fqF, q.j.settings_modify_name_invalid_less, q.j.settings_modify_name_title);
  }
  
  public final void xC()
  {
    h.h(this.fqG.fqF, q.j.settings_modify_name_invalid_more, q.j.settings_modify_name_title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.4.1
 * JD-Core Version:    0.7.0.1
 */