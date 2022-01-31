package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.n;

public enum r$a
  implements com.tencent.mm.plugin.appbrand.appstorage.a.a
{
  private r$a() {}
  
  public final int rE(String paramString)
  {
    paramString = com.tencent.mm.plugin.appbrand.a.qn(paramString);
    if ((paramString == null) || (paramString.aac() == null)) {
      return 0;
    }
    return paramString.aac().uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.r.a
 * JD-Core Version:    0.7.0.1
 */