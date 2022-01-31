package com.tencent.mm.ah;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.ck.f;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public final class x
{
  public static <T extends bly> a.a<T> a(a<T> parama)
  {
    if (w.een == null) {}
    for (Object localObject = null; localObject == null; localObject = w.een.Dl())
    {
      y.e("MicroMsg.SynchronousCgiCall", "NetSceneQueue not ready, just return NULL");
      return null;
    }
    if (ai.isMainThread()) {
      throw new IllegalAccessError("Cant call this function in main thread");
    }
    if (((p)localObject).edy.mnU.getLooper().getThread().getId() == Thread.currentThread().getId()) {
      throw new IllegalAccessError("Cant call this function in NetSceneQueue's worker thread!!!");
    }
    localObject = new AtomicReference();
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    parama.Km().b(new x.3((AtomicReference)localObject, localCountDownLatch));
    try
    {
      localCountDownLatch.await();
      return (a.a)((AtomicReference)localObject).get();
    }
    catch (Exception parama)
    {
      y.printErrStackTrace("MicroMsg.SynchronousCgiCall", parama, "semaphore await exp ", new Object[0]);
    }
    return null;
  }
  
  public static <T extends bly> a.a<T> c(b paramb)
  {
    if (paramb == null) {
      throw new IllegalArgumentException("Cant use NULL rr");
    }
    if (w.een == null) {}
    for (Object localObject = null; localObject == null; localObject = w.een.Dl())
    {
      y.e("MicroMsg.SynchronousCgiCall", "NetSceneQueue not ready, just return NULL");
      return null;
    }
    if (ai.isMainThread()) {
      throw new IllegalAccessError("Cant call this function in main thread");
    }
    if (((p)localObject).edy.mnU.getLooper().getThread().getId() == Thread.currentThread().getId()) {
      throw new IllegalAccessError("Cant call this function in NetSceneQueue's worker thread!!!");
    }
    localObject = new AtomicReference();
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    w.a(paramb, new x.1((AtomicReference)localObject, localCountDownLatch));
    new am(Looper.getMainLooper(), new x.2((AtomicReference)localObject, localCountDownLatch), false).S(20000L, 20000L);
    try
    {
      localCountDownLatch.await();
      return (a.a)((AtomicReference)localObject).get();
    }
    catch (InterruptedException paramb)
    {
      y.printErrStackTrace("MicroMsg.SynchronousCgiCall", paramb, "latch await exp ", new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.x
 * JD-Core Version:    0.7.0.1
 */