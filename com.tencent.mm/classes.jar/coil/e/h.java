package coil.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.aa;
import j.k;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlinx.coroutines.p;

@Metadata(d1={""}, d2={"Lcoil/decode/InterruptibleSource;", "Lokio/ForwardingSource;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "delegate", "Lokio/Source;", "(Lkotlinx/coroutines/CancellableContinuation;Lokio/Source;)V", "_state", "Ljava/util/concurrent/atomic/AtomicInteger;", "targetThread", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "clearInterrupt", "invalidState", "", "state", "", "invoke", "read", "", "sink", "Lokio/Buffer;", "byteCount", "setInterruptible", "interruptible", "", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends k
  implements b<Throwable, ah>
{
  private final AtomicInteger cno;
  private final Thread cnp;
  
  public h(p<?> paramp, aa paramaa)
  {
    super(paramaa);
    AppMethodBeat.i(187827);
    this.cno = new AtomicInteger(1);
    this.cnp = Thread.currentThread();
    paramp.bg((b)this);
    paramp = (h)this;
    paramaa = paramp.cno;
    int i;
    do
    {
      i = paramaa.get();
      switch (i)
      {
      case 2: 
      default: 
        gQ(i);
        paramp = new kotlin.f();
        AppMethodBeat.o(187827);
        throw paramp;
      }
    } while (!paramp.cno.compareAndSet(i, 1));
    AppMethodBeat.o(187827);
    return;
    AppMethodBeat.o(187827);
  }
  
  private final void bo(boolean paramBoolean)
  {
    AppMethodBeat.i(187841);
    Object localObject = this.cno;
    int j;
    do
    {
      j = ((AtomicInteger)localObject).get();
      switch (j)
      {
      case 4: 
      case 2: 
      default: 
        gQ(j);
        localObject = new kotlin.f();
        AppMethodBeat.o(187841);
        throw ((Throwable)localObject);
      case 0: 
      case 1: 
        if (paramBoolean) {}
        for (int i = 0; this.cno.compareAndSet(j, i); i = 1)
        {
          AppMethodBeat.o(187841);
          return;
        }
      }
    } while (!this.cno.compareAndSet(j, 4));
    this.cnp.interrupt();
    this.cno.set(5);
    AppMethodBeat.o(187841);
    return;
    Thread.interrupted();
    AppMethodBeat.o(187841);
  }
  
  private static Void gQ(int paramInt)
  {
    AppMethodBeat.i(187845);
    Throwable localThrowable = (Throwable)new IllegalStateException(s.X("Illegal state: ", Integer.valueOf(paramInt)).toString());
    AppMethodBeat.o(187845);
    throw localThrowable;
  }
  
  public final void MP()
  {
    AppMethodBeat.i(187867);
    Object localObject = this.cno;
    int i;
    do
    {
      i = ((AtomicInteger)localObject).get();
      switch (i)
      {
      case 4: 
      case 1: 
      case 2: 
      default: 
        gQ(i);
        localObject = new kotlin.f();
        AppMethodBeat.o(187867);
        throw ((Throwable)localObject);
      }
    } while (!this.cno.compareAndSet(i, 2));
    AppMethodBeat.o(187867);
    return;
    Thread.interrupted();
    AppMethodBeat.o(187867);
  }
  
  public final long a(j.f paramf, long paramLong)
  {
    AppMethodBeat.i(187856);
    s.u(paramf, "sink");
    try
    {
      bo(false);
      paramLong = super.a(paramf, paramLong);
      return paramLong;
    }
    finally
    {
      bo(true);
      AppMethodBeat.o(187856);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     coil.e.h
 * JD-Core Version:    0.7.0.1
 */