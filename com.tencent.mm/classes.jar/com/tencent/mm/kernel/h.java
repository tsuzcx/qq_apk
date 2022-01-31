package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.a.a;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.f;
import junit.framework.Assert;

public final class h<_Profile extends com.tencent.mm.kernel.b.g>
{
  private static h eID;
  private c eIE;
  private d<_Profile> eIF;
  byte[] eIG;
  public volatile boolean eIH;
  public long eII;
  a eIJ;
  
  private h(_Profile param_Profile)
  {
    AppMethodBeat.i(123258);
    this.eIG = new byte[0];
    this.eIH = false;
    this.eIJ = new a();
    this.eIE = new c();
    this.eIF = new d(param_Profile);
    AppMethodBeat.o(123258);
  }
  
  public static <_Profile extends com.tencent.mm.kernel.b.g> h<_Profile> RP()
  {
    AppMethodBeat.i(123261);
    Assert.assertNotNull("Skeleton not initialized!", eID);
    h localh = eID;
    AppMethodBeat.o(123261);
    return localh;
  }
  
  /* Error */
  public static <_Profile extends com.tencent.mm.kernel.b.g> h<_Profile> c(_Profile param_Profile)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 86
    //   5: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 76	com/tencent/mm/kernel/h:eID	Lcom/tencent/mm/kernel/h;
    //   11: ifnull +28 -> 39
    //   14: ldc 88
    //   16: ldc 90
    //   18: iconst_0
    //   19: anewarray 5	java/lang/Object
    //   22: invokestatic 95	com/tencent/mm/kernel/j:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: getstatic 76	com/tencent/mm/kernel/h:eID	Lcom/tencent/mm/kernel/h;
    //   28: astore_0
    //   29: ldc 86
    //   31: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: ldc 2
    //   36: monitorexit
    //   37: aload_0
    //   38: areturn
    //   39: ldc 88
    //   41: ldc 97
    //   43: iconst_0
    //   44: anewarray 5	java/lang/Object
    //   47: invokestatic 95	com/tencent/mm/kernel/j:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: new 2	com/tencent/mm/kernel/h
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 98	com/tencent/mm/kernel/h:<init>	(Lcom/tencent/mm/kernel/b/g;)V
    //   58: astore_0
    //   59: aload_0
    //   60: putstatic 76	com/tencent/mm/kernel/h:eID	Lcom/tencent/mm/kernel/h;
    //   63: ldc 86
    //   65: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: goto -34 -> 34
    //   71: astore_0
    //   72: ldc 2
    //   74: monitorexit
    //   75: aload_0
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	param_Profile	_Profile
    // Exception table:
    //   from	to	target	type
    //   3	34	71	finally
    //   39	68	71	finally
  }
  
  public final c RH()
  {
    AppMethodBeat.i(123259);
    Assert.assertNotNull("mCorePlugins not initialized!", this.eIE);
    c localc = this.eIE;
    AppMethodBeat.o(123259);
    return localc;
  }
  
  public final d<_Profile> RI()
  {
    AppMethodBeat.i(123260);
    Assert.assertNotNull("mCoreProcess not initialized!", this.eIF);
    d locald = this.eIF;
    AppMethodBeat.o(123260);
    return locald;
  }
  
  public final void a(com.tencent.mm.kernel.api.g paramg)
  {
    AppMethodBeat.i(123262);
    int i = 0;
    synchronized (this.eIG)
    {
      if (this.eIH) {
        i = 1;
      }
      if (i != 0)
      {
        paramg.BN();
        AppMethodBeat.o(123262);
        return;
      }
    }
    this.eIJ.at(paramg);
    AppMethodBeat.o(123262);
  }
  
  public final void a(com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(123265);
    j.ks("startup");
    synchronized (this.eIG)
    {
      if (this.eIH)
      {
        com.tencent.mm.kernel.a.a.g("warning, mmskeleton has started up already.", new Object[0]);
        AppMethodBeat.o(123265);
        return;
      }
      ??? = RI().Rj();
      final long l = System.currentTimeMillis();
      com.tencent.mm.kernel.a.a.g("mmskeleton boot startup for process [%s]...", new Object[] { ((com.tencent.mm.kernel.b.g)???).mProcessName });
      final com.tencent.mm.kernel.a.a locala = ((com.tencent.mm.kernel.b.g)???).eHJ;
      locala.RU();
      com.tencent.mm.vending.g.c localc = f.dQr().rK(true);
      ((com.tencent.mm.kernel.b.g)???).eKw.eKy = System.currentTimeMillis();
      locala.Bc();
      ((com.tencent.mm.kernel.b.g)???).eKw.eKz = System.currentTimeMillis();
      locala.Bd();
      j.ks("installPlugins");
      ((com.tencent.mm.kernel.b.g)???).eKw.eKA = System.currentTimeMillis();
      locala.RV();
      ((com.tencent.mm.kernel.b.g)???).eKw.eKB = System.currentTimeMillis();
      locala.a((com.tencent.mm.kernel.b.g)???);
      if (paramd != null) {
        localc.b(paramd);
      }
      ((com.tencent.mm.kernel.b.g)???).eKw.eKC = System.currentTimeMillis();
      localc.c(new com.tencent.mm.vending.c.a() {});
      ((com.tencent.mm.kernel.b.g)???).eKw.eKD = System.currentTimeMillis();
      localc.c(new com.tencent.mm.vending.c.a() {});
      ((com.tencent.mm.kernel.b.g)???).eKw.eKE = System.currentTimeMillis();
      localc.a(com.tencent.mm.vending.h.d.AOW, new d.b()
      {
        public final void ap(Object arg1)
        {
          AppMethodBeat.i(123253);
          j.ks("executeBootExtension");
          synchronized (h.this.eIG)
          {
            h.this.eIH = true;
            com.tencent.mm.kernel.a.a.g("summerboot mmskeleton boot startup finished in [%s]!", new Object[] { com.tencent.mm.kernel.a.a.gi(l) });
            h.this.eIJ.BN();
            j.ks("onStartupDone");
            h.this.eII = System.currentTimeMillis();
            this.bXV.eKw.eKF = h.this.eII;
            AppMethodBeat.o(123253);
            return;
          }
        }
      });
      AppMethodBeat.o(123265);
      return;
    }
  }
  
  public final void b(com.tencent.mm.kernel.api.g paramg)
  {
    AppMethodBeat.i(123263);
    this.eIJ.remove(paramg);
    AppMethodBeat.o(123263);
  }
  
  static final class a
    extends com.tencent.mm.cm.a<com.tencent.mm.kernel.api.g>
    implements com.tencent.mm.kernel.api.g
  {
    public a()
    {
      super();
    }
    
    public final void BN()
    {
      AppMethodBeat.i(123256);
      a(new a.a() {});
      AppMethodBeat.o(123256);
    }
    
    public final void br(final boolean paramBoolean)
    {
      AppMethodBeat.i(123257);
      a(new a.a() {});
      AppMethodBeat.o(123257);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.h
 * JD-Core Version:    0.7.0.1
 */