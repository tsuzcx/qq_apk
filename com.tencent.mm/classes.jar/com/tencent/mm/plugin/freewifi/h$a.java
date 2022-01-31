package com.tencent.mm.plugin.freewifi;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum h$a
{
  String key;
  String mIv;
  
  static
  {
    AppMethodBeat.i(20581);
    mIp = new a("version", 0, "version", "2");
    mIq = new a("httpConnectTimeoutMillis", 1, "httpConnectTimeoutMillis", "5000");
    mIr = new a("httpReadTimeoutMillis", 2, "httpReadTimeoutMillis", "5000");
    mIs = new a("pingEnabled", 3, "pingEnabled", "1");
    mIt = new a("pingUrl", 4, "pingUrl", "http://o2o.gtimg.com/wifi/echo");
    mIu = new a("threeTwoBlackUrl", 5, "threeTwoBlackUrl", "http://o2o.gtimg.com/wifi/echo.html");
    mIw = new a[] { mIp, mIq, mIr, mIs, mIt, mIu };
    AppMethodBeat.o(20581);
  }
  
  private h$a(String paramString1, String paramString2)
  {
    this.key = paramString1;
    this.mIv = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.h.a
 * JD-Core Version:    0.7.0.1
 */