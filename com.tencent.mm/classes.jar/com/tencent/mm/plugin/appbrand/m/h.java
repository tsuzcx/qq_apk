package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class h
{
  String hwp;
  int isQ;
  public volatile boolean isRunning;
  Map<String, String> isT;
  ArrayList<String> isU;
  int isV;
  HttpURLConnection isX;
  String isY;
  Map<String, String> ite;
  g.a itf;
  String mFileName;
  String mFilepath;
  String mMimeType;
  String mName;
  String mUrl;
  private long startTime;
  
  h(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, g.a parama)
  {
    AppMethodBeat.i(108178);
    this.isRunning = false;
    this.isV = 15;
    this.isX = null;
    this.mFilepath = paramString1;
    this.mUrl = paramString2;
    this.itf = parama;
    this.mName = paramString3;
    this.mFileName = paramString4;
    this.isQ = paramInt;
    this.mMimeType = paramString5;
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(108178);
  }
  
  public final int aIj()
  {
    AppMethodBeat.i(108179);
    int i = (int)(System.currentTimeMillis() - this.startTime);
    AppMethodBeat.o(108179);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.h
 * JD-Core Version:    0.7.0.1
 */