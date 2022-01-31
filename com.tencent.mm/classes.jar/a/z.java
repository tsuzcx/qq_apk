package a;

import a.f.a.a;
import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/UnsafeLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"})
public final class z<T>
  implements f<T>, Serializable
{
  private a<? extends T> BLZ;
  private Object BMa;
  
  public z(a<? extends T> parama)
  {
    AppMethodBeat.i(56411);
    this.BLZ = parama;
    this.BMa = w.BMf;
    AppMethodBeat.o(56411);
  }
  
  private final Object writeReplace()
  {
    AppMethodBeat.i(56410);
    d locald = new d(getValue());
    AppMethodBeat.o(56410);
    return locald;
  }
  
  public final T getValue()
  {
    AppMethodBeat.i(56408);
    if (this.BMa == w.BMf)
    {
      localObject = this.BLZ;
      if (localObject == null) {
        j.ebi();
      }
      this.BMa = ((a)localObject).invoke();
      this.BLZ = null;
    }
    Object localObject = this.BMa;
    AppMethodBeat.o(56408);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56409);
    if (this.BMa != w.BMf) {}
    for (int i = 1; i != 0; i = 0)
    {
      String str = String.valueOf(getValue());
      AppMethodBeat.o(56409);
      return str;
    }
    AppMethodBeat.o(56409);
    return "Lazy value not initialized yet.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.z
 * JD-Core Version:    0.7.0.1
 */