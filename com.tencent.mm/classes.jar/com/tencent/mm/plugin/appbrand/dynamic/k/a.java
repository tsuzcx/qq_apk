package com.tencent.mm.plugin.appbrand.dynamic.k;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.CountDownLatch;

public final class a
{
  public static <T extends com.tencent.mm.kernel.c.a> T aS(Class<T> paramClass)
  {
    AppMethodBeat.i(121518);
    Object localObject = h.ax(paramClass);
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
    if (!h.baF().mDl.mDG)
    {
      CountDownLatch localCountDownLatch = new CountDownLatch(1);
      localObject = new g()
      {
        public final void aDv()
        {
          AppMethodBeat.i(121516);
          a.this.countDown();
          AppMethodBeat.o(121516);
        }
        
        public final void dZ(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(121517);
          a.this.countDown();
          AppMethodBeat.o(121517);
        }
      };
      h.baF().a((g)localObject);
      try
      {
        localCountDownLatch.await();
        h.baF().b((g)localObject);
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SyncGetter", localInterruptedException, "", new Object[0]);
          h.baF().b((g)localObject);
        }
      }
      finally
      {
        h.baF().b((g)localObject);
        AppMethodBeat.o(121518);
      }
      paramClass = h.ax(paramClass);
      AppMethodBeat.o(121518);
      return paramClass;
    }
    AppMethodBeat.o(121518);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.k.a
 * JD-Core Version:    0.7.0.1
 */