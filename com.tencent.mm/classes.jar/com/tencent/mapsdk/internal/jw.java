package com.tencent.mapsdk.internal;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.Util;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class jw
{
  private static final Handler a;
  private static c b;
  
  static
  {
    AppMethodBeat.i(223961);
    kl.g("DU");
    a = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(223961);
  }
  
  public static Looper a(String paramString)
  {
    AppMethodBeat.i(223897);
    if (b == null)
    {
      AppMethodBeat.o(223897);
      return null;
    }
    c localc = b;
    String str = "tms-".concat(String.valueOf(paramString));
    HandlerThread localHandlerThread = (HandlerThread)localc.a.get(str);
    if (localHandlerThread != null)
    {
      paramString = localHandlerThread;
      if (localHandlerThread.getThreadId() != -1) {}
    }
    else
    {
      paramString = new HandlerThread(str);
      paramString.start();
      localc.a(str, paramString);
    }
    paramString = paramString.getLooper();
    AppMethodBeat.o(223897);
    return paramString;
  }
  
  public static <T> jw.b.a<T> a(g<T> paramg)
  {
    AppMethodBeat.i(223943);
    kl.f("DU").a(new Object[] { paramg });
    paramg = b.b.a(paramg);
    AppMethodBeat.o(223943);
    return paramg;
  }
  
  public static c a()
  {
    AppMethodBeat.i(223923);
    c localc = new c();
    AppMethodBeat.o(223923);
    return localc;
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(223933);
    if (paramc == null)
    {
      AppMethodBeat.o(223933);
      return;
    }
    b = paramc;
    paramc.a("tms-dsp", paramc.b);
    paramc = b.b.getLooper();
    if (paramc != null) {
      paramc.setMessageLogging(new Printer()
      {
        public final void println(String paramAnonymousString)
        {
          AppMethodBeat.i(225069);
          kh.c("DU", paramAnonymousString);
          AppMethodBeat.o(225069);
        }
      });
    }
    AppMethodBeat.o(223933);
  }
  
  public static void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(223874);
    if (Looper.getMainLooper().getThread() != Thread.currentThread())
    {
      a.post(paramRunnable);
      AppMethodBeat.o(223874);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(223874);
  }
  
  public static void a(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(223882);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(223882);
      return;
    }
    a.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(223882);
  }
  
  private static Looper b()
  {
    AppMethodBeat.i(223906);
    if (b == null)
    {
      AppMethodBeat.o(223906);
      return null;
    }
    Looper localLooper = b.b.getLooper();
    AppMethodBeat.o(223906);
    return localLooper;
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(223953);
    if ((paramc != null) && (!paramc.a.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      Util.foreach(paramc.a.entrySet(), new jw.c.1(paramc, localArrayList));
      Util.foreach(localArrayList, new jw.c.2(paramc));
    }
    a.removeCallbacksAndMessages(null);
    AppMethodBeat.o(223953);
  }
  
  public static void b(Runnable paramRunnable)
  {
    AppMethodBeat.i(223915);
    a(new g()
    {
      private Void a()
      {
        AppMethodBeat.i(224962);
        this.a.run();
        AppMethodBeat.o(224962);
        return null;
      }
    }).a(new jw.e(null)).a();
    AppMethodBeat.o(223915);
  }
  
  public static abstract class a<T>
    implements Callback<T>, Runnable
  {
    public abstract void callback(T paramT);
    
    public void run() {}
  }
  
  public static final class b
    extends HandlerThread
  {
    public static final String a = "tms-dsp";
    private static final int h = 1;
    private static final int i = 300;
    private boolean b;
    private boolean c;
    private volatile boolean d;
    private Handler e;
    private final ConcurrentLinkedQueue<a> f;
    private final List<a> g;
    
    public b()
    {
      super();
      AppMethodBeat.i(223358);
      this.f = new ConcurrentLinkedQueue();
      this.g = new LinkedList();
      AppMethodBeat.o(223358);
    }
    
    private void a(jw.c paramc)
    {
      AppMethodBeat.i(223363);
      paramc.a("tms-dsp", this);
      AppMethodBeat.o(223363);
    }
    
    private boolean a()
    {
      AppMethodBeat.i(223381);
      if (!this.f.isEmpty())
      {
        localObject = (a)this.f.poll();
        if ((localObject != null) && (((a)localObject).m == 1))
        {
          kl.f("DU").a(new Object[0]);
          if ((((a)localObject).g != null) && (((a)localObject).h != null)) {
            ((a)localObject).j = ((a)localObject).g.a(((a)localObject).h);
          }
          kl.f("DU").a(new Object[0]);
          ((a)localObject).m = 2;
          this.g.add(localObject);
        }
      }
      Object localObject = this.g.iterator();
      for (;;)
      {
        a locala;
        if (((Iterator)localObject).hasNext())
        {
          locala = (a)((Iterator)localObject).next();
          if (locala != null) {
            switch (locala.m)
            {
            default: 
              break;
            }
          }
        }
        else
        {
          try
          {
            kl.f("DU").a(new Object[0]);
            if ((locala.j != null) && (!locala.f)) {
              if (locala.j.isDone())
              {
                locala.m = 3;
              }
              else if (locala.j.isCancelled())
              {
                locala.k = locala.j.get();
                locala.b();
              }
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            continue;
            kl.f("DU").a(new Object[] { "result:" + localInterruptedException.k, "userCallback:" + localInterruptedException.i });
            if (localInterruptedException.i != null) {
              localInterruptedException.i.callback(localInterruptedException.k);
            }
            ((Iterator)localObject).remove();
            continue;
            localInterruptedException.l += 1;
            kl.f("DU").a(new Object[] { "try time:" + localInterruptedException.l });
            if (localInterruptedException.l < 2)
            {
              localInterruptedException.f = false;
              localInterruptedException.a();
            }
            for (int j = 1;; j = 0)
            {
              if (j != 0) {
                this.f.offer(localInterruptedException);
              }
              ((Iterator)localObject).remove();
              break;
            }
            if (!this.g.isEmpty())
            {
              AppMethodBeat.o(223381);
              return true;
            }
            AppMethodBeat.o(223381);
            return false;
          }
          catch (ExecutionException localExecutionException) {}
        }
      }
    }
    
    private void b()
    {
      AppMethodBeat.i(223392);
      Iterator localIterator = this.f.iterator();
      a locala;
      while (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if (locala != null) {
          locala.b();
        }
      }
      localIterator = this.g.iterator();
      while (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if (locala != null) {
          locala.b();
        }
      }
      this.f.clear();
      this.g.clear();
      kl.f("DU").a(new Object[] { "cancelAll..." });
      if (this.e != null) {
        this.e.removeCallbacksAndMessages(null);
      }
      AppMethodBeat.o(223392);
    }
    
    final <T> a<T> a(jw.g<T> paramg)
    {
      try
      {
        AppMethodBeat.i(223467);
        kl.f("DU").a(new Object[] { "prepared:" + this.b });
        if ((!this.b) && (!this.c) && (!this.d))
        {
          start();
          this.c = true;
        }
        paramg = new a(paramg, (byte)0);
        AppMethodBeat.o(223467);
        return paramg;
      }
      finally {}
    }
    
    protected final void onLooperPrepared()
    {
      AppMethodBeat.i(223457);
      super.onLooperPrepared();
      this.b = true;
      this.e = new Handler(getLooper())
      {
        public final void dispatchMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(221452);
          super.dispatchMessage(paramAnonymousMessage);
          if (paramAnonymousMessage.what == 1) {
            try
            {
              boolean bool = jw.b.a(jw.b.this);
              if (bool)
              {
                jw.b.b(jw.b.this).sendEmptyMessageDelayed(1, 300L);
                AppMethodBeat.o(221452);
                return;
              }
            }
            finally
            {
              try
              {
                kh.a("MSG_SYNC_CHECK ERR:", paramAnonymousMessage);
                return;
              }
              finally
              {
                AppMethodBeat.o(221452);
              }
            }
          }
          AppMethodBeat.o(221452);
        }
      };
      kl.f("DU").a(new Object[] { "looper is prepared..." });
      this.e.sendEmptyMessage(1);
      AppMethodBeat.o(223457);
    }
    
    public final boolean quit()
    {
      AppMethodBeat.i(223475);
      boolean bool = super.quit();
      if (bool)
      {
        b();
        this.d = true;
      }
      AppMethodBeat.o(223475);
      return bool;
    }
    
    public final boolean quitSafely()
    {
      AppMethodBeat.i(223481);
      boolean bool = super.quitSafely();
      if (bool)
      {
        b();
        this.d = true;
      }
      AppMethodBeat.o(223481);
      return bool;
    }
    
    public final class a<T>
    {
      static final int a = 0;
      static final int b = 1;
      static final int c = 2;
      static final int d = 3;
      static final int e = 4;
      boolean f;
      jw.d<T> g;
      final jw.g<T> h;
      jw.a<T> i;
      Future<T> j;
      T k;
      int l;
      int m;
      
      private a()
      {
        AppMethodBeat.i(225635);
        this.m = 0;
        Object localObject;
        this.h = localObject;
        if ((localObject == null) || (jw.b.c(jw.b.this))) {
          this.f = true;
        }
        AppMethodBeat.o(225635);
      }
      
      private void b(jw.d<T> paramd)
      {
        AppMethodBeat.i(225652);
        this.g = paramd;
        if (this.h != null) {
          jw.g.a(this.h, new jw.a()
          {
            public final void callback(T paramAnonymousT)
            {
              jw.b.a.this.k = paramAnonymousT;
            }
          });
        }
        AppMethodBeat.o(225652);
      }
      
      private void c()
      {
        AppMethodBeat.i(225644);
        a(new jw.e(null)).a();
        AppMethodBeat.o(225644);
      }
      
      private boolean d()
      {
        AppMethodBeat.i(225664);
        this.l += 1;
        kl.f("DU").a(new Object[] { "try time:" + this.l });
        if (this.l < 2)
        {
          this.f = false;
          a();
          AppMethodBeat.o(225664);
          return true;
        }
        AppMethodBeat.o(225664);
        return false;
      }
      
      private void e()
      {
        AppMethodBeat.i(225670);
        kl.f("DU").a(new Object[0]);
        if ((this.g != null) && (this.h != null)) {
          this.j = this.g.a(this.h);
        }
        kl.f("DU").a(new Object[0]);
        this.m = 2;
        AppMethodBeat.o(225670);
      }
      
      private void f()
      {
        AppMethodBeat.i(225681);
        kl.f("DU").a(new Object[] { "result:" + this.k, "userCallback:" + this.i });
        if (this.i != null) {
          this.i.callback(this.k);
        }
        AppMethodBeat.o(225681);
      }
      
      private void g()
      {
        AppMethodBeat.i(225698);
        kl.f("DU").a(new Object[0]);
        if ((this.j != null) && (!this.f))
        {
          if (this.j.isDone())
          {
            this.m = 3;
            AppMethodBeat.o(225698);
            return;
          }
          if (this.j.isCancelled())
          {
            this.k = this.j.get();
            b();
          }
        }
        AppMethodBeat.o(225698);
      }
      
      public final a<T> a(jw.d<T> paramd)
      {
        AppMethodBeat.i(225725);
        jw.b.d(jw.b.this).add(this);
        kl.f("DU").a(new Object[] { "dispatchHandler:" + jw.b.b(jw.b.this) });
        b(paramd);
        AppMethodBeat.o(225725);
        return this;
      }
      
      public final void a()
      {
        AppMethodBeat.i(225766);
        kl.f("DU").a(new Object[0]);
        if ((this.f) || (jw.b.c(jw.b.this)))
        {
          kl.f("DU").a(new Object[] { "cancelled..." });
          AppMethodBeat.o(225766);
          return;
        }
        this.m = 1;
        if (jw.b.b(jw.b.this) != null) {
          jw.b.b(jw.b.this).sendEmptyMessage(1);
        }
        AppMethodBeat.o(225766);
      }
      
      public final void a(jw.a<T> parama)
      {
        AppMethodBeat.i(225737);
        if (jw.b.c(jw.b.this))
        {
          AppMethodBeat.o(225737);
          return;
        }
        a(new jw.f(null)).b(parama);
        AppMethodBeat.o(225737);
      }
      
      public final void a(T paramT)
      {
        AppMethodBeat.i(225732);
        if (jw.b.c(jw.b.this))
        {
          AppMethodBeat.o(225732);
          return;
        }
        a(new jw.f(paramT)).a();
        AppMethodBeat.o(225732);
      }
      
      public final void a(T paramT, jw.a<T> parama)
      {
        AppMethodBeat.i(225747);
        a(new jw.e(paramT)).b(parama);
        AppMethodBeat.o(225747);
      }
      
      final void b()
      {
        AppMethodBeat.i(225774);
        kl.f("DU").a(new Object[0]);
        this.f = true;
        if (this.j != null) {
          this.j.cancel(false);
        }
        this.m = 4;
        AppMethodBeat.o(225774);
      }
      
      public final void b(jw.a<T> parama)
      {
        AppMethodBeat.i(225757);
        this.i = parama;
        a();
        AppMethodBeat.o(225757);
      }
    }
  }
  
  public static final class c
  {
    final Map<String, HandlerThread> a;
    final jw.b b;
    
    public c()
    {
      AppMethodBeat.i(223371);
      this.a = new HashMap();
      this.b = new jw.b();
      AppMethodBeat.o(223371);
    }
    
    private Looper a(String paramString)
    {
      AppMethodBeat.i(223394);
      String str = "tms-".concat(String.valueOf(paramString));
      HandlerThread localHandlerThread = (HandlerThread)this.a.get(str);
      if (localHandlerThread != null)
      {
        paramString = localHandlerThread;
        if (localHandlerThread.getThreadId() != -1) {}
      }
      else
      {
        paramString = new HandlerThread(str);
        paramString.start();
        a(str, paramString);
      }
      paramString = paramString.getLooper();
      AppMethodBeat.o(223394);
      return paramString;
    }
    
    private void a()
    {
      AppMethodBeat.i(223382);
      a("tms-dsp", this.b);
      AppMethodBeat.o(223382);
    }
    
    private jw.b b()
    {
      return this.b;
    }
    
    private void c()
    {
      AppMethodBeat.i(223416);
      if (!this.a.isEmpty())
      {
        final ArrayList localArrayList = new ArrayList();
        Util.foreach(this.a.entrySet(), new jw.a()
        {
          private void a(Map.Entry<String, HandlerThread> paramAnonymousEntry)
          {
            AppMethodBeat.i(223340);
            HandlerThread localHandlerThread;
            if (paramAnonymousEntry != null)
            {
              localHandlerThread = (HandlerThread)paramAnonymousEntry.getValue();
              if (localHandlerThread != null)
              {
                if (Build.VERSION.SDK_INT < 18) {
                  break label58;
                }
                localHandlerThread.quitSafely();
              }
            }
            for (;;)
            {
              localArrayList.add(paramAnonymousEntry.getKey());
              AppMethodBeat.o(223340);
              return;
              label58:
              localHandlerThread.quit();
            }
          }
        });
        Util.foreach(localArrayList, new jw.a()
        {
          private void a(String paramAnonymousString)
          {
            AppMethodBeat.i(223303);
            if (paramAnonymousString != null) {
              jw.c.this.a.remove(paramAnonymousString);
            }
            AppMethodBeat.o(223303);
          }
        });
      }
      AppMethodBeat.o(223416);
    }
    
    public final void a(String paramString, HandlerThread paramHandlerThread)
    {
      AppMethodBeat.i(223435);
      if ((paramString == null) || (paramString.isEmpty()))
      {
        AppMethodBeat.o(223435);
        return;
      }
      this.a.put(paramString, paramHandlerThread);
      AppMethodBeat.o(223435);
    }
  }
  
  public static abstract interface d<T>
  {
    public abstract Future<T> a(jw.g<T> paramg);
  }
  
  public static abstract class g<T>
    implements Runnable, Callable<T>
  {
    private jw.a<T> a;
    
    public final void run()
    {
      try
      {
        Object localObject = call();
        if (this.a != null) {
          this.a.callback(localObject);
        }
        return;
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.jw
 * JD-Core Version:    0.7.0.1
 */