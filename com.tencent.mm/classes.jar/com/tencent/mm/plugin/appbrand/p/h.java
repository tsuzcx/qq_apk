package com.tencent.mm.plugin.appbrand.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class h
{
  String imk;
  Map<String, String> iml;
  public volatile boolean isRunning;
  ArrayList<String> lwO;
  int lwP;
  HttpURLConnection lwR;
  String lwT;
  String lxc;
  Map<String, String> lxd;
  g.a lxe;
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
    this.lwP = 15;
    this.lwR = null;
    this.lxc = paramString1;
    this.mUrl = paramString2;
    this.lxe = parama;
    this.mName = paramString3;
    this.mFileName = paramString4;
    this.mTimeout = paramInt;
    this.mMimeType = paramString5;
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(144356);
  }
  
  public final int bpi()
  {
    AppMethodBeat.i(144357);
    int i = (int)(System.currentTimeMillis() - this.startTime);
    AppMethodBeat.o(144357);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.h
 * JD-Core Version:    0.7.0.1
 */