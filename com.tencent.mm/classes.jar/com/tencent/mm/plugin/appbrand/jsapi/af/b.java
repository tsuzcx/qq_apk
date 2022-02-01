package com.tencent.mm.plugin.appbrand.jsapi.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class b
{
  public static final HashMap<Integer, b> sxM;
  public static final b sxN;
  public static final b sxO;
  public static final b sxP;
  public static final b sxQ;
  public static final b sxR;
  public static final b sxS;
  public static final b sxT;
  public static final b sxU;
  public static final b sxV;
  public static final b sxW;
  public static final b sxX;
  public static final b sxY;
  public static final b sxZ;
  public static final b syA;
  public static final b sya;
  public static final b syb;
  public static final b syc;
  public static final b syd;
  public static final b sye;
  public static final b syf;
  public static final b syg;
  public static final b syh;
  public static final b syi;
  public static final b syj;
  public static final b syk;
  public static final b syl;
  public static final b sym;
  public static final b syn;
  public static final b syo;
  public static final b syp;
  public static final b syq;
  public static final b syr;
  public static final b sys;
  public static final b syt;
  public static final b syu;
  public static final b syv;
  public static final b syw;
  public static final b syx;
  public static final b syy;
  public static final b syz;
  int errorCode;
  String errorMsg;
  
  static
  {
    AppMethodBeat.i(325920);
    sxM = new HashMap();
    sxN = new b(0, "ok");
    sxO = new b(10001, "Invalid parameters");
    sxP = new b(10002, "Network unavailable");
    sxQ = new b(10003, "NFC not open");
    sxR = new b(10004, "eSE unsupported");
    sxS = new b(10005, "Internal system error");
    sxT = new b(10006, "Permission not granted");
    sxU = new b(10007, "The wallet account is not logined.");
    sxV = new b(10008, "The card is not supported");
    sxW = new b(10009, "The wallet pay is not default payment application");
    sxX = new b(10010, "NFC is not supported on this device.");
    sxY = new b(10011, "Sign failed");
    sxZ = new b(10012, "Time out error.");
    sya = new b(10013, "The login state is invalid.");
    syb = new b(10101, "Query CPLC failed");
    syc = new b(10102, "Total number of card out of max bounds");
    syd = new b(10103, "The card already issued");
    sye = new b(10104, "The card is issuing, can not retry issuing");
    syf = new b(10105, "The Wallet Pay unsupported by this ROM");
    syg = new b(10106, "The wallet version too low");
    syh = new b(10107, "The card can not issued");
    syi = new b(10108, "The issue card service is unavailable");
    syj = new b(10109, "The recharge service is unavailable");
    syk = new b(10110, "Check traffic card conditions failed");
    syl = new b(10201, "Query traffic card info failed");
    sym = new b(10202, "The card is not issued");
    syn = new b(10203, "The card is issuing, can retry issuing");
    syo = new b(10204, "The wallet account is not correct");
    syp = new b(10205, "The card is shifting.");
    syq = new b(10206, "The card is deleting, can not perform querying info.");
    syr = new b(10207, "Card bound by a third party");
    sys = new b(10301, "Issue card failed");
    syt = new b(10302, "The orderNo is used");
    syu = new b(10401, "Recharge traffic card failed");
    syv = new b(10501, "Set default card failed");
    syw = new b(10502, "Traffic card already set to default");
    syx = new b(10601, "Delete card failed.");
    syy = new b(10602, "The card is deleting.");
    syz = new b(10603, "Delete service unavailable.");
    syA = new b(99999, "Undefined error");
    sxM.put(Integer.valueOf(sxN.errorCode), sxN);
    sxM.put(Integer.valueOf(sxO.errorCode), sxO);
    sxM.put(Integer.valueOf(sxP.errorCode), sxP);
    sxM.put(Integer.valueOf(sxQ.errorCode), sxQ);
    sxM.put(Integer.valueOf(sxR.errorCode), sxR);
    sxM.put(Integer.valueOf(sxS.errorCode), sxS);
    sxM.put(Integer.valueOf(sxT.errorCode), sxT);
    sxM.put(Integer.valueOf(sxU.errorCode), sxU);
    sxM.put(Integer.valueOf(sxV.errorCode), sxV);
    sxM.put(Integer.valueOf(sxW.errorCode), sxW);
    sxM.put(Integer.valueOf(syb.errorCode), syb);
    sxM.put(Integer.valueOf(syc.errorCode), syc);
    sxM.put(Integer.valueOf(syd.errorCode), syd);
    sxM.put(Integer.valueOf(sye.errorCode), sye);
    sxM.put(Integer.valueOf(syf.errorCode), syf);
    sxM.put(Integer.valueOf(syg.errorCode), syg);
    sxM.put(Integer.valueOf(syh.errorCode), syh);
    sxM.put(Integer.valueOf(syi.errorCode), syi);
    sxM.put(Integer.valueOf(syj.errorCode), syj);
    sxM.put(Integer.valueOf(syk.errorCode), syk);
    sxM.put(Integer.valueOf(syl.errorCode), syl);
    sxM.put(Integer.valueOf(sym.errorCode), sym);
    sxM.put(Integer.valueOf(syn.errorCode), syn);
    sxM.put(Integer.valueOf(syo.errorCode), syo);
    sxM.put(Integer.valueOf(sys.errorCode), sys);
    sxM.put(Integer.valueOf(syt.errorCode), syt);
    sxM.put(Integer.valueOf(syu.errorCode), syu);
    sxM.put(Integer.valueOf(syv.errorCode), syv);
    sxM.put(Integer.valueOf(syw.errorCode), syw);
    sxM.put(Integer.valueOf(sxX.errorCode), sxX);
    sxM.put(Integer.valueOf(sxY.errorCode), sxY);
    sxM.put(Integer.valueOf(sxZ.errorCode), sxZ);
    sxM.put(Integer.valueOf(syp.errorCode), syp);
    sxM.put(Integer.valueOf(sya.errorCode), sya);
    sxM.put(Integer.valueOf(syx.errorCode), syx);
    sxM.put(Integer.valueOf(syy.errorCode), syy);
    sxM.put(Integer.valueOf(syz.errorCode), syz);
    sxM.put(Integer.valueOf(syq.errorCode), syq);
    sxM.put(Integer.valueOf(syr.errorCode), syr);
    AppMethodBeat.o(325920);
  }
  
  private b(int paramInt, String paramString)
  {
    this.errorCode = paramInt;
    this.errorMsg = paramString;
  }
  
  public static b Bb(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return syA;
    case 10001: 
      return sxO;
    case 10002: 
      return sxP;
    case 10003: 
      return sxQ;
    case 10004: 
    case 10005: 
    case 10008: 
    case 10205: 
    case 10804: 
      return sxT;
    case 10006: 
      return sxU;
    case 10007: 
      return sxR;
    case 10009: 
      return sxV;
    case 10010: 
      return sxW;
    case 10099: 
      return sxS;
    case 10101: 
      return syb;
    case 10201: 
    case 10801: 
    case 10901: 
      return sym;
    case 10202: 
      return syn;
    case 10203: 
    case 10208: 
    case 10299: 
      return syl;
    case 10204: 
    case 10602: 
    case 10702: 
    case 10803: 
      return syo;
    case 10207: 
      return syq;
    case 10213: 
      return syr;
    case 10301: 
      return syi;
    case 10302: 
      return syj;
    case 10401: 
      return syf;
    case 10402: 
      return syg;
    case 10403: 
      return syh;
    case 10404: 
    case 10405: 
      return syc;
    case 10406: 
    case 10408: 
      return syd;
    case 10407: 
    case 10502: 
      return sye;
    case 10501: 
      return sys;
    case 10503: 
    case 10603: 
      return syt;
    case 10601: 
    case 10604: 
    case 10605: 
    case 10606: 
    case 10607: 
      return syu;
    case 10802: 
      return syw;
    case 10805: 
      return syv;
    case 10701: 
      return syx;
    }
    return syz;
  }
  
  public static b Bc(int paramInt)
  {
    AppMethodBeat.i(325913);
    b localb2 = (b)sxM.get(Integer.valueOf(paramInt));
    b localb1 = localb2;
    if (localb2 == null) {
      localb1 = syA;
    }
    AppMethodBeat.o(325913);
    return localb1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.af.b
 * JD-Core Version:    0.7.0.1
 */