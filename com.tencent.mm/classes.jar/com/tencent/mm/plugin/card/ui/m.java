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
import com.tencent.mm.cb.a;
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
  private List<b> pRa;
  View.OnClickListener qet;
  boolean qeu;
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(113612);
    this.pRa = new ArrayList();
    this.qeu = false;
    this.mContext = paramContext;
    AppMethodBeat.o(113612);
  }
  
  private b Ew(int paramInt)
  {
    AppMethodBeat.i(113615);
    b localb = (b)this.pRa.get(paramInt);
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
    c(paramView, paramb.pSj, paramBoolean);
    AppMethodBeat.o(161199);
  }
  
  private static void c(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(161200);
    Rect localRect = n.dC(paramView);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    int i;
    if (paramBoolean1) {
      i = 2131233974;
    }
    for (;;)
    {
      paramView.setBackgroundResource(i);
      paramView.setLayoutParams(localLayoutParams);
      n.f(paramView, localRect);
      AppMethodBeat.o(161200);
      return;
      if (paramBoolean2) {
        i = 2131233329;
      } else {
        i = 2131233327;
      }
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113614);
    int i = this.pRa.size();
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
    b localb = Ew(paramInt);
    switch (localb.pSi)
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
        paramView = View.inflate(this.mContext, 2131493342, null);
        localObject1 = new a((byte)0);
        ((a)localObject1).qdx = ((TextView)paramView.findViewById(2131298067));
        ((a)localObject1).qez = ((TextView)paramView.findViewById(2131298066));
        ((a)localObject1).qeA = ((TextView)paramView.findViewById(2131298063));
        ((a)localObject1).qeB = ((ImageView)paramView.findViewById(2131298065));
        ((a)localObject1).sc = paramView.findViewById(2131298061);
        ((a)localObject1).qeC = ((CheckBox)paramView.findViewById(2131298064));
        paramView.setTag(localObject1);
      }
      ((a)localObject1).qdx.setText(localb.title);
      label257:
      int i;
      label272:
      label317:
      label334:
      Object localObject2;
      if (localb.pSk)
      {
        ((a)localObject1).qeC.setVisibility(0);
        ((a)localObject1).qeC.setChecked(localb.edw);
        ((a)localObject1).qeC.setOnClickListener(new m.2(this, localb));
        if (!TextUtils.isEmpty(localb.pRY)) {
          break label666;
        }
        ((a)localObject1).qez.setVisibility(4);
        if ((localb.LfD & 1L) <= 0L) {
          break label691;
        }
        i = 1;
        if (i == 0) {
          break label697;
        }
        ((a)localObject1).qdx.setGravity(17);
        ((a)localObject1).qdx.setTextColor(this.mContext.getResources().getColor(2131100685));
        ((a)localObject1).qez.setVisibility(8);
        if (!localb.pSj) {
          break label801;
        }
        ((a)localObject1).qeA.setVisibility(0);
        paramViewGroup = ((a)localObject1).qez;
        localObject2 = this.mContext.getResources();
        if (!localb.pSl) {
          break label814;
        }
        i = 2131100245;
        label361:
        paramViewGroup.setTextColor(((Resources)localObject2).getColor(i));
        if (Util.isNullOrNil(localb.qGB)) {
          break label822;
        }
        i = 1;
        label386:
        if (i == 0) {
          break label828;
        }
        ((a)localObject1).qeB.setVisibility(0);
        n.a(((a)localObject1).qeB, localb.qGB, a.fromDPToPix(this.mContext, 20), 2131234198, false);
        label425:
        if (paramInt + 1 >= getCount()) {
          break label853;
        }
        paramViewGroup = Ew(paramInt);
        localObject2 = ((a)localObject1).sc;
        if (localb.pSl) {
          break label841;
        }
        bool1 = true;
        label459:
        a((View)localObject2, paramViewGroup, bool1);
        paramViewGroup = Ew(paramInt + 1);
        localObject1 = ((a)localObject1).sc;
        if (localb.pSl) {
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
        paramView = View.inflate(this.mContext, 2131493341, null);
        paramViewGroup = (TextView)paramView.findViewById(2131298070);
        localObject1 = (TextView)paramView.findViewById(2131298069);
        localObject2 = (LinearLayout)paramView.findViewById(2131307844);
        if (!TextUtils.isEmpty(localb.pSm))
        {
          ((LinearLayout)localObject2).setTag(localb.pSm);
          ((LinearLayout)localObject2).setOnClickListener(new m.1(this));
          ((ImageView)paramView.findViewById(2131298068)).setBackgroundColor(l.ake(localb.ixw));
          ((LinearLayout)localObject2).setVisibility(0);
        }
        for (;;)
        {
          paramViewGroup.setText(localb.title);
          ((TextView)localObject1).setText(localb.pRY);
          AppMethodBeat.o(113616);
          return paramView;
          ((LinearLayout)localObject2).setVisibility(8);
        }
        ((a)localObject1).qeC.setVisibility(8);
        break;
        label666:
        ((a)localObject1).qez.setVisibility(0);
        ((a)localObject1).qez.setText(localb.pRY);
        break label257;
        label691:
        i = 0;
        break label272;
        label697:
        ((a)localObject1).qdx.setGravity(3);
        paramViewGroup = ((a)localObject1).qdx;
        localObject2 = this.mContext.getResources();
        if (localb.pSl) {}
        for (i = 2131100904;; i = 2131099836)
        {
          paramViewGroup.setTextColor(((Resources)localObject2).getColor(i));
          if (!localb.pSl) {
            break label781;
          }
          paramView.setBackgroundColor(this.mContext.getResources().getColor(2131101424));
          break;
        }
        label781:
        paramView.setBackgroundColor(this.mContext.getResources().getColor(2131099844));
        break label317;
        label801:
        ((a)localObject1).qeA.setVisibility(8);
        break label334;
        label814:
        i = 2131099835;
        break label361;
        label822:
        i = 0;
        break label386;
        label828:
        ((a)localObject1).qeB.setVisibility(8);
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
          if (!this.qeu) {
            break label897;
          }
          paramViewGroup = ((a)localObject1).sc;
          if (!localb.pSl) {
            bool1 = true;
          }
          c(paramViewGroup, true, bool1);
        }
      }
      label897:
      paramViewGroup = ((a)localObject1).sc;
      if (!localb.pSl) {}
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
    this.pRa.clear();
    this.pRa.addAll(paramList);
    AppMethodBeat.o(113613);
  }
  
  final class a
  {
    TextView qdx;
    TextView qeA;
    ImageView qeB;
    CheckBox qeC;
    TextView qez;
    View sc;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.m
 * JD-Core Version:    0.7.0.1
 */