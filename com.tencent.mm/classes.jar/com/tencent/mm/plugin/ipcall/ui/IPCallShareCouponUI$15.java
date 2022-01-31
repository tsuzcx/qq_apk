package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ipcall.a.e.i;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class IPCallShareCouponUI$15
  implements View.OnClickListener
{
  IPCallShareCouponUI$15(IPCallShareCouponUI paramIPCallShareCouponUI) {}
  
  public final void onClick(View paramView)
  {
    au.Hx();
    if (((Boolean)c.Dz().get(ac.a.uqm, Boolean.valueOf(false))).booleanValue() == true) {
      i.M(3, -1, -1);
    }
    au.Hx();
    c.Dz().c(ac.a.uqm, Boolean.valueOf(false));
    IPCallShareCouponUI.a(this.lyX).setVisibility(8);
    paramView = new Intent();
    paramView.setClass(this.lyX.mController.uMN, IPCallRechargeUI.class);
    this.lyX.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.15
 * JD-Core Version:    0.7.0.1
 */