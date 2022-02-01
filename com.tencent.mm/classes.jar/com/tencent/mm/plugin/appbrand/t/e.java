package com.tencent.mm.plugin.appbrand.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class e
{
  String eir;
  String mHost;
  int mPort;
  Runnable mRunnable;
  String mUrl;
  String ppa;
  Map<String, String> ppb;
  boolean ppj;
  boolean ppk;
  private long startTime;
  int tnN;
  byte[] tnO;
  d.a tnP;
  ArrayList<String> tnQ;
  int tnR;
  String tnS;
  HttpURLConnection tnT;
  String tnU;
  String tnV;
  boolean tnW;
  boolean tnX;
  boolean tnY;
  boolean tnZ;
  boolean toa;
  String tob;
  boolean toc;
  final boolean tod;
  
  public e(String paramString1, byte[] paramArrayOfByte, int paramInt1, d.a parama, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString3, int paramInt2, String paramString4, boolean paramBoolean5, boolean paramBoolean6)
  {
    AppMethodBeat.i(319169);
    this.tnR = 15;
    this.mRunnable = null;
    this.tnW = false;
    this.ppj = false;
    this.ppk = false;
    this.tnX = false;
    this.tnY = true;
    this.tnZ = false;
    this.toa = false;
    this.toc = false;
    this.mUrl = paramString1;
    this.tnO = paramArrayOfByte;
    this.tnP = parama;
    this.tnN = paramInt1;
    this.eir = paramString2;
    this.startTime = System.currentTimeMillis();
    this.ppj = paramBoolean1;
    this.ppk = paramBoolean2;
    this.tnZ = paramBoolean4;
    this.tnX = paramBoolean3;
    this.tob = paramString3;
    this.mPort = paramInt2;
    this.mHost = paramString4;
    this.toc = paramBoolean5;
    this.tod = paramBoolean6;
    AppMethodBeat.o(319169);
  }
  
  public final int cCj()
  {
    AppMethodBeat.i(144337);
    int i = (int)(System.currentTimeMillis() - this.startTime);
    AppMethodBeat.o(144337);
    return i;
  }
  
  public final long getDataSize()
  {
    if (this.tnO != null) {
      return this.tnO.length;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.e
 * JD-Core Version:    0.7.0.1
 */