package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.ipcall.a.g.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class IPCallAcitivityUI$2
  implements View.OnClickListener
{
  IPCallAcitivityUI$2(IPCallAcitivityUI paramIPCallAcitivityUI) {}
  
  public final void onClick(View paramView)
  {
    if (IPCallAcitivityUI.a(this.ltH).hQR == 1)
    {
      y.i("MicroMsg.IPCallAcitivityUI", "click activity, go to IPCallPackageUI");
      paramView = new Intent();
      paramView.setClass(this.ltH.mController.uMN, IPCallShareCouponUI.class);
      this.ltH.startActivity(paramView);
      paramView = new Intent();
      paramView.setClass(this.ltH.mController.uMN, IPCallPackageUI.class);
      this.ltH.startActivity(paramView);
    }
    IPCallAcitivityUI.b(this.ltH);
    this.ltH.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAcitivityUI.2
 * JD-Core Version:    0.7.0.1
 */