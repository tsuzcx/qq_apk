package com.tencent.mm.modelimage.loader.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.LinkedBlockingDeque;

public final class a<E>
  extends LinkedBlockingDeque<E>
{
  public final boolean offer(E paramE)
  {
    AppMethodBeat.i(130431);
    boolean bool = super.offerFirst(paramE);
    AppMethodBeat.o(130431);
    return bool;
  }
  
  public final E remove()
  {
    AppMethodBeat.i(130432);
    Object localObject = super.removeFirst();
    AppMethodBeat.o(130432);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelimage.loader.d.a
 * JD-Core Version:    0.7.0.1
 */