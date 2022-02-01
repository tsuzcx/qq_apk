package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class e
{
  String cqz;
  String mHost;
  int mPort;
  byte[] mPostData;
  Runnable mRunnable;
  int mTimeout;
  String mUrl;
  String mvB;
  Map<String, String> mvC;
  boolean mvK;
  boolean mvL;
  d.a qja;
  ArrayList<String> qjb;
  int qjc;
  String qjd;
  HttpURLConnection qje;
  String qjf;
  String qjg;
  boolean qjh;
  boolean qji;
  boolean qjj;
  String qjk;
  boolean qjl;
  private long startTime;
  
  public e(String paramString1, byte[] paramArrayOfByte, int paramInt1, d.a parama, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3, int paramInt2, String paramString4, boolean paramBoolean4)
  {
    AppMethodBeat.i(186638);
    this.qjc = 15;
    this.mRunnable = null;
    this.qjh = false;
    this.mvK = false;
    this.mvL = false;
    this.qji = false;
    this.qjj = true;
    this.qjl = false;
    this.mUrl = paramString1;
    this.mPostData = paramArrayOfByte;
    this.qja = parama;
    this.mTimeout = paramInt1;
    this.cqz = paramString2;
    this.startTime = System.currentTimeMillis();
    this.mvK = paramBoolean1;
    this.mvL = paramBoolean2;
    this.qji = paramBoolean3;
    this.qjk = paramString3;
    this.mPort = paramInt2;
    this.mHost = paramString4;
    this.qjl = paramBoolean4;
    AppMethodBeat.o(186638);
  }
  
  public final int cbQ()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.e
 * JD-Core Version:    0.7.0.1
 */