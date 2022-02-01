package com.c.a.a;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class w
  extends n
{
  private static w bUt;
  private boolean bUu;
  private int bUv;
  private long bUw;
  private long bUx;
  
  static w zy()
  {
    AppMethodBeat.i(87951);
    if (bUt == null) {
      bUt = new w();
    }
    w localw = bUt;
    AppMethodBeat.o(87951);
    return localw;
  }
  
  final void a(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(87956);
    if (this.bUu) {
      stop();
    }
    super.a(paramInt, paramString, paramLong1, paramLong2);
    AppMethodBeat.o(87956);
  }
  
  final void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    AppMethodBeat.i(87952);
    if (this.bUu) {
      if (k.yY().bOR) {
        k.yY().yU();
      }
    }
    for (;;)
    {
      super.a(paramContext, paramHandler, parama);
      AppMethodBeat.o(87952);
      return;
      if (!k.yY().bOR) {
        try
        {
          k.yY().a(paramContext, new m[] { this });
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
      this.bUu = false;
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
    long l = paramp.bRD;
    if ((this.bUu) && (l - this.bUx > this.bUw)) {
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
    if (paramx.bUB == null) {
      paramx.bUB = new x.a();
    }
    float f = paramx.bUB.bUE;
    if ((this.bUu) && (f >= this.bUv)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.c.a.a.w
 * JD-Core Version:    0.7.0.1
 */