package com.tencent.mm.plugin.backup.backuppcmodel;

import android.os.Looper;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class b
  extends com.tencent.mm.plugin.backup.b.d
{
  private static b vbq;
  private com.tencent.mm.plugin.backup.c.a uYt;
  private c vbr;
  private e vbs;
  private d vbt;
  private a vbu;
  private PowerManager.WakeLock wakeLock = null;
  
  public static b cVW()
  {
    AppMethodBeat.i(21549);
    if (vbq == null)
    {
      localb = new b();
      vbq = localb;
      a(localb);
    }
    b localb = vbq;
    AppMethodBeat.o(21549);
    return localb;
  }
  
  public final void cUE()
  {
    vbq = null;
  }
  
  public final void cUK()
  {
    AppMethodBeat.i(21556);
    Log.i("MicroMsg.BackupPcModel", "startWakeLock");
    MMHandlerThread.postToMainThread(new b.1(this));
    AppMethodBeat.o(21556);
  }
  
  public final void cUL()
  {
    AppMethodBeat.i(21557);
    Log.i("MicroMsg.BackupPcModel", "stopWakeLock");
    MMHandlerThread.postToMainThread(new b.2(this));
    AppMethodBeat.o(21557);
  }
  
  public final c cVX()
  {
    AppMethodBeat.i(21552);
    if (this.vbr == null) {
      this.vbr = new c();
    }
    c localc = this.vbr;
    AppMethodBeat.o(21552);
    return localc;
  }
  
  public final e cVY()
  {
    AppMethodBeat.i(21553);
    if (this.vbs == null) {
      this.vbs = new e();
    }
    e locale = this.vbs;
    AppMethodBeat.o(21553);
    return locale;
  }
  
  public final d cVZ()
  {
    AppMethodBeat.i(21554);
    if (this.vbt == null) {
      this.vbt = new d();
    }
    d locald = this.vbt;
    AppMethodBeat.o(21554);
    return locald;
  }
  
  public final com.tencent.mm.plugin.backup.c.a cVt()
  {
    AppMethodBeat.i(21551);
    if (this.uYt == null) {
      this.uYt = new com.tencent.mm.plugin.backup.c.a();
    }
    com.tencent.mm.plugin.backup.c.a locala = this.uYt;
    AppMethodBeat.o(21551);
    return locala;
  }
  
  public final a cWa()
  {
    AppMethodBeat.i(21555);
    if (this.vbu == null) {
      this.vbu = new a();
    }
    a locala = this.vbu;
    AppMethodBeat.o(21555);
    return locala;
  }
  
  public final void p(Object... paramVarArgs)
  {
    AppMethodBeat.i(21550);
    ((Boolean)paramVarArgs[0]).booleanValue();
    paramVarArgs = cVW().cVX();
    new MMHandler(Looper.getMainLooper()).postDelayed(new c.6(paramVarArgs), 100L);
    AppMethodBeat.o(21550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.b
 * JD-Core Version:    0.7.0.1
 */