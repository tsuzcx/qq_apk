package com.tencent.mm.plugin.backup.d;

import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class b
  extends com.tencent.mm.plugin.backup.b.d
{
  private static b oLl;
  private d oLm;
  private c oLn;
  private a oLo;
  private com.tencent.mm.plugin.backup.c.a oLp;
  String oLq = "tickit";
  private PowerManager.WakeLock wakeLock = null;
  
  public static b cfv()
  {
    AppMethodBeat.i(21292);
    if (oLl == null)
    {
      localb = new b();
      oLl = localb;
      a(localb);
    }
    b localb = oLl;
    AppMethodBeat.o(21292);
    return localb;
  }
  
  public final void ceH()
  {
    oLl = null;
  }
  
  public final void ceN()
  {
    AppMethodBeat.i(21298);
    Log.i("MicroMsg.BackupMoveModel", "startWakeLock");
    MMHandlerThread.postToMainThread(new b.2(this));
    AppMethodBeat.o(21298);
  }
  
  public final void ceO()
  {
    AppMethodBeat.i(21299);
    Log.i("MicroMsg.BackupMoveModel", "stopWakeLock");
    MMHandlerThread.postToMainThreadDelayed(new b.3(this), 15000L);
    AppMethodBeat.o(21299);
  }
  
  public final com.tencent.mm.plugin.backup.c.a cfw()
  {
    AppMethodBeat.i(21294);
    if (this.oLp == null) {
      this.oLp = new com.tencent.mm.plugin.backup.c.a();
    }
    com.tencent.mm.plugin.backup.c.a locala = this.oLp;
    AppMethodBeat.o(21294);
    return locala;
  }
  
  public final d cfx()
  {
    AppMethodBeat.i(21295);
    if (this.oLm == null) {
      this.oLm = new d();
    }
    d locald = this.oLm;
    AppMethodBeat.o(21295);
    return locald;
  }
  
  public final c cfy()
  {
    AppMethodBeat.i(21296);
    if (this.oLn == null) {
      this.oLn = new c();
    }
    c localc = this.oLn;
    AppMethodBeat.o(21296);
    return localc;
  }
  
  public final a cfz()
  {
    AppMethodBeat.i(21297);
    if (this.oLo == null) {
      this.oLo = new a();
    }
    a locala = this.oLo;
    AppMethodBeat.o(21297);
    return locala;
  }
  
  public final void o(Object... paramVarArgs)
  {
    AppMethodBeat.i(21293);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21289);
        Object localObject = b.cfv().cfy();
        String str = this.val$url;
        Log.w("MicroMsg.BackupMoveRecoverServer", "~~~~~~~~~~~~  start by url:%s", new Object[] { str });
        if (((l)g.af(l.class)).aTq().eiC()) {
          bp.aVQ();
        }
        com.tencent.mm.plugin.backup.g.b.cgx();
        bg.azz().a(595, ((c)localObject).oLS);
        localObject = new e(str);
        bg.azz().a((q)localObject, 0);
        AppMethodBeat.o(21289);
      }
    });
    AppMethodBeat.o(21293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.b
 * JD-Core Version:    0.7.0.1
 */