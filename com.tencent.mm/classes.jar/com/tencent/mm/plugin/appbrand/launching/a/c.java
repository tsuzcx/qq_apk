package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.g.b.a.hs;
import com.tencent.mm.g.b.a.hs.b;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.ebb;
import com.tencent.mm.protocal.protobuf.ebc;
import com.tencent.mm.protocal.protobuf.ebd;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends com.tencent.mm.ak.c<ebc>
{
  final String appId;
  final String cbY;
  final int hxM;
  public volatile boolean lnb;
  private final hs loM;
  public volatile HashMap<String, AppRuntimeApiPermissionBundle> loN;
  final b rr;
  
  public c(String paramString1, int paramInt, List<e> paramList, boolean paramBoolean, String paramString2, QualitySession paramQualitySession)
  {
    AppMethodBeat.i(186858);
    this.lnb = false;
    this.loN = new HashMap();
    this.appId = paramString1;
    this.hxM = paramInt;
    this.cbY = paramString2;
    this.loM = com.tencent.mm.plugin.appbrand.report.quality.f.g(paramQualitySession);
    paramString2 = this.loM;
    if (paramBoolean) {}
    for (paramString1 = hs.b.ehB;; paramString1 = hs.b.ehC)
    {
      paramString2.ehw = paramString1;
      this.loM.dQE = com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType();
      paramString1 = new ebb();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramString2 = (e)paramList.next();
        paramQualitySession = new ebd();
        paramQualitySession.djj = paramString2.appId;
        paramQualitySession.oGP = paramString2.appType;
        paramString1.GgN.add(paramQualitySession);
      }
    }
    paramList = new b.a();
    paramList.funcId = 3827;
    paramList.uri = "/cgi-bin/mmbiz-bin/wxaattr/wxajsapiinfo";
    paramList.hvt = paramString1;
    paramList.hvu = new ebc();
    paramString1 = paramList.aAz();
    this.rr = paramString1;
    this.rr = paramString1;
    AppMethodBeat.o(186858);
  }
  
  public final com.tencent.mm.cn.f<c.a<ebc>> aBB()
  {
    try
    {
      AppMethodBeat.i(186859);
      long l = bs.eWj();
      this.loM.nd(l);
      com.tencent.mm.cn.f localf = super.aBB();
      AppMethodBeat.o(186859);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.c
 * JD-Core Version:    0.7.0.1
 */