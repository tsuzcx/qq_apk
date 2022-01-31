package com.tencent.mm.plugin.appbrand.dynamic.k;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.CountDownLatch;

public final class a
{
  public static <T extends com.tencent.mm.kernel.c.a> T Z(Class<T> paramClass)
  {
    AppMethodBeat.i(11036);
    Object localObject = com.tencent.mm.kernel.g.E(paramClass);
    if (localObject != null)
    {
      AppMethodBeat.o(11036);
      return localObject;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      AppMethodBeat.o(11036);
      return null;
    }
    if (!com.tencent.mm.kernel.g.RM().eIn.eIH)
    {
      CountDownLatch localCountDownLatch = new CountDownLatch(1);
      localObject = new a.1(localCountDownLatch);
      com.tencent.mm.kernel.g.RM().a((com.tencent.mm.kernel.api.g)localObject);
      try
      {
        localCountDownLatch.await();
        com.tencent.mm.kernel.g.RM().b((com.tencent.mm.kernel.api.g)localObject);
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.SyncGetter", localInterruptedException, "", new Object[0]);
          com.tencent.mm.kernel.g.RM().b((com.tencent.mm.kernel.api.g)localObject);
        }
      }
      finally
      {
        com.tencent.mm.kernel.g.RM().b((com.tencent.mm.kernel.api.g)localObject);
        AppMethodBeat.o(11036);
      }
      paramClass = com.tencent.mm.kernel.g.E(paramClass);
      AppMethodBeat.o(11036);
      return paramClass;
    }
    AppMethodBeat.o(11036);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.k.a
 * JD-Core Version:    0.7.0.1
 */