package com.tencent.mm.plugin.luckymoney.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.List;

final class LuckyMoneyMyRecordUI$a
  extends BaseAdapter
{
  int aJH;
  List<String> lVV;
  
  LuckyMoneyMyRecordUI$a(LuckyMoneyMyRecordUI paramLuckyMoneyMyRecordUI) {}
  
  public final int getCount()
  {
    return this.lVV.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (CheckedTextView)LayoutInflater.from(this.lVW.mController.uMN).inflate(a.g.wallet_list_dialog_item_singlechoice, paramViewGroup, false);
    paramView.setText(ke(paramInt));
    if (paramInt == this.aJH)
    {
      paramView.setChecked(true);
      return paramView;
    }
    paramView.setChecked(false);
    return paramView;
  }
  
  public final String ke(int paramInt)
  {
    return (String)this.lVV.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.a
 * JD-Core Version:    0.7.0.1
 */