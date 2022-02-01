package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import java.util.List;

public final class h
  implements a
{
  private g oJM;
  
  public h(g paramg)
  {
    this.oJM = paramg;
  }
  
  public final b Ay(int paramInt)
  {
    AppMethodBeat.i(113099);
    if (this.oJM != null)
    {
      b localb = this.oJM.Ay(paramInt);
      AppMethodBeat.o(113099);
      return localb;
    }
    AppMethodBeat.o(113099);
    return null;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(113096);
    this.oJM.notifyDataSetChanged();
    AppMethodBeat.o(113096);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(113097);
    if (this.oJM != null)
    {
      g localg = this.oJM;
      localg.oJA.release();
      localg.oJA = null;
      localg.oJL.clear();
      localg.mContext = null;
      this.oJM = null;
    }
    AppMethodBeat.o(113097);
  }
  
  public final void onNotify()
  {
    AppMethodBeat.i(113098);
    if (this.oJM != null) {
      this.oJM.notifyDataSetChanged();
    }
    AppMethodBeat.o(113098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.h
 * JD-Core Version:    0.7.0.1
 */