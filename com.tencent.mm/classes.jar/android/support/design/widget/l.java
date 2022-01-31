package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

final class l
{
  private static l jE;
  l.b jF;
  l.b jG;
  private final Handler mHandler = new Handler(Looper.getMainLooper(), new l.1(this));
  final Object mLock = new Object();
  
  static l aT()
  {
    if (jE == null) {
      jE = new l();
    }
    return jE;
  }
  
  public final void a(l.a parama)
  {
    synchronized (this.mLock)
    {
      if ((d(parama)) && (!this.jF.jJ))
      {
        this.jF.jJ = true;
        this.mHandler.removeCallbacksAndMessages(this.jF);
      }
      return;
    }
  }
  
  final boolean a(l.b paramb)
  {
    if ((l.a)paramb.jI.get() != null)
    {
      this.mHandler.removeCallbacksAndMessages(paramb);
      return true;
    }
    return false;
  }
  
  public final void b(l.a parama)
  {
    synchronized (this.mLock)
    {
      if ((d(parama)) && (this.jF.jJ))
      {
        this.jF.jJ = false;
        b(this.jF);
      }
      return;
    }
  }
  
  final void b(l.b paramb)
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
      this.mHandler.removeCallbacksAndMessages(paramb);
      this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 0, paramb), i);
      return;
      if (paramb.duration == -1) {
        i = 1500;
      }
    }
  }
  
  public final boolean c(l.a parama)
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (!d(parama))
        {
          if (!e(parama)) {
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
  
  final boolean d(l.a parama)
  {
    return (this.jF != null) && (this.jF.f(parama));
  }
  
  final boolean e(l.a parama)
  {
    return (this.jG != null) && (this.jG.f(parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.widget.l
 * JD-Core Version:    0.7.0.1
 */