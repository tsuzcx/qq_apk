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
  private View.OnClickListener kuO;
  Context mContext;
  private boolean pTl;
  c pXo;
  List<CardInfo> pXz;
  private boolean qcv;
  List<Boolean> qcw;
  a qcx;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(113473);
    this.pXz = new ArrayList();
    this.qcv = false;
    this.qcw = new ArrayList();
    this.pTl = true;
    this.kuO = new g.1(this);
    this.pXo = new l(paramContext, this);
    this.mContext = paramContext;
    AppMethodBeat.o(113473);
  }
  
  public final CardInfo Ep(int paramInt)
  {
    AppMethodBeat.i(113475);
    CardInfo localCardInfo = (CardInfo)this.pXz.get(paramInt);
    AppMethodBeat.o(113475);
    return localCardInfo;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113474);
    int i = this.pXz.size();
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
    paramViewGroup = Ep(paramInt);
    paramViewGroup.pTl = this.pTl;
    paramView = this.pXo.a(paramInt, paramView, paramViewGroup);
    if ((this.qcv) && (paramViewGroup.csC()))
    {
      this.pXo.Z(paramView, 0);
      if (((Boolean)this.qcw.get(paramInt)).booleanValue())
      {
        this.pXo.Y(paramView, 2131231488);
        this.pXo.a(paramView, paramInt, this.kuO);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(113476);
      return paramView;
      this.pXo.Y(paramView, 2131231489);
      break;
      this.pXo.Z(paramView, 8);
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.g
 * JD-Core Version:    0.7.0.1
 */