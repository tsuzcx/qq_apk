package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;

public final class h
{
  static int index = 0;
  private a mXE;
  int[] mZj;
  int mZk;
  au mZl;
  boolean stopped;
  
  public h(a parama)
  {
    AppMethodBeat.i(21732);
    this.mZj = new int[] { 1000, 1000, 1000, 2000, 5000, 9000, 1000 };
    this.mZk = 0;
    this.stopped = false;
    this.mZl = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21731);
        if (h.a(h.this))
        {
          ac.e("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler stopped is true, index[%d]", new Object[] { Integer.valueOf(h.index) });
          h.this.mZk = 0;
          AppMethodBeat.o(21731);
          return false;
        }
        ac.i("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler start reconnect, index[%d]", new Object[] { Integer.valueOf(h.index) });
        if (h.index < h.b(h.this).length)
        {
          h.c(h.this).bEh();
          au localau = h.d(h.this);
          long l = h.b(h.this)[h.index];
          localau.au(l, l);
          h.aBu();
        }
        for (;;)
        {
          AppMethodBeat.o(21731);
          return false;
          h.e(h.this);
          h.this.mZk = 0;
          h.c(h.this).bEi();
        }
      }
    }, false);
    this.mXE = parama;
    AppMethodBeat.o(21732);
  }
  
  public static abstract interface a
  {
    public abstract void bEh();
    
    public abstract void bEi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.h
 * JD-Core Version:    0.7.0.1
 */