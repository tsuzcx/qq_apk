package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;

public final class e
  extends d
{
  private Context mContext = null;
  
  public e(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.Lu.inflate(a.g.lucky_money_my_send_record_item, paramViewGroup, false);
      paramViewGroup = new e.a(this);
      paramViewGroup.haW = ((TextView)paramView.findViewById(a.f.lucky_money_my_send_record_title));
      paramViewGroup.iIV = ((TextView)paramView.findViewById(a.f.lucky_money_my_send_record_desc));
      paramViewGroup.lLL = ((TextView)paramView.findViewById(a.f.lucky_money_my_send_record_time));
      paramViewGroup.lLM = ((TextView)paramView.findViewById(a.f.lucky_money_my_send_record_amount));
      paramViewGroup.El = paramInt;
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      i locali = tt(paramInt);
      paramViewGroup.haW.setText(locali.lQA);
      paramViewGroup.lLL.setText(locali.lQB);
      paramViewGroup.lLM.setText(this.mContext.getString(a.i.lucky_money_amount_with_unit, new Object[] { com.tencent.mm.wallet_core.ui.e.A(locali.lQa / 100.0D) }));
      String str2 = this.mContext.getString(a.i.lucky_money_send_record_desc, new Object[] { Long.valueOf(locali.lPY), Long.valueOf(locali.lQC) });
      String str1 = str2;
      if (locali.status == 5) {
        str1 = this.mContext.getString(a.i.lucky_money_send_record_status_expired) + " " + str2;
      }
      paramViewGroup.iIV.setText(str1);
      return paramView;
      paramViewGroup = (e.a)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.e
 * JD-Core Version:    0.7.0.1
 */