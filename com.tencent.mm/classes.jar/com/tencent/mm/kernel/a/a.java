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
  public static long gec;
  public static long ged;
  public static long gee;
  public com.tencent.mm.kernel.a.a.b gea;
  public b geb;
  private volatile boolean mConfigured = false;
  
  public static final void h(String paramString, Object... paramVarArgs)
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
  
  public static String lx(long paramLong)
  {
    AppMethodBeat.i(158333);
    String str = System.currentTimeMillis() - paramLong + "ms";
    AppMethodBeat.o(158333);
    return str;
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(158328);
    gee = SystemClock.elapsedRealtime();
    h("hello WeChat.", new Object[0]);
    this.geb.Kv();
    AppMethodBeat.o(158328);
  }
  
  public final void Kw()
  {
    AppMethodBeat.i(158329);
    long l = System.currentTimeMillis();
    h("boot install plugins...", new Object[0]);
    this.geb.Kw();
    this.mConfigured = true;
    h("boot all installed plugins : %s...", new Object[] { h.afF().afx().aeY() });
    h("boot install plugins done in [%s].", new Object[] { lx(l) });
    AppMethodBeat.o(158329);
  }
  
  public final void a(b paramVarArgs)
  {
    AppMethodBeat.i(158326);
    Assert.assertNotNull(paramVarArgs);
    h.afF().afy();
    this.geb = paramVarArgs;
    AppMethodBeat.o(158326);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(158331);
    long l = System.currentTimeMillis();
    h("boot configure plugins...", new Object[0]);
    this.geb.a(paramg);
    h("boot configure plugins done in [%s].", new Object[] { lx(l) });
    AppMethodBeat.o(158331);
  }
  
  public final void afL()
  {
    AppMethodBeat.i(158327);
    Assert.assertNotNull("You must call whichBootStep(BootStep defaultOne, BootStep ... bootSteps) to specify your BootStep instance first!", this.geb);
    AppMethodBeat.o(158327);
  }
  
  public final void afM()
  {
    AppMethodBeat.i(158330);
    long l = System.currentTimeMillis();
    h("boot make dependency of plugins...", new Object[0]);
    this.geb.afM();
    h("boot make dependency of done in [%s].", new Object[] { lx(l) });
    AppMethodBeat.o(158330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a.a
 * JD-Core Version:    0.7.0.1
 */