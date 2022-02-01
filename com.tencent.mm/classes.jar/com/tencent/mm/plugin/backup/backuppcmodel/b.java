package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.Context;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;

public final class b
  extends com.tencent.mm.plugin.backup.b.d
{
  private static b nDh;
  private com.tencent.mm.plugin.backup.c.a nAr;
  private c nDi;
  private e nDj;
  private d nDk;
  private a nDl;
  private PowerManager.WakeLock wakeLock = null;
  
  public static b bJh()
  {
    AppMethodBeat.i(21549);
    if (nDh == null)
    {
      localb = new b();
      nDh = localb;
      a(localb);
    }
    b localb = nDh;
    AppMethodBeat.o(21549);
    return localb;
  }
  
  public final void bHQ()
  {
    nDh = null;
  }
  
  public final void bHW()
  {
    AppMethodBeat.i(21556);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21547);
        try
        {
          if (b.a(b.this) == null)
          {
            PowerManager localPowerManager = (PowerManager)ak.getContext().getSystemService("power");
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
  
  public final void bHX()
  {
    AppMethodBeat.i(21557);
    ar.f(new Runnable()
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
  
  public final com.tencent.mm.plugin.backup.c.a bIF()
  {
    AppMethodBeat.i(21551);
    if (this.nAr == null) {
      this.nAr = new com.tencent.mm.plugin.backup.c.a();
    }
    com.tencent.mm.plugin.backup.c.a locala = this.nAr;
    AppMethodBeat.o(21551);
    return locala;
  }
  
  public final c bJi()
  {
    AppMethodBeat.i(21552);
    if (this.nDi == null) {
      this.nDi = new c();
    }
    c localc = this.nDi;
    AppMethodBeat.o(21552);
    return localc;
  }
  
  public final e bJj()
  {
    AppMethodBeat.i(21553);
    if (this.nDj == null) {
      this.nDj = new e();
    }
    e locale = this.nDj;
    AppMethodBeat.o(21553);
    return locale;
  }
  
  public final d bJk()
  {
    AppMethodBeat.i(21554);
    if (this.nDk == null) {
      this.nDk = new d();
    }
    d locald = this.nDk;
    AppMethodBeat.o(21554);
    return locald;
  }
  
  public final a bJl()
  {
    AppMethodBeat.i(21555);
    if (this.nDl == null) {
      this.nDl = new a();
    }
    a locala = this.nDl;
    AppMethodBeat.o(21555);
    return locala;
  }
  
  public final void o(Object... paramVarArgs)
  {
    AppMethodBeat.i(21550);
    ((Boolean)paramVarArgs[0]).booleanValue();
    paramVarArgs = bJh().bJi();
    new aq(Looper.getMainLooper()).postDelayed(new c.5(paramVarArgs), 100L);
    AppMethodBeat.o(21550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.b
 * JD-Core Version:    0.7.0.1
 */