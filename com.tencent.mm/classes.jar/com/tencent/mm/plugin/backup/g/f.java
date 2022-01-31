package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import junit.framework.Assert;

public final class f
{
  public static int hLX = 10000;
  public static int hLY = 5000;
  private int hLZ = 0;
  private long hMa = 0L;
  private long hMb = 0L;
  private boolean hMc = false;
  private Boolean hMd = null;
  
  public final void avc()
  {
    this.hMa = bk.UY();
    y.d("MicroMsg.BackupHeartBeatHandler", "updateHeartBeatTimeStamp[%d]", new Object[] { Long.valueOf(this.hMa) });
    this.hMc = false;
    if (this.hLZ != 0)
    {
      this.hLZ = 0;
      eg(false);
    }
  }
  
  public final void avd()
  {
    if (this.hMb == 9223372036854775807L) {}
    for (long l = 0L;; l = this.hMb + 1L)
    {
      this.hMb = l;
      com.tencent.mm.plugin.backup.i.e locale = new com.tencent.mm.plugin.backup.i.e();
      locale.hMb = this.hMb;
      try
      {
        y.i("MicroMsg.BackupHeartBeatHandler", "sendBackupHeartBeatRequest send heartbeat req, ack:%d", new Object[] { Long.valueOf(locale.hMb) });
        b.I(locale.toByteArray(), 9);
        return;
      }
      catch (IOException localIOException)
      {
        y.printErrStackTrace("MicroMsg.BackupHeartBeatHandler", localIOException, "buf to BackupHeartBeatRequest err.", new Object[0]);
      }
    }
  }
  
  public final void eg(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.hMd != null) {
        break label59;
      }
    }
    label59:
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue("New BackupHeartBeatHandler EveryTime !", paramBoolean);
      y.i("MicroMsg.BackupHeartBeatHandler", "start backup heart beat handler.");
      avc();
      this.hMd = Boolean.valueOf(false);
      com.tencent.mm.sdk.f.e.b(new f.1(this), "BackupSendBackupHeartBeat").start();
      avd();
      return;
    }
  }
  
  public final void stop()
  {
    if (this.hMd != null)
    {
      y.i("MicroMsg.BackupHeartBeatHandler", "stop");
      this.hMd = Boolean.valueOf(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.f
 * JD-Core Version:    0.7.0.1
 */