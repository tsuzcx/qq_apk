package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class e
{
  String csu;
  String jEY;
  Map<String, String> jEZ;
  boolean jFh;
  boolean jFi;
  byte[] mPostData;
  Runnable mRunnable;
  int mTimeout;
  String mUrl;
  boolean niA;
  d.a nir;
  ArrayList<String> nis;
  int nit;
  String niu;
  HttpURLConnection niv;
  String niw;
  String nix;
  boolean niy;
  boolean niz;
  private long startTime;
  
  public e(String paramString1, byte[] paramArrayOfByte, int paramInt, d.a parama, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(144336);
    this.nit = 15;
    this.mRunnable = null;
    this.niy = false;
    this.jFh = false;
    this.jFi = false;
    this.niz = false;
    this.niA = true;
    this.mUrl = paramString1;
    this.mPostData = paramArrayOfByte;
    this.nir = parama;
    this.mTimeout = paramInt;
    this.csu = paramString2;
    this.startTime = System.currentTimeMillis();
    this.jFh = paramBoolean1;
    this.jFi = paramBoolean2;
    this.niz = paramBoolean3;
    AppMethodBeat.o(144336);
  }
  
  public final int bPz()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.e
 * JD-Core Version:    0.7.0.1
 */