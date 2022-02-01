package com.tencent.mm.plugin.appbrand.config;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.o.j;
import com.tencent.mm.plugin.appbrand.utils.v.a;
import com.tencent.mm.plugin.appbrand.z.p.a;
import com.tencent.mm.protocal.protobuf.bxl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class e
{
  private static ArrayList<byte[]> Q(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146963);
    localArrayList = new ArrayList();
    Object localObject = new com.tencent.mm.plugin.appbrand.z.i();
    paramAppBrandRuntime.Fg().b("cer", (com.tencent.mm.plugin.appbrand.z.i)localObject);
    if (((com.tencent.mm.plugin.appbrand.z.i)localObject).value == null)
    {
      AppMethodBeat.o(146963);
      return localArrayList;
    }
    localObject = com.tencent.mm.plugin.appbrand.z.d.p((ByteBuffer)((com.tencent.mm.plugin.appbrand.z.i)localObject).value);
    try
    {
      paramAppBrandRuntime = new bxl();
      paramAppBrandRuntime.parseFrom((byte[])localObject);
      localObject = paramAppBrandRuntime.GRy;
      if (localObject == null)
      {
        AppMethodBeat.o(146963);
        return localArrayList;
      }
      paramAppBrandRuntime = paramAppBrandRuntime.GRy.iterator();
      while (paramAppBrandRuntime.hasNext()) {
        localArrayList.add(((b)paramAppBrandRuntime.next()).zr);
      }
      return localArrayList;
    }
    catch (Exception paramAppBrandRuntime)
    {
      ad.e("", "readPkgCertificate, parse error: ".concat(String.valueOf(paramAppBrandRuntime)));
      AppMethodBeat.o(146963);
    }
  }
  
  public static com.tencent.mm.plugin.appbrand.jsapi.file.d a(AppBrandSysConfigLU paramAppBrandSysConfigLU)
  {
    AppMethodBeat.i(146964);
    com.tencent.mm.plugin.appbrand.jsapi.file.d locald = new com.tencent.mm.plugin.appbrand.jsapi.file.d();
    locald.cmT = paramAppBrandSysConfigLU.cmT;
    if (locald.cmT <= 0L) {
      locald.cmT = 10L;
    }
    locald.jWT = paramAppBrandSysConfigLU.cnf.jWT;
    if (locald.jWT <= 0L) {
      locald.jWT = 30L;
    }
    AppMethodBeat.o(146964);
    return locald;
  }
  
  public static com.tencent.mm.plugin.appbrand.o.a a(c paramc)
  {
    AppMethodBeat.i(192199);
    AppBrandInitConfigLU localAppBrandInitConfigLU = paramc.Fb();
    AppBrandSysConfigLU localAppBrandSysConfigLU = paramc.Fa();
    a locala = paramc.getAppConfig();
    com.tencent.mm.plugin.appbrand.o.a locala1 = new com.tencent.mm.plugin.appbrand.o.a();
    boolean bool;
    int i;
    if ((localAppBrandInitConfigLU.DY()) || (localAppBrandInitConfigLU.Eb()))
    {
      bool = true;
      locala1.lVk = bool;
      locala1.lVl = d(localAppBrandSysConfigLU);
      i = s(new int[] { localAppBrandSysConfigLU.cnf.jWA.jXg, locala.jVv.dNp });
      if (i > 0) {
        locala1.lVm = i;
      }
      i = s(new int[] { localAppBrandSysConfigLU.cnf.jWA.jXd, locala.jVv.jVN });
      if (i > 0) {
        locala1.lVn = i;
      }
      i = s(new int[] { localAppBrandSysConfigLU.cnf.jWA.jXe, locala.jVv.jVO });
      if (i > 0) {
        locala1.lVo = i;
      }
      i = s(new int[] { localAppBrandSysConfigLU.cnf.jWA.jXf, locala.jVv.jVP });
      if (i > 0) {
        locala1.lVp = i;
      }
      locala1.cmM = localAppBrandSysConfigLU.cmM;
      locala1.lVq = localAppBrandSysConfigLU.cmP;
      locala1.cmN = localAppBrandSysConfigLU.cmN;
      locala1.cmO = localAppBrandSysConfigLU.cmO;
      locala1.cmV = localAppBrandSysConfigLU.cmV;
      locala1.cmW = localAppBrandSysConfigLU.cmW;
      locala1.cmX = localAppBrandSysConfigLU.cmX;
      locala1.cmY = localAppBrandSysConfigLU.cmY;
      locala1.cmZ = localAppBrandSysConfigLU.cmZ;
      if (localAppBrandSysConfigLU.cnf.jWA.mode != 1) {
        break label572;
      }
      if (localAppBrandSysConfigLU.cnf.jWA.jXb != null) {
        locala1.lVr = localAppBrandSysConfigLU.cnf.jWA.jXb;
      }
      label366:
      locala1.mode = localAppBrandSysConfigLU.cnf.jWA.mode;
      locala1.lVt = Q(paramc);
      if (!localAppBrandInitConfigLU.Eb()) {
        break label620;
      }
      i = localAppBrandSysConfigLU.cnf.jWM;
      label407:
      locala1.jWu = i;
      locala1.cmR = localAppBrandSysConfigLU.cmR;
      locala1.cmS = localAppBrandSysConfigLU.cmS;
      locala1.lVu = bdP();
      ad.i("Luggage.FULL.AppBrandConfigAdapter", "runtime(%s).getNetworkConfig.userAgentString = [ %s ]", new Object[] { paramc.mAppId, locala1.lVu });
      paramc = (com.tencent.mm.plugin.appbrand.jsapi.s.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.s.a.class);
      if (paramc == null) {
        break label632;
      }
      locala1.lVv = paramc.Qu(locala.hLQ);
    }
    for (;;)
    {
      locala1.referer = e(localAppBrandSysConfigLU);
      locala1.cms = localAppBrandInitConfigLU.cms;
      locala1.lVw = j.a.oN(localAppBrandSysConfigLU.jYh.jIU);
      if ((locala1.lVw) || (!bt.hj(locala1.lVt))) {
        j.b(locala1);
      }
      AppMethodBeat.o(192199);
      return locala1;
      bool = false;
      break;
      label572:
      if ((localAppBrandSysConfigLU.cnf.jWA.mode != 2) || (localAppBrandSysConfigLU.cnf.jWA.jXc == null)) {
        break label366;
      }
      locala1.lVs = localAppBrandSysConfigLU.cnf.jWA.jXc;
      break label366;
      label620:
      i = localAppBrandSysConfigLU.cnf.jWu;
      break label407;
      label632:
      ad.w("", "getNetworkConfig, referrerHelper is null");
    }
  }
  
  public static com.tencent.mm.plugin.appbrand.a.a b(c paramc)
  {
    AppMethodBeat.i(192200);
    AppBrandSysConfigLU localAppBrandSysConfigLU = paramc.Fa();
    paramc = paramc.getAppConfig();
    com.tencent.mm.plugin.appbrand.a.a locala = new com.tencent.mm.plugin.appbrand.a.a();
    if ((localAppBrandSysConfigLU == null) || (paramc == null))
    {
      AppMethodBeat.o(192200);
      return locala;
    }
    if (j.a.oN(localAppBrandSysConfigLU.jYh.jIU)) {
      locala.jKM = paramc.jVz.contains("audio");
    }
    for (locala.jKN = paramc.jVz.contains("location");; locala.jKN = localAppBrandSysConfigLU.jYc)
    {
      AppMethodBeat.o(192200);
      return locala;
      locala.jKM = localAppBrandSysConfigLU.jYb;
    }
  }
  
  public static v.a b(AppBrandSysConfigLU paramAppBrandSysConfigLU)
  {
    AppMethodBeat.i(192201);
    v.a locala = new v.a();
    locala.jWJ = paramAppBrandSysConfigLU.cnf.jWJ;
    AppMethodBeat.o(192201);
    return locala;
  }
  
  private static String bdP()
  {
    AppMethodBeat.i(192204);
    String str = i.bdZ();
    str = com.tencent.mm.plugin.appbrand.z.p.a(aj.getContext(), str, (p.a)com.tencent.luggage.a.e.K(p.a.class));
    AppMethodBeat.o(192204);
    return str;
  }
  
  public static com.tencent.mm.plugin.appbrand.performance.a c(AppBrandSysConfigLU paramAppBrandSysConfigLU)
  {
    boolean bool2 = true;
    AppMethodBeat.i(192202);
    com.tencent.mm.plugin.appbrand.performance.a locala = new com.tencent.mm.plugin.appbrand.performance.a();
    if ((paramAppBrandSysConfigLU.cmF) && ((paramAppBrandSysConfigLU.jYh.jIU == 1) || (paramAppBrandSysConfigLU.jYh.jIU == 2) || (bu.flY())))
    {
      bool1 = true;
      locala.mhb = bool1;
      if (paramAppBrandSysConfigLU.jYh.jIU == 0) {
        break label96;
      }
    }
    label96:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.mhc = bool1;
      locala.mhd = paramAppBrandSysConfigLU.cmE;
      AppMethodBeat.o(192202);
      return locala;
      bool1 = false;
      break;
    }
  }
  
  private static boolean d(AppBrandSysConfigLU paramAppBrandSysConfigLU)
  {
    boolean bool = false;
    int i;
    if ((paramAppBrandSysConfigLU.jYh.jIU == 1) || (paramAppBrandSysConfigLU.jYh.jIU == 2))
    {
      i = 1;
      if (!paramAppBrandSysConfigLU.cms) {
        break label53;
      }
      if ((i == 0) || (!paramAppBrandSysConfigLU.cmH)) {
        bool = true;
      }
    }
    label53:
    while ((i != 0) && (paramAppBrandSysConfigLU.cmE))
    {
      return bool;
      i = 0;
      break;
    }
    return true;
  }
  
  private static String e(AppBrandSysConfigLU paramAppBrandSysConfigLU)
  {
    AppMethodBeat.i(192203);
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (paramAppBrandSysConfigLU.cnf != null)
    {
      localObject1 = localObject2;
      if (paramAppBrandSysConfigLU.cnf.jWA != null) {
        localObject1 = paramAppBrandSysConfigLU.cnf.jWA.jXh;
      }
    }
    localObject2 = localObject1;
    if (bt.isNullOrNil((String)localObject1)) {
      localObject2 = "servicewechat.com";
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("https://");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append(paramAppBrandSysConfigLU.appId);
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append(paramAppBrandSysConfigLU.jYh.pkgVersion);
    ((StringBuilder)localObject1).append("/page-frame.html");
    paramAppBrandSysConfigLU = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(192203);
    return paramAppBrandSysConfigLU;
  }
  
  private static int s(int... paramVarArgs)
  {
    int k = 0;
    int i = 0;
    if (k < 2)
    {
      int m = paramVarArgs[k];
      int j;
      if (m > 0) {
        if (i == 0) {
          j = m;
        }
      }
      for (;;)
      {
        k += 1;
        i = j;
        break;
        j = m;
        if (m >= i) {
          j = i;
        }
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.e
 * JD-Core Version:    0.7.0.1
 */