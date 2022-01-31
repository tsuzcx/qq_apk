package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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

final class IPCallShareCouponUI$13
  implements View.OnClickListener
{
  IPCallShareCouponUI$13(IPCallShareCouponUI paramIPCallShareCouponUI) {}
  
  public final void onClick(View paramView)
  {
    au.Hx();
    if (((Boolean)c.Dz().get(ac.a.uqu, Boolean.valueOf(false))).booleanValue())
    {
      au.Hx();
      i.M(4, -1, ((Integer)c.Dz().get(ac.a.uqv, Integer.valueOf(-1))).intValue());
    }
    au.Hx();
    c.Dz().c(ac.a.uqv, Integer.valueOf(-1));
    au.Hx();
    c.Dz().c(ac.a.uqu, Boolean.valueOf(false));
    IPCallShareCouponUI.g(this.lyX).setVisibility(8);
    paramView = new Intent();
    paramView.setClass(this.lyX.mController.uMN, IPCallMsgUI.class);
    this.lyX.mController.uMN.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.13
 * JD-Core Version:    0.7.0.1
 */