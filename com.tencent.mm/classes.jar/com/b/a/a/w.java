package com.b.a.a;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class w
  extends n
{
  private static w brX;
  private boolean brY;
  private int brZ;
  private long bsa;
  private long bsb;
  
  static w tK()
  {
    AppMethodBeat.i(55606);
    if (brX == null) {
      brX = new w();
    }
    w localw = brX;
    AppMethodBeat.o(55606);
    return localw;
  }
  
  final void a(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(55611);
    if (this.brY) {
      stop();
    }
    super.a(paramInt, paramString, paramLong1, paramLong2);
    AppMethodBeat.o(55611);
  }
  
  final void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    AppMethodBeat.i(55607);
    if (this.brY) {
      if (k.tk().bmr) {
        k.tk().tg();
      }
    }
    for (;;)
    {
      super.a(paramContext, paramHandler, parama);
      AppMethodBeat.o(55607);
      return;
      if (!k.tk().bmr) {
        try
        {
          k.tk().a(paramContext, new m[] { this });
        }
        catch (Exception localException) {}
      }
    }
  }
  
  final void a(Handler paramHandler, d.a parama)
  {
    try
    {
      AppMethodBeat.i(55608);
      this.brY = false;
      super.a(paramHandler, parama);
      AppMethodBeat.o(55608);
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
    AppMethodBeat.i(55609);
    long l = paramp.bph;
    if ((this.brY) && (l - this.bsb > this.bsa)) {
      stop();
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(55609);
      return;
    }
    super.a(paramp);
    AppMethodBeat.o(55609);
  }
  
  final void a(x paramx, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(55610);
    if (paramx.bsg == null) {
      paramx.bsg = new x.a();
    }
    float f = paramx.bsg.bsj;
    if ((this.brY) && (f >= this.brZ)) {
      stop();
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(55610);
      return;
    }
    super.a(paramx, paramLong1, paramLong2);
    AppMethodBeat.o(55610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.b.a.a.w
 * JD-Core Version:    0.7.0.1
 */