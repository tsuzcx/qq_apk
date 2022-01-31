package com.tencent.matrix.g;

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
  private static volatile HandlerThread bTY;
  private static volatile Handler bTZ;
  private static volatile Handler bUa = new Handler(Looper.getMainLooper());
  private static HashSet<HandlerThread> bUb = new HashSet();
  public static boolean isDebug = false;
  
  public static HandlerThread cD(String paramString)
  {
    Object localObject = bUb.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!((HandlerThread)((Iterator)localObject).next()).isAlive())
      {
        ((Iterator)localObject).remove();
        c.w("Matrix.HandlerThread", "warning: remove dead handler thread with name %s", new Object[] { paramString });
      }
    }
    localObject = new HandlerThread(paramString);
    ((HandlerThread)localObject).start();
    bUb.add(localObject);
    c.w("Matrix.HandlerThread", "warning: create new handler thread with name %s, alive thread size:%d", new Object[] { paramString, Integer.valueOf(bUb.size()) });
    return localObject;
  }
  
  public static Handler zH()
  {
    return bUa;
  }
  
  public static HandlerThread zI()
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        if (bTY == null)
        {
          localObject1 = new HandlerThread("default_matrix_thread");
          bTY = (HandlerThread)localObject1;
          ((HandlerThread)localObject1).start();
          bTZ = new Handler(bTY.getLooper());
          Looper localLooper = bTY.getLooper();
          if (isDebug)
          {
            localObject1 = new a();
            localLooper.setMessageLogging((Printer)localObject1);
            c.w("Matrix.HandlerThread", "create default handler thread, we should use these thread normal, isDebug:%s", new Object[] { Boolean.valueOf(isDebug) });
          }
        }
        else
        {
          localObject1 = bTY;
          return localObject1;
        }
      }
      finally {}
      Object localObject3 = null;
    }
  }
  
  public static Handler zJ()
  {
    return bTZ;
  }
  
  static final class a
    implements Printer, com.tencent.matrix.b.a
  {
    private boolean bSe;
    private ConcurrentHashMap<String, a> bUc = new ConcurrentHashMap();
    
    a()
    {
      com.tencent.matrix.a.bLP.a(this);
      this.bSe = com.tencent.matrix.a.bLP.bLR;
    }
    
    public final void onForeground(boolean paramBoolean)
    {
      this.bSe = paramBoolean;
      c.d("Matrix.HandlerThread", "onForeground:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      if (paramBoolean)
      {
        long l = System.currentTimeMillis();
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = this.bUc.values().iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (locala.count > 1) {
            localLinkedList.add(locala);
          }
        }
        Collections.sort(localLinkedList, new Comparator() {});
        this.bUc.clear();
        if (!localLinkedList.isEmpty()) {
          c.i("Matrix.HandlerThread", "matrix default thread has exec in background! %s cost:%s", new Object[] { localLinkedList, Long.valueOf(System.currentTimeMillis() - l) });
        }
        return;
      }
      this.bUc.clear();
    }
    
    public final void println(String paramString)
    {
      if (this.bSe) {}
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
      a locala = (a)this.bUc.get(str);
      paramString = locala;
      if (locala == null)
      {
        paramString = new a();
        paramString.key = str;
        this.bUc.put(str, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.g.b
 * JD-Core Version:    0.7.0.1
 */