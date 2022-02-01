package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(21547);
    try
    {
      Object localObject1;
      if (b.a(this.vbv) == null)
      {
        localObject1 = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
        b.a(this.vbv, ((PowerManager)localObject1).newWakeLock(26, "BackupPc Lock"));
      }
      if (!b.a(this.vbv).isHeld())
      {
        localObject1 = b.a(this.vbv);
        a.b(localObject1, "com/tencent/mm/plugin/backup/backuppcmodel/BackupPcModel$1", "run", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
        ((PowerManager.WakeLock)localObject1).acquire();
        a.c(localObject1, "com/tencent/mm/plugin/backup/backuppcmodel/BackupPcModel$1", "run", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(21547);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.b.1
 * JD-Core Version:    0.7.0.1
 */