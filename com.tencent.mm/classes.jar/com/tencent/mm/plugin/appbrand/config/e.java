package com.tencent.mm.plugin.appbrand.config;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.o.j;
import com.tencent.mm.plugin.appbrand.utils.x.a;
import com.tencent.mm.plugin.appbrand.y.p;
import com.tencent.mm.plugin.appbrand.y.p.a;
import com.tencent.mm.protocal.protobuf.byf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class e
{
  private static ArrayList<byte[]> O(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146963);
    localArrayList = new ArrayList();
    Object localObject = new com.tencent.mm.plugin.appbrand.y.i();
    paramAppBrandRuntime.Fl().b("cer", (com.tencent.mm.plugin.appbrand.y.i)localObject);
    if (((com.tencent.mm.plugin.appbrand.y.i)localObject).value == null)
    {
      AppMethodBeat.o(146963);
      return localArrayList;
    }
    localObject = com.tencent.mm.plugin.appbrand.y.d.p((ByteBuffer)((com.tencent.mm.plugin.appbrand.y.i)localObject).value);
    try
    {
      paramAppBrandRuntime = new byf();
      paramAppBrandRuntime.parseFrom((byte[])localObject);
      localObject = paramAppBrandRuntime.HkZ;
      if (localObject == null)
      {
        AppMethodBeat.o(146963);
        return localArrayList;
      }
      paramAppBrandRuntime = paramAppBrandRuntime.HkZ.iterator();
      while (paramAppBrandRuntime.hasNext()) {
        localArrayList.add(((b)paramAppBrandRuntime.next()).zr);
      }
      return localArrayList;
    }
    catch (Exception paramAppBrandRuntime)
    {
      ae.e("", "readPkgCertificate, parse error: ".concat(String.valueOf(paramAppBrandRuntime)));
      AppMethodBeat.o(146963);
    }
  }
  
  public static com.tencent.mm.plugin.appbrand.jsapi.file.d a(AppBrandSysConfigLU paramAppBrandSysConfigLU)
  {
    AppMethodBeat.i(146964);
    com.tencent.mm.plugin.appbrand.jsapi.file.d locald = new com.tencent.mm.plugin.appbrand.jsapi.file.d();
    locald.cmV = paramAppBrandSysConfigLU.cmV;
    if (locald.cmV <= 0L) {
      locald.cmV = 10L;
    }
    locald.kai = paramAppBrandSysConfigLU.cnh.kai;
    if (locald.kai <= 0L) {
      locald.kai = 30L;
    }
    AppMethodBeat.o(146964);
    return locald;
  }
  
  public static com.tencent.mm.plugin.appbrand.o.a a(com.tencent.luggage.sdk.d.d paramd)
  {
    AppMethodBeat.i(220770);
    AppBrandInitConfigLU localAppBrandInitConfigLU = paramd.Fg();
    AppBrandSysConfigLU localAppBrandSysConfigLU = paramd.Ff();
    a locala = paramd.getAppConfig();
    com.tencent.mm.plugin.appbrand.o.a locala1 = new com.tencent.mm.plugin.appbrand.o.a();
    boolean bool;
    int i;
    if ((localAppBrandInitConfigLU.Eb()) || (localAppBrandInitConfigLU.Ee()))
    {
      bool = true;
      locala1.lZN = bool;
      locala1.lZO = d(localAppBrandSysConfigLU);
      i = s(new int[] { localAppBrandSysConfigLU.cnh.jZP.kav, locala.jYM.dOF });
      if (i > 0) {
        locala1.lZP = i;
      }
      i = s(new int[] { localAppBrandSysConfigLU.cnh.jZP.kas, locala.jYM.jZc });
      if (i > 0) {
        locala1.lZQ = i;
      }
      i = s(new int[] { localAppBrandSysConfigLU.cnh.jZP.kat, locala.jYM.jZd });
      if (i > 0) {
        locala1.lZR = i;
      }
      i = s(new int[] { localAppBrandSysConfigLU.cnh.jZP.kau, locala.jYM.jZe });
      if (i > 0) {
        locala1.lZS = i;
      }
      locala1.cmO = localAppBrandSysConfigLU.cmO;
      locala1.lZT = localAppBrandSysConfigLU.cmR;
      locala1.cmP = localAppBrandSysConfigLU.cmP;
      locala1.cmQ = localAppBrandSysConfigLU.cmQ;
      locala1.cmX = localAppBrandSysConfigLU.cmX;
      locala1.cmY = localAppBrandSysConfigLU.cmY;
      locala1.cmZ = localAppBrandSysConfigLU.cmZ;
      locala1.cna = localAppBrandSysConfigLU.cna;
      locala1.cnb = localAppBrandSysConfigLU.cnb;
      if (localAppBrandSysConfigLU.cnh.jZP.mode != 1) {
        break label572;
      }
      if (localAppBrandSysConfigLU.cnh.jZP.kaq != null) {
        locala1.lZU = localAppBrandSysConfigLU.cnh.jZP.kaq;
      }
      label366:
      locala1.mode = localAppBrandSysConfigLU.cnh.jZP.mode;
      locala1.lZW = O(paramd);
      if (!localAppBrandInitConfigLU.Ee()) {
        break label620;
      }
      i = localAppBrandSysConfigLU.cnh.kab;
      label407:
      locala1.jZJ = i;
      locala1.cmT = localAppBrandSysConfigLU.cmT;
      locala1.cmU = localAppBrandSysConfigLU.cmU;
      locala1.lZX = bev();
      ae.i("Luggage.FULL.AppBrandConfigAdapter", "runtime(%s).getNetworkConfig.userAgentString = [ %s ]", new Object[] { paramd.mAppId, locala1.lZX });
      paramd = (com.tencent.mm.plugin.appbrand.jsapi.s.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.s.a.class);
      if (paramd == null) {
        break label632;
      }
      locala1.lZY = paramd.Rd(locala.hOJ);
    }
    for (;;)
    {
      locala1.referer = e(localAppBrandSysConfigLU);
      locala1.cmu = localAppBrandInitConfigLU.cmu;
      locala1.lZZ = j.a.oQ(localAppBrandSysConfigLU.kbw.jLV);
      if ((locala1.lZZ) || (!bu.ht(locala1.lZW))) {
        j.b(locala1);
      }
      AppMethodBeat.o(220770);
      return locala1;
      bool = false;
      break;
      label572:
      if ((localAppBrandSysConfigLU.cnh.jZP.mode != 2) || (localAppBrandSysConfigLU.cnh.jZP.kar == null)) {
        break label366;
      }
      locala1.lZV = localAppBrandSysConfigLU.cnh.jZP.kar;
      break label366;
      label620:
      i = localAppBrandSysConfigLU.cnh.jZJ;
      break label407;
      label632:
      ae.w("", "getNetworkConfig, referrerHelper is null");
    }
  }
  
  public static com.tencent.mm.plugin.appbrand.a.a b(com.tencent.luggage.sdk.d.d paramd)
  {
    AppMethodBeat.i(220771);
    AppBrandSysConfigLU localAppBrandSysConfigLU = paramd.Ff();
    paramd = paramd.getAppConfig();
    com.tencent.mm.plugin.appbrand.a.a locala = new com.tencent.mm.plugin.appbrand.a.a();
    if ((localAppBrandSysConfigLU == null) || (paramd == null))
    {
      AppMethodBeat.o(220771);
      return locala;
    }
    if (j.a.oQ(localAppBrandSysConfigLU.kbw.jLV)) {
      locala.jNY = paramd.jYQ.contains("audio");
    }
    for (locala.jNZ = paramd.jYQ.contains("location");; locala.jNZ = localAppBrandSysConfigLU.kbr)
    {
      AppMethodBeat.o(220771);
      return locala;
      locala.jNY = localAppBrandSysConfigLU.kbq;
    }
  }
  
  public static x.a b(AppBrandSysConfigLU paramAppBrandSysConfigLU)
  {
    AppMethodBeat.i(220772);
    x.a locala = new x.a();
    locala.jZY = paramAppBrandSysConfigLU.cnh.jZY;
    AppMethodBeat.o(220772);
    return locala;
  }
  
  private static String bev()
  {
    AppMethodBeat.i(220775);
    String str = i.beF();
    str = p.a(ak.getContext(), str, (p.a)com.tencent.luggage.a.e.K(p.a.class));
    AppMethodBeat.o(220775);
    return str;
  }
  
  public static com.tencent.mm.plugin.appbrand.performance.a c(AppBrandSysConfigLU paramAppBrandSysConfigLU)
  {
    boolean bool2 = true;
    AppMethodBeat.i(220773);
    com.tencent.mm.plugin.appbrand.performance.a locala = new com.tencent.mm.plugin.appbrand.performance.a();
    if ((paramAppBrandSysConfigLU.cmH) && ((paramAppBrandSysConfigLU.kbw.jLV == 1) || (paramAppBrandSysConfigLU.kbw.jLV == 2) || (bv.fpT())))
    {
      bool1 = true;
      locala.mma = bool1;
      if (paramAppBrandSysConfigLU.kbw.jLV == 0) {
        break label96;
      }
    }
    label96:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.mmb = bool1;
      locala.mmc = paramAppBrandSysConfigLU.cmG;
      AppMethodBeat.o(220773);
      return locala;
      bool1 = false;
      break;
    }
  }
  
  private static boolean d(AppBrandSysConfigLU paramAppBrandSysConfigLU)
  {
    boolean bool = false;
    int i;
    if ((paramAppBrandSysConfigLU.kbw.jLV == 1) || (paramAppBrandSysConfigLU.kbw.jLV == 2))
    {
      i = 1;
      if (!paramAppBrandSysConfigLU.cmu) {
        break label53;
      }
      if ((i == 0) || (!paramAppBrandSysConfigLU.cmJ)) {
        bool = true;
      }
    }
    label53:
    while ((i != 0) && (paramAppBrandSysConfigLU.cmG))
    {
      return bool;
      i = 0;
      break;
    }
    return true;
  }
  
  private static String e(AppBrandSysConfigLU paramAppBrandSysConfigLU)
  {
    AppMethodBeat.i(220774);
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (paramAppBrandSysConfigLU.cnh != null)
    {
      localObject1 = localObject2;
      if (paramAppBrandSysConfigLU.cnh.jZP != null) {
        localObject1 = paramAppBrandSysConfigLU.cnh.jZP.kaw;
      }
    }
    localObject2 = localObject1;
    if (bu.isNullOrNil((String)localObject1)) {
      localObject2 = "servicewechat.com";
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("https://");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append(paramAppBrandSysConfigLU.appId);
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append(paramAppBrandSysConfigLU.kbw.pkgVersion);
    ((StringBuilder)localObject1).append("/page-frame.html");
    paramAppBrandSysConfigLU = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(220774);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.e
 * JD-Core Version:    0.7.0.1
 */