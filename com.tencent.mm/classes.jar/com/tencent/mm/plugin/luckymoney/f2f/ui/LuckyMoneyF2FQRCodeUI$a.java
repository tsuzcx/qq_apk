package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.List;
import java.util.Map;

final class LuckyMoneyF2FQRCodeUI$a
  extends BaseAdapter
{
  private LuckyMoneyF2FQRCodeUI$a(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI) {}
  
  private String ke(int paramInt)
  {
    return (String)LuckyMoneyF2FQRCodeUI.a(this.lOE).get(paramInt);
  }
  
  public final int getCount()
  {
    return LuckyMoneyF2FQRCodeUI.a(this.lOE).size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.lOE).inflate(a.g.lucky_money_f2f_recv_list_item, null);
      localObject = (ImageView)paramView.findViewById(a.f.lucky_money_f2f_recv_grid_avatar);
      ImageView localImageView = (ImageView)paramView.findViewById(a.f.lucky_money_f2f_most_lucky_icon);
      paramViewGroup = new LuckyMoneyF2FQRCodeUI.a.a(this);
      paramViewGroup.eYO = ((ImageView)localObject);
      paramViewGroup.lON = localImageView;
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      localObject = (String)LuckyMoneyF2FQRCodeUI.b(this.lOE).get(ke(paramInt));
      o.a(paramViewGroup.eYO, null, (String)localObject);
      if ((bk.bl(LuckyMoneyF2FQRCodeUI.C(this.lOE))) || (!LuckyMoneyF2FQRCodeUI.C(this.lOE).equals(localObject))) {
        break;
      }
      paramViewGroup.lON.setVisibility(0);
      return paramView;
      paramViewGroup = (LuckyMoneyF2FQRCodeUI.a.a)paramView.getTag();
    }
    paramViewGroup.lON.setVisibility(4);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.a
 * JD-Core Version:    0.7.0.1
 */