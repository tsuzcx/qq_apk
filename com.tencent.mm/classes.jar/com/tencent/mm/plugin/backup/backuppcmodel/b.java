package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.Context;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class b
  extends com.tencent.mm.plugin.backup.b.d
{
  private static b rQb;
  private com.tencent.mm.plugin.backup.c.a rNf;
  private c rQc;
  private e rQd;
  private d rQe;
  private a rQf;
  private PowerManager.WakeLock wakeLock = null;
  
  public static b ctm()
  {
    AppMethodBeat.i(21549);
    if (rQb == null)
    {
      localb = new b();
      rQb = localb;
      a(localb);
    }
    b localb = rQb;
    AppMethodBeat.o(21549);
    return localb;
  }
  
  public final void crU()
  {
    rQb = null;
  }
  
  public final com.tencent.mm.plugin.backup.c.a csJ()
  {
    AppMethodBeat.i(21551);
    if (this.rNf == null) {
      this.rNf = new com.tencent.mm.plugin.backup.c.a();
    }
    com.tencent.mm.plugin.backup.c.a locala = this.rNf;
    AppMethodBeat.o(21551);
    return locala;
  }
  
  public final void csa()
  {
    AppMethodBeat.i(21556);
    Log.i("MicroMsg.BackupPcModel", "startWakeLock");
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21547);
        try
        {
          Object localObject;
          if (b.a(b.this) == null)
          {
            localObject = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
            b.a(b.this, ((PowerManager)localObject).newWakeLock(26, "BackupPc Lock"));
          }
          if (!b.a(b.this).isHeld())
          {
            localObject = b.a(b.this);
            com.tencent.mm.hellhoundlib.a.a.b(localObject, "com/tencent/mm/plugin/backup/backuppcmodel/BackupPcModel$1", "run", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
            ((PowerManager.WakeLock)localObject).acquire();
            com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/backup/backuppcmodel/BackupPcModel$1", "run", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
          }
          AppMethodBeat.o(21547);
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(21547);
        }
      }
    });
    AppMethodBeat.o(21556);
  }
  
  public final void csb()
  {
    AppMethodBeat.i(21557);
    Log.i("MicroMsg.BackupPcModel", "stopWakeLock");
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21548);
        try
        {
          if ((b.a(b.this) != null) && (b.a(b.this).isHeld()))
          {
            PowerManager.WakeLock localWakeLock = b.a(b.this);
            com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/mm/plugin/backup/backuppcmodel/BackupPcModel$2", "run", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
            localWakeLock.release();
            com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mm/plugin/backup/backuppcmodel/BackupPcModel$2", "run", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
          }
          AppMethodBeat.o(21548);
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(21548);
        }
      }
    });
    AppMethodBeat.o(21557);
  }
  
  public final c ctn()
  {
    AppMethodBeat.i(21552);
    if (this.rQc == null) {
      this.rQc = new c();
    }
    c localc = this.rQc;
    AppMethodBeat.o(21552);
    return localc;
  }
  
  public final e cto()
  {
    AppMethodBeat.i(21553);
    if (this.rQd == null) {
      this.rQd = new e();
    }
    e locale = this.rQd;
    AppMethodBeat.o(21553);
    return locale;
  }
  
  public final d ctp()
  {
    AppMethodBeat.i(21554);
    if (this.rQe == null) {
      this.rQe = new d();
    }
    d locald = this.rQe;
    AppMethodBeat.o(21554);
    return locald;
  }
  
  public final a ctq()
  {
    AppMethodBeat.i(21555);
    if (this.rQf == null) {
      this.rQf = new a();
    }
    a locala = this.rQf;
    AppMethodBeat.o(21555);
    return locala;
  }
  
  public final void n(Object... paramVarArgs)
  {
    AppMethodBeat.i(21550);
    ((Boolean)paramVarArgs[0]).booleanValue();
    paramVarArgs = ctm().ctn();
    new MMHandler(Looper.getMainLooper()).postDelayed(new c.6(paramVarArgs), 100L);
    AppMethodBeat.o(21550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.b
 * JD-Core Version:    0.7.0.1
 */