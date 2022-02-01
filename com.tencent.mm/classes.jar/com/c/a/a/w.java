package com.c.a.a;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class w
  extends n
{
  private static w bSb;
  private boolean bSc;
  private int bSd;
  private long bSe;
  private long bSf;
  
  static w zl()
  {
    AppMethodBeat.i(87951);
    if (bSb == null) {
      bSb = new w();
    }
    w localw = bSb;
    AppMethodBeat.o(87951);
    return localw;
  }
  
  final void a(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(87956);
    if (this.bSc) {
      stop();
    }
    super.a(paramInt, paramString, paramLong1, paramLong2);
    AppMethodBeat.o(87956);
  }
  
  final void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    AppMethodBeat.i(87952);
    if (this.bSc) {
      if (k.yL().bMz) {
        k.yL().yH();
      }
    }
    for (;;)
    {
      super.a(paramContext, paramHandler, parama);
      AppMethodBeat.o(87952);
      return;
      if (!k.yL().bMz) {
        try
        {
          k.yL().a(paramContext, new m[] { this });
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
      this.bSc = false;
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
    long l = paramp.bPl;
    if ((this.bSc) && (l - this.bSf > this.bSe)) {
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
    if (paramx.bSj == null) {
      paramx.bSj = new x.a();
    }
    float f = paramx.bSj.bSm;
    if ((this.bSc) && (f >= this.bSd)) {
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