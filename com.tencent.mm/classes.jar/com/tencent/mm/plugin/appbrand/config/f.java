package com.tencent.mm.plugin.appbrand.config;

import com.tencent.luggage.a.e;
import com.tencent.luggage.l.a.g;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.utils.z.a;
import com.tencent.mm.protocal.protobuf.cuu;
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
  private static final String cys;
  
  static
  {
    AppMethodBeat.i(234161);
    cys = WeChatHosts.domainString(a.g.host_servicewechat_com);
    AppMethodBeat.o(234161);
  }
  
  private static ArrayList<byte[]> Q(AppBrandRuntime paramAppBrandRuntime)
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
    localObject = com.tencent.mm.plugin.appbrand.ac.d.m((ByteBuffer)((i)localObject).value);
    try
    {
      paramAppBrandRuntime = new cuu();
      paramAppBrandRuntime.parseFrom((byte[])localObject);
      localObject = paramAppBrandRuntime.TCy;
      if (localObject == null)
      {
        AppMethodBeat.o(146963);
        return localArrayList;
      }
      paramAppBrandRuntime = paramAppBrandRuntime.TCy.iterator();
      while (paramAppBrandRuntime.hasNext()) {
        localArrayList.add(((com.tencent.mm.cd.b)paramAppBrandRuntime.next()).UH);
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
    locald.oRG = AppBrandGlobalSystemConfig.bLe().nWU;
    if (locald.oRG <= 0L) {
      locald.oRG = 300L;
    }
    locald.cxy = paramAppBrandSysConfigLU.cxy;
    if (locald.cxy <= 0L) {
      locald.cxy = 10L;
    }
    locald.cxw = paramAppBrandSysConfigLU.cxw;
    if (locald.cxw <= 0L) {
      locald.cxw = 300L;
    }
    locald.cxx = paramAppBrandSysConfigLU.cxx;
    if (locald.cxx <= 0L) {
      locald.cxx = 100L;
    }
    locald.nXu = paramAppBrandSysConfigLU.cxL.nXu;
    if (locald.nXu <= 0L) {
      locald.nXu = 30L;
    }
    AppMethodBeat.o(146964);
    return locald;
  }
  
  public static z.a b(AppBrandSysConfigLU paramAppBrandSysConfigLU)
  {
    AppMethodBeat.i(234154);
    z.a locala = new z.a();
    locala.nXk = paramAppBrandSysConfigLU.cxL.nXk;
    AppMethodBeat.o(234154);
    return locala;
  }
  
  public static com.tencent.mm.plugin.appbrand.performance.a c(AppBrandSysConfigLU paramAppBrandSysConfigLU)
  {
    boolean bool2 = true;
    AppMethodBeat.i(234158);
    com.tencent.mm.plugin.appbrand.performance.a locala = new com.tencent.mm.plugin.appbrand.performance.a();
    if ((paramAppBrandSysConfigLU.cxi) && ((paramAppBrandSysConfigLU.nYR.nHY == 1) || (paramAppBrandSysConfigLU.nYR.nHY == 2) || (WeChatEnvironment.hasDebugger())))
    {
      bool1 = true;
      locala.qyB = bool1;
      if (paramAppBrandSysConfigLU.nYR.nHY == 0) {
        break label94;
      }
    }
    label94:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.qyC = bool1;
      locala.qyD = paramAppBrandSysConfigLU.cxh;
      AppMethodBeat.o(234158);
      return locala;
      bool1 = false;
      break;
    }
  }
  
  public static com.tencent.mm.plugin.appbrand.s.a g(com.tencent.luggage.sdk.e.d paramd)
  {
    AppMethodBeat.i(234144);
    AppBrandInitConfigLU localAppBrandInitConfigLU = paramd.Sk();
    AppBrandSysConfigLU localAppBrandSysConfigLU = paramd.Sj();
    Object localObject = paramd.getAppConfig();
    com.tencent.mm.plugin.appbrand.s.a locala = new com.tencent.mm.plugin.appbrand.s.a();
    boolean bool;
    int i;
    if ((localAppBrandInitConfigLU.Qs()) || (localAppBrandInitConfigLU.Qv()))
    {
      bool = true;
      locala.qil = bool;
      if ((localAppBrandSysConfigLU.nYR.nHY != 1) && (localAppBrandSysConfigLU.nYR.nHY != 2)) {
        break label662;
      }
      i = 1;
      label81:
      if (!localAppBrandSysConfigLU.cwS) {
        break label672;
      }
      if ((i != 0) && (localAppBrandSysConfigLU.cxj)) {
        break label667;
      }
      bool = true;
      label103:
      locala.qim = bool;
      i = ((b)localObject).nVX.gaR;
      if (i > 0) {
        locala.qin = i;
      }
      i = ((b)localObject).nVX.nWn;
      if (i > 0) {
        locala.qio = i;
      }
      i = ((b)localObject).nVX.nWo;
      if (i > 0) {
        locala.qip = i;
      }
      i = ((b)localObject).nVX.nWp;
      if (i > 0) {
        locala.qiq = i;
      }
      locala.cxp = localAppBrandSysConfigLU.cxp;
      locala.qir = localAppBrandSysConfigLU.cxs;
      locala.cxq = localAppBrandSysConfigLU.cxq;
      locala.cxr = localAppBrandSysConfigLU.cxr;
      locala.cxA = localAppBrandSysConfigLU.cxA;
      locala.cxB = localAppBrandSysConfigLU.cxB;
      locala.cxC = localAppBrandSysConfigLU.cxC;
      locala.cxD = localAppBrandSysConfigLU.cxD;
      locala.cxE = localAppBrandSysConfigLU.cxE;
      locala.cxF = localAppBrandSysConfigLU.cxF;
      if (localAppBrandSysConfigLU.cxL.nXb.mode != 1) {
        break label694;
      }
      if (localAppBrandSysConfigLU.cxL.nXb.nXH != null) {
        locala.qis = localAppBrandSysConfigLU.cxL.nXb.nXH;
      }
      label326:
      locala.mode = localAppBrandSysConfigLU.cxL.nXb.mode;
      locala.qiu = Q(paramd);
      if (!localAppBrandInitConfigLU.Qv()) {
        break label742;
      }
      i = localAppBrandSysConfigLU.cxL.nXn;
      label368:
      locala.nWV = i;
      locala.cxu = localAppBrandSysConfigLU.cxu;
      locala.cxv = localAppBrandSysConfigLU.cxv;
      String str = j.bLl();
      locala.qiv = s.Y(MMApplicationContext.getContext(), str);
      Log.i("Luggage.FULL.AppBrandConfigAdapter", "runtime(%s).getNetworkConfig.userAgentString = [ %s ]", new Object[] { paramd.mAppId, locala.qiv });
      paramd = (com.tencent.mm.plugin.appbrand.jsapi.v.a)e.K(com.tencent.mm.plugin.appbrand.jsapi.v.a.class);
      if (paramd == null) {
        break label754;
      }
      locala.qiw = paramd.aix(((b)localObject).lzT);
    }
    for (;;)
    {
      localObject = "";
      paramd = (com.tencent.luggage.sdk.e.d)localObject;
      if (localAppBrandSysConfigLU.cxL != null)
      {
        paramd = (com.tencent.luggage.sdk.e.d)localObject;
        if (localAppBrandSysConfigLU.cxL.nXb != null) {
          paramd = localAppBrandSysConfigLU.cxL.nXb.nXN;
        }
      }
      localObject = paramd;
      if (Util.isNullOrNil(paramd)) {
        localObject = cys;
      }
      paramd = new StringBuilder();
      paramd.append("https://");
      paramd.append((String)localObject);
      paramd.append("/");
      paramd.append(localAppBrandSysConfigLU.appId);
      paramd.append("/");
      paramd.append(localAppBrandSysConfigLU.nYR.pkgVersion);
      paramd.append("/page-frame.html");
      locala.referer = paramd.toString();
      locala.cwS = localAppBrandInitConfigLU.cwS;
      locala.qix = j.a.vB(localAppBrandSysConfigLU.nYR.nHY);
      if ((locala.qix) || (!Util.isNullOrNil(locala.qiu))) {
        com.tencent.mm.plugin.appbrand.s.j.b(locala);
      }
      AppMethodBeat.o(234144);
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
      if ((i == 0) || (!localAppBrandSysConfigLU.cxh))
      {
        bool = true;
        break label103;
      }
      bool = false;
      break label103;
      label694:
      if ((localAppBrandSysConfigLU.cxL.nXb.mode != 2) || (localAppBrandSysConfigLU.cxL.nXb.nXI == null)) {
        break label326;
      }
      locala.qit = localAppBrandSysConfigLU.cxL.nXb.nXI;
      break label326;
      label742:
      i = localAppBrandSysConfigLU.cxL.nWV;
      break label368;
      label754:
      Log.w("", "getNetworkConfig, referrerHelper is null");
    }
  }
  
  public static com.tencent.mm.plugin.appbrand.a.a h(com.tencent.luggage.sdk.e.d paramd)
  {
    AppMethodBeat.i(234147);
    AppBrandSysConfigLU localAppBrandSysConfigLU = paramd.Sj();
    paramd = paramd.getAppConfig();
    com.tencent.mm.plugin.appbrand.a.a locala = new com.tencent.mm.plugin.appbrand.a.a();
    if ((localAppBrandSysConfigLU == null) || (paramd == null))
    {
      AppMethodBeat.o(234147);
      return locala;
    }
    if (j.a.vB(localAppBrandSysConfigLU.nYR.nHY)) {
      locala.nKN = paramd.nWb.contains("audio");
    }
    for (locala.nKO = paramd.nWb.contains("location");; locala.nKO = localAppBrandSysConfigLU.nYM)
    {
      AppMethodBeat.o(234147);
      return locala;
      locala.nKN = localAppBrandSysConfigLU.nYL;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.f
 * JD-Core Version:    0.7.0.1
 */