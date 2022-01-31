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
import com.tencent.mm.plugin.card.model.b;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class m
  extends BaseAdapter
{
  private List<b> klo;
  View.OnClickListener kyq;
  boolean kyr;
  private Context mContext;
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(88685);
    this.klo = new ArrayList();
    this.kyr = false;
    this.mContext = paramContext;
    AppMethodBeat.o(88685);
  }
  
  private static void a(View paramView, b paramb)
  {
    AppMethodBeat.i(88690);
    if (paramb == null)
    {
      AppMethodBeat.o(88690);
      return;
    }
    o(paramView, paramb.kmy);
    AppMethodBeat.o(88690);
  }
  
  private static void o(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(88691);
    Rect localRect = com.tencent.mm.plugin.card.d.m.dg(paramView);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if (paramBoolean) {
      paramView.setBackgroundResource(2130839676);
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      com.tencent.mm.plugin.card.d.m.k(paramView, localRect);
      AppMethodBeat.o(88691);
      return;
      paramView.setBackgroundResource(2130839276);
    }
  }
  
  private b tn(int paramInt)
  {
    AppMethodBeat.i(88688);
    b localb = (b)this.klo.get(paramInt);
    AppMethodBeat.o(88688);
    return localb;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(88687);
    int i = this.klo.size();
    AppMethodBeat.o(88687);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(88689);
    b localb = tn(paramInt);
    switch (localb.kmx)
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
        paramView = View.inflate(this.mContext, 2130968913, null);
        localObject = new m.a(this, (byte)0);
        ((m.a)localObject).kxu = ((TextView)paramView.findViewById(2131822006));
        ((m.a)localObject).kyw = ((TextView)paramView.findViewById(2131822007));
        ((m.a)localObject).kyx = ((TextView)paramView.findViewById(2131822003));
        ((m.a)localObject).kyy = ((ImageView)paramView.findViewById(2131822005));
        ((m.a)localObject).jIo = paramView.findViewById(2131822004);
        ((m.a)localObject).kyz = ((CheckBox)paramView.findViewById(2131822008));
        paramView.setTag(localObject);
      }
      ((m.a)localObject).kxu.setText(localb.title);
      label249:
      int i;
      if (localb.kmz)
      {
        ((m.a)localObject).kyz.setVisibility(0);
        ((m.a)localObject).kyz.setChecked(localb.cJz);
        ((m.a)localObject).kyz.setOnClickListener(new m.2(this, localb));
        if (!TextUtils.isEmpty(localb.kmn)) {
          break label601;
        }
        ((m.a)localObject).kyw.setVisibility(4);
        if ((localb.wGZ & 1L) <= 0L) {
          break label626;
        }
        i = 1;
        label264:
        if (i == 0) {
          break label632;
        }
        ((m.a)localObject).kxu.setGravity(17);
        ((m.a)localObject).kxu.setTextColor(this.mContext.getResources().getColor(2131690214));
        ((m.a)localObject).kyw.setVisibility(8);
        label309:
        if (!localb.kmy) {
          break label665;
        }
        ((m.a)localObject).kyx.setVisibility(0);
        label326:
        ((m.a)localObject).kyw.setTextColor(this.mContext.getResources().getColor(2131690195));
        if (bo.isNullOrNil(localb.kWy)) {
          break label678;
        }
        i = 1;
        label360:
        if (i == 0) {
          break label684;
        }
        ((m.a)localObject).kyy.setVisibility(0);
        com.tencent.mm.plugin.card.d.m.a(((m.a)localObject).kyy, localb.kWy, a.fromDPToPix(this.mContext, 20), 2130839758, false);
        label399:
        if (paramInt + 1 >= getCount()) {
          break label697;
        }
        paramViewGroup = tn(paramInt);
        a(((m.a)localObject).jIo, paramViewGroup);
        paramViewGroup = tn(paramInt + 1);
        a(((m.a)localObject).jIo, paramViewGroup);
      }
      for (;;)
      {
        AppMethodBeat.o(88689);
        return paramView;
        paramView = View.inflate(this.mContext, 2130968912, null);
        paramViewGroup = (TextView)paramView.findViewById(2131821998);
        localObject = (TextView)paramView.findViewById(2131821999);
        LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131822000);
        if (!TextUtils.isEmpty(localb.kmA))
        {
          localLinearLayout.setTag(localb.kmA);
          localLinearLayout.setOnClickListener(new m.1(this));
          ((ImageView)paramView.findViewById(2131822001)).setBackgroundColor(l.IB(localb.color));
          localLinearLayout.setVisibility(0);
        }
        for (;;)
        {
          paramViewGroup.setText(localb.title);
          ((TextView)localObject).setText(localb.kmn);
          AppMethodBeat.o(88689);
          return paramView;
          localLinearLayout.setVisibility(8);
        }
        ((m.a)localObject).kyz.setVisibility(8);
        break;
        label601:
        ((m.a)localObject).kyw.setVisibility(0);
        ((m.a)localObject).kyw.setText(localb.kmn);
        break label249;
        label626:
        i = 0;
        break label264;
        label632:
        ((m.a)localObject).kxu.setGravity(3);
        ((m.a)localObject).kxu.setTextColor(this.mContext.getResources().getColor(2131690196));
        break label309;
        label665:
        ((m.a)localObject).kyx.setVisibility(8);
        break label326;
        label678:
        i = 0;
        break label360;
        label684:
        ((m.a)localObject).kyy.setVisibility(8);
        break label399;
        label697:
        if (paramInt + 1 == getCount()) {
          if (this.kyr) {
            o(((m.a)localObject).jIo, true);
          } else {
            o(((m.a)localObject).jIo, false);
          }
        }
      }
    }
  }
  
  public final void setData(List<b> paramList)
  {
    AppMethodBeat.i(88686);
    this.klo.clear();
    this.klo.addAll(paramList);
    AppMethodBeat.o(88686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.m
 * JD-Core Version:    0.7.0.1
 */