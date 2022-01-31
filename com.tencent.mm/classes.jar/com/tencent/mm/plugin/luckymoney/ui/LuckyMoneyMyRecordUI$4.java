package com.tencent.mm.plugin.luckymoney.ui;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class LuckyMoneyMyRecordUI$4
  implements AdapterView.OnItemLongClickListener
{
  LuckyMoneyMyRecordUI$4(LuckyMoneyMyRecordUI paramLuckyMoneyMyRecordUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(42761);
    if ((paramInt <= 0) || (paramInt > LuckyMoneyMyRecordUI.f(this.oua).getCount()))
    {
      AppMethodBeat.o(42761);
      return true;
    }
    h.a(this.oua, this.oua.getResources().getString(2131301247), null, this.oua.getResources().getString(2131296901), new LuckyMoneyMyRecordUI.4.1(this, paramInt - 1));
    AppMethodBeat.o(42761);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.4
 * JD-Core Version:    0.7.0.1
 */