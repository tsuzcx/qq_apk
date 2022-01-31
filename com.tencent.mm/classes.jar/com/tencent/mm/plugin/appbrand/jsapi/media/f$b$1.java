package com.tencent.mm.plugin.appbrand.jsapi.media;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.f;
import java.io.File;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Ljava/io/File;", "selected", "kotlin.jvm.PlatformType", "call"})
final class f$b$1<_Ret, _Var>
  implements a<_Ret, _Var>
{
  f$b$1(f.b paramb) {}
  
  private File G(File paramFile)
  {
    AppMethodBeat.i(143816);
    if (!this.hRR.hRP.isRunning())
    {
      f.dQn().cK(new Exception("component not running"));
      AppMethodBeat.o(143816);
      return null;
    }
    if (this.hRR.hRQ) {
      try
      {
        j.p(paramFile, "selected");
        paramFile = new File(n.Cu(paramFile.getAbsolutePath()));
        AppMethodBeat.o(143816);
        return paramFile;
      }
      catch (Exception paramFile)
      {
        f.dQn().cK(paramFile);
        AppMethodBeat.o(143816);
        return null;
      }
    }
    AppMethodBeat.o(143816);
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.f.b.1
 * JD-Core Version:    0.7.0.1
 */