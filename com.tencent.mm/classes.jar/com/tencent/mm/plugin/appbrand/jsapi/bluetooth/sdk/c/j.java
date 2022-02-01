package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  public static final j lNA;
  public static final j lNB;
  public static final j lNC;
  public static final j lND;
  public static final j lNE;
  public static final j lNF;
  public static final j lNG;
  public static final j lNH;
  public static final j lNI;
  public static final j lNJ;
  public static final j lNK;
  public static final j lNL;
  public static final j lNM;
  public static final j lNN;
  public static final j lNu;
  public static final j lNv;
  public static final j lNw;
  public static final j lNx;
  public static final j lNy;
  public static final j lNz;
  public int errCode;
  public String errMsg;
  public final Object lNO;
  
  static
  {
    AppMethodBeat.i(144596);
    lNu = new j(0, "");
    lNv = new j(-1, "fail:internal error");
    lNw = new j(10000, "fail:not init");
    lNx = new j(10001, "fail:not available");
    lNy = new j(10002, "fail:no device");
    lNz = new j(10003, "fail:connection fail");
    lNA = new j(10004, "fail:no service");
    lNB = new j(10005, "fail:no characteristic");
    lNC = new j(10006, "fail:no connection");
    lND = new j(10007, "fail:property not support");
    lNE = new j(10008, "fail:system error");
    lNF = new j(10009, "fail:system not support");
    lNG = new j(10008, "fail:no descriptor");
    lNH = new j(10008, "fail:fail to set descriptor");
    lNI = new j(10008, "fail:fail to write descriptor");
    lNJ = new j(10012, "fail:operate time out");
    lNK = new j(-1, "fail:already connect");
    lNL = new j(10013, "fail:invalid data");
    lNM = new j(10008, "fail:not found service");
    lNN = new j(10014, "fail:need pin");
    AppMethodBeat.o(144596);
  }
  
  public j(int paramInt, String paramString)
  {
    this.errCode = paramInt;
    this.errMsg = paramString;
    this.lNO = null;
  }
  
  private j(String paramString, Object paramObject)
  {
    this.errCode = 0;
    this.errMsg = paramString;
    this.lNO = paramObject;
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
    String str = "Result{errCode=" + this.errCode + ", errMsg='" + this.errMsg + '\'' + ", retObj=" + this.lNO + '}';
    AppMethodBeat.o(144595);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j
 * JD-Core Version:    0.7.0.1
 */