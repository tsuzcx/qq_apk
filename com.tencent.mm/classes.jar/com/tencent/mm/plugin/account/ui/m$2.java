package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class m$2
  implements DialogInterface.OnClickListener
{
  m$2(m paramm) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + this.fpl.fmA.feA + " img len" + this.fpl.fmA.fez.length + " " + com.tencent.mm.compatible.util.g.zI());
    paramDialogInterface = new q(this.fpl.fmA.account, this.fpl.fmA.fnr, this.fpl.fmA.fns, this.fpl.fex.getSecImgCode(), this.fpl.fex.getSecImgSid(), this.fpl.fex.getSecImgEncryptKey(), 1, "", false, true);
    com.tencent.mm.kernel.g.Dk().a(paramDialogInterface, 0);
    MobileVerifyUI localMobileVerifyUI = this.fpl.fpj;
    this.fpl.fpj.getString(q.j.app_tip);
    h.b(localMobileVerifyUI, this.fpl.fpj.getString(q.j.login_logining), true, new m.2.1(this, paramDialogInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.m.2
 * JD-Core Version:    0.7.0.1
 */