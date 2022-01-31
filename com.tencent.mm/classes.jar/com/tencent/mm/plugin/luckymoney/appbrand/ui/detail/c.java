package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.aog;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends BaseAdapter
{
  private LayoutInflater Lu;
  List<aog> lLG = new LinkedList();
  private String lLH = null;
  boolean lLI = false;
  private int lLJ = 1;
  private c.a lLK = null;
  private Context mContext;
  
  public c(Context paramContext)
  {
    this.mContext = paramContext;
    this.Lu = LayoutInflater.from(paramContext);
  }
  
  private aog tf(int paramInt)
  {
    return (aog)this.lLG.get(paramInt);
  }
  
  public final int getCount()
  {
    return this.lLG.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.Lu.inflate(a.g.lucky_money_record_item, paramViewGroup, false);
      paramViewGroup = new c.b(this);
      paramViewGroup.iUL = paramView.findViewById(a.f.root);
      paramViewGroup.iIS = ((ImageView)paramView.findViewById(a.f.lucky_money_record_avatar));
      paramViewGroup.lbC = ((TextView)paramView.findViewById(a.f.lucky_money_record_nickname));
      paramViewGroup.lLL = ((TextView)paramView.findViewById(a.f.lucky_money_record_time));
      paramViewGroup.lLM = ((TextView)paramView.findViewById(a.f.lucky_money_record_amount));
      paramViewGroup.lLN = ((TextView)paramView.findViewById(a.f.lucky_money_record_answer));
      paramViewGroup.lLO = ((TextView)paramView.findViewById(a.f.lucky_money_record_wish_btn));
      paramViewGroup.lLP = ((ImageView)paramView.findViewById(a.f.lucky_money_record_best_luck_icon));
      paramViewGroup.lLQ = ((TextView)paramView.findViewById(a.f.lucky_money_record_game_tips));
      paramView.setTag(paramViewGroup);
    }
    aog localaog;
    for (;;)
    {
      localaog = tf(paramInt);
      o.a(paramViewGroup.iIS, localaog.lLj, localaog.username);
      paramViewGroup.lLN.setVisibility(8);
      o.a(this.mContext, paramViewGroup.lbC, localaog.nickname);
      String str = this.mContext.getString(a.i.lucky_money_receive_amount, new Object[] { e.A(localaog.tjV / 100.0D) });
      paramViewGroup.lLM.setText(str);
      paramViewGroup.lLL.setText(o.i(this.mContext, localaog.tjW * 1000L));
      paramViewGroup.lLL.setVisibility(0);
      paramViewGroup.lLO.setVisibility(8);
      if (!bk.bl(localaog.tjY)) {
        break;
      }
      paramViewGroup.lLP.setVisibility(8);
      paramViewGroup.lLQ.setVisibility(8);
      return paramView;
      paramViewGroup = (c.b)paramView.getTag();
    }
    paramViewGroup.lLQ.setText(localaog.tjY);
    if (this.lLJ == 2) {
      paramViewGroup.lLP.setImageResource(a.e.lucky_money_first_share_icon);
    }
    for (;;)
    {
      paramViewGroup.lLP.setVisibility(0);
      paramViewGroup.lLQ.setVisibility(0);
      return paramView;
      paramViewGroup.lLP.setImageResource(a.e.lucky_money_best_luck_icon);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.c
 * JD-Core Version:    0.7.0.1
 */