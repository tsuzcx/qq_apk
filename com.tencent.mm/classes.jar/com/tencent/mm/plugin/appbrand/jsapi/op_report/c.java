package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.n;
import com.tencent.mm.protocal.protobuf.bwv;
import com.tencent.mm.protocal.protobuf.cuy;
import com.tencent.mm.protocal.protobuf.cuz;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/op_report/OpReportUtil;", "", "()V", "getReportIdOrThrows", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "matchNetScene", "", "requestAppID", "", "plugin-appbrand-integration_release"})
public final class c
{
  public static final c laI;
  
  static
  {
    AppMethodBeat.i(50632);
    laI = new c();
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
    for (paramn = paramn.aEE();; paramn = null)
    {
      localObject1 = paramn;
      if (!(paramn instanceof cuy)) {
        localObject1 = null;
      }
      localObject1 = (cuy)localObject1;
      paramn = localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((cuy)localObject1).Hnd;
        paramn = localObject2;
        if (localObject1 != null) {
          paramn = ((bwv)localObject1).duW;
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
    for (paramn = paramn.aEF();; paramn = null)
    {
      localn = paramn;
      if (!(paramn instanceof cuz)) {
        localn = null;
      }
      paramn = (cuz)localn;
      if (paramn == null) {
        break label81;
      }
      int i = paramn.Hne;
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