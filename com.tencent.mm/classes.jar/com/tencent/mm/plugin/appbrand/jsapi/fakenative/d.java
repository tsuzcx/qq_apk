package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum d
{
  int errCode;
  String errMsg;
  
  static
  {
    AppMethodBeat.i(131042);
    hLF = new d("OK", 0, 0, "ok");
    hLG = new d("SYSTEM_ERROR", 1, -1, "fail system error");
    hLH = new d("CGI_ERROR", 2, -2, "fail CGI error");
    hLI = new d("CANCEL", 3, -3, "fail cancel");
    hLJ = new d("INVALID_BUSINESS_TYPE", 4, -4, "fail invalid businessType");
    hLK = new d[] { hLF, hLG, hLH, hLI, hLJ };
    AppMethodBeat.o(131042);
  }
  
  private d(int paramInt, String paramString)
  {
    this.errCode = paramInt;
    this.errMsg = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.d
 * JD-Core Version:    0.7.0.1
 */