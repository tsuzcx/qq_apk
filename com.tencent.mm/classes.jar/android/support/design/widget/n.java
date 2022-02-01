package android.support.design.widget;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

final class n
{
  private static n tB;
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
        if ((localn.tC == localb) || (localn.tD == localb)) {
          localn.a(localb);
        }
        return true;
      }
    }
  });
  final Object lock = new Object();
  b tC;
  b tD;
  
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
  
  static n cT()
  {
    if (tB == null) {
      tB = new n();
    }
    return tB;
  }
  
  public final void a(a parama)
  {
    synchronized (this.lock)
    {
      if (e(parama)) {
        b(this.tC);
      }
      return;
    }
  }
  
  final boolean a(b paramb)
  {
    if ((a)paramb.tF.get() != null)
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
      if ((e(parama)) && (!this.tC.tG))
      {
        this.tC.tG = true;
        this.handler.removeCallbacksAndMessages(this.tC);
      }
      return;
    }
  }
  
  public final void c(a parama)
  {
    synchronized (this.lock)
    {
      if ((e(parama)) && (this.tC.tG))
      {
        this.tC.tG = false;
        b(this.tC);
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
    return (this.tC != null) && (this.tC.g(parama));
  }
  
  final boolean f(a parama)
  {
    return (this.tD != null) && (this.tD.g(parama));
  }
  
  static abstract interface a {}
  
  static final class b
  {
    int duration;
    final WeakReference<n.a> tF;
    boolean tG;
    
    final boolean g(n.a parama)
    {
      return (parama != null) && (this.tF.get() == parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.n
 * JD-Core Version:    0.7.0.1
 */