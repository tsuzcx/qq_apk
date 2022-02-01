package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.am.b;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.autogen.mmdata.rpt.tm;
import com.tencent.mm.autogen.mmdata.rpt.tm.b;
import com.tencent.mm.plugin.appbrand.launching.ay;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.glq;
import com.tencent.mm.protocal.protobuf.glr;
import com.tencent.mm.protocal.protobuf.gls;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public final class d
  extends b<glr>
{
  final String appId;
  final String eoP;
  final int euz;
  final c rr;
  public volatile boolean tbv;
  public volatile HashMap<String, AppRuntimeApiPermissionBundle> tdd;
  private final ay tdf;
  private final tm tdg;
  
  public d(String paramString1, int paramInt, List<g> paramList, boolean paramBoolean, String paramString2, QualitySession paramQualitySession, ay paramay, aeo paramaeo)
  {
    AppMethodBeat.i(321110);
    this.tbv = false;
    this.tdd = new HashMap();
    this.appId = paramString1;
    this.euz = paramInt;
    this.eoP = paramString2;
    this.tdf = paramay;
    this.tdg = com.tencent.mm.plugin.appbrand.report.quality.f.f(paramQualitySession);
    Object localObject = this.tdg;
    if (paramBoolean) {}
    for (paramay = tm.b.jDz;; paramay = tm.b.jDA)
    {
      ((tm)localObject).jDu = paramay;
      this.tdg.iVU = com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType();
      paramay = new glq();
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        g localg = (g)((Iterator)localObject).next();
        gls localgls = new gls();
        localgls.appid = localg.appId;
        localgls.xlL = localg.appType;
        paramay.acfK.add(localgls);
      }
    }
    paramay.YMR = ((aeo)Objects.requireNonNull(paramaeo));
    localObject = new c.a();
    ((c.a)localObject).funcId = 3827;
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaattr/wxajsapiinfo";
    ((c.a)localObject).otE = paramay;
    ((c.a)localObject).otF = new glr();
    paramay = ((c.a)localObject).bEF();
    this.rr = paramay;
    c(paramay);
    Log.i("MicroMsg.AppBrand.CgiWxaJsApiInfo", "<init> appId:%s, versionType:%d, appIdList:%s, sync:%b, sessionId:%s, instanceId:%s, source:%s", new Object[] { paramString1, Integer.valueOf(paramInt), dy(paramList), Boolean.valueOf(paramBoolean), paramString2, paramQualitySession.eup, a.b(paramaeo) });
    AppMethodBeat.o(321110);
  }
  
  private static String dy(List<g> paramList)
  {
    AppMethodBeat.i(321118);
    StringBuilder localStringBuilder = new StringBuilder("[");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      g localg = (g)paramList.next();
      localStringBuilder.append("{appId:").append(localg.appId).append(", appType:").append(localg.appType).append("}");
    }
    localStringBuilder.append("]");
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(321118);
    return paramList;
  }
  
  public final com.tencent.mm.cp.f<b.a<glr>> bFJ()
  {
    try
    {
      AppMethodBeat.i(321135);
      long l = Util.nowMilliSecond();
      this.tdg.gs(l);
      com.tencent.mm.cp.f localf = super.bFJ();
      AppMethodBeat.o(321135);
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.d
 * JD-Core Version:    0.7.0.1
 */