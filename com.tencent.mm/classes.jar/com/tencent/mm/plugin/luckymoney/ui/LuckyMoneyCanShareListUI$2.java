package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.luckymoney.b.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class LuckyMoneyCanShareListUI$2
  implements AdapterView.OnItemClickListener
{
  LuckyMoneyCanShareListUI$2(LuckyMoneyCanShareListUI paramLuckyMoneyCanShareListUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = LuckyMoneyCanShareListUI.a(this.lVf).tt((int)paramLong);
    if ((paramAdapterView != null) && (!bk.bl(paramAdapterView.lMg)))
    {
      paramView = new Intent();
      paramView.setClass(this.lVf.mController.uMN, LuckyMoneyDetailUI.class);
      paramView.putExtra("key_sendid", paramAdapterView.lMg);
      this.lVf.startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI.2
 * JD-Core Version:    0.7.0.1
 */