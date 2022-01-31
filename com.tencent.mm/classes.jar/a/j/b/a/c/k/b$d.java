package a.j.b.a.c.k;

import a.f.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$d<K, V>
{
  final a<? extends V> CAD;
  private final K ypR;
  
  public b$d(K paramK, a<? extends V> parama)
  {
    this.ypR = paramK;
    this.CAD = parama;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(122442);
    if (this == paramObject)
    {
      AppMethodBeat.o(122442);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(122442);
      return false;
    }
    paramObject = (d)paramObject;
    if (!this.ypR.equals(paramObject.ypR))
    {
      AppMethodBeat.o(122442);
      return false;
    }
    AppMethodBeat.o(122442);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(122443);
    int i = this.ypR.hashCode();
    AppMethodBeat.o(122443);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.k.b.d
 * JD-Core Version:    0.7.0.1
 */