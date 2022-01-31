package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.ra;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends BaseAdapter
{
  List<CardInfo> iqo = new ArrayList();
  HashMap<String, Integer> irj = new HashMap();
  Context mContext;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final int getCount()
  {
    return this.iqo.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    CardInfo localCardInfo = oV(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, a.e.card_accept_card_list_item, null);
      paramViewGroup = new a.a(this);
      paramViewGroup.iqZ = ((RelativeLayout)paramView.findViewById(a.d.card_container_parent));
      paramViewGroup.irk = ((LinearLayout)paramView.findViewById(a.d.card_top_container));
      paramViewGroup.ira = ((ImageView)paramView.findViewById(a.d.card_img));
      paramViewGroup.irb = ((TextView)paramView.findViewById(a.d.card_brand_name));
      paramViewGroup.irc = ((TextView)paramView.findViewById(a.d.card_name));
      paramViewGroup.ird = ((TextView)paramView.findViewById(a.d.subtitle));
      paramViewGroup.irf = ((TextView)paramView.findViewById(a.d.card_not_support_tip));
      paramViewGroup.irl = ((ImageView)paramView.findViewById(a.d.card_lucky_icon));
      paramViewGroup.irm = ((TextView)paramView.findViewById(a.d.card_count));
      paramViewGroup.irn = ((TextView)paramView.findViewById(a.d.card_status));
      paramView.setTag(paramViewGroup);
      if (!localCardInfo.azk()) {
        break label975;
      }
      paramViewGroup.ira.setVisibility(0);
      paramViewGroup.irc.setVisibility(0);
      paramViewGroup.ird.setVisibility(0);
      paramViewGroup.irf.setVisibility(8);
      paramViewGroup.irb.setVisibility(0);
      paramViewGroup.irb.setText(localCardInfo.azx().imA);
      if (!localCardInfo.azh()) {
        break label733;
      }
      if ((localCardInfo.azx().sIq == null) || (localCardInfo.azx().sIq.size() != 1)) {
        break label618;
      }
      paramViewGroup.irc.setText(((ra)localCardInfo.azx().sIq.get(0)).title);
      label312:
      if (localCardInfo.azx().sIP != 1) {
        break label753;
      }
      paramViewGroup.irl.setVisibility(0);
      label334:
      long l = ((CardInfo)localCardInfo).field_begin_time;
      if ((localCardInfo.getEndTime() <= 0L) || (l <= 0L)) {
        break label765;
      }
      paramViewGroup.ird.setText(this.mContext.getString(a.g.card_validate_to_format_day, new Object[] { l.ce(l) + "  -  " + l.ce(localCardInfo.getEndTime()) }));
      paramViewGroup.ird.setVisibility(0);
      label431:
      paramInt = this.mContext.getResources().getDimensionPixelSize(a.b.card_list_logo_height);
      m.a(paramViewGroup.ira, localCardInfo.azx().ilp, paramInt, a.c.my_card_package_defaultlogo, true);
      if (localCardInfo.azx().sIN != 1) {
        break label844;
      }
      paramViewGroup.ira.setAlpha(255);
      paramViewGroup.irn.setVisibility(8);
      paramViewGroup.irc.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.card_black_color));
      paramViewGroup.irb.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.card_black_color));
      paramViewGroup.ird.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.grey_background_text_color));
    }
    for (;;)
    {
      paramInt = ((Integer)this.irj.get(localCardInfo.azC())).intValue();
      if (paramInt != 1) {
        break label941;
      }
      paramViewGroup.irm.setText("");
      paramViewGroup.irm.setVisibility(8);
      return paramView;
      paramViewGroup = (a.a)paramView.getTag();
      break;
      label618:
      if ((localCardInfo.azx().sIq == null) || (localCardInfo.azx().sIq.size() != 2)) {
        break label312;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((ra)localCardInfo.azx().sIq.get(0)).title);
      localStringBuilder.append("-");
      localStringBuilder.append(((ra)localCardInfo.azx().sIq.get(1)).title);
      paramViewGroup.irc.setText(localStringBuilder.toString());
      break label312;
      label733:
      paramViewGroup.irc.setText(localCardInfo.azx().title);
      break label312;
      label753:
      paramViewGroup.irl.setVisibility(8);
      break label334;
      label765:
      if (localCardInfo.getEndTime() > 0L)
      {
        paramViewGroup.ird.setText(this.mContext.getString(a.g.card_validate_to, new Object[] { l.ce(localCardInfo.getEndTime()) }));
        paramViewGroup.ird.setVisibility(0);
        break label431;
      }
      paramViewGroup.ird.setText("");
      paramViewGroup.ird.setVisibility(8);
      break label431;
      label844:
      paramViewGroup.irn.setText(localCardInfo.azx().sIO);
      paramViewGroup.ira.setAlpha(90);
      paramViewGroup.irn.setVisibility(0);
      paramViewGroup.irc.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.grey_background_text_color));
      paramViewGroup.irb.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.grey_background_text_color));
      paramViewGroup.ird.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.grey_background_text_color));
    }
    label941:
    paramViewGroup.irm.setText("x" + paramInt);
    paramViewGroup.irm.setVisibility(0);
    return paramView;
    label975:
    paramViewGroup.ira.setVisibility(8);
    paramViewGroup.irc.setVisibility(8);
    paramViewGroup.irb.setVisibility(8);
    paramViewGroup.ird.setVisibility(8);
    paramViewGroup.irn.setVisibility(8);
    paramViewGroup.irm.setVisibility(8);
    paramViewGroup.irf.setVisibility(0);
    paramViewGroup.iqZ.setBackgroundColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.card_list_item_not_support_type_bg));
    paramViewGroup.irf.setText(this.mContext.getResources().getString(a.g.card_not_support_card_type));
    return paramView;
  }
  
  public final CardInfo oV(int paramInt)
  {
    return (CardInfo)this.iqo.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a
 * JD-Core Version:    0.7.0.1
 */