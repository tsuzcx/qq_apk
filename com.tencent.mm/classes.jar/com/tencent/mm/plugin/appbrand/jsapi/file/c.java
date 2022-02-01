package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ew;
import com.tencent.mm.g.b.a.ew.a;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.vfs.e;
import d.h.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"createSingleAllocReport", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppFileSystemTempFileSingleAllocStatStruct;", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", "lengthInKB", "", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-appbrand-integration_release"})
public final class c
{
  static final ew a(QualitySessionRuntime paramQualitySessionRuntime)
  {
    AppMethodBeat.i(50511);
    ew localew = new ew();
    localew.kT(paramQualitySessionRuntime.appId);
    localew.hM(paramQualitySessionRuntime.lty);
    localew.a(ew.a.iH(paramQualitySessionRuntime.lrW));
    localew.hN(paramQualitySessionRuntime.apptype);
    AppMethodBeat.o(50511);
    return localew;
  }
  
  static final long y(e parame)
  {
    AppMethodBeat.i(175168);
    long l = a.J(parame.length() / 1024.0D);
    AppMethodBeat.o(175168);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.c
 * JD-Core Version:    0.7.0.1
 */