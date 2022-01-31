package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class WxaExposedParams$a
{
  public String appId = "";
  public int from = 0;
  public int gXe = -1;
  public int gXf = -1;
  public String hko = "";
  public String hkp = "";
  public String iconUrl = "";
  public String nickname = "";
  public String pageId = "";
  public String username = "";
  
  public final a AG(String paramString)
  {
    this.appId = paramString;
    return this;
  }
  
  public final a AH(String paramString)
  {
    this.username = paramString;
    return this;
  }
  
  public final a AI(String paramString)
  {
    this.nickname = paramString;
    return this;
  }
  
  public final a AJ(String paramString)
  {
    this.iconUrl = paramString;
    return this;
  }
  
  public final a AK(String paramString)
  {
    this.pageId = paramString;
    return this;
  }
  
  public final WxaExposedParams ayJ()
  {
    AppMethodBeat.i(114914);
    WxaExposedParams localWxaExposedParams = new WxaExposedParams(this, (byte)0);
    AppMethodBeat.o(114914);
    return localWxaExposedParams;
  }
  
  public final a nz(int paramInt)
  {
    this.from = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a
 * JD-Core Version:    0.7.0.1
 */