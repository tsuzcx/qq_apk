package a.k;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/sequences/ConstrainedOnceSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "(Lkotlin/sequences/Sequence;)V", "sequenceRef", "Ljava/util/concurrent/atomic/AtomicReference;", "kotlin.jvm.PlatformType", "iterator", "", "kotlin-stdlib"})
public final class a<T>
  implements h<T>
{
  private final AtomicReference<h<T>> CGg;
  
  public a(h<? extends T> paramh)
  {
    AppMethodBeat.i(55952);
    this.CGg = new AtomicReference(paramh);
    AppMethodBeat.o(55952);
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(55951);
    Object localObject = (h)this.CGg.getAndSet(null);
    if (localObject == null)
    {
      localObject = (Throwable)new IllegalStateException("This sequence can be consumed only once.");
      AppMethodBeat.o(55951);
      throw ((Throwable)localObject);
    }
    localObject = ((h)localObject).iterator();
    AppMethodBeat.o(55951);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.k.a
 * JD-Core Version:    0.7.0.1
 */