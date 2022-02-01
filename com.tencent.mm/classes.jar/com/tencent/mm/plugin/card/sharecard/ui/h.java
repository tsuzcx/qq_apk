package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import java.util.List;

public final class h
  implements a
{
  private g nwQ;
  
  public h(g paramg)
  {
    this.nwQ = paramg;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(113096);
    this.nwQ.notifyDataSetChanged();
    AppMethodBeat.o(113096);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(113097);
    if (this.nwQ != null)
    {
      g localg = this.nwQ;
      localg.nwE.release();
      localg.nwE = null;
      localg.nwP.clear();
      localg.mContext = null;
      this.nwQ = null;
    }
    AppMethodBeat.o(113097);
  }
  
  public final void onNotify()
  {
    AppMethodBeat.i(113098);
    if (this.nwQ != null) {
      this.nwQ.notifyDataSetChanged();
    }
    AppMethodBeat.o(113098);
  }
  
  public final b yN(int paramInt)
  {
    AppMethodBeat.i(113099);
    if (this.nwQ != null)
    {
      b localb = this.nwQ.yN(paramInt);
      AppMethodBeat.o(113099);
      return localb;
    }
    AppMethodBeat.o(113099);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.h
 * JD-Core Version:    0.7.0.1
 */