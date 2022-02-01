package com.tencent.mm.plugin.appbrand.launching.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.appcache.av;
import com.tencent.mm.plugin.appbrand.appcache.p;
import com.tencent.mm.plugin.appbrand.launching.ba;
import com.tencent.mm.plugin.appbrand.permission.appidABTest.AppRuntimeAppidABTestPermissionBundle;
import com.tencent.mm.protocal.protobuf.gjs;
import com.tencent.mm.protocal.protobuf.gjt;
import com.tencent.mm.protocal.protobuf.gju;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends b<gju>
{
  final String appId;
  final String eoP;
  final int euz;
  final com.tencent.mm.am.c rr;
  public volatile boolean tbv;
  private final ba tdc;
  public volatile HashMap<String, AppRuntimeAppidABTestPermissionBundle> tdd;
  
  public c(String paramString1, int paramInt, List<f> paramList, boolean paramBoolean, String paramString2, ba paramba)
  {
    AppMethodBeat.i(321098);
    this.tbv = false;
    this.tdd = new HashMap();
    this.appId = paramString1;
    this.euz = paramInt;
    this.eoP = paramString2;
    this.tdc = paramba;
    paramba = new gjt();
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      gjs localgjs = new gjs();
      localgjs.appid = localf.appId;
      localgjs.xlL = localf.appType;
      localgjs.aaJu = localf.euz;
      paramba.acfK.add(localgjs);
    }
    paramba.mut = q.aPo();
    paramba.muu = Build.BRAND;
    paramba.acfL = Build.MANUFACTURER;
    paramba.muw = Build.VERSION.RELEASE;
    paramba.acfO = Build.VERSION.RELEASE;
    paramba.acfP = Build.VERSION.INCREMENTAL;
    paramba.acfQ = Build.DISPLAY;
    localObject = av.cgx();
    if (localObject != null)
    {
      paramba.acfM = ((p)localObject).cfD();
      paramba.acfN = ((p)localObject).cfG();
    }
    localObject = new c.a();
    ((c.a)localObject).funcId = 5124;
    ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/getwxagameabtestinfo";
    ((c.a)localObject).otE = paramba;
    ((c.a)localObject).otF = new gju();
    paramba = ((c.a)localObject).bEF();
    this.rr = paramba;
    c(paramba);
    Log.i("MicroMsg.AppBrand.CgiWxaAppidABTestInfo", "<init> appId:%s, versionType:%d, appIdList:%s, sync:%b, sessionId:%s", new Object[] { paramString1, Integer.valueOf(paramInt), dy(paramList), Boolean.valueOf(paramBoolean), paramString2 });
    AppMethodBeat.o(321098);
  }
  
  public static String X(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(321107);
    String str;
    if (paramInt1 == 1) {
      str = "_weApp";
    }
    for (;;)
    {
      paramString = paramString + str + paramInt2;
      AppMethodBeat.o(321107);
      return paramString;
      if (paramInt1 == 2) {
        str = "_plugin";
      } else {
        str = "";
      }
    }
  }
  
  private static String dy(List<f> paramList)
  {
    AppMethodBeat.i(321102);
    StringBuilder localStringBuilder = new StringBuilder("[");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      f localf = (f)paramList.next();
      localStringBuilder.append("{appId:").append(localf.appId).append(", appType:").append(localf.appType).append(", versionType:").append(localf.euz).append("}");
    }
    localStringBuilder.append("]");
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(321102);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.c
 * JD-Core Version:    0.7.0.1
 */