package com.tencent.mm.kernel.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.i;
import com.tencent.mm.kernel.l;
import junit.framework.Assert;

public final class a
{
  public static long mDS;
  public static long mDT;
  public static long mDU;
  private volatile boolean mConfigured = false;
  public com.tencent.mm.kernel.a.a.b mDQ;
  public b mDR;
  
  public static String hE(long paramLong)
  {
    AppMethodBeat.i(158333);
    String str = System.currentTimeMillis() - paramLong + "ms";
    AppMethodBeat.o(158333);
    return str;
  }
  
  public static final void j(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(158332);
    if (paramVarArgs.length == 0)
    {
      l.i("MMSkeleton.Boot", paramString, new Object[0]);
      AppMethodBeat.o(158332);
      return;
    }
    l.i("MMSkeleton.Boot", paramString, paramVarArgs);
    AppMethodBeat.o(158332);
  }
  
  public final void a(b paramVarArgs)
  {
    AppMethodBeat.i(158326);
    Assert.assertNotNull(paramVarArgs);
    i.baI().baB().bad();
    this.mDR = paramVarArgs;
    AppMethodBeat.o(158326);
  }
  
  public final void aBY()
  {
    AppMethodBeat.i(158328);
    mDU = SystemClock.elapsedRealtime();
    j("hello WeChat.", new Object[0]);
    this.mDR.aBY();
    AppMethodBeat.o(158328);
  }
  
  public final void aBZ()
  {
    AppMethodBeat.i(158329);
    long l = System.currentTimeMillis();
    j("boot install plugins...", new Object[0]);
    this.mDR.aBZ();
    this.mConfigured = true;
    j("boot all installed plugins : %s...", new Object[] { i.baI().baA().bac() });
    j("boot install plugins done in [%s].", new Object[] { hE(l) });
    AppMethodBeat.o(158329);
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(158331);
    long l = System.currentTimeMillis();
    j("boot configure plugins...", new Object[0]);
    this.mDR.b(paramg);
    j("boot configure plugins done in [%s].", new Object[] { hE(l) });
    AppMethodBeat.o(158331);
  }
  
  public final void baP()
  {
    AppMethodBeat.i(158327);
    Assert.assertNotNull("You must call whichBootStep(BootStep defaultOne, BootStep ... bootSteps) to specify your BootStep instance first!", this.mDR);
    AppMethodBeat.o(158327);
  }
  
  public final void baQ()
  {
    AppMethodBeat.i(158330);
    long l = System.currentTimeMillis();
    j("boot make dependency of plugins...", new Object[0]);
    this.mDR.baQ();
    j("boot make dependency of done in [%s].", new Object[] { hE(l) });
    AppMethodBeat.o(158330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.kernel.a.a
 * JD-Core Version:    0.7.0.1
 */