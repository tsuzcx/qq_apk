package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.a.a;
import com.tencent.mm.vending.g.d.b;
import junit.framework.Assert;

public final class h<_Profile extends com.tencent.mm.kernel.b.g>
{
  private static h gdM;
  private c gdN;
  private d<_Profile> gdO;
  byte[] gdP;
  public volatile boolean gdQ;
  public long gdR;
  a gdS;
  
  private h(_Profile param_Profile)
  {
    AppMethodBeat.i(158311);
    this.gdP = new byte[0];
    this.gdQ = false;
    this.gdS = new a();
    this.gdN = new c();
    this.gdO = new d(param_Profile);
    AppMethodBeat.o(158311);
  }
  
  public static <_Profile extends com.tencent.mm.kernel.b.g> h<_Profile> afF()
  {
    AppMethodBeat.i(158314);
    Assert.assertNotNull("Skeleton not initialized!", gdM);
    h localh = gdM;
    AppMethodBeat.o(158314);
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
    //   8: getstatic 76	com/tencent/mm/kernel/h:gdM	Lcom/tencent/mm/kernel/h;
    //   11: ifnull +28 -> 39
    //   14: ldc 88
    //   16: ldc 90
    //   18: iconst_0
    //   19: anewarray 5	java/lang/Object
    //   22: invokestatic 95	com/tencent/mm/kernel/j:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: getstatic 76	com/tencent/mm/kernel/h:gdM	Lcom/tencent/mm/kernel/h;
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
    //   60: putstatic 76	com/tencent/mm/kernel/h:gdM	Lcom/tencent/mm/kernel/h;
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
  
  public final void a(com.tencent.mm.kernel.api.g paramg)
  {
    AppMethodBeat.i(158315);
    int i = 0;
    synchronized (this.gdP)
    {
      if (this.gdQ) {
        i = 1;
      }
      if (i != 0)
      {
        paramg.Lk();
        AppMethodBeat.o(158315);
        return;
      }
    }
    this.gdS.bv(paramg);
    AppMethodBeat.o(158315);
  }
  
  public final void a(com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(158318);
    j.qV("startup");
    synchronized (this.gdP)
    {
      if (this.gdQ)
      {
        com.tencent.mm.kernel.a.a.h("warning, mmskeleton has started up already.", new Object[0]);
        AppMethodBeat.o(158318);
        return;
      }
      ??? = afy().aeZ();
      final long l = System.currentTimeMillis();
      com.tencent.mm.kernel.a.a.h("mmskeleton boot startup for process [%s]...", new Object[] { ((com.tencent.mm.kernel.b.g)???).mProcessName });
      final com.tencent.mm.kernel.a.a locala = ((com.tencent.mm.kernel.b.g)???).gcO;
      locala.afL();
      com.tencent.mm.vending.g.c localc = com.tencent.mm.vending.g.g.fhq().xc(true);
      ((com.tencent.mm.kernel.b.g)???).gfE.gfG = System.currentTimeMillis();
      locala.Kv();
      ((com.tencent.mm.kernel.b.g)???).gfE.gfH = System.currentTimeMillis();
      locala.Kw();
      j.qV("installPlugins");
      ((com.tencent.mm.kernel.b.g)???).gfE.gfI = System.currentTimeMillis();
      locala.afM();
      ((com.tencent.mm.kernel.b.g)???).gfE.gfJ = System.currentTimeMillis();
      locala.a((com.tencent.mm.kernel.b.g)???);
      if (paramd != null) {
        localc.b(paramd);
      }
      ((com.tencent.mm.kernel.b.g)???).gfE.gfK = System.currentTimeMillis();
      localc.c(new com.tencent.mm.vending.c.a() {});
      ((com.tencent.mm.kernel.b.g)???).gfE.gfL = System.currentTimeMillis();
      localc.c(new com.tencent.mm.vending.c.a() {});
      ((com.tencent.mm.kernel.b.g)???).gfE.gfM = System.currentTimeMillis();
      localc.a(com.tencent.mm.vending.h.d.HQL, new d.b()
      {
        public final void br(Object arg1)
        {
          AppMethodBeat.i(158306);
          j.qV("executeBootExtension");
          synchronized (h.this.gdP)
          {
            h.this.gdQ = true;
            com.tencent.mm.kernel.a.a.h("summerboot mmskeleton boot startup finished in [%s]!", new Object[] { com.tencent.mm.kernel.a.a.lx(l) });
            h.this.gdS.Lk();
            j.qV("onStartupDone");
            h.this.gdR = System.currentTimeMillis();
            this.cLs.gfE.gfN = h.this.gdR;
            AppMethodBeat.o(158306);
            return;
          }
        }
      });
      AppMethodBeat.o(158318);
      return;
    }
  }
  
  public final c afx()
  {
    AppMethodBeat.i(158312);
    Assert.assertNotNull("mCorePlugins not initialized!", this.gdN);
    c localc = this.gdN;
    AppMethodBeat.o(158312);
    return localc;
  }
  
  public final d<_Profile> afy()
  {
    AppMethodBeat.i(158313);
    Assert.assertNotNull("mCoreProcess not initialized!", this.gdO);
    d locald = this.gdO;
    AppMethodBeat.o(158313);
    return locald;
  }
  
  public final void b(com.tencent.mm.kernel.api.g paramg)
  {
    AppMethodBeat.i(158316);
    this.gdS.remove(paramg);
    AppMethodBeat.o(158316);
  }
  
  static final class a
    extends com.tencent.mm.co.a<com.tencent.mm.kernel.api.g>
    implements com.tencent.mm.kernel.api.g
  {
    public a()
    {
      super();
    }
    
    public final void Lk()
    {
      AppMethodBeat.i(158309);
      a(new a.a() {});
      AppMethodBeat.o(158309);
    }
    
    public final void ce(final boolean paramBoolean)
    {
      AppMethodBeat.i(158310);
      a(new a.a() {});
      AppMethodBeat.o(158310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.h
 * JD-Core Version:    0.7.0.1
 */