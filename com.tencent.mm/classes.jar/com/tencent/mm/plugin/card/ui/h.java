package com.tencent.mm.plugin.card.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.c;
import java.util.List;

public final class h
  implements a
{
  private g qcz;
  
  public h(g paramg)
  {
    this.qcz = paramg;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(113478);
    this.qcz.notifyDataSetChanged();
    AppMethodBeat.o(113478);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(113479);
    if (this.qcz != null)
    {
      g localg = this.qcz;
      localg.pXo.release();
      localg.pXo = null;
      localg.pXz.clear();
      localg.mContext = null;
      localg.qcx = null;
      this.qcz = null;
    }
    AppMethodBeat.o(113479);
  }
  
  public final void onNotify()
  {
    AppMethodBeat.i(113480);
    if (this.qcz != null) {
      this.qcz.notifyDataSetChanged();
    }
    AppMethodBeat.o(113480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.h
 * JD-Core Version:    0.7.0.1
 */