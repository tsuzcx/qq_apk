package com.tencent.i.a.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.h.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class a
{
  public Handler Son;
  public HandlerThread mHandlerThread;
  
  public a(String paramString)
  {
    hI(paramString, 0);
  }
  
  public a(String paramString, byte paramByte)
  {
    hI(paramString, 5);
  }
  
  private void hI(String paramString, int paramInt)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "worker_thread";
    }
    this.mHandlerThread = new HandlerThread(str, paramInt);
    this.mHandlerThread.start();
    this.Son = new Handler(this.mHandlerThread.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(214682);
        try
        {
          a.this.q(paramAnonymousMessage);
          AppMethodBeat.o(214682);
          return;
        }
        catch (Throwable paramAnonymousMessage)
        {
          h.i("sensor_AsyncWorker", "[method: handleMessage ] e: " + paramAnonymousMessage.getCause());
          a.this.q(paramAnonymousMessage);
          AppMethodBeat.o(214682);
        }
      }
    };
  }
  
  private void k(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.Son != null) {
      b(paramInt1, paramInt2, paramObject, 0L);
    }
  }
  
  public final void a(com.tencent.h.a.a parama)
  {
    if (parama != null) {
      this.Son.removeCallbacks(parama);
    }
  }
  
  protected final void asB(int paramInt)
  {
    if ((this.Son != null) && (this.Son != null) && (this.Son != null))
    {
      Message localMessage = this.Son.obtainMessage();
      localMessage.what = paramInt;
      localMessage.arg1 = -1;
      localMessage.arg2 = -1;
      localMessage.obj = null;
      this.Son.sendMessageAtFrontOfQueue(localMessage);
    }
  }
  
  protected final void b(int paramInt1, int paramInt2, Object paramObject, long paramLong)
  {
    if (this.Son != null)
    {
      Message localMessage = this.Son.obtainMessage();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = -1;
      localMessage.obj = paramObject;
      this.Son.sendMessageDelayed(localMessage, paramLong);
    }
  }
  
  protected final void hqd()
  {
    u(2, null);
  }
  
  protected final void j(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.Son != null) {
      k(paramInt1, paramInt2, paramObject);
    }
  }
  
  public void q(Message paramMessage) {}
  
  public void q(Throwable paramThrowable) {}
  
  protected final void u(int paramInt, Object paramObject)
  {
    if (this.Son != null) {
      j(paramInt, -1, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.a.a
 * JD-Core Version:    0.7.0.1
 */