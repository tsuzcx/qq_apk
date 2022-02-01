package com.tencent.matrix.a.a.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.a.a.d;
import com.tencent.matrix.trace.core.a;
import com.tencent.matrix.trace.core.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class i
  extends b
{
  final List<String> cWe = new ArrayList();
  final Map<Looper, a> cWf = new HashMap();
  a.a cWg;
  Runnable cWh;
  
  static Collection<Thread> Wt()
  {
    Map localMap = Thread.getAllStackTraces();
    if (localMap == null) {
      return Collections.emptyList();
    }
    return localMap.keySet();
  }
  
  protected final void G(List<j.a.a<b.a>> paramList) {}
  
  protected final void H(String paramString, int paramInt)
  {
    b.a locala = J(paramString, Process.myTid());
    if (locala != null)
    {
      this.cUs.put(Integer.valueOf(paramInt), locala);
      b(Process.myTid(), paramString, ((Long)locala.cUC.cWu).longValue());
    }
  }
  
  protected final void I(String paramString, int paramInt)
  {
    b.a locala = (b.a)this.cUs.remove(Integer.valueOf(paramInt));
    if (locala != null)
    {
      paramString = J(paramString, Process.myTid());
      if (paramString != null)
      {
        paramString.isFinished = true;
        a(locala, paramString);
      }
      paramInt = Process.myTid();
      if (paramString != null) {
        break label76;
      }
    }
    label76:
    for (paramString = (Long)locala.cUC.cWu;; paramString = (Long)paramString.cUC.cWu)
    {
      b(paramInt, "thread_pool@idle", paramString.longValue());
      return;
    }
  }
  
  public final void VZ()
  {
    super.VZ();
    this.cWg = new a.a()
    {
      private static String eX(String paramAnonymousString)
      {
        if (TextUtils.isEmpty(paramAnonymousString)) {}
        int i;
        int j;
        do
        {
          return null;
          i = paramAnonymousString.indexOf("} ");
          j = paramAnonymousString.lastIndexOf("@");
        } while (i >= j - 1);
        return paramAnonymousString.substring("} ".length() + i, j);
      }
      
      private static int eY(String paramAnonymousString)
      {
        if (TextUtils.isEmpty(paramAnonymousString)) {
          return -1;
        }
        int j = paramAnonymousString.indexOf("@");
        if (paramAnonymousString.contains(": ")) {}
        for (int i = paramAnonymousString.lastIndexOf(": "); j >= i - 1; i = 2147483647) {
          return -1;
        }
        if (i == 2147483647) {}
        for (paramAnonymousString = paramAnonymousString.substring("@".length() + j);; paramAnonymousString = paramAnonymousString.substring("@".length() + j, i)) {
          try
          {
            i = Integer.parseInt(paramAnonymousString, 16);
            return i;
          }
          catch (NumberFormatException paramAnonymousString) {}
        }
        return -1;
      }
      
      public final void eV(String paramAnonymousString)
      {
        super.eV(paramAnonymousString);
        if (i.this.cSI.cUb.cTS) {
          com.tencent.matrix.e.c.i("Matrix.battery.LooperTaskMonitorFeature", "[" + Thread.currentThread().getName() + "]" + paramAnonymousString, new Object[0]);
        }
        String str = eX(paramAnonymousString);
        if (!TextUtils.isEmpty(str))
        {
          int i = eY(paramAnonymousString);
          if (i > 0) {
            i.this.H(str, i);
          }
        }
      }
      
      public final void eW(String paramAnonymousString)
      {
        super.eW(paramAnonymousString);
        if (i.this.cSI.cUb.cTS) {
          com.tencent.matrix.e.c.i("Matrix.battery.LooperTaskMonitorFeature", "[" + Thread.currentThread().getName() + "]" + paramAnonymousString, new Object[0]);
        }
        String str = eX(paramAnonymousString);
        if (!TextUtils.isEmpty(str))
        {
          int i = eY(paramAnonymousString);
          if (i > 0) {
            i.this.I(str, i);
          }
        }
      }
      
      public final boolean isValid()
      {
        return i.this.cSI.VY();
      }
    };
  }
  
  public final void Wa()
  {
    super.Wa();
    synchronized (this.cWe)
    {
      this.cWg = null;
      Iterator localIterator = this.cWf.values().iterator();
      if (localIterator.hasNext()) {
        ((a)localIterator.next()).onRelease();
      }
    }
    this.cWf.clear();
    this.cWe.clear();
  }
  
  public final int Wh()
  {
    return 0;
  }
  
  final void a(String paramString, Looper paramLooper)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLooper == null)) {
      return;
    }
    synchronized (this.cWe)
    {
      if (this.cWg != null)
      {
        this.cWe.remove(paramString);
        a locala = (a)this.cWf.remove(paramLooper);
        if (locala != null) {
          locala.onRelease();
        }
        locala = a.b(paramLooper);
        locala.c(this.cWg);
        this.cWe.add(paramString);
        this.cWf.put(paramLooper, locala);
      }
      return;
    }
  }
  
  protected final String getTag()
  {
    return "Matrix.battery.LooperTaskMonitorFeature";
  }
  
  public final void onForeground(boolean paramBoolean)
  {
    super.onForeground(paramBoolean);
    if (paramBoolean)
    {
      if (this.cWh != null) {
        this.cSI.mHandler.removeCallbacks(this.cWh);
      }
      return;
    }
    this.cWh = new Runnable()
    {
      public final void run()
      {
        i locali = i.this;
        Object localObject4;
        for (;;)
        {
          synchronized (locali.cWe)
          {
            if (locali.cWg == null) {
              return;
            }
            com.tencent.matrix.e.c.i("Matrix.battery.LooperTaskMonitorFeature", "#startWatching", new Object[0]);
            if (!locali.cSI.cUb.cTW.contains("all")) {
              break;
            }
            Iterator localIterator1 = i.Wt().iterator();
            if (!localIterator1.hasNext()) {
              break label418;
            }
            localObject3 = (Thread)localIterator1.next();
            if ((localObject3 instanceof HandlerThread))
            {
              localObject4 = ((HandlerThread)localObject3).getLooper();
              if ((localObject4 == null) || (locali.cWf.containsKey(localObject4))) {
                continue;
              }
              localObject3 = (HandlerThread)localObject3;
              localObject4 = ((HandlerThread)localObject3).getLooper();
              if (localObject4 == null) {
                continue;
              }
              locali.a(((HandlerThread)localObject3).getName(), (Looper)localObject4);
            }
          }
          if ((Looper.getMainLooper().getThread() == localObject3) && (!locali.cWf.containsKey(Looper.getMainLooper()))) {
            locali.a("main", Looper.getMainLooper());
          }
        }
        Object localObject2 = Collections.emptyList();
        Object localObject3 = locali.cSI.cUb.cTW.iterator();
        label418:
        label421:
        label427:
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (String)((Iterator)localObject3).next();
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              continue;
            }
            if ("main".equalsIgnoreCase((String)localObject4))
            {
              localObject4 = Looper.getMainLooper();
              if (locali.cWf.containsKey(localObject4)) {
                continue;
              }
              locali.a("main", (Looper)localObject4);
              continue;
            }
            if (locali.cWe.contains(localObject4)) {
              break label427;
            }
            if (!((Collection)localObject2).isEmpty()) {
              break label421;
            }
            localObject2 = i.Wt();
          }
          for (;;)
          {
            Iterator localIterator2 = ((Collection)localObject2).iterator();
            while (localIterator2.hasNext())
            {
              Thread localThread = (Thread)localIterator2.next();
              if ((Looper.getMainLooper().getThread() != localThread) && (localThread.getName().contains((CharSequence)localObject4)) && ((localThread instanceof HandlerThread)))
              {
                Looper localLooper = ((HandlerThread)localThread).getLooper();
                if ((localLooper != null) && (!locali.cWf.containsKey(localLooper))) {
                  locali.a(localThread.getName(), localLooper);
                }
              }
            }
            return;
          }
        }
      }
    };
    this.cSI.mHandler.postDelayed(this.cWh, this.cSI.cUb.cTD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.i
 * JD-Core Version:    0.7.0.1
 */