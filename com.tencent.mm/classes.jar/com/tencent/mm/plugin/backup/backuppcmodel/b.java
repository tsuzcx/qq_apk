package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.Context;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;

public final class b
  extends com.tencent.mm.plugin.backup.b.d
{
  private static b nxM;
  private com.tencent.mm.plugin.backup.c.a nuW;
  private c nxN;
  private e nxO;
  private d nxP;
  private a nxQ;
  private PowerManager.WakeLock wakeLock = null;
  
  public static b bIj()
  {
    AppMethodBeat.i(21549);
    if (nxM == null)
    {
      localb = new b();
      nxM = localb;
      a(localb);
    }
    b localb = nxM;
    AppMethodBeat.o(21549);
    return localb;
  }
  
  public final void bGS()
  {
    nxM = null;
  }
  
  public final void bGY()
  {
    AppMethodBeat.i(21556);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21547);
        try
        {
          if (b.a(b.this) == null)
          {
            PowerManager localPowerManager = (PowerManager)aj.getContext().getSystemService("power");
            b.a(b.this, localPowerManager.newWakeLock(26, "BackupPc Lock"));
          }
          if (!b.a(b.this).isHeld()) {
            b.a(b.this).acquire();
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
  
  public final void bGZ()
  {
    AppMethodBeat.i(21557);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21548);
        try
        {
          if ((b.a(b.this) != null) && (b.a(b.this).isHeld())) {
            b.a(b.this).release();
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
  
  public final com.tencent.mm.plugin.backup.c.a bHH()
  {
    AppMethodBeat.i(21551);
    if (this.nuW == null) {
      this.nuW = new com.tencent.mm.plugin.backup.c.a();
    }
    com.tencent.mm.plugin.backup.c.a locala = this.nuW;
    AppMethodBeat.o(21551);
    return locala;
  }
  
  public final c bIk()
  {
    AppMethodBeat.i(21552);
    if (this.nxN == null) {
      this.nxN = new c();
    }
    c localc = this.nxN;
    AppMethodBeat.o(21552);
    return localc;
  }
  
  public final e bIl()
  {
    AppMethodBeat.i(21553);
    if (this.nxO == null) {
      this.nxO = new e();
    }
    e locale = this.nxO;
    AppMethodBeat.o(21553);
    return locale;
  }
  
  public final d bIm()
  {
    AppMethodBeat.i(21554);
    if (this.nxP == null) {
      this.nxP = new d();
    }
    d locald = this.nxP;
    AppMethodBeat.o(21554);
    return locald;
  }
  
  public final a bIn()
  {
    AppMethodBeat.i(21555);
    if (this.nxQ == null) {
      this.nxQ = new a();
    }
    a locala = this.nxQ;
    AppMethodBeat.o(21555);
    return locala;
  }
  
  public final void p(Object... paramVarArgs)
  {
    AppMethodBeat.i(21550);
    ((Boolean)paramVarArgs[0]).booleanValue();
    paramVarArgs = bIj().bIk();
    new ap(Looper.getMainLooper()).postDelayed(new c.5(paramVarArgs), 100L);
    AppMethodBeat.o(21550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.b
 * JD-Core Version:    0.7.0.1
 */