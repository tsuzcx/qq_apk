package com.tencent.ilink.tdi;

import com.google.b.be.b;
import com.google.b.cl;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$a
  implements cl
{
  private static final be.b<a> bRT;
  private static final a[] cmK;
  final int value;
  
  static
  {
    AppMethodBeat.i(218381);
    cmB = new a("kFaceExtVerifyType_WxBase_Begin", 0, 0);
    cmC = new a("kFaceExtVerifyType_WxBase_4PhoneNum", 1, 1);
    cmD = new a("kFaceExtVerifyType_WxBase_End", 2, 999);
    cmE = new a("kFaceExtVerifyType_WxPay_Begin", 3, 1000);
    cmF = new a("kFaceExtVerifyType_WxPay_4PhoneNum", 4, 1001);
    cmG = new a("kFaceExtVerifyType_WxPay_WholePhoneNum", 5, 1002);
    cmH = new a("kFaceExtVerifyType_WxPay_QrCode", 6, 1003);
    cmI = new a("kFaceExtVerifyType_WxPay_FacePin", 7, 1004);
    cmJ = new a("kFaceExtVerifyType_WxPay_End", 8, 1999);
    cmL = new a[] { cmB, cmC, cmD, cmE, cmF, cmG, cmH, cmI, cmJ };
    bRT = new be.b() {};
    cmK = values();
    AppMethodBeat.o(218381);
  }
  
  private a$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  @Deprecated
  public static a ix(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return cmB;
    case 1: 
      return cmC;
    case 999: 
      return cmD;
    case 1000: 
      return cmE;
    case 1001: 
      return cmF;
    case 1002: 
      return cmG;
    case 1003: 
      return cmH;
    case 1004: 
      return cmI;
    }
    return cmJ;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ilink.tdi.a.a
 * JD-Core Version:    0.7.0.1
 */