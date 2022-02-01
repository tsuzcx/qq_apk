package com.tencent.mm.ak;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.vending.c.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public final class y
{
  public static <T extends cqk> c.a<T> a(c<T> paramc)
  {
    AppMethodBeat.i(182921);
    if (x.hwU == null) {}
    for (Object localObject = null; localObject == null; localObject = x.hwU.agj())
    {
      ac.e("MicroMsg.SynchronousCgiCall", "NetSceneQueue not ready, just return NULL");
      AppMethodBeat.o(182921);
      return null;
    }
    if (ap.isMainThread())
    {
      paramc = new IllegalAccessError("Cant call this function in main thread");
      AppMethodBeat.o(182921);
      throw paramc;
    }
    if (((q)localObject).hwh.GrZ.getLooper().getThread().getId() == Thread.currentThread().getId())
    {
      paramc = new IllegalAccessError("Cant call this function in NetSceneQueue's worker thread!!!");
      AppMethodBeat.o(182921);
      throw paramc;
    }
    localObject = new AtomicReference();
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    paramc.aBB().b(new a() {});
    try
    {
      localCountDownLatch.await();
      paramc = (c.a)((AtomicReference)localObject).get();
      AppMethodBeat.o(182921);
      return paramc;
    }
    catch (Exception paramc)
    {
      ac.printErrStackTrace("MicroMsg.SynchronousCgiCall", paramc, "semaphore await exp ", new Object[0]);
      AppMethodBeat.o(182921);
    }
    return null;
  }
  
  public static <T extends cqk> c.a<T> e(b paramb)
  {
    AppMethodBeat.i(182920);
    if (paramb == null)
    {
      paramb = new IllegalArgumentException("Cant use NULL rr");
      AppMethodBeat.o(182920);
      throw paramb;
    }
    if (x.hwU == null) {}
    for (Object localObject = null; localObject == null; localObject = x.hwU.agj())
    {
      ac.e("MicroMsg.SynchronousCgiCall", "NetSceneQueue not ready, just return NULL");
      AppMethodBeat.o(182920);
      return null;
    }
    if (ap.isMainThread())
    {
      paramb = new IllegalAccessError("Cant call this function in main thread");
      AppMethodBeat.o(182920);
      throw paramb;
    }
    if (((q)localObject).hwh.GrZ.getLooper().getThread().getId() == Thread.currentThread().getId())
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
        this.hxf.set(c.a.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, (cqk)paramAnonymousb.hvs.hvw, paramAnonymousn, null));
        localCountDownLatch.countDown();
        AppMethodBeat.o(132497);
        return 0;
      }
    });
    new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132498);
        this.hxf.set(new y.a());
        localCountDownLatch.countDown();
        AppMethodBeat.o(132498);
        return false;
      }
    }, false).au(20000L, 20000L);
    try
    {
      localCountDownLatch.await();
      paramb = (c.a)((AtomicReference)localObject).get();
      AppMethodBeat.o(182920);
      return paramb;
    }
    catch (InterruptedException paramb)
    {
      ac.printErrStackTrace("MicroMsg.SynchronousCgiCall", paramb, "latch await exp ", new Object[0]);
      AppMethodBeat.o(182920);
    }
    return null;
  }
  
  public static final class a<T extends cqk>
    extends c.a<T>
  {
    public a()
    {
      this.errType = 3;
      this.errCode = -13;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ak.y
 * JD-Core Version:    0.7.0.1
 */