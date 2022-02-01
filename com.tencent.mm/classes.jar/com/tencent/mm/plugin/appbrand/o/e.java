package com.tencent.mm.plugin.appbrand.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class e
{
  String cgz;
  boolean iID;
  boolean iIE;
  String iIu;
  Map<String, String> iIv;
  byte[] mPostData;
  Runnable mRunnable;
  int mTimeout;
  String mUrl;
  d.a maG;
  ArrayList<String> maH;
  int maI;
  String maJ;
  HttpURLConnection maK;
  String maL;
  String maM;
  boolean maN;
  boolean maO;
  boolean maP;
  private long startTime;
  
  public e(String paramString1, byte[] paramArrayOfByte, int paramInt, d.a parama, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(144336);
    this.maI = 15;
    this.mRunnable = null;
    this.maN = false;
    this.iID = false;
    this.iIE = false;
    this.maO = false;
    this.maP = true;
    this.mUrl = paramString1;
    this.mPostData = paramArrayOfByte;
    this.maG = parama;
    this.mTimeout = paramInt;
    this.cgz = paramString2;
    this.startTime = System.currentTimeMillis();
    this.iID = paramBoolean1;
    this.iIE = paramBoolean2;
    this.maO = paramBoolean3;
    AppMethodBeat.o(144336);
  }
  
  public final int btS()
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