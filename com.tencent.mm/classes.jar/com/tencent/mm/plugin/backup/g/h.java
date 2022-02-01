package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;

public final class h
{
  static int index = 0;
  private a nDw;
  int[] nFb;
  int nFc;
  aw nFd;
  boolean stopped;
  
  public h(a parama)
  {
    AppMethodBeat.i(21732);
    this.nFb = new int[] { 1000, 1000, 1000, 2000, 5000, 9000, 1000 };
    this.nFc = 0;
    this.stopped = false;
    this.nFd = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21731);
        if (h.a(h.this))
        {
          ae.e("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler stopped is true, index[%d]", new Object[] { Integer.valueOf(h.index) });
          h.this.nFc = 0;
          AppMethodBeat.o(21731);
          return false;
        }
        ae.i("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler start reconnect, index[%d]", new Object[] { Integer.valueOf(h.index) });
        if (h.index < h.b(h.this).length)
        {
          h.c(h.this).bJo();
          aw localaw = h.d(h.this);
          long l = h.b(h.this)[h.index];
          localaw.ay(l, l);
          h.Qe();
        }
        for (;;)
        {
          AppMethodBeat.o(21731);
          return false;
          h.e(h.this);
          h.this.nFc = 0;
          h.c(h.this).bJp();
        }
      }
    }, false);
    this.nDw = parama;
    AppMethodBeat.o(21732);
  }
  
  public static abstract interface a
  {
    public abstract void bJo();
    
    public abstract void bJp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.h
 * JD-Core Version:    0.7.0.1
 */