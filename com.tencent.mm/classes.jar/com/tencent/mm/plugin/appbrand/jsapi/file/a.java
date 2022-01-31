package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bx;
import com.tencent.mm.g.b.a.bx.a;
import com.tencent.mm.g.b.a.by;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import java.io.File;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandRuntimeFileSystemRegistry;", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/LuggageFileSystemRegistryWC;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "config", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandStorageConfig;", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;Lcom/tencent/mm/plugin/appbrand/jsapi/file/AppBrandStorageConfig;)V", "createTempFileFrom", "Lcom/tencent/mm/plugin/appbrand/appstorage/FileOpResult;", "scrFile", "Ljava/io/File;", "suffix", "", "deleteSrc", "", "pResultPath", "Lcom/tencent/mm/plugin/appbrand/util/Pointer;", "TempFileSystemProfilerImpl", "plugin-appbrand-integration_release"})
public final class a
  extends an
{
  private final com.tencent.luggage.sdk.d.b hLN;
  private final c hLO;
  
  public a(com.tencent.luggage.sdk.d.b paramb, c paramc)
  {
    super(paramb, paramc);
    AppMethodBeat.i(155953);
    this.hLN = paramb;
    this.hLO = paramc;
    paramc = (com.tencent.mm.plugin.appbrand.appstorage.l)Y(com.tencent.mm.plugin.appbrand.appstorage.l.class);
    if (paramc != null)
    {
      paramb = com.tencent.mm.plugin.appbrand.report.quality.a.EM(this.hLN.getAppId());
      if (paramb != null)
      {
        a.f.b.j.p(paramc, "ffs");
        long l = k.z(new File(paramc.getRootPath()));
        paramc = new bx();
        paramc.gX(this.hLN.getAppId());
        paramc.ew(paramb.iIG);
        paramc.a(bx.a.gL(paramb.iIF));
        paramc.ex(paramb.apptype);
        paramc.ey(a.g.a.H(l / 1024.0D));
        paramc.ake();
        AppMethodBeat.o(155953);
        return;
      }
    }
    AppMethodBeat.o(155953);
  }
  
  public final com.tencent.mm.plugin.appbrand.appstorage.j a(File paramFile, String paramString, boolean paramBoolean, com.tencent.mm.plugin.appbrand.s.j<String> paramj)
  {
    AppMethodBeat.i(155952);
    if (paramFile != null) {}
    for (long l = b.E(paramFile);; l = -1L)
    {
      paramFile = super.a(paramFile, paramString, paramBoolean, paramj);
      if (paramFile == com.tencent.mm.plugin.appbrand.appstorage.j.gZA)
      {
        paramString = com.tencent.mm.plugin.appbrand.report.quality.a.EM(this.hLN.getAppId());
        if (paramString != null)
        {
          paramString = b.a(paramString);
          paramString.eB(l);
          paramString.ake();
        }
      }
      a.f.b.j.p(paramFile, "super.createTempFileFrom…}\n            }\n        }");
      AppMethodBeat.o(155952);
      return paramFile;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.a
 * JD-Core Version:    0.7.0.1
 */