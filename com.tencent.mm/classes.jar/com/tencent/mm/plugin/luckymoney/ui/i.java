package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends BaseAdapter
{
  private LayoutInflater Lu;
  private List<n> lLG = new LinkedList();
  String lLH;
  boolean lLI;
  int lLJ = 1;
  View.OnClickListener lXC;
  i.b lXD = null;
  private Context mContext;
  
  public i(Context paramContext)
  {
    this.mContext = paramContext;
    this.Lu = LayoutInflater.from(paramContext);
  }
  
  private n tw(int paramInt)
  {
    return (n)this.lLG.get(paramInt);
  }
  
  public final void bM(List<n> paramList)
  {
    if (paramList == null) {
      new LinkedList();
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.lLG = paramList;
    }
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
      paramViewGroup = new i.c(this);
      paramViewGroup.iUL = paramView.findViewById(a.f.root);
      paramViewGroup.iIS = ((ImageView)paramView.findViewById(a.f.lucky_money_record_avatar));
      paramViewGroup.lbC = ((TextView)paramView.findViewById(a.f.lucky_money_record_nickname));
      paramViewGroup.lLL = ((TextView)paramView.findViewById(a.f.lucky_money_record_time));
      paramViewGroup.lLM = ((TextView)paramView.findViewById(a.f.lucky_money_record_amount));
      paramViewGroup.lLN = ((TextView)paramView.findViewById(a.f.lucky_money_record_answer));
      paramViewGroup.lLO = ((TextView)paramView.findViewById(a.f.lucky_money_record_wish_btn));
      paramViewGroup.lLP = ((ImageView)paramView.findViewById(a.f.lucky_money_record_best_luck_icon));
      paramViewGroup.lLQ = ((TextView)paramView.findViewById(a.f.lucky_money_record_game_tips));
      if (this.lXD != null) {
        this.lXD.a(paramViewGroup, this.mContext);
      }
      paramView.setTag(paramViewGroup);
    }
    n localn;
    for (;;)
    {
      localn = tw(paramInt);
      o.a(paramViewGroup.iIS, localn.lQM, localn.userName);
      if ((!bk.pm(localn.lQb).equals(this.lLH)) || (!this.lLI)) {
        break;
      }
      paramViewGroup.lLO.setOnClickListener(this.lXC);
      paramViewGroup.lLO.setVisibility(0);
      paramViewGroup.lLN.setVisibility(8);
      paramViewGroup.lLL.setVisibility(8);
      o.a(this.mContext, paramViewGroup.lbC, localn.lQL);
      String str = this.mContext.getString(a.i.lucky_money_receive_amount, new Object[] { e.A(localn.lQy / 100.0D) });
      paramViewGroup.lLM.setText(str);
      if (!bk.bl(localn.lQO)) {
        break label454;
      }
      paramViewGroup.lLP.setVisibility(8);
      paramViewGroup.lLQ.setVisibility(8);
      return paramView;
      paramViewGroup = (i.c)paramView.getTag();
    }
    if (bk.bl(localn.lQN)) {
      paramViewGroup.lLN.setVisibility(8);
    }
    for (;;)
    {
      paramViewGroup.lLL.setText(o.i(this.mContext, bk.getLong(localn.lQz, 0L) * 1000L));
      paramViewGroup.lLL.setVisibility(0);
      paramViewGroup.lLO.setVisibility(8);
      break;
      o.a(this.mContext, paramViewGroup.lLN, localn.lQN);
      paramViewGroup.lLN.setVisibility(0);
    }
    label454:
    paramViewGroup.lLQ.setText(localn.lQO);
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
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.i
 * JD-Core Version:    0.7.0.1
 */