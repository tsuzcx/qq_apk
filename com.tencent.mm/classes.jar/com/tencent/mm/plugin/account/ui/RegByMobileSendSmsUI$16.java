package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class RegByMobileSendSmsUI$16
  implements DialogInterface.OnClickListener
{
  RegByMobileSendSmsUI$16(RegByMobileSendSmsUI paramRegByMobileSendSmsUI, com.tencent.mm.modelsimple.s params) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new com.tencent.mm.modelsimple.s("", RegByMobileSendSmsUI.e(this.fqR), RegByMobileSendSmsUI.f(this.fqR), 0, "", RegByMobileSendSmsUI.g(this.fqR), "", "", RegByMobileSendSmsUI.h(this.fqR), 1, "", this.fqS.Qz(), RegByMobileSendSmsUI.i(this.fqR).getSecImgCode(), true, RegByMobileSendSmsUI.j(this.fqR));
    paramDialogInterface.ne(RegByMobileSendSmsUI.k(this.fqR));
    paramDialogInterface.jc(1);
    g.Dk().a(paramDialogInterface, 0);
    RegByMobileSendSmsUI localRegByMobileSendSmsUI = this.fqR;
    AppCompatActivity localAppCompatActivity = this.fqR.mController.uMN;
    this.fqR.getString(q.j.app_tip);
    RegByMobileSendSmsUI.a(localRegByMobileSendSmsUI, h.b(localAppCompatActivity, this.fqR.getString(q.j.regbyqq_reg_waiting), true, new RegByMobileSendSmsUI.16.1(this, paramDialogInterface)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.16
 * JD-Core Version:    0.7.0.1
 */