package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.i.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import junit.framework.Assert;

public final class f
{
  public static int jFA = 5000;
  public static int jFz = 10000;
  private int jFB = 0;
  private long jFC = 0L;
  private long jFD = 0L;
  private boolean jFE = false;
  private Boolean jFF = null;
  
  public final void aUE()
  {
    AppMethodBeat.i(17662);
    this.jFC = bo.aoy();
    ab.d("MicroMsg.BackupHeartBeatHandler", "updateHeartBeatTimeStamp[%d]", new Object[] { Long.valueOf(this.jFC) });
    this.jFE = false;
    if (this.jFB != 0)
    {
      this.jFB = 0;
      start(false);
    }
    AppMethodBeat.o(17662);
  }
  
  public final void aUF()
  {
    AppMethodBeat.i(17663);
    if (this.jFD == 9223372036854775807L) {}
    for (long l = 0L;; l = this.jFD + 1L)
    {
      this.jFD = l;
      e locale = new e();
      locale.jFD = this.jFD;
      try
      {
        ab.i("MicroMsg.BackupHeartBeatHandler", "sendBackupHeartBeatRequest send heartbeat req, ack:%d", new Object[] { Long.valueOf(locale.jFD) });
        b.J(locale.toByteArray(), 9);
        AppMethodBeat.o(17663);
        return;
      }
      catch (IOException localIOException)
      {
        ab.printErrStackTrace("MicroMsg.BackupHeartBeatHandler", localIOException, "buf to BackupHeartBeatRequest err.", new Object[0]);
        AppMethodBeat.o(17663);
      }
    }
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(17665);
    if (paramBoolean) {
      if (this.jFF != null) {
        break label70;
      }
    }
    label70:
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue("New BackupHeartBeatHandler EveryTime !", paramBoolean);
      ab.i("MicroMsg.BackupHeartBeatHandler", "start backup heart beat handler.");
      aUE();
      this.jFF = Boolean.FALSE;
      d.h(new f.1(this), "BackupSendBackupHeartBeat").start();
      aUF();
      AppMethodBeat.o(17665);
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(17664);
    if (this.jFF != null)
    {
      ab.i("MicroMsg.BackupHeartBeatHandler", "stop");
      this.jFF = Boolean.TRUE;
    }
    AppMethodBeat.o(17664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.f
 * JD-Core Version:    0.7.0.1
 */