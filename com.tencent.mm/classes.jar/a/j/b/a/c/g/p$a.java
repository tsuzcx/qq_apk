package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.NoSuchElementException;

final class p$a
  implements d.a
{
  private final int limit;
  private int position;
  
  private p$a(p paramp)
  {
    AppMethodBeat.i(121567);
    this.position = 0;
    this.limit = paramp.size();
    AppMethodBeat.o(121567);
  }
  
  public final boolean hasNext()
  {
    return this.position < this.limit;
  }
  
  public final byte nextByte()
  {
    AppMethodBeat.i(121568);
    try
    {
      byte[] arrayOfByte = this.CrU.pW;
      int i = this.position;
      this.position = (i + 1);
      byte b = arrayOfByte[i];
      AppMethodBeat.o(121568);
      return b;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      NoSuchElementException localNoSuchElementException = new NoSuchElementException(localArrayIndexOutOfBoundsException.getMessage());
      AppMethodBeat.o(121568);
      throw localNoSuchElementException;
    }
  }
  
  public final void remove()
  {
    AppMethodBeat.i(121569);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(121569);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.g.p.a
 * JD-Core Version:    0.7.0.1
 */