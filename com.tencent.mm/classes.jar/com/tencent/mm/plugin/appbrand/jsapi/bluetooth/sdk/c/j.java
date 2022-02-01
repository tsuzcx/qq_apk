package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  public static final j oJI;
  public static final j oJJ;
  public static final j oJK;
  public static final j oJL;
  public static final j oJM;
  public static final j oJN;
  public static final j oJO;
  public static final j oJP;
  public static final j oJQ;
  public static final j oJR;
  public static final j oJS;
  public static final j oJT;
  public static final j oJU;
  public static final j oJV;
  public static final j oJW;
  public static final j oJX;
  public static final j oJY;
  public static final j oJZ;
  public static final j oKa;
  public static final j oKb;
  public int errCode;
  public String errMsg;
  public final Object oKc;
  
  static
  {
    AppMethodBeat.i(144596);
    oJI = new j(0, "");
    oJJ = new j(-1, "fail:internal error");
    oJK = new j(10000, "fail:not init");
    oJL = new j(10001, "fail:not available");
    oJM = new j(10002, "fail:no device");
    oJN = new j(10003, "fail:connection fail");
    oJO = new j(10004, "fail:no service");
    oJP = new j(10005, "fail:no characteristic");
    oJQ = new j(10006, "fail:no connection");
    oJR = new j(10007, "fail:property not support");
    oJS = new j(10008, "fail:system error");
    oJT = new j(10009, "fail:system not support");
    oJU = new j(10008, "fail:no descriptor");
    oJV = new j(10008, "fail:fail to set descriptor");
    oJW = new j(10008, "fail:fail to write descriptor");
    oJX = new j(10012, "fail:operate time out");
    oJY = new j(-1, "fail:already connect");
    oJZ = new j(10013, "fail:invalid data");
    oKa = new j(10008, "fail:not found service");
    oKb = new j(10014, "fail:need pin");
    AppMethodBeat.o(144596);
  }
  
  public j(int paramInt, String paramString)
  {
    this.errCode = paramInt;
    this.errMsg = paramString;
    this.oKc = null;
  }
  
  private j(String paramString, Object paramObject)
  {
    this.errCode = 0;
    this.errMsg = paramString;
    this.oKc = paramObject;
  }
  
  public static j cF(Object paramObject)
  {
    AppMethodBeat.i(175631);
    paramObject = new j("", paramObject);
    AppMethodBeat.o(175631);
    return paramObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144595);
    String str = "Result{errCode=" + this.errCode + ", errMsg='" + this.errMsg + '\'' + ", retObj=" + this.oKc + '}';
    AppMethodBeat.o(144595);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j
 * JD-Core Version:    0.7.0.1
 */