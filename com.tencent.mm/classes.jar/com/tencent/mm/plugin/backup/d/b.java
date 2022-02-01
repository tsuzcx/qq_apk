package com.tencent.mm.plugin.backup.d;

import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class b
  extends com.tencent.mm.plugin.backup.b.d
{
  private static b uYp;
  private d uYq;
  private c uYr;
  private a uYs;
  private com.tencent.mm.plugin.backup.c.a uYt;
  String uYu = "tickit";
  private PowerManager.WakeLock wakeLock = null;
  
  public static b cVs()
  {
    AppMethodBeat.i(21292);
    if (uYp == null)
    {
      localb = new b();
      uYp = localb;
      a(localb);
    }
    b localb = uYp;
    AppMethodBeat.o(21292);
    return localb;
  }
  
  public final void cUE()
  {
    uYp = null;
  }
  
  public final void cUK()
  {
    AppMethodBeat.i(21298);
    Log.i("MicroMsg.BackupMoveModel", "startWakeLock");
    MMHandlerThread.postToMainThread(new b.2(this));
    AppMethodBeat.o(21298);
  }
  
  public final void cUL()
  {
    AppMethodBeat.i(21299);
    Log.i("MicroMsg.BackupMoveModel", "stopWakeLock");
    MMHandlerThread.postToMainThreadDelayed(new b.3(this), 15000L);
    AppMethodBeat.o(21299);
  }
  
  public final com.tencent.mm.plugin.backup.c.a cVt()
  {
    AppMethodBeat.i(21294);
    if (this.uYt == null) {
      this.uYt = new com.tencent.mm.plugin.backup.c.a();
    }
    com.tencent.mm.plugin.backup.c.a locala = this.uYt;
    AppMethodBeat.o(21294);
    return locala;
  }
  
  public final d cVu()
  {
    AppMethodBeat.i(21295);
    if (this.uYq == null) {
      this.uYq = new d();
    }
    d locald = this.uYq;
    AppMethodBeat.o(21295);
    return locald;
  }
  
  public final c cVv()
  {
    AppMethodBeat.i(21296);
    if (this.uYr == null) {
      this.uYr = new c();
    }
    c localc = this.uYr;
    AppMethodBeat.o(21296);
    return localc;
  }
  
  public final a cVw()
  {
    AppMethodBeat.i(21297);
    if (this.uYs == null) {
      this.uYs = new a();
    }
    a locala = this.uYs;
    AppMethodBeat.o(21297);
    return locala;
  }
  
  public final void p(Object... paramVarArgs)
  {
    AppMethodBeat.i(21293);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21289);
        Object localObject = b.cVs().cVv();
        String str = this.val$url;
        Log.w("MicroMsg.BackupMoveRecoverServer", "~~~~~~~~~~~~  start by url:%s", new Object[] { str });
        if (((n)h.ax(n.class)).bAd().gbd()) {
          br.bCK();
        }
        com.tencent.mm.plugin.backup.g.b.cWt();
        bh.aZW().a(595, ((c)localObject).uYY);
        localObject = new e(str);
        bh.aZW().a((p)localObject, 0);
        AppMethodBeat.o(21289);
      }
    });
    AppMethodBeat.o(21293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.b
 * JD-Core Version:    0.7.0.1
 */