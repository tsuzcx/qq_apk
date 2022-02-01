package com.tencent.mm.cd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.vending.h.d;

public final class a
  extends d
{
  private String IsI;
  private aq handler;
  
  public a(String paramString)
  {
    AppMethodBeat.i(179439);
    this.handler = new aq(paramString);
    this.IsI = this.handler.getSerialTag();
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
    return this.IsI;
  }
  
  public final void u(Runnable paramRunnable)
  {
    AppMethodBeat.i(179440);
    this.handler.post(paramRunnable);
    AppMethodBeat.o(179440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cd.a
 * JD-Core Version:    0.7.0.1
 */