package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.g.a;
import com.tencent.mm.sdk.platformtools.ab;

final class IPCallAcitivityUI$2
  implements View.OnClickListener
{
  IPCallAcitivityUI$2(IPCallAcitivityUI paramIPCallAcitivityUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21987);
    if (IPCallAcitivityUI.a(this.nRa).jKs == 1)
    {
      ab.i("MicroMsg.IPCallAcitivityUI", "click activity, go to IPCallPackageUI");
      paramView = new Intent();
      paramView.setClass(this.nRa.getContext(), IPCallShareCouponUI.class);
      this.nRa.startActivity(paramView);
      paramView = new Intent();
      paramView.setClass(this.nRa.getContext(), IPCallPackageUI.class);
      this.nRa.startActivity(paramView);
    }
    IPCallAcitivityUI.b(this.nRa);
    this.nRa.finish();
    AppMethodBeat.o(21987);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAcitivityUI.2
 * JD-Core Version:    0.7.0.1
 */