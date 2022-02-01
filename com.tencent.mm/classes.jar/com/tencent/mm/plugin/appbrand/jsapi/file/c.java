package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.om;
import com.tencent.mm.f.b.a.om.a;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.vfs.q;
import kotlin.h.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"createSingleAllocReport", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppFileSystemTempFileSingleAllocStatStruct;", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", "lengthInKB", "", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-appbrand-integration_release"})
public final class c
{
  static final om a(QualitySessionRuntime paramQualitySessionRuntime)
  {
    AppMethodBeat.i(50511);
    om localom = new om();
    localom.FB(paramQualitySessionRuntime.appId);
    localom.AZ(paramQualitySessionRuntime.qNx);
    localom.a(om.a.on(paramQualitySessionRuntime.qLQ));
    localom.Ba(paramQualitySessionRuntime.apptype);
    AppMethodBeat.o(50511);
    return localom;
  }
  
  static final long v(q paramq)
  {
    AppMethodBeat.i(175168);
    long l = a.N(paramq.length() / 1024.0D);
    AppMethodBeat.o(175168);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.c
 * JD-Core Version:    0.7.0.1
 */