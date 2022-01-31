package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class RegSetInfoUI$10
  implements DialogInterface.OnClickListener
{
  RegSetInfoUI$10(RegSetInfoUI paramRegSetInfoUI, m paramm) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = RegSetInfoUI.a(this.fso).getText().toString().trim();
    Object localObject = RegSetInfoUI.b(this.fso).getText().toString().trim();
    if ((localObject == null) || (((String)localObject).length() <= 0))
    {
      h.h(this.fso, q.j.verify_account_null_tip, q.j.regbymobile_reg_setpwd_alert_title);
      return;
    }
    paramInt = RegSetInfoUI.e(this.fso);
    g.Dk().a(126, this.fso);
    paramDialogInterface = new s("", RegSetInfoUI.y(this.fso), (String)localObject, RegSetInfoUI.z(this.fso), RegSetInfoUI.A(this.fso), RegSetInfoUI.B(this.fso), "", "", RegSetInfoUI.g(this.fso), paramInt, paramDialogInterface, ((s)this.bEe).Qz(), RegSetInfoUI.C(this.fso).getSecImgCode(), RegSetInfoUI.D(this.fso), RegSetInfoUI.j(this.fso));
    paramDialogInterface.ne(RegSetInfoUI.E(this.fso));
    paramDialogInterface.jc(RegSetInfoUI.F(this.fso));
    g.Dk().a(paramDialogInterface, 0);
    localObject = this.fso;
    RegSetInfoUI localRegSetInfoUI = this.fso;
    this.fso.getString(q.j.app_tip);
    RegSetInfoUI.a((RegSetInfoUI)localObject, h.b(localRegSetInfoUI, this.fso.getString(q.j.regbyqq_reg_waiting), true, new RegSetInfoUI.10.1(this, paramDialogInterface)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.10
 * JD-Core Version:    0.7.0.1
 */