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
  private static b mvo;
  private com.tencent.mm.plugin.backup.c.a msx;
  private c mvp;
  private e mvq;
  private d mvr;
  private a mvs;
  private PowerManager.WakeLock wakeLock = null;
  
  public static b bxe()
  {
    AppMethodBeat.i(21549);
    if (mvo == null)
    {
      localb = new b();
      mvo = localb;
      a(localb);
    }
    b localb = mvo;
    AppMethodBeat.o(21549);
    return localb;
  }
  
  public final void bvO()
  {
    mvo = null;
  }
  
  public final void bvU()
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
  
  public final void bvV()
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
  
  public final com.tencent.mm.plugin.backup.c.a bwD()
  {
    AppMethodBeat.i(21551);
    if (this.msx == null) {
      this.msx = new com.tencent.mm.plugin.backup.c.a();
    }
    com.tencent.mm.plugin.backup.c.a locala = this.msx;
    AppMethodBeat.o(21551);
    return locala;
  }
  
  public final c bxf()
  {
    AppMethodBeat.i(21552);
    if (this.mvp == null) {
      this.mvp = new c();
    }
    c localc = this.mvp;
    AppMethodBeat.o(21552);
    return localc;
  }
  
  public final e bxg()
  {
    AppMethodBeat.i(21553);
    if (this.mvq == null) {
      this.mvq = new e();
    }
    e locale = this.mvq;
    AppMethodBeat.o(21553);
    return locale;
  }
  
  public final d bxh()
  {
    AppMethodBeat.i(21554);
    if (this.mvr == null) {
      this.mvr = new d();
    }
    d locald = this.mvr;
    AppMethodBeat.o(21554);
    return locald;
  }
  
  public final a bxi()
  {
    AppMethodBeat.i(21555);
    if (this.mvs == null) {
      this.mvs = new a();
    }
    a locala = this.mvs;
    AppMethodBeat.o(21555);
    return locala;
  }
  
  public final void o(Object... paramVarArgs)
  {
    AppMethodBeat.i(21550);
    ((Boolean)paramVarArgs[0]).booleanValue();
    paramVarArgs = bxe().bxf();
    new ap(Looper.getMainLooper()).postDelayed(new c.5(paramVarArgs), 100L);
    AppMethodBeat.o(21550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.b
 * JD-Core Version:    0.7.0.1
 */