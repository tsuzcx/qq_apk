package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  public static final j kFA;
  public static final j kFB;
  public static final j kFC;
  public static final j kFD;
  public static final j kFE;
  public static final j kFF;
  public static final j kFG;
  public static final j kFH;
  public static final j kFI;
  public static final j kFJ;
  public static final j kFK;
  public static final j kFL;
  public static final j kFM;
  public static final j kFN;
  public static final j kFO;
  public static final j kFP;
  public static final j kFQ;
  public static final j kFR;
  public static final j kFS;
  public static final j kFT;
  public int errCode;
  public String errMsg;
  public final Object kFU;
  
  static
  {
    AppMethodBeat.i(144596);
    kFA = new j(0, "");
    kFB = new j(-1, "fail:internal error");
    kFC = new j(10000, "fail:not init");
    kFD = new j(10001, "fail:not available");
    kFE = new j(10002, "fail:no device");
    kFF = new j(10003, "fail:connection fail");
    kFG = new j(10004, "fail:no service");
    kFH = new j(10005, "fail:no characteristic");
    kFI = new j(10006, "fail:no connection");
    kFJ = new j(10007, "fail:property not support");
    kFK = new j(10008, "fail:system error");
    kFL = new j(10009, "fail:system not support");
    kFM = new j(10008, "fail:no descriptor");
    kFN = new j(10008, "fail:fail to set descriptor");
    kFO = new j(10008, "fail:fail to write descriptor");
    kFP = new j(10012, "fail:operate time out");
    kFQ = new j(-1, "fail:already connect");
    kFR = new j(10013, "fail:invalid data");
    kFS = new j(10008, "fail:not found service");
    kFT = new j(10014, "fail:need pin");
    AppMethodBeat.o(144596);
  }
  
  public j(int paramInt, String paramString)
  {
    this.errCode = paramInt;
    this.errMsg = paramString;
    this.kFU = null;
  }
  
  private j(String paramString, Object paramObject)
  {
    this.errCode = 0;
    this.errMsg = paramString;
    this.kFU = paramObject;
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
    String str = "Result{errCode=" + this.errCode + ", errMsg='" + this.errMsg + '\'' + ", retObj=" + this.kFU + '}';
    AppMethodBeat.o(144595);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j
 * JD-Core Version:    0.7.0.1
 */