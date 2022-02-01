package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.vfs.i;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
final class a$c
  implements Runnable
{
  public static final c nVA;
  
  static
  {
    AppMethodBeat.i(6445);
    nVA = new c();
    AppMethodBeat.o(6445);
  }
  
  public final void run()
  {
    AppMethodBeat.i(6444);
    i.deleteDir(d.dcT());
    AppMethodBeat.o(6444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a.c
 * JD-Core Version:    0.7.0.1
 */