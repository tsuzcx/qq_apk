package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;

public final class h
  implements a
{
  private g wxT;
  
  public h(g paramg)
  {
    this.wxT = paramg;
  }
  
  public final b If(int paramInt)
  {
    AppMethodBeat.i(113099);
    if (this.wxT != null)
    {
      AppMethodBeat.o(113099);
      throw null;
    }
    AppMethodBeat.o(113099);
    return null;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(113096);
    this.wxT.notifyDataSetChanged();
    AppMethodBeat.o(113096);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(113097);
    if (this.wxT != null)
    {
      AppMethodBeat.o(113097);
      throw null;
    }
    AppMethodBeat.o(113097);
  }
  
  public final void onNotify()
  {
    AppMethodBeat.i(113098);
    if (this.wxT != null) {
      this.wxT.notifyDataSetChanged();
    }
    AppMethodBeat.o(113098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.h
 * JD-Core Version:    0.7.0.1
 */