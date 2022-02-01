package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.m;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "f", "Lcom/tencent/mm/vfs/VFSFile;", "kotlin.jvm.PlatformType", "accept"})
final class e
  implements m
{
  public static final e mlO;
  
  static
  {
    AppMethodBeat.i(50965);
    mlO = new e();
    AppMethodBeat.o(50965);
  }
  
  public final boolean accept(k paramk)
  {
    AppMethodBeat.i(50964);
    if (paramk.exists())
    {
      p.g(paramk, "f");
      if (paramk.isFile())
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