package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.sdk.platformtools.bk;

public final class j
{
  public static boolean sm(String paramString)
  {
    if (bk.bl(paramString)) {}
    do
    {
      return false;
      paramString = a.qo(paramString);
    } while ((paramString == null) || (paramString.fPx) || (paramString.fPS.fEM == 0));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.j
 * JD-Core Version:    0.7.0.1
 */