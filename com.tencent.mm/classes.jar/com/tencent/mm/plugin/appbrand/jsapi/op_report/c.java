package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.protocal.protobuf.bxp;
import com.tencent.mm.protocal.protobuf.cvs;
import com.tencent.mm.protocal.protobuf.cvt;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/op_report/OpReportUtil;", "", "()V", "getReportIdOrThrows", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "matchNetScene", "", "requestAppID", "", "plugin-appbrand-integration_release"})
public final class c
{
  public static final c ler;
  
  static
  {
    AppMethodBeat.i(50632);
    ler = new c();
    AppMethodBeat.o(50632);
  }
  
  public static final boolean b(n paramn, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(50630);
    p.h(paramString, "requestAppID");
    Object localObject1;
    if (paramn != null)
    {
      paramn = paramn.getReqResp();
      localObject1 = paramn;
      if (!(paramn instanceof b)) {
        localObject1 = null;
      }
      paramn = (b)localObject1;
      if (paramn == null) {
        break label106;
      }
    }
    label106:
    for (paramn = paramn.aEU();; paramn = null)
    {
      localObject1 = paramn;
      if (!(paramn instanceof cvs)) {
        localObject1 = null;
      }
      localObject1 = (cvs)localObject1;
      paramn = localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((cvs)localObject1).HGD;
        paramn = localObject2;
        if (localObject1 != null) {
          paramn = ((bxp)localObject1).dwb;
        }
      }
      boolean bool = p.i(paramn, paramString);
      AppMethodBeat.o(50630);
      return bool;
      paramn = null;
      break;
    }
  }
  
  public static final int e(n paramn)
  {
    AppMethodBeat.i(50631);
    n localn;
    if (paramn != null)
    {
      paramn = paramn.getReqResp();
      localn = paramn;
      if (!(paramn instanceof b)) {
        localn = null;
      }
      paramn = (b)localn;
      if (paramn == null) {
        break label76;
      }
    }
    label76:
    for (paramn = paramn.aEV();; paramn = null)
    {
      localn = paramn;
      if (!(paramn instanceof cvt)) {
        localn = null;
      }
      paramn = (cvt)localn;
      if (paramn == null) {
        break label81;
      }
      int i = paramn.HGE;
      AppMethodBeat.o(50631);
      return i;
      paramn = null;
      break;
    }
    label81:
    paramn = (Throwable)new IllegalArgumentException();
    AppMethodBeat.o(50631);
    throw paramn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.op_report.c
 * JD-Core Version:    0.7.0.1
 */