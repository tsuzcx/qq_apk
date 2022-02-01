package com.tencent.mm.plugin.backup.d;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;

public final class b
  extends com.tencent.mm.plugin.backup.b.d
{
  private static b mUu;
  private d mUv;
  private c mUw;
  private a mUx;
  private com.tencent.mm.plugin.backup.c.a mUy;
  String mUz = "tickit";
  private PowerManager.WakeLock wakeLock = null;
  
  public static b bDy()
  {
    AppMethodBeat.i(21292);
    if (mUu == null)
    {
      localb = new b();
      mUu = localb;
      a(localb);
    }
    b localb = mUu;
    AppMethodBeat.o(21292);
    return localb;
  }
  
  public final void bCK()
  {
    mUu = null;
  }
  
  public final void bCQ()
  {
    AppMethodBeat.i(21298);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21290);
        try
        {
          if (b.a(b.this) == null)
          {
            PowerManager localPowerManager = (PowerManager)ai.getContext().getSystemService("power");
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
  
  public final void bCR()
  {
    AppMethodBeat.i(21299);
    ap.n(new Runnable()
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
  
  public final d bDA()
  {
    AppMethodBeat.i(21295);
    if (this.mUv == null) {
      this.mUv = new d();
    }
    d locald = this.mUv;
    AppMethodBeat.o(21295);
    return locald;
  }
  
  public final c bDB()
  {
    AppMethodBeat.i(21296);
    if (this.mUw == null) {
      this.mUw = new c();
    }
    c localc = this.mUw;
    AppMethodBeat.o(21296);
    return localc;
  }
  
  public final a bDC()
  {
    AppMethodBeat.i(21297);
    if (this.mUx == null) {
      this.mUx = new a();
    }
    a locala = this.mUx;
    AppMethodBeat.o(21297);
    return locala;
  }
  
  public final com.tencent.mm.plugin.backup.c.a bDz()
  {
    AppMethodBeat.i(21294);
    if (this.mUy == null) {
      this.mUy = new com.tencent.mm.plugin.backup.c.a();
    }
    com.tencent.mm.plugin.backup.c.a locala = this.mUy;
    AppMethodBeat.o(21294);
    return locala;
  }
  
  public final void p(Object... paramVarArgs)
  {
    AppMethodBeat.i(21293);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21289);
        Object localObject = b.bDy().bDB();
        String str = this.val$url;
        ac.w("MicroMsg.BackupMoveRecoverServer", "~~~~~~~~~~~~  start by url:%s", new Object[] { str });
        if (((k)g.ab(k.class)).axd().dcw()) {
          bi.ayY();
        }
        com.tencent.mm.plugin.backup.g.b.bEx();
        az.agi().a(595, ((c)localObject).mVb);
        localObject = new e(str);
        az.agi().a((n)localObject, 0);
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