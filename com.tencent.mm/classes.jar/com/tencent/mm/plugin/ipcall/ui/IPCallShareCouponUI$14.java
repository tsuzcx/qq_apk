package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallShareCouponUI$14
  implements View.OnClickListener
{
  IPCallShareCouponUI$14(IPCallShareCouponUI paramIPCallShareCouponUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22332);
    paramView = new Intent();
    paramView.setClass(this.nWj.getContext(), IPCallMyGiftCardUI.class);
    this.nWj.getContext().startActivity(paramView);
    AppMethodBeat.o(22332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.14
 * JD-Core Version:    0.7.0.1
 */