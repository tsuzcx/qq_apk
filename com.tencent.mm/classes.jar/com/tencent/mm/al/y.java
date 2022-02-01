package com.tencent.mm.al;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.vending.c.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public final class y
{
  public static <T extends cld> c.a<T> a(c<T> paramc)
  {
    AppMethodBeat.i(182921);
    if (x.gWv == null) {}
    for (Object localObject = null; localObject == null; localObject = x.gWv.aeT())
    {
      ad.e("MicroMsg.SynchronousCgiCall", "NetSceneQueue not ready, just return NULL");
      AppMethodBeat.o(182921);
      return null;
    }
    if (aq.isMainThread())
    {
      paramc = new IllegalAccessError("Cant call this function in main thread");
      AppMethodBeat.o(182921);
      throw paramc;
    }
    if (((q)localObject).gVI.EUN.getLooper().getThread().getId() == Thread.currentThread().getId())
    {
      paramc = new IllegalAccessError("Cant call this function in NetSceneQueue's worker thread!!!");
      AppMethodBeat.o(182921);
      throw paramc;
    }
    localObject = new AtomicReference();
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    paramc.auK().b(new a() {});
    try
    {
      localCountDownLatch.await();
      paramc = (c.a)((AtomicReference)localObject).get();
      AppMethodBeat.o(182921);
      return paramc;
    }
    catch (Exception paramc)
    {
      ad.printErrStackTrace("MicroMsg.SynchronousCgiCall", paramc, "semaphore await exp ", new Object[0]);
      AppMethodBeat.o(182921);
    }
    return null;
  }
  
  public static <T extends cld> c.a<T> e(b paramb)
  {
    AppMethodBeat.i(182920);
    if (paramb == null)
    {
      paramb = new IllegalArgumentException("Cant use NULL rr");
      AppMethodBeat.o(182920);
      throw paramb;
    }
    if (x.gWv == null) {}
    for (Object localObject = null; localObject == null; localObject = x.gWv.aeT())
    {
      ad.e("MicroMsg.SynchronousCgiCall", "NetSceneQueue not ready, just return NULL");
      AppMethodBeat.o(182920);
      return null;
    }
    if (aq.isMainThread())
    {
      paramb = new IllegalAccessError("Cant call this function in main thread");
      AppMethodBeat.o(182920);
      throw paramb;
    }
    if (((q)localObject).gVI.EUN.getLooper().getThread().getId() == Thread.currentThread().getId())
    {
      paramb = new IllegalAccessError("Cant call this function in NetSceneQueue's worker thread!!!");
      AppMethodBeat.o(182920);
      throw paramb;
    }
    localObject = new AtomicReference();
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    x.a(paramb, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(132497);
        this.gWG.set(c.a.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, (cld)paramAnonymousb.gUT.gUX, paramAnonymousn, null));
        localCountDownLatch.countDown();
        AppMethodBeat.o(132497);
        return 0;
      }
    });
    new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132498);
        this.gWG.set(new y.a());
        localCountDownLatch.countDown();
        AppMethodBeat.o(132498);
        return false;
      }
    }, false).av(20000L, 20000L);
    try
    {
      localCountDownLatch.await();
      paramb = (c.a)((AtomicReference)localObject).get();
      AppMethodBeat.o(182920);
      return paramb;
    }
    catch (InterruptedException paramb)
    {
      ad.printErrStackTrace("MicroMsg.SynchronousCgiCall", paramb, "latch await exp ", new Object[0]);
      AppMethodBeat.o(182920);
    }
    return null;
  }
  
  public static final class a<T extends cld>
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
 * Qualified Name:     com.tencent.mm.al.y
 * JD-Core Version:    0.7.0.1
 */