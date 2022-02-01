package com.tencent.mm.ak;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.vending.c.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public final class ab
{
  public static <T extends dpc> c.a<T> a(c<T> paramc)
  {
    AppMethodBeat.i(182921);
    if (paramc == null)
    {
      paramc = new IllegalArgumentException("Cant use NULL cgi instance");
      AppMethodBeat.o(182921);
      throw paramc;
    }
    if (aa.iNn == null) {}
    for (Object localObject = null; localObject == null; localObject = aa.iNn.azA())
    {
      Log.e("MicroMsg.SynchronousCgiCall", "NetSceneQueue not ready, just return NULL");
      AppMethodBeat.o(182921);
      return null;
    }
    if (MMHandlerThread.isMainThread())
    {
      paramc = new IllegalAccessError("Cant call this function in main thread");
      AppMethodBeat.o(182921);
      throw paramc;
    }
    if (((t)localObject).iMx.getLooper().getThread().getId() == Thread.currentThread().getId())
    {
      paramc = new IllegalAccessError("Cant call this function in NetSceneQueue's worker thread!!!");
      AppMethodBeat.o(182921);
      throw paramc;
    }
    localObject = new AtomicReference();
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    paramc.aYI().b(new a() {});
    try
    {
      localCountDownLatch.await();
      paramc = (c.a)((AtomicReference)localObject).get();
      AppMethodBeat.o(182921);
      return paramc;
    }
    catch (Exception paramc)
    {
      Log.printErrStackTrace("MicroMsg.SynchronousCgiCall", paramc, "semaphore await exp ", new Object[0]);
      AppMethodBeat.o(182921);
    }
    return null;
  }
  
  public static <T extends dpc> c.a<T> e(d paramd)
  {
    AppMethodBeat.i(182920);
    if (paramd == null)
    {
      paramd = new IllegalArgumentException("Cant use NULL rr");
      AppMethodBeat.o(182920);
      throw paramd;
    }
    if (aa.iNn == null) {}
    for (Object localObject = null; localObject == null; localObject = aa.iNn.azA())
    {
      Log.e("MicroMsg.SynchronousCgiCall", "NetSceneQueue not ready, just return NULL");
      AppMethodBeat.o(182920);
      return null;
    }
    if (MMHandlerThread.isMainThread())
    {
      paramd = new IllegalAccessError("Cant call this function in main thread");
      AppMethodBeat.o(182920);
      throw paramd;
    }
    if (((t)localObject).iMx.getLooper().getThread().getId() == Thread.currentThread().getId())
    {
      paramd = new IllegalAccessError("Cant call this function in NetSceneQueue's worker thread!!!");
      AppMethodBeat.o(182920);
      throw paramd;
    }
    localObject = new AtomicReference();
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    aa.a(paramd, new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd, q paramAnonymousq)
      {
        AppMethodBeat.i(132497);
        this.iNx.set(c.a.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, (dpc)paramAnonymousd.iLL.iLR, paramAnonymousq, null));
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
        this.iNx.set(new ab.a());
        localCountDownLatch.countDown();
        AppMethodBeat.o(132498);
        return false;
      }
    }, false).startTimer(20000L);
    try
    {
      localCountDownLatch.await();
      paramd = (c.a)((AtomicReference)localObject).get();
      AppMethodBeat.o(182920);
      return paramd;
    }
    catch (InterruptedException paramd)
    {
      Log.printErrStackTrace("MicroMsg.SynchronousCgiCall", paramd, "latch await exp ", new Object[0]);
      AppMethodBeat.o(182920);
    }
    return null;
  }
  
  public static final class a<T extends dpc>
    extends c.a<T>
  {
    public a()
    {
      this.errType = 3;
      this.errCode = -13;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ak.ab
 * JD-Core Version:    0.7.0.1
 */