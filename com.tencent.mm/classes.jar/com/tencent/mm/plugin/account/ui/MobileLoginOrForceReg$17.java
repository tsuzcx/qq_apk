package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class MobileLoginOrForceReg$17
  implements DialogInterface.OnClickListener
{
  MobileLoginOrForceReg$17(MobileLoginOrForceReg paramMobileLoginOrForceReg) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.d("MicorMsg.MobileLoginOrForceReg", "imgSid:" + MobileLoginOrForceReg.o(this.fpa).feA + " img len" + MobileLoginOrForceReg.o(this.fpa).fez.length + " " + com.tencent.mm.compatible.util.g.zI());
    paramDialogInterface = new q(MobileLoginOrForceReg.o(this.fpa).account, MobileLoginOrForceReg.o(this.fpa).fnr, MobileLoginOrForceReg.o(this.fpa).fns, MobileLoginOrForceReg.p(this.fpa).getSecImgCode(), MobileLoginOrForceReg.p(this.fpa).getSecImgSid(), MobileLoginOrForceReg.p(this.fpa).getSecImgEncryptKey(), 1, "", false, true);
    com.tencent.mm.kernel.g.Dk().a(paramDialogInterface, 0);
    MobileLoginOrForceReg localMobileLoginOrForceReg = this.fpa;
    this.fpa.getString(q.j.app_tip);
    h.b(localMobileLoginOrForceReg, this.fpa.getString(q.j.login_logining), true, new MobileLoginOrForceReg.17.1(this, paramDialogInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.17
 * JD-Core Version:    0.7.0.1
 */