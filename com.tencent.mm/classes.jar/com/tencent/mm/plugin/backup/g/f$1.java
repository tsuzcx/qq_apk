package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class f$1
  implements Runnable
{
  f$1(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(17661);
    for (;;)
    {
      if (!f.a(this.jFG).booleanValue()) {}
      try
      {
        Thread.sleep(1000L);
        label25:
        if (f.a(this.jFG).booleanValue() == true)
        {
          ab.e("MicroMsg.BackupHeartBeatHandler", "start BackupSendBackupHeartBeat thread stopped.");
          AppMethodBeat.o(17661);
          return;
        }
        long l = bo.hl(f.b(this.jFG));
        ab.d("MicroMsg.BackupHeartBeatHandler", "start heartBeatState[%d], heartBeatTimeStamp[%d], timeDiff[%d], hasSendHeartBeat[%b]", new Object[] { Integer.valueOf(f.c(this.jFG)), Long.valueOf(f.b(this.jFG)), Long.valueOf(l), Boolean.valueOf(f.d(this.jFG)) });
        if (!f.d(this.jFG))
        {
          if (l < f.jFz)
          {
            f.a(this.jFG, 0);
            continue;
          }
          ab.e("MicroMsg.BackupHeartBeatHandler", "start send heartbeat req, heartBeatTimeStamp[%d], timeDiff[%d]", new Object[] { Long.valueOf(f.b(this.jFG)), Long.valueOf(l) });
          this.jFG.aUF();
          this.jFG.aUE();
          f.e(this.jFG);
          continue;
        }
        if (l < f.jFA) {
          continue;
        }
        if (f.c(this.jFG) != 1)
        {
          ab.e("MicroMsg.BackupHeartBeatHandler", "start weak connect Timeout Now! heartBeatTimeStamp[%d], timeDiff[%d]", new Object[] { Long.valueOf(f.b(this.jFG)), Long.valueOf(l) });
          f.a(this.jFG, 1);
        }
        this.jFG.stop();
        AppMethodBeat.o(17661);
        return;
        AppMethodBeat.o(17661);
        return;
      }
      catch (Exception localException)
      {
        break label25;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.f.1
 * JD-Core Version:    0.7.0.1
 */