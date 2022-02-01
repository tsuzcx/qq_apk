package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import java.util.List;

public final class h
  implements a
{
  private g oDk;
  
  public h(g paramg)
  {
    this.oDk = paramg;
  }
  
  public final b Am(int paramInt)
  {
    AppMethodBeat.i(113099);
    if (this.oDk != null)
    {
      b localb = this.oDk.Am(paramInt);
      AppMethodBeat.o(113099);
      return localb;
    }
    AppMethodBeat.o(113099);
    return null;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(113096);
    this.oDk.notifyDataSetChanged();
    AppMethodBeat.o(113096);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(113097);
    if (this.oDk != null)
    {
      g localg = this.oDk;
      localg.oCY.release();
      localg.oCY = null;
      localg.oDj.clear();
      localg.mContext = null;
      this.oDk = null;
    }
    AppMethodBeat.o(113097);
  }
  
  public final void onNotify()
  {
    AppMethodBeat.i(113098);
    if (this.oDk != null) {
      this.oDk.notifyDataSetChanged();
    }
    AppMethodBeat.o(113098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.h
 * JD-Core Version:    0.7.0.1
 */