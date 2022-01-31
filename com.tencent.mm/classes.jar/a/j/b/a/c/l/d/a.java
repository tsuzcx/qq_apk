package a.j.b.a.c.l.d;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a<T>
{
  final T CDc;
  public final T CDd;
  
  public a(T paramT1, T paramT2)
  {
    this.CDc = paramT1;
    this.CDd = paramT2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(122829);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!j.e(this.CDc, paramObject.CDc)) || (!j.e(this.CDd, paramObject.CDd))) {}
      }
    }
    else
    {
      AppMethodBeat.o(122829);
      return true;
    }
    AppMethodBeat.o(122829);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(122828);
    Object localObject = this.CDc;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.CDd;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(122828);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122827);
    String str = "ApproximationBounds(lower=" + this.CDc + ", upper=" + this.CDd + ")";
    AppMethodBeat.o(122827);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.j.b.a.c.l.d.a
 * JD-Core Version:    0.7.0.1
 */