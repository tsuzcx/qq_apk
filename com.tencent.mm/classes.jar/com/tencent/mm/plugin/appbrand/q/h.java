package com.tencent.mm.plugin.appbrand.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class h
{
  String hLO;
  Map<String, String> hLP;
  public volatile boolean isRunning;
  ArrayList<String> kVe;
  int kVf;
  HttpURLConnection kVh;
  String kVj;
  String kVs;
  Map<String, String> kVt;
  g.a kVu;
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
    this.kVf = 15;
    this.kVh = null;
    this.kVs = paramString1;
    this.mUrl = paramString2;
    this.kVu = parama;
    this.mName = paramString3;
    this.mFileName = paramString4;
    this.mTimeout = paramInt;
    this.mMimeType = paramString5;
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(144356);
  }
  
  public final int bio()
  {
    AppMethodBeat.i(144357);
    int i = (int)(System.currentTimeMillis() - this.startTime);
    AppMethodBeat.o(144357);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.h
 * JD-Core Version:    0.7.0.1
 */