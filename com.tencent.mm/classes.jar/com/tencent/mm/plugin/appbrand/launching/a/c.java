package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.g.b.a.iy;
import com.tencent.mm.g.b.a.iy.b;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.protocal.protobuf.eix;
import com.tencent.mm.protocal.protobuf.eiy;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends a<eix>
{
  final String appId;
  final String cmr;
  final int hSZ;
  public volatile boolean lOV;
  private final iy lQE;
  public volatile HashMap<String, AppRuntimeApiPermissionBundle> lQF;
  final b rr;
  
  public c(String paramString1, int paramInt, List<e> paramList, boolean paramBoolean, String paramString2, QualitySession paramQualitySession)
  {
    AppMethodBeat.i(222805);
    this.lOV = false;
    this.lQF = new HashMap();
    this.appId = paramString1;
    this.hSZ = paramInt;
    this.cmr = paramString2;
    this.lQE = com.tencent.mm.plugin.appbrand.report.quality.f.g(paramQualitySession);
    paramString2 = this.lQE;
    if (paramBoolean) {}
    for (paramString1 = iy.b.eAk;; paramString1 = iy.b.eAl)
    {
      paramString2.eAf = paramString1;
      this.lQE.ehL = com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType();
      paramString1 = new eiw();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramString2 = (e)paramList.next();
        paramQualitySession = new eiy();
        paramQualitySession.dwb = paramString2.appId;
        paramQualitySession.pqY = paramString2.appType;
        paramString1.Imh.add(paramQualitySession);
      }
    }
    paramList = new b.a();
    paramList.funcId = 3827;
    paramList.uri = "/cgi-bin/mmbiz-bin/wxaattr/wxajsapiinfo";
    paramList.hQF = paramString1;
    paramList.hQG = new eix();
    paramString1 = paramList.aDS();
    this.rr = paramString1;
    c(paramString1);
    AppMethodBeat.o(222805);
  }
  
  public final com.tencent.mm.cm.f<a.a<eix>> aET()
  {
    try
    {
      AppMethodBeat.i(222806);
      long l = bu.fpO();
      this.lQE.po(l);
      com.tencent.mm.cm.f localf = super.aET();
      AppMethodBeat.o(222806);
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