package com.tencent.matrix;

import android.app.Application;
import com.tencent.matrix.b.c;
import com.tencent.matrix.d.b.a;
import java.util.HashSet;
import java.util.Iterator;

public class a
{
  private static volatile a bmn;
  private final Application application;
  public final HashSet<com.tencent.matrix.b.b> bmo;
  private final c bmp;
  
  private a(Application paramApplication, c paramc, HashSet<com.tencent.matrix.b.b> paramHashSet)
  {
    this.application = paramApplication;
    this.bmp = paramc;
    this.bmo = paramHashSet;
    paramApplication = paramHashSet.iterator();
    while (paramApplication.hasNext())
    {
      paramc = (com.tencent.matrix.b.b)paramApplication.next();
      paramc.a(this.application, this.bmp);
      this.bmp.b(paramc);
    }
  }
  
  /* Error */
  public static a a(a parama)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 63	com/tencent/matrix/a:bmn	Lcom/tencent/matrix/a;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: putstatic 63	com/tencent/matrix/a:bmn	Lcom/tencent/matrix/a;
    //   13: ldc 2
    //   15: monitorexit
    //   16: getstatic 63	com/tencent/matrix/a:bmn	Lcom/tencent/matrix/a;
    //   19: areturn
    //   20: ldc 65
    //   22: ldc 67
    //   24: iconst_0
    //   25: anewarray 4	java/lang/Object
    //   28: invokestatic 73	com/tencent/matrix/d/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: goto -18 -> 13
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	parama	a
    // Exception table:
    //   from	to	target	type
    //   3	13	34	finally
    //   13	16	34	finally
    //   20	31	34	finally
    //   35	38	34	finally
  }
  
  public static void a(b.a parama)
  {
    com.tencent.matrix.d.b.b(parama);
  }
  
  public static boolean isInstalled()
  {
    return bmn != null;
  }
  
  public static a qO()
  {
    if (bmn == null) {
      throw new RuntimeException("you must init Matrix sdk first");
    }
    return bmn;
  }
  
  public final <T extends com.tencent.matrix.b.b> T l(Class<T> paramClass)
  {
    paramClass = paramClass.getName();
    Iterator localIterator = this.bmo.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.matrix.b.b localb = (com.tencent.matrix.b.b)localIterator.next();
      if (localb.getClass().getName().equals(paramClass)) {
        return localb;
      }
    }
    return null;
  }
  
  public static final class a
  {
    public final Application application;
    public HashSet<com.tencent.matrix.b.b> bmo;
    public c bmp;
    
    public a(Application paramApplication)
    {
      if (paramApplication == null) {
        throw new RuntimeException("matrix init, application is null");
      }
      this.application = paramApplication;
    }
    
    public final a a(com.tencent.matrix.b.b paramb)
    {
      if (this.bmo == null) {
        this.bmo = new HashSet();
      }
      String str = paramb.getTag();
      Iterator localIterator = this.bmo.iterator();
      while (localIterator.hasNext()) {
        if (str.equals(((com.tencent.matrix.b.b)localIterator.next()).getTag())) {
          throw new RuntimeException(String.format("plugin with tag %s is already exist", new Object[] { str }));
        }
      }
      this.bmo.add(paramb);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.a
 * JD-Core Version:    0.7.0.1
 */