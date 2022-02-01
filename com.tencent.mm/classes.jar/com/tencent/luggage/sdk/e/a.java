package com.tencent.luggage.sdk.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/luggage/sdk/tasks/AppBrandBasePreFetchTask;", "T", "", "()V", "cost", "", "endTimeStampMs", "getEndTimeStampMs", "()J", "setEndTimeStampMs", "(J)V", "futureTask", "Ljava/util/concurrent/FutureTask;", "isUsed", "", "()Z", "setUsed", "(Z)V", "startTimeStampMs", "getStartTimeStampMs", "setStartTimeStampMs", "cancel", "", "getPreFetchResult", "timeoutMs", "", "(I)Ljava/lang/Object;", "initialed", "isDone", "key", "post", "preFetch", "()Ljava/lang/Object;", "Companion", "luggage-wechat-full-sdk_release"})
public abstract class a<T>
{
  public static final a cpA = new a((byte)0);
  protected FutureTask<T> cpv;
  protected long cpw;
  protected long cpx;
  public boolean cpy;
  private long cpz;
  
  public abstract T Fj();
  
  public abstract int Fk();
  
  public final boolean Fl()
  {
    return ((a)this).cpv != null;
  }
  
  public final void cancel()
  {
    if (((a)this).cpv == null) {
      throw ((Throwable)new IllegalStateException());
    }
    FutureTask localFutureTask = this.cpv;
    if (localFutureTask == null) {
      p.bcb("futureTask");
    }
    localFutureTask.cancel(false);
  }
  
  public T gC(int paramInt)
  {
    if (((a)this).cpv == null) {
      throw ((Throwable)new IllegalStateException());
    }
    Object localObject1 = this.cpv;
    if (localObject1 == null) {
      p.bcb("futureTask");
    }
    boolean bool2 = ((FutureTask)localObject1).isDone();
    Object localObject2 = null;
    long l1 = 0L;
    localObject1 = localObject2;
    try
    {
      long l2 = System.currentTimeMillis();
      localObject1 = localObject2;
      FutureTask localFutureTask = this.cpv;
      if (localFutureTask == null)
      {
        localObject1 = localObject2;
        p.bcb("futureTask");
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
        ad.e("Luggage.AppBrandBasePreFetchTask", "getPreFetchResult: " + localException.getMessage());
        continue;
        boolean bool1 = false;
      }
    }
    if (localObject1 == null) {
      cancel();
    }
    paramInt = Fk();
    if (localObject1 != null)
    {
      bool1 = true;
      ad.i("Luggage.AppBrandBasePreFetchTask", "getPreFetchResult: #%d task hit preFetch, isPreFetchSuccess = [%b], is done before invoke = [%b], cost = [%dms], wait = [%dms]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(this.cpz), Long.valueOf(l1) });
      this.cpy = true;
      return localObject1;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/luggage/sdk/tasks/AppBrandBasePreFetchTask$Companion;", "", "()V", "DEFAULT_TIME_OUT", "", "TAG", "", "luggage-wechat-full-sdk_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "T", "call", "()Ljava/lang/Object;"})
  static final class b<V>
    implements Callable<T>
  {
    b(a parama) {}
    
    public final T call()
    {
      AppMethodBeat.i(192329);
      long l1 = System.currentTimeMillis();
      Object localObject = this.cpB.Fj();
      long l2 = System.currentTimeMillis();
      a.a(this.cpB, l2 - l1);
      AppMethodBeat.o(192329);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.e.a
 * JD-Core Version:    0.7.0.1
 */