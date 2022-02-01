package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  public static final j kIP;
  public static final j kIQ;
  public static final j kIR;
  public static final j kIS;
  public static final j kIT;
  public static final j kIU;
  public static final j kIV;
  public static final j kIW;
  public static final j kIX;
  public static final j kIY;
  public static final j kIZ;
  public static final j kJa;
  public static final j kJb;
  public static final j kJc;
  public static final j kJd;
  public static final j kJe;
  public static final j kJf;
  public static final j kJg;
  public static final j kJh;
  public static final j kJi;
  public int errCode;
  public String errMsg;
  public final Object kJj;
  
  static
  {
    AppMethodBeat.i(144596);
    kIP = new j(0, "");
    kIQ = new j(-1, "fail:internal error");
    kIR = new j(10000, "fail:not init");
    kIS = new j(10001, "fail:not available");
    kIT = new j(10002, "fail:no device");
    kIU = new j(10003, "fail:connection fail");
    kIV = new j(10004, "fail:no service");
    kIW = new j(10005, "fail:no characteristic");
    kIX = new j(10006, "fail:no connection");
    kIY = new j(10007, "fail:property not support");
    kIZ = new j(10008, "fail:system error");
    kJa = new j(10009, "fail:system not support");
    kJb = new j(10008, "fail:no descriptor");
    kJc = new j(10008, "fail:fail to set descriptor");
    kJd = new j(10008, "fail:fail to write descriptor");
    kJe = new j(10012, "fail:operate time out");
    kJf = new j(-1, "fail:already connect");
    kJg = new j(10013, "fail:invalid data");
    kJh = new j(10008, "fail:not found service");
    kJi = new j(10014, "fail:need pin");
    AppMethodBeat.o(144596);
  }
  
  public j(int paramInt, String paramString)
  {
    this.errCode = paramInt;
    this.errMsg = paramString;
    this.kJj = null;
  }
  
  private j(String paramString, Object paramObject)
  {
    this.errCode = 0;
    this.errMsg = paramString;
    this.kJj = paramObject;
  }
  
  public static j cw(Object paramObject)
  {
    AppMethodBeat.i(175631);
    paramObject = new j("", paramObject);
    AppMethodBeat.o(175631);
    return paramObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144595);
    String str = "Result{errCode=" + this.errCode + ", errMsg='" + this.errMsg + '\'' + ", retObj=" + this.kJj + '}';
    AppMethodBeat.o(144595);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j
 * JD-Core Version:    0.7.0.1
 */