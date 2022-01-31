package com.tencent.mm.plugin.collect.reward.ui;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

final class QrRewardSetMoneyUI$a
  extends BaseAdapter
{
  private QrRewardSetMoneyUI$a(QrRewardSetMoneyUI paramQrRewardSetMoneyUI) {}
  
  public final int getCount()
  {
    return QrRewardSetMoneyUI.e(this.iJO).size();
  }
  
  public final Object getItem(int paramInt)
  {
    return QrRewardSetMoneyUI.e(this.iJO).get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      return (View)QrRewardSetMoneyUI.f(this.iJO).get(paramInt);
    }
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI.a
 * JD-Core Version:    0.7.0.1
 */