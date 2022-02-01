package com.tencent.ilink.tdi;

import com.google.b.be.b;
import com.google.b.cl;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$b
  implements cl
{
  private static final be.b<b> bRT;
  private static final b[] cmQ;
  final int value;
  
  static
  {
    AppMethodBeat.i(217617);
    cmM = new b("kFaceRecognizeTypeRes_Non", 0, 0);
    cmN = new b("kFaceRecognizeTypeRes_WxPay", 1, 1);
    cmO = new b("kFaceRecognizeTypeRes_WxBase", 2, 2);
    cmP = new b("kFaceRecognizeTypeRes_WxPayBaseAll", 3, 3);
    cmR = new b[] { cmM, cmN, cmO, cmP };
    bRT = new be.b() {};
    cmQ = values();
    AppMethodBeat.o(217617);
  }
  
  private a$b(int paramInt)
  {
    this.value = paramInt;
  }
  
  @Deprecated
  public static b iy(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return cmM;
    case 1: 
      return cmN;
    case 2: 
      return cmO;
    }
    return cmP;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ilink.tdi.a.b
 * JD-Core Version:    0.7.0.1
 */