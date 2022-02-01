package com.tencent.mm.plugin.card.mgr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class h$b
{
  String hEl;
  String name;
  int rssi;
  byte[] wsc;
  
  public h$b(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte)
  {
    this.hEl = paramString1;
    this.rssi = paramInt;
    this.name = paramString2;
    this.wsc = paramArrayOfByte;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(112656);
    String str = "SrvDeviceInfo{deviceId='" + this.hEl + '\'' + ", rssi=" + this.rssi + ", name='" + this.name + '\'' + ", manuData=" + Arrays.toString(this.wsc) + '}';
    AppMethodBeat.o(112656);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.mgr.h.b
 * JD-Core Version:    0.7.0.1
 */