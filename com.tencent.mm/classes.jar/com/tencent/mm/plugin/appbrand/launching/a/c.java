package com.tencent.mm.plugin.appbrand.launching.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.plugin.appbrand.appcache.au;
import com.tencent.mm.plugin.appbrand.appcache.o;
import com.tencent.mm.plugin.appbrand.launching.ay;
import com.tencent.mm.plugin.appbrand.permission.appidABTest.AppRuntimeAppidABTestPermissionBundle;
import com.tencent.mm.protocal.protobuf.fmz;
import com.tencent.mm.protocal.protobuf.fna;
import com.tencent.mm.protocal.protobuf.fnb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends com.tencent.mm.an.c<fnb>
{
  final String appId;
  final int cBU;
  final String cwP;
  public volatile boolean pWG;
  private final ay pYl;
  public volatile HashMap<String, AppRuntimeAppidABTestPermissionBundle> pYm;
  final d rr;
  
  public c(String paramString1, int paramInt, List<f> paramList, boolean paramBoolean, String paramString2, ay paramay)
  {
    AppMethodBeat.i(271321);
    this.pWG = false;
    this.pYm = new HashMap();
    this.appId = paramString1;
    this.cBU = paramInt;
    this.cwP = paramString2;
    this.pYl = paramay;
    paramay = new fna();
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      fmz localfmz = new fmz();
      localfmz.appid = localf.appId;
      localfmz.ufE = localf.appType;
      localfmz.TuP = localf.cBU;
      paramay.ULx.add(localfmz);
    }
    paramay.jUb = Build.MODEL;
    paramay.jUc = Build.BRAND;
    paramay.ULy = Build.MANUFACTURER;
    paramay.jUe = Build.VERSION.RELEASE;
    paramay.ULB = Build.VERSION.RELEASE;
    paramay.ULC = Build.VERSION.INCREMENTAL;
    paramay.ULD = Build.DISPLAY;
    localObject = au.bHb();
    if (localObject != null)
    {
      paramay.ULz = ((o)localObject).bGg();
      paramay.ULA = ((o)localObject).bGi();
    }
    localObject = new d.a();
    ((d.a)localObject).funcId = 5124;
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/getwxagameabtestinfo";
    ((d.a)localObject).lBU = paramay;
    ((d.a)localObject).lBV = new fnb();
    paramay = ((d.a)localObject).bgN();
    this.rr = paramay;
    c(paramay);
    Log.i("MicroMsg.AppBrand.CgiWxaAppidABTestInfo", "<init> appId:%s, versionType:%d, appIdList:%s, sync:%b, sessionId:%s", new Object[] { paramString1, Integer.valueOf(paramInt), bM(paramList), Boolean.valueOf(paramBoolean), paramString2 });
    AppMethodBeat.o(271321);
  }
  
  public static String T(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(271324);
    String str;
    if (paramInt1 == 1) {
      str = "_weApp";
    }
    for (;;)
    {
      paramString = paramString + str + paramInt2;
      AppMethodBeat.o(271324);
      return paramString;
      if (paramInt1 == 2) {
        str = "_plugin";
      } else {
        str = "";
      }
    }
  }
  
  private static String bM(List<f> paramList)
  {
    AppMethodBeat.i(271322);
    StringBuilder localStringBuilder = new StringBuilder("[");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      f localf = (f)paramList.next();
      localStringBuilder.append("{appId:").append(localf.appId).append(", appType:").append(localf.appType).append(", versionType:").append(localf.cBU).append("}");
    }
    localStringBuilder.append("]");
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(271322);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.c
 * JD-Core Version:    0.7.0.1
 */