package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.j;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.ui.l.a;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;

public final class aa
  implements com.tencent.mm.plugin.card.base.c
{
  private BaseAdapter iqN;
  private int iqR;
  protected LinkedList<CardTagTextView> iqV = new LinkedList();
  private int ixc;
  int ixd;
  int ixe;
  private Context mContext;
  
  public aa(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    this.mContext = paramContext;
    this.iqN = paramBaseAdapter;
    this.ixc = this.mContext.getResources().getDimensionPixelSize(a.b.SmallestPadding);
    this.iqR = this.mContext.getResources().getDimensionPixelSize(a.b.MiddlePadding);
    this.ixd = this.mContext.getResources().getDimensionPixelOffset(a.b.card_item_bg_corner);
    this.ixe = this.mContext.getResources().getDimensionPixelOffset(a.b.card_item_height);
  }
  
  public final void F(View paramView, int paramInt)
  {
    ((l.a)paramView.getTag()).ixf.setImageResource(paramInt);
  }
  
  public final void G(View paramView, int paramInt)
  {
    ((l.a)paramView.getTag()).ixf.setVisibility(paramInt);
  }
  
  public final View a(int paramInt, View paramView, b paramb)
  {
    Object localObject1;
    label105:
    Object localObject2;
    if (paramView == null) {
      switch (this.iqN.getItemViewType(paramInt))
      {
      default: 
        paramView = View.inflate(this.mContext, a.e.card_item, null);
        localObject1 = new aa.a(this);
        if ((paramb.azB().equals("PRIVATE_TICKET_TITLE")) || (paramb.azB().equals("PRIVATE_INVOICE_TITLE")))
        {
          ((aa.a)localObject1).iyL = ((TextView)paramView.findViewById(a.d.card_list_header_text));
          paramView.setTag(localObject1);
          localObject2 = paramView;
          label114:
          if (((aa.a)localObject1).irc != null)
          {
            float f = this.mContext.getResources().getDimension(a.b.BigerTextSize);
            ((aa.a)localObject1).irc.setTextSize(0, f);
          }
          if (!paramb.azk()) {
            break label2043;
          }
          if (!paramb.azB().equals("PRIVATE_TICKET_TITLE")) {
            break label808;
          }
          ((aa.a)localObject1).iyL.setText(this.mContext.getString(a.g.card_ticket_list_title));
        }
        break;
      }
    }
    int i;
    label316:
    Object localObject3;
    label808:
    Object localObject4;
    for (;;)
    {
      if ((!paramb.azB().equals("PRIVATE_TICKET_TITLE")) && (!paramb.azB().equals("PRIVATE_INVOICE_TITLE")) && (!paramb.azj()))
      {
        i = paramb.azx().ilo;
        if ((paramInt != this.iqN.getCount() - 1) || (((aa.a)localObject1).iqZ == null)) {
          break label2183;
        }
        paramView = (LinearLayout.LayoutParams)((aa.a)localObject1).iqZ.getLayoutParams();
        if (paramView.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(a.b.LittlePadding))
        {
          paramView.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.b.LittlePadding);
          ((aa.a)localObject1).iqZ.setLayoutParams(paramView);
        }
      }
      return localObject2;
      localObject1 = View.inflate(this.mContext, a.e.card_list_group_header, null);
      if (paramb.azB().equals("PRIVATE_TICKET_TITLE"))
      {
        localObject2 = (TextView)((View)localObject1).findViewById(a.d.card_list_header_text);
        paramView = (View)localObject1;
        if (localObject2 == null) {
          break;
        }
        ((TextView)localObject2).setText(this.mContext.getString(a.g.card_ticket_list_title));
        paramView = (View)localObject1;
        break;
      }
      paramView = (View)localObject1;
      if (!paramb.azB().equals("PRIVATE_INVOICE_TITLE")) {
        break;
      }
      localObject2 = (TextView)((View)localObject1).findViewById(a.d.card_list_header_text);
      paramView = (View)localObject1;
      if (localObject2 == null) {
        break;
      }
      ((TextView)localObject2).setText(this.mContext.getString(a.g.card_invoice_list_title));
      paramView = (View)localObject1;
      break;
      paramView = View.inflate(this.mContext, a.e.card_item, null);
      break;
      paramView = View.inflate(this.mContext, a.e.card_list_invoice_item, null);
      break;
      if (paramb.azj())
      {
        ((aa.a)localObject1).iyM = ((TextView)paramView.findViewById(a.d.card_list_invoice_title));
        ((aa.a)localObject1).iyN = ((TextView)paramView.findViewById(a.d.card_list_invoice_date));
        ((aa.a)localObject1).iyO = ((TextView)paramView.findViewById(a.d.card_list_invoice_name));
        ((aa.a)localObject1).iyP = ((TextView)paramView.findViewById(a.d.card_list_invoice_sum));
        break label105;
      }
      ((aa.a)localObject1).iqZ = ((RelativeLayout)paramView.findViewById(a.d.card_container_parent));
      ((aa.a)localObject1).ira = ((ImageView)paramView.findViewById(a.d.card_img));
      ((aa.a)localObject1).iwo = paramView.findViewById(a.d.card_type_img_layout);
      ((aa.a)localObject1).iwp = ((ImageView)paramView.findViewById(a.d.card_type_img));
      ((aa.a)localObject1).irb = ((TextView)paramView.findViewById(a.d.card_brand_name));
      ((aa.a)localObject1).irc = ((TextView)paramView.findViewById(a.d.card_name));
      ((aa.a)localObject1).irf = ((TextView)paramView.findViewById(a.d.card_not_support_tip));
      ((aa.a)localObject1).ixf = ((ImageView)paramView.findViewById(a.d.card_add_img));
      ((aa.a)localObject1).ixh = ((ImageView)paramView.findViewById(a.d.card_bg_img));
      ((aa.a)localObject1).ixi = ((ImageView)paramView.findViewById(a.d.card_bg_shadow_img));
      ((aa.a)localObject1).ixj = ((ImageView)paramView.findViewById(a.d.card_bg_pattern_img));
      ((aa.a)localObject1).ixg = ((LinearLayout)paramView.findViewById(a.d.card_right_tag_layout));
      break label105;
      localObject1 = (aa.a)paramView.getTag();
      if (((aa.a)localObject1).iyL != null)
      {
        if (paramb.azB().equals("PRIVATE_TICKET_TITLE"))
        {
          ((aa.a)localObject1).iyL.setText(this.mContext.getString(a.g.card_ticket_list_title));
          localObject2 = paramView;
          break label114;
        }
        ((aa.a)localObject1).iyL.setText(this.mContext.getString(a.g.card_invoice_list_title));
      }
      localObject2 = paramView;
      break label114;
      if (paramb.azB().equals("PRIVATE_INVOICE_TITLE"))
      {
        ((aa.a)localObject1).iyL.setText(this.mContext.getString(a.g.card_invoice_list_title));
      }
      else if (paramb.azj())
      {
        paramView = paramb.azx().sIq;
        ((aa.a)localObject1).iyM.setText(((ra)paramView.get(0)).ilq);
        ((aa.a)localObject1).iyO.setText(((ra)paramView.get(1)).ilq);
        paramView = paramb.azy().sHy;
        localObject3 = String.format(this.mContext.getString(a.g.card_list_invoice_sum), new Object[] { ((ra)paramView.get(0)).ilq });
        ((aa.a)localObject1).iyP.setText((CharSequence)localObject3);
        if (paramView.size() >= 2) {
          ((aa.a)localObject1).iyN.setText(((ra)paramView.get(1)).ilq);
        }
      }
      else
      {
        if ((this.iqN.getItem(paramInt) instanceof CardInfo))
        {
          localObject4 = (CardInfo)this.iqN.getItem(paramInt);
          if ((!((CardInfo)localObject4).field_card_id.equals("PRIVATE_TICKET_TITLE")) && (!((CardInfo)localObject4).field_card_id.equals("PRIVATE_INVOICE_TITLE"))) {
            break label1340;
          }
        }
        label1036:
        ((aa.a)localObject1).iqZ.setVisibility(0);
        ((aa.a)localObject1).ira.setVisibility(0);
        ((aa.a)localObject1).irc.setVisibility(0);
        ((aa.a)localObject1).irf.setVisibility(8);
        ((aa.a)localObject1).irb.setVisibility(0);
        ((aa.a)localObject1).irb.setText(paramb.azx().imA);
        ((aa.a)localObject1).irc.setText(paramb.azx().title);
        if (!paramb.azh()) {
          break label1699;
        }
        ((aa.a)localObject1).iwo.setVisibility(0);
        ((aa.a)localObject1).ira.setVisibility(4);
        paramView = ((aa.a)localObject1).iwp;
        if (TextUtils.isEmpty(paramb.azx().sIy)) {
          break label1677;
        }
        i = this.mContext.getResources().getDimensionPixelSize(a.b.card_list_logo_height);
        com.tencent.mm.plugin.card.d.m.a(this.mContext, paramView, paramb.azx().sIy, i, a.c.card_ticket_normal_icon, l.yR(paramb.azx().color));
        label1213:
        if (!paramb.azf()) {
          break label1947;
        }
        if (!bk.bl(paramb.azy().sHI)) {
          break label1759;
        }
        paramView = l.cx(l.yR(paramb.azx().color), this.ixd);
        ((aa.a)localObject1).iqZ.setBackgroundDrawable(paramView);
        ((aa.a)localObject1).ixh.setVisibility(8);
        ((aa.a)localObject1).ixi.setVisibility(8);
        ((aa.a)localObject1).ixj.setVisibility(0);
        label1295:
        ((aa.a)localObject1).irb.setTextColor(this.mContext.getResources().getColor(a.a.white));
        ((aa.a)localObject1).irc.setTextColor(this.mContext.getResources().getColor(a.a.white));
      }
    }
    label1340:
    if (((CardInfo)localObject4).field_stickyIndex % 10 != 0)
    {
      if (((CardInfo)localObject4).field_stickyIndex <= 0) {
        break label2219;
      }
      paramView = j.a(this.mContext, ((CardInfo)localObject4).field_stickyIndex, (CardInfo)localObject4);
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        i = 0;
        for (;;)
        {
          if (i < ((aa.a)localObject1).ixg.getChildCount())
          {
            localObject3 = (CardTagTextView)((aa.a)localObject1).ixg.getChildAt(i);
            this.iqV.add(localObject3);
            i += 1;
            continue;
            if (bk.bl(((CardInfo)localObject4).field_label_wording)) {
              break label2219;
            }
            paramView = ((CardInfo)localObject4).field_label_wording;
            i = 1;
            break;
          }
        }
        ((aa.a)localObject1).ixg.removeAllViews();
        ((aa.a)localObject1).ixg.setVisibility(0);
        if (this.iqV.size() == 0)
        {
          localObject3 = new CardTagTextView(this.mContext);
          label1495:
          ((CardTagTextView)localObject3).setPadding(this.iqR, this.ixc, this.iqR, this.ixc);
          ((CardTagTextView)localObject3).setGravity(17);
          ((CardTagTextView)localObject3).setMinWidth(this.mContext.getResources().getDimensionPixelSize(a.b.card_item_tag_width));
          ((CardTagTextView)localObject3).setMinHeight(this.mContext.getResources().getDimensionPixelSize(a.b.card_item_tag_height));
          if (!((CardInfo)localObject4).azf()) {
            break label1640;
          }
          ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cb.a.i(this.mContext, a.a.white));
          ((CardTagTextView)localObject3).setFillColor(com.tencent.mm.cb.a.i(this.mContext, a.a.card_member_card_fill_color));
        }
        for (;;)
        {
          ((CardTagTextView)localObject3).setText(paramView);
          ((CardTagTextView)localObject3).setTextSize(1, 10.0F);
          ((aa.a)localObject1).ixg.addView((View)localObject3);
          break;
          localObject3 = (CardTagTextView)this.iqV.removeFirst();
          break label1495;
          label1640:
          ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cb.a.i(this.mContext, a.a.link_color));
          ((CardTagTextView)localObject3).setFillColor(0);
        }
      }
      ((aa.a)localObject1).ixg.setVisibility(8);
      break label1036;
      label1677:
      com.tencent.mm.plugin.card.d.m.a(paramView, a.c.card_ticket_normal_icon, l.yR(paramb.azx().color));
      break label1213;
      label1699:
      ((aa.a)localObject1).iwo.setVisibility(8);
      ((aa.a)localObject1).ira.setVisibility(0);
      i = this.mContext.getResources().getDimensionPixelSize(a.b.card_list_logo_height);
      com.tencent.mm.plugin.card.d.m.a(((aa.a)localObject1).ira, paramb.azx().ilp, i, a.c.my_card_package_defaultlogo, true);
      break label1213;
      label1759:
      ((aa.a)localObject1).iqZ.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.c.card_item_bg_selector));
      ((aa.a)localObject1).ixh.setVisibility(0);
      ((aa.a)localObject1).ixi.setVisibility(0);
      paramView = ((aa.a)localObject1).ixh;
      localObject3 = paramb.azy().sHI;
      localObject4 = new c.a();
      ((c.a)localObject4).eri = e.bkH;
      o.OO();
      ((c.a)localObject4).erB = null;
      ((c.a)localObject4).erh = com.tencent.mm.plugin.card.model.m.yn((String)localObject3);
      ((c.a)localObject4).erf = true;
      ((c.a)localObject4).erF = true;
      ((c.a)localObject4).erd = true;
      ((c.a)localObject4).eru = a.c.card_item_bg_selector;
      ((c.a)localObject4).erm = com.tencent.mm.cb.a.aa(this.mContext, a.b.card_item_height);
      ((c.a)localObject4).erl = com.tencent.mm.cb.a.fj(this.mContext);
      localObject4 = ((c.a)localObject4).OV();
      o.ON().a((String)localObject3, paramView, (com.tencent.mm.as.a.a.c)localObject4);
      paramView.setImageMatrix(new Matrix());
      ((aa.a)localObject1).ixj.setVisibility(8);
      break label1295;
      label1947:
      ((aa.a)localObject1).ixj.setVisibility(8);
      ((aa.a)localObject1).ixh.setVisibility(8);
      ((aa.a)localObject1).ixi.setVisibility(8);
      ((aa.a)localObject1).iqZ.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.c.card_item_bg_selector));
      ((aa.a)localObject1).irc.setTextColor(this.mContext.getResources().getColor(a.a.card_black_color));
      ((aa.a)localObject1).irb.setTextColor(this.mContext.getResources().getColor(a.a.card_black_color));
      break;
      label2043:
      if ((paramb.azB().equals("PRIVATE_TICKET_TITLE")) || (paramb.azB().equals("PRIVATE_INVOICE_TITLE")) || (paramb.azj())) {
        break;
      }
      ((aa.a)localObject1).ira.setVisibility(8);
      ((aa.a)localObject1).irc.setVisibility(8);
      ((aa.a)localObject1).irb.setVisibility(8);
      ((aa.a)localObject1).ixg.setVisibility(8);
      ((aa.a)localObject1).irf.setVisibility(0);
      paramView = l.cx(this.mContext.getResources().getColor(a.a.card_list_item_not_support_type_bg), this.ixd);
      ((aa.a)localObject1).iqZ.setBackgroundDrawable(paramView);
      ((aa.a)localObject1).irf.setText(this.mContext.getResources().getString(a.g.card_not_support_card_type));
      break;
      label2183:
      paramView = (LinearLayout.LayoutParams)((aa.a)localObject1).iqZ.getLayoutParams();
      if (paramView.bottomMargin == 0) {
        break label316;
      }
      paramView.bottomMargin = 0;
      ((aa.a)localObject1).iqZ.setLayoutParams(paramView);
      return localObject2;
      label2219:
      i = 0;
      paramView = null;
    }
  }
  
  public final void a(View paramView, int paramInt, View.OnClickListener paramOnClickListener)
  {
    CardInfo localCardInfo = (CardInfo)this.iqN.getItem(paramInt);
    if ((localCardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE")) || (localCardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE"))) {
      return;
    }
    paramView = (aa.a)paramView.getTag();
    paramView.ixf.setTag(Integer.valueOf(paramInt));
    paramView.ixf.setOnClickListener(paramOnClickListener);
  }
  
  public final void release()
  {
    this.mContext = null;
    this.iqN = null;
    if (this.iqV != null) {
      this.iqV.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.aa
 * JD-Core Version:    0.7.0.1
 */