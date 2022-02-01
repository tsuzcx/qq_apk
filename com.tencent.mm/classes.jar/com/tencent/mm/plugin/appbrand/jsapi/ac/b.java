package com.tencent.mm.plugin.appbrand.jsapi.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class b
{
  public static final HashMap<Integer, b> psA;
  public static final b psB;
  public static final b psC;
  public static final b psD;
  public static final b psE;
  public static final b psF;
  public static final b psG;
  public static final b psH;
  public static final b psI;
  public static final b psJ;
  public static final b psK;
  public static final b psL;
  public static final b psM;
  public static final b psN;
  public static final b psO;
  public static final b psP;
  public static final b psQ;
  public static final b psR;
  public static final b psS;
  public static final b psT;
  public static final b psU;
  public static final b psV;
  public static final b psW;
  public static final b psX;
  public static final b psY;
  public static final b psZ;
  public static final b pta;
  public static final b ptb;
  public static final b ptc;
  public static final b ptd;
  public static final b pte;
  public static final b ptf;
  public static final b ptg;
  public static final b pth;
  public static final b pti;
  public static final b ptj;
  public static final b ptk;
  public static final b ptl;
  public static final b ptm;
  public static final b ptn;
  int errorCode;
  String errorMsg;
  
  static
  {
    AppMethodBeat.i(283439);
    psA = new HashMap();
    psB = new b(0, "ok");
    psC = new b(10001, "Invalid parameters");
    psD = new b(10002, "Network unavailable");
    psE = new b(10003, "NFC not open");
    psF = new b(10004, "eSE unsupported");
    psG = new b(10005, "Internal system error");
    psH = new b(10006, "Permission not granted");
    psI = new b(10007, "The wallet account is not logined.");
    psJ = new b(10008, "The card is not supported");
    psK = new b(10009, "The wallet pay is not default payment application");
    psL = new b(10010, "NFC is not supported on this device.");
    psM = new b(10011, "Sign failed");
    psN = new b(10012, "Time out error.");
    psO = new b(10013, "The login state is invalid.");
    psP = new b(10101, "Query CPLC failed");
    psQ = new b(10102, "Total number of card out of max bounds");
    psR = new b(10103, "The card already issued");
    psS = new b(10104, "The card is issuing, can not retry issuing");
    psT = new b(10105, "The Wallet Pay unsupported by this ROM");
    psU = new b(10106, "The wallet version too low");
    psV = new b(10107, "The card can not issued");
    psW = new b(10108, "The issue card service is unavailable");
    psX = new b(10109, "The recharge service is unavailable");
    psY = new b(10110, "Check traffic card conditions failed");
    psZ = new b(10201, "Query traffic card info failed");
    pta = new b(10202, "The card is not issued");
    ptb = new b(10203, "The card is issuing, can retry issuing");
    ptc = new b(10204, "The wallet account is not correct");
    ptd = new b(10205, "The card is shifting.");
    pte = new b(10206, "The card is deleting, can not perform querying info.");
    ptf = new b(10301, "Issue card failed");
    ptg = new b(10302, "The orderNo is used");
    pth = new b(10401, "Recharge traffic card failed");
    pti = new b(10501, "Set default card failed");
    ptj = new b(10502, "Traffic card already set to default");
    ptk = new b(10601, "Delete card failed.");
    ptl = new b(10602, "The card is deleting.");
    ptm = new b(10603, "Delete service unavailable.");
    ptn = new b(99999, "Undefined error");
    psA.put(Integer.valueOf(psB.errorCode), psB);
    psA.put(Integer.valueOf(psC.errorCode), psC);
    psA.put(Integer.valueOf(psD.errorCode), psD);
    psA.put(Integer.valueOf(psE.errorCode), psE);
    psA.put(Integer.valueOf(psF.errorCode), psF);
    psA.put(Integer.valueOf(psG.errorCode), psG);
    psA.put(Integer.valueOf(psH.errorCode), psH);
    psA.put(Integer.valueOf(psI.errorCode), psI);
    psA.put(Integer.valueOf(psJ.errorCode), psJ);
    psA.put(Integer.valueOf(psK.errorCode), psK);
    psA.put(Integer.valueOf(psP.errorCode), psP);
    psA.put(Integer.valueOf(psQ.errorCode), psQ);
    psA.put(Integer.valueOf(psR.errorCode), psR);
    psA.put(Integer.valueOf(psS.errorCode), psS);
    psA.put(Integer.valueOf(psT.errorCode), psT);
    psA.put(Integer.valueOf(psU.errorCode), psU);
    psA.put(Integer.valueOf(psV.errorCode), psV);
    psA.put(Integer.valueOf(psW.errorCode), psW);
    psA.put(Integer.valueOf(psX.errorCode), psX);
    psA.put(Integer.valueOf(psY.errorCode), psY);
    psA.put(Integer.valueOf(psZ.errorCode), psZ);
    psA.put(Integer.valueOf(pta.errorCode), pta);
    psA.put(Integer.valueOf(ptb.errorCode), ptb);
    psA.put(Integer.valueOf(ptc.errorCode), ptc);
    psA.put(Integer.valueOf(ptf.errorCode), ptf);
    psA.put(Integer.valueOf(ptg.errorCode), ptg);
    psA.put(Integer.valueOf(pth.errorCode), pth);
    psA.put(Integer.valueOf(pti.errorCode), pti);
    psA.put(Integer.valueOf(ptj.errorCode), ptj);
    psA.put(Integer.valueOf(psL.errorCode), psL);
    psA.put(Integer.valueOf(psM.errorCode), psM);
    psA.put(Integer.valueOf(psN.errorCode), psN);
    psA.put(Integer.valueOf(ptd.errorCode), ptd);
    psA.put(Integer.valueOf(psO.errorCode), psO);
    psA.put(Integer.valueOf(ptk.errorCode), ptk);
    psA.put(Integer.valueOf(ptl.errorCode), ptl);
    psA.put(Integer.valueOf(ptm.errorCode), ptm);
    psA.put(Integer.valueOf(pte.errorCode), pte);
    AppMethodBeat.o(283439);
  }
  
  private b(int paramInt, String paramString)
  {
    this.errorCode = paramInt;
    this.errorMsg = paramString;
  }
  
  public static b AM(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return ptn;
    case 10001: 
      return psC;
    case 10002: 
      return psD;
    case 10003: 
      return psE;
    case 10004: 
    case 10005: 
    case 10008: 
    case 10205: 
    case 10804: 
      return psH;
    case 10006: 
      return psI;
    case 10007: 
      return psF;
    case 10009: 
      return psJ;
    case 10010: 
      return psK;
    case 10099: 
      return psG;
    case 10101: 
      return psP;
    case 10201: 
    case 10801: 
    case 10901: 
      return pta;
    case 10202: 
      return ptb;
    case 10203: 
    case 10208: 
    case 10299: 
      return psZ;
    case 10204: 
    case 10602: 
    case 10702: 
    case 10803: 
      return ptc;
    case 10207: 
      return pte;
    case 10301: 
      return psW;
    case 10302: 
      return psX;
    case 10401: 
      return psT;
    case 10402: 
      return psU;
    case 10403: 
      return psV;
    case 10404: 
    case 10405: 
      return psQ;
    case 10406: 
    case 10408: 
      return psR;
    case 10407: 
    case 10502: 
      return psS;
    case 10501: 
      return ptf;
    case 10503: 
    case 10603: 
      return ptg;
    case 10601: 
    case 10604: 
    case 10605: 
    case 10606: 
    case 10607: 
      return pth;
    case 10802: 
      return ptj;
    case 10805: 
      return pti;
    case 10701: 
      return ptk;
    }
    return ptm;
  }
  
  public static b AN(int paramInt)
  {
    AppMethodBeat.i(283436);
    b localb2 = (b)psA.get(Integer.valueOf(paramInt));
    b localb1 = localb2;
    if (localb2 == null) {
      localb1 = ptn;
    }
    AppMethodBeat.o(283436);
    return localb1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.b
 * JD-Core Version:    0.7.0.1
 */