package com.google.android.exoplayer2.h;

import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.t;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class r
{
  IOException aJx;
  final ExecutorService aRR;
  r.b<? extends c> aRS;
  
  public r(String paramString)
  {
    this.aRR = t.aC(paramString);
  }
  
  public final <T extends c> long a(T paramT, r.a<T> parama, int paramInt)
  {
    Looper localLooper = Looper.myLooper();
    if (localLooper != null) {}
    for (boolean bool = true;; bool = false)
    {
      a.aC(bool);
      long l = SystemClock.elapsedRealtime();
      new r.b(this, localLooper, paramT, parama, paramInt, l).start(0L);
      return l;
    }
  }
  
  public final boolean a(r.d paramd)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.aRS != null)
    {
      this.aRS.cancel(true);
      bool1 = bool2;
      if (paramd != null)
      {
        this.aRR.execute(new r.e(paramd));
        bool1 = bool2;
      }
    }
    for (;;)
    {
      this.aRR.shutdown();
      return bool1;
      bool1 = bool2;
      if (paramd != null)
      {
        paramd.nc();
        bool1 = true;
      }
    }
  }
  
  public final void cancelLoading()
  {
    this.aRS.cancel(false);
  }
  
  public final boolean isLoading()
  {
    return this.aRS != null;
  }
  
  public final void mD()
  {
    if (this.aJx != null) {
      throw this.aJx;
    }
    if (this.aRS != null)
    {
      r.b localb = this.aRS;
      int i = this.aRS.aRV;
      if ((localb.aRX != null) && (localb.aRY > i)) {
        throw localb.aRX;
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void mR();
    
    public abstract boolean mS();
    
    public abstract void mT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.h.r
 * JD-Core Version:    0.7.0.1
 */