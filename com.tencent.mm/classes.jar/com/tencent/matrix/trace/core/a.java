package com.tencent.matrix.trace.core;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.util.Printer;
import com.tencent.matrix.g.c;
import java.lang.reflect.Field;
import java.util.HashSet;

public final class a
  implements MessageQueue.IdleHandler
{
  private static Printer bRh;
  public static Printer bRi = null;
  private static final a bRj = new a();
  private static final HashSet<a> listeners = new HashSet();
  
  private a()
  {
    zs();
    if (Build.VERSION.SDK_INT >= 23)
    {
      Looper.getMainLooper().getQueue().addIdleHandler(this);
      return;
    }
    ((MessageQueue)e(Looper.getMainLooper(), "mQueue")).addIdleHandler(this);
  }
  
  public static void a(a parama)
  {
    synchronized (listeners)
    {
      listeners.add(parama);
      return;
    }
  }
  
  public static void b(a parama)
  {
    if (parama == null) {
      return;
    }
    synchronized (listeners)
    {
      listeners.remove(parama);
      return;
    }
  }
  
  private static <T> T e(Object paramObject, String paramString)
  {
    try
    {
      paramString = paramObject.getClass().getDeclaredField(paramString);
      paramString.setAccessible(true);
      paramObject = paramString.get(paramObject);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      c.e("Matrix.LooperMonitor", paramObject.toString(), new Object[0]);
    }
    return null;
  }
  
  private static void zs()
  {
    Object localObject = (Printer)e(Looper.getMainLooper(), "mLogging");
    if ((localObject == bRh) && (bRh != null)) {
      return;
    }
    if (bRh != null) {
      c.w("Matrix.LooperMonitor", "[resetPrinter] maybe looper printer was replace other!", new Object[0]);
    }
    Looper localLooper = Looper.getMainLooper();
    localObject = new Printer()
    {
      boolean bRg = false;
      boolean bRk = false;
      
      public final void println(String paramAnonymousString)
      {
        boolean bool2 = true;
        if (this.bRl != null) {
          this.bRl.println(paramAnonymousString);
        }
        if (!this.bRk)
        {
          if ((paramAnonymousString.charAt(0) != '>') && (paramAnonymousString.charAt(0) != '<')) {
            break label119;
          }
          bool1 = true;
          this.bRg = bool1;
          this.bRk = true;
          if (!this.bRg) {
            c.e("Matrix.LooperMonitor", "[println] Printer is inValid! x:%s", new Object[] { paramAnonymousString });
          }
        }
        if (this.bRg) {
          if (paramAnonymousString.charAt(0) != '>') {
            break label124;
          }
        }
        label119:
        label124:
        for (boolean bool1 = bool2;; bool1 = false)
        {
          a.bj(bool1);
          if (a.bRi != null) {
            a.bRi.println(paramAnonymousString);
          }
          return;
          bool1 = false;
          break;
        }
      }
    };
    bRh = (Printer)localObject;
    localLooper.setMessageLogging((Printer)localObject);
  }
  
  public final boolean queueIdle()
  {
    zs();
    return true;
  }
  
  public static abstract class a
  {
    boolean bRm = false;
    
    void dispatchEnd()
    {
      this.bRm = false;
    }
    
    void dispatchStart()
    {
      this.bRm = true;
    }
    
    boolean isValid()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.core.a
 * JD-Core Version:    0.7.0.1
 */