package com.tencent.mm.plugin.backup.d;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;

public final class b
  extends com.tencent.mm.plugin.backup.b.d
{
  private static b mst;
  private d msu;
  private c msv;
  private a msw;
  private com.tencent.mm.plugin.backup.c.a msx;
  String msy = "tickit";
  private PowerManager.WakeLock wakeLock = null;
  
  public static b bwC()
  {
    AppMethodBeat.i(21292);
    if (mst == null)
    {
      localb = new b();
      mst = localb;
      a(localb);
    }
    b localb = mst;
    AppMethodBeat.o(21292);
    return localb;
  }
  
  public final void bvO()
  {
    mst = null;
  }
  
  public final void bvU()
  {
    AppMethodBeat.i(21298);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21290);
        try
        {
          if (b.a(b.this) == null)
          {
            PowerManager localPowerManager = (PowerManager)aj.getContext().getSystemService("power");
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
  
  public final void bvV()
  {
    AppMethodBeat.i(21299);
    aq.n(new Runnable()
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
  
  public final com.tencent.mm.plugin.backup.c.a bwD()
  {
    AppMethodBeat.i(21294);
    if (this.msx == null) {
      this.msx = new com.tencent.mm.plugin.backup.c.a();
    }
    com.tencent.mm.plugin.backup.c.a locala = this.msx;
    AppMethodBeat.o(21294);
    return locala;
  }
  
  public final d bwE()
  {
    AppMethodBeat.i(21295);
    if (this.msu == null) {
      this.msu = new d();
    }
    d locald = this.msu;
    AppMethodBeat.o(21295);
    return locald;
  }
  
  public final c bwF()
  {
    AppMethodBeat.i(21296);
    if (this.msv == null) {
      this.msv = new c();
    }
    c localc = this.msv;
    AppMethodBeat.o(21296);
    return localc;
  }
  
  public final a bwG()
  {
    AppMethodBeat.i(21297);
    if (this.msw == null) {
      this.msw = new a();
    }
    a locala = this.msw;
    AppMethodBeat.o(21297);
    return locala;
  }
  
  public final void o(Object... paramVarArgs)
  {
    AppMethodBeat.i(21293);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21289);
        Object localObject = b.bwC().bwF();
        String str = this.val$url;
        ad.w("MicroMsg.BackupMoveRecoverServer", "~~~~~~~~~~~~  start by url:%s", new Object[] { str });
        if (((k)g.ab(k.class)).aqo().cON()) {
          bi.ash();
        }
        com.tencent.mm.plugin.backup.g.b.bxB();
        az.aeS().a(595, ((c)localObject).msZ);
        localObject = new e(str);
        az.aeS().a((n)localObject, 0);
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