package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class IPCallShareCouponUI$12
  implements View.OnClickListener
{
  IPCallShareCouponUI$12(IPCallShareCouponUI paramIPCallShareCouponUI) {}
  
  public final void onClick(View paramView)
  {
    h.nFQ.f(13340, new Object[] { Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
    paramView = new Intent();
    paramView.setClass(this.lyX.mController.uMN, IPCallShareCouponCardUI.class);
    this.lyX.mController.uMN.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.12
 * JD-Core Version:    0.7.0.1
 */