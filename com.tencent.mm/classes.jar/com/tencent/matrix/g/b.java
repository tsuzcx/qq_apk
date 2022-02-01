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
  public static boolean cFj = false;
  private static volatile HandlerThread cNL;
  private static volatile Handler cNM;
  private static volatile Handler cNN = new Handler(Looper.getMainLooper());
  private static HashSet<HandlerThread> cNO = new HashSet();
  
  public static Handler Js()
  {
    return cNN;
  }
  
  public static HandlerThread Jt()
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        if (cNL == null)
        {
          localObject1 = new HandlerThread("default_matrix_thread");
          cNL = (HandlerThread)localObject1;
          ((HandlerThread)localObject1).start();
          cNM = new Handler(cNL.getLooper());
          Looper localLooper = cNL.getLooper();
          if (cFj)
          {
            localObject1 = new a();
            localLooper.setMessageLogging((Printer)localObject1);
            c.w("Matrix.HandlerThread", "create default handler thread, we should use these thread normal, isDebug:%s", new Object[] { Boolean.valueOf(cFj) });
          }
        }
        else
        {
          localObject1 = cNL;
          return localObject1;
        }
      }
      finally {}
      Object localObject3 = null;
    }
  }
  
  public static Handler Ju()
  {
    if (cNM == null) {
      Jt();
    }
    return cNM;
  }
  
  public static HandlerThread ed(String paramString)
  {
    Object localObject = cNO.iterator();
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
    cNO.add(localObject);
    c.w("Matrix.HandlerThread", "warning: create new handler thread with name %s, alive thread size:%d", new Object[] { paramString, Integer.valueOf(cNO.size()) });
    return localObject;
  }
  
  static final class a
    implements Printer, com.tencent.matrix.b.b
  {
    private boolean cBJ;
    private ConcurrentHashMap<String, a> cNP = new ConcurrentHashMap();
    
    a()
    {
      a.cAS.a(this);
      this.cBJ = a.cAS.cAU;
    }
    
    public final void onForeground(boolean paramBoolean)
    {
      this.cBJ = paramBoolean;
      if (paramBoolean)
      {
        long l = System.currentTimeMillis();
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = this.cNP.values().iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (locala.count > 1) {
            localLinkedList.add(locala);
          }
        }
        Collections.sort(localLinkedList, new Comparator() {});
        this.cNP.clear();
        if (!localLinkedList.isEmpty()) {
          c.i("Matrix.HandlerThread", "matrix default thread has exec in background! %s cost:%s", new Object[] { localLinkedList, Long.valueOf(System.currentTimeMillis() - l) });
        }
        return;
      }
      this.cNP.clear();
    }
    
    public final void println(String paramString)
    {
      if (this.cBJ) {}
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
      a locala = (a)this.cNP.get(str);
      paramString = locala;
      if (locala == null)
      {
        paramString = new a();
        paramString.key = str;
        this.cNP.put(str, paramString);
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