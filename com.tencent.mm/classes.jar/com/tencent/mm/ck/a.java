package com.tencent.mm.ck;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vending.h.d;

public final class a
  extends d
{
  private MMHandler handler;
  private String serialTag;
  
  public a(String paramString)
  {
    AppMethodBeat.i(179439);
    this.handler = new MMHandler(paramString);
    this.serialTag = this.handler.getSerialTag();
    AppMethodBeat.o(179439);
  }
  
  public final void arrange(Runnable paramRunnable)
  {
    AppMethodBeat.i(179440);
    this.handler.post(paramRunnable);
    AppMethodBeat.o(179440);
  }
  
  public final void arrangeInterval(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(179441);
    this.handler.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(179441);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(179442);
    this.handler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(179442);
  }
  
  public final String getType()
  {
    return this.serialTag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ck.a
 * JD-Core Version:    0.7.0.1
 */