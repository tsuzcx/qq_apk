package com.tencent.mm.plugin.card.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.model.CardInfo;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"UseValueOf"})
public final class g
  extends BaseAdapter
{
  private View.OnClickListener jax;
  Context mContext;
  private boolean nVG;
  c nZE;
  List<CardInfo> nZP;
  private boolean oeL;
  List<Boolean> oeM;
  a oeN;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(113473);
    this.nZP = new ArrayList();
    this.oeL = false;
    this.oeM = new ArrayList();
    this.nVG = true;
    this.jax = new g.1(this);
    this.nZE = new l(paramContext, this);
    this.mContext = paramContext;
    AppMethodBeat.o(113473);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113474);
    int i = this.nZP.size();
    AppMethodBeat.o(113474);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(113476);
    paramViewGroup = zP(paramInt);
    paramViewGroup.nVG = this.nVG;
    paramView = this.nZE.a(paramInt, paramView, paramViewGroup);
    if ((this.oeL) && (paramViewGroup.bOU()))
    {
      this.nZE.Z(paramView, 0);
      if (((Boolean)this.oeM.get(paramInt)).booleanValue())
      {
        this.nZE.Y(paramView, 2131231424);
        this.nZE.a(paramView, paramInt, this.jax);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(113476);
      return paramView;
      this.nZE.Y(paramView, 2131231425);
      break;
      this.nZE.Z(paramView, 8);
    }
  }
  
  public final CardInfo zP(int paramInt)
  {
    AppMethodBeat.i(113475);
    CardInfo localCardInfo = (CardInfo)this.nZP.get(paramInt);
    AppMethodBeat.o(113475);
    return localCardInfo;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.g
 * JD-Core Version:    0.7.0.1
 */