package com.tencent.mm.plugin.appbrand.jsapi.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final b muA;
  public static final b muB;
  public static final b muC;
  public static final b muD;
  public static final b muE;
  public static final b muF;
  public static final b muG;
  public static final b muH;
  public static final b muI;
  public static final b muJ;
  public static final b muK;
  public static final b muL;
  public static final b muM;
  public static final b muN;
  public static final b muO;
  public static final b muP;
  public static final b muQ;
  public static final b mun;
  public static final b muo;
  public static final b mup;
  public static final b muq;
  public static final b mur;
  public static final b mus;
  public static final b mut;
  public static final b muu;
  public static final b muv;
  public static final b muw;
  public static final b mux;
  public static final b muy;
  public static final b muz;
  int errorCode;
  String errorMsg;
  
  static
  {
    AppMethodBeat.i(226994);
    mun = new b(0, "ok");
    muo = new b(10001, "Invalid parameters");
    mup = new b(10002, "Network unavailable");
    muq = new b(10003, "NFC not open");
    mur = new b(10004, "eSE unsupported");
    mus = new b(10005, "Internal system error");
    mut = new b(10006, "Permission not granted");
    muu = new b(10007, "Huawei account is not logined");
    muv = new b(10008, "The card is not supported");
    muw = new b(10009, "Huawei pay is not default payment application");
    mux = new b(10101, "Query CPLC failed");
    muy = new b(10102, "Total number of card out of max bounds");
    muz = new b(10103, "The card already issued");
    muA = new b(10104, "The card is issuing, can not retry issuing");
    muB = new b(10105, "Huawei Pay unsupported by this ROM");
    muC = new b(10106, "The wallet version too low");
    muD = new b(10107, "The card can not issued");
    muE = new b(10108, "The issue card service is unavailable");
    muF = new b(10109, "The recharge service is unavailable");
    muG = new b(10110, "Check traffic card conditions failed");
    muH = new b(10201, "Query traffic card info failed");
    muI = new b(10202, "The card is not issued");
    muJ = new b(10203, "The card is issuing, can retry issuing");
    muK = new b(10204, "Huawei account is not correct");
    muL = new b(10301, "Issue card failed");
    muM = new b(10302, "The orderNo is used");
    muN = new b(10401, "Recharge traffic card failed");
    muO = new b(10501, "Set default card failed");
    muP = new b(10502, "Traffic card already set to default");
    muQ = new b(99999, "Undefined error");
    AppMethodBeat.o(226994);
  }
  
  private b(int paramInt, String paramString)
  {
    this.errorCode = paramInt;
    this.errorMsg = paramString;
  }
  
  public static b xq(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return muQ;
    case 10001: 
      return muo;
    case 10002: 
      return mup;
    case 10003: 
      return muq;
    case 10004: 
    case 10005: 
    case 10008: 
    case 10205: 
    case 10804: 
      return mut;
    case 10006: 
      return muu;
    case 10007: 
      return mur;
    case 10009: 
      return muv;
    case 10010: 
      return muw;
    case 10099: 
      return mus;
    case 10101: 
      return mux;
    case 10201: 
    case 10801: 
    case 10901: 
      return muI;
    case 10202: 
      return muJ;
    case 10203: 
    case 10299: 
      return muH;
    case 10204: 
    case 10602: 
    case 10803: 
      return muK;
    case 10301: 
      return muE;
    case 10302: 
      return muF;
    case 10401: 
      return muB;
    case 10402: 
      return muC;
    case 10403: 
      return muD;
    case 10404: 
    case 10405: 
      return muy;
    case 10406: 
    case 10408: 
      return muz;
    case 10407: 
    case 10502: 
      return muA;
    case 10501: 
      return muL;
    case 10503: 
    case 10603: 
      return muM;
    case 10601: 
    case 10604: 
    case 10605: 
    case 10606: 
    case 10607: 
      return muN;
    case 10802: 
      return muP;
    }
    return muO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.b
 * JD-Core Version:    0.7.0.1
 */