package com.tencent.mm.plugin.backup.d;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(21290);
    try
    {
      Object localObject1;
      if (b.a(this.uYv) == null)
      {
        localObject1 = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
        b.a(this.uYv, ((PowerManager)localObject1).newWakeLock(26, "BackupMove Lock"));
      }
      if (!b.a(this.uYv).isHeld())
      {
        localObject1 = b.a(this.uYv);
        a.b(localObject1, "com/tencent/mm/plugin/backup/backupmovemodel/BackupMoveModel$2", "run", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
        ((PowerManager.WakeLock)localObject1).acquire();
        a.c(localObject1, "com/tencent/mm/plugin/backup/backupmovemodel/BackupMoveModel$2", "run", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(21290);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.b.2
 * JD-Core Version:    0.7.0.1
 */