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
  public Class<? extends com.tencent.mm.kernel.b.a> mCA;
  private com.tencent.mm.kernel.a.a mCB;
  private final ConcurrentHashMap<Class<? extends com.tencent.mm.kernel.b.a>, f> mCt;
  private final ArrayList<f> mCu;
  private final ConcurrentHashMap<Class<? extends f>, ArrayList<Class<? extends com.tencent.mm.kernel.b.a>>> mCv;
  private final ConcurrentHashMap<Class<? extends com.tencent.mm.kernel.b.a>, Class<? extends f>> mCw;
  public com.tencent.mm.kernel.a.a.a<Class<? extends f>> mCx;
  private com.tencent.mm.kernel.c.d mCy;
  protected a mCz;
  
  public d()
  {
    AppMethodBeat.i(158284);
    this.mCt = new ConcurrentHashMap();
    this.mCu = new ArrayList();
    this.mCv = new ConcurrentHashMap();
    this.mCw = new ConcurrentHashMap();
    this.mCx = new com.tencent.mm.kernel.a.a.a();
    this.mCy = new com.tencent.mm.kernel.c.d();
    this.mCA = null;
    this.mCy.a(new com.tencent.mm.kernel.c.d.a()
    {
      public final void a(Class<? extends com.tencent.mm.kernel.c.a> paramAnonymousClass, com.tencent.mm.kernel.c.a paramAnonymousa)
      {
        AppMethodBeat.i(158283);
        if (d.this.mCz != null) {
          d.this.mCz.c(paramAnonymousa);
        }
        AppMethodBeat.o(158283);
      }
      
      public final void a(Class<? extends com.tencent.mm.kernel.c.a> paramAnonymousClass, c paramAnonymousc)
      {
        AppMethodBeat.i(158281);
        if (((paramAnonymousc instanceof com.tencent.mm.kernel.c.e)) && (d.this.mCz != null)) {
          d.this.mCz.a(paramAnonymousc.bbD());
        }
        AppMethodBeat.o(158281);
      }
      
      public final void b(Class<? extends com.tencent.mm.kernel.c.a> paramAnonymousClass, c paramAnonymousc)
      {
        AppMethodBeat.i(158282);
        if (((paramAnonymousc instanceof com.tencent.mm.kernel.c.e)) && (d.this.mCz != null)) {
          d.this.mCz.b(paramAnonymousc.bbD());
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
        if (aw(paramf.getClass()))
        {
          l.w("MMSkeleton.CorePlugins", "Plugin %s has been installed.", new Object[] { paramf.getClass() });
          paramf = (f)aA(paramf.getClass());
          AppMethodBeat.o(158289);
          return paramf;
        }
        Assert.assertNotNull(paramf);
        String[] arrayOfString = paramf.ofProcesses();
        if ((arrayOfString != null) && (arrayOfString.length > 0))
        {
          com.tencent.mm.kernel.b.g localg = i.baI().baB().bad();
          int j = arrayOfString.length;
          int i = 0;
          boolean bool1 = false;
          boolean bool2 = bool1;
          if (i < j)
          {
            bool1 = localg.FH(arrayOfString[i]);
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
      this.mCt.put(paramf.getClass(), paramf);
      this.mCu.add(paramf);
      paramf.invokeInstalled();
      if (this.mCz != null) {
        this.mCz.b(paramf);
      }
      AppMethodBeat.o(158289);
    }
  }
  
  private <T extends com.tencent.mm.kernel.b.a> T aA(Class<T> paramClass)
  {
    try
    {
      AppMethodBeat.i(158296);
      Assert.assertNotNull(paramClass);
      paramClass = (com.tencent.mm.kernel.b.a)this.mCt.get(paramClass);
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
  private boolean aB(Class<? extends com.tencent.mm.kernel.b.a> paramClass)
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
    //   15: invokevirtual 88	com/tencent/mm/kernel/d:aw	(Ljava/lang/Class;)Z
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
  
  public final f B(String paramString, boolean paramBoolean)
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
        i.baI().baB().bad();
        l.baJ();
        continue;
      }
      paramString = null;
      AppMethodBeat.o(158288);
    }
  }
  
  public final f Fx(String paramString)
  {
    try
    {
      AppMethodBeat.i(158287);
      paramString = B(paramString, false);
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
    this.mCy.c(paramClass, paramc);
    AppMethodBeat.o(158293);
  }
  
  public final f av(Class<? extends f> paramClass)
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
  
  public final boolean aw(Class<? extends com.tencent.mm.kernel.b.a> paramClass)
  {
    try
    {
      AppMethodBeat.i(158290);
      boolean bool = this.mCt.containsKey(paramClass);
      AppMethodBeat.o(158290);
      return bool;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public final <T extends com.tencent.mm.kernel.c.a> T ax(Class<T> paramClass)
  {
    AppMethodBeat.i(158292);
    com.tencent.mm.kernel.c.a locala = this.mCy.aH(paramClass);
    int i;
    if (locala == null) {
      if (paramClass != null)
      {
        Object localObject = (com.tencent.mm.kernel.b.e)paramClass.getAnnotation(com.tencent.mm.kernel.b.e.class);
        if ((localObject != null) && (((com.tencent.mm.kernel.b.e)localObject).Dr() != null))
        {
          localObject = az(((com.tencent.mm.kernel.b.e)localObject).Dr());
          if ((localObject != null) && (!g.cR(localObject)))
          {
            i = 1;
            if (i == 0) {
              break label158;
            }
            l.i("MMSkeleton.CorePlugins", "Try load OwnerPlugin for service(%s)...", new Object[] { paramClass });
            locala = this.mCy.aH(paramClass);
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
      i.baI().baB().bad();
      l.baJ();
      paramClass = (com.tencent.mm.kernel.c.a)g.aC(paramClass);
      AppMethodBeat.o(158292);
      return paramClass;
    }
  }
  
  public final void ay(Class<? extends com.tencent.mm.kernel.c.a> paramClass)
  {
    AppMethodBeat.i(158294);
    this.mCy.ay(paramClass);
    AppMethodBeat.o(158294);
  }
  
  public final <T extends com.tencent.mm.kernel.b.a> T az(Class<T> paramClass)
  {
    for (;;)
    {
      com.tencent.mm.kernel.b.a locala;
      try
      {
        AppMethodBeat.i(158295);
        locala = aA(paramClass);
        if (this.mCz != null) {
          this.mCz.c((f)locala);
        }
        if (locala == null)
        {
          paramClass = (com.tencent.mm.kernel.b.a)g.aC(paramClass);
          AppMethodBeat.o(158295);
          return paramClass;
        }
      }
      finally {}
      paramClass = locala;
    }
  }
  
  public final void bab()
  {
    try
    {
      AppMethodBeat.i(158299);
      Iterator localIterator = this.mCu.iterator();
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
  
  public final List<f> bac()
  {
    try
    {
      ArrayList localArrayList = this.mCu;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void f(Class<? extends f> paramClass, Class<? extends com.tencent.mm.kernel.b.a> paramClass1)
  {
    try
    {
      AppMethodBeat.i(158291);
      Assert.assertNotNull(paramClass);
      Assert.assertNotNull(paramClass1);
      f localf = (f)this.mCt.get(paramClass);
      Assert.assertNotNull(localf);
      ArrayList localArrayList2 = (ArrayList)this.mCv.get(paramClass);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.mCv.put(paramClass, localArrayList1);
      }
      this.mCw.put(paramClass1, paramClass);
      localArrayList1.add(paramClass1);
      this.mCt.put(paramClass1, localf);
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
    if (!aB(paramClass1))
    {
      paramClass = String.format("depends plugin %s not install, plugin %s will not add in to dependency tree", new Object[] { paramClass1.getName(), paramClass.getName() });
      l.e("MMSkeleton.CorePlugins", paramClass, new Object[0]);
      paramClass = new IllegalAccessError(paramClass);
      AppMethodBeat.o(158298);
      throw paramClass;
    }
    Object localObject = paramClass1;
    if (this.mCw.containsKey(paramClass1)) {
      localObject = (Class)this.mCw.get(paramClass1);
    }
    this.mCx.D(paramClass, localObject);
    if (this.mCB == null) {
      this.mCB = i.baI().baB().bad().mCB;
    }
    paramClass = (f)aA(paramClass);
    paramClass1 = (f)aA((Class)localObject);
    this.mCB.mDQ.a(com.tencent.mm.kernel.b.b.class, paramClass, paramClass1);
    this.mCB.mDQ.a(com.tencent.mm.kernel.a.c.b.class, paramClass, paramClass1);
    AppMethodBeat.o(158298);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.kernel.d
 * JD-Core Version:    0.7.0.1
 */