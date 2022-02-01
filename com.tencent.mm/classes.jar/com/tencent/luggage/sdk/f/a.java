package com.tencent.luggage.sdk.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/tasks/AppBrandBasePreFetchTask;", "T", "", "()V", "cost", "", "endTimeStampMs", "getEndTimeStampMs", "()J", "setEndTimeStampMs", "(J)V", "futureTask", "Ljava/util/concurrent/FutureTask;", "isUsed", "", "()Z", "setUsed", "(Z)V", "startTimeStampMs", "getStartTimeStampMs", "setStartTimeStampMs", "cancel", "", "getPreFetchResult", "timeoutMs", "", "(I)Ljava/lang/Object;", "initialed", "isDone", "key", "post", "preFetch", "()Ljava/lang/Object;", "Companion", "luggage-wechat-full-sdk_release"})
public abstract class a<T>
{
  public static final a cCZ = new a((byte)0);
  protected FutureTask<T> cCU;
  private long cCV;
  private long cCW;
  public boolean cCX;
  private long cCY;
  
  protected final long St()
  {
    return this.cCV;
  }
  
  protected final long Su()
  {
    return this.cCW;
  }
  
  public abstract T Sv();
  
  public abstract int Sw();
  
  public final boolean Sx()
  {
    return ((a)this).cCU != null;
  }
  
  protected final void bc(long paramLong)
  {
    this.cCV = paramLong;
  }
  
  protected final void bd(long paramLong)
  {
    this.cCW = paramLong;
  }
  
  public final void cancel()
  {
    if (((a)this).cCU == null) {
      throw ((Throwable)new IllegalStateException());
    }
    FutureTask localFutureTask = this.cCU;
    if (localFutureTask == null) {
      p.bGy("futureTask");
    }
    localFutureTask.cancel(false);
  }
  
  public T iU(int paramInt)
  {
    if (((a)this).cCU == null) {
      throw ((Throwable)new IllegalStateException());
    }
    Object localObject1 = this.cCU;
    if (localObject1 == null) {
      p.bGy("futureTask");
    }
    boolean bool2 = ((FutureTask)localObject1).isDone();
    Object localObject2 = null;
    long l1 = 0L;
    localObject1 = localObject2;
    try
    {
      long l2 = System.currentTimeMillis();
      localObject1 = localObject2;
      FutureTask localFutureTask = this.cCU;
      if (localFutureTask == null)
      {
        localObject1 = localObject2;
        p.bGy("futureTask");
      }
      localObject1 = localObject2;
      localObject2 = localFutureTask.get(paramInt, TimeUnit.MILLISECONDS);
      localObject1 = localObject2;
      long l3 = System.currentTimeMillis();
      l1 = l3 - l2;
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("Luggage.AppBrandBasePreFetchTask", "getPreFetchResult: " + localException.getMessage());
        continue;
        boolean bool1 = false;
      }
    }
    if (localObject1 == null) {
      cancel();
    }
    paramInt = Sw();
    if (localObject1 != null)
    {
      bool1 = true;
      Log.i("Luggage.AppBrandBasePreFetchTask", "getPreFetchResult: #%d task hit preFetch, isPreFetchSuccess = [%b], is done before invoke = [%b], cost = [%dms], wait = [%dms]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(this.cCY), Long.valueOf(l1) });
      this.cCX = true;
      return localObject1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/tasks/AppBrandBasePreFetchTask$Companion;", "", "()V", "DEFAULT_TIME_OUT", "", "TAG", "", "luggage-wechat-full-sdk_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "T", "call", "()Ljava/lang/Object;"})
  static final class b<V>
    implements Callable<T>
  {
    b(a parama) {}
    
    public final T call()
    {
      AppMethodBeat.i(246001);
      long l1 = System.currentTimeMillis();
      Object localObject = this.cDa.Sv();
      long l2 = System.currentTimeMillis();
      a.a(this.cDa, l2 - l1);
      AppMethodBeat.o(246001);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.f.a
 * JD-Core Version:    0.7.0.1
 */