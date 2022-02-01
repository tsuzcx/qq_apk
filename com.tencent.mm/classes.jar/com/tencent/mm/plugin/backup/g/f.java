package com.tencent.mm.plugin.backup.g;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.i.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import junit.framework.Assert;

public final class f
{
  public static int nzr = 10000;
  public static int nzs = 5000;
  private int nzt = 0;
  private long nzu = 0L;
  private long nzv = 0L;
  private boolean nzw = false;
  private Boolean nzx = null;
  
  public final void bIS()
  {
    AppMethodBeat.i(21721);
    this.nzu = bt.flT();
    ad.d("MicroMsg.BackupHeartBeatHandler", "updateHeartBeatTimeStamp[%d]", new Object[] { Long.valueOf(this.nzu) });
    this.nzw = false;
    if (this.nzt != 0)
    {
      this.nzt = 0;
      start(false);
    }
    AppMethodBeat.o(21721);
  }
  
  public final void bIT()
  {
    AppMethodBeat.i(21722);
    if (this.nzv == 9223372036854775807L) {}
    for (long l = 0L;; l = this.nzv + 1L)
    {
      this.nzv = l;
      e locale = new e();
      locale.nzv = this.nzv;
      try
      {
        ad.i("MicroMsg.BackupHeartBeatHandler", "sendBackupHeartBeatRequest send heartbeat req, ack:%d", new Object[] { Long.valueOf(locale.nzv) });
        b.L(locale.toByteArray(), 9);
        AppMethodBeat.o(21722);
        return;
      }
      catch (IOException localIOException)
      {
        ad.printErrStackTrace("MicroMsg.BackupHeartBeatHandler", localIOException, "buf to BackupHeartBeatRequest err.", new Object[0]);
        AppMethodBeat.o(21722);
      }
    }
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(21724);
    if (paramBoolean) {
      if (this.nzx != null) {
        break label71;
      }
    }
    label71:
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue("New BackupHeartBeatHandler EveryTime !", paramBoolean);
      ad.i("MicroMsg.BackupHeartBeatHandler", "start backup heart beat handler.");
      bIS();
      this.nzx = Boolean.FALSE;
      com.tencent.e.h.LTJ.aU(new com.tencent.e.i.h()
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
                ad.e("MicroMsg.BackupHeartBeatHandler", "start BackupSendBackupHeartBeat thread stopped.");
                AppMethodBeat.o(21720);
                return;
              }
              long l = bt.Df(f.b(f.this));
              ad.d("MicroMsg.BackupHeartBeatHandler", "start heartBeatState[%d], heartBeatTimeStamp[%d], timeDiff[%d], hasSendHeartBeat[%b]", new Object[] { Integer.valueOf(f.c(f.this)), Long.valueOf(f.b(f.this)), Long.valueOf(l), Boolean.valueOf(f.d(f.this)) });
              if (!f.d(f.this))
              {
                if (l < f.nzr)
                {
                  f.a(f.this, 0);
                  continue;
                }
                ad.e("MicroMsg.BackupHeartBeatHandler", "start send heartbeat req, heartBeatTimeStamp[%d], timeDiff[%d]", new Object[] { Long.valueOf(f.b(f.this)), Long.valueOf(l) });
                f.this.bIT();
                f.this.bIS();
                f.e(f.this);
                continue;
              }
              if (l < f.nzs) {
                continue;
              }
              if (f.c(f.this) != 1)
              {
                ad.e("MicroMsg.BackupHeartBeatHandler", "start weak connect Timeout Now! heartBeatTimeStamp[%d], timeDiff[%d]", new Object[] { Long.valueOf(f.b(f.this)), Long.valueOf(l) });
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
      bIT();
      AppMethodBeat.o(21724);
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(21723);
    if (this.nzx != null)
    {
      ad.i("MicroMsg.BackupHeartBeatHandler", "stop");
      this.nzx = Boolean.TRUE;
    }
    AppMethodBeat.o(21723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.f
 * JD-Core Version:    0.7.0.1
 */