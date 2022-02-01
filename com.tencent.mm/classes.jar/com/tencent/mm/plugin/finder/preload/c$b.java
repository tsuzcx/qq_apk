package com.tencent.mm.plugin.finder.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;", "", "(Ljava/lang/String;I)V", "LOADING", "PENDING", "WAITING", "plugin-finder_release"})
public enum c$b
{
  static
  {
    AppMethodBeat.i(202613);
    b localb1 = new b("LOADING", 0);
    rvz = localb1;
    b localb2 = new b("PENDING", 1);
    rvA = localb2;
    b localb3 = new b("WAITING", 2);
    rvB = localb3;
    rvC = new b[] { localb1, localb2, localb3 };
    AppMethodBeat.o(202613);
  }
  
  private c$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.c.b
 * JD-Core Version:    0.7.0.1
 */