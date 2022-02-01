package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum f
{
  int errCode;
  String errMsg;
  
  static
  {
    AppMethodBeat.i(46297);
    kPy = new f("OK", 0, 0, "ok");
    kPz = new f("SYSTEM_ERROR", 1, -1, "fail system error");
    kPA = new f("CGI_ERROR", 2, -2, "fail CGI error");
    kPB = new f("CANCEL", 3, -3, "fail cancel");
    kPC = new f("INVALID_BUSINESS_TYPE", 4, -4, "fail invalid businessType");
    kPD = new f[] { kPy, kPz, kPA, kPB, kPC };
    AppMethodBeat.o(46297);
  }
  
  private f(int paramInt, String paramString)
  {
    this.errCode = paramInt;
    this.errMsg = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.f
 * JD-Core Version:    0.7.0.1
 */