package com.tencent.mm.plugin.card.ui;

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
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;

public final class l
  implements com.tencent.mm.plugin.card.base.c
{
  private BaseAdapter iqN;
  private int iqR;
  protected LinkedList<CardTagTextView> iqV = new LinkedList();
  private int ixc;
  int ixd;
  int ixe;
  private Context mContext;
  
  public l(Context paramContext, BaseAdapter paramBaseAdapter)
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
    Object localObject2;
    label266:
    Object localObject4;
    int i;
    if (paramView == null) {
      if (paramb.azB().equals("PRIVATE_TICKET_TITLE"))
      {
        localObject1 = View.inflate(this.mContext, a.e.card_list_group_header, null);
        localObject2 = (TextView)((View)localObject1).findViewById(a.d.card_list_header_text);
        paramView = (View)localObject1;
        if (localObject2 != null)
        {
          ((TextView)localObject2).setText(this.mContext.getString(a.g.card_ticket_list_title));
          paramView = (View)localObject1;
        }
        localObject1 = new l.a(this);
        ((l.a)localObject1).iqZ = ((RelativeLayout)paramView.findViewById(a.d.card_container_parent));
        ((l.a)localObject1).ira = ((ImageView)paramView.findViewById(a.d.card_img));
        ((l.a)localObject1).iwo = paramView.findViewById(a.d.card_type_img_layout);
        ((l.a)localObject1).iwp = ((ImageView)paramView.findViewById(a.d.card_type_img));
        ((l.a)localObject1).irb = ((TextView)paramView.findViewById(a.d.card_brand_name));
        ((l.a)localObject1).irc = ((TextView)paramView.findViewById(a.d.card_name));
        ((l.a)localObject1).irf = ((TextView)paramView.findViewById(a.d.card_not_support_tip));
        ((l.a)localObject1).ixf = ((ImageView)paramView.findViewById(a.d.card_add_img));
        ((l.a)localObject1).ixh = ((ImageView)paramView.findViewById(a.d.card_bg_img));
        ((l.a)localObject1).ixi = ((ImageView)paramView.findViewById(a.d.card_bg_shadow_img));
        ((l.a)localObject1).ixj = ((ImageView)paramView.findViewById(a.d.card_bg_pattern_img));
        ((l.a)localObject1).ixg = ((LinearLayout)paramView.findViewById(a.d.card_right_tag_layout));
        paramView.setTag(localObject1);
        localObject2 = paramView;
        if (((l.a)localObject1).irc != null)
        {
          float f = this.mContext.getResources().getDimension(a.b.BigerTextSize);
          ((l.a)localObject1).irc.setTextSize(0, f);
        }
        if (!(this.iqN.getItem(paramInt) instanceof CardInfo)) {
          break label709;
        }
        localObject4 = (CardInfo)this.iqN.getItem(paramInt);
        if (((CardInfo)localObject4).field_stickyIndex % 10 == 0) {
          break label519;
        }
        if (((CardInfo)localObject4).field_stickyIndex <= 0) {
          break label1660;
        }
        paramView = j.a(this.mContext, ((CardInfo)localObject4).field_stickyIndex, (CardInfo)localObject4);
        i = 1;
      }
    }
    for (;;)
    {
      label364:
      Object localObject3;
      if (i != 0)
      {
        i = 0;
        for (;;)
        {
          if (i < ((l.a)localObject1).ixg.getChildCount())
          {
            localObject3 = (CardTagTextView)((l.a)localObject1).ixg.getChildAt(i);
            this.iqV.add(localObject3);
            i += 1;
            continue;
            if (paramb.azB().equals("PRIVATE_INVOICE_TITLE"))
            {
              localObject1 = View.inflate(this.mContext, a.e.card_list_group_header, null);
              localObject2 = (TextView)((View)localObject1).findViewById(a.d.card_list_header_text);
              paramView = (View)localObject1;
              if (localObject2 == null) {
                break;
              }
              ((TextView)localObject2).setText(this.mContext.getString(a.g.card_invoice_list_title));
              paramView = (View)localObject1;
              break;
            }
            paramView = View.inflate(this.mContext, a.e.card_item, null);
            break;
            localObject1 = (l.a)paramView.getTag();
            localObject2 = paramView;
            break label266;
            label519:
            if (bk.bl(((CardInfo)localObject4).field_label_wording)) {
              break label1660;
            }
            paramView = ((CardInfo)localObject4).field_label_wording;
            i = 1;
            break label364;
          }
        }
        ((l.a)localObject1).ixg.removeAllViews();
        ((l.a)localObject1).ixg.setVisibility(0);
        if (this.iqV.size() == 0)
        {
          localObject3 = new CardTagTextView(this.mContext);
          ((CardTagTextView)localObject3).setPadding(this.iqR, this.ixc, this.iqR, this.ixc);
          ((CardTagTextView)localObject3).setGravity(17);
          ((CardTagTextView)localObject3).setMinWidth(this.mContext.getResources().getDimensionPixelSize(a.b.card_item_tag_width));
          ((CardTagTextView)localObject3).setMinHeight(this.mContext.getResources().getDimensionPixelSize(a.b.card_item_tag_height));
          if (!((CardInfo)localObject4).azf()) {
            break label1118;
          }
          ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cb.a.i(this.mContext, a.a.white));
          ((CardTagTextView)localObject3).setFillColor(com.tencent.mm.cb.a.i(this.mContext, a.a.card_member_card_fill_color));
          label684:
          ((CardTagTextView)localObject3).setText(paramView);
          ((CardTagTextView)localObject3).setTextSize(1, 10.0F);
          ((l.a)localObject1).ixg.addView((View)localObject3);
          label709:
          if (!paramb.azk()) {
            break label1521;
          }
          ((l.a)localObject1).ira.setVisibility(0);
          ((l.a)localObject1).irc.setVisibility(0);
          ((l.a)localObject1).irf.setVisibility(8);
          ((l.a)localObject1).irb.setVisibility(0);
          ((l.a)localObject1).irb.setText(paramb.azx().imA);
          ((l.a)localObject1).irc.setText(paramb.azx().title);
          if (!paramb.azh()) {
            break label1177;
          }
          ((l.a)localObject1).iwo.setVisibility(0);
          ((l.a)localObject1).ira.setVisibility(4);
          paramView = ((l.a)localObject1).iwp;
          if (TextUtils.isEmpty(paramb.azx().sIy)) {
            break label1155;
          }
          i = this.mContext.getResources().getDimensionPixelSize(a.b.card_list_logo_height);
          com.tencent.mm.plugin.card.d.m.a(this.mContext, paramView, paramb.azx().sIy, i, a.c.card_ticket_normal_icon, com.tencent.mm.plugin.card.d.l.yR(paramb.azx().color));
          label886:
          if (!paramb.azf()) {
            break label1425;
          }
          if (!bk.bl(paramb.azy().sHI)) {
            break label1237;
          }
          paramView = com.tencent.mm.plugin.card.d.l.cx(com.tencent.mm.plugin.card.d.l.yR(paramb.azx().color), this.ixd);
          ((l.a)localObject1).iqZ.setBackgroundDrawable(paramView);
          ((l.a)localObject1).ixh.setVisibility(8);
          ((l.a)localObject1).ixi.setVisibility(8);
          ((l.a)localObject1).ixj.setVisibility(0);
          label968:
          ((l.a)localObject1).irb.setTextColor(this.mContext.getResources().getColor(a.a.white));
          ((l.a)localObject1).irc.setTextColor(this.mContext.getResources().getColor(a.a.white));
          label1010:
          i = paramb.azx().ilo;
          if ((paramInt != this.iqN.getCount() - 1) || (((l.a)localObject1).iqZ == null)) {
            break label1624;
          }
          paramView = (LinearLayout.LayoutParams)((l.a)localObject1).iqZ.getLayoutParams();
          if (paramView.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(a.b.LittlePadding))
          {
            paramView.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.b.LittlePadding);
            ((l.a)localObject1).iqZ.setLayoutParams(paramView);
          }
        }
      }
      label1118:
      label1521:
      do
      {
        return localObject2;
        localObject3 = (CardTagTextView)this.iqV.removeFirst();
        break;
        ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cb.a.i(this.mContext, a.a.link_color));
        ((CardTagTextView)localObject3).setFillColor(0);
        break label684;
        ((l.a)localObject1).ixg.setVisibility(8);
        break label709;
        com.tencent.mm.plugin.card.d.m.a(paramView, a.c.card_ticket_normal_icon, com.tencent.mm.plugin.card.d.l.yR(paramb.azx().color));
        break label886;
        ((l.a)localObject1).iwo.setVisibility(8);
        ((l.a)localObject1).ira.setVisibility(0);
        i = this.mContext.getResources().getDimensionPixelSize(a.b.card_list_logo_height);
        com.tencent.mm.plugin.card.d.m.a(((l.a)localObject1).ira, paramb.azx().ilp, i, a.c.my_card_package_defaultlogo, true);
        break label886;
        ((l.a)localObject1).iqZ.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.c.card_item_bg_selector));
        ((l.a)localObject1).ixh.setVisibility(0);
        ((l.a)localObject1).ixi.setVisibility(0);
        paramView = ((l.a)localObject1).ixh;
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
        ((l.a)localObject1).ixj.setVisibility(8);
        break label968;
        ((l.a)localObject1).ixj.setVisibility(8);
        ((l.a)localObject1).ixh.setVisibility(8);
        ((l.a)localObject1).ixi.setVisibility(8);
        ((l.a)localObject1).iqZ.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.c.card_item_bg_selector));
        ((l.a)localObject1).irc.setTextColor(this.mContext.getResources().getColor(a.a.card_black_color));
        ((l.a)localObject1).irb.setTextColor(this.mContext.getResources().getColor(a.a.card_black_color));
        break label1010;
        ((l.a)localObject1).ira.setVisibility(8);
        ((l.a)localObject1).irc.setVisibility(8);
        ((l.a)localObject1).irb.setVisibility(8);
        ((l.a)localObject1).ixg.setVisibility(8);
        ((l.a)localObject1).irf.setVisibility(0);
        paramView = com.tencent.mm.plugin.card.d.l.cx(this.mContext.getResources().getColor(a.a.card_list_item_not_support_type_bg), this.ixd);
        ((l.a)localObject1).iqZ.setBackgroundDrawable(paramView);
        ((l.a)localObject1).irf.setText(this.mContext.getResources().getString(a.g.card_not_support_card_type));
        break label1010;
        paramView = (LinearLayout.LayoutParams)((l.a)localObject1).iqZ.getLayoutParams();
      } while (paramView.bottomMargin == 0);
      label1155:
      label1177:
      label1237:
      label1624:
      paramView.bottomMargin = 0;
      label1425:
      ((l.a)localObject1).iqZ.setLayoutParams(paramView);
      return localObject2;
      label1660:
      i = 0;
      paramView = null;
    }
  }
  
  public final void a(View paramView, int paramInt, View.OnClickListener paramOnClickListener)
  {
    paramView = (l.a)paramView.getTag();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.l
 * JD-Core Version:    0.7.0.1
 */