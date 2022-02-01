package com.tencent.luggage.sdk.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/luggage/sdk/tasks/AppBrandBasePreFetchTask;", "T", "", "()V", "cost", "", "endTimeStampMs", "getEndTimeStampMs", "()J", "setEndTimeStampMs", "(J)V", "futureTask", "Ljava/util/concurrent/FutureTask;", "isUsed", "", "()Z", "setUsed", "(Z)V", "startTimeStampMs", "getStartTimeStampMs", "setStartTimeStampMs", "cancel", "", "getPreFetchResult", "timeoutMs", "", "(I)Ljava/lang/Object;", "initialed", "isDone", "key", "post", "preFetch", "()Ljava/lang/Object;", "Companion", "luggage-wechat-full-sdk_release"})
public abstract class a<T>
{
  public static final a cfk = new a((byte)0);
  protected FutureTask<T> cfe;
  protected long cff;
  protected long cfh;
  protected boolean cfi;
  private long cfj;
  
  public abstract T DK();
  
  public abstract int DL();
  
  public final boolean DM()
  {
    return ((a)this).cfe != null;
  }
  
  public final void cancel()
  {
    if (((a)this).cfe == null) {
      throw ((Throwable)new IllegalStateException());
    }
    FutureTask localFutureTask = this.cfe;
    if (localFutureTask == null) {
      k.aVY("futureTask");
    }
    localFutureTask.cancel(false);
  }
  
  public T gx(int paramInt)
  {
    if (((a)this).cfe == null) {
      throw ((Throwable)new IllegalStateException());
    }
    Object localObject1 = this.cfe;
    if (localObject1 == null) {
      k.aVY("futureTask");
    }
    boolean bool2 = ((FutureTask)localObject1).isDone();
    Object localObject2 = null;
    long l1 = 0L;
    localObject1 = localObject2;
    try
    {
      long l2 = System.currentTimeMillis();
      localObject1 = localObject2;
      FutureTask localFutureTask = this.cfe;
      if (localFutureTask == null)
      {
        localObject1 = localObject2;
        k.aVY("futureTask");
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
        ac.e("Luggage.AppBrandBasePreFetchTask", "getPreFetchResult: " + localException.getMessage());
        continue;
        boolean bool1 = false;
      }
    }
    if (localObject1 == null) {
      cancel();
    }
    paramInt = DL();
    if (localObject1 != null)
    {
      bool1 = true;
      ac.i("Luggage.AppBrandBasePreFetchTask", "getPreFetchResult: #%d task hit preFetch, isPreFetchSuccess = [%b], is done before invoke = [%b], cost = [%dms], wait = [%dms]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(this.cfj), Long.valueOf(l1) });
      this.cfi = true;
      return localObject1;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/luggage/sdk/tasks/AppBrandBasePreFetchTask$Companion;", "", "()V", "DEFAULT_TIME_OUT", "", "TAG", "", "luggage-wechat-full-sdk_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "T", "call", "()Ljava/lang/Object;"})
  static final class b<V>
    implements Callable<T>
  {
    b(a parama) {}
    
    public final T call()
    {
      AppMethodBeat.i(206197);
      long l1 = System.currentTimeMillis();
      Object localObject = this.cfl.DK();
      long l2 = System.currentTimeMillis();
      a.a(this.cfl, l2 - l1);
      AppMethodBeat.o(206197);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.e.a
 * JD-Core Version:    0.7.0.1
 */