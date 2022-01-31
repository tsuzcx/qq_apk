package com.tencent.mm.plugin.account.security.ui;

import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class SecurityAccountVerifyUI$2
  implements ap.a
{
  SecurityAccountVerifyUI$2(SecurityAccountVerifyUI paramSecurityAccountVerifyUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(69916);
    int i = ((Integer)SecurityAccountVerifyUI.a(this.gCb).getTag()).intValue();
    if (i <= 1)
    {
      SecurityAccountVerifyUI.b(this.gCb).setVisibility(0);
      SecurityAccountVerifyUI.a(this.gCb).setVisibility(8);
      AppMethodBeat.o(69916);
      return false;
    }
    i -= 1;
    SecurityAccountVerifyUI.a(this.gCb).setTag(Integer.valueOf(i));
    SecurityAccountVerifyUI.a(this.gCb).setText(this.gCb.getString(2131302857, new Object[] { Integer.valueOf(i) }));
    if (SecurityAccountVerifyUI.a(this.gCb).getVisibility() != 0) {
      SecurityAccountVerifyUI.a(this.gCb).setVisibility(0);
    }
    AppMethodBeat.o(69916);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI.2
 * JD-Core Version:    0.7.0.1
 */