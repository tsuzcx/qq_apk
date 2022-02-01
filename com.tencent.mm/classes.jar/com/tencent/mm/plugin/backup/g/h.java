package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;

public final class h
{
  static int index = 0;
  private a nyb;
  int[] nzG;
  int nzH;
  av nzI;
  boolean stopped;
  
  public h(a parama)
  {
    AppMethodBeat.i(21732);
    this.nzG = new int[] { 1000, 1000, 1000, 2000, 5000, 9000, 1000 };
    this.nzH = 0;
    this.stopped = false;
    this.nzI = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21731);
        if (h.a(h.this))
        {
          ad.e("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler stopped is true, index[%d]", new Object[] { Integer.valueOf(h.index) });
          h.this.nzH = 0;
          AppMethodBeat.o(21731);
          return false;
        }
        ad.i("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler start reconnect, index[%d]", new Object[] { Integer.valueOf(h.index) });
        if (h.index < h.b(h.this).length)
        {
          h.c(h.this).bIq();
          av localav = h.d(h.this);
          long l = h.b(h.this)[h.index];
          localav.az(l, l);
          h.Qf();
        }
        for (;;)
        {
          AppMethodBeat.o(21731);
          return false;
          h.e(h.this);
          h.this.nzH = 0;
          h.c(h.this).bIr();
        }
      }
    }, false);
    this.nyb = parama;
    AppMethodBeat.o(21732);
  }
  
  public static abstract interface a
  {
    public abstract void bIq();
    
    public abstract void bIr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.h
 * JD-Core Version:    0.7.0.1
 */