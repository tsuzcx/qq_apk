package com.tencent.mm.plugin.account.ui;

import android.content.res.Resources;
import android.widget.TextView;

final class MobileVerifyUI$1$1
  implements Runnable
{
  MobileVerifyUI$1$1(MobileVerifyUI.1 param1) {}
  
  public final void run()
  {
    MobileVerifyUI.b(this.fpT.fpS);
    if (MobileVerifyUI.c(this.fpT.fpS) >= 0L)
    {
      this.fpT.fpS.fpD.setText(this.fpT.fpS.getResources().getQuantityString(q.h.mobileverify_send_code_tip, (int)MobileVerifyUI.c(this.fpT.fpS), new Object[] { Integer.valueOf((int)MobileVerifyUI.c(this.fpT.fpS)) }));
      return;
    }
    this.fpT.fpS.fpD.setVisibility(8);
    this.fpT.fpS.fpC.setVisibility(0);
    MobileVerifyUI.d(this.fpT.fpS);
    this.fpT.fpS.fpC.setEnabled(true);
    this.fpT.fpS.fpC.setText(this.fpT.fpS.getString(q.j.mobileverify_nocode));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI.1.1
 * JD-Core Version:    0.7.0.1
 */