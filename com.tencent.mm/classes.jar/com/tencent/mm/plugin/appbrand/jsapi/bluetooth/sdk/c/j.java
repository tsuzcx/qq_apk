package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  public static final j jJZ;
  public static final j jKa;
  public static final j jKb;
  public static final j jKc;
  public static final j jKd;
  public static final j jKe;
  public static final j jKf;
  public static final j jKg;
  public static final j jKh;
  public static final j jKi;
  public static final j jKj;
  public static final j jKk;
  public static final j jKl;
  public static final j jKm;
  public static final j jKn;
  public static final j jKo;
  public static final j jKp;
  public static final j jKq;
  public static final j jKr;
  public static final j jKs;
  public int errCode;
  public String errMsg;
  public final Object jKt;
  
  static
  {
    AppMethodBeat.i(144596);
    jJZ = new j(0, "");
    jKa = new j(-1, "fail:internal error");
    jKb = new j(10000, "fail:not init");
    jKc = new j(10001, "fail:not available");
    jKd = new j(10002, "fail:no device");
    jKe = new j(10003, "fail:connection fail");
    jKf = new j(10004, "fail:no service");
    jKg = new j(10005, "fail:no characteristic");
    jKh = new j(10006, "fail:no connection");
    jKi = new j(10007, "fail:property not support");
    jKj = new j(10008, "fail:system error");
    jKk = new j(10009, "fail:system not support");
    jKl = new j(10008, "fail:no descriptor");
    jKm = new j(10008, "fail:fail to set descriptor");
    jKn = new j(10008, "fail:fail to write descriptor");
    jKo = new j(10012, "fail:operate time out");
    jKp = new j(-1, "fail:already connect");
    jKq = new j(10013, "fail:invalid data");
    jKr = new j(10008, "fail:not found service");
    jKs = new j(10014, "fail:need pin");
    AppMethodBeat.o(144596);
  }
  
  public j(int paramInt, String paramString)
  {
    this.errCode = paramInt;
    this.errMsg = paramString;
    this.jKt = null;
  }
  
  private j(String paramString, Object paramObject)
  {
    this.errCode = 0;
    this.errMsg = paramString;
    this.jKt = paramObject;
  }
  
  public static j cv(Object paramObject)
  {
    AppMethodBeat.i(175631);
    paramObject = new j("", paramObject);
    AppMethodBeat.o(175631);
    return paramObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144595);
    String str = "Result{errCode=" + this.errCode + ", errMsg='" + this.errMsg + '\'' + ", retObj=" + this.jKt + '}';
    AppMethodBeat.o(144595);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j
 * JD-Core Version:    0.7.0.1
 */