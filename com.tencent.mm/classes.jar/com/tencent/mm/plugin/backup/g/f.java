package com.tencent.mm.plugin.backup.g;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.i.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import junit.framework.Assert;

public final class f
{
  public static int rRG = 10000;
  public static int rRH = 5000;
  private int rRI = 0;
  private long rRJ = 0L;
  private long rRK = 0L;
  private boolean rRL = false;
  private Boolean rRM = null;
  
  public final void ctV()
  {
    AppMethodBeat.i(21721);
    this.rRJ = Util.nowMilliSecond();
    Log.d("MicroMsg.BackupHeartBeatHandler", "updateHeartBeatTimeStamp[%d]", new Object[] { Long.valueOf(this.rRJ) });
    this.rRL = false;
    if (this.rRI != 0)
    {
      this.rRI = 0;
      start(false);
    }
    AppMethodBeat.o(21721);
  }
  
  public final void ctW()
  {
    AppMethodBeat.i(21722);
    if (this.rRK == 9223372036854775807L) {}
    for (long l = 0L;; l = this.rRK + 1L)
    {
      this.rRK = l;
      e locale = new e();
      locale.rRK = this.rRK;
      try
      {
        Log.i("MicroMsg.BackupHeartBeatHandler", "sendBackupHeartBeatRequest send heartbeat req, ack:%d", new Object[] { Long.valueOf(locale.rRK) });
        b.O(locale.toByteArray(), 9);
        AppMethodBeat.o(21722);
        return;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.BackupHeartBeatHandler", localIOException, "buf to BackupHeartBeatRequest err.", new Object[0]);
        AppMethodBeat.o(21722);
      }
    }
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(21724);
    if (paramBoolean) {
      if (this.rRM != null) {
        break label71;
      }
    }
    label71:
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue("New BackupHeartBeatHandler EveryTime !", paramBoolean);
      Log.i("MicroMsg.BackupHeartBeatHandler", "start backup heart beat handler.");
      ctV();
      this.rRM = Boolean.FALSE;
      com.tencent.e.h.ZvG.bh(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "BackupSendBackupHeartBeat";
        }
        
        public final void run()
        {
          AppMethodBeat.i(21720);
          for (;;)
          {
            if (!f.a(f.this).booleanValue()) {}
            try
            {
              Thread.sleep(1000L);
              label25:
              if (f.a(f.this).booleanValue() == true)
              {
                Log.e("MicroMsg.BackupHeartBeatHandler", "start BackupSendBackupHeartBeat thread stopped.");
                AppMethodBeat.o(21720);
                return;
              }
              long l = Util.milliSecondsToNow(f.b(f.this));
              Log.d("MicroMsg.BackupHeartBeatHandler", "start heartBeatState[%d], heartBeatTimeStamp[%d], timeDiff[%d], hasSendHeartBeat[%b]", new Object[] { Integer.valueOf(f.c(f.this)), Long.valueOf(f.b(f.this)), Long.valueOf(l), Boolean.valueOf(f.d(f.this)) });
              if (!f.d(f.this))
              {
                if (l < f.rRG)
                {
                  f.a(f.this, 0);
                  continue;
                }
                Log.e("MicroMsg.BackupHeartBeatHandler", "start send heartbeat req, heartBeatTimeStamp[%d], timeDiff[%d]", new Object[] { Long.valueOf(f.b(f.this)), Long.valueOf(l) });
                f.this.ctW();
                f.this.ctV();
                f.e(f.this);
                continue;
              }
              if (l < f.rRH) {
                continue;
              }
              if (f.c(f.this) != 1)
              {
                Log.e("MicroMsg.BackupHeartBeatHandler", "start weak connect Timeout Now! heartBeatTimeStamp[%d], timeDiff[%d]", new Object[] { Long.valueOf(f.b(f.this)), Long.valueOf(l) });
                f.a(f.this, 1);
                AppMethodBeat.o(21720);
                return;
              }
              AppMethodBeat.o(21720);
              return;
            }
            catch (Exception localException)
            {
              break label25;
            }
          }
        }
      });
      ctW();
      AppMethodBeat.o(21724);
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(21723);
    if (this.rRM != null)
    {
      Log.i("MicroMsg.BackupHeartBeatHandler", "stop");
      this.rRM = Boolean.TRUE;
    }
    AppMethodBeat.o(21723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.f
 * JD-Core Version:    0.7.0.1
 */