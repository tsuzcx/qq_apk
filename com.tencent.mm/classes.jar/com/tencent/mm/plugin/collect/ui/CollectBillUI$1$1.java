package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.c.cx;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;

final class CollectBillUI$1$1
  implements View.OnClickListener
{
  CollectBillUI$1$1(CollectBillUI.1 param1, cx paramcx) {}
  
  public final void onClick(View paramView)
  {
    if (!bk.bl(this.iKE.url)) {
      e.l(this.iKF.iKD.mController.uMN, this.iKE.url, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillUI.1.1
 * JD-Core Version:    0.7.0.1
 */