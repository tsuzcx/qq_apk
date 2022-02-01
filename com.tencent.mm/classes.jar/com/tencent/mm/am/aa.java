package com.tencent.mm.am;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cp.f;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.vending.c.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public final class aa
{
  public static <T extends esc> b.a<T> a(c paramc, long paramLong)
  {
    AppMethodBeat.i(236813);
    if (paramc == null)
    {
      paramc = new IllegalArgumentException("Cant use NULL rr");
      AppMethodBeat.o(236813);
      throw paramc;
    }
    if (z.ovg == null) {}
    for (Object localObject = null; localObject == null; localObject = z.ovg.aZX())
    {
      Log.e("MicroMsg.SynchronousCgiCall", "NetSceneQueue not ready, just return NULL");
      AppMethodBeat.o(236813);
      return null;
    }
    if (MMHandlerThread.isMainThread())
    {
      paramc = new IllegalAccessError("Cant call this function in main thread");
      AppMethodBeat.o(236813);
      throw paramc;
    }
    if (((s)localObject).ouo.getLooper().getThread().getId() == Thread.currentThread().getId())
    {
      paramc = new IllegalAccessError("Cant call this function in NetSceneQueue's worker thread!!!");
      AppMethodBeat.o(236813);
      throw paramc;
    }
    localObject = new AtomicReference();
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    z.a(paramc, new z.a()
    {
      public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, c paramAnonymousc, p paramAnonymousp)
      {
        AppMethodBeat.i(132497);
        aa.this.set(b.a.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, (esc)c.c.b(paramAnonymousc.otC), paramAnonymousp, null));
        localCountDownLatch.countDown();
        AppMethodBeat.o(132497);
        return 0;
      }
    });
    new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132498);
        aa.this.set(new aa.a());
        localCountDownLatch.countDown();
        AppMethodBeat.o(132498);
        return false;
      }
    }, false).startTimer(paramLong);
    try
    {
      localCountDownLatch.await();
      paramc = (b.a)((AtomicReference)localObject).get();
      AppMethodBeat.o(236813);
      return paramc;
    }
    catch (InterruptedException paramc)
    {
      Log.printErrStackTrace("MicroMsg.SynchronousCgiCall", paramc, "latch await exp ", new Object[0]);
      AppMethodBeat.o(236813);
    }
    return null;
  }
  
  public static <T extends esc> b.a<T> c(b<T> paramb)
  {
    AppMethodBeat.i(182921);
    if (paramb == null)
    {
      paramb = new IllegalArgumentException("Cant use NULL cgi instance");
      AppMethodBeat.o(182921);
      throw paramb;
    }
    if (z.ovg == null) {}
    for (Object localObject = null; localObject == null; localObject = z.ovg.aZX())
    {
      Log.e("MicroMsg.SynchronousCgiCall", "NetSceneQueue not ready, just return NULL");
      AppMethodBeat.o(182921);
      return null;
    }
    if (MMHandlerThread.isMainThread())
    {
      paramb = new IllegalAccessError("Cant call this function in main thread");
      AppMethodBeat.o(182921);
      throw paramb;
    }
    if (((s)localObject).ouo.getLooper().getThread().getId() == Thread.currentThread().getId())
    {
      paramb = new IllegalAccessError("Cant call this function in NetSceneQueue's worker thread!!!");
      AppMethodBeat.o(182921);
      throw paramb;
    }
    localObject = new AtomicReference();
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    paramb.bFJ().b(new a() {});
    try
    {
      localCountDownLatch.await();
      paramb = (b.a)((AtomicReference)localObject).get();
      AppMethodBeat.o(182921);
      return paramb;
    }
    catch (Exception paramb)
    {
      Log.printErrStackTrace("MicroMsg.SynchronousCgiCall", paramb, "semaphore await exp ", new Object[0]);
      AppMethodBeat.o(182921);
    }
    return null;
  }
  
  public static final class a<T extends esc>
    extends b.a<T>
  {
    public a()
    {
      this.errType = 3;
      this.errCode = -13;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.am.aa
 * JD-Core Version:    0.7.0.1
 */