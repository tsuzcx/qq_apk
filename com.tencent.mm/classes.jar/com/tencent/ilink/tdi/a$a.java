package com.tencent.ilink.tdi;

import com.google.d.bj.d;
import com.google.d.cw;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$a
  implements cw
{
  private static final bj.d<a> dLG;
  private static final a[] edQ;
  final int value;
  
  static
  {
    AppMethodBeat.i(213998);
    edH = new a("kFaceExtVerifyType_WxBase_Begin", 0, 0);
    edI = new a("kFaceExtVerifyType_WxBase_4PhoneNum", 1, 1);
    edJ = new a("kFaceExtVerifyType_WxBase_End", 2, 999);
    edK = new a("kFaceExtVerifyType_WxPay_Begin", 3, 1000);
    edL = new a("kFaceExtVerifyType_WxPay_4PhoneNum", 4, 1001);
    edM = new a("kFaceExtVerifyType_WxPay_WholePhoneNum", 5, 1002);
    edN = new a("kFaceExtVerifyType_WxPay_QrCode", 6, 1003);
    edO = new a("kFaceExtVerifyType_WxPay_FacePin", 7, 1004);
    edP = new a("kFaceExtVerifyType_WxPay_End", 8, 1999);
    edR = new a[] { edH, edI, edJ, edK, edL, edM, edN, edO, edP };
    dLG = new bj.d() {};
    edQ = values();
    AppMethodBeat.o(213998);
  }
  
  private a$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  @Deprecated
  public static a mc(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return edH;
    case 1: 
      return edI;
    case 999: 
      return edJ;
    case 1000: 
      return edK;
    case 1001: 
      return edL;
    case 1002: 
      return edM;
    case 1003: 
      return edN;
    case 1004: 
      return edO;
    }
    return edP;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ilink.tdi.a.a
 * JD-Core Version:    0.7.0.1
 */