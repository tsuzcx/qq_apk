package com.tencent.mm.ck;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vending.h.a;

public final class d
  implements a
{
  private ah mHandler;
  
  public d(ah paramah)
  {
    this.mHandler = paramah;
  }
  
  public static d c(ah paramah)
  {
    return new d(paramah);
  }
  
  public final void c(Runnable paramRunnable, long paramLong)
  {
    this.mHandler.postDelayed(paramRunnable, paramLong);
  }
  
  public final void dD()
  {
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  public final void f(Runnable paramRunnable)
  {
    this.mHandler.post(paramRunnable);
  }
  
  public final Looper getLooper()
  {
    return this.mHandler.getLooper();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ck.d
 * JD-Core Version:    0.7.0.1
 */