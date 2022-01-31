package com.tencent.mm.plugin.luckymoney.ui;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
    AppMethodBeat.i(42562);
    AppMethodBeat.o(42562);
    return Integer.valueOf(paramInt % 10);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(42563);
    View localView;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localView = LayoutInflater.from(LuckyMoneyAutoScrollItem.c(this.ore)).inflate(2130970014, null);
      paramView = new LuckyMoneyAutoScrollItem.a.a(this);
      paramView.org = ((ImageView)localView.findViewById(2131825544));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.org.setImageResource(((Integer)LuckyMoneyAutoScrollItem.orc.get(paramInt % 10)).intValue());
      AppMethodBeat.o(42563);
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