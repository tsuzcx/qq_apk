package com.tencent.mm.plugin.card.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.c;
import java.util.List;

public final class h
  implements a
{
  private g tyw;
  
  public h(g paramg)
  {
    this.tyw = paramg;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(113478);
    this.tyw.notifyDataSetChanged();
    AppMethodBeat.o(113478);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(113479);
    if (this.tyw != null)
    {
      g localg = this.tyw;
      localg.ttl.release();
      localg.ttl = null;
      localg.tup.clear();
      localg.mContext = null;
      localg.tyu = null;
      this.tyw = null;
    }
    AppMethodBeat.o(113479);
  }
  
  public final void onNotify()
  {
    AppMethodBeat.i(113480);
    if (this.tyw != null) {
      this.tyw.notifyDataSetChanged();
    }
    AppMethodBeat.o(113480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.h
 * JD-Core Version:    0.7.0.1
 */