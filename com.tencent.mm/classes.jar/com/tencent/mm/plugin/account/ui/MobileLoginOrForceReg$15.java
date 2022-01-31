package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.b.a;
import com.tencent.mm.sdk.platformtools.bo;

final class MobileLoginOrForceReg$15
  implements View.OnClickListener
{
  MobileLoginOrForceReg$15(MobileLoginOrForceReg paramMobileLoginOrForceReg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125216);
    if (bo.isNullOrNil(MobileLoginOrForceReg.g(this.gGw)))
    {
      paramView = new Intent();
      a.xD("R200_900_phone");
      paramView.putExtra("regsetinfo_ticket", MobileLoginOrForceReg.h(this.gGw));
      paramView.putExtra("regsetinfo_user", MobileLoginOrForceReg.e(this.gGw));
      paramView.putExtra("regsetinfo_pwd", MobileLoginOrForceReg.d(this.gGw));
      paramView.putExtra("regsetinfo_ismobile", 4);
      paramView.putExtra("regsetinfo_isForce", true);
      paramView.putExtra("regsession_id", MobileLoginOrForceReg.i(this.gGw));
      paramView.putExtra("reg_3d_app_ticket", MobileLoginOrForceReg.j(this.gGw));
      paramView.putExtra("reg_3d_app_type", MobileLoginOrForceReg.k(this.gGw));
      paramView.putExtra("regsetinfo_NextControl", MobileLoginOrForceReg.l(this.gGw));
      paramView.putExtra("mobile_check_type", MobileLoginOrForceReg.m(this.gGw));
      paramView.putExtra("key_reg_style", MobileLoginOrForceReg.n(this.gGw));
      paramView.setClass(this.gGw, RegSetInfoUI.class);
      this.gGw.startActivity(paramView);
      AppMethodBeat.o(125216);
      return;
    }
    MobileLoginOrForceReg.o(this.gGw);
    AppMethodBeat.o(125216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.15
 * JD-Core Version:    0.7.0.1
 */