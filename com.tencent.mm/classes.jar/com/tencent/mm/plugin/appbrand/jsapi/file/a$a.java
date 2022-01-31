package com.tencent.mm.plugin.appbrand.jsapi.file;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.by;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.report.quality.a;
import java.io.File;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandRuntimeFileSystemRegistry$TempFileSystemProfilerImpl;", "Lcom/tencent/mm/plugin/appbrand/appstorage/IFileSystemProfiler;", "()V", "reportTempFileAlloc", "", "appId", "", "file", "Ljava/io/File;", "plugin-appbrand-integration_release"})
public final class a$a
  implements p
{
  public final void c(String paramString, File paramFile)
  {
    AppMethodBeat.i(155951);
    if (paramString == null)
    {
      AppMethodBeat.o(155951);
      return;
    }
    paramString = a.EM(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(155951);
      return;
    }
    paramString = b.a(paramString);
    paramString.eB(b.E(paramFile));
    paramString.ake();
    AppMethodBeat.o(155951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.a.a
 * JD-Core Version:    0.7.0.1
 */