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
  private View.OnClickListener jwB;
  Context mContext;
  private boolean oFD;
  c oJA;
  List<CardInfo> oJL;
  private boolean oOH;
  List<Boolean> oOI;
  a oOJ;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(113473);
    this.oJL = new ArrayList();
    this.oOH = false;
    this.oOI = new ArrayList();
    this.oFD = true;
    this.jwB = new g.1(this);
    this.oJA = new l(paramContext, this);
    this.mContext = paramContext;
    AppMethodBeat.o(113473);
  }
  
  public final CardInfo AK(int paramInt)
  {
    AppMethodBeat.i(113475);
    CardInfo localCardInfo = (CardInfo)this.oJL.get(paramInt);
    AppMethodBeat.o(113475);
    return localCardInfo;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113474);
    int i = this.oJL.size();
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
    paramViewGroup = AK(paramInt);
    paramViewGroup.oFD = this.oFD;
    paramView = this.oJA.a(paramInt, paramView, paramViewGroup);
    if ((this.oOH) && (paramViewGroup.bUO()))
    {
      this.oJA.aa(paramView, 0);
      if (((Boolean)this.oOI.get(paramInt)).booleanValue())
      {
        this.oJA.Z(paramView, 2131231424);
        this.oJA.a(paramView, paramInt, this.jwB);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(113476);
      return paramView;
      this.oJA.Z(paramView, 2131231425);
      break;
      this.oJA.aa(paramView, 8);
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.g
 * JD-Core Version:    0.7.0.1
 */