package com.tencent.mm.plugin.account.ui;

import android.os.Message;
import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.widget.a.c;

final class RegByMobileRegAIOUI$15
  extends ah
{
  RegByMobileRegAIOUI$15(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (((RegByMobileRegAIOUI.r(this.fqF) != null) && (!RegByMobileRegAIOUI.r(this.fqF).isShowing())) || (RegByMobileRegAIOUI.s(this.fqF))) {}
    do
    {
      return;
      RegByMobileRegAIOUI.a(this.fqF, RegByMobileRegAIOUI.t(this.fqF) + 2);
      RegByMobileRegAIOUI.u(this.fqF).setProgress(RegByMobileRegAIOUI.t(this.fqF));
      if (RegByMobileRegAIOUI.t(this.fqF) < RegByMobileRegAIOUI.u(this.fqF).getMax())
      {
        sendEmptyMessageDelayed(0, 10L);
        return;
      }
      RegByMobileRegAIOUI.u(this.fqF).setIndeterminate(true);
    } while (RegByMobileRegAIOUI.s(this.fqF));
    if (RegByMobileRegAIOUI.r(this.fqF) != null) {
      RegByMobileRegAIOUI.r(this.fqF).dismiss();
    }
    RegByMobileRegAIOUI.v(this.fqF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.15
 * JD-Core Version:    0.7.0.1
 */