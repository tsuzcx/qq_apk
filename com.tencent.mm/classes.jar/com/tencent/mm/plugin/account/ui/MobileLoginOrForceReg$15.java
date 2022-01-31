package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.b.a;
import com.tencent.mm.sdk.platformtools.bk;

final class MobileLoginOrForceReg$15
  implements View.OnClickListener
{
  MobileLoginOrForceReg$15(MobileLoginOrForceReg paramMobileLoginOrForceReg) {}
  
  public final void onClick(View paramView)
  {
    if (bk.bl(MobileLoginOrForceReg.g(this.fpa)))
    {
      paramView = new Intent();
      a.qj("R200_900_phone");
      paramView.putExtra("regsetinfo_ticket", MobileLoginOrForceReg.h(this.fpa));
      paramView.putExtra("regsetinfo_user", MobileLoginOrForceReg.e(this.fpa));
      paramView.putExtra("regsetinfo_pwd", MobileLoginOrForceReg.d(this.fpa));
      paramView.putExtra("regsetinfo_ismobile", 4);
      paramView.putExtra("regsetinfo_isForce", true);
      paramView.putExtra("regsession_id", MobileLoginOrForceReg.i(this.fpa));
      paramView.putExtra("regsetinfo_NextControl", MobileLoginOrForceReg.j(this.fpa));
      paramView.putExtra("mobile_check_type", MobileLoginOrForceReg.k(this.fpa));
      paramView.putExtra("key_reg_style", MobileLoginOrForceReg.l(this.fpa));
      paramView.setClass(this.fpa, RegSetInfoUI.class);
      this.fpa.startActivity(paramView);
      return;
    }
    MobileLoginOrForceReg.m(this.fpa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.15
 * JD-Core Version:    0.7.0.1
 */