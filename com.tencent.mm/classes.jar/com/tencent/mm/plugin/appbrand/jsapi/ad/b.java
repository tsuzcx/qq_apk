package com.tencent.mm.plugin.appbrand.jsapi.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final b mSY;
  public static final b mSZ;
  public static final b mTa;
  public static final b naU;
  public static final b naW;
  public static final b naY;
  public static final b nbA;
  public static final b nbB;
  public static final b nbC;
  public static final b nba;
  public static final b nbb;
  public static final b nbc;
  public static final b nbd;
  public static final b nbe;
  public static final b nbf;
  public static final b nbg;
  public static final b nbh;
  public static final b nbi;
  public static final b nbk;
  public static final b nbl;
  public static final b nbm;
  public static final b nbn;
  public static final b nbo;
  public static final b nbp;
  public static final b nbq;
  public static final b nbr;
  public static final b nbs;
  public static final b nbx;
  public static final b nby;
  public static final b nbz;
  int errorCode;
  String errorMsg;
  
  static
  {
    AppMethodBeat.i(221287);
    mSY = new b(0, "ok");
    mSZ = new b(10001, "Invalid parameters");
    mTa = new b(10002, "Network unavailable");
    naU = new b(10003, "NFC not open");
    naW = new b(10004, "eSE unsupported");
    naY = new b(10005, "Internal system error");
    nba = new b(10006, "Permission not granted");
    nbb = new b(10007, "Huawei account is not logined");
    nbc = new b(10008, "The card is not supported");
    nbd = new b(10009, "Huawei pay is not default payment application");
    nbe = new b(10101, "Query CPLC failed");
    nbf = new b(10102, "Total number of card out of max bounds");
    nbg = new b(10103, "The card already issued");
    nbh = new b(10104, "The card is issuing, can not retry issuing");
    nbi = new b(10105, "Huawei Pay unsupported by this ROM");
    nbk = new b(10106, "The wallet version too low");
    nbl = new b(10107, "The card can not issued");
    nbm = new b(10108, "The issue card service is unavailable");
    nbn = new b(10109, "The recharge service is unavailable");
    nbo = new b(10110, "Check traffic card conditions failed");
    nbp = new b(10201, "Query traffic card info failed");
    nbq = new b(10202, "The card is not issued");
    nbr = new b(10203, "The card is issuing, can retry issuing");
    nbs = new b(10204, "Huawei account is not correct");
    nbx = new b(10301, "Issue card failed");
    nby = new b(10302, "The orderNo is used");
    nbz = new b(10401, "Recharge traffic card failed");
    nbA = new b(10501, "Set default card failed");
    nbB = new b(10502, "Traffic card already set to default");
    nbC = new b(99999, "Undefined error");
    AppMethodBeat.o(221287);
  }
  
  private b(int paramInt, String paramString)
  {
    this.errorCode = paramInt;
    this.errorMsg = paramString;
  }
  
  public static b wk(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return nbC;
    case 10001: 
      return mSZ;
    case 10002: 
      return mTa;
    case 10003: 
      return naU;
    case 10004: 
    case 10005: 
    case 10008: 
    case 10205: 
    case 10804: 
      return nba;
    case 10006: 
      return nbb;
    case 10007: 
      return naW;
    case 10009: 
      return nbc;
    case 10010: 
      return nbd;
    case 10099: 
      return naY;
    case 10101: 
      return nbe;
    case 10201: 
    case 10801: 
    case 10901: 
      return nbq;
    case 10202: 
      return nbr;
    case 10203: 
    case 10299: 
      return nbp;
    case 10204: 
    case 10602: 
    case 10803: 
      return nbs;
    case 10301: 
      return nbm;
    case 10302: 
      return nbn;
    case 10401: 
      return nbi;
    case 10402: 
      return nbk;
    case 10403: 
      return nbl;
    case 10404: 
    case 10405: 
      return nbf;
    case 10406: 
    case 10408: 
      return nbg;
    case 10407: 
    case 10502: 
      return nbh;
    case 10501: 
      return nbx;
    case 10503: 
    case 10603: 
      return nby;
    case 10601: 
    case 10604: 
    case 10605: 
    case 10606: 
    case 10607: 
      return nbz;
    case 10802: 
      return nbB;
    }
    return nbA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.b
 * JD-Core Version:    0.7.0.1
 */