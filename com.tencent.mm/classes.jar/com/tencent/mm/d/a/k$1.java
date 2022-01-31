package com.tencent.mm.d.a;

import com.eclipsesource.v8.MultiContextV8;
import com.eclipsesource.v8.utils.MemoryManager;
import com.tencent.mm.sdk.platformtools.y;

public final class k$1
  implements Runnable
{
  public k$1(k paramk) {}
  
  public final void run()
  {
    try
    {
      k.a(this.bzN).release();
      k.b(this.bzN).release();
      localh = k.c(this.bzN);
    }
    catch (Exception localException1)
    {
      synchronized (localh.bzA)
      {
        for (;;)
        {
          h localh;
          localh.ahC = false;
          y.i("MicroMsg.J2V8.V8Runtime", "exit");
          return;
          localException1 = localException1;
          y.e("MicroMsg.J2V8.V8Runtime", "V8 release ex = %s", new Object[] { localException1 });
          try
          {
            k.b(this.bzN).release();
          }
          catch (Exception localException2)
          {
            y.e("MicroMsg.J2V8.V8Runtime", "V8 release ex again = %s", new Object[] { localException1 });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.d.a.k.1
 * JD-Core Version:    0.7.0.1
 */