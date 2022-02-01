package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.sf;
import com.tencent.mm.autogen.mmdata.rpt.sf.a;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.vfs.u;
import kotlin.Metadata;
import kotlin.h.a;

@Metadata(d1={""}, d2={"createSingleAllocReport", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppFileSystemTempFileSingleAllocStatStruct;", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", "lengthInKB", "", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-appbrand-integration_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  static final sf a(QualitySessionRuntime paramQualitySessionRuntime)
  {
    AppMethodBeat.i(50511);
    sf localsf = new sf();
    localsf.yS(paramQualitySessionRuntime.appId);
    localsf.ind = paramQualitySessionRuntime.tSh;
    localsf.jxI = sf.a.oD(paramQualitySessionRuntime.tQx);
    localsf.jax = paramQualitySessionRuntime.apptype;
    AppMethodBeat.o(50511);
    return localsf;
  }
  
  static final long w(u paramu)
  {
    AppMethodBeat.i(175168);
    long l = a.ai(paramu.length() / 1024.0D);
    AppMethodBeat.o(175168);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.c
 * JD-Core Version:    0.7.0.1
 */