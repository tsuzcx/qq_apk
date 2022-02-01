package com.tencent.mm.plugin.collect.reward.ui;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class QrRewardSetMoneyUI$a
  extends BaseAdapter
{
  private QrRewardSetMoneyUI$a(QrRewardSetMoneyUI paramQrRewardSetMoneyUI) {}
  
  public final int getCount()
  {
    AppMethodBeat.i(64016);
    int i = QrRewardSetMoneyUI.e(this.xbJ).size();
    AppMethodBeat.o(64016);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(64017);
    Object localObject = QrRewardSetMoneyUI.e(this.xbJ).get(paramInt);
    AppMethodBeat.o(64017);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(64018);
    if (paramView == null) {
      paramView = (View)QrRewardSetMoneyUI.f(this.xbJ).get(paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(64018);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI.a
 * JD-Core Version:    0.7.0.1
 */