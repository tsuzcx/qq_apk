package com.tencent.mm.plugin.finder.cgi;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.plugin.finder.video.reporter.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.aas;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.apc;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/FinderBaseRequestFactory;", "", "()V", "create", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "reportData", "Lcom/tencent/mm/protocal/protobuf/MvReportData;", "generateClientStatus", "Lcom/tencent/mm/protocal/protobuf/FinderClientStatus;", "plugin-finder_release"})
public final class am
{
  public static final am tuw;
  
  static
  {
    AppMethodBeat.i(242326);
    tuw = new am();
    AppMethodBeat.o(242326);
  }
  
  public static aov a(bbn parambbn)
  {
    AppMethodBeat.i(242323);
    aov localaov = new aov();
    Object localObject = i.vDq;
    i.a(localaov);
    localObject = g.aAh();
    p.g(localObject, "MMKernel.storage()");
    localaov.LAQ = ((com.tencent.mm.kernel.e)localObject).azQ().getInt(ar.a.OlL, 0);
    localaov.LAT = new aas();
    if (parambbn != null)
    {
      localaov.scene = parambbn.tCE;
      localaov.LAT.sGQ = parambbn.sGQ;
      localaov.LAT.sGE = parambbn.sGE;
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("sessionId", parambbn.sessionId);
      if (!Util.isNullOrNil(parambbn.extraInfo)) {
        ((JSONObject)localObject).put("extraInfo", parambbn.extraInfo);
      }
      if (!Util.isNullOrNil(parambbn.sGH)) {
        ((JSONObject)localObject).put("enterSourceInfo", parambbn.sGH);
      }
    }
    catch (Exception parambbn)
    {
      label152:
      break label152;
    }
    localaov.LAT.Lma = ((JSONObject)localObject).toString();
    localaov.ulj = cl.aWz();
    AppMethodBeat.o(242323);
    return localaov;
  }
  
  public static aov a(cst paramcst)
  {
    AppMethodBeat.i(242324);
    aov localaov = new aov();
    if (paramcst != null)
    {
      localaov.scene = paramcst.MxI;
      localaov.ulj = cl.aWz();
    }
    AppMethodBeat.o(242324);
    return localaov;
  }
  
  public static aov cXY()
  {
    AppMethodBeat.i(242322);
    aov localaov = new aov();
    Object localObject = i.vDq;
    i.a(localaov);
    localObject = g.aAh();
    p.g(localObject, "MMKernel.storage()");
    localaov.LAQ = ((com.tencent.mm.kernel.e)localObject).azQ().getInt(ar.a.OlL, 0);
    AppMethodBeat.o(242322);
    return localaov;
  }
  
  public static apc cXZ()
  {
    AppMethodBeat.i(242325);
    apc localapc = new apc();
    localapc.osName = d.KyL;
    localapc.osVersion = d.KyM;
    localapc.deviceBrand = d.KyI;
    localapc.deviceModel = d.KyJ;
    localapc.LBe = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
    Object localObject = k.vfA;
    localapc.netType = k.dod();
    localapc.LBf = CdnLogic.getRecentAverageSpeed(2);
    localObject = b.whK;
    localapc.LBg = b.dFY();
    localapc.LBh.add("h264");
    if (com.tencent.mm.modelcontrol.e.sX(4)) {
      localapc.LBh.add("h265");
    }
    AppMethodBeat.o(242325);
    return localapc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.am
 * JD-Core Version:    0.7.0.1
 */