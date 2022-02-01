package com.tencent.mm.plugin.appbrand.dynamic.k;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.CountDownLatch;

public final class a
{
  public static <T extends com.tencent.mm.kernel.c.a> T aA(Class<T> paramClass)
  {
    AppMethodBeat.i(121518);
    Object localObject = com.tencent.mm.kernel.g.af(paramClass);
    if (localObject != null)
    {
      AppMethodBeat.o(121518);
      return localObject;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      AppMethodBeat.o(121518);
      return null;
    }
    if (!com.tencent.mm.kernel.g.aAi().hrh.hrB)
    {
      CountDownLatch localCountDownLatch = new CountDownLatch(1);
      localObject = new com.tencent.mm.kernel.api.g()
      {
        public final void WY()
        {
          AppMethodBeat.i(121516);
          this.val$latch.countDown();
          AppMethodBeat.o(121516);
        }
        
        public final void cQ(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(121517);
          this.val$latch.countDown();
          AppMethodBeat.o(121517);
        }
      };
      com.tencent.mm.kernel.g.aAi().a((com.tencent.mm.kernel.api.g)localObject);
      try
      {
        localCountDownLatch.await();
        com.tencent.mm.kernel.g.aAi().b((com.tencent.mm.kernel.api.g)localObject);
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SyncGetter", localInterruptedException, "", new Object[0]);
          com.tencent.mm.kernel.g.aAi().b((com.tencent.mm.kernel.api.g)localObject);
        }
      }
      finally
      {
        com.tencent.mm.kernel.g.aAi().b((com.tencent.mm.kernel.api.g)localObject);
        AppMethodBeat.o(121518);
      }
      paramClass = com.tencent.mm.kernel.g.af(paramClass);
      AppMethodBeat.o(121518);
      return paramClass;
    }
    AppMethodBeat.o(121518);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.k.a
 * JD-Core Version:    0.7.0.1
 */