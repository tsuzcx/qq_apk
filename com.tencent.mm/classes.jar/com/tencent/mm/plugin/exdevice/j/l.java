package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.exdevice.service.l.a;
import com.tencent.mm.plugin.exdevice.service.p;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import junit.framework.Assert;

public final class l
  extends l.a
{
  private final long gVY;
  private c pak;
  boolean pal;
  boolean pam;
  Runnable pan;
  
  public l(c paramc)
  {
    AppMethodBeat.i(23817);
    this.pak = null;
    this.gVY = 15000L;
    this.pal = false;
    this.pam = false;
    this.pan = new Runnable()
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
    this.pak = paramc;
    AppMethodBeat.o(23817);
  }
  
  public final void a(final long paramLong, int paramInt1, final int paramInt2, final String paramString, final p paramp)
  {
    AppMethodBeat.i(23818);
    if (this.pam)
    {
      AppMethodBeat.o(23818);
      return;
    }
    if (this.pal)
    {
      AppMethodBeat.o(23818);
      return;
    }
    az.afE().cBt().removeCallbacks(this.pan);
    az.afE().cBt().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23815);
        l.c(l.this).a(paramLong, paramInt2, paramString, paramp, this.paq);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.l
 * JD-Core Version:    0.7.0.1
 */