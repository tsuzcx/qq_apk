package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.lo;
import com.tencent.mm.g.b.a.lo.a;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.vfs.o;
import kotlin.h.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"createSingleAllocReport", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppFileSystemTempFileSingleAllocStatStruct;", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", "lengthInKB", "", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-appbrand-integration_release"})
public final class c
{
  static final lo a(QualitySessionRuntime paramQualitySessionRuntime)
  {
    AppMethodBeat.i(50511);
    lo locallo = new lo();
    locallo.yV(paramQualitySessionRuntime.appId);
    locallo.ve(paramQualitySessionRuntime.nLk);
    locallo.a(lo.a.mc(paramQualitySessionRuntime.nJE));
    locallo.vf(paramQualitySessionRuntime.apptype);
    AppMethodBeat.o(50511);
    return locallo;
  }
  
  static final long w(o paramo)
  {
    AppMethodBeat.i(175168);
    long l = a.L(paramo.length() / 1024.0D);
    AppMethodBeat.o(175168);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.c
 * JD-Core Version:    0.7.0.1
 */