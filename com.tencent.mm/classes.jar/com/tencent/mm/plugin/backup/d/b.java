package com.tencent.mm.plugin.backup.d;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;

public final class b
  extends com.tencent.mm.plugin.backup.b.d
{
  private static b nAn;
  private d nAo;
  private c nAp;
  private a nAq;
  private com.tencent.mm.plugin.backup.c.a nAr;
  String nAs = "tickit";
  private PowerManager.WakeLock wakeLock = null;
  
  public static b bIE()
  {
    AppMethodBeat.i(21292);
    if (nAn == null)
    {
      localb = new b();
      nAn = localb;
      a(localb);
    }
    b localb = nAn;
    AppMethodBeat.o(21292);
    return localb;
  }
  
  public final void bHQ()
  {
    nAn = null;
  }
  
  public final void bHW()
  {
    AppMethodBeat.i(21298);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21290);
        try
        {
          if (b.a(b.this) == null)
          {
            PowerManager localPowerManager = (PowerManager)ak.getContext().getSystemService("power");
            b.a(b.this, localPowerManager.newWakeLock(26, "BackupMove Lock"));
          }
          if (!b.a(b.this).isHeld()) {
            b.a(b.this).acquire();
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
  
  public final void bHX()
  {
    AppMethodBeat.i(21299);
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21291);
        try
        {
          if ((b.a(b.this) != null) && (b.a(b.this).isHeld())) {
            b.a(b.this).release();
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
  
  public final com.tencent.mm.plugin.backup.c.a bIF()
  {
    AppMethodBeat.i(21294);
    if (this.nAr == null) {
      this.nAr = new com.tencent.mm.plugin.backup.c.a();
    }
    com.tencent.mm.plugin.backup.c.a locala = this.nAr;
    AppMethodBeat.o(21294);
    return locala;
  }
  
  public final d bIG()
  {
    AppMethodBeat.i(21295);
    if (this.nAo == null) {
      this.nAo = new d();
    }
    d locald = this.nAo;
    AppMethodBeat.o(21295);
    return locald;
  }
  
  public final c bIH()
  {
    AppMethodBeat.i(21296);
    if (this.nAp == null) {
      this.nAp = new c();
    }
    c localc = this.nAp;
    AppMethodBeat.o(21296);
    return localc;
  }
  
  public final a bII()
  {
    AppMethodBeat.i(21297);
    if (this.nAq == null) {
      this.nAq = new a();
    }
    a locala = this.nAq;
    AppMethodBeat.o(21297);
    return locala;
  }
  
  public final void o(Object... paramVarArgs)
  {
    AppMethodBeat.i(21293);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21289);
        Object localObject = b.bIE().bIH();
        String str = this.val$url;
        ae.w("MicroMsg.BackupMoveRecoverServer", "~~~~~~~~~~~~  start by url:%s", new Object[] { str });
        if (((l)g.ab(l.class)).aAi().doN()) {
          bl.aCs();
        }
        com.tencent.mm.plugin.backup.g.b.bJE();
        bc.ajj().a(595, ((c)localObject).nAT);
        localObject = new e(str);
        bc.ajj().a((n)localObject, 0);
        AppMethodBeat.o(21289);
      }
    });
    AppMethodBeat.o(21293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.b
 * JD-Core Version:    0.7.0.1
 */