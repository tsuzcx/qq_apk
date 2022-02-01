package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.g;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "f", "Lcom/tencent/mm/vfs/VFSFile;", "kotlin.jvm.PlatformType", "accept"})
final class e
  implements g
{
  public static final e mgP;
  
  static
  {
    AppMethodBeat.i(50965);
    mgP = new e();
    AppMethodBeat.o(50965);
  }
  
  public final boolean accept(com.tencent.mm.vfs.e parame)
  {
    AppMethodBeat.i(50964);
    if (parame.exists())
    {
      p.g(parame, "f");
      if (parame.isFile())
      {
        AppMethodBeat.o(50964);
        return true;
      }
    }
    AppMethodBeat.o(50964);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.e
 * JD-Core Version:    0.7.0.1
 */