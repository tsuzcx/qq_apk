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
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

public final class m
  extends BaseAdapter
{
  private Context mContext;
  View.OnClickListener tAq;
  boolean tAr;
  private List<b> tmZ;
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(113612);
    this.tmZ = new ArrayList();
    this.tAr = false;
    this.mContext = paramContext;
    AppMethodBeat.o(113612);
  }
  
  private b HY(int paramInt)
  {
    AppMethodBeat.i(113615);
    b localb = (b)this.tmZ.get(paramInt);
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
    c(paramView, paramb.toi, paramBoolean);
    AppMethodBeat.o(161199);
  }
  
  private static void c(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(161200);
    Rect localRect = n.ea(paramView);
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
    int i = this.tmZ.size();
    AppMethodBeat.o(113614);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool3 = true;
    boolean bool2 = true;
    boolean bool1 = false;
    AppMethodBeat.i(113616);
    b localb = HY(paramInt);
    switch (localb.toh)
    {
    default: 
      if (paramView == null) {
        break;
      }
    }
    for (paramViewGroup = (a)paramView.getTag();; paramViewGroup = null)
    {
      Object localObject1;
      if (paramView != null)
      {
        localObject1 = paramViewGroup;
        if (paramViewGroup != null) {}
      }
      else
      {
        paramView = View.inflate(this.mContext, a.e.thL, null);
        localObject1 = new a((byte)0);
        ((a)localObject1).tzu = ((TextView)paramView.findViewById(a.d.tbu));
        ((a)localObject1).tAw = ((TextView)paramView.findViewById(a.d.tbt));
        ((a)localObject1).tAx = ((TextView)paramView.findViewById(a.d.tbq));
        ((a)localObject1).tAy = ((ImageView)paramView.findViewById(a.d.tbs));
        ((a)localObject1).bvK = paramView.findViewById(a.d.tbp);
        ((a)localObject1).tAz = ((CheckBox)paramView.findViewById(a.d.tbr));
        paramView.setTag(localObject1);
      }
      ((a)localObject1).tzu.setText(localb.title);
      label264:
      int i;
      label279:
      label325:
      label342:
      Object localObject2;
      if (localb.toj)
      {
        ((a)localObject1).tAz.setVisibility(0);
        ((a)localObject1).tAz.setChecked(localb.fXF);
        ((a)localObject1).tAz.setOnClickListener(new m.2(this, localb));
        if (!TextUtils.isEmpty(localb.tnY)) {
          break label676;
        }
        ((a)localObject1).tAw.setVisibility(4);
        if ((localb.SgR & 1L) <= 0L) {
          break label701;
        }
        i = 1;
        if (i == 0) {
          break label707;
        }
        ((a)localObject1).tzu.setGravity(17);
        ((a)localObject1).tzu.setTextColor(this.mContext.getResources().getColor(a.a.link_color));
        ((a)localObject1).tAw.setVisibility(8);
        if (!localb.toi) {
          break label811;
        }
        ((a)localObject1).tAx.setVisibility(0);
        paramViewGroup = ((a)localObject1).tAw;
        localObject2 = this.mContext.getResources();
        if (!localb.tok) {
          break label824;
        }
        i = a.a.desc_text_color;
        label370:
        paramViewGroup.setTextColor(((Resources)localObject2).getColor(i));
        if (Util.isNullOrNil(localb.ufC)) {
          break label832;
        }
        i = 1;
        label395:
        if (i == 0) {
          break label838;
        }
        ((a)localObject1).tAy.setVisibility(0);
        n.a(((a)localObject1).tAy, localb.ufC, a.fromDPToPix(this.mContext, 20), a.c.my_card_package_defaultlogo, false);
        label435:
        if (paramInt + 1 >= getCount()) {
          break label863;
        }
        paramViewGroup = HY(paramInt);
        localObject2 = ((a)localObject1).bvK;
        if (localb.tok) {
          break label851;
        }
        bool1 = true;
        label469:
        a((View)localObject2, paramViewGroup, bool1);
        paramViewGroup = HY(paramInt + 1);
        localObject1 = ((a)localObject1).bvK;
        if (localb.tok) {
          break label857;
        }
        bool1 = bool2;
        label504:
        a((View)localObject1, paramViewGroup, bool1);
      }
      for (;;)
      {
        AppMethodBeat.o(113616);
        return paramView;
        paramView = View.inflate(this.mContext, a.e.thK, null);
        paramViewGroup = (TextView)paramView.findViewById(a.d.tbx);
        localObject1 = (TextView)paramView.findViewById(a.d.tbw);
        localObject2 = (LinearLayout)paramView.findViewById(a.d.tgR);
        if (!TextUtils.isEmpty(localb.tol))
        {
          ((LinearLayout)localObject2).setTag(localb.tol);
          ((LinearLayout)localObject2).setOnClickListener(new m.1(this));
          ((ImageView)paramView.findViewById(a.d.tbv)).setBackgroundColor(l.arR(localb.lmL));
          ((LinearLayout)localObject2).setVisibility(0);
        }
        for (;;)
        {
          paramViewGroup.setText(localb.title);
          ((TextView)localObject1).setText(localb.tnY);
          AppMethodBeat.o(113616);
          return paramView;
          ((LinearLayout)localObject2).setVisibility(8);
        }
        ((a)localObject1).tAz.setVisibility(8);
        break;
        label676:
        ((a)localObject1).tAw.setVisibility(0);
        ((a)localObject1).tAw.setText(localb.tnY);
        break label264;
        label701:
        i = 0;
        break label279;
        label707:
        ((a)localObject1).tzu.setGravity(3);
        paramViewGroup = ((a)localObject1).tzu;
        localObject2 = this.mContext.getResources();
        if (localb.tok) {}
        for (i = a.a.normal_text_color;; i = a.a.UN_BW_0_Alpha_0_9)
        {
          paramViewGroup.setTextColor(((Resources)localObject2).getColor(i));
          if (!localb.tok) {
            break label791;
          }
          paramView.setBackgroundColor(this.mContext.getResources().getColor(a.a.white));
          break;
        }
        label791:
        paramView.setBackgroundColor(this.mContext.getResources().getColor(a.a.White));
        break label325;
        label811:
        ((a)localObject1).tAx.setVisibility(8);
        break label342;
        label824:
        i = a.a.UN_BW_0_Alpha_0_5;
        break label370;
        label832:
        i = 0;
        break label395;
        label838:
        ((a)localObject1).tAy.setVisibility(8);
        break label435;
        label851:
        bool1 = false;
        break label469;
        label857:
        bool1 = false;
        break label504;
        label863:
        if (paramInt + 1 == getCount())
        {
          if (!this.tAr) {
            break label907;
          }
          paramViewGroup = ((a)localObject1).bvK;
          if (!localb.tok) {
            bool1 = true;
          }
          c(paramViewGroup, true, bool1);
        }
      }
      label907:
      paramViewGroup = ((a)localObject1).bvK;
      if (!localb.tok) {}
      for (bool1 = bool3;; bool1 = false)
      {
        c(paramViewGroup, false, bool1);
        break;
      }
    }
  }
  
  public final void setData(List<b> paramList)
  {
    AppMethodBeat.i(113613);
    this.tmZ.clear();
    this.tmZ.addAll(paramList);
    AppMethodBeat.o(113613);
  }
  
  final class a
  {
    View bvK;
    TextView tAw;
    TextView tAx;
    ImageView tAy;
    CheckBox tAz;
    TextView tzu;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.m
 * JD-Core Version:    0.7.0.1
 */