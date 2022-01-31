package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.i.a;
import com.tencent.mm.ui.s;

final class IPCallShareCouponCardUI$16
  implements DialogInterface.OnClickListener
{
  IPCallShareCouponCardUI$16(IPCallShareCouponCardUI paramIPCallShareCouponCardUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.lyq;
    AppCompatActivity localAppCompatActivity = this.lyq.mController.uMN;
    this.lyq.mController.uMN.getString(R.l.app_tip);
    IPCallShareCouponCardUI.a(paramDialogInterface, h.b(localAppCompatActivity, this.lyq.mController.uMN.getString(R.l.twitter_loading), true, new IPCallShareCouponCardUI.16.1(this)));
    IPCallShareCouponCardUI.c(this.lyq).a(this.lyq, this.lyq.mController.uMN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.16
 * JD-Core Version:    0.7.0.1
 */