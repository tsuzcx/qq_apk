package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class IPCallShareCouponUI$12
  implements View.OnClickListener
{
  IPCallShareCouponUI$12(IPCallShareCouponUI paramIPCallShareCouponUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22330);
    h.qsU.e(13340, new Object[] { Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
    paramView = new Intent();
    paramView.setClass(this.nWj.getContext(), IPCallShareCouponCardUI.class);
    this.nWj.getContext().startActivity(paramView);
    AppMethodBeat.o(22330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.12
 * JD-Core Version:    0.7.0.1
 */