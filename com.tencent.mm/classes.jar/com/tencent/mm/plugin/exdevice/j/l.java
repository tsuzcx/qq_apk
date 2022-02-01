package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.exdevice.service.l.a;
import com.tencent.mm.plugin.exdevice.service.p;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import junit.framework.Assert;

public final class l
  extends l.a
{
  private final long ouG;
  private c ywu;
  boolean ywv;
  boolean yww;
  Runnable ywx;
  
  public l(c paramc)
  {
    AppMethodBeat.i(23817);
    this.ywu = null;
    this.ouG = 15000L;
    this.ywv = false;
    this.yww = false;
    this.ywx = new Runnable()
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
    this.ywu = paramc;
    AppMethodBeat.o(23817);
  }
  
  public final void a(final long paramLong, int paramInt1, final int paramInt2, final String paramString, final p paramp)
  {
    AppMethodBeat.i(23818);
    if (this.yww)
    {
      AppMethodBeat.o(23818);
      return;
    }
    if (this.ywv)
    {
      AppMethodBeat.o(23818);
      return;
    }
    bh.baH().getWorkerHandler().removeCallbacks(this.ywx);
    bh.baH().getWorkerHandler().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23815);
        l.c(l.this).a(paramLong, paramInt2, paramString, paramp, this.ywA);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.l
 * JD-Core Version:    0.7.0.1
 */