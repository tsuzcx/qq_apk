package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.r;
import com.tencent.mm.sdk.platformtools.bo;

final class LuckyMoneyCanShareListUI$2
  implements AdapterView.OnItemClickListener
{
  LuckyMoneyCanShareListUI$2(LuckyMoneyCanShareListUI paramLuckyMoneyCanShareListUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(42637);
    paramAdapterView = LuckyMoneyCanShareListUI.a(this.oso).yz((int)paramLong);
    if ((paramAdapterView != null) && (!bo.isNullOrNil(paramAdapterView.ojA)))
    {
      paramView = new Intent();
      paramView.setClass(this.oso.getContext(), LuckyMoneyBeforeDetailUI.class);
      paramView.putExtra("key_sendid", paramAdapterView.ojA);
      this.oso.startActivity(paramView);
    }
    AppMethodBeat.o(42637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI.2
 * JD-Core Version:    0.7.0.1
 */