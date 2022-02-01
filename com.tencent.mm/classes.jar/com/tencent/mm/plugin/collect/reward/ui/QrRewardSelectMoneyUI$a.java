package com.tencent.mm.plugin.collect.reward.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class QrRewardSelectMoneyUI$a
  extends BaseAdapter
{
  private QrRewardSelectMoneyUI$a(QrRewardSelectMoneyUI paramQrRewardSelectMoneyUI) {}
  
  public final int getCount()
  {
    AppMethodBeat.i(63997);
    int i = QrRewardSelectMoneyUI.a(this.qzb).size();
    AppMethodBeat.o(63997);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(63998);
    Object localObject = QrRewardSelectMoneyUI.a(this.qzb).get(paramInt);
    AppMethodBeat.o(63998);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(63999);
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.qzb.getContext()).inflate(2131496007, paramViewGroup, false);
    }
    paramInt = ((Integer)getItem(paramInt)).intValue();
    paramView = (TextView)localView.findViewById(2131306435);
    int i = paramInt / 100;
    double d = paramInt / 100.0D;
    if (d > i) {
      paramView.setText(String.format("%.2f", new Object[] { Double.valueOf(d) }) + this.qzb.getString(2131764136));
    }
    for (;;)
    {
      AppMethodBeat.o(63999);
      return localView;
      paramView.setText(String.format("%d", new Object[] { Integer.valueOf(i) }) + this.qzb.getString(2131764136));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI.a
 * JD-Core Version:    0.7.0.1
 */