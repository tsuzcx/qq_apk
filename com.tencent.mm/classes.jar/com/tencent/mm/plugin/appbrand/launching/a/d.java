package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.an.c;
import com.tencent.mm.an.c.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cw.f;
import com.tencent.mm.f.b.a.pt;
import com.tencent.mm.f.b.a.pt.b;
import com.tencent.mm.plugin.appbrand.launching.aw;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.protocal.protobuf.fop;
import com.tencent.mm.protocal.protobuf.foq;
import com.tencent.mm.protocal.protobuf.for;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public final class d
  extends c<foq>
{
  final String appId;
  final int cBU;
  final String cwP;
  public volatile boolean pWG;
  public volatile HashMap<String, AppRuntimeApiPermissionBundle> pYm;
  private final aw pYo;
  private final pt pYp;
  final com.tencent.mm.an.d rr;
  
  public d(String paramString1, int paramInt, List<g> paramList, boolean paramBoolean, String paramString2, QualitySession paramQualitySession, aw paramaw, ack paramack)
  {
    AppMethodBeat.i(275089);
    this.pWG = false;
    this.pYm = new HashMap();
    this.appId = paramString1;
    this.cBU = paramInt;
    this.cwP = paramString2;
    this.pYo = paramaw;
    this.pYp = com.tencent.mm.plugin.appbrand.report.quality.g.e(paramQualitySession);
    Object localObject = this.pYp;
    if (paramBoolean) {}
    for (paramaw = pt.b.hhH;; paramaw = pt.b.hhI)
    {
      ((pt)localObject).hhC = paramaw;
      this.pYp.gHC = com.tencent.mm.plugin.appbrand.report.quality.g.getNetworkType();
      paramaw = new fop();
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        g localg = (g)((Iterator)localObject).next();
        for localfor = new for();
        localfor.appid = localg.appId;
        localfor.ufE = localg.appType;
        paramaw.ULx.add(localfor);
      }
    }
    paramaw.RPD = ((ack)Objects.requireNonNull(paramack));
    localObject = new d.a();
    ((d.a)localObject).funcId = 3827;
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaattr/wxajsapiinfo";
    ((d.a)localObject).lBU = paramaw;
    ((d.a)localObject).lBV = new foq();
    paramaw = ((d.a)localObject).bgN();
    this.rr = paramaw;
    c(paramaw);
    Log.i("MicroMsg.AppBrand.CgiWxaJsApiInfo", "<init> appId:%s, versionType:%d, appIdList:%s, sync:%b, sessionId:%s, instanceId:%s, source:%s", new Object[] { paramString1, Integer.valueOf(paramInt), bM(paramList), Boolean.valueOf(paramBoolean), paramString2, paramQualitySession.cBH, a.a(paramack) });
    AppMethodBeat.o(275089);
  }
  
  private static String bM(List<g> paramList)
  {
    AppMethodBeat.i(275090);
    StringBuilder localStringBuilder = new StringBuilder("[");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      g localg = (g)paramList.next();
      localStringBuilder.append("{appId:").append(localg.appId).append(", appType:").append(localg.appType).append("}");
    }
    localStringBuilder.append("]");
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(275090);
    return paramList;
  }
  
  public final f<c.a<foq>> bhW()
  {
    try
    {
      AppMethodBeat.i(275092);
      long l = Util.nowMilliSecond();
      this.pYp.CZ(l);
      f localf = super.bhW();
      AppMethodBeat.o(275092);
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.d
 * JD-Core Version:    0.7.0.1
 */