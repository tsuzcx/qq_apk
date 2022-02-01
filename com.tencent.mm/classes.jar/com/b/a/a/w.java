package com.b.a.a;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class w
  extends n
{
  private static w cmU;
  private boolean cmV;
  private int cmW;
  private long cmX;
  private long cmY;
  
  static w JC()
  {
    AppMethodBeat.i(87951);
    if (cmU == null) {
      cmU = new w();
    }
    w localw = cmU;
    AppMethodBeat.o(87951);
    return localw;
  }
  
  final void a(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(87956);
    if (this.cmV) {
      stop();
    }
    super.a(paramInt, paramString, paramLong1, paramLong2);
    AppMethodBeat.o(87956);
  }
  
  final void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    AppMethodBeat.i(87952);
    if (this.cmV) {
      if (k.Jc().chu) {
        k.Jc().IY();
      }
    }
    for (;;)
    {
      super.a(paramContext, paramHandler, parama);
      AppMethodBeat.o(87952);
      return;
      if (!k.Jc().chu) {
        try
        {
          k.Jc().a(paramContext, new m[] { this });
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
      this.cmV = false;
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
    long l = paramp.ckf;
    if ((this.cmV) && (l - this.cmY > this.cmX)) {
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
    if (paramx.cnc == null) {
      paramx.cnc = new x.a();
    }
    float f = paramx.cnc.cnf;
    if ((this.cmV) && (f >= this.cmW)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.b.a.a.w
 * JD-Core Version:    0.7.0.1
 */