package com.tencent.mm.ce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.vending.h.d;

public final class a
  extends d
{
  private String HYB;
  private ap handler;
  
  public a(String paramString)
  {
    AppMethodBeat.i(179439);
    this.handler = new ap(paramString);
    this.HYB = this.handler.getSerialTag();
    AppMethodBeat.o(179439);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(179442);
    this.handler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(179442);
  }
  
  public final void g(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(179441);
    this.handler.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(179441);
  }
  
  public final String getType()
  {
    return this.HYB;
  }
  
  public final void w(Runnable paramRunnable)
  {
    AppMethodBeat.i(179440);
    this.handler.post(paramRunnable);
    AppMethodBeat.o(179440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ce.a
 * JD-Core Version:    0.7.0.1
 */