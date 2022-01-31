package a.j.b.a.c.k;

import a.f.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

class b$f<T>
  extends b.e<T>
  implements f<T>
{
  static
  {
    AppMethodBeat.i(122447);
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(122447);
      return;
    }
  }
  
  public b$f(b paramb, a<? extends T> parama)
  {
    super(paramb, parama);
  }
  
  public final T invoke()
  {
    AppMethodBeat.i(122446);
    Object localObject = super.invoke();
    if ((!$assertionsDisabled) && (localObject == null))
    {
      localObject = new AssertionError("compute() returned null");
      AppMethodBeat.o(122446);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(122446);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.k.b.f
 * JD-Core Version:    0.7.0.1
 */