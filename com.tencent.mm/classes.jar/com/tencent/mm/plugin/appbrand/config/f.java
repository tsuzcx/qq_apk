package com.tencent.mm.plugin.appbrand.config;

import com.tencent.luggage.a.e;
import com.tencent.luggage.m.a.g;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.t.i;
import com.tencent.mm.plugin.appbrand.utils.ae.a;
import com.tencent.mm.protocal.protobuf.dma;
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
  private static final String eqM;
  
  static
  {
    AppMethodBeat.i(323423);
    eqM = WeChatHosts.domainString(a.g.host_servicewechat_com);
    AppMethodBeat.o(323423);
  }
  
  private static ArrayList<byte[]> U(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146963);
    localArrayList = new ArrayList();
    Object localObject = new com.tencent.mm.plugin.appbrand.af.k();
    paramAppBrandRuntime.getFileSystem().b("cer", (com.tencent.mm.plugin.appbrand.af.k)localObject);
    if (((com.tencent.mm.plugin.appbrand.af.k)localObject).value == null)
    {
      AppMethodBeat.o(146963);
      return localArrayList;
    }
    localObject = com.tencent.mm.plugin.appbrand.af.d.s((ByteBuffer)((com.tencent.mm.plugin.appbrand.af.k)localObject).value);
    try
    {
      paramAppBrandRuntime = new dma();
      paramAppBrandRuntime.parseFrom((byte[])localObject);
      localObject = paramAppBrandRuntime.aaSe;
      if (localObject == null)
      {
        AppMethodBeat.o(146963);
        return localArrayList;
      }
      paramAppBrandRuntime = paramAppBrandRuntime.aaSe.iterator();
      while (paramAppBrandRuntime.hasNext()) {
        localArrayList.add(((com.tencent.mm.bx.b)paramAppBrandRuntime.next()).Op);
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
    locald.rXg = AppBrandGlobalSystemConfig.ckD().qWK;
    if (locald.rXg <= 0L) {
      locald.rXg = 300L;
    }
    locald.epQ = paramAppBrandSysConfigLU.epQ;
    if (locald.epQ <= 0L) {
      locald.epQ = 10L;
    }
    locald.epO = paramAppBrandSysConfigLU.epO;
    if (locald.epO <= 0L) {
      locald.epO = 300L;
    }
    locald.epP = paramAppBrandSysConfigLU.epP;
    if (locald.epP <= 0L) {
      locald.epP = 100L;
    }
    locald.qXk = paramAppBrandSysConfigLU.eqf.qXk;
    if (locald.qXk <= 0L) {
      locald.qXk = 30L;
    }
    AppMethodBeat.o(146964);
    return locald;
  }
  
  public static ae.a b(AppBrandSysConfigLU paramAppBrandSysConfigLU)
  {
    AppMethodBeat.i(323417);
    ae.a locala = new ae.a();
    locala.qXa = paramAppBrandSysConfigLU.eqf.qXa;
    AppMethodBeat.o(323417);
    return locala;
  }
  
  public static com.tencent.mm.plugin.appbrand.performance.a c(AppBrandSysConfigLU paramAppBrandSysConfigLU)
  {
    boolean bool2 = true;
    AppMethodBeat.i(323421);
    com.tencent.mm.plugin.appbrand.performance.a locala = new com.tencent.mm.plugin.appbrand.performance.a();
    if ((paramAppBrandSysConfigLU.epA) && ((paramAppBrandSysConfigLU.qYY.qHO == 1) || (paramAppBrandSysConfigLU.qYY.qHO == 2) || (WeChatEnvironment.hasDebugger())))
    {
      bool1 = true;
      locala.tDw = bool1;
      if (paramAppBrandSysConfigLU.qYY.qHO == 0) {
        break label94;
      }
    }
    label94:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.tDx = bool1;
      locala.tDy = paramAppBrandSysConfigLU.epz;
      AppMethodBeat.o(323421);
      return locala;
      bool1 = false;
      break;
    }
  }
  
  public static com.tencent.mm.plugin.appbrand.t.a g(com.tencent.luggage.sdk.e.d paramd)
  {
    AppMethodBeat.i(323403);
    AppBrandInitConfigLU localAppBrandInitConfigLU = paramd.asA();
    AppBrandSysConfigLU localAppBrandSysConfigLU = paramd.asz();
    Object localObject = paramd.getAppConfig();
    com.tencent.mm.plugin.appbrand.t.a locala = new com.tencent.mm.plugin.appbrand.t.a();
    boolean bool;
    int i;
    if ((localAppBrandInitConfigLU.aqC()) || (localAppBrandInitConfigLU.aqJ()))
    {
      bool = true;
      locala.tmX = bool;
      if ((localAppBrandSysConfigLU.qYY.qHO != 1) && (localAppBrandSysConfigLU.qYY.qHO != 2)) {
        break label662;
      }
      i = 1;
      label81:
      if (!localAppBrandSysConfigLU.eoX) {
        break label672;
      }
      if ((i != 0) && (localAppBrandSysConfigLU.epB)) {
        break label667;
      }
      bool = true;
      label103:
      locala.tmY = bool;
      i = ((b)localObject).qVH.ihb;
      if (i > 0) {
        locala.tmZ = i;
      }
      i = ((b)localObject).qVH.qVY;
      if (i > 0) {
        locala.tna = i;
      }
      i = ((b)localObject).qVH.qVZ;
      if (i > 0) {
        locala.tnb = i;
      }
      i = ((b)localObject).qVH.qWa;
      if (i > 0) {
        locala.tnc = i;
      }
      locala.epH = localAppBrandSysConfigLU.epH;
      locala.tnd = localAppBrandSysConfigLU.epK;
      locala.epI = localAppBrandSysConfigLU.epI;
      locala.epJ = localAppBrandSysConfigLU.epJ;
      locala.epU = localAppBrandSysConfigLU.epU;
      locala.epV = localAppBrandSysConfigLU.epV;
      locala.epW = localAppBrandSysConfigLU.epW;
      locala.epX = localAppBrandSysConfigLU.epX;
      locala.epY = localAppBrandSysConfigLU.epY;
      locala.epZ = localAppBrandSysConfigLU.epZ;
      if (localAppBrandSysConfigLU.eqf.qWR.mode != 1) {
        break label694;
      }
      if (localAppBrandSysConfigLU.eqf.qWR.qXB != null) {
        locala.tne = localAppBrandSysConfigLU.eqf.qWR.qXB;
      }
      label326:
      locala.mode = localAppBrandSysConfigLU.eqf.qWR.mode;
      locala.tng = U(paramd);
      if (!localAppBrandInitConfigLU.aqJ()) {
        break label742;
      }
      i = localAppBrandSysConfigLU.eqf.qXd;
      label368:
      locala.qWL = i;
      locala.epM = localAppBrandSysConfigLU.epM;
      locala.epN = localAppBrandSysConfigLU.epN;
      String str = k.ckJ();
      locala.tnh = v.Y(MMApplicationContext.getContext(), str);
      Log.i("Luggage.FULL.AppBrandConfigAdapter", "runtime(%s).getNetworkConfig.userAgentString = [ %s ]", new Object[] { paramd.mAppId, locala.tnh });
      paramd = (com.tencent.mm.plugin.appbrand.jsapi.y.a)e.T(com.tencent.mm.plugin.appbrand.jsapi.y.a.class);
      if (paramd == null) {
        break label754;
      }
      locala.tni = paramd.abv(((b)localObject).oru);
    }
    for (;;)
    {
      localObject = "";
      paramd = (com.tencent.luggage.sdk.e.d)localObject;
      if (localAppBrandSysConfigLU.eqf != null)
      {
        paramd = (com.tencent.luggage.sdk.e.d)localObject;
        if (localAppBrandSysConfigLU.eqf.qWR != null) {
          paramd = localAppBrandSysConfigLU.eqf.qWR.qXH;
        }
      }
      localObject = paramd;
      if (Util.isNullOrNil(paramd)) {
        localObject = eqM;
      }
      paramd = new StringBuilder();
      paramd.append("https://");
      paramd.append((String)localObject);
      paramd.append("/");
      paramd.append(localAppBrandSysConfigLU.appId);
      paramd.append("/");
      paramd.append(localAppBrandSysConfigLU.qYY.pkgVersion);
      paramd.append("/page-frame.html");
      locala.referer = paramd.toString();
      locala.eoX = localAppBrandInitConfigLU.eoX;
      locala.tnj = k.a.vK(localAppBrandSysConfigLU.qYY.qHO);
      if ((locala.tnj) || (!Util.isNullOrNil(locala.tng))) {
        i.b(locala);
      }
      AppMethodBeat.o(323403);
      return locala;
      bool = false;
      break;
      label662:
      i = 0;
      break label81;
      label667:
      bool = false;
      break label103;
      label672:
      if ((i == 0) || (!localAppBrandSysConfigLU.epz))
      {
        bool = true;
        break label103;
      }
      bool = false;
      break label103;
      label694:
      if ((localAppBrandSysConfigLU.eqf.qWR.mode != 2) || (localAppBrandSysConfigLU.eqf.qWR.qXC == null)) {
        break label326;
      }
      locala.tnf = localAppBrandSysConfigLU.eqf.qWR.qXC;
      break label326;
      label742:
      i = localAppBrandSysConfigLU.eqf.qWL;
      break label368;
      label754:
      Log.w("", "getNetworkConfig, referrerHelper is null");
    }
  }
  
  public static com.tencent.mm.plugin.appbrand.b.a h(com.tencent.luggage.sdk.e.d paramd)
  {
    AppMethodBeat.i(323406);
    AppBrandSysConfigLU localAppBrandSysConfigLU = paramd.asz();
    paramd = paramd.getAppConfig();
    com.tencent.mm.plugin.appbrand.b.a locala = new com.tencent.mm.plugin.appbrand.b.a();
    if ((localAppBrandSysConfigLU == null) || (paramd == null))
    {
      AppMethodBeat.o(323406);
      return locala;
    }
    if (k.a.vK(localAppBrandSysConfigLU.qYY.qHO))
    {
      locala.qKt = paramd.qVL.contains("audio");
      locala.qKu = paramd.qVL.contains("location");
    }
    for (locala.qKv = paramd.qVL.contains("bluetooth");; locala.qKv = localAppBrandSysConfigLU.qYT)
    {
      AppMethodBeat.o(323406);
      return locala;
      locala.qKt = localAppBrandSysConfigLU.qYR;
      locala.qKu = localAppBrandSysConfigLU.qYS;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.f
 * JD-Core Version:    0.7.0.1
 */