package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class d
{
  private final ConcurrentHashMap<Class<? extends com.tencent.mm.kernel.b.a>, f> kcl;
  private final ArrayList<f> kcm;
  private final ConcurrentHashMap<Class<? extends f>, ArrayList<Class<? extends com.tencent.mm.kernel.b.a>>> kcn;
  private final ConcurrentHashMap<Class<? extends com.tencent.mm.kernel.b.a>, Class<? extends f>> kco;
  public com.tencent.mm.kernel.a.a.a<Class<? extends f>> kcp;
  private com.tencent.mm.kernel.c.d kcq;
  protected a kcr;
  public Class<? extends com.tencent.mm.kernel.b.a> kcs;
  private com.tencent.mm.kernel.a.a kct;
  
  public d()
  {
    AppMethodBeat.i(158284);
    this.kcl = new ConcurrentHashMap();
    this.kcm = new ArrayList();
    this.kcn = new ConcurrentHashMap();
    this.kco = new ConcurrentHashMap();
    this.kcp = new com.tencent.mm.kernel.a.a.a();
    this.kcq = new com.tencent.mm.kernel.c.d();
    this.kcs = null;
    this.kcq.a(new com.tencent.mm.kernel.c.d.a()
    {
      public final void a(Class<? extends com.tencent.mm.kernel.c.a> paramAnonymousClass, com.tencent.mm.kernel.c.a paramAnonymousa)
      {
        AppMethodBeat.i(158283);
        if (d.this.kcr != null) {
          d.this.kcr.c(paramAnonymousa);
        }
        AppMethodBeat.o(158283);
      }
      
      public final void a(Class<? extends com.tencent.mm.kernel.c.a> paramAnonymousClass, c paramAnonymousc)
      {
        AppMethodBeat.i(158281);
        if (((paramAnonymousc instanceof com.tencent.mm.kernel.c.e)) && (d.this.kcr != null)) {
          d.this.kcr.a(paramAnonymousc.aIH());
        }
        AppMethodBeat.o(158281);
      }
      
      public final void b(Class<? extends com.tencent.mm.kernel.c.a> paramAnonymousClass, c paramAnonymousc)
      {
        AppMethodBeat.i(158282);
        if (((paramAnonymousc instanceof com.tencent.mm.kernel.c.e)) && (d.this.kcr != null)) {
          d.this.kcr.b(paramAnonymousc.aIH());
        }
        AppMethodBeat.o(158282);
      }
    });
    AppMethodBeat.o(158284);
  }
  
  private f a(f paramf)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(158289);
        if (ad(paramf.getClass()))
        {
          l.w("MMSkeleton.CorePlugins", "Plugin %s has been installed.", new Object[] { paramf.getClass() });
          paramf = (f)ah(paramf.getClass());
          AppMethodBeat.o(158289);
          return paramf;
        }
        Assert.assertNotNull(paramf);
        String[] arrayOfString = paramf.ofProcesses();
        if ((arrayOfString != null) && (arrayOfString.length > 0))
        {
          com.tencent.mm.kernel.b.g localg = i.aHL().aHD().aHf();
          int j = arrayOfString.length;
          int i = 0;
          boolean bool1 = false;
          boolean bool2 = bool1;
          if (i < j)
          {
            bool1 = localg.MY(arrayOfString[i]);
            bool2 = bool1;
            if (!bool1)
            {
              i += 1;
              continue;
            }
          }
          if (!bool2)
          {
            paramf = new IllegalStateException(String.format("Plugin %s can't install in process %s. It only support process %s.", new Object[] { paramf, localg.mProcessName, Arrays.asList(arrayOfString) }));
            AppMethodBeat.o(158289);
            throw paramf;
          }
        }
      }
      finally {}
      this.kcl.put(paramf.getClass(), paramf);
      this.kcm.add(paramf);
      paramf.invokeInstalled();
      if (this.kcr != null) {
        this.kcr.b(paramf);
      }
      AppMethodBeat.o(158289);
    }
  }
  
  private <T extends com.tencent.mm.kernel.b.a> T ah(Class<T> paramClass)
  {
    try
    {
      AppMethodBeat.i(158296);
      Assert.assertNotNull(paramClass);
      paramClass = (com.tencent.mm.kernel.b.a)this.kcl.get(paramClass);
      AppMethodBeat.o(158296);
      return paramClass;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  /* Error */
  private boolean ai(Class<? extends com.tencent.mm.kernel.b.a> paramClass)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 187
    //   6: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: invokestatic 110	junit/framework/Assert:assertNotNull	(Ljava/lang/Object;)V
    //   13: aload_0
    //   14: aload_1
    //   15: invokevirtual 88	com/tencent/mm/kernel/d:ad	(Ljava/lang/Class;)Z
    //   18: ifne +42 -> 60
    //   21: ldc 90
    //   23: new 189	java/lang/StringBuilder
    //   26: dup
    //   27: ldc 191
    //   29: invokespecial 192	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   32: aload_1
    //   33: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   36: ldc 198
    //   38: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: iconst_0
    //   45: anewarray 4	java/lang/Object
    //   48: invokestatic 98	com/tencent/mm/kernel/l:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: ldc 187
    //   53: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_0
    //   57: monitorexit
    //   58: iload_2
    //   59: ireturn
    //   60: iconst_1
    //   61: istore_2
    //   62: ldc 187
    //   64: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: goto -11 -> 56
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	d
    //   0	75	1	paramClass	Class<? extends com.tencent.mm.kernel.b.a>
    //   1	61	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	56	70	finally
    //   62	67	70	finally
  }
  
  private f b(Class<? extends f> paramClass, boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(158286);
      Assert.assertNotNull(paramClass);
      try
      {
        f localf = (f)paramClass.newInstance();
        if (paramBoolean) {
          localf.markAsPendingPlugin();
        }
        localf = a(localf);
        paramClass = localf;
        AppMethodBeat.o(158286);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          l.printErrStackTrace("MMSkeleton.CorePlugins", localException, "Install plugin %s failed.", new Object[] { paramClass });
          paramClass = null;
          AppMethodBeat.o(158286);
        }
      }
      return paramClass;
    }
    finally {}
  }
  
  public final f MO(String paramString)
  {
    try
    {
      AppMethodBeat.i(158287);
      paramString = z(paramString, false);
      AppMethodBeat.o(158287);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> paramClass, c<N> paramc)
  {
    AppMethodBeat.i(158293);
    this.kcq.c(paramClass, paramc);
    AppMethodBeat.o(158293);
  }
  
  public final void aHd()
  {
    try
    {
      AppMethodBeat.i(158299);
      Iterator localIterator = this.kcm.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (!localf.isDependencyMade()) {
          localf.invokeDependency();
        }
      }
      AppMethodBeat.o(158299);
    }
    finally {}
  }
  
  public final List<f> aHe()
  {
    try
    {
      ArrayList localArrayList = this.kcm;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final f ac(Class<? extends f> paramClass)
  {
    try
    {
      AppMethodBeat.i(158285);
      paramClass = b(paramClass, false);
      AppMethodBeat.o(158285);
      return paramClass;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public final boolean ad(Class<? extends com.tencent.mm.kernel.b.a> paramClass)
  {
    try
    {
      AppMethodBeat.i(158290);
      boolean bool = this.kcl.containsKey(paramClass);
      AppMethodBeat.o(158290);
      return bool;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public final <T extends com.tencent.mm.kernel.c.a> T ae(Class<T> paramClass)
  {
    AppMethodBeat.i(158292);
    com.tencent.mm.kernel.c.a locala = this.kcq.ao(paramClass);
    int i;
    if (locala == null) {
      if (paramClass != null)
      {
        Object localObject = (com.tencent.mm.kernel.b.e)paramClass.getAnnotation(com.tencent.mm.kernel.b.e.class);
        if ((localObject != null) && (((com.tencent.mm.kernel.b.e)localObject).gf() != null))
        {
          localObject = ag(((com.tencent.mm.kernel.b.e)localObject).gf());
          if ((localObject != null) && (!g.bx(localObject)))
          {
            i = 1;
            if (i == 0) {
              break label158;
            }
            l.i("MMSkeleton.CorePlugins", "Try load OwnerPlugin for service(%s)...", new Object[] { paramClass });
            locala = this.kcq.ao(paramClass);
          }
        }
      }
    }
    label158:
    for (;;)
    {
      if (locala != null)
      {
        AppMethodBeat.o(158292);
        return locala;
        i = 0;
        break;
        i = 0;
        break;
      }
      i.aHL().aHD().aHf();
      l.aHM();
      paramClass = (com.tencent.mm.kernel.c.a)g.aj(paramClass);
      AppMethodBeat.o(158292);
      return paramClass;
    }
  }
  
  public final void af(Class<? extends com.tencent.mm.kernel.c.a> paramClass)
  {
    AppMethodBeat.i(158294);
    this.kcq.af(paramClass);
    AppMethodBeat.o(158294);
  }
  
  public final <T extends com.tencent.mm.kernel.b.a> T ag(Class<T> paramClass)
  {
    for (;;)
    {
      com.tencent.mm.kernel.b.a locala;
      try
      {
        AppMethodBeat.i(158295);
        locala = ah(paramClass);
        if (this.kcr != null) {
          this.kcr.c((f)locala);
        }
        if (locala == null)
        {
          paramClass = (com.tencent.mm.kernel.b.a)g.aj(paramClass);
          AppMethodBeat.o(158295);
          return paramClass;
        }
      }
      finally {}
      paramClass = locala;
    }
  }
  
  public final void f(Class<? extends f> paramClass, Class<? extends com.tencent.mm.kernel.b.a> paramClass1)
  {
    try
    {
      AppMethodBeat.i(158291);
      Assert.assertNotNull(paramClass);
      Assert.assertNotNull(paramClass1);
      f localf = (f)this.kcl.get(paramClass);
      Assert.assertNotNull(localf);
      ArrayList localArrayList2 = (ArrayList)this.kcn.get(paramClass);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.kcn.put(paramClass, localArrayList1);
      }
      this.kco.put(paramClass1, paramClass);
      localArrayList1.add(paramClass1);
      this.kcl.put(paramClass1, localf);
      AppMethodBeat.o(158291);
      return;
    }
    finally {}
  }
  
  public final void g(Class<? extends f> paramClass, Class<? extends com.tencent.mm.kernel.b.a> paramClass1)
  {
    AppMethodBeat.i(158298);
    Assert.assertNotNull(paramClass);
    Assert.assertNotNull(paramClass1);
    if (!ai(paramClass1))
    {
      paramClass = String.format("depends plugin %s not install, plugin %s will not add in to dependency tree", new Object[] { paramClass1.getName(), paramClass.getName() });
      l.e("MMSkeleton.CorePlugins", paramClass, new Object[0]);
      paramClass = new IllegalAccessError(paramClass);
      AppMethodBeat.o(158298);
      throw paramClass;
    }
    Object localObject = paramClass1;
    if (this.kco.containsKey(paramClass1)) {
      localObject = (Class)this.kco.get(paramClass1);
    }
    this.kcp.s(paramClass, localObject);
    if (this.kct == null) {
      this.kct = i.aHL().aHD().aHf().kct;
    }
    paramClass = (f)ah(paramClass);
    paramClass1 = (f)ah((Class)localObject);
    this.kct.kdG.a(com.tencent.mm.kernel.b.b.class, paramClass, paramClass1);
    this.kct.kdG.a(com.tencent.mm.kernel.a.c.b.class, paramClass, paramClass1);
    AppMethodBeat.o(158298);
  }
  
  public final f z(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(158288);
      }
      finally {}
      try
      {
        localObject = Class.forName(paramString);
        if (f.class.isAssignableFrom((Class)localObject))
        {
          localObject = b((Class)localObject, paramBoolean);
          paramString = (String)localObject;
          AppMethodBeat.o(158288);
          return paramString;
        }
        l.e("MMSkeleton.CorePlugins", "class string %s, not a Plugin", new Object[] { paramString });
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        l.e("MMSkeleton.CorePlugins", "plugin %s not found.", new Object[] { paramString });
        i.aHL().aHD().aHf();
        l.aHM();
        continue;
      }
      paramString = null;
      AppMethodBeat.o(158288);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.kernel.c.a parama);
    
    public abstract void b(f paramf);
    
    public abstract void b(com.tencent.mm.kernel.c.a parama);
    
    public abstract void c(f paramf);
    
    public abstract void c(com.tencent.mm.kernel.c.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kernel.d
 * JD-Core Version:    0.7.0.1
 */