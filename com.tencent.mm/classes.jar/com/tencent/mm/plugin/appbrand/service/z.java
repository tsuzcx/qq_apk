package com.tencent.mm.plugin.appbrand.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.e;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/service/PRELOAD_SCENE;", "", "reportKeyInvoke", "", "reportKeyInvokeApplied", "(Ljava/lang/String;III)V", "getReportKeyInvoke", "()I", "getReportKeyInvokeApplied", "DEFAULT", "TEST_ONLY", "ACCOUNT_INIT", "APP_FOREGROUND", "APPBRAND_PROCESS_RESTART", "APPBRAND_RUNTIME_PRELOAD_NEXT", "MAIN_PULLDOWN", "APPBRAND_LAUNCHER", "SYNC_WXA_ATTRS_ON_APP_LAUNCH", "WXA_JSAPI_PRELOAD", "H5_JSAPI_PRELOAD", "QRCODE_LONG_PRESS", "OPEN_SDK_API_PRELOAD", "SNS_AD", "WXA_JSAPI_BATCH_PRELOAD", "FINDER_LIVING", "FIND_MORE_ENTRANCE_EXPOSED", "PRE_LAUNCH_REDIRECTING_PAGE", "FIND_MORE_NEARBY", "CHATTING_WEISHI", "KF_GUIDE", "BIZ_TIME_LINE", "SEARCH_WEAPP", "Companion", "api-protocol_release"})
public enum z
{
  public static final a nMV;
  public final int nMT;
  public final int nMU;
  
  static
  {
    AppMethodBeat.i(194324);
    z localz1 = new z("DEFAULT", 0, 21, 22);
    nMv = localz1;
    z localz2 = new z("TEST_ONLY", 1, 23, 24);
    nMw = localz2;
    z localz3 = new z("ACCOUNT_INIT", 2, 25, 26);
    nMx = localz3;
    z localz4 = new z("APP_FOREGROUND", 3, 27, 28);
    nMy = localz4;
    z localz5 = new z("APPBRAND_PROCESS_RESTART", 4, 29, 30);
    nMz = localz5;
    z localz6 = new z("APPBRAND_RUNTIME_PRELOAD_NEXT", 5, 31, 32);
    nMA = localz6;
    z localz7 = new z("MAIN_PULLDOWN", 6, 33, 34);
    nMB = localz7;
    z localz8 = new z("APPBRAND_LAUNCHER", 7, 35, 36);
    nMC = localz8;
    z localz9 = new z("SYNC_WXA_ATTRS_ON_APP_LAUNCH", 8, 37, 38);
    nMD = localz9;
    z localz10 = new z("WXA_JSAPI_PRELOAD", 9, 39, 40);
    nME = localz10;
    z localz11 = new z("H5_JSAPI_PRELOAD", 10, 41, 42);
    nMF = localz11;
    z localz12 = new z("QRCODE_LONG_PRESS", 11, 43, 44);
    nMG = localz12;
    z localz13 = new z("OPEN_SDK_API_PRELOAD", 12, 45, 46);
    nMH = localz13;
    z localz14 = new z("SNS_AD", 13, 47, 48);
    nMI = localz14;
    z localz15 = new z("WXA_JSAPI_BATCH_PRELOAD", 14, 49, 50);
    nMJ = localz15;
    z localz16 = new z("FINDER_LIVING", 15, 51, 52);
    nMK = localz16;
    z localz17 = new z("FIND_MORE_ENTRANCE_EXPOSED", 16, 53, 54);
    nML = localz17;
    z localz18 = new z("PRE_LAUNCH_REDIRECTING_PAGE", 17, 55, 56);
    nMM = localz18;
    z localz19 = new z("FIND_MORE_NEARBY", 18, 57, 58);
    nMN = localz19;
    z localz20 = new z("CHATTING_WEISHI", 19, 59, 60);
    nMO = localz20;
    z localz21 = new z("KF_GUIDE", 20, 61, 62);
    nMP = localz21;
    z localz22 = new z("BIZ_TIME_LINE", 21, 63, 64);
    nMQ = localz22;
    z localz23 = new z("SEARCH_WEAPP", 22, 65, 66);
    nMR = localz23;
    nMS = new z[] { localz1, localz2, localz3, localz4, localz5, localz6, localz7, localz8, localz9, localz10, localz11, localz12, localz13, localz14, localz15, localz16, localz17, localz18, localz19, localz20, localz21, localz22, localz23 };
    nMV = new a((byte)0);
    AppMethodBeat.o(194324);
  }
  
  private z(int paramInt1, int paramInt2)
  {
    this.nMT = paramInt1;
    this.nMU = paramInt2;
  }
  
  public static final boolean d(z paramz)
  {
    AppMethodBeat.i(194327);
    boolean bool = a.d(paramz);
    AppMethodBeat.o(194327);
    return bool;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/service/PRELOAD_SCENE$Companion;", "", "()V", "shouldIgnoreFrequencyLimit", "", "scene", "Lcom/tencent/mm/plugin/appbrand/service/PRELOAD_SCENE;", "api-protocol_release"})
  public static final class a
  {
    public static boolean d(z paramz)
    {
      AppMethodBeat.i(194323);
      if (paramz == null)
      {
        AppMethodBeat.o(194323);
        return false;
      }
      if (e.contains(new z[] { z.nMx, z.nMy, z.nMB, z.nMC, z.nMD, z.nMw }, paramz))
      {
        AppMethodBeat.o(194323);
        return true;
      }
      AppMethodBeat.o(194323);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.z
 * JD-Core Version:    0.7.0.1
 */