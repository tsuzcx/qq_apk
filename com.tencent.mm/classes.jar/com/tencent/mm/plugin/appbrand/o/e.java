package com.tencent.mm.plugin.appbrand.o;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class e
{
  String bhw;
  int gRb;
  byte[] gRc;
  d.a gRd;
  Map<String, String> gRe;
  ArrayList<String> gRf;
  int gRg = 15;
  String gRh;
  HttpURLConnection gRi;
  String gRj;
  String gep;
  String mUrl;
  private long startTime;
  
  public e(String paramString1, byte[] paramArrayOfByte, int paramInt, d.a parama, String paramString2)
  {
    this.mUrl = paramString1;
    this.gRc = paramArrayOfByte;
    this.gRd = parama;
    this.gRb = paramInt;
    this.bhw = paramString2;
    this.startTime = System.currentTimeMillis();
  }
  
  public final int amF()
  {
    return (int)(System.currentTimeMillis() - this.startTime);
  }
  
  public final long getDataSize()
  {
    if (this.gRc != null) {
      return this.gRc.length;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.e
 * JD-Core Version:    0.7.0.1
 */