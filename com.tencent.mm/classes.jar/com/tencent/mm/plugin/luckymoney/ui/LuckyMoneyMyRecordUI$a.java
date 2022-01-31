package com.tencent.mm.plugin.luckymoney.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class LuckyMoneyMyRecordUI$a
  extends BaseAdapter
{
  int aRn;
  List<String> otZ;
  
  LuckyMoneyMyRecordUI$a(LuckyMoneyMyRecordUI paramLuckyMoneyMyRecordUI) {}
  
  public final int getCount()
  {
    AppMethodBeat.i(42766);
    int i = this.otZ.size();
    AppMethodBeat.o(42766);
    return i;
  }
  
  public final String getItem(int paramInt)
  {
    AppMethodBeat.i(42767);
    String str = (String)this.otZ.get(paramInt);
    AppMethodBeat.o(42767);
    return str;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(42768);
    paramView = (CheckedTextView)LayoutInflater.from(this.oua.getContext()).inflate(2130971195, paramViewGroup, false);
    paramView.setText(getItem(paramInt));
    if (paramInt == this.aRn) {
      paramView.setChecked(true);
    }
    for (;;)
    {
      AppMethodBeat.o(42768);
      return paramView;
      paramView.setChecked(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.a
 * JD-Core Version:    0.7.0.1
 */