package com.tencent.mm.plugin.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.g;

final class b$9
  implements g
{
  b$9(b paramb) {}
  
  public final boolean accept(e parame)
  {
    AppMethodBeat.i(22698);
    if (parame.isDirectory())
    {
      AppMethodBeat.o(22698);
      return false;
    }
    if ((parame.getName().endsWith(".apk")) || (parame.getName().endsWith(".temp")))
    {
      AppMethodBeat.o(22698);
      return true;
    }
    AppMethodBeat.o(22698);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.f.b.9
 * JD-Core Version:    0.7.0.1
 */