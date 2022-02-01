package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import java.util.List;

public final class h
  implements a
{
  private g pXA;
  
  public h(g paramg)
  {
    this.pXA = paramg;
  }
  
  public final b Ed(int paramInt)
  {
    AppMethodBeat.i(113099);
    if (this.pXA != null)
    {
      b localb = this.pXA.Ed(paramInt);
      AppMethodBeat.o(113099);
      return localb;
    }
    AppMethodBeat.o(113099);
    return null;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(113096);
    this.pXA.notifyDataSetChanged();
    AppMethodBeat.o(113096);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(113097);
    if (this.pXA != null)
    {
      g localg = this.pXA;
      localg.pXo.release();
      localg.pXo = null;
      localg.pXz.clear();
      localg.mContext = null;
      this.pXA = null;
    }
    AppMethodBeat.o(113097);
  }
  
  public final void onNotify()
  {
    AppMethodBeat.i(113098);
    if (this.pXA != null) {
      this.pXA.notifyDataSetChanged();
    }
    AppMethodBeat.o(113098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.h
 * JD-Core Version:    0.7.0.1
 */