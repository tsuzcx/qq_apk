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
  public static final ThreadLocal<a> dA = new ThreadLocal();
  final n<b, Long> dB = new n();
  final ArrayList<b> dC = new ArrayList();
  private final a dD = new a();
  private c dE;
  long dF = 0L;
  boolean dG = false;
  
  public static a af()
  {
    if (dA.get() == null) {
      dA.set(new a());
    }
    return (a)dA.get();
  }
  
  public final void a(b paramb)
  {
    this.dB.remove(paramb);
    int i = this.dC.indexOf(paramb);
    if (i >= 0)
    {
      this.dC.set(i, null);
      this.dG = true;
    }
  }
  
  final c am()
  {
    if (this.dE == null) {
      if (Build.VERSION.SDK_INT < 16) {
        break label35;
      }
    }
    label35:
    for (this.dE = new e(this.dD);; this.dE = new d(this.dD)) {
      return this.dE;
    }
  }
  
  final class a
  {
    a() {}
    
    final void an()
    {
      a.this.dF = SystemClock.uptimeMillis();
      a locala = a.this;
      long l1 = a.this.dF;
      long l2 = SystemClock.uptimeMillis();
      int j = 0;
      int i;
      if (j < locala.dC.size())
      {
        a.b localb = (a.b)locala.dC.get(j);
        Long localLong;
        if (localb != null)
        {
          localLong = (Long)locala.dB.get(localb);
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
            locala.dB.remove(localb);
            i = 1;
          }
          else
          {
            i = 0;
          }
        }
      }
      if (locala.dG)
      {
        i = locala.dC.size() - 1;
        while (i >= 0)
        {
          if (locala.dC.get(i) == null) {
            locala.dC.remove(i);
          }
          i -= 1;
        }
        locala.dG = false;
      }
      if (a.this.dC.size() > 0) {
        a.this.am().ao();
      }
    }
  }
  
  static abstract interface b
  {
    public abstract boolean d(long paramLong);
  }
  
  static abstract class c
  {
    final a.a dI;
    
    c(a.a parama)
    {
      this.dI = parama;
    }
    
    abstract void ao();
  }
  
  static final class d
    extends a.c
  {
    long dJ = -1L;
    private final Handler mHandler = new Handler(Looper.myLooper());
    private final Runnable mRunnable = new Runnable()
    {
      public final void run()
      {
        a.d.this.dJ = SystemClock.uptimeMillis();
        a.d.this.dI.an();
      }
    };
    
    d(a.a parama)
    {
      super();
    }
    
    final void ao()
    {
      long l = Math.max(10L - (SystemClock.uptimeMillis() - this.dJ), 0L);
      this.mHandler.postDelayed(this.mRunnable, l);
    }
  }
  
  static final class e
    extends a.c
  {
    private final Choreographer dL = Choreographer.getInstance();
    private final Choreographer.FrameCallback dM = new Choreographer.FrameCallback()
    {
      public final void doFrame(long paramAnonymousLong)
      {
        a.e.this.dI.an();
      }
    };
    
    e(a.a parama)
    {
      super();
    }
    
    final void ao()
    {
      this.dL.postFrameCallback(this.dM);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.a.a
 * JD-Core Version:    0.7.0.1
 */