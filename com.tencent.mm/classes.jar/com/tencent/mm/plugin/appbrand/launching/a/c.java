package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.co.f;
import com.tencent.mm.g.b.a.mu;
import com.tencent.mm.g.b.a.mu.b;
import com.tencent.mm.plugin.appbrand.launching.ay;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.g;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.fdo;
import com.tencent.mm.protocal.protobuf.fdp;
import com.tencent.mm.protocal.protobuf.fdq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public final class c
  extends com.tencent.mm.ak.c<fdp>
{
  final String appId;
  final String cym;
  final int iOo;
  public volatile boolean mWd;
  private final ay mXR;
  private final mu mXS;
  public volatile HashMap<String, AppRuntimeApiPermissionBundle> mXT;
  final d rr;
  
  public c(String paramString1, int paramInt, List<e> paramList, boolean paramBoolean, String paramString2, QualitySession paramQualitySession, ay paramay, acc paramacc)
  {
    AppMethodBeat.i(227128);
    this.mWd = false;
    this.mXT = new HashMap();
    this.appId = paramString1;
    this.iOo = paramInt;
    this.cym = paramString2;
    this.mXR = paramay;
    this.mXS = g.f(paramQualitySession);
    Object localObject = this.mXS;
    if (paramBoolean) {}
    for (paramay = mu.b.feH;; paramay = mu.b.feI)
    {
      ((mu)localObject).feC = paramay;
      this.mXS.eJb = g.getNetworkType();
      paramay = new fdo();
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        e locale = (e)((Iterator)localObject).next();
        fdq localfdq = new fdq();
        localfdq.dNI = locale.appId;
        localfdq.qGD = locale.appType;
        paramay.Nzk.add(localfdq);
      }
    }
    paramay.KOF = ((acc)Objects.requireNonNull(paramacc));
    localObject = new d.a();
    ((d.a)localObject).funcId = 3827;
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaattr/wxajsapiinfo";
    ((d.a)localObject).iLN = paramay;
    ((d.a)localObject).iLO = new fdp();
    paramay = ((d.a)localObject).aXF();
    this.rr = paramay;
    c(paramay);
    Log.i("MicroMsg.AppBrand.CgiWxaJsApiInfo", "<init> appId:%s, versionType:%d, appIdList:%s, sync:%b, sessionId:%s, instanceId:%s, source:%s", new Object[] { paramString1, Integer.valueOf(paramInt), bN(paramList), Boolean.valueOf(paramBoolean), paramString2, paramQualitySession.kEY, a.a(paramacc) });
    AppMethodBeat.o(227128);
  }
  
  private static String bN(List<e> paramList)
  {
    AppMethodBeat.i(227129);
    StringBuilder localStringBuilder = new StringBuilder("[");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      e locale = (e)paramList.next();
      localStringBuilder.append("{appId:").append(locale.appId).append(", appType:").append(locale.appType).append("}");
    }
    localStringBuilder.append("]");
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(227129);
    return paramList;
  }
  
  public final f<c.a<fdp>> aYI()
  {
    try
    {
      AppMethodBeat.i(227130);
      long l = Util.nowMilliSecond();
      this.mXS.wZ(l);
      f localf = super.aYI();
      AppMethodBeat.o(227130);
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.c
 * JD-Core Version:    0.7.0.1
 */