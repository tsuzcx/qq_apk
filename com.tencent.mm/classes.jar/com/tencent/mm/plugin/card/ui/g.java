package com.tencent.mm.plugin.card.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.model.CardInfo;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"UseValueOf"})
public final class g
  extends BaseAdapter
{
  Context mContext;
  private View.OnClickListener nmC;
  private boolean tpm;
  c ttl;
  List<CardInfo> tup;
  private boolean tys;
  List<Boolean> tyt;
  a tyu;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(113473);
    this.tup = new ArrayList();
    this.tys = false;
    this.tyt = new ArrayList();
    this.tpm = true;
    this.nmC = new g.1(this);
    this.ttl = new l(paramContext, this);
    this.mContext = paramContext;
    AppMethodBeat.o(113473);
  }
  
  public final CardInfo HQ(int paramInt)
  {
    AppMethodBeat.i(113475);
    CardInfo localCardInfo = (CardInfo)this.tup.get(paramInt);
    AppMethodBeat.o(113475);
    return localCardInfo;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113474);
    int i = this.tup.size();
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
    paramViewGroup = HQ(paramInt);
    paramViewGroup.tpm = this.tpm;
    paramView = this.ttl.a(paramInt, paramView, paramViewGroup);
    if ((this.tys) && (paramViewGroup.cGd()))
    {
      this.ttl.ab(paramView, 0);
      if (((Boolean)this.tyt.get(paramInt)).booleanValue())
      {
        this.ttl.aa(paramView, a.c.tab);
        this.ttl.a(paramView, paramInt, this.nmC);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(113476);
      return paramView;
      this.ttl.aa(paramView, a.c.tac);
      break;
      this.ttl.ab(paramView, 8);
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.g
 * JD-Core Version:    0.7.0.1
 */