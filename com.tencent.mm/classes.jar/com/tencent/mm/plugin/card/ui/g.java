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
  private View.OnClickListener iAw;
  Context mContext;
  private boolean nBL;
  List<Boolean> nBM;
  a nBN;
  private boolean nsG;
  c nwE;
  List<CardInfo> nwP;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(113473);
    this.nwP = new ArrayList();
    this.nBL = false;
    this.nBM = new ArrayList();
    this.nsG = true;
    this.iAw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113472);
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        paramAnonymousView = g.this;
        if (((Boolean)paramAnonymousView.nBM.get(i)).booleanValue()) {
          paramAnonymousView.nBM.set(i, Boolean.FALSE);
        }
        for (;;)
        {
          paramAnonymousView.notifyDataSetChanged();
          AppMethodBeat.o(113472);
          return;
          paramAnonymousView.nBM.set(i, Boolean.TRUE);
        }
      }
    };
    this.nwE = new l(paramContext, this);
    this.mContext = paramContext;
    AppMethodBeat.o(113473);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113474);
    int i = this.nwP.size();
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
    paramViewGroup = yZ(paramInt);
    paramViewGroup.nsG = this.nsG;
    paramView = this.nwE.a(paramInt, paramView, paramViewGroup);
    if ((this.nBL) && (paramViewGroup.bHH()))
    {
      this.nwE.Y(paramView, 0);
      if (((Boolean)this.nBM.get(paramInt)).booleanValue())
      {
        this.nwE.X(paramView, 2131231424);
        this.nwE.a(paramView, paramInt, this.iAw);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(113476);
      return paramView;
      this.nwE.X(paramView, 2131231425);
      break;
      this.nwE.Y(paramView, 8);
    }
  }
  
  public final CardInfo yZ(int paramInt)
  {
    AppMethodBeat.i(113475);
    CardInfo localCardInfo = (CardInfo)this.nwP.get(paramInt);
    AppMethodBeat.o(113475);
    return localCardInfo;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.g
 * JD-Core Version:    0.7.0.1
 */