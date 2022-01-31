package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class RegSetInfoUI$15
  implements DialogInterface.OnClickListener
{
  RegSetInfoUI$15(RegSetInfoUI paramRegSetInfoUI, m paramm) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = RegSetInfoUI.b(this.fso).getText().toString().trim();
    Object localObject1 = RegSetInfoUI.a(this.fso).getText().toString().trim();
    if ((paramDialogInterface == null) || (paramDialogInterface.length() <= 0))
    {
      h.h(this.fso, q.j.verify_account_null_tip, q.j.regbymobile_reg_setpwd_alert_title);
      return;
    }
    this.fso.XM();
    paramInt = RegSetInfoUI.e(this.fso);
    Object localObject2 = RegSetInfoUI.f(this.fso);
    g.Dk().a(429, this.fso);
    paramDialogInterface = new ad((String)localObject2, RegSetInfoUI.g(this.fso), paramInt, paramDialogInterface, (String)localObject1, ((ad)this.bEe).Qz(), RegSetInfoUI.C(this.fso).getSecImgCode());
    g.Dk().a(paramDialogInterface, 0);
    localObject1 = this.fso;
    localObject2 = this.fso;
    this.fso.getString(q.j.app_tip);
    RegSetInfoUI.a((RegSetInfoUI)localObject1, h.b((Context)localObject2, this.fso.getString(q.j.regbyqq_reg_waiting), true, new RegSetInfoUI.15.1(this, paramDialogInterface)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.15
 * JD-Core Version:    0.7.0.1
 */