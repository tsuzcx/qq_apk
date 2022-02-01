package com.tencent.mm.plugin.card.ui;

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

public final class g
  extends BaseAdapter
{
  Context mContext;
  private View.OnClickListener qjL;
  private boolean wCP;
  List<Boolean> wCQ;
  a wCR;
  private boolean wtL;
  c wxI;
  List<CardInfo> wyM;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(113473);
    this.wyM = new ArrayList();
    this.wCP = false;
    this.wCQ = new ArrayList();
    this.wtL = true;
    this.qjL = new g.1(this);
    this.wxI = new l(paramContext, this);
    this.mContext = paramContext;
    AppMethodBeat.o(113473);
  }
  
  public final CardInfo Ir(int paramInt)
  {
    AppMethodBeat.i(113475);
    CardInfo localCardInfo = (CardInfo)this.wyM.get(paramInt);
    AppMethodBeat.o(113475);
    return localCardInfo;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113474);
    int i = this.wyM.size();
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
    paramViewGroup = Ir(paramInt);
    paramViewGroup.wtL = this.wtL;
    paramView = this.wxI.a(paramInt, paramView, paramViewGroup);
    if ((this.wCP) && (paramViewGroup.djv()))
    {
      this.wxI.ag(paramView, 0);
      if (((Boolean)this.wCQ.get(paramInt)).booleanValue())
      {
        this.wxI.af(paramView, a.c.wei);
        this.wxI.a(paramView, paramInt, this.qjL);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(113476);
      return paramView;
      this.wxI.af(paramView, a.c.wej);
      break;
      this.wxI.ag(paramView, 8);
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.g
 * JD-Core Version:    0.7.0.1
 */