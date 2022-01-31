package com.tencent.mm.plugin.appbrand.jsapi.file;

import a.g.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.by;
import com.tencent.mm.g.b.a.by.a;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import java.io.File;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"createSingleAllocReport", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppFileSystemTempFileSingleAllocStatStruct;", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", "lengthInKB", "", "Ljava/io/File;", "plugin-appbrand-integration_release"})
public final class b
{
  static final long E(File paramFile)
  {
    AppMethodBeat.i(155955);
    long l = a.H(paramFile.length() / 1024.0D);
    AppMethodBeat.o(155955);
    return l;
  }
  
  static final by a(QualitySessionRuntime paramQualitySessionRuntime)
  {
    AppMethodBeat.i(155954);
    by localby = new by();
    localby.gY(paramQualitySessionRuntime.appId);
    localby.ez(paramQualitySessionRuntime.iIG);
    localby.a(by.a.gM(paramQualitySessionRuntime.iIF));
    localby.eA(paramQualitySessionRuntime.apptype);
    AppMethodBeat.o(155954);
    return localby;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.b
 * JD-Core Version:    0.7.0.1
 */