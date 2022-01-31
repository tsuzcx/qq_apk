package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$1
  implements Runnable
{
  c$1(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(21223);
    Object localObject = c.a(this.ncE);
    if (((d)localObject).ncL != null)
    {
      localObject = ((d)localObject).ncL;
      if (((f)localObject).dirty)
      {
        ((f)localObject).dirty = false;
        ((f)localObject).bDZ();
        ((f)localObject).bEa();
        ((f)localObject).wH(-1);
        ((f)localObject).bEc();
      }
    }
    AppMethodBeat.o(21223);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(21224);
    String str = super.toString() + "|tryStartDocode";
    AppMethodBeat.o(21224);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.c.1
 * JD-Core Version:    0.7.0.1
 */