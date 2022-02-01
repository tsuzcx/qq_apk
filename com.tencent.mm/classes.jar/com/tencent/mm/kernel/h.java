package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.a.a;
import com.tencent.mm.vending.g.d.b;
import junit.framework.Assert;

public final class h<_Profile extends com.tencent.mm.kernel.b.g>
{
  private static h gCc;
  private c gCd;
  private d<_Profile> gCe;
  byte[] gCf;
  public volatile boolean gCg;
  public long gCh;
  a gCi;
  
  private h(_Profile param_Profile)
  {
    AppMethodBeat.i(158311);
    this.gCf = new byte[0];
    this.gCg = false;
    this.gCi = new a();
    this.gCd = new c();
    this.gCe = new d(param_Profile);
    AppMethodBeat.o(158311);
  }
  
  public static <_Profile extends com.tencent.mm.kernel.b.g> h<_Profile> ajG()
  {
    AppMethodBeat.i(158314);
    Assert.assertNotNull("Skeleton not initialized!", gCc);
    h localh = gCc;
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
    //   8: getstatic 76	com/tencent/mm/kernel/h:gCc	Lcom/tencent/mm/kernel/h;
    //   11: ifnull +28 -> 39
    //   14: ldc 88
    //   16: ldc 90
    //   18: iconst_0
    //   19: anewarray 5	java/lang/Object
    //   22: invokestatic 95	com/tencent/mm/kernel/j:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: getstatic 76	com/tencent/mm/kernel/h:gCc	Lcom/tencent/mm/kernel/h;
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
    //   60: putstatic 76	com/tencent/mm/kernel/h:gCc	Lcom/tencent/mm/kernel/h;
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
    synchronized (this.gCf)
    {
      if (this.gCg) {
        i = 1;
      }
      if (i != 0)
      {
        paramg.MP();
        AppMethodBeat.o(158315);
        return;
      }
    }
    this.gCi.bu(paramg);
    AppMethodBeat.o(158315);
  }
  
  public final void a(com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(158318);
    j.xa("startup");
    synchronized (this.gCf)
    {
      if (this.gCg)
      {
        com.tencent.mm.kernel.a.a.k("warning, mmskeleton has started up already.", new Object[0]);
        AppMethodBeat.o(158318);
        return;
      }
      ??? = ajz().ajb();
      final long l = System.currentTimeMillis();
      com.tencent.mm.kernel.a.a.k("mmskeleton boot startup for process [%s]...", new Object[] { ((com.tencent.mm.kernel.b.g)???).mProcessName });
      final com.tencent.mm.kernel.a.a locala = ((com.tencent.mm.kernel.b.g)???).gBe;
      locala.ajM();
      com.tencent.mm.vending.g.c localc = com.tencent.mm.vending.g.g.fOf().yX(true);
      ((com.tencent.mm.kernel.b.g)???).gDU.gDW = System.currentTimeMillis();
      locala.LE();
      ((com.tencent.mm.kernel.b.g)???).gDU.gDX = System.currentTimeMillis();
      locala.LF();
      j.xa("installPlugins");
      ((com.tencent.mm.kernel.b.g)???).gDU.gDY = System.currentTimeMillis();
      locala.ajN();
      ((com.tencent.mm.kernel.b.g)???).gDU.gDZ = System.currentTimeMillis();
      locala.a((com.tencent.mm.kernel.b.g)???);
      if (paramd != null) {
        localc.b(paramd);
      }
      ((com.tencent.mm.kernel.b.g)???).gDU.gEa = System.currentTimeMillis();
      localc.c(new com.tencent.mm.vending.c.a() {});
      ((com.tencent.mm.kernel.b.g)???).gDU.gEb = System.currentTimeMillis();
      localc.c(new com.tencent.mm.vending.c.a() {});
      ((com.tencent.mm.kernel.b.g)???).gDU.gEc = System.currentTimeMillis();
      localc.a(com.tencent.mm.vending.h.d.LiL, new d.b()
      {
        public final void bq(Object arg1)
        {
          AppMethodBeat.i(158306);
          j.xa("executeBootExtension");
          synchronized (h.this.gCf)
          {
            h.this.gCg = true;
            com.tencent.mm.kernel.a.a.k("summerboot mmskeleton boot startup finished in [%s]!", new Object[] { com.tencent.mm.kernel.a.a.rb(l) });
            h.this.gCi.MP();
            j.xa("onStartupDone");
            h.this.gCh = System.currentTimeMillis();
            this.cTI.gDU.gEd = h.this.gCh;
            AppMethodBeat.o(158306);
            return;
          }
        }
      });
      AppMethodBeat.o(158318);
      return;
    }
  }
  
  public final c ajy()
  {
    AppMethodBeat.i(158312);
    Assert.assertNotNull("mCorePlugins not initialized!", this.gCd);
    c localc = this.gCd;
    AppMethodBeat.o(158312);
    return localc;
  }
  
  public final d<_Profile> ajz()
  {
    AppMethodBeat.i(158313);
    Assert.assertNotNull("mCoreProcess not initialized!", this.gCe);
    d locald = this.gCe;
    AppMethodBeat.o(158313);
    return locald;
  }
  
  public final void b(com.tencent.mm.kernel.api.g paramg)
  {
    AppMethodBeat.i(158316);
    this.gCi.remove(paramg);
    AppMethodBeat.o(158316);
  }
  
  static final class a
    extends com.tencent.mm.cn.a<com.tencent.mm.kernel.api.g>
    implements com.tencent.mm.kernel.api.g
  {
    public a()
    {
      super();
    }
    
    public final void MP()
    {
      AppMethodBeat.i(158309);
      a(new a.a() {});
      AppMethodBeat.o(158309);
    }
    
    public final void cg(final boolean paramBoolean)
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