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
  public Handler ZQg;
  public HandlerThread mHandlerThread;
  
  public a(String paramString)
  {
    ir(paramString, 0);
  }
  
  public a(String paramString, byte paramByte)
  {
    ir(paramString, 5);
  }
  
  private void b(int paramInt1, int paramInt2, Object paramObject, long paramLong)
  {
    if (this.ZQg != null)
    {
      Message localMessage = this.ZQg.obtainMessage();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = -1;
      localMessage.obj = paramObject;
      this.ZQg.sendMessageDelayed(localMessage, paramLong);
    }
  }
  
  private void ir(String paramString, int paramInt)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "worker_thread";
    }
    this.mHandlerThread = new HandlerThread(str, paramInt);
    this.mHandlerThread.start();
    this.ZQg = new Handler(this.mHandlerThread.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(208442);
        try
        {
          a.this.q(paramAnonymousMessage);
          AppMethodBeat.o(208442);
          return;
        }
        catch (Throwable paramAnonymousMessage)
        {
          i.i("sensor_AsyncWorker", "[method: handleMessage ] e: " + paramAnonymousMessage.getCause());
          a.this.q(paramAnonymousMessage);
          AppMethodBeat.o(208442);
        }
      }
    };
  }
  
  private void l(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.ZQg != null) {
      b(paramInt1, paramInt2, paramObject, 0L);
    }
  }
  
  public final void a(com.tencent.g.a.a parama)
  {
    if (parama != null) {
      this.ZQg.removeCallbacks(parama);
    }
  }
  
  protected final void aCp(int paramInt)
  {
    if ((this.ZQg != null) && (this.ZQg != null) && (this.ZQg != null))
    {
      Message localMessage = this.ZQg.obtainMessage();
      localMessage.what = paramInt;
      localMessage.arg1 = -1;
      localMessage.arg2 = -1;
      localMessage.obj = null;
      this.ZQg.sendMessageAtFrontOfQueue(localMessage);
    }
  }
  
  protected final void itI()
  {
    y(2, null);
  }
  
  protected final void itJ()
  {
    if (this.ZQg != null) {
      b(7, -1, null, 10000L);
    }
  }
  
  protected final void k(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.ZQg != null) {
      l(paramInt1, paramInt2, paramObject);
    }
  }
  
  public void q(Message paramMessage) {}
  
  public void q(Throwable paramThrowable) {}
  
  protected final void y(int paramInt, Object paramObject)
  {
    if (this.ZQg != null) {
      k(paramInt, -1, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.a.a
 * JD-Core Version:    0.7.0.1
 */