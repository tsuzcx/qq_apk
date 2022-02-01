package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import java.util.List;

public final class g
  extends BaseAdapter
{
  Context mContext;
  c oCY;
  List<b> oDj;
  
  public final b Am(int paramInt)
  {
    AppMethodBeat.i(113093);
    b localb = (b)this.oDj.get(paramInt);
    AppMethodBeat.o(113093);
    return localb;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113092);
    int i = this.oDj.size();
    AppMethodBeat.o(113092);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(113094);
    paramViewGroup = Am(paramInt);
    paramView = this.oCY.a(paramInt, paramView, paramViewGroup);
    AppMethodBeat.o(113094);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.g
 * JD-Core Version:    0.7.0.1
 */