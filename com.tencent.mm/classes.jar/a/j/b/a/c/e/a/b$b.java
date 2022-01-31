package a.j.b.a.c.e.a;

import a.j.b.a.c.g.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$b<E extends j.a>
  extends b.c<E>
{
  private final E[] CoS;
  
  public b$b(int paramInt, E[] paramArrayOfE)
  {
    super(paramInt, Z(paramArrayOfE), (byte)0);
    AppMethodBeat.i(121069);
    this.CoS = paramArrayOfE;
    AppMethodBeat.o(121069);
  }
  
  private static <E> int Z(E[] paramArrayOfE)
  {
    AppMethodBeat.i(121070);
    int j = paramArrayOfE.length - 1;
    if (j == 0)
    {
      AppMethodBeat.o(121070);
      return 1;
    }
    int i = 31;
    while (i >= 0)
    {
      if ((1 << i & j) != 0)
      {
        AppMethodBeat.o(121070);
        return i + 1;
      }
      i -= 1;
    }
    paramArrayOfE = new IllegalStateException("Empty enum: " + paramArrayOfE.getClass());
    AppMethodBeat.o(121070);
    throw paramArrayOfE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.j.b.a.c.e.a.b.b
 * JD-Core Version:    0.7.0.1
 */