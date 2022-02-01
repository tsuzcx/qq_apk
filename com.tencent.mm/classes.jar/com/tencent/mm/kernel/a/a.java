package com.tencent.mm.kernel.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.j;
import junit.framework.Assert;

public final class a
{
  public static long hrN;
  public static long hrO;
  public static long hrP;
  public com.tencent.mm.kernel.a.a.b hrL;
  public b hrM;
  private volatile boolean mConfigured = false;
  
  public static final void k(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(158332);
    if (paramVarArgs.length == 0)
    {
      j.i("MMSkeleton.Boot", paramString, new Object[0]);
      AppMethodBeat.o(158332);
      return;
    }
    j.i("MMSkeleton.Boot", paramString, paramVarArgs);
    AppMethodBeat.o(158332);
  }
  
  public static String zr(long paramLong)
  {
    AppMethodBeat.i(158333);
    String str = System.currentTimeMillis() - paramLong + "ms";
    AppMethodBeat.o(158333);
    return str;
  }
  
  public final void VZ()
  {
    AppMethodBeat.i(158328);
    hrP = SystemClock.elapsedRealtime();
    k("hello WeChat.", new Object[0]);
    this.hrM.VZ();
    AppMethodBeat.o(158328);
  }
  
  public final void Wa()
  {
    AppMethodBeat.i(158329);
    long l = System.currentTimeMillis();
    k("boot install plugins...", new Object[0]);
    this.hrM.Wa();
    this.mConfigured = true;
    k("boot all installed plugins : %s...", new Object[] { h.aAl().aAd().azF() });
    k("boot install plugins done in [%s].", new Object[] { zr(l) });
    AppMethodBeat.o(158329);
  }
  
  public final void a(b paramVarArgs)
  {
    AppMethodBeat.i(158326);
    Assert.assertNotNull(paramVarArgs);
    h.aAl().aAe();
    this.hrM = paramVarArgs;
    AppMethodBeat.o(158326);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(158331);
    long l = System.currentTimeMillis();
    k("boot configure plugins...", new Object[0]);
    this.hrM.a(paramg);
    k("boot configure plugins done in [%s].", new Object[] { zr(l) });
    AppMethodBeat.o(158331);
  }
  
  public final void aAr()
  {
    AppMethodBeat.i(158327);
    Assert.assertNotNull("You must call whichBootStep(BootStep defaultOne, BootStep ... bootSteps) to specify your BootStep instance first!", this.hrM);
    AppMethodBeat.o(158327);
  }
  
  public final void aAs()
  {
    AppMethodBeat.i(158330);
    long l = System.currentTimeMillis();
    k("boot make dependency of plugins...", new Object[0]);
    this.hrM.aAs();
    k("boot make dependency of done in [%s].", new Object[] { zr(l) });
    AppMethodBeat.o(158330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a.a
 * JD-Core Version:    0.7.0.1
 */