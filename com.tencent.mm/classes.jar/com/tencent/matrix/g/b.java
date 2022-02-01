package com.tencent.matrix.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Printer;
import com.tencent.matrix.a;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
  private static volatile HandlerThread cCN;
  private static volatile Handler cCO;
  private static volatile Handler cCP = new Handler(Looper.getMainLooper());
  private static HashSet<HandlerThread> cCQ = new HashSet();
  public static boolean cuo = false;
  
  public static Handler HX()
  {
    return cCP;
  }
  
  public static HandlerThread HY()
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        if (cCN == null)
        {
          localObject1 = new HandlerThread("default_matrix_thread");
          cCN = (HandlerThread)localObject1;
          ((HandlerThread)localObject1).start();
          cCO = new Handler(cCN.getLooper());
          Looper localLooper = cCN.getLooper();
          if (cuo)
          {
            localObject1 = new a();
            localLooper.setMessageLogging((Printer)localObject1);
            c.w("Matrix.HandlerThread", "create default handler thread, we should use these thread normal, isDebug:%s", new Object[] { Boolean.valueOf(cuo) });
          }
        }
        else
        {
          localObject1 = cCN;
          return localObject1;
        }
      }
      finally {}
      Object localObject3 = null;
    }
  }
  
  public static Handler HZ()
  {
    if (cCO == null) {
      HY();
    }
    return cCO;
  }
  
  public static HandlerThread df(String paramString)
  {
    Object localObject = cCQ.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!((HandlerThread)((Iterator)localObject).next()).isAlive())
      {
        ((Iterator)localObject).remove();
        c.w("Matrix.HandlerThread", "warning: remove dead handler thread with name %s", new Object[] { paramString });
      }
    }
    localObject = new HandlerThread(paramString);
    ((HandlerThread)localObject).setPriority(3);
    ((HandlerThread)localObject).start();
    cCQ.add(localObject);
    c.w("Matrix.HandlerThread", "warning: create new handler thread with name %s, alive thread size:%d", new Object[] { paramString, Integer.valueOf(cCQ.size()) });
    return localObject;
  }
  
  static final class a
    implements Printer, com.tencent.matrix.b.b
  {
    private ConcurrentHashMap<String, a> cCR = new ConcurrentHashMap();
    private boolean cqM;
    
    a()
    {
      a.cqa.a(this);
      this.cqM = a.cqa.cqc;
    }
    
    public final void onForeground(boolean paramBoolean)
    {
      this.cqM = paramBoolean;
      if (paramBoolean)
      {
        long l = System.currentTimeMillis();
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = this.cCR.values().iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (locala.count > 1) {
            localLinkedList.add(locala);
          }
        }
        Collections.sort(localLinkedList, new Comparator() {});
        this.cCR.clear();
        if (!localLinkedList.isEmpty()) {
          c.i("Matrix.HandlerThread", "matrix default thread has exec in background! %s cost:%s", new Object[] { localLinkedList, Long.valueOf(System.currentTimeMillis() - l) });
        }
        return;
      }
      this.cCR.clear();
    }
    
    public final void println(String paramString)
    {
      if (this.cqM) {}
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
      a locala = (a)this.cCR.get(str);
      paramString = locala;
      if (locala == null)
      {
        paramString = new a();
        paramString.key = str;
        this.cCR.put(str, paramString);
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