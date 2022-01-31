package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.collect.b.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;

final class CollectHKMainUI$3
  implements View.OnClickListener
{
  CollectHKMainUI$3(CollectHKMainUI paramCollectHKMainUI, m paramm) {}
  
  public final void onClick(View paramView)
  {
    if (!bk.bl(this.iKL.iHD)) {
      e.l(this.iKN.mController.uMN, this.iKL.iHD, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectHKMainUI.3
 * JD-Core Version:    0.7.0.1
 */