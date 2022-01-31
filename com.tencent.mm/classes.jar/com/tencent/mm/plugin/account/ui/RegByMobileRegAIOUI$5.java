package com.tencent.mm.plugin.account.ui;

import android.widget.EditText;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bk;

final class RegByMobileRegAIOUI$5
  implements ai.a
{
  String dqb;
  
  RegByMobileRegAIOUI$5(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final boolean JS()
  {
    this.dqb = i.getPhoneNum(this.fqF, RegByMobileRegAIOUI.d(this.fqF));
    return true;
  }
  
  public final boolean JT()
  {
    if (bk.bl(RegByMobileRegAIOUI.c(this.fqF).getText().trim()))
    {
      String str = ar.Ga(this.dqb);
      if ((!bk.bl(this.dqb)) && ("+86".equals(str))) {
        RegByMobileRegAIOUI.c(this.fqF).setText(this.dqb.substring(3));
      }
    }
    return true;
  }
  
  public final String toString()
  {
    return super.toString() + "|initView1";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.5
 * JD-Core Version:    0.7.0.1
 */