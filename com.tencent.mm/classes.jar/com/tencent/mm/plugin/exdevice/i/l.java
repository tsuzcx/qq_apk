package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.service.l.a;
import com.tencent.mm.plugin.exdevice.service.p;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import junit.framework.Assert;

public final class l
  extends l.a
{
  private final long ftT;
  private c lJA;
  boolean lJB;
  boolean lJC;
  Runnable lJD;
  
  public l(c paramc)
  {
    AppMethodBeat.i(19749);
    this.lJA = null;
    this.ftT = 15000L;
    this.lJB = false;
    this.lJC = false;
    this.lJD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(19745);
        l.a(l.this);
        if (l.b(l.this))
        {
          AppMethodBeat.o(19745);
          return;
        }
        l.c(l.this).a(-1L, -1, -2, "TimeOut", null);
        AppMethodBeat.o(19745);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(19746);
        String str = super.toString() + "|mAsyncTimeOut";
        AppMethodBeat.o(19746);
        return str;
      }
    };
    Assert.assertNotNull(paramc);
    this.lJA = paramc;
    AppMethodBeat.o(19749);
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(19750);
    if (this.lJC)
    {
      AppMethodBeat.o(19750);
      return;
    }
    if (this.lJB)
    {
      AppMethodBeat.o(19750);
      return;
    }
    aw.RO().caB().removeCallbacks(this.lJD);
    aw.RO().caB().post(new l.2(this, paramLong, paramInt1, paramInt2, paramString, paramp));
    AppMethodBeat.o(19750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.l
 * JD-Core Version:    0.7.0.1
 */