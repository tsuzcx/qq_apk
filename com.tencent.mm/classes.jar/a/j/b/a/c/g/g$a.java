package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$a
{
  private final int number;
  private final Object object;
  
  g$a(Object paramObject, int paramInt)
  {
    this.object = paramObject;
    this.number = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof a)) {}
    do
    {
      return false;
      paramObject = (a)paramObject;
    } while ((this.object != paramObject.object) || (this.number != paramObject.number));
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(121491);
    int i = System.identityHashCode(this.object);
    int j = this.number;
    AppMethodBeat.o(121491);
    return i * 65535 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.g.g.a
 * JD-Core Version:    0.7.0.1
 */