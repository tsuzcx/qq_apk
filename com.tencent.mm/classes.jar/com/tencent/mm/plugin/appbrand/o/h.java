package com.tencent.mm.plugin.appbrand.o;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class h
{
  int gRb;
  Map<String, String> gRe;
  ArrayList<String> gRf;
  int gRg = 15;
  HttpURLConnection gRi = null;
  String gRj;
  String gRp;
  Map<String, String> gRq;
  g.a gRr;
  String gep;
  public volatile boolean isRunning = false;
  String mFileName;
  String mMimeType;
  String mName;
  String mUrl;
  private long startTime;
  
  h(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, g.a parama)
  {
    this.gRp = paramString1;
    this.mUrl = paramString2;
    this.gRr = parama;
    this.mName = paramString3;
    this.mFileName = paramString4;
    this.gRb = paramInt;
    this.mMimeType = paramString5;
    this.startTime = System.currentTimeMillis();
  }
  
  public final int amF()
  {
    return (int)(System.currentTimeMillis() - this.startTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.h
 * JD-Core Version:    0.7.0.1
 */