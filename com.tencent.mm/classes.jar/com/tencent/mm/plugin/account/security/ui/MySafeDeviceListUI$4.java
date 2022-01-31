package com.tencent.mm.plugin.account.security.ui;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.security.a.c;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;

final class MySafeDeviceListUI$4
  implements h.b
{
  MySafeDeviceListUI$4(MySafeDeviceListUI paramMySafeDeviceListUI, d paramd) {}
  
  public final boolean onFinish(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(69876);
    if (paramCharSequence == null) {}
    for (paramCharSequence = ""; paramCharSequence.equals(this.gBF.field_name); paramCharSequence = paramCharSequence.toString().trim())
    {
      AppMethodBeat.o(69876);
      return true;
    }
    if (paramCharSequence.length() <= 0)
    {
      h.bO(this.gBD.getContext(), this.gBD.getString(2131302846));
      AppMethodBeat.o(69876);
      return false;
    }
    paramCharSequence = new c(this.gBF.field_uid, paramCharSequence, this.gBF.field_devicetype);
    g.Rc().a(paramCharSequence, 0);
    if (MySafeDeviceListUI.c(this.gBD) != null) {
      MySafeDeviceListUI.c(this.gBD).dismiss();
    }
    MySafeDeviceListUI.a(this.gBD, h.b(this.gBD, a.aq(this.gBD, 2131297112), true, new MySafeDeviceListUI.4.1(this, paramCharSequence)));
    AppMethodBeat.o(69876);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.MySafeDeviceListUI.4
 * JD-Core Version:    0.7.0.1
 */