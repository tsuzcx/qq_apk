package com.tencent.mm.plugin.appbrand.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class e
{
  String cgz;
  String iFB;
  Map<String, String> iFC;
  boolean iFK;
  boolean iFL;
  d.a lWa;
  ArrayList<String> lWb;
  int lWc;
  String lWd;
  HttpURLConnection lWe;
  String lWf;
  String lWg;
  boolean lWh;
  boolean lWi;
  boolean lWj;
  byte[] mPostData;
  Runnable mRunnable;
  int mTimeout;
  String mUrl;
  private long startTime;
  
  public e(String paramString1, byte[] paramArrayOfByte, int paramInt, d.a parama, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(144336);
    this.lWc = 15;
    this.mRunnable = null;
    this.lWh = false;
    this.iFK = false;
    this.iFL = false;
    this.lWi = false;
    this.lWj = true;
    this.mUrl = paramString1;
    this.mPostData = paramArrayOfByte;
    this.lWa = parama;
    this.mTimeout = paramInt;
    this.cgz = paramString2;
    this.startTime = System.currentTimeMillis();
    this.iFK = paramBoolean1;
    this.iFL = paramBoolean2;
    this.lWi = paramBoolean3;
    AppMethodBeat.o(144336);
  }
  
  public final int bth()
  {
    AppMethodBeat.i(144337);
    int i = (int)(System.currentTimeMillis() - this.startTime);
    AppMethodBeat.o(144337);
    return i;
  }
  
  public final long getDataSize()
  {
    if (this.mPostData != null) {
      return this.mPostData.length;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.e
 * JD-Core Version:    0.7.0.1
 */