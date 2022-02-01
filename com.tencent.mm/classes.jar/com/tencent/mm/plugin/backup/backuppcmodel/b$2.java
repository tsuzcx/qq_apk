package com.tencent.mm.plugin.backup.backuppcmodel;

import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(21548);
    try
    {
      if ((b.a(this.vbv) != null) && (b.a(this.vbv).isHeld()))
      {
        PowerManager.WakeLock localWakeLock = b.a(this.vbv);
        a.b(localWakeLock, "com/tencent/mm/plugin/backup/backuppcmodel/BackupPcModel$2", "run", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        localWakeLock.release();
        a.c(localWakeLock, "com/tencent/mm/plugin/backup/backuppcmodel/BackupPcModel$2", "run", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(21548);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.b.2
 * JD-Core Version:    0.7.0.1
 */