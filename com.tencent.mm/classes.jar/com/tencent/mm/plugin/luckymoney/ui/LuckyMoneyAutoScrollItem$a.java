package com.tencent.mm.plugin.luckymoney.ui;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;

final class LuckyMoneyAutoScrollItem$a
  extends BaseAdapter
{
  private LuckyMoneyAutoScrollItem$a(LuckyMoneyAutoScrollItem paramLuckyMoneyAutoScrollItem) {}
  
  public final int getCount()
  {
    return 2147483646;
  }
  
  public final Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt % 10);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localView = LayoutInflater.from(LuckyMoneyAutoScrollItem.c(this.lTX)).inflate(a.g.lucky_money_auto_scroll_item, null);
      paramView = new LuckyMoneyAutoScrollItem.a.a(this);
      paramView.lTZ = ((ImageView)localView.findViewById(a.f.text_number));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.lTZ.setImageResource(((Integer)LuckyMoneyAutoScrollItem.lTV.get(paramInt % 10)).intValue());
      return localView;
      paramViewGroup = (LuckyMoneyAutoScrollItem.a.a)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollItem.a
 * JD-Core Version:    0.7.0.1
 */