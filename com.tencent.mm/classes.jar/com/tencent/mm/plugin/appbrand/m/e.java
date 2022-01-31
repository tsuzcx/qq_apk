package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class e
{
  String bxW;
  String hwp;
  int isQ;
  byte[] isR;
  d.a isS;
  Map<String, String> isT;
  ArrayList<String> isU;
  int isV;
  String isW;
  HttpURLConnection isX;
  String isY;
  String mUrl;
  private long startTime;
  
  public e(String paramString1, byte[] paramArrayOfByte, int paramInt, d.a parama, String paramString2)
  {
    AppMethodBeat.i(108159);
    this.isV = 15;
    this.mUrl = paramString1;
    this.isR = paramArrayOfByte;
    this.isS = parama;
    this.isQ = paramInt;
    this.bxW = paramString2;
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(108159);
  }
  
  public final int aIj()
  {
    AppMethodBeat.i(108160);
    int i = (int)(System.currentTimeMillis() - this.startTime);
    AppMethodBeat.o(108160);
    return i;
  }
  
  public final long getDataSize()
  {
    if (this.isR != null) {
      return this.isR.length;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.e
 * JD-Core Version:    0.7.0.1
 */