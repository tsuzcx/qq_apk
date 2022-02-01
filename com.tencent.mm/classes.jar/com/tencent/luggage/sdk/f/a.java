package com.tencent.luggage.sdk.f;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/tasks/AppBrandBasePreFetchTask;", "T", "", "()V", "cost", "", "endTimeStampMs", "getEndTimeStampMs", "()J", "setEndTimeStampMs", "(J)V", "futureTask", "Ljava/util/concurrent/FutureTask;", "isUsed", "", "()Z", "setUsed", "(Z)V", "startTimeStampMs", "getStartTimeStampMs", "setStartTimeStampMs", "cancel", "", "getPreFetchResult", "timeoutMs", "", "(I)Ljava/lang/Object;", "initialed", "isDone", "key", "post", "preFetch", "()Ljava/lang/Object;", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a<T>
{
  public static final a.a evx = new a.a((byte)0);
  private long cost;
  private long evA;
  public boolean evB;
  private FutureTask<T> evy;
  private long evz;
  
  private static final Object b(a parama)
  {
    s.u(parama, "this$0");
    long l = System.currentTimeMillis();
    Object localObject = parama.asK();
    parama.cost = (System.currentTimeMillis() - l);
    return localObject;
  }
  
  protected final long asI()
  {
    return this.evz;
  }
  
  protected final long asJ()
  {
    return this.evA;
  }
  
  public abstract T asK();
  
  public abstract int asL();
  
  public final void asM()
  {
    this.evy = new FutureTask(new a..ExternalSyntheticLambda0(this));
    i locali = h.ahAA;
    FutureTask localFutureTask2 = this.evy;
    FutureTask localFutureTask1 = localFutureTask2;
    if (localFutureTask2 == null)
    {
      s.bIx("futureTask");
      localFutureTask1 = null;
    }
    locali.bm((Runnable)localFutureTask1);
  }
  
  public final boolean asN()
  {
    return this.evy != null;
  }
  
  public final void cancel()
  {
    if (this.evy == null) {
      throw new IllegalStateException();
    }
    FutureTask localFutureTask2 = this.evy;
    FutureTask localFutureTask1 = localFutureTask2;
    if (localFutureTask2 == null)
    {
      s.bIx("futureTask");
      localFutureTask1 = null;
    }
    localFutureTask1.cancel(false);
  }
  
  protected final void du(long paramLong)
  {
    this.evz = paramLong;
  }
  
  protected final void dv(long paramLong)
  {
    this.evA = paramLong;
  }
  
  public final boolean isDone()
  {
    if (this.evy == null) {
      throw new IllegalStateException();
    }
    FutureTask localFutureTask2 = this.evy;
    FutureTask localFutureTask1 = localFutureTask2;
    if (localFutureTask2 == null)
    {
      s.bIx("futureTask");
      localFutureTask1 = null;
    }
    return localFutureTask1.isDone();
  }
  
  public T mv(int paramInt)
  {
    Object localObject3 = null;
    if (this.evy == null) {
      throw new IllegalStateException();
    }
    Object localObject2 = this.evy;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("futureTask");
      localObject1 = null;
    }
    boolean bool2 = localObject1.isDone();
    long l1 = 0L;
    localObject1 = localObject3;
    try
    {
      long l2 = System.currentTimeMillis();
      localObject1 = localObject3;
      FutureTask localFutureTask = this.evy;
      localObject2 = localFutureTask;
      if (localFutureTask == null)
      {
        localObject1 = localObject3;
        s.bIx("futureTask");
        localObject2 = null;
      }
      localObject1 = localObject3;
      localObject2 = ((FutureTask)localObject2).get(paramInt, TimeUnit.MILLISECONDS);
      localObject1 = localObject2;
      long l3 = System.currentTimeMillis();
      l1 = l3 - l2;
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("Luggage.AppBrandBasePreFetchTask", s.X("getPreFetchResult: ", localException.getMessage()));
        continue;
        boolean bool1 = false;
      }
    }
    if (localObject1 == null) {
      cancel();
    }
    paramInt = asL();
    if (localObject1 != null)
    {
      bool1 = true;
      Log.i("Luggage.AppBrandBasePreFetchTask", "getPreFetchResult: #%d task hit preFetch, isPreFetchSuccess = [%b], is done before invoke = [%b], cost = [%dms], wait = [%dms]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(this.cost), Long.valueOf(l1) });
      this.evB = true;
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.f.a
 * JD-Core Version:    0.7.0.1
 */