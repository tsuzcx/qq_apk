package com.tencent.mm.plugin.appbrand.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class h
{
  String iFB;
  Map<String, String> iFC;
  public volatile boolean isRunning;
  ArrayList<String> lWb;
  int lWc;
  HttpURLConnection lWe;
  String lWg;
  String lWp;
  Map<String, String> lWq;
  g.a lWr;
  String mFileName;
  String mMimeType;
  String mName;
  int mTimeout;
  String mUrl;
  private long startTime;
  
  h(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, g.a parama)
  {
    AppMethodBeat.i(144356);
    this.isRunning = false;
    this.lWc = 15;
    this.lWe = null;
    this.lWp = paramString1;
    this.mUrl = paramString2;
    this.lWr = parama;
    this.mName = paramString3;
    this.mFileName = paramString4;
    this.mTimeout = paramInt;
    this.mMimeType = paramString5;
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(144356);
  }
  
  public final int bth()
  {
    AppMethodBeat.i(144357);
    int i = (int)(System.currentTimeMillis() - this.startTime);
    AppMethodBeat.o(144357);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.h
 * JD-Core Version:    0.7.0.1
 */