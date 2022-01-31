package com.tencent.mm.plugin.card.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.c;
import java.util.List;

public final class h
  implements a
{
  private g kww;
  
  public h(g paramg)
  {
    this.kww = paramg;
  }
  
  public final void aaK()
  {
    AppMethodBeat.i(88553);
    if (this.kww != null) {
      this.kww.notifyDataSetChanged();
    }
    AppMethodBeat.o(88553);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(88551);
    this.kww.notifyDataSetChanged();
    AppMethodBeat.o(88551);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(88552);
    if (this.kww != null)
    {
      g localg = this.kww;
      localg.krl.release();
      localg.krl = null;
      localg.krw.clear();
      localg.mContext = null;
      localg.kwu = null;
      this.kww = null;
    }
    AppMethodBeat.o(88552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.h
 * JD-Core Version:    0.7.0.1
 */