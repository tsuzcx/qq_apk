package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;

final class RegByMobileSetPwdUI$1
  implements View.OnClickListener
{
  RegByMobileSetPwdUI$1(RegByMobileSetPwdUI paramRegByMobileSetPwdUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = (String)g.DP().Dz().get(6, null);
    if (bk.bl(paramView))
    {
      y.i("MicorMsg.RegByMobileSetPwdUI", "has not bind mobile");
      paramView = new Intent(this.frm, BindMContactUI.class);
      paramView.putExtra("is_bind_for_reset_pwd", true);
      h.a(this.frm, this.frm.getString(q.j.regbymobile_reg_setpwd_no_mobile), "", this.frm.getString(q.j.bind_start), this.frm.getString(q.j.app_cancel), true, new RegByMobileSetPwdUI.1.1(this, paramView), null);
      return;
    }
    y.i("MicorMsg.RegByMobileSetPwdUI", "has bind mobile");
    h.a(this.frm, this.frm.getString(q.j.regbymobile_reg_setpwd_has_mobile, new Object[] { paramView }), "", this.frm.getString(q.j.app_send), this.frm.getString(q.j.app_cancel), true, new RegByMobileSetPwdUI.1.2(this, paramView), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI.1
 * JD-Core Version:    0.7.0.1
 */