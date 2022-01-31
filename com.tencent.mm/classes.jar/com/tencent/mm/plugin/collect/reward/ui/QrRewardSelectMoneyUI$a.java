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
    AppMethodBeat.i(41138);
    int i = QrRewardSelectMoneyUI.a(this.kQf).size();
    AppMethodBeat.o(41138);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(41139);
    Object localObject = QrRewardSelectMoneyUI.a(this.kQf).get(paramInt);
    AppMethodBeat.o(41139);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(41140);
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.kQf.getContext()).inflate(2130970491, paramViewGroup, false);
    }
    paramInt = ((Integer)getItem(paramInt)).intValue();
    paramView = (TextView)localView.findViewById(2131826961);
    int i = paramInt / 100;
    double d = paramInt / 100.0D;
    if (d > i) {
      paramView.setText(String.format("%.2f", new Object[] { Double.valueOf(d) }) + this.kQf.getString(2131302236));
    }
    for (;;)
    {
      AppMethodBeat.o(41140);
      return localView;
      paramView.setText(String.format("%d", new Object[] { Integer.valueOf(i) }) + this.kQf.getString(2131302236));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI.a
 * JD-Core Version:    0.7.0.1
 */