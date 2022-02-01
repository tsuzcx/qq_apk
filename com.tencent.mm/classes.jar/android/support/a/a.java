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
  public static final ThreadLocal<a> fw = new ThreadLocal();
  private c fA;
  long fB = 0L;
  boolean fC = false;
  final n<b, Long> fx = new n();
  final ArrayList<b> fy = new ArrayList();
  private final a fz = new a();
  
  public static a aD()
  {
    if (fw.get() == null) {
      fw.set(new a());
    }
    return (a)fw.get();
  }
  
  public final void a(b paramb)
  {
    this.fx.remove(paramb);
    int i = this.fy.indexOf(paramb);
    if (i >= 0)
    {
      this.fy.set(i, null);
      this.fC = true;
    }
  }
  
  final c aE()
  {
    if (this.fA == null) {
      if (Build.VERSION.SDK_INT < 16) {
        break label35;
      }
    }
    label35:
    for (this.fA = new e(this.fz);; this.fA = new d(this.fz)) {
      return this.fA;
    }
  }
  
  final class a
  {
    a() {}
    
    final void aF()
    {
      a.this.fB = SystemClock.uptimeMillis();
      a locala = a.this;
      long l1 = a.this.fB;
      long l2 = SystemClock.uptimeMillis();
      int j = 0;
      int i;
      if (j < locala.fy.size())
      {
        a.b localb = (a.b)locala.fy.get(j);
        Long localLong;
        if (localb != null)
        {
          localLong = (Long)locala.fx.get(localb);
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
            locala.fx.remove(localb);
            i = 1;
          }
          else
          {
            i = 0;
          }
        }
      }
      if (locala.fC)
      {
        i = locala.fy.size() - 1;
        while (i >= 0)
        {
          if (locala.fy.get(i) == null) {
            locala.fy.remove(i);
          }
          i -= 1;
        }
        locala.fC = false;
      }
      if (a.this.fy.size() > 0) {
        a.this.aE().aG();
      }
    }
  }
  
  static abstract interface b
  {
    public abstract boolean d(long paramLong);
  }
  
  static abstract class c
  {
    final a.a fE;
    
    c(a.a parama)
    {
      this.fE = parama;
    }
    
    abstract void aG();
  }
  
  static final class d
    extends a.c
  {
    long fF = -1L;
    private final Handler mHandler = new Handler(Looper.myLooper());
    private final Runnable mRunnable = new Runnable()
    {
      public final void run()
      {
        a.d.this.fF = SystemClock.uptimeMillis();
        a.d.this.fE.aF();
      }
    };
    
    d(a.a parama)
    {
      super();
    }
    
    final void aG()
    {
      long l = Math.max(10L - (SystemClock.uptimeMillis() - this.fF), 0L);
      this.mHandler.postDelayed(this.mRunnable, l);
    }
  }
  
  static final class e
    extends a.c
  {
    private final Choreographer fH = Choreographer.getInstance();
    private final Choreographer.FrameCallback fI = new Choreographer.FrameCallback()
    {
      public final void doFrame(long paramAnonymousLong)
      {
        a.e.this.fE.aF();
      }
    };
    
    e(a.a parama)
    {
      super();
    }
    
    final void aG()
    {
      this.fH.postFrameCallback(this.fI);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.a.a
 * JD-Core Version:    0.7.0.1
 */