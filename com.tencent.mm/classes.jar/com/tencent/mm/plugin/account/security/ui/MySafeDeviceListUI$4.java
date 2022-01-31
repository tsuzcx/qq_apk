package com.tencent.mm.plugin.account.security.ui;

import android.app.ProgressDialog;
import com.tencent.mm.ah.p;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.account.security.a.c;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.s;

final class MySafeDeviceListUI$4
  implements h.b
{
  MySafeDeviceListUI$4(MySafeDeviceListUI paramMySafeDeviceListUI, d paramd) {}
  
  public final boolean m(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    for (paramCharSequence = ""; paramCharSequence.equals(this.fko.field_name); paramCharSequence = paramCharSequence.toString().trim()) {
      return true;
    }
    if (paramCharSequence.length() <= 0)
    {
      h.bC(this.fkm.mController.uMN, this.fkm.getString(a.d.safe_device_edit_empty_tips));
      return false;
    }
    paramCharSequence = new c(this.fko.field_uid, paramCharSequence, this.fko.field_devicetype);
    g.Dk().a(paramCharSequence, 0);
    if (MySafeDeviceListUI.c(this.fkm) != null) {
      MySafeDeviceListUI.c(this.fkm).dismiss();
    }
    MySafeDeviceListUI.a(this.fkm, h.b(this.fkm, a.ac(this.fkm, a.d.app_waiting), true, new MySafeDeviceListUI.4.1(this, paramCharSequence)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.MySafeDeviceListUI.4
 * JD-Core Version:    0.7.0.1
 */