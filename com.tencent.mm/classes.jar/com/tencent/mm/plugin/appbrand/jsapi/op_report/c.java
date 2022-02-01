package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.n;
import com.tencent.mm.protocal.protobuf.bns;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.protocal.protobuf.ckn;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/op_report/OpReportUtil;", "", "()V", "getReportIdOrThrows", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "matchNetScene", "", "requestAppID", "", "plugin-appbrand-integration_release"})
public final class c
{
  public static final c kdL;
  
  static
  {
    AppMethodBeat.i(50632);
    kdL = new c();
    AppMethodBeat.o(50632);
  }
  
  public static final boolean b(n paramn, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(50630);
    k.h(paramString, "requestAppID");
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
    for (paramn = paramn.auL();; paramn = null)
    {
      localObject1 = paramn;
      if (!(paramn instanceof ckm)) {
        localObject1 = null;
      }
      localObject1 = (ckm)localObject1;
      paramn = localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((ckm)localObject1).EfQ;
        paramn = localObject2;
        if (localObject1 != null) {
          paramn = ((bns)localObject1).dlB;
        }
      }
      boolean bool = k.g(paramn, paramString);
      AppMethodBeat.o(50630);
      return bool;
      paramn = null;
      break;
    }
  }
  
  public static final int f(n paramn)
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
    for (paramn = paramn.auM();; paramn = null)
    {
      localn = paramn;
      if (!(paramn instanceof ckn)) {
        localn = null;
      }
      paramn = (ckn)localn;
      if (paramn == null) {
        break label81;
      }
      int i = paramn.EfR;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.op_report.c
 * JD-Core Version:    0.7.0.1
 */