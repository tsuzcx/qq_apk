package com.tencent.mm.plugin.appbrand.config;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.utils.x.a;
import com.tencent.mm.protocal.protobuf.clx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class f
{
  private static final String czw;
  
  static
  {
    AppMethodBeat.i(229880);
    czw = WeChatHosts.domainString(2131761738);
    AppMethodBeat.o(229880);
  }
  
  private static ArrayList<byte[]> P(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146963);
    localArrayList = new ArrayList();
    Object localObject = new i();
    paramAppBrandRuntime.getFileSystem().b("cer", (i)localObject);
    if (((i)localObject).value == null)
    {
      AppMethodBeat.o(146963);
      return localArrayList;
    }
    localObject = com.tencent.mm.plugin.appbrand.ac.d.p((ByteBuffer)((i)localObject).value);
    try
    {
      paramAppBrandRuntime = new clx();
      paramAppBrandRuntime.parseFrom((byte[])localObject);
      localObject = paramAppBrandRuntime.Mrl;
      if (localObject == null)
      {
        AppMethodBeat.o(146963);
        return localArrayList;
      }
      paramAppBrandRuntime = paramAppBrandRuntime.Mrl.iterator();
      while (paramAppBrandRuntime.hasNext()) {
        localArrayList.add(((com.tencent.mm.bw.b)paramAppBrandRuntime.next()).zy);
      }
      return localArrayList;
    }
    catch (Exception paramAppBrandRuntime)
    {
      Log.e("", "readPkgCertificate, parse error: ".concat(String.valueOf(paramAppBrandRuntime)));
      AppMethodBeat.o(146963);
    }
  }
  
  public static com.tencent.mm.plugin.appbrand.jsapi.file.d a(AppBrandSysConfigLU paramAppBrandSysConfigLU)
  {
    AppMethodBeat.i(146964);
    com.tencent.mm.plugin.appbrand.jsapi.file.d locald = new com.tencent.mm.plugin.appbrand.jsapi.file.d();
    locald.cyR = paramAppBrandSysConfigLU.cyR;
    if (locald.cyR <= 0L) {
      locald.cyR = 10L;
    }
    locald.ldl = paramAppBrandSysConfigLU.czd.ldl;
    if (locald.ldl <= 0L) {
      locald.ldl = 30L;
    }
    AppMethodBeat.o(146964);
    return locald;
  }
  
  public static com.tencent.mm.plugin.appbrand.s.a a(com.tencent.luggage.sdk.d.d paramd)
  {
    AppMethodBeat.i(229876);
    AppBrandInitConfigLU localAppBrandInitConfigLU = paramd.ON();
    AppBrandSysConfigLU localAppBrandSysConfigLU = paramd.OM();
    Object localObject = paramd.getAppConfig();
    com.tencent.mm.plugin.appbrand.s.a locala = new com.tencent.mm.plugin.appbrand.s.a();
    boolean bool;
    int i;
    if ((localAppBrandInitConfigLU.Nx()) || (localAppBrandInitConfigLU.NA()))
    {
      bool = true;
      locala.nhC = bool;
      if ((localAppBrandSysConfigLU.leE.kNW != 1) && (localAppBrandSysConfigLU.leE.kNW != 2)) {
        break label652;
      }
      i = 1;
      label81:
      if (!localAppBrandSysConfigLU.cyp) {
        break label662;
      }
      if ((i != 0) && (localAppBrandSysConfigLU.cyF)) {
        break label657;
      }
      bool = true;
      label103:
      locala.nhD = bool;
      i = ((b)localObject).lbO.egB;
      if (i > 0) {
        locala.nhE = i;
      }
      i = ((b)localObject).lbO.lce;
      if (i > 0) {
        locala.nhF = i;
      }
      i = ((b)localObject).lbO.lcf;
      if (i > 0) {
        locala.nhG = i;
      }
      i = ((b)localObject).lbO.lcg;
      if (i > 0) {
        locala.nhH = i;
      }
      locala.cyK = localAppBrandSysConfigLU.cyK;
      locala.nhI = localAppBrandSysConfigLU.cyN;
      locala.cyL = localAppBrandSysConfigLU.cyL;
      locala.cyM = localAppBrandSysConfigLU.cyM;
      locala.cyT = localAppBrandSysConfigLU.cyT;
      locala.cyU = localAppBrandSysConfigLU.cyU;
      locala.cyV = localAppBrandSysConfigLU.cyV;
      locala.cyW = localAppBrandSysConfigLU.cyW;
      locala.cyX = localAppBrandSysConfigLU.cyX;
      if (localAppBrandSysConfigLU.czd.lcS.mode != 1) {
        break label684;
      }
      if (localAppBrandSysConfigLU.czd.lcS.ldu != null) {
        locala.nhJ = localAppBrandSysConfigLU.czd.lcS.ldu;
      }
      label316:
      locala.mode = localAppBrandSysConfigLU.czd.lcS.mode;
      locala.nhL = P(paramd);
      if (!localAppBrandInitConfigLU.NA()) {
        break label732;
      }
      i = localAppBrandSysConfigLU.czd.lde;
      label358:
      locala.lcM = i;
      locala.cyP = localAppBrandSysConfigLU.cyP;
      locala.cyQ = localAppBrandSysConfigLU.cyQ;
      String str = j.bzW();
      locala.nhM = s.aa(MMApplicationContext.getContext(), str);
      Log.i("Luggage.FULL.AppBrandConfigAdapter", "runtime(%s).getNetworkConfig.userAgentString = [ %s ]", new Object[] { paramd.mAppId, locala.nhM });
      paramd = (com.tencent.mm.plugin.appbrand.jsapi.u.a)e.M(com.tencent.mm.plugin.appbrand.jsapi.u.a.class);
      if (paramd == null) {
        break label744;
      }
      locala.nhN = paramd.aaF(((b)localObject).iJP);
    }
    for (;;)
    {
      localObject = "";
      paramd = (com.tencent.luggage.sdk.d.d)localObject;
      if (localAppBrandSysConfigLU.czd != null)
      {
        paramd = (com.tencent.luggage.sdk.d.d)localObject;
        if (localAppBrandSysConfigLU.czd.lcS != null) {
          paramd = localAppBrandSysConfigLU.czd.lcS.ldA;
        }
      }
      localObject = paramd;
      if (Util.isNullOrNil(paramd)) {
        localObject = czw;
      }
      paramd = new StringBuilder();
      paramd.append("https://");
      paramd.append((String)localObject);
      paramd.append("/");
      paramd.append(localAppBrandSysConfigLU.appId);
      paramd.append("/");
      paramd.append(localAppBrandSysConfigLU.leE.pkgVersion);
      paramd.append("/page-frame.html");
      locala.referer = paramd.toString();
      locala.cyp = localAppBrandInitConfigLU.cyp;
      locala.nhO = j.a.sE(localAppBrandSysConfigLU.leE.kNW);
      if ((locala.nhO) || (!Util.isNullOrNil(locala.nhL))) {
        com.tencent.mm.plugin.appbrand.s.j.b(locala);
      }
      AppMethodBeat.o(229876);
      return locala;
      bool = false;
      break;
      label652:
      i = 0;
      break label81;
      label657:
      bool = false;
      break label103;
      label662:
      if ((i == 0) || (!localAppBrandSysConfigLU.cyC))
      {
        bool = true;
        break label103;
      }
      bool = false;
      break label103;
      label684:
      if ((localAppBrandSysConfigLU.czd.lcS.mode != 2) || (localAppBrandSysConfigLU.czd.lcS.ldv == null)) {
        break label316;
      }
      locala.nhK = localAppBrandSysConfigLU.czd.lcS.ldv;
      break label316;
      label732:
      i = localAppBrandSysConfigLU.czd.lcM;
      break label358;
      label744:
      Log.w("", "getNetworkConfig, referrerHelper is null");
    }
  }
  
  public static com.tencent.mm.plugin.appbrand.a.a b(com.tencent.luggage.sdk.d.d paramd)
  {
    AppMethodBeat.i(229877);
    AppBrandSysConfigLU localAppBrandSysConfigLU = paramd.OM();
    paramd = paramd.getAppConfig();
    com.tencent.mm.plugin.appbrand.a.a locala = new com.tencent.mm.plugin.appbrand.a.a();
    if ((localAppBrandSysConfigLU == null) || (paramd == null))
    {
      AppMethodBeat.o(229877);
      return locala;
    }
    if (j.a.sE(localAppBrandSysConfigLU.leE.kNW)) {
      locala.kQF = paramd.lbS.contains("audio");
    }
    for (locala.kQG = paramd.lbS.contains("location");; locala.kQG = localAppBrandSysConfigLU.lez)
    {
      AppMethodBeat.o(229877);
      return locala;
      locala.kQF = localAppBrandSysConfigLU.ley;
    }
  }
  
  public static x.a b(AppBrandSysConfigLU paramAppBrandSysConfigLU)
  {
    AppMethodBeat.i(229878);
    x.a locala = new x.a();
    locala.ldb = paramAppBrandSysConfigLU.czd.ldb;
    AppMethodBeat.o(229878);
    return locala;
  }
  
  public static com.tencent.mm.plugin.appbrand.performance.a c(AppBrandSysConfigLU paramAppBrandSysConfigLU)
  {
    boolean bool2 = true;
    AppMethodBeat.i(229879);
    com.tencent.mm.plugin.appbrand.performance.a locala = new com.tencent.mm.plugin.appbrand.performance.a();
    if ((paramAppBrandSysConfigLU.cyD) && ((paramAppBrandSysConfigLU.leE.kNW == 1) || (paramAppBrandSysConfigLU.leE.kNW == 2) || (WeChatEnvironment.hasDebugger())))
    {
      bool1 = true;
      locala.nwy = bool1;
      if (paramAppBrandSysConfigLU.leE.kNW == 0) {
        break label96;
      }
    }
    label96:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.nwz = bool1;
      locala.nwA = paramAppBrandSysConfigLU.cyC;
      AppMethodBeat.o(229879);
      return locala;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.f
 * JD-Core Version:    0.7.0.1
 */