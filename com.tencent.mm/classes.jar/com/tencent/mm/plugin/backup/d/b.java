package com.tencent.mm.plugin.backup.d;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;

public final class b
  extends com.tencent.mm.plugin.backup.b.d
{
  private static b nuS;
  private d nuT;
  private c nuU;
  private a nuV;
  private com.tencent.mm.plugin.backup.c.a nuW;
  String nuX = "tickit";
  private PowerManager.WakeLock wakeLock = null;
  
  public static b bHG()
  {
    AppMethodBeat.i(21292);
    if (nuS == null)
    {
      localb = new b();
      nuS = localb;
      a(localb);
    }
    b localb = nuS;
    AppMethodBeat.o(21292);
    return localb;
  }
  
  public final void bGS()
  {
    nuS = null;
  }
  
  public final void bGY()
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
  
  public final void bGZ()
  {
    AppMethodBeat.i(21299);
    aq.o(new Runnable()
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
  
  public final com.tencent.mm.plugin.backup.c.a bHH()
  {
    AppMethodBeat.i(21294);
    if (this.nuW == null) {
      this.nuW = new com.tencent.mm.plugin.backup.c.a();
    }
    com.tencent.mm.plugin.backup.c.a locala = this.nuW;
    AppMethodBeat.o(21294);
    return locala;
  }
  
  public final d bHI()
  {
    AppMethodBeat.i(21295);
    if (this.nuT == null) {
      this.nuT = new d();
    }
    d locald = this.nuT;
    AppMethodBeat.o(21295);
    return locald;
  }
  
  public final c bHJ()
  {
    AppMethodBeat.i(21296);
    if (this.nuU == null) {
      this.nuU = new c();
    }
    c localc = this.nuU;
    AppMethodBeat.o(21296);
    return localc;
  }
  
  public final a bHK()
  {
    AppMethodBeat.i(21297);
    if (this.nuV == null) {
      this.nuV = new a();
    }
    a locala = this.nuV;
    AppMethodBeat.o(21297);
    return locala;
  }
  
  public final void p(Object... paramVarArgs)
  {
    AppMethodBeat.i(21293);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21289);
        Object localObject = b.bHG().bHJ();
        String str = this.val$url;
        ad.w("MicroMsg.BackupMoveRecoverServer", "~~~~~~~~~~~~  start by url:%s", new Object[] { str });
        if (((l)g.ab(l.class)).azS().dlO()) {
          bj.aCc();
        }
        com.tencent.mm.plugin.backup.g.b.bIG();
        ba.aiU().a(595, ((c)localObject).nvy);
        localObject = new e(str);
        ba.aiU().a((n)localObject, 0);
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