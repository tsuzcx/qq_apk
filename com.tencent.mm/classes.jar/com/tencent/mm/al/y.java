package com.tencent.mm.al;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public final class y
{
  public static <T extends cvp> a.a<T> a(a<T> parama)
  {
    AppMethodBeat.i(182921);
    if (parama == null)
    {
      parama = new IllegalArgumentException("Cant use NULL cgi instance");
      AppMethodBeat.o(182921);
      throw parama;
    }
    if (x.hPm == null) {}
    for (Object localObject = null; localObject == null; localObject = x.hPm.aiV())
    {
      ad.e("MicroMsg.SynchronousCgiCall", "NetSceneQueue not ready, just return NULL");
      AppMethodBeat.o(182921);
      return null;
    }
    if (aq.isMainThread())
    {
      parama = new IllegalAccessError("Cant call this function in main thread");
      AppMethodBeat.o(182921);
      throw parama;
    }
    if (((q)localObject).hOw.IdO.getLooper().getThread().getId() == Thread.currentThread().getId())
    {
      parama = new IllegalAccessError("Cant call this function in NetSceneQueue's worker thread!!!");
      AppMethodBeat.o(182921);
      throw parama;
    }
    localObject = new AtomicReference();
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    parama.aED().b(new com.tencent.mm.vending.c.a() {});
    try
    {
      localCountDownLatch.await();
      parama = (a.a)((AtomicReference)localObject).get();
      AppMethodBeat.o(182921);
      return parama;
    }
    catch (Exception parama)
    {
      ad.printErrStackTrace("MicroMsg.SynchronousCgiCall", parama, "semaphore await exp ", new Object[0]);
      AppMethodBeat.o(182921);
    }
    return null;
  }
  
  public static <T extends cvp> a.a<T> e(b paramb)
  {
    AppMethodBeat.i(182920);
    if (paramb == null)
    {
      paramb = new IllegalArgumentException("Cant use NULL rr");
      AppMethodBeat.o(182920);
      throw paramb;
    }
    if (x.hPm == null) {}
    for (Object localObject = null; localObject == null; localObject = x.hPm.aiV())
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
    if (((q)localObject).hOw.IdO.getLooper().getThread().getId() == Thread.currentThread().getId())
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
        this.hPx.set(a.a.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, (cvp)paramAnonymousb.hNL.hNQ, paramAnonymousn, null));
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
        this.hPx.set(new y.a());
        localCountDownLatch.countDown();
        AppMethodBeat.o(132498);
        return false;
      }
    }, false).az(20000L, 20000L);
    try
    {
      localCountDownLatch.await();
      paramb = (a.a)((AtomicReference)localObject).get();
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
  
  public static final class a<T extends cvp>
    extends a.a<T>
  {
    public a()
    {
      this.errType = 3;
      this.errCode = -13;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.y
 * JD-Core Version:    0.7.0.1
 */