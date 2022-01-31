package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class LoginHistoryUI$15
  implements DialogInterface.OnClickListener
{
  LoginHistoryUI$15(LoginHistoryUI paramLoginHistoryUI, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    int i = -1;
    y.d("MicroMsg.LoginHistoryUI", "imgSid:" + this.fnc.fmA.feA + " img len" + this.fnc.fmA.fez.length + " " + com.tencent.mm.compatible.util.g.zI());
    int j = this.bEf;
    if (this.fnc.fmR == null)
    {
      paramInt = -1;
      paramDialogInterface = bk.aac(this.fnc.fmR);
      if (this.fnc.fmA.fey != null) {
        break label371;
      }
    }
    for (;;)
    {
      y.d("MicroMsg.LoginHistoryUI", "summervoice errType:%d, mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt), paramDialogInterface, Integer.valueOf(i), bk.aac(this.fnc.fmA.fey) });
      paramDialogInterface = new q(this.fnc.fmA.account, this.fnc.fmA.fey, this.fnc.fmA.fns, LoginHistoryUI.i(this.fnc).getSecImgCode(), LoginHistoryUI.i(this.fnc).getSecImgSid(), LoginHistoryUI.i(this.fnc).getSecImgEncryptKey(), 0, "", false, false);
      if ((bk.bl(this.fnc.fmA.fey)) && (!bk.bl(this.fnc.fmR)))
      {
        y.i("MicroMsg.LoginHistoryUI", "summervoice resetMd5BeforeDoSceneByVoice mAuthPwd:", new Object[] { bk.aac(this.fnc.fmR) });
        paramDialogInterface.nd(this.fnc.fmR);
      }
      com.tencent.mm.kernel.g.Dk().a(paramDialogInterface, 0);
      LoginHistoryUI localLoginHistoryUI1 = this.fnc;
      LoginHistoryUI localLoginHistoryUI2 = this.fnc;
      this.fnc.getString(q.j.app_tip);
      localLoginHistoryUI1.dnm = h.b(localLoginHistoryUI2, this.fnc.getString(q.j.login_logining), true, new LoginHistoryUI.15.1(this, paramDialogInterface));
      return;
      paramInt = this.fnc.fmR.length();
      break;
      label371:
      i = this.fnc.fmA.fey.length();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.15
 * JD-Core Version:    0.7.0.1
 */