package androidx.compose.runtime;

import androidx.compose.runtime.c.d;
import androidx.compose.runtime.c.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/SnapshotThreadLocal;", "T", "", "()V", "map", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/internal/ThreadMap;", "Landroidx/compose/runtime/AtomicReference;", "writeMutex", "get", "()Ljava/lang/Object;", "set", "", "value", "(Ljava/lang/Object;)V", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bk<T>
{
  private final AtomicReference<d> aqf;
  private final Object aqg;
  
  public bk()
  {
    AppMethodBeat.i(201949);
    this.aqf = new AtomicReference(e.rb());
    this.aqg = new Object();
    AppMethodBeat.o(201949);
  }
  
  public final T get()
  {
    AppMethodBeat.i(201954);
    Object localObject = ((d)this.aqf.get()).A(Thread.currentThread().getId());
    AppMethodBeat.o(201954);
    return localObject;
  }
  
  public final void set(T paramT)
  {
    AppMethodBeat.i(201959);
    long l = Thread.currentThread().getId();
    synchronized (this.aqg)
    {
      d locald = (d)this.aqf.get();
      boolean bool = locald.c(l, paramT);
      if (bool)
      {
        AppMethodBeat.o(201959);
        return;
      }
      this.aqf.set(locald.d(l, paramT));
      paramT = ah.aiuX;
      AppMethodBeat.o(201959);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.bk
 * JD-Core Version:    0.7.0.1
 */