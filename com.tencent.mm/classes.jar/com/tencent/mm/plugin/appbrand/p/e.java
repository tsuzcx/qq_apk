package com.tencent.mm.plugin.appbrand.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class e
{
  String bWk;
  public String imk;
  Map<String, String> iml;
  boolean imt;
  boolean imu;
  d.a lwN;
  ArrayList<String> lwO;
  int lwP;
  String lwQ;
  public HttpURLConnection lwR;
  public String lwS;
  String lwT;
  boolean lwU;
  boolean lwV;
  boolean lwW;
  byte[] mPostData;
  Runnable mRunnable;
  int mTimeout;
  String mUrl;
  private long startTime;
  
  public e(String paramString1, byte[] paramArrayOfByte, int paramInt, d.a parama, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(144336);
    this.lwP = 15;
    this.mRunnable = null;
    this.lwU = false;
    this.imt = false;
    this.imu = false;
    this.lwV = false;
    this.lwW = true;
    this.mUrl = paramString1;
    this.mPostData = paramArrayOfByte;
    this.lwN = parama;
    this.mTimeout = paramInt;
    this.bWk = paramString2;
    this.startTime = System.currentTimeMillis();
    this.imt = paramBoolean1;
    this.imu = paramBoolean2;
    this.lwV = paramBoolean3;
    AppMethodBeat.o(144336);
  }
  
  public final int bpi()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.e
 * JD-Core Version:    0.7.0.1
 */