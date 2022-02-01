package com.tencent.mm.plugin.appbrand.jsapi.y;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final b lnF;
  public static final b lnG;
  public static final b lnH;
  public static final b lnI;
  public static final b lnJ;
  public static final b lnK;
  public static final b lnL;
  public static final b lnM;
  public static final b lnN;
  public static final b lnO;
  public static final b lnP;
  public static final b lnQ;
  public static final b lnR;
  public static final b lnS;
  public static final b lnT;
  public static final b lnU;
  public static final b lnV;
  public static final b lnW;
  public static final b lnX;
  public static final b lnY;
  public static final b lnZ;
  public static final b loa;
  public static final b lob;
  public static final b lod;
  public static final b loe;
  public static final b lof;
  public static final b loh;
  public static final b loi;
  public static final b loj;
  public static final b lok;
  int errorCode;
  String errorMsg;
  
  static
  {
    AppMethodBeat.i(222683);
    lnF = new b(0, "ok");
    lnG = new b(10001, "Invalid parameters");
    lnH = new b(10002, "Network unavailable");
    lnI = new b(10003, "NFC not open");
    lnJ = new b(10004, "eSE unsupported");
    lnK = new b(10005, "Internal system error");
    lnL = new b(10006, "Permission not granted");
    lnM = new b(10007, "Huawei account is not logined");
    lnN = new b(10008, "The card is not supported");
    lnO = new b(10009, "Huawei pay is not default payment application");
    lnP = new b(10101, "Query CPLC failed");
    lnQ = new b(10102, "Total number of card out of max bounds");
    lnR = new b(10103, "The card already issued");
    lnS = new b(10104, "The card is issuing, can not retry issuing");
    lnT = new b(10105, "Huawei Pay unsupported by this ROM");
    lnU = new b(10106, "The wallet version too low");
    lnV = new b(10107, "The card can not issued");
    lnW = new b(10108, "The issue card service is unavailable");
    lnX = new b(10109, "The recharge service is unavailable");
    lnY = new b(10110, "Check traffic card conditions failed");
    lnZ = new b(10201, "Query traffic card info failed");
    loa = new b(10202, "The card is not issued");
    lob = new b(10203, "The card is issuing, can retry issuing");
    lod = new b(10204, "Huawei account is not correct");
    loe = new b(10301, "Issue card failed");
    lof = new b(10302, "The orderNo is used");
    loh = new b(10401, "Recharge traffic card failed");
    loi = new b(10501, "Set default card failed");
    loj = new b(10502, "Traffic card already set to default");
    lok = new b(99999, "Undefined error");
    AppMethodBeat.o(222683);
  }
  
  private b(int paramInt, String paramString)
  {
    this.errorCode = paramInt;
    this.errorMsg = paramString;
  }
  
  public static b ts(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return lok;
    case 10001: 
      return lnG;
    case 10002: 
      return lnH;
    case 10003: 
      return lnI;
    case 10004: 
    case 10005: 
    case 10008: 
    case 10205: 
    case 10804: 
      return lnL;
    case 10006: 
      return lnM;
    case 10007: 
      return lnJ;
    case 10009: 
      return lnN;
    case 10010: 
      return lnO;
    case 10099: 
      return lnK;
    case 10101: 
      return lnP;
    case 10201: 
    case 10801: 
    case 10901: 
      return loa;
    case 10202: 
      return lob;
    case 10203: 
    case 10299: 
      return lnZ;
    case 10204: 
    case 10602: 
    case 10803: 
      return lod;
    case 10301: 
      return lnW;
    case 10302: 
      return lnX;
    case 10401: 
      return lnT;
    case 10402: 
      return lnU;
    case 10403: 
      return lnV;
    case 10404: 
    case 10405: 
      return lnQ;
    case 10406: 
    case 10408: 
      return lnR;
    case 10407: 
    case 10502: 
      return lnS;
    case 10501: 
      return loe;
    case 10503: 
    case 10603: 
      return lof;
    case 10601: 
    case 10604: 
    case 10605: 
    case 10606: 
    case 10607: 
      return loh;
    case 10802: 
      return loj;
    }
    return loi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.b
 * JD-Core Version:    0.7.0.1
 */