package a;

import a.f.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/SafePublicationLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "final", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "Companion", "kotlin-stdlib"})
final class r<T>
  implements f<T>, Serializable
{
  private static final AtomicReferenceFieldUpdater<r<?>, Object> BMc;
  public static final a BMd;
  private volatile a<? extends T> BLZ;
  private volatile Object BMa;
  private final Object BMb;
  
  static
  {
    AppMethodBeat.i(55912);
    BMd = new a((byte)0);
    BMc = AtomicReferenceFieldUpdater.newUpdater(r.class, Object.class, "BMa");
    AppMethodBeat.o(55912);
  }
  
  public r(a<? extends T> parama)
  {
    AppMethodBeat.i(55911);
    this.BLZ = parama;
    this.BMa = w.BMf;
    this.BMb = w.BMf;
    AppMethodBeat.o(55911);
  }
  
  private final Object writeReplace()
  {
    AppMethodBeat.i(55910);
    d locald = new d(getValue());
    AppMethodBeat.o(55910);
    return locald;
  }
  
  public final T getValue()
  {
    AppMethodBeat.i(55908);
    Object localObject = this.BMa;
    if (localObject != w.BMf)
    {
      AppMethodBeat.o(55908);
      return localObject;
    }
    localObject = this.BLZ;
    if (localObject != null)
    {
      localObject = ((a)localObject).invoke();
      if (BMc.compareAndSet(this, w.BMf, localObject))
      {
        this.BLZ = null;
        AppMethodBeat.o(55908);
        return localObject;
      }
    }
    localObject = this.BMa;
    AppMethodBeat.o(55908);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(55909);
    if (this.BMa != w.BMf) {}
    for (int i = 1; i != 0; i = 0)
    {
      String str = String.valueOf(getValue());
      AppMethodBeat.o(55909);
      return str;
    }
    AppMethodBeat.o(55909);
    return "Lazy value not initialized yet.";
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/SafePublicationLazyImpl$Companion;", "", "()V", "valueUpdater", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/SafePublicationLazyImpl;", "kotlin.jvm.PlatformType", "kotlin-stdlib"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.r
 * JD-Core Version:    0.7.0.1
 */