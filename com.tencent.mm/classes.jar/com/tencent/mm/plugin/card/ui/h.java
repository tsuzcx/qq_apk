package com.tencent.mm.plugin.card.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.c;
import java.util.List;

public final class h
  implements a
{
  private g wCT;
  
  public h(g paramg)
  {
    this.wCT = paramg;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(113478);
    this.wCT.notifyDataSetChanged();
    AppMethodBeat.o(113478);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(113479);
    if (this.wCT != null)
    {
      g localg = this.wCT;
      localg.wxI.release();
      localg.wxI = null;
      localg.wyM.clear();
      localg.mContext = null;
      localg.wCR = null;
      this.wCT = null;
    }
    AppMethodBeat.o(113479);
  }
  
  public final void onNotify()
  {
    AppMethodBeat.i(113480);
    if (this.wCT != null) {
      this.wCT.notifyDataSetChanged();
    }
    AppMethodBeat.o(113480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.h
 * JD-Core Version:    0.7.0.1
 */