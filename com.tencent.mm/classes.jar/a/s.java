package a;

import a.f.a.a;
import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/SynchronizedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "lock", "", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "_value", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"})
final class s<T>
  implements f<T>, Serializable
{
  private a<? extends T> BLZ;
  private volatile Object BMa;
  private final Object lock;
  
  private s(a<? extends T> parama)
  {
    AppMethodBeat.i(56256);
    this.BLZ = parama;
    this.BMa = w.BMf;
    this.lock = this;
    AppMethodBeat.o(56256);
  }
  
  private final Object writeReplace()
  {
    AppMethodBeat.i(56255);
    d locald = new d(getValue());
    AppMethodBeat.o(56255);
    return locald;
  }
  
  public final T getValue()
  {
    AppMethodBeat.i(56253);
    Object localObject1 = this.BMa;
    if (localObject1 != w.BMf)
    {
      AppMethodBeat.o(56253);
      return localObject1;
    }
    synchronized (this.lock)
    {
      localObject1 = this.BMa;
      w localw = w.BMf;
      if (localObject1 != localw)
      {
        AppMethodBeat.o(56253);
        return localObject1;
      }
      localObject1 = this.BLZ;
      if (localObject1 == null) {
        j.ebi();
      }
      localObject1 = ((a)localObject1).invoke();
      this.BMa = localObject1;
      this.BLZ = null;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56254);
    if (this.BMa != w.BMf) {}
    for (int i = 1; i != 0; i = 0)
    {
      String str = String.valueOf(getValue());
      AppMethodBeat.o(56254);
      return str;
    }
    AppMethodBeat.o(56254);
    return "Lazy value not initialized yet.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.s
 * JD-Core Version:    0.7.0.1
 */