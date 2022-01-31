package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

final class l
{
  private static l kC;
  l.b kD;
  l.b kE;
  private final Handler mHandler = new Handler(Looper.getMainLooper(), new l.1(this));
  final Object mLock = new Object();
  
  static l bD()
  {
    if (kC == null) {
      kC = new l();
    }
    return kC;
  }
  
  public final void a(l.a parama)
  {
    synchronized (this.mLock)
    {
      if ((d(parama)) && (!this.kD.kH))
      {
        this.kD.kH = true;
        this.mHandler.removeCallbacksAndMessages(this.kD);
      }
      return;
    }
  }
  
  final boolean a(l.b paramb)
  {
    if ((l.a)paramb.kG.get() != null)
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
      if ((d(parama)) && (this.kD.kH))
      {
        this.kD.kH = false;
        b(this.kD);
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
    return (this.kD != null) && (this.kD.f(parama));
  }
  
  final boolean e(l.a parama)
  {
    return (this.kE != null) && (this.kE.f(parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.design.widget.l
 * JD-Core Version:    0.7.0.1
 */