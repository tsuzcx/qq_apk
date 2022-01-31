package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.NoSuchElementException;

final class c$a
  implements d.a
{
  private final int limit;
  private int position;
  
  private c$a(c paramc)
  {
    AppMethodBeat.i(121411);
    this.position = paramc.Crb;
    this.limit = (this.position + paramc.size());
    AppMethodBeat.o(121411);
  }
  
  public final boolean hasNext()
  {
    return this.position < this.limit;
  }
  
  public final byte nextByte()
  {
    AppMethodBeat.i(121412);
    if (this.position >= this.limit)
    {
      localObject = new NoSuchElementException();
      AppMethodBeat.o(121412);
      throw ((Throwable)localObject);
    }
    Object localObject = this.Crd.pW;
    int i = this.position;
    this.position = (i + 1);
    byte b = localObject[i];
    AppMethodBeat.o(121412);
    return b;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(121413);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(121413);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.g.c.a
 * JD-Core Version:    0.7.0.1
 */