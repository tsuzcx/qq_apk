package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class MobileLoginOrForceReg$2
  implements DialogInterface.OnClickListener
{
  MobileLoginOrForceReg$2(MobileLoginOrForceReg paramMobileLoginOrForceReg, String paramString1, String paramString2, m paramm, Boolean paramBoolean) {}
  
  public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new com.tencent.mm.modelsimple.s("", this.fpb, this.fpc, 0, "", MobileLoginOrForceReg.e(this.fpa), "", "", MobileLoginOrForceReg.h(this.fpa), MobileLoginOrForceReg.r(this.fpa), "", ((com.tencent.mm.modelsimple.s)this.bEe).Qz(), MobileLoginOrForceReg.p(this.fpa).getSecImgCode(), true, this.fpd.booleanValue());
    paramDialogInterface.ne(MobileLoginOrForceReg.i(this.fpa));
    paramDialogInterface.jc(MobileLoginOrForceReg.k(this.fpa));
    g.Dk().a(paramDialogInterface, 0);
    MobileLoginOrForceReg localMobileLoginOrForceReg = this.fpa;
    AppCompatActivity localAppCompatActivity = this.fpa.mController.uMN;
    this.fpa.getString(q.j.app_tip);
    localMobileLoginOrForceReg.dnm = h.b(localAppCompatActivity, this.fpa.getString(q.j.regbyqq_reg_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        g.Dk().c(paramDialogInterface);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.2
 * JD-Core Version:    0.7.0.1
 */