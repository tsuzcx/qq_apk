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
  public static int mwT = 10000;
  public static int mwU = 5000;
  private int mwV = 0;
  private long mwW = 0L;
  private long mwX = 0L;
  private boolean mwY = false;
  private Boolean mwZ = null;
  
  public final void bxN()
  {
    AppMethodBeat.i(21721);
    this.mwW = bt.eGO();
    ad.d("MicroMsg.BackupHeartBeatHandler", "updateHeartBeatTimeStamp[%d]", new Object[] { Long.valueOf(this.mwW) });
    this.mwY = false;
    if (this.mwV != 0)
    {
      this.mwV = 0;
      start(false);
    }
    AppMethodBeat.o(21721);
  }
  
  public final void bxO()
  {
    AppMethodBeat.i(21722);
    if (this.mwX == 9223372036854775807L) {}
    for (long l = 0L;; l = this.mwX + 1L)
    {
      this.mwX = l;
      e locale = new e();
      locale.mwX = this.mwX;
      try
      {
        ad.i("MicroMsg.BackupHeartBeatHandler", "sendBackupHeartBeatRequest send heartbeat req, ack:%d", new Object[] { Long.valueOf(locale.mwX) });
        b.N(locale.toByteArray(), 9);
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
      if (this.mwZ != null) {
        break label71;
      }
    }
    label71:
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue("New BackupHeartBeatHandler EveryTime !", paramBoolean);
      ad.i("MicroMsg.BackupHeartBeatHandler", "start backup heart beat handler.");
      bxN();
      this.mwZ = Boolean.FALSE;
      com.tencent.e.h.Iye.aS(new com.tencent.e.i.h()
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
              long l = bt.vM(f.b(f.this));
              ad.d("MicroMsg.BackupHeartBeatHandler", "start heartBeatState[%d], heartBeatTimeStamp[%d], timeDiff[%d], hasSendHeartBeat[%b]", new Object[] { Integer.valueOf(f.c(f.this)), Long.valueOf(f.b(f.this)), Long.valueOf(l), Boolean.valueOf(f.d(f.this)) });
              if (!f.d(f.this))
              {
                if (l < f.mwT)
                {
                  f.a(f.this, 0);
                  continue;
                }
                ad.e("MicroMsg.BackupHeartBeatHandler", "start send heartbeat req, heartBeatTimeStamp[%d], timeDiff[%d]", new Object[] { Long.valueOf(f.b(f.this)), Long.valueOf(l) });
                f.this.bxO();
                f.this.bxN();
                f.e(f.this);
                continue;
              }
              if (l < f.mwU) {
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
      bxO();
      AppMethodBeat.o(21724);
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(21723);
    if (this.mwZ != null)
    {
      ad.i("MicroMsg.BackupHeartBeatHandler", "stop");
      this.mwZ = Boolean.TRUE;
    }
    AppMethodBeat.o(21723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.f
 * JD-Core Version:    0.7.0.1
 */