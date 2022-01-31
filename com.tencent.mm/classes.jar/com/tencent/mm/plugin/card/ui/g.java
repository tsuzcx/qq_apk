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
  private View.OnClickListener gMO;
  private boolean kns;
  c krl;
  List<CardInfo> krw;
  private boolean kws;
  List<Boolean> kwt;
  g.a kwu;
  Context mContext;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(88546);
    this.krw = new ArrayList();
    this.kws = false;
    this.kwt = new ArrayList();
    this.kns = true;
    this.gMO = new g.1(this);
    this.krl = new l(paramContext, this);
    this.mContext = paramContext;
    AppMethodBeat.o(88546);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(88547);
    int i = this.krw.size();
    AppMethodBeat.o(88547);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(88549);
    paramViewGroup = tg(paramInt);
    paramViewGroup.kns = this.kns;
    paramView = this.krl.a(paramInt, paramView, paramViewGroup);
    if ((this.kws) && (paramViewGroup.baQ()))
    {
      this.krl.W(paramView, 0);
      if (((Boolean)this.kwt.get(paramInt)).booleanValue())
      {
        this.krl.V(paramView, 2130838096);
        this.krl.a(paramView, paramInt, this.gMO);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(88549);
      return paramView;
      this.krl.V(paramView, 2130838097);
      break;
      this.krl.W(paramView, 8);
    }
  }
  
  public final CardInfo tg(int paramInt)
  {
    AppMethodBeat.i(88548);
    CardInfo localCardInfo = (CardInfo)this.krw.get(paramInt);
    AppMethodBeat.o(88548);
    return localCardInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.g
 * JD-Core Version:    0.7.0.1
 */