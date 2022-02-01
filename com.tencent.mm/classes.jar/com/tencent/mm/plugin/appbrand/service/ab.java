package com.tencent.mm.plugin.appbrand.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.a.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/service/PRELOAD_SCENE;", "", "reportKeyInvoke", "", "reportKeyInvokeApplied", "(Ljava/lang/String;III)V", "getReportKeyInvoke", "()I", "getReportKeyInvokeApplied", "DEFAULT", "TEST_ONLY", "ACCOUNT_INIT", "APP_FOREGROUND", "APPBRAND_PROCESS_RESTART", "APPBRAND_RUNTIME_PRELOAD_NEXT", "MAIN_PULLDOWN", "APPBRAND_LAUNCHER", "SYNC_WXA_ATTRS_ON_APP_LAUNCH", "WXA_JSAPI_PRELOAD", "H5_JSAPI_PRELOAD", "QRCODE_LONG_PRESS", "OPEN_SDK_API_PRELOAD", "SNS_AD", "WXA_JSAPI_BATCH_PRELOAD", "FINDER_LIVING", "FIND_MORE_ENTRANCE_EXPOSED", "PRE_LAUNCH_REDIRECTING_PAGE", "FIND_MORE_NEARBY", "CHATTING_WEISHI", "KF_GUIDE", "BIZ_TIME_LINE", "SEARCH_WEAPP", "TEXT_STATUS", "WALLET", "CARD_PACKAGE", "CHATTING_APPMSG", "SCAN_CODE_FOR_WXA", "FINDER_AD", "CHATTING_LUCKY_BAG", "Companion", "api-protocol_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum ab
{
  public static final a tTB;
  public final int tTC;
  public final int tTD;
  
  static
  {
    AppMethodBeat.i(321557);
    tTE = new ab("DEFAULT", 0, 21, 22);
    tTF = new ab("TEST_ONLY", 1, 23, 24);
    tTG = new ab("ACCOUNT_INIT", 2, 25, 26);
    tTH = new ab("APP_FOREGROUND", 3, 27, 28);
    tTI = new ab("APPBRAND_PROCESS_RESTART", 4, 29, 30);
    tTJ = new ab("APPBRAND_RUNTIME_PRELOAD_NEXT", 5, 31, 32);
    tTK = new ab("MAIN_PULLDOWN", 6, 33, 34);
    tTL = new ab("APPBRAND_LAUNCHER", 7, 35, 36);
    tTM = new ab("SYNC_WXA_ATTRS_ON_APP_LAUNCH", 8, 37, 38);
    tTN = new ab("WXA_JSAPI_PRELOAD", 9, 39, 40);
    tTO = new ab("H5_JSAPI_PRELOAD", 10, 41, 42);
    tTP = new ab("QRCODE_LONG_PRESS", 11, 43, 44);
    tTQ = new ab("OPEN_SDK_API_PRELOAD", 12, 45, 46);
    tTR = new ab("SNS_AD", 13, 47, 48);
    tTS = new ab("WXA_JSAPI_BATCH_PRELOAD", 14, 49, 50);
    tTT = new ab("FINDER_LIVING", 15, 51, 52);
    tTU = new ab("FIND_MORE_ENTRANCE_EXPOSED", 16, 53, 54);
    tTV = new ab("PRE_LAUNCH_REDIRECTING_PAGE", 17, 55, 56);
    tTW = new ab("FIND_MORE_NEARBY", 18, 57, 58);
    tTX = new ab("CHATTING_WEISHI", 19, 59, 60);
    tTY = new ab("KF_GUIDE", 20, 61, 62);
    tTZ = new ab("BIZ_TIME_LINE", 21, 63, 64);
    tUa = new ab("SEARCH_WEAPP", 22, 65, 66);
    tUb = new ab("TEXT_STATUS", 23, 67, 68);
    tUc = new ab("WALLET", 24, 69, 70);
    tUd = new ab("CARD_PACKAGE", 25, 71, 72);
    tUe = new ab("CHATTING_APPMSG", 26, 73, 74);
    tUf = new ab("SCAN_CODE_FOR_WXA", 27, 75, 76);
    tUg = new ab("FINDER_AD", 28, 77, 78);
    tUh = new ab("CHATTING_LUCKY_BAG", 29, 79, 80);
    tUi = new ab[] { tTE, tTF, tTG, tTH, tTI, tTJ, tTK, tTL, tTM, tTN, tTO, tTP, tTQ, tTR, tTS, tTT, tTU, tTV, tTW, tTX, tTY, tTZ, tUa, tUb, tUc, tUd, tUe, tUf, tUg, tUh };
    tTB = new a((byte)0);
    AppMethodBeat.o(321557);
  }
  
  private ab(int paramInt1, int paramInt2)
  {
    this.tTC = paramInt1;
    this.tTD = paramInt2;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/service/PRELOAD_SCENE$Companion;", "", "()V", "shouldIgnoreFrequencyLimit", "", "scene", "Lcom/tencent/mm/plugin/appbrand/service/PRELOAD_SCENE;", "api-protocol_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean d(ab paramab)
    {
      AppMethodBeat.i(321534);
      if (paramab == null)
      {
        AppMethodBeat.o(321534);
        return false;
      }
      if (k.contains(new ab[] { ab.tTG, ab.tTH, ab.tTK, ab.tTL, ab.tTM, ab.tTF, ab.tTJ, ab.tTI }, paramab))
      {
        AppMethodBeat.o(321534);
        return true;
      }
      AppMethodBeat.o(321534);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.ab
 * JD-Core Version:    0.7.0.1
 */