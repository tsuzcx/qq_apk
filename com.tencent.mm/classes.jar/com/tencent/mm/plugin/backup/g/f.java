package com.tencent.mm.plugin.backup.g;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.i.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.IOException;
import junit.framework.Assert;

public final class f
{
  public static int nEM = 10000;
  public static int nEN = 5000;
  private int nEO = 0;
  private long nEP = 0L;
  private long nEQ = 0L;
  private boolean nER = false;
  private Boolean nES = null;
  
  public final void bJQ()
  {
    AppMethodBeat.i(21721);
    this.nEP = bu.fpO();
    ae.d("MicroMsg.BackupHeartBeatHandler", "updateHeartBeatTimeStamp[%d]", new Object[] { Long.valueOf(this.nEP) });
    this.nER = false;
    if (this.nEO != 0)
    {
      this.nEO = 0;
      start(false);
    }
    AppMethodBeat.o(21721);
  }
  
  public final void bJR()
  {
    AppMethodBeat.i(21722);
    if (this.nEQ == 9223372036854775807L) {}
    for (long l = 0L;; l = this.nEQ + 1L)
    {
      this.nEQ = l;
      e locale = new e();
      locale.nEQ = this.nEQ;
      try
      {
        ae.i("MicroMsg.BackupHeartBeatHandler", "sendBackupHeartBeatRequest send heartbeat req, ack:%d", new Object[] { Long.valueOf(locale.nEQ) });
        b.L(locale.toByteArray(), 9);
        AppMethodBeat.o(21722);
        return;
      }
      catch (IOException localIOException)
      {
        ae.printErrStackTrace("MicroMsg.BackupHeartBeatHandler", localIOException, "buf to BackupHeartBeatRequest err.", new Object[0]);
        AppMethodBeat.o(21722);
      }
    }
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(21724);
    if (paramBoolean) {
      if (this.nES != null) {
        break label71;
      }
    }
    label71:
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue("New BackupHeartBeatHandler EveryTime !", paramBoolean);
      ae.i("MicroMsg.BackupHeartBeatHandler", "start backup heart beat handler.");
      bJQ();
      this.nES = Boolean.FALSE;
      com.tencent.e.h.MqF.aR(new com.tencent.e.i.h()
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
                ae.e("MicroMsg.BackupHeartBeatHandler", "start BackupSendBackupHeartBeat thread stopped.");
                AppMethodBeat.o(21720);
                return;
              }
              long l = bu.DD(f.b(f.this));
              ae.d("MicroMsg.BackupHeartBeatHandler", "start heartBeatState[%d], heartBeatTimeStamp[%d], timeDiff[%d], hasSendHeartBeat[%b]", new Object[] { Integer.valueOf(f.c(f.this)), Long.valueOf(f.b(f.this)), Long.valueOf(l), Boolean.valueOf(f.d(f.this)) });
              if (!f.d(f.this))
              {
                if (l < f.nEM)
                {
                  f.a(f.this, 0);
                  continue;
                }
                ae.e("MicroMsg.BackupHeartBeatHandler", "start send heartbeat req, heartBeatTimeStamp[%d], timeDiff[%d]", new Object[] { Long.valueOf(f.b(f.this)), Long.valueOf(l) });
                f.this.bJR();
                f.this.bJQ();
                f.e(f.this);
                continue;
              }
              if (l < f.nEN) {
                continue;
              }
              if (f.c(f.this) != 1)
              {
                ae.e("MicroMsg.BackupHeartBeatHandler", "start weak connect Timeout Now! heartBeatTimeStamp[%d], timeDiff[%d]", new Object[] { Long.valueOf(f.b(f.this)), Long.valueOf(l) });
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
      bJR();
      AppMethodBeat.o(21724);
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(21723);
    if (this.nES != null)
    {
      ae.i("MicroMsg.BackupHeartBeatHandler", "stop");
      this.nES = Boolean.TRUE;
    }
    AppMethodBeat.o(21723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.f
 * JD-Core Version:    0.7.0.1
 */