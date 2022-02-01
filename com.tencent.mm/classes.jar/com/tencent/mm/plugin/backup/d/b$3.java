package com.tencent.mm.plugin.backup.d;

import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;

final class b$3
  implements Runnable
{
  b$3(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(21291);
    try
    {
      if ((b.a(this.uYv) != null) && (b.a(this.uYv).isHeld()))
      {
        PowerManager.WakeLock localWakeLock = b.a(this.uYv);
        a.b(localWakeLock, "com/tencent/mm/plugin/backup/backupmovemodel/BackupMoveModel$3", "run", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        localWakeLock.release();
        a.c(localWakeLock, "com/tencent/mm/plugin/backup/backupmovemodel/BackupMoveModel$3", "run", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(21291);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.b.3
 * JD-Core Version:    0.7.0.1
 */