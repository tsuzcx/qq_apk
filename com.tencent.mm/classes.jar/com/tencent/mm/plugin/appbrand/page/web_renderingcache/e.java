package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.q;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "f", "Lcom/tencent/mm/vfs/VFSFile;", "accept"})
final class e
  implements q
{
  public static final e nwm;
  
  static
  {
    AppMethodBeat.i(50965);
    nwm = new e();
    AppMethodBeat.o(50965);
  }
  
  public final boolean accept(o paramo)
  {
    AppMethodBeat.i(50964);
    p.h(paramo, "f");
    if ((paramo.exists()) && (paramo.isFile()))
    {
      AppMethodBeat.o(50964);
      return true;
    }
    AppMethodBeat.o(50964);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.e
 * JD-Core Version:    0.7.0.1
 */