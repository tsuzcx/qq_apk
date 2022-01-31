package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.List;
import java.util.Map;

final class LuckyMoneyMyRecordUI$8
  implements AdapterView.OnItemClickListener
{
  LuckyMoneyMyRecordUI$8(LuckyMoneyMyRecordUI paramLuckyMoneyMyRecordUI, LuckyMoneyMyRecordUI.a parama) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(42765);
    this.oua.dismissDialog(1);
    paramAdapterView = this.oue.getItem(paramInt);
    this.oue.aRn = paramInt;
    if (!paramAdapterView.equals(LuckyMoneyMyRecordUI.j(this.oua)))
    {
      LuckyMoneyMyRecordUI.a(this.oua, paramAdapterView);
      LuckyMoneyMyRecordUI.k(this.oua).setText(this.oua.getString(2131301298, new Object[] { LuckyMoneyMyRecordUI.j(this.oua) }));
      LuckyMoneyMyRecordUI.l(this.oua);
      LuckyMoneyMyRecordUI.m(this.oua).clear();
      LuckyMoneyMyRecordUI.n(this.oua).clear();
      LuckyMoneyMyRecordUI.d(this.oua);
    }
    h.qsU.e(11701, new Object[] { Integer.valueOf(LuckyMoneyMyRecordUI.e(this.oua)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), paramAdapterView });
    AppMethodBeat.o(42765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.8
 * JD-Core Version:    0.7.0.1
 */