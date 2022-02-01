package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  public static final j kkA;
  public static final j kkB;
  public static final j kkC;
  public static final j kkD;
  public static final j kkE;
  public static final j kkF;
  public static final j kkG;
  public static final j kkH;
  public static final j kkI;
  public static final j kkJ;
  public static final j kkK;
  public static final j kkL;
  public static final j kkM;
  public static final j kkN;
  public static final j kkO;
  public static final j kkP;
  public static final j kkQ;
  public static final j kkR;
  public static final j kkS;
  public static final j kkT;
  public int errCode;
  public String errMsg;
  public final Object kkU;
  
  static
  {
    AppMethodBeat.i(144596);
    kkA = new j(0, "");
    kkB = new j(-1, "fail:internal error");
    kkC = new j(10000, "fail:not init");
    kkD = new j(10001, "fail:not available");
    kkE = new j(10002, "fail:no device");
    kkF = new j(10003, "fail:connection fail");
    kkG = new j(10004, "fail:no service");
    kkH = new j(10005, "fail:no characteristic");
    kkI = new j(10006, "fail:no connection");
    kkJ = new j(10007, "fail:property not support");
    kkK = new j(10008, "fail:system error");
    kkL = new j(10009, "fail:system not support");
    kkM = new j(10008, "fail:no descriptor");
    kkN = new j(10008, "fail:fail to set descriptor");
    kkO = new j(10008, "fail:fail to write descriptor");
    kkP = new j(10012, "fail:operate time out");
    kkQ = new j(-1, "fail:already connect");
    kkR = new j(10013, "fail:invalid data");
    kkS = new j(10008, "fail:not found service");
    kkT = new j(10014, "fail:need pin");
    AppMethodBeat.o(144596);
  }
  
  public j(int paramInt, String paramString)
  {
    this.errCode = paramInt;
    this.errMsg = paramString;
    this.kkU = null;
  }
  
  private j(String paramString, Object paramObject)
  {
    this.errCode = 0;
    this.errMsg = paramString;
    this.kkU = paramObject;
  }
  
  public static j ct(Object paramObject)
  {
    AppMethodBeat.i(175631);
    paramObject = new j("", paramObject);
    AppMethodBeat.o(175631);
    return paramObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144595);
    String str = "Result{errCode=" + this.errCode + ", errMsg='" + this.errMsg + '\'' + ", retObj=" + this.kkU + '}';
    AppMethodBeat.o(144595);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j
 * JD-Core Version:    0.7.0.1
 */