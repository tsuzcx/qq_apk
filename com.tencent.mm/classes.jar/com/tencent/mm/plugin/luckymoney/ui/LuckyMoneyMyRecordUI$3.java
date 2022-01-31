package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.luckymoney.b.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class LuckyMoneyMyRecordUI$3
  implements AdapterView.OnItemClickListener
{
  LuckyMoneyMyRecordUI$3(LuckyMoneyMyRecordUI paramLuckyMoneyMyRecordUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt = 3;
    int i = (int)paramLong;
    h.nFQ.f(11701, new Object[] { Integer.valueOf(LuckyMoneyMyRecordUI.e(this.lVW)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
    if ((i >= 0) && (i < LuckyMoneyMyRecordUI.f(this.lVW).getCount()))
    {
      paramAdapterView = LuckyMoneyMyRecordUI.f(this.lVW).tt(i);
      if ((paramAdapterView != null) && (!bk.bl(paramAdapterView.lMg)))
      {
        paramView = new Intent();
        if (paramAdapterView.lQm != 2) {
          break label187;
        }
        y.d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go busi detail");
        paramView.setClass(this.lVW.mController.uMN, LuckyMoneyBusiDetailUI.class);
        paramView.putExtra("key_sendid", paramAdapterView.lMg);
        if (LuckyMoneyMyRecordUI.a(this.lVW) != 1) {
          break label214;
        }
      }
    }
    for (;;)
    {
      paramView.putExtra("key_jump_from", paramInt);
      this.lVW.startActivity(paramView);
      return;
      label187:
      y.d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go normal detail");
      paramView.setClass(this.lVW.mController.uMN, LuckyMoneyDetailUI.class);
      break;
      label214:
      paramInt = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.3
 * JD-Core Version:    0.7.0.1
 */