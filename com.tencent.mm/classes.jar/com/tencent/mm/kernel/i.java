package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.a.a;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d.b;
import junit.framework.Assert;

public final class i<_Profile extends com.tencent.mm.kernel.b.g>
{
  private static i kds;
  private d kdt;
  private e<_Profile> kdu;
  byte[] kdv;
  public volatile boolean kdw;
  public long kdx;
  a kdy;
  
  private i(_Profile param_Profile)
  {
    AppMethodBeat.i(158311);
    this.kdv = new byte[0];
    this.kdw = false;
    this.kdy = new a();
    this.kdt = new d();
    this.kdu = new e(param_Profile);
    AppMethodBeat.o(158311);
  }
  
  public static <_Profile extends com.tencent.mm.kernel.b.g> i<_Profile> aHL()
  {
    AppMethodBeat.i(158314);
    Assert.assertNotNull("Skeleton not initialized!", kds);
    i locali = kds;
    AppMethodBeat.o(158314);
    return locali;
  }
  
  /* Error */
  public static <_Profile extends com.tencent.mm.kernel.b.g> i<_Profile> d(_Profile param_Profile)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 86
    //   5: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 76	com/tencent/mm/kernel/i:kds	Lcom/tencent/mm/kernel/i;
    //   11: ifnull +28 -> 39
    //   14: ldc 88
    //   16: ldc 90
    //   18: iconst_0
    //   19: anewarray 5	java/lang/Object
    //   22: invokestatic 95	com/tencent/mm/kernel/l:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: getstatic 76	com/tencent/mm/kernel/i:kds	Lcom/tencent/mm/kernel/i;
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
    //   47: invokestatic 95	com/tencent/mm/kernel/l:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: new 2	com/tencent/mm/kernel/i
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 98	com/tencent/mm/kernel/i:<init>	(Lcom/tencent/mm/kernel/b/g;)V
    //   58: astore_0
    //   59: aload_0
    //   60: putstatic 76	com/tencent/mm/kernel/i:kds	Lcom/tencent/mm/kernel/i;
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
    synchronized (this.kdv)
    {
      if (this.kdw) {
        i = 1;
      }
      if (i != 0)
      {
        paramg.abB();
        AppMethodBeat.o(158315);
        return;
      }
    }
    this.kdy.add(paramg);
    AppMethodBeat.o(158315);
  }
  
  public final void a(com.tencent.mm.vending.h.d paramd)
  {
    AppMethodBeat.i(158318);
    l.MT("startup");
    synchronized (this.kdv)
    {
      if (this.kdw)
      {
        com.tencent.mm.kernel.a.a.j("warning, mmskeleton has started up already.", new Object[0]);
        AppMethodBeat.o(158318);
        return;
      }
      ??? = aHD().aHf();
      final long l = System.currentTimeMillis();
      com.tencent.mm.kernel.a.a.j("mmskeleton boot startup for process [%s]...", new Object[] { ((com.tencent.mm.kernel.b.g)???).mProcessName });
      final com.tencent.mm.kernel.a.a locala = ((com.tencent.mm.kernel.b.g)???).kct;
      locala.aHS();
      c localc = com.tencent.mm.vending.g.g.ieN().HR(true);
      ((com.tencent.mm.kernel.b.g)???).kfk.kfn = System.currentTimeMillis();
      locala.aau();
      ((com.tencent.mm.kernel.b.g)???).kfk.kfo = System.currentTimeMillis();
      locala.aav();
      l.MT("installPlugins");
      ((com.tencent.mm.kernel.b.g)???).kfk.kfp = System.currentTimeMillis();
      locala.aHT();
      ((com.tencent.mm.kernel.b.g)???).kfk.kfq = System.currentTimeMillis();
      locala.a((com.tencent.mm.kernel.b.g)???);
      if (paramd != null) {
        localc.b(paramd);
      }
      ((com.tencent.mm.kernel.b.g)???).kfk.kfr = System.currentTimeMillis();
      localc.c(new com.tencent.mm.vending.c.a() {});
      ((com.tencent.mm.kernel.b.g)???).kfk.kfs = System.currentTimeMillis();
      localc.c(new com.tencent.mm.vending.c.a() {});
      ((com.tencent.mm.kernel.b.g)???).kfk.kft = System.currentTimeMillis();
      localc.a(com.tencent.mm.vending.h.d.UI, new d.b()
      {
        public final void bz(Object arg1)
        {
          AppMethodBeat.i(158306);
          l.MT("executeBootExtension");
          synchronized (i.this.kdv)
          {
            i.this.kdw = true;
            com.tencent.mm.kernel.a.a.j("summerboot mmskeleton boot startup finished in [%s]!", new Object[] { com.tencent.mm.kernel.a.a.Fv(l) });
            i.this.kdy.abB();
            l.MT("onStartupDone");
            i.this.kdx = System.currentTimeMillis();
            this.fcw.kfk.kfu = i.this.kdx;
            AppMethodBeat.o(158306);
            return;
          }
        }
      });
      AppMethodBeat.o(158318);
      return;
    }
  }
  
  public final d aHC()
  {
    AppMethodBeat.i(158312);
    Assert.assertNotNull("mCorePlugins not initialized!", this.kdt);
    d locald = this.kdt;
    AppMethodBeat.o(158312);
    return locald;
  }
  
  public final e<_Profile> aHD()
  {
    AppMethodBeat.i(158313);
    Assert.assertNotNull("mCoreProcess not initialized!", this.kdu);
    e locale = this.kdu;
    AppMethodBeat.o(158313);
    return locale;
  }
  
  public final void b(com.tencent.mm.kernel.api.g paramg)
  {
    AppMethodBeat.i(158316);
    this.kdy.remove(paramg);
    AppMethodBeat.o(158316);
  }
  
  static final class a
    extends com.tencent.mm.cw.a<com.tencent.mm.kernel.api.g>
    implements com.tencent.mm.kernel.api.g
  {
    public a()
    {
      super();
    }
    
    public final void abB()
    {
      AppMethodBeat.i(158309);
      a(new a.a() {});
      AppMethodBeat.o(158309);
    }
    
    public final void dn(final boolean paramBoolean)
    {
      AppMethodBeat.i(158310);
      a(new a.a() {});
      AppMethodBeat.o(158310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kernel.i
 * JD-Core Version:    0.7.0.1
 */