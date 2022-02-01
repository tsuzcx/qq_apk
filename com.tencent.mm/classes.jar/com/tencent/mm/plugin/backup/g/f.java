package com.tencent.mm.plugin.backup.g;

import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.i.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import junit.framework.Assert;

public final class f
{
  public static int oPJ = 10000;
  public static int oPK = 5000;
  private int oPL = 0;
  private long oPM = 0L;
  private long oPN = 0L;
  private boolean oPO = false;
  private Boolean oPP = null;
  
  public final void cgJ()
  {
    AppMethodBeat.i(21721);
    this.oPM = Util.nowMilliSecond();
    Log.d("MicroMsg.BackupHeartBeatHandler", "updateHeartBeatTimeStamp[%d]", new Object[] { Long.valueOf(this.oPM) });
    this.oPO = false;
    if (this.oPL != 0)
    {
      this.oPL = 0;
      start(false);
    }
    AppMethodBeat.o(21721);
  }
  
  public final void cgK()
  {
    AppMethodBeat.i(21722);
    if (this.oPN == 9223372036854775807L) {}
    for (long l = 0L;; l = this.oPN + 1L)
    {
      this.oPN = l;
      e locale = new e();
      locale.oPN = this.oPN;
      try
      {
        Log.i("MicroMsg.BackupHeartBeatHandler", "sendBackupHeartBeatRequest send heartbeat req, ack:%d", new Object[] { Long.valueOf(locale.oPN) });
        b.N(locale.toByteArray(), 9);
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
      if (this.oPP != null) {
        break label71;
      }
    }
    label71:
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue("New BackupHeartBeatHandler EveryTime !", paramBoolean);
      Log.i("MicroMsg.BackupHeartBeatHandler", "start backup heart beat handler.");
      cgJ();
      this.oPP = Boolean.FALSE;
      com.tencent.f.h.RTc.ba(new com.tencent.f.i.h()
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
                if (l < f.oPJ)
                {
                  f.a(f.this, 0);
                  continue;
                }
                Log.e("MicroMsg.BackupHeartBeatHandler", "start send heartbeat req, heartBeatTimeStamp[%d], timeDiff[%d]", new Object[] { Long.valueOf(f.b(f.this)), Long.valueOf(l) });
                f.this.cgK();
                f.this.cgJ();
                f.e(f.this);
                continue;
              }
              if (l < f.oPK) {
                continue;
              }
              if (f.c(f.this) != 1)
              {
                Log.e("MicroMsg.BackupHeartBeatHandler", "start weak connect Timeout Now! heartBeatTimeStamp[%d], timeDiff[%d]", new Object[] { Long.valueOf(f.b(f.this)), Long.valueOf(l) });
                f.a(f.this, 1);
              }
              f.this.stop();
              AppMethodBeat.o(21720);
              return;
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
      cgK();
      AppMethodBeat.o(21724);
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(21723);
    if (this.oPP != null)
    {
      Log.i("MicroMsg.BackupHeartBeatHandler", "stop");
      this.oPP = Boolean.TRUE;
    }
    AppMethodBeat.o(21723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.f
 * JD-Core Version:    0.7.0.1
 */