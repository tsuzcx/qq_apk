package com.tencent.mm.plugin.luckymoney.ui;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

final class LuckyMoneyMyRecordUI$4
  implements AdapterView.OnItemLongClickListener
{
  LuckyMoneyMyRecordUI$4(LuckyMoneyMyRecordUI paramLuckyMoneyMyRecordUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramInt <= 0) || (paramInt > LuckyMoneyMyRecordUI.f(this.lVW).getCount())) {
      return true;
    }
    h.a(this.lVW, this.lVW.getResources().getString(a.i.lucky_money_list_delete_record), null, this.lVW.getResources().getString(a.i.app_delete), new LuckyMoneyMyRecordUI.4.1(this, paramInt - 1));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.4
 * JD-Core Version:    0.7.0.1
 */