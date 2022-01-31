package com.tencent.liteav.basic.b;

import android.os.Looper;

class a$3
  implements Runnable
{
  a$3(a parama) {}
  
  public void run()
  {
    a.a(this.a, false);
    a.a(this.a);
    try
    {
      Looper.myLooper().quit();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.liteav.basic.b.a.3
 * JD-Core Version:    0.7.0.1
 */