package com.tencent.matrix;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.g.c.a;
import java.util.HashSet;
import java.util.Iterator;

public class b
{
  private static volatile b cBI;
  public final Application application;
  public final HashSet<com.tencent.matrix.e.b> cBJ;
  private final com.tencent.matrix.e.c pluginListener;
  
  private b(Application paramApplication, com.tencent.matrix.e.c paramc, HashSet<com.tencent.matrix.e.b> paramHashSet)
  {
    this.application = paramApplication;
    this.pluginListener = paramc;
    this.cBJ = paramHashSet;
    paramApplication = a.cBz;
    paramc = this.application;
    if (paramApplication.cBE) {
      com.tencent.matrix.g.c.e("Matrix.AppActiveDelegate", "has inited!", new Object[0]);
    }
    for (;;)
    {
      paramApplication = paramHashSet.iterator();
      while (paramApplication.hasNext())
      {
        paramc = (com.tencent.matrix.e.b)paramApplication.next();
        paramc.init(this.application, this.pluginListener);
        this.pluginListener.b(paramc);
      }
      paramApplication.cBE = true;
      if (com.tencent.matrix.g.b.JB() != null) {
        paramApplication.handler = new Handler(com.tencent.matrix.g.b.JB().getLooper());
      }
      paramc.registerComponentCallbacks(paramApplication.cBD);
      paramc.registerActivityLifecycleCallbacks(paramApplication.cBD);
    }
  }
  
  public static boolean HS()
  {
    return cBI != null;
  }
  
  public static b HT()
  {
    if (cBI == null) {
      throw new RuntimeException("you must init Matrix sdk first");
    }
    return cBI;
  }
  
  /* Error */
  public static b a(b paramb)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 119	com/tencent/matrix/b:cBI	Lcom/tencent/matrix/b;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: putstatic 119	com/tencent/matrix/b:cBI	Lcom/tencent/matrix/b;
    //   13: ldc 2
    //   15: monitorexit
    //   16: getstatic 119	com/tencent/matrix/b:cBI	Lcom/tencent/matrix/b;
    //   19: areturn
    //   20: ldc 131
    //   22: ldc 133
    //   24: iconst_0
    //   25: anewarray 4	java/lang/Object
    //   28: invokestatic 47	com/tencent/matrix/g/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: goto -18 -> 13
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	paramb	b
    // Exception table:
    //   from	to	target	type
    //   3	13	34	finally
    //   13	16	34	finally
    //   20	31	34	finally
    //   35	38	34	finally
  }
  
  public static void a(c.a parama)
  {
    com.tencent.matrix.g.c.b(parama);
  }
  
  public final <T extends com.tencent.matrix.e.b> T V(Class<T> paramClass)
  {
    paramClass = paramClass.getName();
    Iterator localIterator = this.cBJ.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.matrix.e.b localb = (com.tencent.matrix.e.b)localIterator.next();
      if (localb.getClass().getName().equals(paramClass)) {
        return localb;
      }
    }
    return null;
  }
  
  public static final class a
  {
    final Application application;
    HashSet<com.tencent.matrix.e.b> cBJ = new HashSet();
    com.tencent.matrix.e.c pluginListener;
    
    public a(Application paramApplication)
    {
      if (paramApplication == null) {
        throw new RuntimeException("matrix init, application is null");
      }
      this.application = paramApplication;
    }
    
    public final a a(com.tencent.matrix.e.b paramb)
    {
      String str = paramb.getTag();
      Iterator localIterator = this.cBJ.iterator();
      while (localIterator.hasNext()) {
        if (str.equals(((com.tencent.matrix.e.b)localIterator.next()).getTag())) {
          throw new RuntimeException(String.format("plugin with tag %s is already exist", new Object[] { str }));
        }
      }
      this.cBJ.add(paramb);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.b
 * JD-Core Version:    0.7.0.1
 */