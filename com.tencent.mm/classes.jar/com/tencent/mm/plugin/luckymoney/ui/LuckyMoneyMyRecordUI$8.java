package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import java.util.List;
import java.util.Map;

final class LuckyMoneyMyRecordUI$8
  implements AdapterView.OnItemClickListener
{
  LuckyMoneyMyRecordUI$8(LuckyMoneyMyRecordUI paramLuckyMoneyMyRecordUI, LuckyMoneyMyRecordUI.a parama) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.lVW.dismissDialog(1);
    paramAdapterView = this.lWa.ke(paramInt);
    this.lWa.aJH = paramInt;
    if (!paramAdapterView.equals(LuckyMoneyMyRecordUI.j(this.lVW)))
    {
      LuckyMoneyMyRecordUI.a(this.lVW, paramAdapterView);
      LuckyMoneyMyRecordUI.k(this.lVW).setText(this.lVW.getString(a.i.lucky_money_record_year_title, new Object[] { LuckyMoneyMyRecordUI.j(this.lVW) }));
      LuckyMoneyMyRecordUI.l(this.lVW);
      LuckyMoneyMyRecordUI.m(this.lVW).clear();
      LuckyMoneyMyRecordUI.n(this.lVW).clear();
      LuckyMoneyMyRecordUI.d(this.lVW);
    }
    h.nFQ.f(11701, new Object[] { Integer.valueOf(LuckyMoneyMyRecordUI.e(this.lVW)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), paramAdapterView });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.8
 * JD-Core Version:    0.7.0.1
 */