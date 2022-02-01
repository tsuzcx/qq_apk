package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public final class h
{
  static int index = 0;
  boolean aFI;
  private a rQq;
  int[] rRV;
  int rRW;
  MTimerHandler rRX;
  
  public h(a parama)
  {
    AppMethodBeat.i(21732);
    this.rRV = new int[] { 1000, 1000, 1000, 2000, 5000, 9000, 1000 };
    this.rRW = 0;
    this.aFI = false;
    this.rRX = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21731);
        if (h.a(h.this))
        {
          Log.e("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler stopped is true, index[%d]", new Object[] { Integer.valueOf(h.index) });
          h.this.rRW = 0;
          AppMethodBeat.o(21731);
          return false;
        }
        Log.i("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler start reconnect, index[%d]", new Object[] { Integer.valueOf(h.index) });
        if (h.index < h.b(h.this).length)
        {
          h.c(h.this).ctt();
          h.d(h.this).startTimer(h.b(h.this)[h.index]);
          h.bhN();
        }
        for (;;)
        {
          AppMethodBeat.o(21731);
          return false;
          h.e(h.this);
          h.this.rRW = 0;
          h.c(h.this).ctu();
        }
      }
    }, false);
    this.rQq = parama;
    AppMethodBeat.o(21732);
  }
  
  public static abstract interface a
  {
    public abstract void ctt();
    
    public abstract void ctu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.h
 * JD-Core Version:    0.7.0.1
 */