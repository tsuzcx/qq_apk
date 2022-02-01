package com.tencent.matrix.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Printer;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
  public static boolean eYL = false;
  private static volatile HandlerThread fiT;
  private static volatile Handler fiU;
  private static volatile Handler fiV = new Handler(Looper.getMainLooper());
  private static HashSet<HandlerThread> fiW = new HashSet();
  
  public static HandlerThread T(String paramString, int paramInt)
  {
    Object localObject = fiW.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!((HandlerThread)((Iterator)localObject).next()).isAlive())
      {
        ((Iterator)localObject).remove();
        c.w("Matrix.HandlerThread", "warning: remove dead handler thread with name %s", new Object[] { paramString });
      }
    }
    localObject = new HandlerThread(paramString);
    ((HandlerThread)localObject).setPriority(paramInt);
    ((HandlerThread)localObject).start();
    fiW.add(localObject);
    c.w("Matrix.HandlerThread", "warning: create new handler thread with name %s, alive thread size:%d", new Object[] { paramString, Integer.valueOf(fiW.size()) });
    return localObject;
  }
  
  public static Handler aAn()
  {
    return fiV;
  }
  
  /* Error */
  public static HandlerThread aAo()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 113	com/tencent/matrix/e/b:fiT	Landroid/os/HandlerThread;
    //   6: ifnonnull +83 -> 89
    //   9: new 65	android/os/HandlerThread
    //   12: dup
    //   13: ldc 115
    //   15: invokespecial 84	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   18: astore_0
    //   19: aload_0
    //   20: putstatic 113	com/tencent/matrix/e/b:fiT	Landroid/os/HandlerThread;
    //   23: aload_0
    //   24: invokevirtual 91	android/os/HandlerThread:start	()V
    //   27: new 25	android/os/Handler
    //   30: dup
    //   31: getstatic 113	com/tencent/matrix/e/b:fiT	Landroid/os/HandlerThread;
    //   34: invokevirtual 118	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   37: invokespecial 35	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   40: putstatic 120	com/tencent/matrix/e/b:fiU	Landroid/os/Handler;
    //   43: getstatic 113	com/tencent/matrix/e/b:fiT	Landroid/os/HandlerThread;
    //   46: invokevirtual 118	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   49: astore_1
    //   50: getstatic 45	com/tencent/matrix/e/b:eYL	Z
    //   53: ifeq +45 -> 98
    //   56: new 6	com/tencent/matrix/e/b$a
    //   59: dup
    //   60: invokespecial 121	com/tencent/matrix/e/b$a:<init>	()V
    //   63: astore_0
    //   64: aload_1
    //   65: aload_0
    //   66: invokevirtual 125	android/os/Looper:setMessageLogging	(Landroid/util/Printer;)V
    //   69: ldc 73
    //   71: ldc 127
    //   73: iconst_1
    //   74: anewarray 4	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: getstatic 45	com/tencent/matrix/e/b:eYL	Z
    //   82: invokestatic 132	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   85: aastore
    //   86: invokestatic 81	com/tencent/matrix/e/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: getstatic 113	com/tencent/matrix/e/b:fiT	Landroid/os/HandlerThread;
    //   92: astore_0
    //   93: ldc 2
    //   95: monitorexit
    //   96: aload_0
    //   97: areturn
    //   98: aconst_null
    //   99: astore_0
    //   100: goto -36 -> 64
    //   103: astore_0
    //   104: ldc 2
    //   106: monitorexit
    //   107: aload_0
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	82	0	localObject1	Object
    //   103	5	0	localObject2	Object
    //   49	16	1	localLooper	Looper
    // Exception table:
    //   from	to	target	type
    //   3	64	103	finally
    //   64	89	103	finally
    //   89	96	103	finally
  }
  
  public static Handler aAp()
  {
    if (fiU == null) {
      aAo();
    }
    return fiU;
  }
  
  static final class a
    implements Printer, com.tencent.matrix.b.a
  {
    private boolean ffv;
    private ConcurrentHashMap<String, a> fiX = new ConcurrentHashMap();
    
    a()
    {
      com.tencent.matrix.a.eLw.a(this);
      this.ffv = com.tencent.matrix.a.eLw.eLx;
    }
    
    public final void onForeground(boolean paramBoolean)
    {
      this.ffv = paramBoolean;
      if (paramBoolean)
      {
        long l = System.currentTimeMillis();
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = this.fiX.values().iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (locala.count > 1) {
            localLinkedList.add(locala);
          }
        }
        Collections.sort(localLinkedList, new Comparator() {});
        this.fiX.clear();
        if (!localLinkedList.isEmpty()) {
          c.i("Matrix.HandlerThread", "matrix default thread has exec in background! %s cost:%s", new Object[] { localLinkedList, Long.valueOf(System.currentTimeMillis() - l) });
        }
        return;
      }
      this.fiX.clear();
    }
    
    public final void println(String paramString)
    {
      if (this.ffv) {}
      int i;
      int j;
      do
      {
        do
        {
          return;
        } while (paramString.charAt(0) != '>');
        i = paramString.indexOf("} ");
        j = paramString.indexOf("@", i);
      } while ((i < 0) || (j < 0));
      String str = paramString.substring(i, j);
      a locala = (a)this.fiX.get(str);
      paramString = locala;
      if (locala == null)
      {
        paramString = new a();
        paramString.key = str;
        this.fiX.put(str, paramString);
      }
      paramString.count += 1;
    }
    
    final class a
    {
      int count;
      String key;
      
      a() {}
      
      public final String toString()
      {
        return this.key + ":" + this.count;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.e.b
 * JD-Core Version:    0.7.0.1
 */