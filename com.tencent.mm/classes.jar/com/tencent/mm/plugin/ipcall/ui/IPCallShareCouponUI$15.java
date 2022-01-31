package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ipcall.a.e.i;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class IPCallShareCouponUI$15
  implements View.OnClickListener
{
  IPCallShareCouponUI$15(IPCallShareCouponUI paramIPCallShareCouponUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22333);
    aw.aaz();
    if (((Boolean)c.Ru().get(ac.a.yAm, Boolean.FALSE)).booleanValue() == true) {
      i.Y(3, -1, -1);
    }
    aw.aaz();
    c.Ru().set(ac.a.yAm, Boolean.FALSE);
    IPCallShareCouponUI.a(this.nWj).setVisibility(8);
    paramView = new Intent();
    paramView.setClass(this.nWj.getContext(), IPCallRechargeUI.class);
    this.nWj.startActivity(paramView);
    AppMethodBeat.o(22333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.15
 * JD-Core Version:    0.7.0.1
 */