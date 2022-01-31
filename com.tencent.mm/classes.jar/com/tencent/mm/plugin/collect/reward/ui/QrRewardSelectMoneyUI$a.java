package com.tencent.mm.plugin.collect.reward.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.List;

final class QrRewardSelectMoneyUI$a
  extends BaseAdapter
{
  private QrRewardSelectMoneyUI$a(QrRewardSelectMoneyUI paramQrRewardSelectMoneyUI) {}
  
  public final int getCount()
  {
    return QrRewardSelectMoneyUI.a(this.iJz).size();
  }
  
  public final Object getItem(int paramInt)
  {
    return QrRewardSelectMoneyUI.a(this.iJz).get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.iJz.mController.uMN).inflate(a.g.qr_reward_select_money_item, paramViewGroup, false);
    }
    paramInt = ((Integer)getItem(paramInt)).intValue();
    paramView = (TextView)localView.findViewById(a.f.qrsi_money_tv);
    int i = paramInt / 100;
    double d = paramInt / 100.0D;
    if (d > i)
    {
      paramView.setText(String.format("%.2f", new Object[] { Double.valueOf(d) }) + this.iJz.getString(a.i.qr_reward_yuan));
      return localView;
    }
    paramView.setText(String.format("%d", new Object[] { Integer.valueOf(i) }) + this.iJz.getString(a.i.qr_reward_yuan));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI.a
 * JD-Core Version:    0.7.0.1
 */