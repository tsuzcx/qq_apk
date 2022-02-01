package com.tencent.mm.plugin.finder.cgi;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.report.s;
import com.tencent.mm.plugin.finder.storage.f;
import com.tencent.mm.protocal.protobuf.alw;
import com.tencent.mm.protocal.protobuf.alz;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.zd;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;
import java.util.LinkedList;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/FinderBaseRequestFactory;", "", "()V", "create", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "generateClientStatus", "Lcom/tencent/mm/protocal/protobuf/FinderClientStatus;", "plugin-finder_release"})
public final class v
{
  public static final v rRb;
  
  static
  {
    AppMethodBeat.i(201511);
    rRb = new v();
    AppMethodBeat.o(201511);
  }
  
  public static alw a(arn paramarn)
  {
    AppMethodBeat.i(201510);
    alw localalw = new alw();
    Object localObject = f.sIv;
    f.a(localalw);
    localObject = g.ajR();
    p.g(localObject, "MMKernel.storage()");
    localalw.GEk = ((e)localObject).ajA().getInt(am.a.JcH, 0);
    localalw.GEn = new zd();
    if (paramarn != null)
    {
      localalw.scene = paramarn.sch;
      localalw.GEn.rfA = paramarn.rfA;
      localalw.GEn.rfo = paramarn.rfo;
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("sessionId", paramarn.sessionId);
      if (!bu.isNullOrNil(paramarn.extraInfo)) {
        ((JSONObject)localObject).put("extraInfo", paramarn.extraInfo);
      }
      if (!bu.isNullOrNil(paramarn.rfr)) {
        ((JSONObject)localObject).put("enterSourceInfo", paramarn.rfr);
      }
    }
    catch (Exception paramarn)
    {
      label152:
      break label152;
    }
    localalw.GEn.Gre = ((JSONObject)localObject).toString();
    localalw.xsF = ch.aDb();
    AppMethodBeat.o(201510);
    return localalw;
  }
  
  public static alz cXN()
  {
    AppMethodBeat.i(224273);
    alz localalz = new alz();
    localalz.osName = com.tencent.mm.protocal.d.FFE;
    localalz.osVersion = com.tencent.mm.protocal.d.FFF;
    localalz.deviceBrand = com.tencent.mm.protocal.d.FFB;
    localalz.deviceModel = com.tencent.mm.protocal.d.FFC;
    localalz.GEp = az.getNetTypeString(ak.getContext());
    Object localObject = i.syT;
    localalz.netType = i.cFu();
    localalz.GEq = CdnLogic.getRecentAverageSpeed(2);
    localObject = s.sAY;
    localalz.GEr = s.cGa();
    localalz.GEs.add("h264");
    if (com.tencent.mm.modelcontrol.d.pi(4)) {
      localalz.GEs.add("h265");
    }
    AppMethodBeat.o(224273);
    return localalz;
  }
  
  public static alw czz()
  {
    AppMethodBeat.i(201509);
    alw localalw = new alw();
    Object localObject = f.sIv;
    f.a(localalw);
    localObject = g.ajR();
    p.g(localObject, "MMKernel.storage()");
    localalw.GEk = ((e)localObject).ajA().getInt(am.a.JcH, 0);
    AppMethodBeat.o(201509);
    return localalw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.v
 * JD-Core Version:    0.7.0.1
 */