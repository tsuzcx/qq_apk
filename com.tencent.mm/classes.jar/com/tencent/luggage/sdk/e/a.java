package com.tencent.luggage.sdk.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/sdk/tasks/AppBrandBasePreFetchTask;", "T", "", "()V", "cost", "", "endTimeStampMs", "getEndTimeStampMs", "()J", "setEndTimeStampMs", "(J)V", "futureTask", "Ljava/util/concurrent/FutureTask;", "isUsed", "", "()Z", "setUsed", "(Z)V", "startTimeStampMs", "getStartTimeStampMs", "setStartTimeStampMs", "cancel", "", "getPreFetchResult", "timeoutMs", "", "(I)Ljava/lang/Object;", "initialed", "isDone", "key", "post", "preFetch", "()Ljava/lang/Object;", "Companion", "luggage-wechat-full-sdk_release"})
public abstract class a<T>
{
  public static final a cCw = new a((byte)0);
  protected FutureTask<T> cCr;
  protected long cCs;
  protected long cCt;
  public boolean cCu;
  private long cCv;
  
  public abstract T OX();
  
  public abstract int OY();
  
  public final boolean OZ()
  {
    return ((a)this).cCr != null;
  }
  
  public final void cancel()
  {
    if (((a)this).cCr == null) {
      throw ((Throwable)new IllegalStateException());
    }
    FutureTask localFutureTask = this.cCr;
    if (localFutureTask == null) {
      p.btv("futureTask");
    }
    localFutureTask.cancel(false);
  }
  
  public T hS(int paramInt)
  {
    if (((a)this).cCr == null) {
      throw ((Throwable)new IllegalStateException());
    }
    Object localObject1 = this.cCr;
    if (localObject1 == null) {
      p.btv("futureTask");
    }
    boolean bool2 = ((FutureTask)localObject1).isDone();
    Object localObject2 = null;
    long l1 = 0L;
    localObject1 = localObject2;
    try
    {
      long l2 = System.currentTimeMillis();
      localObject1 = localObject2;
      FutureTask localFutureTask = this.cCr;
      if (localFutureTask == null)
      {
        localObject1 = localObject2;
        p.btv("futureTask");
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
    paramInt = OY();
    if (localObject1 != null)
    {
      bool1 = true;
      Log.i("Luggage.AppBrandBasePreFetchTask", "getPreFetchResult: #%d task hit preFetch, isPreFetchSuccess = [%b], is done before invoke = [%b], cost = [%dms], wait = [%dms]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(this.cCv), Long.valueOf(l1) });
      this.cCu = true;
      return localObject1;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/sdk/tasks/AppBrandBasePreFetchTask$Companion;", "", "()V", "DEFAULT_TIME_OUT", "", "TAG", "", "luggage-wechat-full-sdk_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "T", "call", "()Ljava/lang/Object;"})
  static final class b<V>
    implements Callable<T>
  {
    b(a parama) {}
    
    public final T call()
    {
      AppMethodBeat.i(230041);
      long l1 = System.currentTimeMillis();
      Object localObject = this.cCx.OX();
      long l2 = System.currentTimeMillis();
      a.a(this.cCx, l2 - l1);
      AppMethodBeat.o(230041);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.e.a
 * JD-Core Version:    0.7.0.1
 */