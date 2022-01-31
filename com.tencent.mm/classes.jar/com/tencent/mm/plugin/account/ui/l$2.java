package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class l$2
  implements DialogInterface.OnClickListener
{
  l$2(l paraml, f paramf) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + this.fol.feA + " img len" + this.fol.fez.length + " " + com.tencent.mm.compatible.util.g.zI());
    paramDialogInterface = new q(this.fol.account, this.fol.fey, this.fol.fns, this.fok.fex.getSecImgCode(), this.fok.fex.getSecImgSid(), this.fok.fex.getSecImgEncryptKey(), 1, "", false, false);
    com.tencent.mm.kernel.g.Dk().a(paramDialogInterface, 0);
    MobileInputUI localMobileInputUI1 = this.fok.fnW;
    MobileInputUI localMobileInputUI2 = this.fok.fnW;
    this.fok.fnW.getString(q.j.app_tip);
    localMobileInputUI1.fev = h.b(localMobileInputUI2, this.fok.fnW.getString(q.j.login_logining), true, new l.2.1(this, paramDialogInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.l.2
 * JD-Core Version:    0.7.0.1
 */