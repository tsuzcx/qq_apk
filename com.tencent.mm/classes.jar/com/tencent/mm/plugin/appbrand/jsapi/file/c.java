package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.go;
import com.tencent.mm.g.b.a.go.a;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.vfs.e;
import d.h.a;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"createSingleAllocReport", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppFileSystemTempFileSingleAllocStatStruct;", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", "lengthInKB", "", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-appbrand-integration_release"})
public final class c
{
  static final go a(QualitySessionRuntime paramQualitySessionRuntime)
  {
    AppMethodBeat.i(50511);
    go localgo = new go();
    localgo.nY(paramQualitySessionRuntime.appId);
    localgo.lo(paramQualitySessionRuntime.lVs);
    localgo.a(go.a.iF(paramQualitySessionRuntime.lTR));
    localgo.lp(paramQualitySessionRuntime.apptype);
    AppMethodBeat.o(50511);
    return localgo;
  }
  
  static final long x(e parame)
  {
    AppMethodBeat.i(175168);
    long l = a.J(parame.length() / 1024.0D);
    AppMethodBeat.o(175168);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.c
 * JD-Core Version:    0.7.0.1
 */