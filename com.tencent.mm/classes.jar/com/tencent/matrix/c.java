package com.tencent.matrix;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashSet;
import java.util.Iterator;

public class c
{
  private static volatile c eLD;
  public final Application application;
  public final HashSet<com.tencent.matrix.d.b> efL;
  private final com.tencent.matrix.d.c pluginListener;
  
  private c(Application paramApplication, com.tencent.matrix.d.c paramc, HashSet<com.tencent.matrix.d.b> paramHashSet)
  {
    this.application = paramApplication;
    this.pluginListener = paramc;
    this.efL = paramHashSet;
    paramApplication = a.eLw;
    paramc = this.application;
    if (paramApplication.isInit) {
      com.tencent.matrix.e.c.e("Matrix.AppActiveDelegate", "has inited!", new Object[0]);
    }
    for (;;)
    {
      paramApplication = paramHashSet.iterator();
      while (paramApplication.hasNext())
      {
        paramc = (com.tencent.matrix.d.b)paramApplication.next();
        paramc.init(this.application, this.pluginListener);
        this.pluginListener.b(paramc);
      }
      paramApplication.isInit = true;
      if (com.tencent.matrix.e.b.aAo() != null) {
        paramApplication.handler = new Handler(com.tencent.matrix.e.b.aAo().getLooper());
      }
      paramc.registerComponentCallbacks(paramApplication.eLz);
      paramc.registerActivityLifecycleCallbacks(paramApplication.eLz);
    }
  }
  
  /* Error */
  public static c a(c paramc)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 119	com/tencent/matrix/c:eLD	Lcom/tencent/matrix/c;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: putstatic 119	com/tencent/matrix/c:eLD	Lcom/tencent/matrix/c;
    //   13: ldc 2
    //   15: monitorexit
    //   16: getstatic 119	com/tencent/matrix/c:eLD	Lcom/tencent/matrix/c;
    //   19: areturn
    //   20: ldc 121
    //   22: ldc 123
    //   24: iconst_0
    //   25: anewarray 4	java/lang/Object
    //   28: invokestatic 47	com/tencent/matrix/e/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: goto -18 -> 13
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	paramc	c
    // Exception table:
    //   from	to	target	type
    //   3	13	34	finally
    //   13	16	34	finally
    //   20	31	34	finally
  }
  
  public static void a(com.tencent.matrix.e.c.a parama)
  {
    com.tencent.matrix.e.c.b(parama);
  }
  
  public static c avW()
  {
    if (eLD == null) {
      throw new RuntimeException("you must init Matrix sdk first");
    }
    return eLD;
  }
  
  public static boolean isInstalled()
  {
    return eLD != null;
  }
  
  public final <T extends com.tencent.matrix.d.b> T ai(Class<T> paramClass)
  {
    paramClass = paramClass.getName();
    Iterator localIterator = this.efL.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.matrix.d.b localb = (com.tencent.matrix.d.b)localIterator.next();
      if (localb.getClass().getName().equals(paramClass)) {
        return localb;
      }
    }
    return null;
  }
  
  public static final class a
  {
    final Application application;
    HashSet<com.tencent.matrix.d.b> efL = new HashSet();
    com.tencent.matrix.d.c pluginListener;
    
    public a(Application paramApplication)
    {
      if (paramApplication == null) {
        throw new RuntimeException("matrix init, application is null");
      }
      this.application = paramApplication;
    }
    
    public final a a(com.tencent.matrix.d.b paramb)
    {
      String str = paramb.getTag();
      Iterator localIterator = this.efL.iterator();
      while (localIterator.hasNext()) {
        if (str.equals(((com.tencent.matrix.d.b)localIterator.next()).getTag())) {
          throw new RuntimeException(String.format("plugin with tag %s is already exist", new Object[] { str }));
        }
      }
      this.efL.add(paramb);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.c
 * JD-Core Version:    0.7.0.1
 */