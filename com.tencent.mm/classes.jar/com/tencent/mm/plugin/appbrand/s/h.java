package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class h
{
  public volatile boolean isRunning;
  String mFileName;
  String mMimeType;
  String mName;
  int mTimeout;
  String mUrl;
  String mvB;
  Map<String, String> mvC;
  ArrayList<String> qjb;
  int qjc;
  HttpURLConnection qje;
  String qjg;
  String qjr;
  Map<String, String> qjs;
  g.a qjt;
  private long startTime;
  
  h(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, g.a parama)
  {
    AppMethodBeat.i(144356);
    this.isRunning = false;
    this.qjc = 15;
    this.qje = null;
    this.qjr = paramString1;
    this.mUrl = paramString2;
    this.qjt = parama;
    this.mName = paramString3;
    this.mFileName = paramString4;
    this.mTimeout = paramInt;
    this.mMimeType = paramString5;
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(144356);
  }
  
  public final int cbQ()
  {
    AppMethodBeat.i(144357);
    int i = (int)(System.currentTimeMillis() - this.startTime);
    AppMethodBeat.o(144357);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.h
 * JD-Core Version:    0.7.0.1
 */