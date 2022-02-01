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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.c.n;
import com.tencent.mm.plugin.card.model.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.List;

public final class m
  extends BaseAdapter
{
  private Context mContext;
  View.OnClickListener wEM;
  boolean wEN;
  public boolean wEO;
  private List<b> wrz;
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(113612);
    this.wrz = new ArrayList();
    this.wEN = false;
    this.wEO = false;
    this.mContext = paramContext;
    AppMethodBeat.o(113612);
  }
  
  private b Iz(int paramInt)
  {
    AppMethodBeat.i(113615);
    b localb = (b)this.wrz.get(paramInt);
    AppMethodBeat.o(113615);
    return localb;
  }
  
  private static void a(View paramView, b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(161199);
    if (paramb == null)
    {
      AppMethodBeat.o(161199);
      return;
    }
    c(paramView, paramb.wsJ, paramBoolean);
    AppMethodBeat.o(161199);
  }
  
  private static void c(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(161200);
    Rect localRect = n.eO(paramView);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    int i;
    if (paramBoolean1) {
      i = a.c.mm_trans;
    }
    for (;;)
    {
      paramView.setBackgroundResource(i);
      paramView.setLayoutParams(localLayoutParams);
      n.f(paramView, localRect);
      AppMethodBeat.o(161200);
      return;
      if (paramBoolean2) {
        i = a.c.list_item_normal_un;
      } else {
        i = a.c.list_item_normal;
      }
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113614);
    int i = this.wrz.size();
    AppMethodBeat.o(113614);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(113616);
    b localb = Iz(paramInt);
    switch (localb.wsI)
    {
    default: 
      paramViewGroup = null;
      if (paramView != null) {
        paramViewGroup = (a)paramView.getTag();
      }
      if ((paramView == null) || (paramViewGroup == null))
      {
        paramView = View.inflate(this.mContext, a.e.wmk, null);
        paramViewGroup = new a((byte)0);
        paramViewGroup.wDQ = ((TextView)paramView.findViewById(a.d.wfG));
        paramViewGroup.wET = ((TextView)paramView.findViewById(a.d.wfF));
        paramViewGroup.wEU = ((TextView)paramView.findViewById(a.d.wfB));
        paramViewGroup.wEV = ((ImageView)paramView.findViewById(a.d.wfD));
        paramViewGroup.doN = paramView.findViewById(a.d.wfA);
        paramViewGroup.wEW = ((CheckBox)paramView.findViewById(a.d.wfC));
        paramViewGroup.wEX = ((WeImageView)paramView.findViewById(a.d.wfz));
        paramViewGroup.une = paramView.findViewById(a.d.wfH);
        if (this.wEO)
        {
          paramView.findViewById(a.d.wgO).setBackgroundResource(a.c.wer);
          paramViewGroup.wEX.setIconColor(this.mContext.getResources().getColor(a.a.UN_BW_0_Alpha_0_3));
        }
        paramView.setTag(paramViewGroup);
      }
      break;
    }
    for (;;)
    {
      label316:
      label335:
      int i;
      label350:
      Object localObject1;
      label393:
      label409:
      Object localObject2;
      if ((paramInt == 0) && (((MMFragmentActivity)this.mContext).findViewById(a.d.wge) == null))
      {
        paramViewGroup.une.setVisibility(0);
        paramViewGroup.wDQ.setText(localb.title);
        if (!localb.wsK) {
          break label754;
        }
        paramViewGroup.wEW.setVisibility(0);
        paramViewGroup.wEW.setChecked(localb.idG);
        paramViewGroup.wEW.setOnClickListener(new m.2(this, localb));
        if (!TextUtils.isEmpty(localb.wsz)) {
          break label766;
        }
        paramViewGroup.wET.setVisibility(4);
        if ((localb.ZeU & 1L) <= 0L) {
          break label789;
        }
        i = 1;
        if (i == 0) {
          break label795;
        }
        paramViewGroup.wDQ.setGravity(17);
        paramViewGroup.wDQ.setTextColor(this.mContext.getResources().getColor(a.a.link_color));
        paramViewGroup.wET.setVisibility(8);
        if (!localb.wsJ) {
          break label919;
        }
        paramViewGroup.wEU.setVisibility(0);
        localObject1 = paramViewGroup.wET;
        localObject2 = this.mContext.getResources();
        if (!localb.wsL) {
          break label931;
        }
        i = a.a.desc_text_color;
        label437:
        ((TextView)localObject1).setTextColor(((Resources)localObject2).getColor(i));
        if (Util.isNullOrNil(localb.icon_url)) {
          break label939;
        }
        i = 1;
        label463:
        if (i == 0) {
          break label945;
        }
        paramViewGroup.wEV.setVisibility(0);
        n.a(paramViewGroup.wEV, localb.icon_url, a.fromDPToPix(this.mContext, 20), a.c.my_card_package_defaultlogo, false);
        label501:
        if (paramInt + 1 >= getCount()) {
          break label969;
        }
        localObject1 = Iz(paramInt);
        localObject2 = paramViewGroup.doN;
        if (localb.wsL) {
          break label957;
        }
        bool = true;
        a((View)localObject2, (b)localObject1, bool);
        localObject1 = Iz(paramInt + 1);
        paramViewGroup = paramViewGroup.doN;
        if (localb.wsL) {
          break label963;
        }
        bool = true;
        a(paramViewGroup, (b)localObject1, bool);
      }
      label754:
      label766:
      while (paramInt + 1 != getCount()) {
        for (;;)
        {
          AppMethodBeat.o(113616);
          return paramView;
          paramView = View.inflate(this.mContext, a.e.wmj, null);
          paramViewGroup = (TextView)paramView.findViewById(a.d.wfK);
          localObject1 = (TextView)paramView.findViewById(a.d.wfJ);
          localObject2 = (LinearLayout)paramView.findViewById(a.d.wlr);
          if (this.wEO) {
            paramView.setBackgroundResource(a.c.wer);
          }
          if (!TextUtils.isEmpty(localb.wsM))
          {
            ((LinearLayout)localObject2).setTag(localb.wsM);
            ((LinearLayout)localObject2).setOnClickListener(new m.1(this));
            ((ImageView)paramView.findViewById(a.d.wfI)).setBackgroundColor(l.alv(localb.nRQ));
            ((LinearLayout)localObject2).setVisibility(0);
          }
          for (;;)
          {
            paramViewGroup.setText(localb.title);
            ((TextView)localObject1).setText(localb.wsz);
            AppMethodBeat.o(113616);
            return paramView;
            ((LinearLayout)localObject2).setVisibility(8);
          }
          paramViewGroup.une.setVisibility(8);
          break;
          paramViewGroup.wEW.setVisibility(8);
          break label316;
          paramViewGroup.wET.setVisibility(0);
          paramViewGroup.wET.setText(localb.wsz);
          break label335;
          i = 0;
          break label350;
          paramViewGroup.wDQ.setGravity(3);
          localObject1 = paramViewGroup.wDQ;
          localObject2 = this.mContext.getResources();
          if (localb.wsL) {}
          for (i = a.a.normal_text_color;; i = a.a.UN_BW_0_Alpha_0_9)
          {
            ((TextView)localObject1).setTextColor(((Resources)localObject2).getColor(i));
            if (!localb.wsL) {
              break label879;
            }
            paramView.setBackgroundColor(this.mContext.getResources().getColor(a.a.white));
            break;
          }
          paramView.setBackgroundColor(this.mContext.getResources().getColor(a.a.UN_BW_97));
          paramViewGroup.wEX.setIconColor(this.mContext.getResources().getColor(a.a.UN_BW_0_Alpha_0_5));
          break label393;
          paramViewGroup.wEU.setVisibility(8);
          break label409;
          i = a.a.UN_BW_0_Alpha_0_5;
          break label437;
          i = 0;
          break label463;
          paramViewGroup.wEV.setVisibility(8);
          break label501;
          bool = false;
          continue;
          bool = false;
        }
      }
      label789:
      label795:
      label879:
      if (this.wEN)
      {
        paramViewGroup = paramViewGroup.doN;
        if (!localb.wsL) {}
        for (bool = true;; bool = false)
        {
          c(paramViewGroup, true, bool);
          break;
        }
      }
      label919:
      label931:
      label939:
      label945:
      label957:
      label963:
      label969:
      paramViewGroup = paramViewGroup.doN;
      if (!localb.wsL) {}
      for (boolean bool = true;; bool = false)
      {
        c(paramViewGroup, false, bool);
        break;
      }
    }
  }
  
  public final void setData(List<b> paramList)
  {
    AppMethodBeat.i(113613);
    this.wrz.clear();
    this.wrz.addAll(paramList);
    AppMethodBeat.o(113613);
  }
  
  final class a
  {
    View doN;
    View une;
    TextView wDQ;
    TextView wET;
    TextView wEU;
    ImageView wEV;
    CheckBox wEW;
    WeImageView wEX;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.m
 * JD-Core Version:    0.7.0.1
 */