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
  public static long eIT;
  public static long eIU;
  public static long eIV;
  public com.tencent.mm.kernel.a.a.b eIR;
  public b eIS;
  private volatile boolean mConfigured = false;
  
  public static final void g(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(123279);
    if (paramVarArgs.length == 0)
    {
      j.i("MMSkeleton.Boot", paramString, new Object[0]);
      AppMethodBeat.o(123279);
      return;
    }
    j.i("MMSkeleton.Boot", paramString, paramVarArgs);
    AppMethodBeat.o(123279);
  }
  
  public static String gi(long paramLong)
  {
    AppMethodBeat.i(123280);
    String str = System.currentTimeMillis() - paramLong + "ms";
    AppMethodBeat.o(123280);
    return str;
  }
  
  public final void Bc()
  {
    AppMethodBeat.i(123275);
    eIV = SystemClock.elapsedRealtime();
    g("hello WeChat.", new Object[0]);
    this.eIS.Bc();
    AppMethodBeat.o(123275);
  }
  
  public final void Bd()
  {
    AppMethodBeat.i(123276);
    long l = System.currentTimeMillis();
    g("boot install plugins...", new Object[0]);
    this.eIS.Bd();
    this.mConfigured = true;
    g("boot all installed plugins : %s...", new Object[] { h.RP().RH().Ri() });
    g("boot install plugins done in [%s].", new Object[] { gi(l) });
    AppMethodBeat.o(123276);
  }
  
  public final void RU()
  {
    AppMethodBeat.i(123274);
    Assert.assertNotNull("You must call whichBootStep(BootStep defaultOne, BootStep ... bootSteps) to specify your BootStep instance first!", this.eIS);
    AppMethodBeat.o(123274);
  }
  
  public final void RV()
  {
    AppMethodBeat.i(123277);
    long l = System.currentTimeMillis();
    g("boot make dependency of plugins...", new Object[0]);
    this.eIS.RV();
    g("boot make dependency of done in [%s].", new Object[] { gi(l) });
    AppMethodBeat.o(123277);
  }
  
  public final void a(b paramVarArgs)
  {
    AppMethodBeat.i(123273);
    Assert.assertNotNull(paramVarArgs);
    h.RP().RI();
    this.eIS = paramVarArgs;
    AppMethodBeat.o(123273);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(123278);
    long l = System.currentTimeMillis();
    g("boot configure plugins...", new Object[0]);
    this.eIS.a(paramg);
    g("boot configure plugins done in [%s].", new Object[] { gi(l) });
    AppMethodBeat.o(123278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a.a
 * JD-Core Version:    0.7.0.1
 */