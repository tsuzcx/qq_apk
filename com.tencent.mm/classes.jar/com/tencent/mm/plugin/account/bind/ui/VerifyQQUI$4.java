package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.bind.a.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class VerifyQQUI$4
  implements DialogInterface.OnClickListener
{
  VerifyQQUI$4(VerifyQQUI paramVerifyQQUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new b(VerifyQQUI.b(this.feQ), VerifyQQUI.c(this.feQ), VerifyQQUI.g(this.feQ).getSecImgSid(), VerifyQQUI.g(this.feQ).getSecImgCode(), VerifyQQUI.g(this.feQ).getSecImgEncryptKey(), VerifyQQUI.d(this.feQ), VerifyQQUI.e(this.feQ), true);
    g.Dk().a(paramDialogInterface, 0);
    VerifyQQUI localVerifyQQUI = this.feQ;
    AppCompatActivity localAppCompatActivity = this.feQ.mController.uMN;
    this.feQ.getString(a.i.bind_qq_verify_alert_title);
    VerifyQQUI.a(localVerifyQQUI, h.b(localAppCompatActivity, this.feQ.getString(a.i.bind_qq_verify_alert_binding), true, new VerifyQQUI.4.1(this, paramDialogInterface)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.VerifyQQUI.4
 * JD-Core Version:    0.7.0.1
 */