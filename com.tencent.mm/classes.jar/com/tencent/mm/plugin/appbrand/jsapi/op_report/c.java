package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.clh;
import com.tencent.mm.protocal.protobuf.dol;
import com.tencent.mm.protocal.protobuf.dom;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/op_report/OpReportUtil;", "", "()V", "getReportIdOrThrows", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "matchNetScene", "", "requestAppID", "", "plugin-appbrand-integration_release"})
public final class c
{
  public static final c mjJ;
  
  static
  {
    AppMethodBeat.i(50632);
    mjJ = new c();
    AppMethodBeat.o(50632);
  }
  
  public static final boolean b(q paramq, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(50630);
    p.h(paramString, "requestAppID");
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
    for (paramq = paramq.aYJ();; paramq = null)
    {
      localObject1 = paramq;
      if (!(paramq instanceof dol)) {
        localObject1 = null;
      }
      localObject1 = (dol)localObject1;
      paramq = localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((dol)localObject1).MRN;
        paramq = localObject2;
        if (localObject1 != null) {
          paramq = ((clh)localObject1).dNI;
        }
      }
      boolean bool = p.j(paramq, paramString);
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
    for (paramq = paramq.aYK();; paramq = null)
    {
      localq = paramq;
      if (!(paramq instanceof dom)) {
        localq = null;
      }
      paramq = (dom)localq;
      if (paramq == null) {
        break label81;
      }
      int i = paramq.MRO;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.op_report.c
 * JD-Core Version:    0.7.0.1
 */