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
  private View.OnClickListener jtG;
  Context mContext;
  c oCY;
  List<CardInfo> oDj;
  private boolean oIf;
  List<Boolean> oIg;
  a oIh;
  private boolean ozb;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(113473);
    this.oDj = new ArrayList();
    this.oIf = false;
    this.oIg = new ArrayList();
    this.ozb = true;
    this.jtG = new g.1(this);
    this.oCY = new l(paramContext, this);
    this.mContext = paramContext;
    AppMethodBeat.o(113473);
  }
  
  public final CardInfo Ay(int paramInt)
  {
    AppMethodBeat.i(113475);
    CardInfo localCardInfo = (CardInfo)this.oDj.get(paramInt);
    AppMethodBeat.o(113475);
    return localCardInfo;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113474);
    int i = this.oDj.size();
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
    paramViewGroup = Ay(paramInt);
    paramViewGroup.ozb = this.ozb;
    paramView = this.oCY.a(paramInt, paramView, paramViewGroup);
    if ((this.oIf) && (paramViewGroup.bTz()))
    {
      this.oCY.aa(paramView, 0);
      if (((Boolean)this.oIg.get(paramInt)).booleanValue())
      {
        this.oCY.Z(paramView, 2131231424);
        this.oCY.a(paramView, paramInt, this.jtG);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(113476);
      return paramView;
      this.oCY.Z(paramView, 2131231425);
      break;
      this.oCY.aa(paramView, 8);
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.g
 * JD-Core Version:    0.7.0.1
 */