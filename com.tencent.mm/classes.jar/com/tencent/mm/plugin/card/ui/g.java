package com.tencent.mm.plugin.card.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.model.CardInfo;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"UseValueOf"})
public final class g
  extends BaseAdapter
{
  private View.OnClickListener fvj = new g.1(this);
  private boolean imw = true;
  c iqd = new l(paramContext, this);
  List<CardInfo> iqo = new ArrayList();
  private boolean ivo = false;
  List<Boolean> ivp = new ArrayList();
  g.a ivq;
  Context mContext;
  
  public g(Context paramContext)
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
    paramViewGroup = oV(paramInt);
    paramViewGroup.imw = this.imw;
    paramView = this.iqd.a(paramInt, paramView, paramViewGroup);
    if ((this.ivo) && (paramViewGroup.azk()))
    {
      this.iqd.G(paramView, 0);
      if (((Boolean)this.ivp.get(paramInt)).booleanValue()) {
        this.iqd.F(paramView, a.c.card_add_selected_btn_bg);
      }
      for (;;)
      {
        this.iqd.a(paramView, paramInt, this.fvj);
        return paramView;
        this.iqd.F(paramView, a.c.card_add_unselected_btn_bg);
      }
    }
    this.iqd.G(paramView, 8);
    return paramView;
  }
  
  public final CardInfo oV(int paramInt)
  {
    return (CardInfo)this.iqo.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.g
 * JD-Core Version:    0.7.0.1
 */