package com.tencent.h.a.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.g.c.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class a
{
  public Handler ahWL;
  private HandlerThread mHandlerThread;
  
  public a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "worker_thread";
    }
    this.mHandlerThread = new HandlerThread(str, 0);
    this.mHandlerThread.start();
    this.ahWL = new Handler(this.mHandlerThread.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(212116);
        try
        {
          a.this.y(paramAnonymousMessage);
          AppMethodBeat.o(212116);
          return;
        }
        finally
        {
          i.i("sensor_AsyncWorker", "[method: handleMessage ] e: " + paramAnonymousMessage.getCause());
          a.this.G(paramAnonymousMessage);
          AppMethodBeat.o(212116);
        }
      }
    };
  }
  
  private void b(int paramInt1, int paramInt2, Object paramObject, long paramLong)
  {
    if (this.ahWL != null)
    {
      Message localMessage = this.ahWL.obtainMessage();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = -1;
      localMessage.obj = paramObject;
      this.ahWL.sendMessageDelayed(localMessage, paramLong);
    }
  }
  
  private void m(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.ahWL != null) {
      b(paramInt1, paramInt2, paramObject, 0L);
    }
  }
  
  public void G(Throwable paramThrowable) {}
  
  protected final void S(int paramInt, Object paramObject)
  {
    if (this.ahWL != null) {
      l(paramInt, -1, paramObject);
    }
  }
  
  protected final void aJc(int paramInt)
  {
    if ((this.ahWL != null) && (this.ahWL != null) && (this.ahWL != null))
    {
      Message localMessage = this.ahWL.obtainMessage();
      localMessage.what = paramInt;
      localMessage.arg1 = -1;
      localMessage.arg2 = -1;
      localMessage.obj = null;
      this.ahWL.sendMessageAtFrontOfQueue(localMessage);
    }
  }
  
  public final boolean isAlive()
  {
    if (this.mHandlerThread != null) {
      return this.mHandlerThread.isAlive();
    }
    return false;
  }
  
  public final void kdd()
  {
    if (this.ahWL != null) {
      this.ahWL.removeCallbacksAndMessages(null);
    }
    if (this.mHandlerThread != null)
    {
      i.i("sensor_AsyncWorker", "[method: quitHandlerThread ] ");
      this.mHandlerThread.quit();
    }
  }
  
  protected final void kde()
  {
    S(2, null);
  }
  
  protected final void kdf()
  {
    if (this.ahWL != null) {
      b(7, -1, null, 10000L);
    }
  }
  
  protected final void l(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.ahWL != null) {
      m(paramInt1, paramInt2, paramObject);
    }
  }
  
  public void y(Message paramMessage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.a.a
 * JD-Core Version:    0.7.0.1
 */