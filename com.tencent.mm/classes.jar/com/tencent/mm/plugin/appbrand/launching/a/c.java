package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c.a;
import com.tencent.mm.g.b.a.ga;
import com.tencent.mm.g.b.a.ga.b;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.protocal.protobuf.dvl;
import com.tencent.mm.protocal.protobuf.dvm;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends com.tencent.mm.al.c<dvl>
{
  final String appId;
  final String cfb;
  final int gXn;
  public volatile boolean kLF;
  private final ga kNn;
  public volatile HashMap<String, AppRuntimeApiPermissionBundle> kNo;
  final b rr;
  
  public c(String paramString1, int paramInt, List<e> paramList, boolean paramBoolean, String paramString2, QualitySession paramQualitySession)
  {
    AppMethodBeat.i(196034);
    this.kLF = false;
    this.kNo = new HashMap();
    this.appId = paramString1;
    this.gXn = paramInt;
    this.cfb = paramString2;
    this.kNn = com.tencent.mm.plugin.appbrand.report.quality.f.g(paramQualitySession);
    paramString2 = this.kNn;
    if (paramBoolean) {}
    for (paramString1 = ga.b.efu;; paramString1 = ga.b.efv)
    {
      paramString2.efp = paramString1;
      this.kNn.dON = com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType();
      paramString1 = new dvk();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramString2 = (e)paramList.next();
        paramQualitySession = new dvm();
        paramQualitySession.dlB = paramString2.appId;
        paramQualitySession.odq = paramString2.appType;
        paramString1.EJB.add(paramQualitySession);
      }
    }
    paramList = new b.a();
    paramList.funcId = 3827;
    paramList.uri = "/cgi-bin/mmbiz-bin/wxaattr/wxajsapiinfo";
    paramList.gUU = paramString1;
    paramList.gUV = new dvl();
    paramString1 = paramList.atI();
    this.rr = paramString1;
    this.rr = paramString1;
    AppMethodBeat.o(196034);
  }
  
  public final com.tencent.mm.co.f<c.a<dvl>> auK()
  {
    try
    {
      AppMethodBeat.i(196035);
      long l = bt.eGO();
      this.kNn.jB(l);
      com.tencent.mm.co.f localf = super.auK();
      AppMethodBeat.o(196035);
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