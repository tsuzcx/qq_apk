package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.b;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.List;

public final class m
  extends BaseAdapter
{
  List<b> iko = new ArrayList();
  View.OnClickListener ixn;
  boolean ixo = false;
  private Context mContext;
  
  public m(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private static void a(View paramView, b paramb)
  {
    if (paramb == null) {
      return;
    }
    j(paramView, paramb.ilA);
  }
  
  private static void j(View paramView, boolean paramBoolean)
  {
    Rect localRect = new Rect();
    localRect.left = paramView.getPaddingLeft();
    localRect.right = paramView.getPaddingRight();
    localRect.top = paramView.getPaddingTop();
    localRect.bottom = paramView.getPaddingBottom();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if (paramBoolean) {
      paramView.setBackgroundResource(a.c.mm_trans);
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      paramView.setPadding(localRect.left, localRect.top, localRect.right, localRect.bottom);
      return;
      paramView.setBackgroundResource(a.c.list_item_normal);
    }
  }
  
  private b pd(int paramInt)
  {
    return (b)this.iko.get(paramInt);
  }
  
  public final int getCount()
  {
    return this.iko.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    final b localb = pd(paramInt);
    switch (localb.ilz)
    {
    default: 
      if (paramView == null) {
        break;
      }
    }
    for (paramViewGroup = (m.a)paramView.getTag();; paramViewGroup = null)
    {
      Object localObject;
      if (paramView != null)
      {
        localObject = paramViewGroup;
        if (paramViewGroup != null) {}
      }
      else
      {
        paramView = View.inflate(this.mContext, a.e.card_cell_list_item, null);
        localObject = new m.a(this, (byte)0);
        ((m.a)localObject).iwq = ((TextView)paramView.findViewById(a.d.card_cell_item_title_tv));
        ((m.a)localObject).ixt = ((TextView)paramView.findViewById(a.d.card_cell_item_subtitle_tv));
        ((m.a)localObject).ixu = ((TextView)paramView.findViewById(a.d.card_cell_item_divider_tv));
        ((m.a)localObject).ixv = ((ImageView)paramView.findViewById(a.d.card_cell_item_icon_iv));
        ((m.a)localObject).hNa = paramView.findViewById(a.d.card_cell_item_content_layout);
        ((m.a)localObject).ixw = ((CheckBox)paramView.findViewById(a.d.card_cell_item_follow_cbx));
        paramView.setTag(localObject);
      }
      ((m.a)localObject).iwq.setText(localb.title);
      label252:
      int i;
      if (localb.ilB)
      {
        ((m.a)localObject).ixw.setVisibility(0);
        ((m.a)localObject).ixw.setChecked(localb.ilC);
        ((m.a)localObject).ixw.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            if (((CheckBox)paramAnonymousView).isChecked())
            {
              localb.ilC = true;
              return;
            }
            localb.ilC = false;
          }
        });
        if (!TextUtils.isEmpty(localb.ilq)) {
          break label601;
        }
        ((m.a)localObject).ixt.setVisibility(4);
        if ((localb.sJq & 1L) <= 0L) {
          break label626;
        }
        i = 1;
        label267:
        if (i == 0) {
          break label632;
        }
        ((m.a)localObject).iwq.setGravity(17);
        ((m.a)localObject).iwq.setTextColor(this.mContext.getResources().getColor(a.a.link_color));
        ((m.a)localObject).ixt.setVisibility(8);
        label313:
        if (!localb.ilA) {
          break label665;
        }
        ((m.a)localObject).ixu.setVisibility(0);
        label330:
        ((m.a)localObject).ixt.setTextColor(this.mContext.getResources().getColor(a.a.item_subtitle_color));
        if (bk.bl(localb.iQn)) {
          break label678;
        }
        i = 1;
        label365:
        if (i == 0) {
          break label684;
        }
        ((m.a)localObject).ixv.setVisibility(0);
        com.tencent.mm.plugin.card.d.m.a(((m.a)localObject).ixv, localb.iQn, a.fromDPToPix(this.mContext, 20), a.c.my_card_package_defaultlogo, false);
        label405:
        if (paramInt + 1 >= getCount()) {
          break label697;
        }
        paramViewGroup = pd(paramInt);
        a(((m.a)localObject).hNa, paramViewGroup);
        paramViewGroup = pd(paramInt + 1);
        a(((m.a)localObject).hNa, paramViewGroup);
      }
      label601:
      label626:
      label632:
      while (paramInt + 1 != getCount())
      {
        return paramView;
        paramView = View.inflate(this.mContext, a.e.card_cell_first_shop_item, null);
        paramViewGroup = (TextView)paramView.findViewById(a.d.card_cell_shop_item_title_tv);
        localObject = (TextView)paramView.findViewById(a.d.card_cell_shop_item_subtitle_tv);
        LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(a.d.shop_phone_layout);
        if (!TextUtils.isEmpty(localb.ilD))
        {
          localLinearLayout.setTag(localb.ilD);
          localLinearLayout.setOnClickListener(new m.1(this));
          ((ImageView)paramView.findViewById(a.d.card_cell_shop_item_phone_iv)).setBackgroundColor(l.yR(localb.color));
          localLinearLayout.setVisibility(0);
        }
        for (;;)
        {
          paramViewGroup.setText(localb.title);
          ((TextView)localObject).setText(localb.ilq);
          return paramView;
          localLinearLayout.setVisibility(8);
        }
        ((m.a)localObject).ixw.setVisibility(8);
        break;
        ((m.a)localObject).ixt.setVisibility(0);
        ((m.a)localObject).ixt.setText(localb.ilq);
        break label252;
        i = 0;
        break label267;
        ((m.a)localObject).iwq.setGravity(3);
        ((m.a)localObject).iwq.setTextColor(this.mContext.getResources().getColor(a.a.item_title_color));
        break label313;
        ((m.a)localObject).ixu.setVisibility(8);
        break label330;
        i = 0;
        break label365;
        ((m.a)localObject).ixv.setVisibility(8);
        break label405;
      }
      label665:
      label678:
      label684:
      label697:
      if (this.ixo)
      {
        j(((m.a)localObject).hNa, true);
        return paramView;
      }
      j(((m.a)localObject).hNa, false);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.m
 * JD-Core Version:    0.7.0.1
 */