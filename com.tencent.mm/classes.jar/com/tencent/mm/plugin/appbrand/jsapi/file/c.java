package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hr;
import com.tencent.mm.g.b.a.hr.a;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.vfs.e;
import d.h.a;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"createSingleAllocReport", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppFileSystemTempFileSingleAllocStatStruct;", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", "lengthInKB", "", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-appbrand-integration_release"})
public final class c
{
  static final hr a(QualitySessionRuntime paramQualitySessionRuntime)
  {
    AppMethodBeat.i(50511);
    hr localhr = new hr();
    localhr.qx(paramQualitySessionRuntime.appId);
    localhr.ni(paramQualitySessionRuntime.mvi);
    localhr.a(hr.a.iY(paramQualitySessionRuntime.mtG));
    localhr.nj(paramQualitySessionRuntime.apptype);
    AppMethodBeat.o(50511);
    return localhr;
  }
  
  static final long x(e parame)
  {
    AppMethodBeat.i(175168);
    long l = a.K(parame.length() / 1024.0D);
    AppMethodBeat.o(175168);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.c
 * JD-Core Version:    0.7.0.1
 */