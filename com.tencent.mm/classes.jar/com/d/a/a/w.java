package com.d.a.a;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class w
  extends n
{
  private static w cco;
  private boolean ccp;
  private int ccq;
  private long ccr;
  private long ccs;
  
  static w AJ()
  {
    AppMethodBeat.i(87951);
    if (cco == null) {
      cco = new w();
    }
    w localw = cco;
    AppMethodBeat.o(87951);
    return localw;
  }
  
  final void a(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(87956);
    if (this.ccp) {
      stop();
    }
    super.a(paramInt, paramString, paramLong1, paramLong2);
    AppMethodBeat.o(87956);
  }
  
  final void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    AppMethodBeat.i(87952);
    if (this.ccp) {
      if (k.Aj().bWM) {
        k.Aj().Af();
      }
    }
    for (;;)
    {
      super.a(paramContext, paramHandler, parama);
      AppMethodBeat.o(87952);
      return;
      if (!k.Aj().bWM) {
        try
        {
          k.Aj().a(paramContext, new m[] { this });
        }
        catch (Exception localException) {}
      }
    }
  }
  
  final void a(Handler paramHandler, d.a parama)
  {
    try
    {
      AppMethodBeat.i(87953);
      this.ccp = false;
      super.a(paramHandler, parama);
      AppMethodBeat.o(87953);
      return;
    }
    finally
    {
      paramHandler = finally;
      throw paramHandler;
    }
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(87954);
    long l = paramp.bZy;
    if ((this.ccp) && (l - this.ccs > this.ccr)) {
      stop();
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(87954);
      return;
    }
    super.a(paramp);
    AppMethodBeat.o(87954);
  }
  
  final void a(x paramx, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(87955);
    if (paramx.ccw == null) {
      paramx.ccw = new x.a();
    }
    float f = paramx.ccw.ccz;
    if ((this.ccp) && (f >= this.ccq)) {
      stop();
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(87955);
      return;
    }
    super.a(paramx, paramLong1, paramLong2);
    AppMethodBeat.o(87955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.a.w
 * JD-Core Version:    0.7.0.1
 */