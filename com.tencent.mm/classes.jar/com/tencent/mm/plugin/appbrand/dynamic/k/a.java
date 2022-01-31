package com.tencent.mm.plugin.appbrand.dynamic.k;

import android.os.Looper;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.CountDownLatch;

public final class a
{
  public static <T extends com.tencent.mm.kernel.c.a> T J(Class<T> paramClass)
  {
    Object localObject = com.tencent.mm.kernel.g.r(paramClass);
    if (localObject != null) {
      return localObject;
    }
    if (Looper.myLooper() == Looper.getMainLooper()) {
      return null;
    }
    if (!com.tencent.mm.kernel.g.DQ().dKP.dLj)
    {
      CountDownLatch localCountDownLatch = new CountDownLatch(1);
      localObject = new a.1(localCountDownLatch);
      com.tencent.mm.kernel.g.DQ().a((com.tencent.mm.kernel.api.g)localObject);
      try
      {
        localCountDownLatch.await();
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.SyncGetter", localInterruptedException, "", new Object[0]);
          com.tencent.mm.kernel.g.DQ().b((com.tencent.mm.kernel.api.g)localObject);
        }
      }
      finally
      {
        com.tencent.mm.kernel.g.DQ().b((com.tencent.mm.kernel.api.g)localObject);
      }
      return com.tencent.mm.kernel.g.r(paramClass);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.k.a
 * JD-Core Version:    0.7.0.1
 */