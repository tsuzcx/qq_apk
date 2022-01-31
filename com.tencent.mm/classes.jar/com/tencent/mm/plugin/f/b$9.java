package com.tencent.mm.plugin.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.c;

final class b$9
  implements c
{
  b$9(b paramb) {}
  
  public final boolean g(com.tencent.mm.vfs.b paramb)
  {
    AppMethodBeat.i(18589);
    if (paramb.isDirectory())
    {
      AppMethodBeat.o(18589);
      return false;
    }
    if ((paramb.getName().endsWith(".apk")) || (paramb.getName().endsWith(".temp")))
    {
      AppMethodBeat.o(18589);
      return true;
    }
    AppMethodBeat.o(18589);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.f.b.9
 * JD-Core Version:    0.7.0.1
 */