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
  c krl;
  List<b> krw;
  Context mContext;
  
  public final int getCount()
  {
    AppMethodBeat.i(88158);
    int i = this.krw.size();
    AppMethodBeat.o(88158);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(88160);
    paramViewGroup = sU(paramInt);
    paramView = this.krl.a(paramInt, paramView, paramViewGroup);
    AppMethodBeat.o(88160);
    return paramView;
  }
  
  public final b sU(int paramInt)
  {
    AppMethodBeat.i(88159);
    b localb = (b)this.krw.get(paramInt);
    AppMethodBeat.o(88159);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.g
 * JD-Core Version:    0.7.0.1
 */