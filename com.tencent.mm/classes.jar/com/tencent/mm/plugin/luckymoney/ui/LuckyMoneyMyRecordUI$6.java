package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.e;

final class LuckyMoneyMyRecordUI$6
  implements View.OnClickListener
{
  LuckyMoneyMyRecordUI$6(LuckyMoneyMyRecordUI paramLuckyMoneyMyRecordUI) {}
  
  public final void onClick(View paramView)
  {
    if (!bk.bl(this.lVW.lRy))
    {
      e.l(this.lVW, this.lVW.lRy, true);
      return;
    }
    y.w("MicroMsg.LuckyMoneyMyRecordUI", "hy: no avatar jump h5");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.6
 * JD-Core Version:    0.7.0.1
 */