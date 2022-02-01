package com.tencent.mm.plugin.backup.g;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;
import junit.framework.Assert;

public final class f
{
  public static int mYU = 10000;
  public static int mYV = 5000;
  private int mYW = 0;
  private long mYX = 0L;
  private long mYY = 0L;
  private boolean mYZ = false;
  private Boolean mZa = null;
  
  public final void bEJ()
  {
    AppMethodBeat.i(21721);
    this.mYX = bs.eWj();
    ac.d("MicroMsg.BackupHeartBeatHandler", "updateHeartBeatTimeStamp[%d]", new Object[] { Long.valueOf(this.mYX) });
    this.mYZ = false;
    if (this.mYW != 0)
    {
      this.mYW = 0;
      start(false);
    }
    AppMethodBeat.o(21721);
  }
  
  public final void bEK()
  {
    AppMethodBeat.i(21722);
    if (this.mYY == 9223372036854775807L) {}
    for (long l = 0L;; l = this.mYY + 1L)
    {
      this.mYY = l;
      e locale = new e();
      locale.mYY = this.mYY;
      try
      {
        ac.i("MicroMsg.BackupHeartBeatHandler", "sendBackupHeartBeatRequest send heartbeat req, ack:%d", new Object[] { Long.valueOf(locale.mYY) });
        b.L(locale.toByteArray(), 9);
        AppMethodBeat.o(21722);
        return;
      }
      catch (IOException localIOException)
      {
        ac.printErrStackTrace("MicroMsg.BackupHeartBeatHandler", localIOException, "buf to BackupHeartBeatRequest err.", new Object[0]);
        AppMethodBeat.o(21722);
      }
    }
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(21724);
    if (paramBoolean) {
      if (this.mZa != null) {
        break label71;
      }
    }
    label71:
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue("New BackupHeartBeatHandler EveryTime !", paramBoolean);
      ac.i("MicroMsg.BackupHeartBeatHandler", "start backup heart beat handler.");
      bEJ();
      this.mZa = Boolean.FALSE;
      com.tencent.e.h.JZN.aV(new com.tencent.e.i.h()
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
                ac.e("MicroMsg.BackupHeartBeatHandler", "start BackupSendBackupHeartBeat thread stopped.");
                AppMethodBeat.o(21720);
                return;
              }
              long l = bs.Ap(f.b(f.this));
              ac.d("MicroMsg.BackupHeartBeatHandler", "start heartBeatState[%d], heartBeatTimeStamp[%d], timeDiff[%d], hasSendHeartBeat[%b]", new Object[] { Integer.valueOf(f.c(f.this)), Long.valueOf(f.b(f.this)), Long.valueOf(l), Boolean.valueOf(f.d(f.this)) });
              if (!f.d(f.this))
              {
                if (l < f.mYU)
                {
                  f.a(f.this, 0);
                  continue;
                }
                ac.e("MicroMsg.BackupHeartBeatHandler", "start send heartbeat req, heartBeatTimeStamp[%d], timeDiff[%d]", new Object[] { Long.valueOf(f.b(f.this)), Long.valueOf(l) });
                f.this.bEK();
                f.this.bEJ();
                f.e(f.this);
                continue;
              }
              if (l < f.mYV) {
                continue;
              }
              if (f.c(f.this) != 1)
              {
                ac.e("MicroMsg.BackupHeartBeatHandler", "start weak connect Timeout Now! heartBeatTimeStamp[%d], timeDiff[%d]", new Object[] { Long.valueOf(f.b(f.this)), Long.valueOf(l) });
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
      bEK();
      AppMethodBeat.o(21724);
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(21723);
    if (this.mZa != null)
    {
      ac.i("MicroMsg.BackupHeartBeatHandler", "stop");
      this.mZa = Boolean.TRUE;
    }
    AppMethodBeat.o(21723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.f
 * JD-Core Version:    0.7.0.1
 */