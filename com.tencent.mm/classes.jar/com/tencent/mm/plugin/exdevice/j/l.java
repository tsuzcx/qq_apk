package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.exdevice.service.l.a;
import com.tencent.mm.plugin.exdevice.service.p;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import junit.framework.Assert;

public final class l
  extends l.a
{
  private final long hRF;
  private c qnF;
  boolean qnG;
  boolean qnH;
  Runnable qnI;
  
  public l(c paramc)
  {
    AppMethodBeat.i(23817);
    this.qnF = null;
    this.hRF = 15000L;
    this.qnG = false;
    this.qnH = false;
    this.qnI = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23813);
        l.a(l.this);
        if (l.b(l.this))
        {
          AppMethodBeat.o(23813);
          return;
        }
        l.c(l.this).a(-1L, -1, -2, "TimeOut", null);
        AppMethodBeat.o(23813);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(23814);
        String str = super.toString() + "|mAsyncTimeOut";
        AppMethodBeat.o(23814);
        return str;
      }
    };
    Assert.assertNotNull(paramc);
    this.qnF = paramc;
    AppMethodBeat.o(23817);
  }
  
  public final void a(final long paramLong, int paramInt1, final int paramInt2, final String paramString, final p paramp)
  {
    AppMethodBeat.i(23818);
    if (this.qnH)
    {
      AppMethodBeat.o(23818);
      return;
    }
    if (this.qnG)
    {
      AppMethodBeat.o(23818);
      return;
    }
    bc.ajU().cZF().removeCallbacks(this.qnI);
    bc.ajU().cZF().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23815);
        l.c(l.this).a(paramLong, paramInt2, paramString, paramp, this.qnL);
        AppMethodBeat.o(23815);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(23816);
        String str = super.toString() + "|onTaskEnd";
        AppMethodBeat.o(23816);
        return str;
      }
    });
    AppMethodBeat.o(23818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.l
 * JD-Core Version:    0.7.0.1
 */