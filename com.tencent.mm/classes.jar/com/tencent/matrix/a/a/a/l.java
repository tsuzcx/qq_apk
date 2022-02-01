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

public final class l
  extends b
{
  final List<String> eRY = new ArrayList();
  final Map<Looper, a> eRZ = new HashMap();
  a.a eSa;
  Runnable eSb;
  
  static Collection<Thread> axj()
  {
    Map localMap = Thread.getAllStackTraces();
    if (localMap == null) {
      return Collections.emptyList();
    }
    return localMap.keySet();
  }
  
  protected final void P(String paramString, int paramInt)
  {
    b.a locala = R(paramString, Process.myTid());
    if (locala != null)
    {
      this.ePS.put(Integer.valueOf(paramInt), locala);
      a(Process.myTid(), paramString, ((Long)locala.eQc.eSn).longValue());
    }
  }
  
  protected final void Q(String paramString, int paramInt)
  {
    b.a locala = (b.a)this.ePS.remove(Integer.valueOf(paramInt));
    if (locala != null)
    {
      paramString = R(paramString, Process.myTid());
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
    for (paramString = (Long)locala.eQc.eSn;; paramString = (Long)paramString.eQc.eSn)
    {
      a(paramInt, "thread_pool@idle", paramString.longValue());
      return;
    }
  }
  
  final void a(String paramString, Looper paramLooper)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLooper == null)) {
      return;
    }
    synchronized (this.eRY)
    {
      if (this.eSa != null)
      {
        this.eRY.remove(paramString);
        a locala = (a)this.eRZ.remove(paramLooper);
        if (locala != null) {
          locala.onRelease();
        }
        locala = a.c(paramLooper);
        locala.c(this.eSa);
        this.eRY.add(paramString);
        this.eRZ.put(paramLooper, locala);
      }
      return;
    }
  }
  
  public final void awI()
  {
    super.awI();
    this.eSa = new a.a()
    {
      private static String gv(String paramAnonymousString)
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
      
      private static int gw(String paramAnonymousString)
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
      
      public final void gt(String paramAnonymousString)
      {
        super.gt(paramAnonymousString);
        if (l.this.eNY.ePD.ePu) {
          com.tencent.matrix.e.c.i("Matrix.battery.LooperTaskMonitorFeature", "[" + Thread.currentThread().getName() + "]" + paramAnonymousString, new Object[0]);
        }
        String str = gv(paramAnonymousString);
        if (!TextUtils.isEmpty(str))
        {
          int i = gw(paramAnonymousString);
          if (i > 0) {
            l.this.P(str, i);
          }
        }
      }
      
      public final void gu(String paramAnonymousString)
      {
        super.gu(paramAnonymousString);
        if (l.this.eNY.ePD.ePu) {
          com.tencent.matrix.e.c.i("Matrix.battery.LooperTaskMonitorFeature", "[" + Thread.currentThread().getName() + "]" + paramAnonymousString, new Object[0]);
        }
        String str = gv(paramAnonymousString);
        if (!TextUtils.isEmpty(str))
        {
          int i = gw(paramAnonymousString);
          if (i > 0) {
            l.this.Q(str, i);
          }
        }
      }
      
      public final boolean isValid()
      {
        return l.this.eNY.awH();
      }
    };
  }
  
  public final void awJ()
  {
    super.awJ();
    synchronized (this.eRY)
    {
      this.eSa = null;
      Iterator localIterator = this.eRZ.values().iterator();
      if (localIterator.hasNext()) {
        ((a)localIterator.next()).onRelease();
      }
    }
    this.eRZ.clear();
    this.eRY.clear();
  }
  
  public final int awQ()
  {
    return 0;
  }
  
  protected final void be(List<m.a.a<b.a>> paramList) {}
  
  protected final String getTag()
  {
    return "Matrix.battery.LooperTaskMonitorFeature";
  }
  
  public final void onForeground(boolean paramBoolean)
  {
    super.onForeground(paramBoolean);
    if (paramBoolean)
    {
      if (this.eSb != null) {
        this.eNY.mHandler.removeCallbacks(this.eSb);
      }
      return;
    }
    this.eSb = new Runnable()
    {
      public final void run()
      {
        l locall = l.this;
        Object localObject4;
        for (;;)
        {
          synchronized (locall.eRY)
          {
            if (locall.eSa == null) {
              return;
            }
            com.tencent.matrix.e.c.i("Matrix.battery.LooperTaskMonitorFeature", "#startWatching", new Object[0]);
            if (!locall.eNY.ePD.ePy.contains("all")) {
              break;
            }
            Iterator localIterator1 = l.axj().iterator();
            if (!localIterator1.hasNext()) {
              break label418;
            }
            localObject3 = (Thread)localIterator1.next();
            if ((localObject3 instanceof HandlerThread))
            {
              localObject4 = ((HandlerThread)localObject3).getLooper();
              if ((localObject4 == null) || (locall.eRZ.containsKey(localObject4))) {
                continue;
              }
              localObject3 = (HandlerThread)localObject3;
              localObject4 = ((HandlerThread)localObject3).getLooper();
              if (localObject4 == null) {
                continue;
              }
              locall.a(((HandlerThread)localObject3).getName(), (Looper)localObject4);
            }
          }
          if ((Looper.getMainLooper().getThread() == localObject3) && (!locall.eRZ.containsKey(Looper.getMainLooper()))) {
            locall.a("main", Looper.getMainLooper());
          }
        }
        Object localObject2 = Collections.emptyList();
        Object localObject3 = locall.eNY.ePD.ePy.iterator();
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
              if (locall.eRZ.containsKey(localObject4)) {
                continue;
              }
              locall.a("main", (Looper)localObject4);
              continue;
            }
            if (locall.eRY.contains(localObject4)) {
              break label427;
            }
            if (!((Collection)localObject2).isEmpty()) {
              break label421;
            }
            localObject2 = l.axj();
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
                if ((localLooper != null) && (!locall.eRZ.containsKey(localLooper))) {
                  locall.a(localThread.getName(), localLooper);
                }
              }
            }
            return;
          }
        }
      }
    };
    this.eNY.mHandler.postDelayed(this.eSb, this.eNY.ePD.ePf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.l
 * JD-Core Version:    0.7.0.1
 */