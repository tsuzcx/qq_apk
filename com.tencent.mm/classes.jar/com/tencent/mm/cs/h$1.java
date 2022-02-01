package com.tencent.mm.cs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

final class h$1
  implements Iterable<Integer>
{
  h$1(String paramString) {}
  
  public final Iterator<Integer> iterator()
  {
    AppMethodBeat.i(231605);
    Iterator local1 = new Iterator()
    {
      private int length;
      private int nextIndex;
      
      public final boolean hasNext()
      {
        return this.nextIndex < this.length;
      }
      
      public final void remove()
      {
        AppMethodBeat.i(231601);
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(231601);
        throw localUnsupportedOperationException;
      }
    };
    AppMethodBeat.o(231605);
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.cs.h.1
 * JD-Core Version:    0.7.0.1
 */