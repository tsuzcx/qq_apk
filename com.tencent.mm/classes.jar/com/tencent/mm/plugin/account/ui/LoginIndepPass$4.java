package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class LoginIndepPass$4
  implements DialogInterface.OnClickListener
{
  LoginIndepPass$4(LoginIndepPass paramLoginIndepPass) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.d("MicroMsg.LoginIndepPass", "imgSid:" + LoginIndepPass.e(this.fnl).feA + " img len" + LoginIndepPass.e(this.fnl).fez.length + " " + com.tencent.mm.compatible.util.g.zI());
    paramDialogInterface = new q(LoginIndepPass.e(this.fnl).account, LoginIndepPass.e(this.fnl).fey, LoginIndepPass.e(this.fnl).fns, LoginIndepPass.f(this.fnl).getSecImgCode(), LoginIndepPass.f(this.fnl).getSecImgSid(), LoginIndepPass.f(this.fnl).getSecImgEncryptKey(), 1, "", false, false);
    com.tencent.mm.kernel.g.Dk().a(paramDialogInterface, 0);
    LoginIndepPass localLoginIndepPass1 = this.fnl;
    LoginIndepPass localLoginIndepPass2 = this.fnl;
    this.fnl.getString(q.j.app_tip);
    LoginIndepPass.a(localLoginIndepPass1, h.b(localLoginIndepPass2, this.fnl.getString(q.j.login_logining), true, new LoginIndepPass.4.1(this, paramDialogInterface)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginIndepPass.4
 * JD-Core Version:    0.7.0.1
 */