package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.rtmp.TXLiveBase;

public final class k
{
  private static boolean gsu;
  
  public static void ajd()
  {
    if (gsu) {
      return;
    }
    TXLiveBase.setLogLevel(1);
    TXLiveBase.setConsoleEnabled(false);
    TXLiveBase.setListener(new k.1());
    gsu = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.k
 * JD-Core Version:    0.7.0.1
 */