package com.tencent.mm.plugin.backup.d;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class b
  extends com.tencent.mm.plugin.backup.b.d
{
  private static b rNb;
  private d rNc;
  private c rNd;
  private a rNe;
  private com.tencent.mm.plugin.backup.c.a rNf;
  String rNg = "tickit";
  private PowerManager.WakeLock wakeLock = null;
  
  public static b csI()
  {
    AppMethodBeat.i(21292);
    if (rNb == null)
    {
      localb = new b();
      rNb = localb;
      a(localb);
    }
    b localb = rNb;
    AppMethodBeat.o(21292);
    return localb;
  }
  
  public final void crU()
  {
    rNb = null;
  }
  
  public final com.tencent.mm.plugin.backup.c.a csJ()
  {
    AppMethodBeat.i(21294);
    if (this.rNf == null) {
      this.rNf = new com.tencent.mm.plugin.backup.c.a();
    }
    com.tencent.mm.plugin.backup.c.a locala = this.rNf;
    AppMethodBeat.o(21294);
    return locala;
  }
  
  public final d csK()
  {
    AppMethodBeat.i(21295);
    if (this.rNc == null) {
      this.rNc = new d();
    }
    d locald = this.rNc;
    AppMethodBeat.o(21295);
    return locald;
  }
  
  public final c csL()
  {
    AppMethodBeat.i(21296);
    if (this.rNd == null) {
      this.rNd = new c();
    }
    c localc = this.rNd;
    AppMethodBeat.o(21296);
    return localc;
  }
  
  public final a csM()
  {
    AppMethodBeat.i(21297);
    if (this.rNe == null) {
      this.rNe = new a();
    }
    a locala = this.rNe;
    AppMethodBeat.o(21297);
    return locala;
  }
  
  public final void csa()
  {
    AppMethodBeat.i(21298);
    Log.i("MicroMsg.BackupMoveModel", "startWakeLock");
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21290);
        try
        {
          Object localObject;
          if (b.a(b.this) == null)
          {
            localObject = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
            b.a(b.this, ((PowerManager)localObject).newWakeLock(26, "BackupMove Lock"));
          }
          if (!b.a(b.this).isHeld())
          {
            localObject = b.a(b.this);
            com.tencent.mm.hellhoundlib.a.a.b(localObject, "com/tencent/mm/plugin/backup/backupmovemodel/BackupMoveModel$2", "run", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
            ((PowerManager.WakeLock)localObject).acquire();
            com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/backup/backupmovemodel/BackupMoveModel$2", "run", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
          }
          AppMethodBeat.o(21290);
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(21290);
        }
      }
    });
    AppMethodBeat.o(21298);
  }
  
  public final void csb()
  {
    AppMethodBeat.i(21299);
    Log.i("MicroMsg.BackupMoveModel", "stopWakeLock");
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21291);
        try
        {
          if ((b.a(b.this) != null) && (b.a(b.this).isHeld()))
          {
            PowerManager.WakeLock localWakeLock = b.a(b.this);
            com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/mm/plugin/backup/backupmovemodel/BackupMoveModel$3", "run", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
            localWakeLock.release();
            com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mm/plugin/backup/backupmovemodel/BackupMoveModel$3", "run", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
          }
          AppMethodBeat.o(21291);
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(21291);
        }
      }
    }, 15000L);
    AppMethodBeat.o(21299);
  }
  
  public final void n(Object... paramVarArgs)
  {
    AppMethodBeat.i(21293);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21289);
        Object localObject = b.csI().csL();
        String str = this.val$url;
        Log.w("MicroMsg.BackupMoveRecoverServer", "~~~~~~~~~~~~  start by url:%s", new Object[] { str });
        if (((n)h.ae(n.class)).bco().eSi()) {
          bq.beT();
        }
        com.tencent.mm.plugin.backup.g.b.ctJ();
        bh.aGY().a(595, ((c)localObject).rNK);
        localObject = new e(str);
        bh.aGY().a((q)localObject, 0);
        AppMethodBeat.o(21289);
      }
    });
    AppMethodBeat.o(21293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.b
 * JD-Core Version:    0.7.0.1
 */