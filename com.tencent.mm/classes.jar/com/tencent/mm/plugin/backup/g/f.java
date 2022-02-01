package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.i.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.io.IOException;
import junit.framework.Assert;

public final class f
{
  public static int vcW = 10000;
  public static int vcX = 5000;
  private int vcY = 0;
  private long vcZ = 0L;
  private long vda = 0L;
  private boolean vdb = false;
  private Boolean vdc = null;
  
  public final void cWF()
  {
    AppMethodBeat.i(21721);
    this.vcZ = Util.nowMilliSecond();
    Log.d("MicroMsg.BackupHeartBeatHandler", "updateHeartBeatTimeStamp[%d]", new Object[] { Long.valueOf(this.vcZ) });
    this.vdb = false;
    if (this.vcY != 0)
    {
      this.vcY = 0;
      start(false);
    }
    AppMethodBeat.o(21721);
  }
  
  public final void cWG()
  {
    AppMethodBeat.i(21722);
    if (this.vda == 9223372036854775807L) {}
    for (long l = 0L;; l = this.vda + 1L)
    {
      this.vda = l;
      e locale = new e();
      locale.vda = this.vda;
      try
      {
        Log.i("MicroMsg.BackupHeartBeatHandler", "sendBackupHeartBeatRequest send heartbeat req, ack:%d", new Object[] { Long.valueOf(locale.vda) });
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
      if (this.vdc != null) {
        break label71;
      }
    }
    label71:
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue("New BackupHeartBeatHandler EveryTime !", paramBoolean);
      Log.i("MicroMsg.BackupHeartBeatHandler", "start backup heart beat handler.");
      cWF();
      this.vdc = Boolean.FALSE;
      com.tencent.threadpool.h.ahAA.bp(new com.tencent.threadpool.i.h()
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
                if (l < f.vcW)
                {
                  f.a(f.this, 0);
                  continue;
                }
                Log.e("MicroMsg.BackupHeartBeatHandler", "start send heartbeat req, heartBeatTimeStamp[%d], timeDiff[%d]", new Object[] { Long.valueOf(f.b(f.this)), Long.valueOf(l) });
                f.this.cWG();
                f.this.cWF();
                f.e(f.this);
                continue;
              }
              if (l < f.vcX) {
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
      cWG();
      AppMethodBeat.o(21724);
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(21723);
    if (this.vdc != null)
    {
      Log.i("MicroMsg.BackupHeartBeatHandler", "stop");
      this.vdc = Boolean.TRUE;
    }
    AppMethodBeat.o(21723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.f
 * JD-Core Version:    0.7.0.1
 */