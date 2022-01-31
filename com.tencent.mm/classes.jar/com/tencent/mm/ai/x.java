package com.tencent.mm.ai;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public final class x
{
  public static <T extends bvk> a.a<T> a(a<T> parama)
  {
    AppMethodBeat.i(58317);
    if (w.fuq == null) {}
    for (Object localObject = null; localObject == null; localObject = w.fuq.Rd())
    {
      ab.e("MicroMsg.SynchronousCgiCall", "NetSceneQueue not ready, just return NULL");
      AppMethodBeat.o(58317);
      return null;
    }
    if (al.isMainThread())
    {
      parama = new IllegalAccessError("Cant call this function in main thread");
      AppMethodBeat.o(58317);
      throw parama;
    }
    if (((p)localObject).ftB.oNc.getLooper().getThread().getId() == Thread.currentThread().getId())
    {
      parama = new IllegalAccessError("Cant call this function in NetSceneQueue's worker thread!!!");
      AppMethodBeat.o(58317);
      throw parama;
    }
    localObject = new AtomicReference();
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    parama.adl().b(new x.3((AtomicReference)localObject, localCountDownLatch));
    try
    {
      localCountDownLatch.await();
      parama = (a.a)((AtomicReference)localObject).get();
      AppMethodBeat.o(58317);
      return parama;
    }
    catch (Exception parama)
    {
      ab.printErrStackTrace("MicroMsg.SynchronousCgiCall", parama, "semaphore await exp ", new Object[0]);
      AppMethodBeat.o(58317);
    }
    return null;
  }
  
  public static <T extends bvk> a.a<T> c(b paramb)
  {
    AppMethodBeat.i(58316);
    if (paramb == null)
    {
      paramb = new IllegalArgumentException("Cant use NULL rr");
      AppMethodBeat.o(58316);
      throw paramb;
    }
    if (w.fuq == null) {}
    for (Object localObject = null; localObject == null; localObject = w.fuq.Rd())
    {
      ab.e("MicroMsg.SynchronousCgiCall", "NetSceneQueue not ready, just return NULL");
      AppMethodBeat.o(58316);
      return null;
    }
    if (al.isMainThread())
    {
      paramb = new IllegalAccessError("Cant call this function in main thread");
      AppMethodBeat.o(58316);
      throw paramb;
    }
    if (((p)localObject).ftB.oNc.getLooper().getThread().getId() == Thread.currentThread().getId())
    {
      paramb = new IllegalAccessError("Cant call this function in NetSceneQueue's worker thread!!!");
      AppMethodBeat.o(58316);
      throw paramb;
    }
    localObject = new AtomicReference();
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    w.a(paramb, new w.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, m paramAnonymousm)
      {
        AppMethodBeat.i(58313);
        this.fuB.set(a.a.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, (bvk)paramAnonymousb.fsW.fta, paramAnonymousm, null));
        localCountDownLatch.countDown();
        AppMethodBeat.o(58313);
        return 0;
      }
    });
    new ap(Looper.getMainLooper(), new x.2((AtomicReference)localObject, localCountDownLatch), false).ag(20000L, 20000L);
    try
    {
      localCountDownLatch.await();
      paramb = (a.a)((AtomicReference)localObject).get();
      AppMethodBeat.o(58316);
      return paramb;
    }
    catch (InterruptedException paramb)
    {
      ab.printErrStackTrace("MicroMsg.SynchronousCgiCall", paramb, "latch await exp ", new Object[0]);
      AppMethodBeat.o(58316);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ai.x
 * JD-Core Version:    0.7.0.1
 */