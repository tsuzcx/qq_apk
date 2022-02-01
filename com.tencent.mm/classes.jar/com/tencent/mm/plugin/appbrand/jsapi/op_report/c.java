package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.protocal.protobuf.dlc;
import com.tencent.mm.protocal.protobuf.erj;
import com.tencent.mm.protocal.protobuf.erk;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/op_report/OpReportUtil;", "", "()V", "getReportIdOrThrows", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "matchNetScene", "", "requestAppID", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c sne;
  
  static
  {
    AppMethodBeat.i(50632);
    sne = new c();
    AppMethodBeat.o(50632);
  }
  
  public static final boolean b(p paramp, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(50630);
    s.u(paramString, "requestAppID");
    if (paramp == null)
    {
      paramp = null;
      if (!(paramp instanceof com.tencent.mm.am.c)) {
        break label76;
      }
      paramp = (com.tencent.mm.am.c)paramp;
      label31:
      if (paramp != null) {
        break label81;
      }
      paramp = null;
      label37:
      if (!(paramp instanceof erj)) {
        break label92;
      }
      paramp = (erj)paramp;
      label49:
      if (paramp != null) {
        break label97;
      }
      paramp = localObject;
    }
    for (;;)
    {
      boolean bool = s.p(paramp, paramString);
      AppMethodBeat.o(50630);
      return bool;
      paramp = paramp.getReqResp();
      break;
      label76:
      paramp = null;
      break label31;
      label81:
      paramp = c.b.b(paramp.otB);
      break label37;
      label92:
      paramp = null;
      break label49;
      label97:
      dlc localdlc = paramp.abvi;
      paramp = localObject;
      if (localdlc != null) {
        paramp = localdlc.appid;
      }
    }
  }
  
  public static final int e(p paramp)
  {
    Object localObject = null;
    AppMethodBeat.i(50631);
    if (paramp == null)
    {
      paramp = null;
      if (!(paramp instanceof com.tencent.mm.am.c)) {
        break label76;
      }
      paramp = (com.tencent.mm.am.c)paramp;
      label25:
      if (paramp != null) {
        break label81;
      }
      paramp = null;
      label31:
      if (!(paramp instanceof erk)) {
        break label92;
      }
      paramp = (erk)paramp;
      label43:
      if (paramp != null) {
        break label97;
      }
    }
    label76:
    label81:
    label92:
    label97:
    for (paramp = localObject;; paramp = Integer.valueOf(paramp.abvj))
    {
      if (paramp != null) {
        break label108;
      }
      paramp = new IllegalArgumentException();
      AppMethodBeat.o(50631);
      throw paramp;
      paramp = paramp.getReqResp();
      break;
      paramp = null;
      break label25;
      paramp = c.c.b(paramp.otC);
      break label31;
      paramp = null;
      break label43;
    }
    label108:
    int i = paramp.intValue();
    AppMethodBeat.o(50631);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.op_report.c
 * JD-Core Version:    0.7.0.1
 */