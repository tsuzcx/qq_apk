package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.Context;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;

public final class b
  extends com.tencent.mm.plugin.backup.b.d
{
  private static b mXp;
  private com.tencent.mm.plugin.backup.c.a mUy;
  private c mXq;
  private e mXr;
  private d mXs;
  private a mXt;
  private PowerManager.WakeLock wakeLock = null;
  
  public static b bEa()
  {
    AppMethodBeat.i(21549);
    if (mXp == null)
    {
      localb = new b();
      mXp = localb;
      a(localb);
    }
    b localb = mXp;
    AppMethodBeat.o(21549);
    return localb;
  }
  
  public final void bCK()
  {
    mXp = null;
  }
  
  public final void bCQ()
  {
    AppMethodBeat.i(21556);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21547);
        try
        {
          if (b.a(b.this) == null)
          {
            PowerManager localPowerManager = (PowerManager)ai.getContext().getSystemService("power");
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
  
  public final void bCR()
  {
    AppMethodBeat.i(21557);
    ap.f(new Runnable()
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
  
  public final com.tencent.mm.plugin.backup.c.a bDz()
  {
    AppMethodBeat.i(21551);
    if (this.mUy == null) {
      this.mUy = new com.tencent.mm.plugin.backup.c.a();
    }
    com.tencent.mm.plugin.backup.c.a locala = this.mUy;
    AppMethodBeat.o(21551);
    return locala;
  }
  
  public final c bEb()
  {
    AppMethodBeat.i(21552);
    if (this.mXq == null) {
      this.mXq = new c();
    }
    c localc = this.mXq;
    AppMethodBeat.o(21552);
    return localc;
  }
  
  public final e bEc()
  {
    AppMethodBeat.i(21553);
    if (this.mXr == null) {
      this.mXr = new e();
    }
    e locale = this.mXr;
    AppMethodBeat.o(21553);
    return locale;
  }
  
  public final d bEd()
  {
    AppMethodBeat.i(21554);
    if (this.mXs == null) {
      this.mXs = new d();
    }
    d locald = this.mXs;
    AppMethodBeat.o(21554);
    return locald;
  }
  
  public final a bEe()
  {
    AppMethodBeat.i(21555);
    if (this.mXt == null) {
      this.mXt = new a();
    }
    a locala = this.mXt;
    AppMethodBeat.o(21555);
    return locala;
  }
  
  public final void p(Object... paramVarArgs)
  {
    AppMethodBeat.i(21550);
    ((Boolean)paramVarArgs[0]).booleanValue();
    paramVarArgs = bEa().bEb();
    new ao(Looper.getMainLooper()).postDelayed(new c.5(paramVarArgs), 100L);
    AppMethodBeat.o(21550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.b
 * JD-Core Version:    0.7.0.1
 */