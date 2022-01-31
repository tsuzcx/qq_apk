package com.tencent.mm.plugin.account.security.ui;

import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.sdk.platformtools.am.a;

final class SecurityAccountVerifyUI$2
  implements am.a
{
  SecurityAccountVerifyUI$2(SecurityAccountVerifyUI paramSecurityAccountVerifyUI) {}
  
  public final boolean tC()
  {
    int i = ((Integer)SecurityAccountVerifyUI.a(this.fkK).getTag()).intValue();
    if (i <= 1)
    {
      SecurityAccountVerifyUI.b(this.fkK).setVisibility(0);
      SecurityAccountVerifyUI.a(this.fkK).setVisibility(8);
      return false;
    }
    i -= 1;
    SecurityAccountVerifyUI.a(this.fkK).setTag(Integer.valueOf(i));
    SecurityAccountVerifyUI.a(this.fkK).setText(this.fkK.getString(a.d.safe_device_resend_verify_code_tips, new Object[] { Integer.valueOf(i) }));
    if (SecurityAccountVerifyUI.a(this.fkK).getVisibility() != 0) {
      SecurityAccountVerifyUI.a(this.fkK).setVisibility(0);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI.2
 * JD-Core Version:    0.7.0.1
 */