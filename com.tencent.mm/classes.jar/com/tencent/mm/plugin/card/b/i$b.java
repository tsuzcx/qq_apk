package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class i$b
{
  String cLR;
  int dhP;
  String name;
  byte[] nqV;
  
  public i$b(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte)
  {
    this.cLR = paramString1;
    this.dhP = paramInt;
    this.name = paramString2;
    this.nqV = paramArrayOfByte;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(112656);
    String str = "SrvDeviceInfo{deviceId='" + this.cLR + '\'' + ", rssi=" + this.dhP + ", name='" + this.name + '\'' + ", manuData=" + Arrays.toString(this.nqV) + '}';
    AppMethodBeat.o(112656);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.i.b
 * JD-Core Version:    0.7.0.1
 */