package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  public static final j hGN;
  public static final j hGO;
  public static final j hGP;
  public static final j hGQ;
  public static final j hGR;
  public static final j hGS;
  public static final j hGT;
  public static final j hGU;
  public static final j hGV;
  public static final j hGW;
  public static final j hGX;
  public static final j hGY;
  public static final j hGZ;
  public static final j hHa;
  public static final j hHb;
  public static final j hHc;
  public static final j hHd;
  public static final j hHe;
  public static final j hHf;
  public int errCode;
  public String errMsg;
  
  static
  {
    AppMethodBeat.i(94284);
    hGN = new j(0, "");
    hGO = new j(-1, "fail:internal error");
    hGP = new j(10000, "fail:not init");
    hGQ = new j(10001, "fail:not available");
    hGR = new j(10002, "fail:no device");
    hGS = new j(10003, "fail:connection fail");
    hGT = new j(10004, "fail:no service");
    hGU = new j(10005, "fail:no characteristic");
    hGV = new j(10006, "fail:no connection");
    hGW = new j(10007, "fail:property not support");
    hGX = new j(10008, "fail:system error");
    hGY = new j(10009, "fail:system not support");
    hGZ = new j(10008, "fail:no descriptor");
    hHa = new j(10008, "fail:fail to set descriptor");
    hHb = new j(10008, "fail:fail to write descriptor");
    hHc = new j(10012, "fail:operate time out");
    hHd = new j(-1, "fail:already connect");
    hHe = new j(10013, "fail:invalid data");
    hHf = new j(10008, "fail:not found service");
    AppMethodBeat.o(94284);
  }
  
  public j(int paramInt, String paramString)
  {
    this.errCode = paramInt;
    this.errMsg = paramString;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(94283);
    String str = "Result{errCode=" + this.errCode + ", errMsg='" + this.errMsg + '\'' + '}';
    AppMethodBeat.o(94283);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j
 * JD-Core Version:    0.7.0.1
 */