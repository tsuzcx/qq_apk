package com.google.android.exoplayer2.h;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.i.a;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

@SuppressLint({"HandlerLeak"})
final class r$b<T extends r.c>
  extends Handler
  implements Runnable
{
  private final T aRT;
  private final r.a<T> aRU;
  public final int aRV;
  private final long aRW;
  IOException aRX;
  int aRY;
  private volatile Thread aRZ;
  private volatile boolean released;
  
  public r$b(Looper paramLooper, T paramT, r.a<T> parama, int paramInt, long paramLong)
  {
    super(paramT);
    this.aRT = parama;
    this.aRU = paramInt;
    this.aRV = paramLong;
    Object localObject;
    this.aRW = localObject;
  }
  
  private void execute()
  {
    this.aRX = null;
    this.aSa.aRR.execute(this.aSa.aRS);
  }
  
  private void finish()
  {
    this.aSa.aRS = null;
  }
  
  public final void cancel(boolean paramBoolean)
  {
    this.released = paramBoolean;
    this.aRX = null;
    if (hasMessages(0))
    {
      removeMessages(0);
      if (!paramBoolean) {
        sendEmptyMessage(1);
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        finish();
        long l = SystemClock.elapsedRealtime();
        this.aRU.a(this.aRT, l, l - this.aRW, true);
      }
      return;
      this.aRT.mR();
      if (this.aRZ != null) {
        this.aRZ.interrupt();
      }
    }
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (this.released) {}
    do
    {
      return;
      if (paramMessage.what == 0)
      {
        execute();
        return;
      }
      if (paramMessage.what == 4) {
        throw ((Error)paramMessage.obj);
      }
      finish();
      long l1 = SystemClock.elapsedRealtime();
      long l2 = l1 - this.aRW;
      if (this.aRT.mS())
      {
        this.aRU.a(this.aRT, l1, l2, false);
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        this.aRU.a(this.aRT, l1, l2, false);
        return;
      case 2: 
        this.aRU.a(this.aRT, l1, l2);
        return;
      }
      this.aRX = ((IOException)paramMessage.obj);
      i = this.aRU.a(this.aRT, l1, l2, this.aRX);
      if (i == 3)
      {
        this.aSa.aJx = this.aRX;
        return;
      }
    } while (i == 2);
    if (i == 1) {}
    for (int i = 1;; i = this.aRY + 1)
    {
      this.aRY = i;
      start(Math.min((this.aRY - 1) * 1000, 5000));
      return;
    }
  }
  
  public final void run()
  {
    try
    {
      this.aRZ = Thread.currentThread();
      if (!this.aRT.mS()) {
        com.google.android.exoplayer2.i.r.beginSection("load:" + this.aRT.getClass().getSimpleName());
      }
      try
      {
        this.aRT.mT();
        com.google.android.exoplayer2.i.r.endSection();
        if (!this.released)
        {
          sendEmptyMessage(2);
          return;
        }
      }
      finally
      {
        com.google.android.exoplayer2.i.r.endSection();
      }
      return;
    }
    catch (IOException localIOException)
    {
      if (!this.released)
      {
        obtainMessage(3, localIOException).sendToTarget();
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      a.aC(this.aRT.mS());
      if (!this.released)
      {
        sendEmptyMessage(2);
        return;
      }
    }
    catch (Exception localException)
    {
      if (!this.released)
      {
        obtainMessage(3, new r.f(localException)).sendToTarget();
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (!this.released)
      {
        obtainMessage(3, new r.f(localOutOfMemoryError)).sendToTarget();
        return;
      }
    }
    catch (Error localError)
    {
      if (!this.released) {
        obtainMessage(4, localError).sendToTarget();
      }
      throw localError;
    }
  }
  
  public final void start(long paramLong)
  {
    if (this.aSa.aRS == null) {}
    for (boolean bool = true;; bool = false)
    {
      a.aC(bool);
      this.aSa.aRS = this;
      if (paramLong <= 0L) {
        break;
      }
      sendEmptyMessageDelayed(0, paramLong);
      return;
    }
    execute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.h.r.b
 * JD-Core Version:    0.7.0.1
 */