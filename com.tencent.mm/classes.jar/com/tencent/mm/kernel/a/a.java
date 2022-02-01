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
  public static long kdI;
  public static long kdJ;
  public static long kdK;
  public com.tencent.mm.kernel.a.a.b kdG;
  public b kdH;
  private volatile boolean mConfigured = false;
  
  public static String Fv(long paramLong)
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
    i.aHL().aHD().aHf();
    this.kdH = paramVarArgs;
    AppMethodBeat.o(158326);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(158331);
    long l = System.currentTimeMillis();
    j("boot configure plugins...", new Object[0]);
    this.kdH.a(paramg);
    j("boot configure plugins done in [%s].", new Object[] { Fv(l) });
    AppMethodBeat.o(158331);
  }
  
  public final void aHS()
  {
    AppMethodBeat.i(158327);
    Assert.assertNotNull("You must call whichBootStep(BootStep defaultOne, BootStep ... bootSteps) to specify your BootStep instance first!", this.kdH);
    AppMethodBeat.o(158327);
  }
  
  public final void aHT()
  {
    AppMethodBeat.i(158330);
    long l = System.currentTimeMillis();
    j("boot make dependency of plugins...", new Object[0]);
    this.kdH.aHT();
    j("boot make dependency of done in [%s].", new Object[] { Fv(l) });
    AppMethodBeat.o(158330);
  }
  
  public final void aau()
  {
    AppMethodBeat.i(158328);
    kdK = SystemClock.elapsedRealtime();
    j("hello WeChat.", new Object[0]);
    this.kdH.aau();
    AppMethodBeat.o(158328);
  }
  
  public final void aav()
  {
    AppMethodBeat.i(158329);
    long l = System.currentTimeMillis();
    j("boot install plugins...", new Object[0]);
    this.kdH.aav();
    this.mConfigured = true;
    j("boot all installed plugins : %s...", new Object[] { i.aHL().aHC().aHe() });
    j("boot install plugins done in [%s].", new Object[] { Fv(l) });
    AppMethodBeat.o(158329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kernel.a.a
 * JD-Core Version:    0.7.0.1
 */