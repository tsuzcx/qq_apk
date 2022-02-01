package com.tencent.mm.plugin.card.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.c;
import java.util.List;

public final class h
  implements a
{
  private g oeP;
  
  public h(g paramg)
  {
    this.oeP = paramg;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(113478);
    this.oeP.notifyDataSetChanged();
    AppMethodBeat.o(113478);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(113479);
    if (this.oeP != null)
    {
      g localg = this.oeP;
      localg.nZE.release();
      localg.nZE = null;
      localg.nZP.clear();
      localg.mContext = null;
      localg.oeN = null;
      this.oeP = null;
    }
    AppMethodBeat.o(113479);
  }
  
  public final void onNotify()
  {
    AppMethodBeat.i(113480);
    if (this.oeP != null) {
      this.oeP.notifyDataSetChanged();
    }
    AppMethodBeat.o(113480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.h
 * JD-Core Version:    0.7.0.1
 */