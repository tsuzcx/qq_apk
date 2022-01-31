package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import java.util.List;

public final class h
  implements a
{
  private g krx;
  
  public h(g paramg)
  {
    this.krx = paramg;
  }
  
  public final void aaK()
  {
    AppMethodBeat.i(88164);
    if (this.krx != null) {
      this.krx.notifyDataSetChanged();
    }
    AppMethodBeat.o(88164);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(88162);
    this.krx.notifyDataSetChanged();
    AppMethodBeat.o(88162);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(88163);
    if (this.krx != null)
    {
      g localg = this.krx;
      localg.krl.release();
      localg.krl = null;
      localg.krw.clear();
      localg.mContext = null;
      this.krx = null;
    }
    AppMethodBeat.o(88163);
  }
  
  public final b sU(int paramInt)
  {
    AppMethodBeat.i(88165);
    if (this.krx != null)
    {
      b localb = this.krx.sU(paramInt);
      AppMethodBeat.o(88165);
      return localb;
    }
    AppMethodBeat.o(88165);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.h
 * JD-Core Version:    0.7.0.1
 */