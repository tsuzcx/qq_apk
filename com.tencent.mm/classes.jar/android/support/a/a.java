package android.support.a;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.e.n;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import java.util.ArrayList;

final class a
{
  public static final ThreadLocal<a> fu = new ThreadLocal();
  boolean fA = false;
  final n<b, Long> fv = new n();
  final ArrayList<b> fw = new ArrayList();
  private final a fx = new a();
  private c fy;
  long fz = 0L;
  
  public static a aB()
  {
    if (fu.get() == null) {
      fu.set(new a());
    }
    return (a)fu.get();
  }
  
  public final void a(b paramb)
  {
    this.fv.remove(paramb);
    int i = this.fw.indexOf(paramb);
    if (i >= 0)
    {
      this.fw.set(i, null);
      this.fA = true;
    }
  }
  
  final c aC()
  {
    if (this.fy == null) {
      if (Build.VERSION.SDK_INT < 16) {
        break label35;
      }
    }
    label35:
    for (this.fy = new e(this.fx);; this.fy = new d(this.fx)) {
      return this.fy;
    }
  }
  
  final class a
  {
    a() {}
    
    final void aD()
    {
      a.this.fz = SystemClock.uptimeMillis();
      a locala = a.this;
      long l1 = a.this.fz;
      long l2 = SystemClock.uptimeMillis();
      int j = 0;
      int i;
      if (j < locala.fw.size())
      {
        a.b localb = (a.b)locala.fw.get(j);
        Long localLong;
        if (localb != null)
        {
          localLong = (Long)locala.fv.get(localb);
          if (localLong != null) {
            break label104;
          }
          i = 1;
        }
        for (;;)
        {
          if (i != 0) {
            localb.d(l1);
          }
          j += 1;
          break;
          label104:
          if (localLong.longValue() < l2)
          {
            locala.fv.remove(localb);
            i = 1;
          }
          else
          {
            i = 0;
          }
        }
      }
      if (locala.fA)
      {
        i = locala.fw.size() - 1;
        while (i >= 0)
        {
          if (locala.fw.get(i) == null) {
            locala.fw.remove(i);
          }
          i -= 1;
        }
        locala.fA = false;
      }
      if (a.this.fw.size() > 0) {
        a.this.aC().aE();
      }
    }
  }
  
  static abstract interface b
  {
    public abstract boolean d(long paramLong);
  }
  
  static abstract class c
  {
    final a.a fC;
    
    c(a.a parama)
    {
      this.fC = parama;
    }
    
    abstract void aE();
  }
  
  static final class d
    extends a.c
  {
    long fD = -1L;
    private final Handler mHandler = new Handler(Looper.myLooper());
    private final Runnable mRunnable = new Runnable()
    {
      public final void run()
      {
        a.d.this.fD = SystemClock.uptimeMillis();
        a.d.this.fC.aD();
      }
    };
    
    d(a.a parama)
    {
      super();
    }
    
    final void aE()
    {
      long l = Math.max(10L - (SystemClock.uptimeMillis() - this.fD), 0L);
      this.mHandler.postDelayed(this.mRunnable, l);
    }
  }
  
  static final class e
    extends a.c
  {
    private final Choreographer fF = Choreographer.getInstance();
    private final Choreographer.FrameCallback fG = new Choreographer.FrameCallback()
    {
      public final void doFrame(long paramAnonymousLong)
      {
        a.e.this.fC.aD();
      }
    };
    
    e(a.a parama)
    {
      super();
    }
    
    final void aE()
    {
      this.fF.postFrameCallback(this.fG);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.a.a
 * JD-Core Version:    0.7.0.1
 */