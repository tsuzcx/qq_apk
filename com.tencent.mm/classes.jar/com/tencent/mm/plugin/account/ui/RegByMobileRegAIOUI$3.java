package com.tencent.mm.plugin.account.ui;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;

final class RegByMobileRegAIOUI$3
  implements al.a
{
  String ehy;
  
  RegByMobileRegAIOUI$3(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final boolean acS()
  {
    AppMethodBeat.i(152585);
    this.ehy = i.getPhoneNum(this.gIh, RegByMobileRegAIOUI.f(this.gIh));
    AppMethodBeat.o(152585);
    return true;
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(152584);
    if (bo.isNullOrNil(RegByMobileRegAIOUI.e(this.gIh).getText().trim()))
    {
      String str = av.RC(this.ehy);
      if ((!bo.isNullOrNil(this.ehy)) && ("+86".equals(str))) {
        RegByMobileRegAIOUI.e(this.gIh).setText(this.ehy.substring(3));
      }
    }
    AppMethodBeat.o(152584);
    return true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(152586);
    String str = super.toString() + "|initView1";
    AppMethodBeat.o(152586);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.3
 * JD-Core Version:    0.7.0.1
 */