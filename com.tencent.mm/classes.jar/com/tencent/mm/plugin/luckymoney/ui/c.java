package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.i;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.e;

public final class c
  extends d
{
  private Context mContext;
  
  public c(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.Lu.inflate(a.g.lucky_money_my_receive_record_item, paramViewGroup, false);
      paramViewGroup = new c.a(this);
      paramViewGroup.lbC = ((TextView)paramView.findViewById(a.f.lucky_money_my_record_nickname));
      paramViewGroup.lLL = ((TextView)paramView.findViewById(a.f.lucky_money_my_record_time));
      paramViewGroup.lLM = ((TextView)paramView.findViewById(a.f.lucky_money_my_record_amount));
      paramViewGroup.lLX = ((ImageView)paramView.findViewById(a.f.lucky_money_my_record_group_icon));
      paramView.setTag(paramViewGroup);
    }
    i locali;
    for (;;)
    {
      locali = tt(paramInt);
      o.a(this.mContext, paramViewGroup.lbC, locali.lQx);
      paramViewGroup.lLL.setText(locali.lQz);
      paramViewGroup.lLM.setText(this.mContext.getString(a.i.lucky_money_receive_amount, new Object[] { e.A(locali.lQy / 100.0D) }));
      if (locali.lPR != 1) {
        break;
      }
      paramViewGroup.lLX.setImageResource(a.e.lucky_money_group_icon);
      paramViewGroup.lLX.setVisibility(0);
      return paramView;
      paramViewGroup = (c.a)paramView.getTag();
    }
    if (locali.lPR == 2)
    {
      paramViewGroup.lLX.setImageResource(a.e.lucky_money_f2f_record_icon);
      paramViewGroup.lLX.setVisibility(0);
      return paramView;
    }
    paramViewGroup.lLX.setVisibility(8);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.c
 * JD-Core Version:    0.7.0.1
 */