package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallShareCouponUI$2
  implements View.OnClickListener
{
  IPCallShareCouponUI$2(IPCallShareCouponUI paramIPCallShareCouponUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22318);
    paramView = new Intent();
    paramView.setClass(this.nWj.getContext(), IPCallPackageUI.class);
    this.nWj.startActivity(paramView);
    AppMethodBeat.o(22318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.2
 * JD-Core Version:    0.7.0.1
 */