package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class f$1
  implements Runnable
{
  f$1(f paramf) {}
  
  public final void run()
  {
    for (;;)
    {
      if (!f.a(this.hMe).booleanValue()) {}
      try
      {
        Thread.sleep(1000L);
        label19:
        if (f.a(this.hMe).booleanValue() == true)
        {
          y.e("MicroMsg.BackupHeartBeatHandler", "start BackupSendBackupHeartBeat thread stopped.");
          return;
        }
        long l = bk.co(f.b(this.hMe));
        y.d("MicroMsg.BackupHeartBeatHandler", "start heartBeatState[%d], heartBeatTimeStamp[%d], timeDiff[%d], hasSendHeartBeat[%b]", new Object[] { Integer.valueOf(f.c(this.hMe)), Long.valueOf(f.b(this.hMe)), Long.valueOf(l), Boolean.valueOf(f.d(this.hMe)) });
        if (!f.d(this.hMe))
        {
          if (l < f.hLX)
          {
            f.a(this.hMe, 0);
            continue;
          }
          y.e("MicroMsg.BackupHeartBeatHandler", "start send heartbeat req, heartBeatTimeStamp[%d], timeDiff[%d]", new Object[] { Long.valueOf(f.b(this.hMe)), Long.valueOf(l) });
          this.hMe.avd();
          this.hMe.avc();
          f.e(this.hMe);
          continue;
        }
        if (l < f.hLY) {
          continue;
        }
        if (f.c(this.hMe) != 1)
        {
          y.e("MicroMsg.BackupHeartBeatHandler", "start weak connect Timeout Now! heartBeatTimeStamp[%d], timeDiff[%d]", new Object[] { Long.valueOf(f.b(this.hMe)), Long.valueOf(l) });
          f.a(this.hMe, 1);
        }
        this.hMe.stop();
        return;
      }
      catch (Exception localException)
      {
        break label19;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.f.1
 * JD-Core Version:    0.7.0.1
 */