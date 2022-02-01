package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.q;
import com.tencent.mm.protocal.protobuf.cua;
import com.tencent.mm.protocal.protobuf.dyf;
import com.tencent.mm.protocal.protobuf.dyg;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/op_report/OpReportUtil;", "", "()V", "getReportIdOrThrows", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "matchNetScene", "", "requestAppID", "", "plugin-appbrand-integration_release"})
public final class c
{
  public static final c phL;
  
  static
  {
    AppMethodBeat.i(50632);
    phL = new c();
    AppMethodBeat.o(50632);
  }
  
  public static final boolean b(q paramq, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(50630);
    p.k(paramString, "requestAppID");
    Object localObject1;
    if (paramq != null)
    {
      paramq = paramq.getReqResp();
      localObject1 = paramq;
      if (!(paramq instanceof d)) {
        localObject1 = null;
      }
      paramq = (d)localObject1;
      if (paramq == null) {
        break label106;
      }
    }
    label106:
    for (paramq = paramq.bhX();; paramq = null)
    {
      localObject1 = paramq;
      if (!(paramq instanceof dyf)) {
        localObject1 = null;
      }
      localObject1 = (dyf)localObject1;
      paramq = localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((dyf)localObject1).UdU;
        paramq = localObject2;
        if (localObject1 != null) {
          paramq = ((cua)localObject1).appid;
        }
      }
      boolean bool = p.h(paramq, paramString);
      AppMethodBeat.o(50630);
      return bool;
      paramq = null;
      break;
    }
  }
  
  public static final int e(q paramq)
  {
    AppMethodBeat.i(50631);
    q localq;
    if (paramq != null)
    {
      paramq = paramq.getReqResp();
      localq = paramq;
      if (!(paramq instanceof d)) {
        localq = null;
      }
      paramq = (d)localq;
      if (paramq == null) {
        break label76;
      }
    }
    label76:
    for (paramq = paramq.bhY();; paramq = null)
    {
      localq = paramq;
      if (!(paramq instanceof dyg)) {
        localq = null;
      }
      paramq = (dyg)localq;
      if (paramq == null) {
        break label81;
      }
      int i = paramq.UdV;
      AppMethodBeat.o(50631);
      return i;
      paramq = null;
      break;
    }
    label81:
    paramq = (Throwable)new IllegalArgumentException();
    AppMethodBeat.o(50631);
    throw paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.op_report.c
 * JD-Core Version:    0.7.0.1
 */