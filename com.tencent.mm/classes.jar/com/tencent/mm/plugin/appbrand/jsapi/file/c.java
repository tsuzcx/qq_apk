package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ht;
import com.tencent.mm.g.b.a.ht.a;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.vfs.k;
import d.h.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"createSingleAllocReport", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppFileSystemTempFileSingleAllocStatStruct;", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", "lengthInKB", "", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-appbrand-integration_release"})
public final class c
{
  static final ht a(QualitySessionRuntime paramQualitySessionRuntime)
  {
    AppMethodBeat.i(50511);
    ht localht = new ht();
    localht.qS(paramQualitySessionRuntime.appId);
    localht.nu(paramQualitySessionRuntime.mAf);
    localht.a(ht.a.ja(paramQualitySessionRuntime.myD));
    localht.nv(paramQualitySessionRuntime.apptype);
    AppMethodBeat.o(50511);
    return localht;
  }
  
  static final long x(k paramk)
  {
    AppMethodBeat.i(175168);
    long l = a.K(paramk.length() / 1024.0D);
    AppMethodBeat.o(175168);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.c
 * JD-Core Version:    0.7.0.1
 */