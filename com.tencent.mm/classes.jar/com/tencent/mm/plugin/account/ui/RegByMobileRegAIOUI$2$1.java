package com.tencent.mm.plugin.account.ui;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.b;
import com.tencent.mm.plugin.account.a.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.b.c.a;

final class RegByMobileRegAIOUI$2$1
  implements c.a
{
  RegByMobileRegAIOUI$2$1(RegByMobileRegAIOUI.2 param2) {}
  
  public final void JU()
  {
    AppMethodBeat.i(152581);
    h.h(this.gIi.gIh, 2131303316, 2131303319);
    AppMethodBeat.o(152581);
  }
  
  public final void kY(String paramString)
  {
    AppMethodBeat.i(152580);
    RegByMobileRegAIOUI.a(this.gIi.gIh, av.apy(RegByMobileRegAIOUI.e(this.gIi.gIh).getText().toString()));
    RegByMobileRegAIOUI.b(this.gIi.gIh, av.apA(RegByMobileRegAIOUI.f(this.gIi.gIh)));
    paramString = RegByMobileRegAIOUI.g(this.gIi.gIh) + RegByMobileRegAIOUI.h(this.gIi.gIh);
    this.gIi.gIh.hideVKB();
    if (RegByMobileRegAIOUI.i(this.gIi.gIh))
    {
      if (bo.isNullOrNil(RegByMobileRegAIOUI.j(this.gIi.gIh))) {
        RegByMobileRegAIOUI.c(this.gIi.gIh, b.m(this.gIi.gIh, RegByMobileRegAIOUI.f(this.gIi.gIh), this.gIi.gIh.getString(2131298871)));
      }
      paramString = this.gIi.gIh.getString(2131306182, new Object[] { aa.dsG(), RegByMobileRegAIOUI.j(this.gIi.gIh), "reg", Integer.valueOf(1), Integer.valueOf(0) });
      a.b(this.gIi.gIh, paramString, 30847, false);
      AppMethodBeat.o(152580);
      return;
    }
    if (!bo.isNullOrNil(RegByMobileRegAIOUI.k(this.gIi.gIh)))
    {
      RegByMobileRegAIOUI.l(this.gIi.gIh);
      AppMethodBeat.o(152580);
      return;
    }
    RegByMobileRegAIOUI.d(this.gIi.gIh, paramString);
    AppMethodBeat.o(152580);
  }
  
  public final void vn()
  {
    AppMethodBeat.i(152582);
    h.h(this.gIi.gIh, 2131303317, 2131303319);
    AppMethodBeat.o(152582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.2.1
 * JD-Core Version:    0.7.0.1
 */