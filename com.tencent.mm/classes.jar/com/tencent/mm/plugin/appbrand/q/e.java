package com.tencent.mm.plugin.appbrand.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class e
{
  String bZn;
  public String hLO;
  Map<String, String> hLP;
  boolean hLX;
  boolean hLY;
  d.a kVd;
  ArrayList<String> kVe;
  int kVf;
  String kVg;
  public HttpURLConnection kVh;
  public String kVi;
  String kVj;
  boolean kVk;
  boolean kVl;
  boolean kVm;
  byte[] mPostData;
  Runnable mRunnable;
  int mTimeout;
  String mUrl;
  private long startTime;
  
  public e(String paramString1, byte[] paramArrayOfByte, int paramInt, d.a parama, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(144336);
    this.kVf = 15;
    this.mRunnable = null;
    this.kVk = false;
    this.hLX = false;
    this.hLY = false;
    this.kVl = false;
    this.kVm = true;
    this.mUrl = paramString1;
    this.mPostData = paramArrayOfByte;
    this.kVd = parama;
    this.mTimeout = paramInt;
    this.bZn = paramString2;
    this.startTime = System.currentTimeMillis();
    this.hLX = paramBoolean1;
    this.hLY = paramBoolean2;
    this.kVl = paramBoolean3;
    AppMethodBeat.o(144336);
  }
  
  public final int bio()
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.e
 * JD-Core Version:    0.7.0.1
 */