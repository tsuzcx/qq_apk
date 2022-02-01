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
  public static long gCs;
  public static long gCt;
  public static long gCu;
  public com.tencent.mm.kernel.a.a.b gCq;
  public b gCr;
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
  
  public static String rb(long paramLong)
  {
    AppMethodBeat.i(158333);
    String str = System.currentTimeMillis() - paramLong + "ms";
    AppMethodBeat.o(158333);
    return str;
  }
  
  public final void LE()
  {
    AppMethodBeat.i(158328);
    gCu = SystemClock.elapsedRealtime();
    k("hello WeChat.", new Object[0]);
    this.gCr.LE();
    AppMethodBeat.o(158328);
  }
  
  public final void LF()
  {
    AppMethodBeat.i(158329);
    long l = System.currentTimeMillis();
    k("boot install plugins...", new Object[0]);
    this.gCr.LF();
    this.mConfigured = true;
    k("boot all installed plugins : %s...", new Object[] { h.ajG().ajy().aja() });
    k("boot install plugins done in [%s].", new Object[] { rb(l) });
    AppMethodBeat.o(158329);
  }
  
  public final void a(b paramVarArgs)
  {
    AppMethodBeat.i(158326);
    Assert.assertNotNull(paramVarArgs);
    h.ajG().ajz();
    this.gCr = paramVarArgs;
    AppMethodBeat.o(158326);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(158331);
    long l = System.currentTimeMillis();
    k("boot configure plugins...", new Object[0]);
    this.gCr.a(paramg);
    k("boot configure plugins done in [%s].", new Object[] { rb(l) });
    AppMethodBeat.o(158331);
  }
  
  public final void ajM()
  {
    AppMethodBeat.i(158327);
    Assert.assertNotNull("You must call whichBootStep(BootStep defaultOne, BootStep ... bootSteps) to specify your BootStep instance first!", this.gCr);
    AppMethodBeat.o(158327);
  }
  
  public final void ajN()
  {
    AppMethodBeat.i(158330);
    long l = System.currentTimeMillis();
    k("boot make dependency of plugins...", new Object[0]);
    this.gCr.ajN();
    k("boot make dependency of done in [%s].", new Object[] { rb(l) });
    AppMethodBeat.o(158330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a.a
 * JD-Core Version:    0.7.0.1
 */