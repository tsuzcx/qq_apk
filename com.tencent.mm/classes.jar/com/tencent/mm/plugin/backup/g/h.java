package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public final class h
{
  static int index = 0;
  private a oOt;
  int[] oPY;
  int oPZ;
  MTimerHandler oQa;
  boolean stopped;
  
  public h(a parama)
  {
    AppMethodBeat.i(21732);
    this.oPY = new int[] { 1000, 1000, 1000, 2000, 5000, 9000, 1000 };
    this.oPZ = 0;
    this.stopped = false;
    this.oQa = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21731);
        if (h.a(h.this))
        {
          Log.e("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler stopped is true, index[%d]", new Object[] { Integer.valueOf(h.index) });
          h.this.oPZ = 0;
          AppMethodBeat.o(21731);
          return false;
        }
        Log.i("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler start reconnect, index[%d]", new Object[] { Integer.valueOf(h.index) });
        if (h.index < h.b(h.this).length)
        {
          h.c(h.this).cgh();
          h.d(h.this).startTimer(h.b(h.this)[h.index]);
          h.aYz();
        }
        for (;;)
        {
          AppMethodBeat.o(21731);
          return false;
          h.e(h.this);
          h.this.oPZ = 0;
          h.c(h.this).cgi();
        }
      }
    }, false);
    this.oOt = parama;
    AppMethodBeat.o(21732);
  }
  
  public static abstract interface a
  {
    public abstract void cgh();
    
    public abstract void cgi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.h
 * JD-Core Version:    0.7.0.1
 */