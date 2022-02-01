package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;

public final class k
{
  public static final k rNA;
  public static final k rNB;
  public static final k rNC;
  public static final k rND;
  public static final k rNE;
  public static final k rNF;
  public static final k rNG;
  public static final k rNH;
  public static final k rNI;
  public static final k rNJ;
  public static final k rNK;
  public static final k rNL;
  public static final k rNM;
  public static final k rNN;
  public static final k rNO;
  public static final k rNP;
  public static final k rNQ;
  public static final k rNR;
  public static final k rNS;
  public static final k rNT;
  public static final k rNU;
  public static final k rNz;
  @Deprecated
  public int errCode;
  public String errMsg;
  public final a.d rKn;
  public final Object rNV;
  
  static
  {
    AppMethodBeat.i(144596);
    rNz = new k(0, "", a.e.rVt);
    rNA = new k(-1, "fail:internal error", a.c.rVf);
    rNB = new k(-1, "fail:internal error", a.c.rUH);
    rNC = new k(10000, "fail:not init", a.c.rUE);
    rND = new k(10001, "fail:not available", a.c.rUF);
    rNE = new k(10004, "fail:no service", a.c.rUG);
    rNF = new k(10005, "fail:no characteristic", a.c.rVh);
    rNG = new k(10006, "fail:no connection", a.c.rVi);
    rNH = new k(10007, "fail:property not support", a.c.rVj);
    rNI = new k(10008, "fail:system error", a.c.rUH);
    rNJ = new k(10009, "fail:system not support", a.c.rUI);
    rNK = new k(10008, "fail:no descriptor", a.c.rUH);
    rNL = new k(10008, "fail:fail to set descriptor", a.c.rUH);
    rNM = new k(10008, "fail:fail to write descriptor", a.c.rUH);
    rNN = new k(10012, "fail:operate time out", a.c.rVk);
    rNO = new k(-1, "fail:already connect", a.c.rVm);
    rNP = new k(10013, "fail:invalid data", a.e.rVz);
    rNQ = new k(10008, "fail:not found service", a.c.rUH);
    rNR = new k(10014, "fail:need pin", a.c.rVq);
    rNS = new k(a.c.rVn);
    rNT = new k(a.c.rVo);
    rNU = new k(10007, "fail:The writeType is not supported", a.c.rVj);
    AppMethodBeat.o(144596);
  }
  
  public k(int paramInt, String paramString, a.d paramd)
  {
    this(paramInt, paramString, paramd, null);
  }
  
  private k(int paramInt, String paramString, a.d paramd, Object paramObject)
  {
    this.errCode = paramInt;
    this.errMsg = paramString;
    this.rKn = paramd;
    this.rNV = paramObject;
  }
  
  private k(a.d paramd)
  {
    this(-1, paramd.errMsg, paramd, null);
  }
  
  public static k ea(Object paramObject)
  {
    AppMethodBeat.i(175631);
    paramObject = new k(0, "", a.e.rVt, paramObject);
    AppMethodBeat.o(175631);
    return paramObject;
  }
  
  public static k eb(Object paramObject)
  {
    AppMethodBeat.i(329695);
    paramObject = new k(-1, "fail:internal error", a.c.rUH, paramObject);
    AppMethodBeat.o(329695);
    return paramObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144595);
    String str = "Result{errCode=" + this.errCode + ", errMsg='" + this.errMsg + '\'' + ", retObj=" + this.rNV + '}';
    AppMethodBeat.o(144595);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.k
 * JD-Core Version:    0.7.0.1
 */