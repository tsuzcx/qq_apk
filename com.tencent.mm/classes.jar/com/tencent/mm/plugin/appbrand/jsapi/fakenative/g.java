package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g
{
  int errCode;
  String errMsg;
  
  static
  {
    AppMethodBeat.i(46297);
    jQa = new g("OK", 0, 0, "ok");
    jQb = new g("SYSTEM_ERROR", 1, -1, "fail system error");
    jQc = new g("CGI_ERROR", 2, -2, "fail CGI error");
    jQd = new g("CANCEL", 3, -3, "fail cancel");
    jQe = new g("INVALID_BUSINESS_TYPE", 4, -4, "fail invalid businessType");
    jQf = new g[] { jQa, jQb, jQc, jQd, jQe };
    AppMethodBeat.o(46297);
  }
  
  private g(int paramInt, String paramString)
  {
    this.errCode = paramInt;
    this.errMsg = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.g
 * JD-Core Version:    0.7.0.1
 */