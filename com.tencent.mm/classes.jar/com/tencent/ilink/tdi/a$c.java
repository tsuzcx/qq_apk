package com.tencent.ilink.tdi;

import com.google.d.bj.d;
import com.google.d.cw;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$c
  implements cw
{
  private static final bj.d<c> dLG;
  private static final c[] eed;
  final int value;
  
  static
  {
    AppMethodBeat.i(213996);
    edY = new c("kLoginQrCodeStatus_NoScan", 0, 0);
    edZ = new c("kLoginQrCodeStatus_Scaned", 1, 1);
    eea = new c("kLoginQrCodeStatus_Confirmed", 2, 2);
    eeb = new c("kLoginQrCodeStatus_Canceled", 3, 3);
    eec = new c("kLoginQrCodeStatus_Expired", 4, 4);
    eee = new c[] { edY, edZ, eea, eeb, eec };
    dLG = new bj.d() {};
    eed = values();
    AppMethodBeat.o(213996);
  }
  
  private a$c(int paramInt)
  {
    this.value = paramInt;
  }
  
  @Deprecated
  public static c me(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return edY;
    case 1: 
      return edZ;
    case 2: 
      return eea;
    case 3: 
      return eeb;
    }
    return eec;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ilink.tdi.a.c
 * JD-Core Version:    0.7.0.1
 */