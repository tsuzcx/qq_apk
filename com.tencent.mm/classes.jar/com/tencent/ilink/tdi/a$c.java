package com.tencent.ilink.tdi;

import com.google.b.be.b;
import com.google.b.cl;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$c
  implements cl
{
  private static final be.b<c> bRT;
  private static final c[] cmX;
  final int value;
  
  static
  {
    AppMethodBeat.i(218378);
    cmS = new c("kLoginQrCodeStatus_NoScan", 0, 0);
    cmT = new c("kLoginQrCodeStatus_Scaned", 1, 1);
    cmU = new c("kLoginQrCodeStatus_Confirmed", 2, 2);
    cmV = new c("kLoginQrCodeStatus_Canceled", 3, 3);
    cmW = new c("kLoginQrCodeStatus_Expired", 4, 4);
    cmY = new c[] { cmS, cmT, cmU, cmV, cmW };
    bRT = new be.b() {};
    cmX = values();
    AppMethodBeat.o(218378);
  }
  
  private a$c(int paramInt)
  {
    this.value = paramInt;
  }
  
  @Deprecated
  public static c iz(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return cmS;
    case 1: 
      return cmT;
    case 2: 
      return cmU;
    case 3: 
      return cmV;
    }
    return cmW;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ilink.tdi.a.c
 * JD-Core Version:    0.7.0.1
 */