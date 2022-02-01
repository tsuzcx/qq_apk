package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.g.b.a.iw;
import com.tencent.mm.g.b.a.iw.b;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.ehf;
import com.tencent.mm.protocal.protobuf.ehg;
import com.tencent.mm.protocal.protobuf.ehh;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends a<ehg>
{
  final String appId;
  final String cmp;
  final int hQh;
  public volatile boolean lKu;
  private final iw lMe;
  public volatile HashMap<String, AppRuntimeApiPermissionBundle> lMf;
  final b rr;
  
  public c(String paramString1, int paramInt, List<e> paramList, boolean paramBoolean, String paramString2, QualitySession paramQualitySession)
  {
    AppMethodBeat.i(188643);
    this.lKu = false;
    this.lMf = new HashMap();
    this.appId = paramString1;
    this.hQh = paramInt;
    this.cmp = paramString2;
    this.lMe = com.tencent.mm.plugin.appbrand.report.quality.f.g(paramQualitySession);
    paramString2 = this.lMe;
    if (paramBoolean) {}
    for (paramString1 = iw.b.eyB;; paramString1 = iw.b.eyC)
    {
      paramString2.eyw = paramString1;
      this.lMe.ega = com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType();
      paramString1 = new ehf();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramString2 = (e)paramList.next();
        paramQualitySession = new ehh();
        paramQualitySession.duW = paramString2.appId;
        paramQualitySession.pkt = paramString2.appType;
        paramString1.HSa.add(paramQualitySession);
      }
    }
    paramList = new b.a();
    paramList.funcId = 3827;
    paramList.uri = "/cgi-bin/mmbiz-bin/wxaattr/wxajsapiinfo";
    paramList.hNM = paramString1;
    paramList.hNN = new ehg();
    paramString1 = paramList.aDC();
    this.rr = paramString1;
    c(paramString1);
    AppMethodBeat.o(188643);
  }
  
  public final com.tencent.mm.cn.f<a.a<ehg>> aED()
  {
    try
    {
      AppMethodBeat.i(188644);
      long l = bt.flT();
      this.lMe.pb(l);
      com.tencent.mm.cn.f localf = super.aED();
      AppMethodBeat.o(188644);
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