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
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.b;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;

public final class m
  extends BaseAdapter
{
  private Context mContext;
  View.OnClickListener nDJ;
  boolean nDK;
  private List<b> nqu;
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(113612);
    this.nqu = new ArrayList();
    this.nDK = false;
    this.mContext = paramContext;
    AppMethodBeat.o(113612);
  }
  
  private static void a(View paramView, b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(161199);
    if (paramb == null)
    {
      AppMethodBeat.o(161199);
      return;
    }
    c(paramView, paramb.nrD, paramBoolean);
    AppMethodBeat.o(161199);
  }
  
  private static void c(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(161200);
    Rect localRect = n.dF(paramView);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    int i;
    if (paramBoolean1) {
      i = 2131233299;
    }
    for (;;)
    {
      paramView.setBackgroundResource(i);
      paramView.setLayoutParams(localLayoutParams);
      n.j(paramView, localRect);
      AppMethodBeat.o(161200);
      return;
      if (paramBoolean2) {
        i = 2131232869;
      } else {
        i = 2131232867;
      }
    }
  }
  
  private b zg(int paramInt)
  {
    AppMethodBeat.i(113615);
    b localb = (b)this.nqu.get(paramInt);
    AppMethodBeat.o(113615);
    return localb;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113614);
    int i = this.nqu.size();
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
    final b localb = zg(paramInt);
    switch (localb.nrC)
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
        paramView = View.inflate(this.mContext, 2131493255, null);
        localObject1 = new a((byte)0);
        ((a)localObject1).nCN = ((TextView)paramView.findViewById(2131297753));
        ((a)localObject1).nDP = ((TextView)paramView.findViewById(2131297752));
        ((a)localObject1).nDQ = ((TextView)paramView.findViewById(2131297749));
        ((a)localObject1).nDR = ((ImageView)paramView.findViewById(2131297751));
        ((a)localObject1).pf = paramView.findViewById(2131297747);
        ((a)localObject1).nDS = ((CheckBox)paramView.findViewById(2131297750));
        paramView.setTag(localObject1);
      }
      ((a)localObject1).nCN.setText(localb.title);
      label257:
      int i;
      label272:
      label317:
      label334:
      Object localObject2;
      if (localb.nrE)
      {
        ((a)localObject1).nDS.setVisibility(0);
        ((a)localObject1).nDS.setChecked(localb.dAt);
        ((a)localObject1).nDS.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(113611);
            if (((CheckBox)paramAnonymousView).isChecked())
            {
              localb.dAt = true;
              AppMethodBeat.o(113611);
              return;
            }
            localb.dAt = false;
            AppMethodBeat.o(113611);
          }
        });
        if (!TextUtils.isEmpty(localb.nrs)) {
          break label666;
        }
        ((a)localObject1).nDP.setVisibility(4);
        if ((localb.CSH & 1L) <= 0L) {
          break label691;
        }
        i = 1;
        if (i == 0) {
          break label697;
        }
        ((a)localObject1).nCN.setGravity(17);
        ((a)localObject1).nCN.setTextColor(this.mContext.getResources().getColor(2131100547));
        ((a)localObject1).nDP.setVisibility(8);
        if (!localb.nrD) {
          break label801;
        }
        ((a)localObject1).nDQ.setVisibility(0);
        paramViewGroup = ((a)localObject1).nDP;
        localObject2 = this.mContext.getResources();
        if (!localb.nrF) {
          break label814;
        }
        i = 2131100212;
        label361:
        paramViewGroup.setTextColor(((Resources)localObject2).getColor(i));
        if (bt.isNullOrNil(localb.odo)) {
          break label822;
        }
        i = 1;
        label386:
        if (i == 0) {
          break label828;
        }
        ((a)localObject1).nDR.setVisibility(0);
        n.a(((a)localObject1).nDR, localb.odo, a.fromDPToPix(this.mContext, 20), 2131233400, false);
        label425:
        if (paramInt + 1 >= getCount()) {
          break label853;
        }
        paramViewGroup = zg(paramInt);
        localObject2 = ((a)localObject1).pf;
        if (localb.nrF) {
          break label841;
        }
        bool1 = true;
        label459:
        a((View)localObject2, paramViewGroup, bool1);
        paramViewGroup = zg(paramInt + 1);
        localObject1 = ((a)localObject1).pf;
        if (localb.nrF) {
          break label847;
        }
        bool1 = bool2;
        label494:
        a((View)localObject1, paramViewGroup, bool1);
      }
      for (;;)
      {
        AppMethodBeat.o(113616);
        return paramView;
        paramView = View.inflate(this.mContext, 2131493254, null);
        paramViewGroup = (TextView)paramView.findViewById(2131297756);
        localObject1 = (TextView)paramView.findViewById(2131297755);
        localObject2 = (LinearLayout)paramView.findViewById(2131304768);
        if (!TextUtils.isEmpty(localb.nrG))
        {
          ((LinearLayout)localObject2).setTag(localb.nrG);
          ((LinearLayout)localObject2).setOnClickListener(new m.1(this));
          ((ImageView)paramView.findViewById(2131297754)).setBackgroundColor(l.Rm(localb.gHT));
          ((LinearLayout)localObject2).setVisibility(0);
        }
        for (;;)
        {
          paramViewGroup.setText(localb.title);
          ((TextView)localObject1).setText(localb.nrs);
          AppMethodBeat.o(113616);
          return paramView;
          ((LinearLayout)localObject2).setVisibility(8);
        }
        ((a)localObject1).nDS.setVisibility(8);
        break;
        label666:
        ((a)localObject1).nDP.setVisibility(0);
        ((a)localObject1).nDP.setText(localb.nrs);
        break label257;
        label691:
        i = 0;
        break label272;
        label697:
        ((a)localObject1).nCN.setGravity(3);
        paramViewGroup = ((a)localObject1).nCN;
        localObject2 = this.mContext.getResources();
        if (localb.nrF) {}
        for (i = 2131100711;; i = 2131099820)
        {
          paramViewGroup.setTextColor(((Resources)localObject2).getColor(i));
          if (!localb.nrF) {
            break label781;
          }
          paramView.setBackgroundColor(this.mContext.getResources().getColor(2131101179));
          break;
        }
        label781:
        paramView.setBackgroundColor(this.mContext.getResources().getColor(2131099828));
        break label317;
        label801:
        ((a)localObject1).nDQ.setVisibility(8);
        break label334;
        label814:
        i = 2131099819;
        break label361;
        label822:
        i = 0;
        break label386;
        label828:
        ((a)localObject1).nDR.setVisibility(8);
        break label425;
        label841:
        bool1 = false;
        break label459;
        label847:
        bool1 = false;
        break label494;
        label853:
        if (paramInt + 1 == getCount())
        {
          if (!this.nDK) {
            break label897;
          }
          paramViewGroup = ((a)localObject1).pf;
          if (!localb.nrF) {
            bool1 = true;
          }
          c(paramViewGroup, true, bool1);
        }
      }
      label897:
      paramViewGroup = ((a)localObject1).pf;
      if (!localb.nrF) {}
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
    this.nqu.clear();
    this.nqu.addAll(paramList);
    AppMethodBeat.o(113613);
  }
  
  final class a
  {
    TextView nCN;
    TextView nDP;
    TextView nDQ;
    ImageView nDR;
    CheckBox nDS;
    View pf;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.m
 * JD-Core Version:    0.7.0.1
 */