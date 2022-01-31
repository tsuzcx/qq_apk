package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class LuckyMoneyMyRecordUI$3
  implements AdapterView.OnItemClickListener
{
  LuckyMoneyMyRecordUI$3(LuckyMoneyMyRecordUI paramLuckyMoneyMyRecordUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt = 3;
    AppMethodBeat.i(42759);
    int i = (int)paramLong;
    h.qsU.e(11701, new Object[] { Integer.valueOf(LuckyMoneyMyRecordUI.e(this.oua)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
    if ((i >= 0) && (i < LuckyMoneyMyRecordUI.f(this.oua).getCount()))
    {
      paramAdapterView = LuckyMoneyMyRecordUI.f(this.oua).yz(i);
      if ((paramAdapterView != null) && (!bo.isNullOrNil(paramAdapterView.ojA)))
      {
        paramView = new Intent();
        if (paramAdapterView.onK != 2) {
          break label194;
        }
        ab.d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go busi detail");
        paramView.setClass(this.oua.getContext(), LuckyMoneyBusiDetailUI.class);
        paramView.putExtra("key_sendid", paramAdapterView.ojA);
        if (LuckyMoneyMyRecordUI.a(this.oua) != 1) {
          break label218;
        }
      }
    }
    for (;;)
    {
      paramView.putExtra("key_jump_from", paramInt);
      this.oua.startActivity(paramView);
      AppMethodBeat.o(42759);
      return;
      label194:
      ab.d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go normal detail");
      paramView.setClass(this.oua.getContext(), LuckyMoneyBeforeDetailUI.class);
      break;
      label218:
      paramInt = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.3
 * JD-Core Version:    0.7.0.1
 */