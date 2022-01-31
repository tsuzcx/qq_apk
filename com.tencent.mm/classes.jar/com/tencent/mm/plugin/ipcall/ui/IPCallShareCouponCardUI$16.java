package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.j.a;

final class IPCallShareCouponCardUI$16
  implements DialogInterface.OnClickListener
{
  IPCallShareCouponCardUI$16(IPCallShareCouponCardUI paramIPCallShareCouponCardUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(22296);
    paramDialogInterface = this.nVC;
    AppCompatActivity localAppCompatActivity = this.nVC.getContext();
    this.nVC.getContext().getString(2131297087);
    IPCallShareCouponCardUI.a(paramDialogInterface, h.b(localAppCompatActivity, this.nVC.getContext().getString(2131304397), true, new IPCallShareCouponCardUI.16.1(this)));
    IPCallShareCouponCardUI.c(this.nVC).a(this.nVC, this.nVC.getContext());
    AppMethodBeat.o(22296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.16
 * JD-Core Version:    0.7.0.1
 */