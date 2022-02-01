package com.tencent.mm.plugin.finder.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;", "", "(Ljava/lang/String;I)V", "LOADING", "PENDING", "WAITING", "plugin-finder_release"})
public enum c$b
{
  static
  {
    AppMethodBeat.i(203519);
    b localb1 = new b("LOADING", 0);
    stX = localb1;
    b localb2 = new b("PENDING", 1);
    stY = localb2;
    b localb3 = new b("WAITING", 2);
    stZ = localb3;
    sua = new b[] { localb1, localb2, localb3 };
    AppMethodBeat.o(203519);
  }
  
  private c$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.c.b
 * JD-Core Version:    0.7.0.1
 */