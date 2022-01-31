package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class LoginUI$13
  implements DialogInterface.OnClickListener
{
  LoginUI$13(LoginUI paramLoginUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (LoginUI.i(this.fnM) == null)
    {
      y.e("MicroMsg.LoginUI", "secimg is null!");
      return;
    }
    y.d("MicroMsg.LoginUI", "imgSid:" + LoginUI.j(this.fnM).feA + " img len" + LoginUI.j(this.fnM).fez.length + " " + com.tencent.mm.compatible.util.g.zI());
    paramDialogInterface = new q(LoginUI.j(this.fnM).account, LoginUI.j(this.fnM).fey, LoginUI.j(this.fnM).fns, LoginUI.i(this.fnM).getSecImgCode(), LoginUI.i(this.fnM).getSecImgSid(), LoginUI.i(this.fnM).getSecImgEncryptKey(), 2, "", false, false);
    com.tencent.mm.kernel.g.Dk().a(paramDialogInterface, 0);
    LoginUI localLoginUI1 = this.fnM;
    LoginUI localLoginUI2 = this.fnM;
    this.fnM.getString(q.j.app_tip);
    LoginUI.a(localLoginUI1, h.b(localLoginUI2, this.fnM.getString(q.j.login_logining), true, new LoginUI.13.1(this, paramDialogInterface)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.13
 * JD-Core Version:    0.7.0.1
 */