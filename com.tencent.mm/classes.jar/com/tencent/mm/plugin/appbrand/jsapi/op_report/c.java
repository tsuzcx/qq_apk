package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.protocal.protobuf.bbr;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.protocal.protobuf.buw;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/op_report/OpReportUtil;", "", "()V", "getReportIdOrThrows", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "matchNetScene", "", "requestAppID", "", "plugin-appbrand-integration_release"})
public final class c
{
  public static final c hVr;
  
  static
  {
    AppMethodBeat.i(134686);
    hVr = new c();
    AppMethodBeat.o(134686);
  }
  
  public static final boolean b(m paramm, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(134684);
    j.q(paramString, "requestAppID");
    Object localObject1;
    if (paramm != null)
    {
      paramm = paramm.getReqResp();
      localObject1 = paramm;
      if (!(paramm instanceof b)) {
        localObject1 = null;
      }
      paramm = (b)localObject1;
      if (paramm == null) {
        break label106;
      }
    }
    label106:
    for (paramm = paramm.adm();; paramm = null)
    {
      localObject1 = paramm;
      if (!(paramm instanceof buv)) {
        localObject1 = null;
      }
      localObject1 = (buv)localObject1;
      paramm = localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((buv)localObject1).xIB;
        paramm = localObject2;
        if (localObject1 != null) {
          paramm = ((bbr)localObject1).cwc;
        }
      }
      boolean bool = j.e(paramm, paramString);
      AppMethodBeat.o(134684);
      return bool;
      paramm = null;
      break;
    }
  }
  
  public static final int f(m paramm)
  {
    AppMethodBeat.i(134685);
    m localm;
    if (paramm != null)
    {
      paramm = paramm.getReqResp();
      localm = paramm;
      if (!(paramm instanceof b)) {
        localm = null;
      }
      paramm = (b)localm;
      if (paramm == null) {
        break label76;
      }
    }
    label76:
    for (paramm = paramm.adn();; paramm = null)
    {
      localm = paramm;
      if (!(paramm instanceof buw)) {
        localm = null;
      }
      paramm = (buw)localm;
      if (paramm == null) {
        break label81;
      }
      int i = paramm.xIC;
      AppMethodBeat.o(134685);
      return i;
      paramm = null;
      break;
    }
    label81:
    paramm = (Throwable)new IllegalArgumentException();
    AppMethodBeat.o(134685);
    throw paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.op_report.c
 * JD-Core Version:    0.7.0.1
 */