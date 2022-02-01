package android.support.design.widget;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

final class n
{
  private static n tI;
  private final Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback()
  {
    public final boolean handleMessage(Message arg1)
    {
      switch (???.what)
      {
      default: 
        return false;
      }
      n localn = n.this;
      n.b localb = (n.b)???.obj;
      synchronized (localn.lock)
      {
        if ((localn.tJ == localb) || (localn.tK == localb)) {
          localn.a(localb);
        }
        return true;
      }
    }
  });
  final Object lock = new Object();
  b tJ;
  b tK;
  
  private void b(b paramb)
  {
    if (paramb.duration == -2) {
      return;
    }
    int i = 2750;
    if (paramb.duration > 0) {
      i = paramb.duration;
    }
    for (;;)
    {
      this.handler.removeCallbacksAndMessages(paramb);
      this.handler.sendMessageDelayed(Message.obtain(this.handler, 0, paramb), i);
      return;
      if (paramb.duration == -1) {
        i = 1500;
      }
    }
  }
  
  static n cV()
  {
    if (tI == null) {
      tI = new n();
    }
    return tI;
  }
  
  public final void a(a parama)
  {
    synchronized (this.lock)
    {
      if (e(parama)) {
        b(this.tJ);
      }
      return;
    }
  }
  
  final boolean a(b paramb)
  {
    if ((a)paramb.tM.get() != null)
    {
      this.handler.removeCallbacksAndMessages(paramb);
      return true;
    }
    return false;
  }
  
  public final void b(a parama)
  {
    synchronized (this.lock)
    {
      if ((e(parama)) && (!this.tJ.tN))
      {
        this.tJ.tN = true;
        this.handler.removeCallbacksAndMessages(this.tJ);
      }
      return;
    }
  }
  
  public final void c(a parama)
  {
    synchronized (this.lock)
    {
      if ((e(parama)) && (this.tJ.tN))
      {
        this.tJ.tN = false;
        b(this.tJ);
      }
      return;
    }
  }
  
  public final boolean d(a parama)
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        if (!e(parama))
        {
          if (!f(parama)) {
            break label40;
          }
          break label35;
          return bool;
        }
      }
      label35:
      boolean bool = true;
      continue;
      label40:
      bool = false;
    }
  }
  
  final boolean e(a parama)
  {
    return (this.tJ != null) && (this.tJ.g(parama));
  }
  
  final boolean f(a parama)
  {
    return (this.tK != null) && (this.tK.g(parama));
  }
  
  static abstract interface a {}
  
  static final class b
  {
    int duration;
    final WeakReference<n.a> tM;
    boolean tN;
    
    final boolean g(n.a parama)
    {
      return (parama != null) && (this.tM.get() == parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.design.widget.n
 * JD-Core Version:    0.7.0.1
 */