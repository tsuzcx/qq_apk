package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

final class c$a
  implements Iterator<f>
{
  private int mIndex = 0;
  
  private c$a(c paramc) {}
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(52776);
    if (this.mIndex < this.leY.size())
    {
      AppMethodBeat.o(52776);
      return true;
    }
    AppMethodBeat.o(52776);
    return false;
  }
  
  public final void remove() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.c.a
 * JD-Core Version:    0.7.0.1
 */