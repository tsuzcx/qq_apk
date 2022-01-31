package a.j.b.a.c.k;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$j<T>
{
  final boolean CAM;
  private final T value;
  
  static
  {
    AppMethodBeat.i(122459);
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(122459);
      return;
    }
  }
  
  private b$j(T paramT, boolean paramBoolean)
  {
    this.value = paramT;
    this.CAM = paramBoolean;
  }
  
  public static <T> j<T> dO(T paramT)
  {
    AppMethodBeat.i(122455);
    paramT = new j(paramT, false);
    AppMethodBeat.o(122455);
    return paramT;
  }
  
  public static <T> j<T> eoE()
  {
    AppMethodBeat.i(122456);
    j localj = new j(null, true);
    AppMethodBeat.o(122456);
    return localj;
  }
  
  public final T getValue()
  {
    AppMethodBeat.i(122457);
    if ((!$assertionsDisabled) && (this.CAM))
    {
      localObject = new AssertionError("A value requested from FALL_THROUGH in ".concat(String.valueOf(this)));
      AppMethodBeat.o(122457);
      throw ((Throwable)localObject);
    }
    Object localObject = this.value;
    AppMethodBeat.o(122457);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122458);
    if (this.CAM)
    {
      AppMethodBeat.o(122458);
      return "FALL_THROUGH";
    }
    String str = String.valueOf(this.value);
    AppMethodBeat.o(122458);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.k.b.j
 * JD-Core Version:    0.7.0.1
 */